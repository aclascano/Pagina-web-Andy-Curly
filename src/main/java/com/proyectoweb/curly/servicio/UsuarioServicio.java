package com.proyectoweb.curly.servicio;

import java.util.List;

import com.proyectoweb.curly.excepcions.UsuarioNoEncontradoException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.proyectoweb.curly.controlador.dto.UsuarioRegistroDTO;
import com.proyectoweb.curly.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);

	Usuario actualizar(Long id, UsuarioRegistroDTO registroDTO) throws UsuarioNoEncontradoException;

	void eliminar(Long id) throws UsuarioNoEncontradoException;

	public List<Usuario> listarUsuarios();
	Usuario buscarPorId(Long id);
	public Long contarUsuarios();


}
