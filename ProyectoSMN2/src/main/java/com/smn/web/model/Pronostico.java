package com.smn.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pronostico")
public class Pronostico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pronostico;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "fecha_pronostico", nullable = false)
	private Date fecha_pronostico;
	
	@Column(name = "probabilidad_lluvia", nullable = false)
	private int probabilidad_lluvia;
	
	@Column(name = "cant_lluvia", nullable = false)
	private int cant_lluvia;
	
	@Column(name = "dsc_pronostico", nullable = false)
	private String dsc_pronostico;
	
	@JoinColumn(name = "id_ciudad", nullable = false)
	@ManyToOne()
	private Ciudad id_ciudad;

	public Pronostico() {
		super();
	}

	public Pronostico(Date fecha_pronostico, int probabilidad_lluvia, int cant_lluvia, Ciudad id_ciudad, String dsc_pronostico) {
		super();
		this.fecha_pronostico = fecha_pronostico;
		this.probabilidad_lluvia = probabilidad_lluvia;
		this.cant_lluvia = cant_lluvia;
		this.id_ciudad = id_ciudad;
		this.dsc_pronostico = dsc_pronostico;
	}

	public Pronostico(Long id_pronostico, Date fecha_pronostico, int probabilidad_lluvia, int cant_lluvia, Ciudad id_ciudad, String dsc_pronostico) {
		super();
		this.id_pronostico = id_pronostico;
		this.fecha_pronostico = fecha_pronostico;
		this.probabilidad_lluvia = probabilidad_lluvia;
		this.cant_lluvia = cant_lluvia;
		this.id_ciudad = id_ciudad;
		this.dsc_pronostico = dsc_pronostico;
	}

	public Ciudad getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Ciudad id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public Long getId_pronostico() {
		return id_pronostico;
	}

	public void setId_pronostico(Long id_pronostico) {
		this.id_pronostico = id_pronostico;
	}

	public Date getFecha_pronostico() {
		return fecha_pronostico;
	}

	public void setFecha_pronostico(Date fecha_pronostico) {
		this.fecha_pronostico = fecha_pronostico;
	}

	public int getProbabilidad_lluvia() {
		return probabilidad_lluvia;
	}

	public void setProbabilidad_lluvia(int probabilidad_lluvia) {
		this.probabilidad_lluvia = probabilidad_lluvia;
	}

	public int getCant_lluvia() {
		return cant_lluvia;
	}

	public void setCant_lluvia(int cant_lluvia) {
		this.cant_lluvia = cant_lluvia;
	}

	public String getDsc_pronostico() {
		return dsc_pronostico;
	}

	public void setDsc_pronostico(String dsc_pronostico) {
		this.dsc_pronostico = dsc_pronostico;
	}


	
}
