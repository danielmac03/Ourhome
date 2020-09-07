package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.RespuestasTestsPersonalizados;

public interface IRespuestasTestsPersonalizadosService {

	public List<RespuestasTestsPersonalizados> listarRespuestasTestsPersonalizados(); 
	
	public RespuestasTestsPersonalizados guardarRespuestaTestPersonalizado(RespuestasTestsPersonalizados respuestaTestPersonalizado);	
	
	public RespuestasTestsPersonalizados buscarRespuestaTestPersonalizado(int id);
	
	public RespuestasTestsPersonalizados actualizarRespuestaTestPersonalizado(RespuestasTestsPersonalizados respuestaTestPersonalizado); 
	
	public void eliminarRespuestaTestPersonalizado(int id);
		
}
