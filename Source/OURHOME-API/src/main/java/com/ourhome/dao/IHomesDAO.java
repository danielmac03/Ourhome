package com.ourhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourhome.dto.Homes;

public interface IHomesDAO extends JpaRepository<Homes, Integer>{

}
