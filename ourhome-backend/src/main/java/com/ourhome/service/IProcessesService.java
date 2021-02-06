package com.ourhome.service;

import com.ourhome.dto.Processes;

import java.util.List;

public interface IProcessesService {

    public List<Processes> listProcesses();

    public Processes saveProcess(Processes process);

    public Processes getProcess(int id);

    public List<Processes> listProcessByUser(int userId);

    public List<Processes> listProcessByHome(int homeId);

    public Processes getProcessByHomeAndUser(int homeId, int userId);

    public void deleteProcess(int id);

    public void deleteProcessesByHome(int id);

}