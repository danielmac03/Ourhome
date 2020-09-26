package com.ourhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourhome.dto.Processes;

public interface IProcessesDAO extends JpaRepository<Processes, Integer>{

}
