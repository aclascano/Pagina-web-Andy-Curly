package com.proyectoweb.curly.servicio;
import com.proyectoweb.curly.modelo.Pedido;

import java.util.List;

public interface PedidoServicio {

    public List<Pedido> listarPedidos();

    public Pedido guardarPedido(Pedido pedido);

    public Pedido obtenerPedidoPorId(Integer id);

    public Pedido actualizaPedido(Pedido pedido);
    
    public void eliminarPedido(Integer id);
}
