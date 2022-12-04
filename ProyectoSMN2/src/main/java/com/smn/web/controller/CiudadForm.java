package com.smn.web.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.smn.web.model.Ciudad;
import com.smn.web.model.Provincia;

public class CiudadForm {
	
	private Long id_ciudad;
	
	@Size(min=4, max=10, message = "Nombre Ciudad, debe tener entre 4 a 10 caracteres")
	private String nombre_ciudad;
	
	@NotNull
	private Provincia Id_provincia;
	
	public CiudadForm() {
		super();
	}

	public CiudadForm(  String nombre_ciudad, Provincia Id_provincia) {
		super();
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

	public void setId_provincia(Provincia Id_provincia) {
		this.Id_provincia = Id_provincia;
	}
	
	public Ciudad toModel() {
		
		Ciudad newCiudad = new Ciudad();
		newCiudad.setId_ciudad(this.id_ciudad);
		newCiudad.setNombre_ciudad(this.nombre_ciudad.toLowerCase());
		newCiudad.setId_provincia(this.Id_provincia);
		return newCiudad;
	}

	@Override
	public String toString() {
		return "CiudadForm [id_ciudad=" + id_ciudad + ", nombre_ciudad=" + nombre_ciudad + ", id_provincia="
				+ Id_provincia + "]";
	}
	
}

