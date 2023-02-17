package com.proyectoweb.curly.modelo;

import javax.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pro;
    private String nombre_pro;
    private String telefono_pro;
    private String correo_pro;

    public Proveedor(Integer id_pro, String nombre_pro, String telefono_pro, String correo_pro) {
        this.id_pro = id_pro;
        this.nombre_pro = nombre_pro;
        this.telefono_pro = telefono_pro;
        this.correo_pro = correo_pro;
    }

    public Proveedor( String nombre_pro, String telefono_pro, String correo_pro) {
        this.nombre_pro = nombre_pro;
        this.telefono_pro = telefono_pro;
        this.correo_pro = correo_pro;
    }
    public Proveedor() {

    }

    public Integer getId_pro() {
        return id_pro;
    }

    public void setId_pro(Integer id_pro) {
        this.id_pro = id_pro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public String getTelefono_pro() {
        return telefono_pro;
    }

    public void setTelefono_pro(String telefono_pro) {
        this.telefono_pro = telefono_pro;
    }

    public String getCorreo_pro() {
        return correo_pro;
    }

    public void setCorreo_pro(String correo_pro) {
        this.correo_pro = correo_pro;
    }
}
