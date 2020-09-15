package com.ourhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ourhome.dto.TestsPersonalizados;
import com.ourhome.service.TestsPersonalizadosServiceImpl;

@RestController
@RequestMapping("/api")
public class TestsPersonalizadosController {
	
	@Autowired
	TestsPersonalizadosServiceImpl testsPersonalizadosServiceImpl;
	
	
	@GetMapping("/testsPersonalizados")
	public List<TestsPersonalizados> listarTestsPersonalizados(){
		return testsPersonalizadosServiceImpl.listarTestsPersonalizados();
	}

	
	@PostMapping("/testsPersonalizados")
	public TestsPersonalizados guardarTestPersonalizado(@RequestBody TestsPersonalizados testPersonalizado) {
		return testsPersonalizadosServiceImpl.guardarTestPersonalizado(testPersonalizado);
	}
	
	
	@GetMapping("/testsPersonalizados/{id}")
	public TestsPersonalizados buscarProceso(@PathVariable(name="id") int id) {
		TestsPersonalizados TestsPersonalizado = new TestsPersonalizados();		
		TestsPersonalizado = testsPersonalizadosServiceImpl.buscarTestPersonalizado(id);
		
		return TestsPersonalizado;
	}
	
	
	@PutMapping("/testsPersonalizados/{id}")
	public TestsPersonalizados actualizarTestPersonalizado(@PathVariable(name="id") int id,@RequestBody TestsPersonalizados TestsPersonalizado) {
		TestsPersonalizados testsPersonalizadosSeleccionado = new TestsPersonalizados();
		TestsPersonalizados testsPersonalizadosActualizado= new TestsPersonalizados();
		
		testsPersonalizadosSeleccionado= testsPersonalizadosServiceImpl.buscarTestPersonalizado(id);
		
		testsPersonalizadosSeleccionado.setId_test_personalizados(TestsPersonalizado.getId_test_personalizados());
		testsPersonalizadosSeleccionado.setId_usuario_creador(TestsPersonalizado.getId_usuario_creador());
		testsPersonalizadosSeleccionado.setRespuestas_correctas(TestsPersonalizado.getRespuestas_correctas());
		testsPersonalizadosSeleccionado.setMinimas_respuestas_correctas(TestsPersonalizado.getMinimas_respuestas_correctas());
		testsPersonalizadosSeleccionado.setFecha_creacion(TestsPersonalizado.getFecha_creacion());
		testsPersonalizadosSeleccionado.setRespuestasTestsPersonalizados(TestsPersonalizado.getRespuestasTestsPersonalizados());

		testsPersonalizadosActualizado = testsPersonalizadosServiceImpl.actualizarTestPersonalizado(testsPersonalizadosSeleccionado);
		
		return testsPersonalizadosActualizado;
	}

	
	@DeleteMapping("/testsPersonalizados/{id}")
	public void eliminarTestPersonalizado(@PathVariable(name="id") int id) {
		testsPersonalizadosServiceImpl.eliminarTestPersonalizado(id);
	}

}
