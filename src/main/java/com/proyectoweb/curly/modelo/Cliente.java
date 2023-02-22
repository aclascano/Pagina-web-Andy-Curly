package com.proyectoweb.curly.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cli;
    @ManyToOne
    @JoinColumn(name= "id")
    private Usuario usuario;
    private String nombre;
    private String identificacion;
    private String telefono;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_direccion",
            joinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id_cli"),
            inverseJoinColumns = @JoinColumn(name = "direccion_id", referencedColumnName = "id_dir")
    )
    private Collection<Direccion> direccion;

    public Cliente(Integer id_cli, Usuario usuario, String nombre, String identificacion, String telefono, Collection<Direccion> direccion) {
        this.id_cli = id_cli;
        this.usuario = usuario;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Cliente(Usuario usuario, String nombre, String identificacion, String telefono, Collection<Direccion> direccion) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Cliente(Usuario usuario, String nombre, String identificacion, String telefono) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;

    }
    public Cliente() {

    }

    public Integer getId_cli() {
        return id_cli;
    }

    public void setId_cli(Integer id_cli) {
        this.id_cli = id_cli;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(Collection<Direccion> direccion) {
        this.direccion = direccion;
    }
}
