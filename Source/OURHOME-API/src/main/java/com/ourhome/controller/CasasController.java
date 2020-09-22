package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.Casas;
import com.ourhome.service.CasasServiceImpl;

@RestController
@RequestMapping("/api")
public class CasasController {

	@Autowired
	CasasServiceImpl casasServiceImpl;
	
	
	@GetMapping("/casas")
	public List<Casas> listarCasas(){
		return casasServiceImpl.listarCasas();
	}

	
	@PostMapping("/casas")
	public Casas guardarCasa(@RequestBody Casas casa) {
		return casasServiceImpl.guardarCasa(casa);
	}
	
	
	@GetMapping("/casas/{id}")
	public Casas buscarCasa(@PathVariable(name="id") int id) {
		Casas casa = new Casas();		
		casa = casasServiceImpl.buscarCasa(id);
		
		return casa;
	}
	

	@PutMapping("/casas/{id}")
	public Casas actualizarCasa(@PathVariable(name="id") int id, @RequestBody Casas casa) {
		Casas casaSeleccionada = new Casas();
		Casas casaActualizada = new Casas();
		
		casaSeleccionada = casasServiceImpl.buscarCasa(id);
		
		casaSeleccionada.setUsuarios(casa.getUsuarios());
		casaSeleccionada.setDescripcion(casa.getDescripcion());
		casaSeleccionada.setPrecio(casa.getPrecio());
		casaSeleccionada.setNumero_habitaciones(casa.getNumero_habitaciones());
		casaSeleccionada.setNumero_baños(casa.getNumero_baños());
		casaSeleccionada.setDireccion(casa.getDireccion());
		casaSeleccionada.setMetros(casa.getMetros());
		casaSeleccionada.setPlantas(casa.getPlantas());
		casaSeleccionada.setExtras(casa.getExtras());
		casaSeleccionada.setFecha_creacion(casa.getFecha_creacion());
		casaSeleccionada.setFecha_actualizacion(casa.getFecha_actualizacion());		
		
		return casaActualizada;
		
	}
	
	
	@DeleteMapping("/casas/{id}")
	public void eliminarCasa(@PathVariable(name="id") int id) {
		casasServiceImpl.eliminarCasa(id);
	}
	
}
