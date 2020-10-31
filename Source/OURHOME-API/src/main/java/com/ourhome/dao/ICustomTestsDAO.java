package com.ourhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourhome.dto.CustomTests;

public interface ICustomTestsDAO extends JpaRepository<CustomTests, Integer>{

    CustomTests findByUser_id(int user_id);

}
