package com.ourhome.dto;

import java.util.List;
import java.sql.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="test_personalizados")
public class TestPersonalizados {
	
	@Id
	@Column(name="id_test_personalizados")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_test_personalizados;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_creador")
	Usuarios id_usuario_creador;
	
	//JSON - Reparar
	@Column(name="respuestas_correctas")
	private String respuestas_correctas;
	
	@Column(name="minimas_respuestas_correctas")
	private int minimas_respuestas_correctas;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@OneToMany
	@JoinColumn(name="id_test_personalizados")
	private List<TestPersonalizados> testPersonalizados;
	
}
