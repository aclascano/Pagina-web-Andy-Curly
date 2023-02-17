package com.proyectoweb.curly.repositorio;

import com.proyectoweb.curly.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository <Proveedor,Integer> {

}
