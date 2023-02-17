package com.proyectoweb.curly.excepcions;

public class UsuarioNoEncontradoException extends RuntimeException{
    public UsuarioNoEncontradoException(String message) {
        super(message);
    }
}
