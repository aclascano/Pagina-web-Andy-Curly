package com.proyectoweb.curly.controlador;

import com.google.gson.Gson;
import com.proyectoweb.curly.modelo.Cliente;
import com.proyectoweb.curly.modelo.Producto;
import com.proyectoweb.curly.modelo.Proveedor;
import com.proyectoweb.curly.modelo.Usuario;
import com.proyectoweb.curly.servicio.ClienteServicio;
import com.proyectoweb.curly.servicio.ProductoServicio;
import com.proyectoweb.curly.servicio.ProveedorServicio;
import com.proyectoweb.curly.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexControlador {

	@Autowired
	private UsuarioServicio servicio;
	@Autowired
	private ProductoServicio servicioProducto;
	@Autowired
	private ProveedorServicio servicioProveedor;

	@Autowired
	private ClienteServicio servicioCliente;


	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	@GetMapping("/usuarios")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());

		return "usuarios";
	}
	@GetMapping("/usuarios/editar/{id}")
	public String editarUsuarios(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("usuario", servicio.obtenerUsuarioPorId(id));
		return "usuario_formulario";
	}

	@PostMapping("/usuarios/{id}")
	public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario,
									Model modelo) {
		Usuario usuarioExistente = servicio.obtenerUsuarioPorId(id);
		usuarioExistente.setId(id);
		usuarioExistente.setNombre(usuario.getNombre());
		usuarioExistente.setEmail(usuario.getEmail());

		servicio.actualizarUsuario(usuarioExistente);
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		servicio.eliminar(id);
		return "redirect:/usuarios";
	}

	//Dashboarddd GOOOOD
	@GetMapping("/")
	public String index(Model model) {
		List<Usuario> usuarios = servicio.listarUsuarios();
		List<Proveedor> proveedor = servicioProveedor.listarProveedor();
		List<Producto> producto = servicioProducto.listarProductos();
		List<Cliente> cliente = servicioCliente.listarClientes();

		List<String> nombresProductos = servicioProducto.listarNombresProductos();
		List<Integer> cantidadesProductos = servicioProducto.listarCantidadProductos();

		int numeroUsuarios = usuarios.size();
		int numeroProveedores = proveedor.size();
		int numeroProductos = producto.size();
		int numeroClientes = cliente.size();

		//TARJETAS
		model.addAttribute("numeroUsuarios", numeroUsuarios);
		model.addAttribute("numeroProveedores", numeroProveedores);
		model.addAttribute("numeroProductos", numeroProductos);
		model.addAttribute("numeroClientes", numeroClientes);
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
