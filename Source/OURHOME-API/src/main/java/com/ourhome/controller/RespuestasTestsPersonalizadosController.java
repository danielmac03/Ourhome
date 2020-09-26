package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.RespuestasTestsPersonalizados;
import com.ourhome.service.RespuestasTestsPersonalizadosServiceImpl;

@RestController
@RequestMapping("/api")
public class RespuestasTestsPersonalizadosController {


	@Autowired
	RespuestasTestsPersonalizadosServiceImpl respuestasTestsPersonalizadosServiceImpl;
	

	@GetMapping("/respuestasTestsPersonalizados")
	public List<RespuestasTestsPersonalizados> listarRespuestasTestsPersonalizados(){
		return respuestasTestsPersonalizadosServiceImpl.listarRespuestasTestsPersonalizados();
	}

	@PostMapping("/respuestasTestsPersonalizados")
	public RespuestasTestsPersonalizados guardarRespuestasTestsPersonalizado(@RequestBody RespuestasTestsPersonalizados respuestasTestsPersonalizado) {
		return respuestasTestsPersonalizadosServiceImpl.guardarRespuestaTestPersonalizado(respuestasTestsPersonalizado);
	}
	
	@GetMapping("/respuestasTestsPersonalizados/{id}")
	public RespuestasTestsPersonalizados buscarRespuestasTestsPersonalizado(@PathVariable(name="id") int id) {
		RespuestasTestsPersonalizados respuestasTestsPersonalizado = new RespuestasTestsPersonalizados();		
		respuestasTestsPersonalizado = respuestasTestsPersonalizadosServiceImpl.buscarRespuestaTestPersonalizado(id);
		
		return respuestasTestsPersonalizado;
	}
	
	@PutMapping("/respuestasTestsPersonalizados/{id}")
	public RespuestasTestsPersonalizados actualizarRespuestaTestPersonalizado(@PathVariable(name="id") int id, @RequestBody RespuestasTestsPersonalizados RespuestasTestsPersonalizado) {
		RespuestasTestsPersonalizados RespuestasTestsPersonalizadosSeleccionado = new RespuestasTestsPersonalizados();
		RespuestasTestsPersonalizados RespuestasTestsPersonalizadosActualizado = new RespuestasTestsPersonalizados();
		
		RespuestasTestsPersonalizadosSeleccionado = respuestasTestsPersonalizadosServiceImpl.buscarRespuestaTestPersonalizado(id);
				
		RespuestasTestsPersonalizadosSeleccionado.setId_respuestas_test_personalizado(RespuestasTestsPersonalizado.getId_respuestas_test_personalizado());
		RespuestasTestsPersonalizadosSeleccionado.setId_usuario(RespuestasTestsPersonalizado.getId_usuario());
		RespuestasTestsPersonalizadosSeleccionado.setId_test_personalizado(RespuestasTestsPersonalizado.getId_test_personalizado());
		RespuestasTestsPersonalizadosSeleccionado.setRespuestas(RespuestasTestsPersonalizado.getRespuestas());
		RespuestasTestsPersonalizadosSeleccionado.setCompatibilidad(RespuestasTestsPersonalizado.getCompatibilidad());
		RespuestasTestsPersonalizadosSeleccionado.setFecha_creacion(RespuestasTestsPersonalizado.getFecha_creacion());

		RespuestasTestsPersonalizadosActualizado = respuestasTestsPersonalizadosServiceImpl.actualizarRespuestaTestPersonalizado(RespuestasTestsPersonalizadosSeleccionado);
		
		return RespuestasTestsPersonalizadosActualizado;
	}
	
	
	@DeleteMapping("/respuestasTestsPersonalizados/{id}")
	public void eliminarRespuestaTestPersonalizado(@PathVariable(name="id")int id) {
		respuestasTestsPersonalizadosServiceImpl.eliminarRespuestaTestPersonalizado(id);
	}
}
