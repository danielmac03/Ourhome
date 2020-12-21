package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.Processes;
import org.springframework.transaction.annotation.Transactional;

public interface IProcessesService {

	public List<Processes> listProcesses(); 
	
	public Processes saveProcess(Processes process);	
	
	public Processes getProcess(int id);

	public List<Processes> listProcessByHome(int homeId);

	public List<Processes> listProcessByUser(int userId);

	public Processes updateProcess(Processes process); 
	
	public void deleteProcess(int id);

	public void deleteProcessesByHome(int id);

}