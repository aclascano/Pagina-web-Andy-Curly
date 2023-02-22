package com.proyectoweb.curly.repositorio;

import com.proyectoweb.curly.modelo.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepositorio extends JpaRepository<Direccion, Integer> {
    @Query(value = "SELECT * FROM direccion d INNER JOIN cliente_direccion cd ON d.id_dir = cd.direccion_id WHERE cd.cliente_id = :idCliente", nativeQuery = true)
    List<Direccion> findByClientesId(Integer idCliente);
}
