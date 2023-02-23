package com.proyectoweb.curly.controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.proyectoweb.curly.modelo.*;
import com.proyectoweb.curly.servicio.*;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;;
import java.io.IOException;

import java.util.List;

@Controller
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;
    @Autowired
    private SpringTemplateEngine templateEngine;

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
    public ResponseEntity<byte[]> aprobarPedido(@PathVariable Integer id, @PathVariable Integer idcar,
                                                @ModelAttribute Pedido pedido, @ModelAttribute LineaPedido lineaPedido) throws IOException, DocumentException {

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
                System.out.println(producto.getCantidad());
                System.out.println(linea.getCantidad());
                System.out.println("resta" + (producto.getCantidad() - linea.getCantidad()));
                producto.setCantidad(producto.getCantidad() - linea.getCantidad());
                productoServicio.actualizarProductos(producto);
            }

            // Generar PDF
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Contenido del PDF
            String contenidoPdf = "Recibo\n\n";
            contenidoPdf += "Líneas del carrito:\n";
            contenidoPdf += "Cliente:"+pedidoExistente.getCarrito().getCliente().getNombre()+ "\n";
            contenidoPdf += ":\n";
            for (LineaPedido linea : lineas) {
                contenidoPdf += linea.getProducto().getNombre() + " x " + linea.getCantidad() + linea.getProducto().getPrecio()+"\n";
            }
            contenidoPdf += "Total:"+pedidoExistente.getTotal()+"\n";

            // Añadir contenido al PDF
            Paragraph paragraph = new Paragraph(contenidoPdf);
            document.add(paragraph);

            // Cerrar el documento y liberar recursos
            document.close();

            // Agregar el archivo PDF a la respuesta HTTP
            byte[] pdf = outputStream.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            headers.add("Content-Disposition", "attachment; filename=pedido.pdf");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(pdf.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(pdf);
        }

        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/pedidos/{id}/recibo")
    public ResponseEntity<?> generarRecibo(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pedido pedido = pedidoServicio.obtenerPedidoPorId(id);

        //Mostrar Direcciones
        Integer clienteId = pedido.getCarrito().getCliente().getId_cli();
        List<Direccion> direcciones = direccionServicio.listarDireccionesPorClienteId(clienteId);

        //Mostrar lineas del pedido
        Integer idcar = pedido.getCarrito().getId_car();
        Carrito carrito = carritoServicio.obtenerCarritoPorId(idcar);
        List<LineaPedido> lineapedidos = lineaServicio.obtenerLineasPorIdCarrito(carrito.getId_car());

        /* Create HTML using Thymeleaf template Engine */

            ServletContext servletContext = request.getServletContext();
            WebContext context = new WebContext(request, response, servletContext);
            context.setVariable("pedido", pedido);
            context.setVariable("direcciones", direcciones);
            context.setVariable("lineapedidos", lineapedidos);
            String html = templateEngine.process("reciboPDF", context);

            /* Setup Source and target I/O streams */

            ByteArrayOutputStream target = new ByteArrayOutputStream();

            /*Setup converter properties. */
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setBaseUri("http://localhost:8080");

            /* Call convert method */
            HtmlConverter.convertToPdf(html, target, converterProperties);

            /* extract output as bytes */
            byte[] bytes = target.toByteArray();


            /* Send the response as downloadable PDF */

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(bytes);
    }




}
