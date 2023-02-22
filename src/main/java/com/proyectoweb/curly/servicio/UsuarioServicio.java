package com.proyectoweb.curly.servicio;

import java.util.List;

import com.proyectoweb.curly.excepcions.UsuarioNoEncontradoException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.proyectoweb.curly.controlador.dto.UsuarioRegistroDTO;
import com.proyectoweb.curly.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public List<Usuario> listarUsuarios();
	public Usuario guardar(UsuarioRegistroDTO registroDTO);

	Usuario obtenerUsuarioPorId(Long id);
	public Usuario actualizarUsuario(Usuario usuario);

	public void eliminar(Long id) ;


	public Long contarUsuarios();


}
