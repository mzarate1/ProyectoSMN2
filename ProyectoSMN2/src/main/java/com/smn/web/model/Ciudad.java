package com.smn.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ciudad;
	
	@Column(name = "nombre_ciudad", nullable = false, length = 10)
	private String nombre_ciudad;
	
	@JoinColumn(name = "id_provincia", nullable = false)
	@ManyToOne()
	private Provincia Id_provincia;

	public Ciudad() {
		super();
	}

	public Ciudad(String nombre_ciudad, Provincia Id_provincia) {
		super();
		this.nombre_ciudad = nombre_ciudad;
		this.Id_provincia = Id_provincia;
	}

	public Ciudad(Long id_ciudad, String nombre_ciudad, Provincia Id_provincia) {
		super();
		this.id_ciudad = id_ciudad;
		this.nombre_ciudad = nombre_ciudad;
		this.Id_provincia = Id_provincia;
	}

	public Long getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Long id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre_ciudad() {
		return nombre_ciudad;
	}

	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}

	public Provincia getId_provincia() {
		return Id_provincia;
	}


	public void setId_provincia(Provincia id_provincia) {
		Id_provincia = id_provincia;
	}

	@Override
	public String toString() {
		return "Ciudad [id_ciudad=" + id_ciudad + ", nombre_ciudad=" + nombre_ciudad + ", Id_provincia=" + Id_provincia
				+ "]";
	}
	
}
