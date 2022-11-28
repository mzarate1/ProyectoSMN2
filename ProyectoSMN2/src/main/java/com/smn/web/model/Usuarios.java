package com.smn.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuariossuscriptos")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 20)
	private String apellido;
	
	@Column(name = "mail", nullable = false, length = 45)
	private String mail;
	
	@Column(name = "estado", nullable = false)
	private boolean estado;
	
	@ManyToMany
	@JoinTable (name = "suscripciones", joinColumns = @JoinColumn (name = "id_usuario"), inverseJoinColumns = @JoinColumn (name = "id_ciudad"))
	private List <Ciudad> ciudades;
			
	public Usuarios() {
		super();
	}
	
	public Usuarios(Long id_usuario, String nombre, String apellido, String mail, boolean estado) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.estado = estado;
	}

	public Long getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuarios [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", estado=" + estado + "]";
	}
	}
	