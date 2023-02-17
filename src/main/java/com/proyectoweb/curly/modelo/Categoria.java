package com.proyectoweb.curly.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cat;

    @Column(name = "nombre", length = 45,nullable = false,unique = true)
    private String nombre;

    public Categoria(Integer id_cat, String nombre) {
        super();
        this.id_cat = id_cat;
        this.nombre = nombre;
    }

    public Categoria(Integer id_cat) {
        super();
        this.id_cat = id_cat;
    }

    public Categoria(String nombre) {
        super();
        this.nombre = nombre;
    }
    public Categoria() {

    }

    public Integer getId_cat() {
        return id_cat;
    }

    public void setId_cat(Integer id_cat) {
        this.id_cat = id_cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
