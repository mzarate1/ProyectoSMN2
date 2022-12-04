package com.smn.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Entity
@Table(name = "provincia")
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_provincia;
	
	@Size(min = 4, max = 10, message = "Nombre Provincia, debe tener entre 4 a 10 caracteres")
	@Column(name = "nombre_provincia", nullable = false, length = 20)
	private String nombre_provincia;
	
	public Provincia() {
		super();
	}
	
	public Provincia(String nombre_provincia) {
		super();
		this.nombre_provincia = nombre_provincia;
	}
	
	public Provincia(Long id_provincia, String nombre_provincia) {
		super();
		this.id_provincia = id_provincia;
		this.nombre_provincia = nombre_provincia;
	}

	public Long getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(Long id_provincia) {
		this.id_provincia = id_provincia;
	}

	public String getNombre_provincia() {
		return nombre_provincia;
	}

	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}

	@Override
	public String toString() {
		return "Provincia [id_provincia=" + id_provincia + ", nombre_provincia=" + nombre_provincia + "]";
	}
	
}
