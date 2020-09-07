package com.ourhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourhome.dto.Procesos;

public interface IProcesosDAO extends JpaRepository<Procesos, Integer>{

}
