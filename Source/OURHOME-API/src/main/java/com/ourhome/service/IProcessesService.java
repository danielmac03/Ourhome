package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.Processes;

public interface IProcessesService {

	public List<Processes> listProcesses(); 
	
	public Processes saveProcess(Processes process);	
	
	public Processes searchProcess(int id);
	
	public Processes updateProcess(Processes process); 
	
	public void deleteProcess(int id);
		
}