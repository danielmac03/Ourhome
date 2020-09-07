package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="respuestas_tests_personalizados")
public class RespuestasTestsPersonalizados {

	@Id
	@Column(name="id_respuestas_test_personalizado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_respuestas_test_personalizado;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	Usuarios id_usuario;
	
	@ManyToOne
	@JoinColumn(name="id_test_personalizado")
	TestsPersonalizados id_test_personalizado;
	
	//JSON - Reparar
	@Column(name="respuestas")
	private String respuestas;
	
	@Column(name="compatibilidad")
	private Double compatibilidad;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;	
	
}
