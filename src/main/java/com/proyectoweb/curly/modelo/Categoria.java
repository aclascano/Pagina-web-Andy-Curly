package com.proyectoweb.curly.modelo;

public class Categoria {

    private int id_cat;
    private String nombre;

    public Categoria(int id_cat, String nombre) {
        this.id_cat = id_cat;
        this.nombre = nombre;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
