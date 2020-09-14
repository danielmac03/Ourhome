package com.ourhome.dto;

import java.util.List;
import java.sql.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="test_personalizados")
public class TestsPersonalizados {
	
	@Id
	@Column(name="id_test_personalizados")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_test_personalizados;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_creador")
	Usuarios id_usuario_creador;
	
	@Column(name="respuestas_correctas")
	private String respuestas_correctas;
	
	@Column(name="minimas_respuestas_correctas")
	private int minimas_respuestas_correctas;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@OneToMany
	@JoinColumn(name="id_test_personalizados")
	private List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados;
	
	public TestsPersonalizados() {}

	/**
	 * @param id_test_personalizados
	 * @param id_usuario_creador
	 * @param respuestas_correctas
	 * @param minimas_respuestas_correctas
	 * @param fecha_creacion
	 * @param respuestasTestsPersonalizados
	 */
	public TestsPersonalizados(int id_test_personalizados, Usuarios id_usuario_creador,
			String respuestas_correctas, int minimas_respuestas_correctas, Date fecha_creacion,
			List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados) {
		this.id_test_personalizados = id_test_personalizados;
		this.id_usuario_creador = id_usuario_creador;
		this.respuestas_correctas = respuestas_correctas;
		this.minimas_respuestas_correctas = minimas_respuestas_correctas;
		this.fecha_creacion = fecha_creacion;
		this.respuestasTestsPersonalizados = respuestasTestsPersonalizados;
	}

	/**
	 * @return the id_test_personalizados
	 */
	public int getId_test_personalizados() {
		return id_test_personalizados;
	}

	/**
	 * @param id_test_personalizados the id_test_personalizados to set
	 */
	public void setId_test_personalizados(int id_test_personalizados) {
		this.id_test_personalizados = id_test_personalizados;
	}

	/**
	 * @return the id_usuario_creador
	 */
	public Usuarios getId_usuario_creador() {
		return id_usuario_creador;
	}

	/**
	 * @param id_usuario_creador the id_usuario_creador to set
	 */
	public void setId_usuario_creador(Usuarios id_usuario_creador) {
		this.id_usuario_creador = id_usuario_creador;
	}

	/**
	 * @return the respuestas_correctas
	 */
	public String getRespuestas_correctas() {
		return respuestas_correctas;
	}

	/**
	 * @param respuestas_correctas the respuestas_correctas to set
	 */
	public void setRespuestas_correctas(String respuestas_correctas) {
		this.respuestas_correctas = respuestas_correctas;
	}

	/**
	 * @return the minimas_respuestas_correctas
	 */
	public int getMinimas_respuestas_correctas() {
		return minimas_respuestas_correctas;
	}

	/**
	 * @param minimas_respuestas_correctas the minimas_respuestas_correctas to set
	 */
	public void setMinimas_respuestas_correctas(int minimas_respuestas_correctas) {
		this.minimas_respuestas_correctas = minimas_respuestas_correctas;
	}

	/**
	 * @return the fecha_creacion
	 */
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	/**
	 * @param fecha_creacion the fecha_creacion to set
	 */
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	/**
	 * @return the respuestasTestsPersonalizados
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "respuestas_tests_personalizados")
	public List<RespuestasTestsPersonalizados> getRespuestasTestsPersonalizados() {
		return respuestasTestsPersonalizados;
	}

	/**
	 * @param respuestasTestsPersonalizados the respuestasTestsPersonalizados to set
	 */
	public void setRespuestasTestsPersonalizados(List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados) {
		this.respuestasTestsPersonalizados = respuestasTestsPersonalizados;
	}

	@Override
	public String toString() {
		return "TestsPersonalizados [id_test_personalizados=" + id_test_personalizados + ", respuestas_correctas="
				+ respuestas_correctas + ", minimas_respuestas_correctas=" + minimas_respuestas_correctas
				+ ", fecha_creacion=" + fecha_creacion + ", respuestasTestsPersonalizados="
				+ respuestasTestsPersonalizados + "]";
	}
	
}