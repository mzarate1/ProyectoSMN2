package com.smn.web.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.smn.web.model.Ciudad;
import com.smn.web.model.Provincia;
/**
 * 
 * @author Kruger Lisandro
 *
 */
public class CiudadForm {
	
	private Long id_ciudad;
	
	@Size(min=4, max=15, message = "Nombre Ciudad, debe tener entre 4 a 15 caracteres")
	private String nombre_ciudad;
	
	@NotNull
	private Provincia provincia;
	
	public CiudadForm() {
		super();
	}

	public CiudadForm(  String nombre_ciudad, Provincia provincia) {
		super();
		this.nombre_ciudad = nombre_ciudad;
		this.provincia = provincia;
		
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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	public Ciudad toModel() {
		
		Ciudad newCiudad = new Ciudad();
		newCiudad.setId_ciudad(this.id_ciudad);
		newCiudad.setNombre_ciudad(this.nombre_ciudad.toLowerCase());
		newCiudad.setProvincia(this.provincia);
		return newCiudad;
	}

	@Override
	public String toString() {
		return "CiudadForm [id_ciudad=" + id_ciudad + ", nombre_ciudad=" + nombre_ciudad + ", id_provincia="
				+ provincia + "]";
	}
	
}

