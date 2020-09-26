package com.ourhome.dto;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
	
	@Column(name="rol")
	private String rol;
	
	@Column(name="respuestas_test_defecto")
	private String respuestas_test_defecto;
	
	@Column(name="mostrar_telefono")
	private boolean mostrar_telefono;
	
	@CreationTimestamp
	@Column(name="fecha_creacion")
	private Date fecha_creacion;
	
	@UpdateTimestamp
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Casas> casas;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Procesos> procesos_1;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Procesos> procesos_2;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<TestsPersonalizados> testPersonalizados;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados;
	
	public Usuarios() {}
	
	

	/**
	 * @param id_usuarios
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param telefono
	 * @param correo
	 * @param contraseña
	 * @param rol
	 * @param respuestas_test_defecto
	 * @param mostrar_telefono
	 * @param fecha_creacion
	 * @param fecha_actualizacion
	 * @param casas
	 * @param procesos_1
	 * @param procesos_2
	 * @param testPersonalizados
	 * @param respuestasTestsPersonalizados
	 */
	public Usuarios(int id_usuarios, String nombre, String apellidos, int edad, int telefono, String correo,
			String contraseña, String rol, String respuestas_test_defecto, boolean mostrar_telefono, 
			Date fecha_creacion, Date fecha_actualizacion, List<Casas> casas, List<Procesos> procesos_1, 
			List<Procesos> procesos_2, List<TestsPersonalizados> testPersonalizados, 
			List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados) {
		this.id_usuarios = id_usuarios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.contraseña = contraseña;
		this.rol = rol;
		this.respuestas_test_defecto = respuestas_test_defecto;
		this.mostrar_telefono = mostrar_telefono;
		this.fecha_creacion = fecha_creacion;
		this.fecha_actualizacion = fecha_actualizacion;
		this.casas = casas;
		this.procesos_1 = procesos_1;
		this.procesos_2 = procesos_2;
		this.testPersonalizados = testPersonalizados;
		this.respuestasTestsPersonalizados = respuestasTestsPersonalizados;
	}

	/**
	 * @return the id_usuarios
	 */
	public int getId_usuarios() {
		return id_usuarios;
	}

	/**
	 * @param id_usuarios the id_usuarios to set
	 */
	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the contrasena
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contrasena to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the respuestas_test_defecto
	 */
	public String getRespuestas_test_defecto() {
		return respuestas_test_defecto;
	}

	/**
	 * @param respuestas_test_defecto the respuestas_test_defecto to set
	 */
	public void setRespuestas_test_defecto(String respuestas_test_defecto) {
		this.respuestas_test_defecto = respuestas_test_defecto;
	}

	/**
	 * @return the mostrar_telefono
	 */
	public boolean isMostrar_telefono() {
		return mostrar_telefono;
	}

	/**
	 * @param mostrar_telefono the mostrar_telefono to set
	 */
	public void setMostrar_telefono(boolean mostrar_telefono) {
		this.mostrar_telefono = mostrar_telefono;
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

	/**
	 * @return the casas
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "casas")
	public List<Casas> getCasas() {
		return casas;
	}

	/**
	 * @param casas the casas to set
	 */
	public void setCasas(List<Casas> casas) {
		this.casas = casas;
	}

	/**
	 * @return the procesos_1
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "procesos")
	public List<Procesos> getProcesos_1() {
		return procesos_1;
	}

	/**
	 * @param procesos_1 the procesos_1 to set
	 */
	public void setProcesos_1(List<Procesos> procesos_1) {
		this.procesos_1 = procesos_1;
	}

	/**
	 * @return the procesos_2
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "procesos")
	public List<Procesos> getProcesos_2() {
		return procesos_2;
	}

	/**
	 * @param procesos_2 the procesos_2 to set
	 */
	public void setProcesos_2(List<Procesos> procesos_2) {
		this.procesos_2 = procesos_2;
	}

	/**
	 * @return the testPersonalizados
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "test_personalizados")
	public List<TestsPersonalizados> getTestPersonalizados() {
		return testPersonalizados;
	}

	/**
	 * @param testPersonalizados the testPersonalizados to set
	 */
	public void setTestPersonalizados(List<TestsPersonalizados> testPersonalizados) {
		this.testPersonalizados = testPersonalizados;
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
		return "Usuarios [id_usuarios=" + id_usuarios + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
				+ edad + ", telefono=" + telefono + ", correo=" + correo + ", contrasena=" + contraseña + ", rol=" + rol
				+ ", respuestas_test_defecto=" + respuestas_test_defecto + ", mostrar_telefono=" + mostrar_telefono
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_actualizacion=" + fecha_actualizacion + ", casas="
				+ casas + ", procesos_1=" + procesos_1 + ", procesos_2=" + procesos_2 + ", testPersonalizados="
				+ testPersonalizados + ", respuestasTestsPersonalizados=" + respuestasTestsPersonalizados + "]";
	}
	
}
