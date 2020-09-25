package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.Usuarios;

public interface IUsuariosService {

	public List<Usuarios> listarUsuarios(); 
	
	public Usuarios guardarUsuario(Usuarios usuario);	
	
	public Usuarios buscarUsuario(int id);
	
	public Usuarios actualizarUsuario(Usuarios usuario); 
	
	public void eliminarUsuario(int id);
	
}
