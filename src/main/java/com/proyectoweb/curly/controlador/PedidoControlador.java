package com.proyectoweb.curly.controlador;

import com.proyectoweb.curly.modelo.*;
import com.proyectoweb.curly.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    @Autowired
    private CarritoServicio carritoServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private LineaServicio lineaServicio;

    @Autowired
    private DireccionServicio direccionServicio;


    @GetMapping("/pedidos")
    public String listarPedido(Model modelo) {
        modelo.addAttribute("pedidos", pedidoServicio.listarPedidos());
        return "pedido";
    }

    @GetMapping("/pedidos/{id}/aprobar")
    public String verificarPedido(@PathVariable Integer id, Model modelo){
        modelo.addAttribute("pedido", pedidoServicio.obtenerPedidoPorId(id));

        return "pedido_aprobar_formulario";
    }

    @PostMapping("/pedidos/{id}/aprobar/{idcar}")
    public String aprobarPedido(@PathVariable Integer id, @PathVariable Integer idcar,
                                @ModelAttribute Pedido pedido,  @ModelAttribute LineaPedido lineaPedido, Model modelo){

        Pedido pedidoExistente = pedidoServicio.obtenerPedidoPorId(id);
        pedidoExistente.setId_ped(id);
        pedidoExistente.setVerificacion(pedido.getVerificacion());
        pedidoExistente.setEstado(pedido.getEstado());

        pedidoServicio.actualizaPedido(pedidoExistente);

        //Actualizar inventario de productos.

        if (pedidoExistente.getVerificacion().equals("Aprobado")) {

            Carrito carrito = carritoServicio.obtenerCarritoPorId(idcar);
            List<LineaPedido> lineas = lineaServicio.obtenerLineasPorIdCarrito(carrito.getId_car());

            for (LineaPedido linea : lineas) {
                Producto producto = productoServicio.obtenerProductosPorId(linea.getProducto().getId_producto());
                producto.setCantidad(producto.getCantidad() - linea.getCantidad());
                productoServicio.actualizarProductos(producto);
            }

        }
        modelo.addAttribute("mensaje", "El inventario de productos se ha actualizado exitosamente");


        return "redirect:/pedidos";
    }





}
