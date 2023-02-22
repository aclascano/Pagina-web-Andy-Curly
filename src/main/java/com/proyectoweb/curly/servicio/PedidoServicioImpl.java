package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Carrito;
import com.proyectoweb.curly.modelo.Pedido;
import com.proyectoweb.curly.repositorio.CarritoRepositorio;
import com.proyectoweb.curly.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicioImpl implements PedidoServicio{
    @Autowired
    private PedidoRepositorio repositorio;

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = repositorio.findAll();
        for (Pedido p : pedidos){
            p.getCarrito().getId_car();
            p.getCarrito().getCliente().getId_cli();
            p.getCarrito().getCliente().getNombre();

        }
        return pedidos;
    }

    @Override
    public Pedido guardarPedido(Pedido carrito) {
        return repositorio.save(carrito);
    }

    @Override
    public Pedido obtenerPedidoPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Pedido actualizaPedido(Pedido pedido) {
        return repositorio.save(pedido);
    }

    @Override
    public void eliminarPedido(Integer id) {
        repositorio.deleteById(id);

    }
}
