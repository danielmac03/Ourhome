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
	
	//JSON - Reparar
	@Column(name="extras")
	private String extras;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
}
