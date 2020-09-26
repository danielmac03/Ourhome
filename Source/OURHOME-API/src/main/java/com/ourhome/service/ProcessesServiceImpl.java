package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.IProcessesDAO;
import com.ourhome.dto.Processes;

@Service
public class ProcessesServiceImpl implements IProcessesService {

	@Autowired
	IProcessesDAO iProcesosDAO;
	
	@Override
	public List<Processes> listProcesses() {
		return iProcesosDAO.findAll();
	}

	@Override
	public Processes saveProcess(Processes process) {
		return iProcesosDAO.save(process);
	}

	@Override
	public Processes searchProcess(int id) {
		return iProcesosDAO.findById(id).get();
	}

	@Override
	public Processes updateProcess(Processes process) {
		return iProcesosDAO.save(process);
	}

	@Override
	public void deleteProcess(int id) {
		iProcesosDAO.deleteById(id);
	}

}