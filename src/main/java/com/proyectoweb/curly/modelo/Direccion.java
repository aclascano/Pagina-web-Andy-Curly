package com.proyectoweb.curly.modelo;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dir;
    private String provincia;
    private String ciudad;
    private String calleprincipal;
    private String callesecundaria;
    private String referencia;
    private String numcasa;
    private String codigopostal;

    public Direccion(Integer id_dir, String provincia, String ciudad, String calleprincipal, String callesecundaria, String referencia, String numcasa, String codigopostal) {
        super();
        this.id_dir = id_dir;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.calleprincipal = calleprincipal;
        this.callesecundaria = callesecundaria;
        this.referencia = referencia;
        this.numcasa = numcasa;
        this.codigopostal = codigopostal;
    }

    public Direccion(String provincia, String ciudad, String calleprincipal, String callesecundaria, String referencia, String numcasa, String codigopostal) {
        super();
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.calleprincipal = calleprincipal;
        this.callesecundaria = callesecundaria;
        this.referencia = referencia;
        this.numcasa = numcasa;
        this.codigopostal = codigopostal;
    }

    public Direccion() {
        super();
    }

    public Integer getId_dir() {
        return id_dir;
    }

    public void setId_dir(Integer id_dir) {
        this.id_dir = id_dir;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalleprincipal() {
        return calleprincipal;
    }

    public void setCalleprincipal(String calleprincipal) {
        this.calleprincipal = calleprincipal;
    }

    public String getCallesecundaria() {
        return callesecundaria;
    }

    public void setCallesecundaria(String callesecundaria) {
        this.callesecundaria = callesecundaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNumcasa() {
        return numcasa;
    }

    public void setNumcasa(String numcasa) {
        this.numcasa = numcasa;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }
}
