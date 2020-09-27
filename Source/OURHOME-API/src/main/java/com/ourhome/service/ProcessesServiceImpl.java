package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.IProcessesDAO;
import com.ourhome.dto.Processes;

@Service
public class ProcessesServiceImpl implements IProcessesService {

	@Autowired
	IProcessesDAO iProcessesDAO;
	
	@Override
	public List<Processes> listProcesses() {
		return iProcessesDAO.findAll();
	}

	@Override
	public Processes saveProcess(Processes process) {
		return iProcessesDAO.save(process);
	}

	@Override
	public Processes searchProcess(int id) {
		return iProcessesDAO.findById(id).get();
	}

	@Override
	public Processes updateProcess(Processes process) {
		return iProcessesDAO.save(process);
	}

	@Override
	public void deleteProcess(int id) {
		iProcessesDAO.deleteById(id);
	}

}