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
	
	@GetMapping("/TestsPersonalizados")
	public List<TestsPersonalizados> listarTestsPersonalizados(){
		return TestsPersonalizadosServiceImpl.listarTestsPersonalizados();
	}

	@PostMapping("/TestsPersonalizados")
	public TestsPersonalizados guardarTestPersonalizado(@RequestBody TestsPersonalizados testPersonalizado) {
		return TestsPersonalizadosServiceImpl.guardarTestPersonalizado(testPersonalizado);
	}
	
	@GetMapping("/TestsPersonalizados/{id}")
	public TestsPersonalizados buscarProceso(@PathVariable(name="id") int id) {
		TestsPersonalizados TestsPersonalizado = new TestsPersonalizados();		
		TestsPersonalizado = TestsPersonalizadosServiceImpl.buscarTestPersonalizado(id);
		
		return TestsPersonalizado;
	}
	
	@PutMapping("/departamentos/{id}")
	public TestsPersonalizados actualizarTestPersonalizado(@PathVariable(name="id") int id,@RequestBody TestsPersonalizados TestsPersonalizado) {
		TestsPersonalizados testsPersonalizadosSeleccionado = new TestsPersonalizados();
		TestsPersonalizados testsPersonalizadosActualizado= new TestsPersonalizados();
		
		testsPersonalizadosSeleccionado= TestsPersonalizadosServiceImpl.buscarTestPersonalizado(id);
		
		testsPersonalizadosSeleccionado.setId_test_personalizados(TestsPersonalizados.getId_test_personalizados());
		testsPersonalizadosSeleccionado.setId_usuario_creador(TestsPersonalizados.getId_usuario_creador());
		testsPersonalizadosSeleccionado.setRespuestas_correctas(TestsPersonalizados.getRespuestas_correctas());
		testsPersonalizadosSeleccionado.setMinimas_respuestas_correctas(TestsPersonalizados.getMinimas_respuestas_correctas());
		testsPersonalizadosSeleccionado.setFecha_creacion(TestsPersonalizados.getFecha_creacion());
		testsPersonalizadosSeleccionado.setRespuestasTestsPersonalizados(TestsPersonalizados.getRespuestasTestsPersonalizados());

		testsPersonalizadosActualizado = TestsPersonalizadosServiceImpl.actualizarTestPersonalizado(testsPersonalizadosSeleccionado);
		
		return testsPersonalizadosActualizado;
	}

	
	@DeleteMapping("/TestsPersonalizados/{id}")
	public void eliminarTestPersonalizado(@PathVariable(name="id") int id) {
		TestsPersonalizadosServiceImpl.eliminarTestPersonalizado(id);
	}

}
