package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ourhome.dto.Usuarios;
import com.ourhome.service.UsuariosServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuariosController {

	@Autowired
	UsuariosServiceImpl usuariosServiceImpl;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuariosController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	@GetMapping("/usuarios")
	public List<Usuarios> listarUsuarios(){
		return usuariosServiceImpl.listarUsuarios();
	}

	
	@PostMapping("/usuarios")
	public Usuarios guardarUsuario(@RequestBody Usuarios usuario) {
		usuario.setContraseña(bCryptPasswordEncoder.encode(usuario.getContraseña()));
		return usuariosServiceImpl.guardarUsuario(usuario);
	}
	
	
	@GetMapping("/usuarios/{id}")
	public Usuarios buscarUsuario(@PathVariable(name="id") int id) {
		Usuarios usuario = new Usuarios();		
		usuario = usuariosServiceImpl.buscarUsuario(id);
		
		return usuario;
	}
	
	
	@PutMapping("/usuarios/{id}")
	public Usuarios actualizarUsuario(@PathVariable(name="id") int id, @RequestBody Usuarios usuario) {
		Usuarios usuarioSeleccionado = new Usuarios();
		Usuarios usuarioActualizado = new Usuarios();
		
		usuarioSeleccionado = usuariosServiceImpl.buscarUsuario(id);
		
		//usuarioSeleccionada.setId_usuarios(usuario.getId_usuarios());
		usuarioSeleccionado.setNombre(usuario.getNombre());
		usuarioSeleccionado.setApellidos(usuario.getApellidos());
		usuarioSeleccionado.setEdad(usuario.getEdad());
		usuarioSeleccionado.setTelefono(usuario.getTelefono());
		usuarioSeleccionado.setCorreo(usuario.getCorreo());
		usuarioSeleccionado.setContraseña(usuario.getContraseña());
		usuarioSeleccionado.setRol(usuario.getRol());
		usuarioSeleccionado.setRespuestas_test_defecto(usuario.getRespuestas_test_defecto());
		usuarioSeleccionado.setMostrar_telefono(usuario.isMostrar_telefono());		
		usuarioSeleccionado.setFecha_creacion(usuario.getFecha_creacion());
		usuarioSeleccionado.setFecha_actualizacion(usuario.getFecha_actualizacion());
		usuarioSeleccionado.setCasas(usuario.getCasas());
		usuarioSeleccionado.setProcesos_1(usuario.getProcesos_1());
		usuarioSeleccionado.setProcesos_2(usuario.getProcesos_2());
		usuarioSeleccionado.setTestPersonalizados(usuario.getTestPersonalizados());
		usuarioSeleccionado.setRespuestasTestsPersonalizados(usuario.getRespuestasTestsPersonalizados());
		
		return usuarioActualizado;	
	}
	
	
	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable(name="id") int id) {
		usuariosServiceImpl.eliminarUsuario(id);
	}
	
}
