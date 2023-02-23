package com.proyectoweb.curly.controlador;

import com.proyectoweb.curly.modelo.*;
import com.proyectoweb.curly.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CarritoControlador {

    @Autowired
    private CarritoServicio servicio;
    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired

    private ProductoServicio productoServicio;
    @Autowired
    private LineaServicio lineaServicio;

    @Autowired
    private PedidoServicio pedidoServicio;


    @GetMapping("/carritos")
    public String listarCarritos(Model modelo) {
        modelo.addAttribute("carritos", servicio.listarCarritos());
        return "carrito";
    }
    @GetMapping("/carritos/nuevo")
    public String mostrarFormularioCarritos(Model modelo) {
        Carrito carrito = new Carrito();
        modelo.addAttribute("carrito", carrito);

        List<Cliente> clientes = clienteServicio.listarClientes();
        modelo.addAttribute("clientes", clientes);


        return "carrito_formulario";
    }
    @PostMapping("/carritos")
    public String guardarCarritos(@ModelAttribute("carrito") Carrito carrito) {
        Cliente cliente = clienteServicio.obtenerClientePorId(carrito.getCliente().getId_cli());
        carrito.setCliente(cliente);

        servicio.guardarCarrito(carrito);
        return "redirect:/carritos";
    }

    //VER LAS LINEAS DE LOS PRODUCTOS
    @GetMapping("/carritos/{id}/agregarcarrito")
    public String mostrarProductosCarrito(@PathVariable Integer id, Model modelo) {
        Carrito carrito = servicio.obtenerCarritoPorId(id);
        modelo.addAttribute("carrito", carrito);
        modelo.addAttribute("cliente", clienteServicio.obtenerClientePorId(id));

        List<Producto> productos = productoServicio.listarProductos();
        LineaPedido lineaPedido = new LineaPedido();
        lineaPedido.setCarrito(carrito);
        modelo.addAttribute("lineapedido", lineaPedido);
        modelo.addAttribute("productos", productos);

        //Mostrar el objeto de cada linea de pedido
        List<LineaPedido> lineapedidos = lineaServicio.obtenerLineasPorIdCarrito(carrito.getId_car());
        modelo.addAttribute("lineapedidos",lineapedidos);
        ;

        //CONTAR LINEAS
        int count = 1;
        for (LineaPedido linea : lineapedidos) {
            modelo.addAttribute("count", count);
            count++;
            // lógica de la iteración
        }

        //SUMAR EL SUBTOTAL DE LOS PRODUCTOS
        double total = 0.0;
        for (LineaPedido linea : lineapedidos) {
            total += linea.getCantidad() * linea.getProducto().getPrecio();
        }
        modelo.addAttribute("total", total);

        return "lineapedido";
    }



    @PostMapping("/carritos/{id}/agregarlineaproducto")
    public String guardarLineaProducto(@PathVariable Integer id, @ModelAttribute LineaPedido lineaPedido) {
        Carrito carrito = servicio.obtenerCarritoPorId(id);
        Producto producto = productoServicio.obtenerProductosPorId(lineaPedido.getProducto().getId_producto());
        LineaPedido linea = new LineaPedido(carrito, producto, lineaPedido.getCantidad());
        lineaServicio.guardarLinea(linea);

        return "redirect:/carritos/{id}/agregarcarrito";
    }

    //ELIMINAR UNA LINEA DE PEDIDO

    @GetMapping("/carritos/{id}/eliminarlineapedido/{lineaId}")
    public String eliminarLineaPedido(@PathVariable Integer id, @PathVariable Integer lineaId) {
        lineaServicio.eliminarLinea(lineaId);
        return "redirect:/carritos/{id}/agregarcarrito";
    }

    //Eliminar un carrito
    @GetMapping("/carritos/{id}")
    public String eliminaCarritos(@PathVariable Integer id) {
        servicio.eliminarCarrito(id);
        return "redirect:/carritos";
    }

    //REALIZAR PEDIDO
    @GetMapping("/carritos/{id}/agregarcarrito/pedido")
    public String mostrarFormularioPedido(@PathVariable Integer id, @RequestParam Double total, Model modelo){
        Pedido pedido = new Pedido();
        modelo.addAttribute("pedido",pedido);

        Carrito carrito = servicio.obtenerCarritoPorId(id);
        modelo.addAttribute("carrito", carrito);
        modelo.addAttribute("total", total);

        LocalDate fechaActual = LocalDate.now();
        modelo.addAttribute("fecha", fechaActual);
        return "pedido_formulario";
    }

    @PostMapping("/carritos/{id}/agregarcarrito/pedido")
    public String crearNuevoPedido(@PathVariable Integer id, @ModelAttribute Pedido pedido,
                                   @RequestParam Double total, @RequestParam String comprobante, Model modelo){

        // Obtener el carrito correspondiente al id recibido
        Carrito carrito = servicio.obtenerCarritoPorId(id);

        // Asignar valores al objeto Pedido
        pedido.setCarrito(carrito);
        pedido.setTotal(total);
        pedido.setComprobante(comprobante);
        pedido.setVerificacion("Pendiente");
        pedido.setEstado("Sin entregar");
        pedido.setFecha(LocalDate.now());


        pedidoServicio.guardarPedido(pedido);


        return "redirect:/carritos";
    }





}
