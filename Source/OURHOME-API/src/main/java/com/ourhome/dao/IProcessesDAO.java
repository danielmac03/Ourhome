package com.ourhome.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ourhome.dto.Processes;

public interface IProcessesDAO extends JpaRepository<Processes, Integer>{

    List<Processes> findByUser_id(int userId);

    List<Processes> findByHome_id(int homeId);

}
