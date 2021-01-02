package com.ourhome.dao;

import com.ourhome.dto.Homes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHomesDAO extends JpaRepository<Homes, Integer>{

    List<Homes> findByActive(boolean active);

    List<Homes> findByUser_id(int userId);

}
