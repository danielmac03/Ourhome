package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.IRespuestasTestsPersonalizadosDAO;
import com.ourhome.dto.RespuestasTestsPersonalizados;

@Service
public class RespuestasTestsPersonalizadosServiceImpl implements IRespuestasTestsPersonalizadosService{
	
	@Autowired
	IRespuestasTestsPersonalizadosDAO iRespuestasTestsPersonalizadosDAO;

	@Override
	public List<RespuestasTestsPersonalizados> listarRespuestasTestsPersonalizados() {
		return iRespuestasTestsPersonalizadosDAO.findAll();
	}

	@Override
	public RespuestasTestsPersonalizados guardarRespuestaTestPersonalizado(RespuestasTestsPersonalizados respuestaTestPersonalizado) {
		return iRespuestasTestsPersonalizadosDAO.save(respuestaTestPersonalizado);
	}

	@Override
	public RespuestasTestsPersonalizados buscarRespuestaTestPersonalizado(int id) {
		return iRespuestasTestsPersonalizadosDAO.findById(id).get();
	}

	@Override
	public RespuestasTestsPersonalizados actualizarRespuestaTestPersonalizado(RespuestasTestsPersonalizados respuestaTestPersonalizado) {
		return iRespuestasTestsPersonalizadosDAO.save(respuestaTestPersonalizado);
	}

	@Override
	public void eliminarRespuestaTestPersonalizado(int id) {
		iRespuestasTestsPersonalizadosDAO.deleteById(id);
	}
	
}