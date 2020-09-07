package com.ourhome.dto;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios")
public class Usuarios {

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuarios;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="telefono")
	private int telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="contraseña")
	private String contraseña;
	
	//ENUM - Reparar
	@Column(name="rol")
	private String rol;
	
	//JSON - Reparar
	@Column(name="respuestas_test_defecto")
	private String respuestas_test_defecto;
	
	@Column(name="mostrar_correo")
	private boolean mostrar_correo;
	
	@Column(name="mostrar_telefono")
	private boolean mostrar_telefono;
	
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Casas> casas;
	
	public Usuarios() {}
	
}
