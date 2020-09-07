package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.TestsPersonalizados;

public interface ITestsPersonalizadosService {

	public List<TestsPersonalizados> listarTestsPersonalizados(); 
	
	public TestsPersonalizados guardarTestPersonalizado(TestsPersonalizados testPersonalizado);	
	
	public TestsPersonalizados buscarTestPersonalizado(int id);
	
	public TestsPersonalizados actualizarTestPersonalizado(TestsPersonalizados testPersonalizado); 
	
	public void eliminarTestPersonalizado(int id);
	
}
