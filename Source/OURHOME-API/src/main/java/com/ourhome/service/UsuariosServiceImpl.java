package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.IUsuariosDAO;
import com.ourhome.dto.Usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

	@Autowired
	IUsuariosDAO iUsuariosDAO;
	
	@Override
	public List<Usuarios> listarUsuarios() {
		return iUsuariosDAO.findAll();
	}

	@Override
	public Usuarios guardarUsuario(Usuarios usuario) {
		return iUsuariosDAO.save(usuario);
	}

	@Override
	public Usuarios buscarUsuario(int id) {
		return iUsuariosDAO.findById(id).get();
	}

	@Override
	public Usuarios actualizarUsuario(Usuarios usuario) {
		return iUsuariosDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(int id) {
		iUsuariosDAO.deleteById(id);
	}

}
