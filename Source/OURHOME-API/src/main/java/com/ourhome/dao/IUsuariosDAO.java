package com.ourhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ourhome.dto.Usuarios;

public interface IUsuariosDAO extends JpaRepository<Usuarios, Integer>{

	Usuarios findByCorreo(String correo);
	
}
