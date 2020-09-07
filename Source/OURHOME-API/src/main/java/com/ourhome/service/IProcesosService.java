package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.Procesos;

public interface IProcesosService {

	public List<Procesos> listarProcesos(); 
	
	public Procesos guardarProceso(Procesos proceso);	
	
	public Procesos buscarProceso(int id);
	
	public Procesos actualizarProceso(Procesos proceso); 
	
	public void eliminarProceso(int id);
		
}