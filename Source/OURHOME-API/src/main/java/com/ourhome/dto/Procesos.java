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
	Users id_usuario_1;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_2")
	Users id_usuario_2;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
	public Procesos() {}
	

	/**
	 * @param id_proceso
	 * @param id_usuario_1
	 * @param id_usuario_2
	 * @param estado
	 * @param fecha_creacion
	 * @param fecha_actualizacion
	 */
	public Procesos(int id_proceso, Users id_usuario_1, Users id_usuario_2, String estado, Date fecha_creacion, Date fecha_actualizacion) {
		this.id_proceso = id_proceso;
		this.id_usuario_1 = id_usuario_1;
		this.id_usuario_2 = id_usuario_2;
		this.estado = estado;
		this.fecha_creacion = fecha_creacion;
		this.fecha_actualizacion = fecha_actualizacion;
	}


	/**
	 * @return the id_proceso
	 */
	public int getId_proceso() {
		return id_proceso;
	}


	/**
	 * @param id_proceso the id_proceso to set
	 */
	public void setId_proceso(int id_proceso) {
		this.id_proceso = id_proceso;
	}


	/**
	 * @return the id_usuario_1
	 */
	public Users getId_usuario_1() {
		return id_usuario_1;
	}


	/**
	 * @param id_usuario_1 the id_usuario_1 to set
	 */
	public void setId_usuario_1(Users id_usuario_1) {
		this.id_usuario_1 = id_usuario_1;
	}


	/**
	 * @return the id_usuario_2
	 */
	public Users getId_usuario_2() {
		return id_usuario_2;
	}


	/**
	 * @param id_usuario_2 the id_usuario_2 to set
	 */
	public void setId_usuario_2(Users id_usuario_2) {
		this.id_usuario_2 = id_usuario_2;
	}


	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
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
	 * @return the fecha_actualizacion
	 */
	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}


	/**
	 * @param fecha_actualizacion the fecha_actualizacion to set
	 */
	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	@Override
	public String toString() {
		return "Procesos [id_proceso=" + id_proceso + ", estado=" + estado + ", fecha_creacion=" + fecha_creacion
				+ ", fecha_actualizacion=" + fecha_actualizacion + "]";
	}
	
}