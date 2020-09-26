package com.ourhome.dto;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="casas")
public class Casas {

	@Id
	@Column(name="id_casa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_casa;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	Users users;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="url_fotos")
	private String url_fotos;
		
	@Column(name="numero_habitaciones")
	private int numero_habitaciones;
	
	@Column(name="numero_banos")
	private int numero_banos;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="metros")
	private double metros;
	
	@Column(name="plantas")
	private int plantas;
	
	@Column(name="extras")
	private String extras;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
	public Casas() {}

	/**
	 * @param id_casa
	 * @param users
	 * @param url_fotos
	 * @param descripcion
	 * @param precio
	 * @param numero_habitaciones
	 * @param numero_banos
	 * @param direccion
	 * @param metros
	 * @param plantas
	 * @param extras
	 * @param fecha_creacion
	 * @param fecha_actualizacion
	 */
	public Casas(int id_casa, Users users, String url_fotos, String descripcion, double precio, 
			int numero_habitaciones, int numero_banos, String direccion, double metros, int plantas, 
			String extras, Date fecha_creacion, Date fecha_actualizacion) {
		this.id_casa = id_casa;
		this.users = users;
		this.url_fotos = url_fotos;
		this.descripcion = descripcion;
		this.precio = precio;
		this.numero_habitaciones = numero_habitaciones;
		this.numero_banos = numero_banos;
		this.direccion = direccion;
		this.metros = metros;
		this.plantas = plantas;
		this.extras = extras;
		this.fecha_creacion = fecha_creacion;
		this.fecha_actualizacion = fecha_actualizacion;
	}

	/**
	 * @return the id_casa
	 */
	public int getId_casa() {
		return id_casa;
	}

	/**
	 * @param id_casa the id_casa to set
	 */
	public void setId_casa(int id_casa) {
		this.id_casa = id_casa;
	}

	/**
	 * @return the usuarios
	 */
	public Users getUsuarios() {
		return users;
	}

	/**
	 * @param users the usuarios to set
	 */
	public void setUsuarios(Users users) {
		this.users = users;
	}

	/**
	 * @return the url_fotos
	 */
	public String getUrl_fotos() {
		return url_fotos;
	}

	/**
	 * @param url_fotos the url_fotos to set
	 */
	public void setUrl_fotos(String url_fotos) {
		this.url_fotos = url_fotos;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the numero_habitaciones
	 */
	public int getNumero_habitaciones() {
		return numero_habitaciones;
	}

	/**
	 * @param numero_habitaciones the numero_habitaciones to set
	 */
	public void setNumero_habitaciones(int numero_habitaciones) {
		this.numero_habitaciones = numero_habitaciones;
	}

	/**
	 * @return the numero_banos
	 */
	public int getNumero_banos() {
		return numero_banos;
	}

	/**
	 * @param numero_banos the numero_banos to set
	 */
	public void setNumero_banos(int numero_banos) {
		this.numero_banos = numero_banos;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the metros
	 */
	public double getMetros() {
		return metros;
	}

	/**
	 * @param metros the metros to set
	 */
	public void setMetros(double metros) {
		this.metros = metros;
	}

	/**
	 * @return the plantas
	 */
	public int getPlantas() {
		return plantas;
	}

	/**
	 * @param plantas the plantas to set
	 */
	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}

	/**
	 * @return the extras
	 */
	public String getExtras() {
		return extras;
	}

	/**
	 * @param extras the extras to set
	 */
	public void setExtras(String extras) {
		this.extras = extras;
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
		return "Casas [id_casa=" + id_casa + ", usuarios=" + users + ", url_fotos=" + url_fotos +", descripcion=" + 
				descripcion + ", precio=" + precio + ", numero_habitaciones=" + numero_habitaciones + ", numero_banos=" 
				+ numero_banos + ", direccion=" + direccion + ", metros=" + metros + ", plantas=" + plantas + 
				", extras=" + extras + ", fecha_creacion=" + fecha_creacion + ", fecha_actualizacion=" + fecha_actualizacion + "]";
	}

}
