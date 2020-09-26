package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.ICasasDAO;
import com.ourhome.dto.Casas;

@Service
public class CasasServiceImpl implements ICasasService{

	@Autowired
	ICasasDAO iCasasDAO;
	
	@Override
	public List<Casas> listarCasas() {
		return iCasasDAO.findAll();
	}

	@Override
	public Casas guardarCasa(Casas casa) {
		return iCasasDAO.save(casa);
	}

	@Override
	public Casas buscarCasa(int id) {
		return iCasasDAO.findById(id).get();
	}

	@Override
	public Casas actualizarCasa(Casas casa) {
		return iCasasDAO.save(casa);
	}

	@Override
	public void eliminarCasa(int id) {
		iCasasDAO.deleteById(id);
	}

}
