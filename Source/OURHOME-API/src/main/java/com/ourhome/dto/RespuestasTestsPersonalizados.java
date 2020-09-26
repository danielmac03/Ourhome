package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="respuestas_tests_personalizados")
public class RespuestasTestsPersonalizados {

	@Id
	@Column(name="id_respuestas_test_personalizado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_respuestas_test_personalizado;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	Users id_usuario;
	
	@ManyToOne
	@JoinColumn(name="id_test_personalizado")
	CustomTests id_test_personalizado;
	
	@Column(name="respuestas")
	private String respuestas;
	
	@Column(name="compatibilidad")
	private Double compatibilidad;
	
	@CreationTimestamp
	@Column(name="fecha_creacion")
	private Date fecha_creacion;	
	
	public RespuestasTestsPersonalizados() {}

	/**
	 * @param id_respuestas_test_personalizado
	 * @param id_usuario
	 * @param id_test_personalizado
	 * @param respuestas
	 * @param compatibilidad
	 * @param fecha_creacion
	 */
	public RespuestasTestsPersonalizados(int id_respuestas_test_personalizado, Users id_usuario,
			CustomTests id_test_personalizado, String respuestas, Double compatibilidad,
			Date fecha_creacion) {
		this.id_respuestas_test_personalizado = id_respuestas_test_personalizado;
		this.id_usuario = id_usuario;
		this.id_test_personalizado = id_test_personalizado;
		this.respuestas = respuestas;
		this.compatibilidad = compatibilidad;
		this.fecha_creacion = fecha_creacion;
	}

	/**
	 * @return the id_respuestas_test_personalizado
	 */
	public int getId_respuestas_test_personalizado() {
		return id_respuestas_test_personalizado;
	}

	/**
	 * @param id_respuestas_test_personalizado the id_respuestas_test_personalizado to set
	 */
	public void setId_respuestas_test_personalizado(int id_respuestas_test_personalizado) {
		this.id_respuestas_test_personalizado = id_respuestas_test_personalizado;
	}

	/**
	 * @return the id_usuario
	 */
	public Users getId_usuario() {
		return id_usuario;
	}

	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(Users id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @return the id_test_personalizado
	 */
	public CustomTests getId_test_personalizado() {
		return id_test_personalizado;
	}

	/**
	 * @param id_test_personalizado the id_test_personalizado to set
	 */
	public void setId_test_personalizado(CustomTests id_test_personalizado) {
		this.id_test_personalizado = id_test_personalizado;
	}

	/**
	 * @return the respuestas
	 */
	public String getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}

	/**
	 * @return the compatibilidad
	 */
	public Double getCompatibilidad() {
		return compatibilidad;
	}

	/**
	 * @param compatibilidad the compatibilidad to set
	 */
	public void setCompatibilidad(Double compatibilidad) {
		this.compatibilidad = compatibilidad;
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

	@Override
	public String toString() {
		return "RespuestasTestsPersonalizados [id_respuestas_test_personalizado=" + id_respuestas_test_personalizado
				+ ", respuestas=" + respuestas + ", compatibilidad=" + compatibilidad + ", fecha_creacion="
				+ fecha_creacion + "]";
	}
	
}