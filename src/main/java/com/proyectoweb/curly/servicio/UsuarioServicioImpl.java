package com.proyectoweb.curly.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.proyectoweb.curly.excepcions.UsuarioNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectoweb.curly.controlador.dto.UsuarioRegistroDTO;
import com.proyectoweb.curly.modelo.Rol;
import com.proyectoweb.curly.modelo.Usuario;
import com.proyectoweb.curly.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), 
				registroDTO.getApellido(),registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("CLIENTE")));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	@Override
	public Usuario actualizar(Long id, UsuarioRegistroDTO registroDTO) throws UsuarioNoEncontradoException {
		Optional<Usuario> usuarioOpt = usuarioRepositorio.findById(id);
		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			usuario.setNombre(registroDTO.getNombre());
			usuario.setApellido(registroDTO.getApellido());
			usuario.setEmail(registroDTO.getEmail());
			usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
			return usuarioRepositorio.save(usuario);
		} else {
			throw new UsuarioNoEncontradoException("Usuario no encontrado");
		}
	}

	@Override
	public void eliminar(Long id) throws UsuarioNoEncontradoException {
		Optional<Usuario> usuarioOpt = usuarioRepositorio.findById(id);
		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			usuarioRepositorio.delete(usuario);
		} else {
			throw new UsuarioNoEncontradoException("Usuario no encontrado");
		}
	}


	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioRepositorio.findById(id)
				.orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado"));
	}

	@Override
	public Long contarUsuarios() {
		return usuarioRepositorio.count();
	}

}
