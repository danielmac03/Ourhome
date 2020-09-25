package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.Casas;

public interface ICasasService {

	public List<Casas> listarCasas(); 
	
	public Casas guardarCasa(Casas casa);	
	
	public Casas buscarCasa(int id);
	
	public Casas actualizarCasa(Casas casa); 
	
	public void eliminarCasa(int id);
	
}
