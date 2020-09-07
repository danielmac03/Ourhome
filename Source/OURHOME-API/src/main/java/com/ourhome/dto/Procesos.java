package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="procesos")
public class Procesos {
	
	@Id
	@Column(name="id_proceso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_proceso;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_1")
	Usuarios id_usuario_1;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_2")
	Usuarios id_usuario_2;
	
	//ENUM - Reparar
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
}
