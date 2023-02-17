package com.proyectoweb.curly.controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.proyectoweb.curly.controlador.dto.UsuarioRegistroDTO;
import com.proyectoweb.curly.excepcions.UsuarioNoEncontradoException;
import com.proyectoweb.curly.modelo.Categoria;
import com.proyectoweb.curly.modelo.Producto;
import com.proyectoweb.curly.modelo.Proveedor;
import com.proyectoweb.curly.modelo.Usuario;
import com.proyectoweb.curly.servicio.ProductoServicio;
import com.proyectoweb.curly.servicio.ProveedorServicio;
import com.proyectoweb.curly.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	@Autowired
	private ProductoServicio servicioProducto;
	@Autowired
	private ProveedorServicio servicioProveedor;
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	@GetMapping("/usuarios")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());

		return "usuarios";
	}
	@GetMapping("/usuarios/nuevo")
	public String mostrarFormularioCategorias(Model modelo) {
		modelo.addAttribute("categoria", new Usuario());
		return "usuario-formulario";
	}
	@GetMapping("/usuarios/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) throws UsuarioNoEncontradoException {
		Usuario usuario = servicio.buscarPorId(id);
		modelo.addAttribute("usuario", usuario);
		return "usuario-formulario";
	}

	@PostMapping("/usuarios/editar/{id}")
	public String procesarFormularioEditar(@PathVariable Long id, UsuarioRegistroDTO registroDTO) throws UsuarioNoEncontradoException {
		servicio.actualizar(id, registroDTO);
		return "redirect:/usuarios";
	}

	@PostMapping("/usuarios/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id) throws UsuarioNoEncontradoException {
		servicio.eliminar(id);
		return "redirect:/usuarios";
	}

	//Dashboarddd GOOOOD
	@GetMapping("/")
	public String index(Model model) {
		List<Usuario> usuarios = servicio.listarUsuarios();
		List<Proveedor> proveedor = servicioProveedor.listarProveedor();
		List<Producto> producto = servicioProducto.listarProductos();

		List<String> nombresProductos = servicioProducto.listarNombresProductos();
		List<Integer> cantidadesProductos = servicioProducto.listarCantidadProductos();

		int numeroUsuarios = usuarios.size();
		int numeroProveedores = proveedor.size();
		int numeroProductos = producto.size();

		//TARJETAS
		model.addAttribute("numeroUsuarios", numeroUsuarios);
		model.addAttribute("numeroProveedores", numeroProveedores);
		model.addAttribute("numeroProductos", numeroProductos);
		model.addAttribute("nombresProductos", nombresProductos);
		model.addAttribute("cantidadesProductos", cantidadesProductos);

		//GRAFICA

		Gson gson = new Gson();
		String nombresProductosJson = gson.toJson(nombresProductos);
		String cantidadesProductosJson = gson.toJson(cantidadesProductos);
		model.addAttribute("nombresProductosJson", nombresProductosJson);
		model.addAttribute("cantidadesProductosJson", cantidadesProductosJson);

		System.out.println(nombresProductosJson);
		System.out.println(cantidadesProductosJson);



		return "index";

	}

}
