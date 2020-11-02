package com.ourhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourhome.dto.Homes;

import java.util.List;

public interface IHomesDAO extends JpaRepository<Homes, Integer>{

    List<Homes> findByUser_id(int userId);

    List<Homes> findByCity(String city);

}
