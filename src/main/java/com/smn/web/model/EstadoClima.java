package com.smn.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_clima")
public class EstadoClima {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estado;
	
	@Column(name = "dsc_estado", nullable = false, length = 50)
	private String dsc_estado;

	public EstadoClima() {
		super();
	}

	public EstadoClima(String dsc_estado) {
		super();
		this.dsc_estado = dsc_estado;
	}

	public EstadoClima(Long id_estado, String dsc_estado) {
		super();
		this.id_estado = id_estado;
		this.dsc_estado = dsc_estado;
	}

	public Long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}

	public String getDsc_estado() {
		return dsc_estado;
	}

	public void setDsc_estado(String dsc_estado) {
		this.dsc_estado = dsc_estado;
	}

	@Override
	public String toString() {
		return "EstadoClima [id_estado=" + id_estado + ", dsc_estado=" + dsc_estado + "]";
	}

}
