package com.proyectoweb.curly.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proyectoweb.curly.controlador.dto.UsuarioRegistroDTO;
import com.proyectoweb.curly.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
