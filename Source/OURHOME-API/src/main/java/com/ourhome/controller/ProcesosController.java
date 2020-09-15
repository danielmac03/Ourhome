package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.Procesos;
import com.ourhome.service.ProcesosServiceImpl;

@RestController
@RequestMapping("/api")
public class ProcesosController {

	@Autowired
	ProcesosServiceImpl procesosServiceImpl;
	
	
	@GetMapping("/procesos")
	public List<Procesos> listarProcesos(){
		return procesosServiceImpl.listarProcesos();
	}

	
	@PostMapping("/procesos")
	public Procesos guardarProceso(@RequestBody Procesos proceso) {
		return procesosServiceImpl.guardarProceso(proceso);
	}
	
	
	@GetMapping("/procesos/{id}")
	public Procesos buscarProceso(@PathVariable(name="id") int id) {
		Procesos proceso = new Procesos();		
		proceso = procesosServiceImpl.buscarProceso(id);
		
		return proceso;
	}
	
	
	@PutMapping("/procesos/{id}")
	public Procesos actualizarProceso(@PathVariable(name="id") int id, @RequestBody Procesos proceso) {
		Procesos procesoSeleccionado = new Procesos();
		Procesos procesoActualizado = new Procesos();
		
		procesoSeleccionado = procesosServiceImpl.buscarProceso(id);
		
		procesoSeleccionado.setId_proceso(proceso.getId_proceso());
		procesoSeleccionado.setId_usuario_1(proceso.getId_usuario_1());
		procesoSeleccionado.setId_usuario_2(proceso.getId_usuario_2());
		procesoSeleccionado.setEstado(proceso.getEstado());
		procesoSeleccionado.setFecha_creacion(proceso.getFecha_creacion());
		procesoSeleccionado.setFecha_actualizacion(proceso.getFecha_actualizacion());
		
		return procesoActualizado;
	}
	
	
	@DeleteMapping("/procesos/{id}")
	public void eliminarProceso(@PathVariable(name="id") int id) {
		procesosServiceImpl.eliminarProceso(id);
	}
	
}
