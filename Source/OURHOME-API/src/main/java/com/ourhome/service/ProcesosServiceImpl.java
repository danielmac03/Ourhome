package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.IProcesosDAO;
import com.ourhome.dto.Procesos;

@Service
public class ProcesosServiceImpl implements IProcesosService {

	@Autowired
	IProcesosDAO iProcesosDAO;
	
	@Override
	public List<Procesos> listarProcesos() {
		return iProcesosDAO.findAll();
	}

	@Override
	public Procesos guardarProceso(Procesos proceso) {
		return iProcesosDAO.save(proceso);
	}

	@Override
	public Procesos buscarProceso(int id) {
		return iProcesosDAO.findById(id).get();
	}

	@Override
	public Procesos actualizarProceso(Procesos proceso) {
		return iProcesosDAO.save(proceso);
	}

	@Override
	public void eliminarProceso(int id) {
		iProcesosDAO.deleteById(id);
	}

}