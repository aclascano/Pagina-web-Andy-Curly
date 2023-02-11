package com.proyectoweb.curly.modelo;

public class Direccion {

    private int id_dir;
    private String provincia_dir;
    private String ciudad_dir;
    private String calleprincipal_dir;
    private String callesecundaria_dir;
    private String referencia_dir;
    private String numcasa_dir;
    private String codigopostal_dir;

    public Direccion(int id_dir, String provincia_dir, String ciudad_dir, String calleprincipal_dir,
                     String callesecundaria_dir, String referencia_dir, String numcasa_dir, String codigopostal_dir) {
        this.id_dir = id_dir;
        this.provincia_dir = provincia_dir;
        this.ciudad_dir = ciudad_dir;
        this.calleprincipal_dir = calleprincipal_dir;
        this.callesecundaria_dir = callesecundaria_dir;
        this.referencia_dir = referencia_dir;
        this.numcasa_dir = numcasa_dir;
        this.codigopostal_dir = codigopostal_dir;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }

    public String getProvincia_dir() {
        return provincia_dir;
    }

    public void setProvincia_dir(String provincia_dir) {
        this.provincia_dir = provincia_dir;
    }

    public String getCiudad_dir() {
        return ciudad_dir;
    }

    public void setCiudad_dir(String ciudad_dir) {
        this.ciudad_dir = ciudad_dir;
    }

    public String getCalleprincipal_dir() {
        return calleprincipal_dir;
    }

    public void setCalleprincipal_dir(String calleprincipal_dir) {
        this.calleprincipal_dir = calleprincipal_dir;
    }

    public String getCallesecundaria_dir() {
        return callesecundaria_dir;
    }

    public void setCallesecundaria_dir(String callesecundaria_dir) {
        this.callesecundaria_dir = callesecundaria_dir;
    }

    public String getReferencia_dir() {
        return referencia_dir;
    }

    public void setReferencia_dir(String referencia_dir) {
        this.referencia_dir = referencia_dir;
    }

    public String getNumcasa_dir() {
        return numcasa_dir;
    }

    public void setNumcasa_dir(String numcasa_dir) {
        this.numcasa_dir = numcasa_dir;
    }

    public String getCodigopostal_dir() {
        return codigopostal_dir;
    }

    public void setCodigopostal_dir(String codigopostal_dir) {
        this.codigopostal_dir = codigopostal_dir;
    }
}
