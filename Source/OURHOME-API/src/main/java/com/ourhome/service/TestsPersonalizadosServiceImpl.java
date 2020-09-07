package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.ITestsPersonalizadosDAO;
import com.ourhome.dto.TestsPersonalizados;

@Service
public class TestsPersonalizadosServiceImpl implements ITestsPersonalizadosService{

	@Autowired
	ITestsPersonalizadosDAO iTestsPersonalizadosDAO;
	
	@Override
	public List<TestsPersonalizados> listarTestsPersonalizados() {
		return iTestsPersonalizadosDAO.findAll();
	}

	@Override
	public TestsPersonalizados guardarTestPersonalizado(TestsPersonalizados testPersonalizado) {
		return iTestsPersonalizadosDAO.save(testPersonalizado);
	}

	@Override
	public TestsPersonalizados buscarTestPersonalizado(int id) {
		return iTestsPersonalizadosDAO.findById(id).get();
	}

	@Override
	public TestsPersonalizados actualizarTestPersonalizado(TestsPersonalizados testPersonalizado) {
		return iTestsPersonalizadosDAO.save(testPersonalizado);
	}

	@Override
	public void eliminarTestPersonalizado(int id) {
		iTestsPersonalizadosDAO.deleteById(id);
	}

}