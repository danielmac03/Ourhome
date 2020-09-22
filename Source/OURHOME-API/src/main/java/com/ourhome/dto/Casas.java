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
	Usuarios usuarios;

	@Column(name="url_foto")
	private String url_foto;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="numero_habitaciones")
	private int numero_habitaciones;
	
	@Column(name="numero_baños")
	private int numero_baños;
	
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
	 * @param usuarios
	 * @param url_foto
	 * @param descripcion
	 * @param precio
	 * @param numero_habitaciones
	 * @param numero_baños
	 * @param direccion
	 * @param metros
	 * @param plantas
	 * @param extras
	 * @param fecha_creacion
	 * @param fecha_actualizacion
	 */
	public Casas(int id_casa, Usuarios usuarios, String url_foto, String descripcion, double precio, int numero_habitaciones,
			int numero_baños, String direccion, double metros, int plantas, String extras, Date fecha_creacion,
			Date fecha_actualizacion) {
		this.id_casa = id_casa;
		this.usuarios = usuarios;
		this.url_foto = url_foto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.numero_habitaciones = numero_habitaciones;
		this.numero_baños = numero_baños;
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
	public Usuarios getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * @return the url_foto
	 */
	public String getUrl_foto() {
		return url_foto;
	}

	/**
	 * @param url_foto the url_foto to set
	 */
	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
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
	 * @return the numero_baños
	 */
	public int getNumero_baños() {
		return numero_baños;
	}

	/**
	 * @param numero_baños the numero_baños to set
	 */
	public void setNumero_baños(int numero_baños) {
		this.numero_baños = numero_baños;
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
		return "Casas [id_casa=" + id_casa + ", usuarios=" + usuarios + ", url_foto=" + url_foto + ", descripcion="
				+ descripcion + ", precio=" + precio + ", numero_habitaciones=" + numero_habitaciones
				+ ", numero_baños=" + numero_baños + ", direccion=" + direccion + ", metros=" + metros + ", plantas="
				+ plantas + ", extras=" + extras + ", fecha_creacion=" + fecha_creacion + ", fecha_actualizacion="
				+ fecha_actualizacion + "]";
	}
	
}