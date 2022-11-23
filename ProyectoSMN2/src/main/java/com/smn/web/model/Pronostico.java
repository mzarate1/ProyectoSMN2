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

@Entity
@Table(name = "pronostico")
public class Pronostico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pronostico;
	
	@Column(name = "fechaPronostico", nullable = false)
	private Date fechaPronostico;
	
	@Column(name = "probabilidadLluvia", nullable = false)
	private int probabilidadLluvia;
	
	@Column(name = "cantLluvia", nullable = false)
	private int cantLluvia;
	
	@Column(name = "dscPronostico", nullable = false)
	private String dscPronostico;
	
	@JoinColumn(name = "id_ciudad", nullable = false)
	@ManyToOne()
	private Ciudad id_ciudad;

	public Pronostico() {
		super();
	}

	public Pronostico(Date fechaPronostico, int probabilidadLluvia, int cantLluvia, Ciudad id_ciudad, String dscPronostico) {
		super();
		this.fechaPronostico = fechaPronostico;
		this.probabilidadLluvia = probabilidadLluvia;
		this.cantLluvia = cantLluvia;
		this.id_ciudad = id_ciudad;
		this.dscPronostico = dscPronostico;
	}

	public Pronostico(Long id_pronostico, Date fechaPronostico, int probabilidadLluvia, int cantLluvia, Ciudad id_ciudad, String dscPronostico) {
		super();
		this.id_pronostico = id_pronostico;
		this.fechaPronostico = fechaPronostico;
		this.probabilidadLluvia = probabilidadLluvia;
		this.cantLluvia = cantLluvia;
		this.id_ciudad = id_ciudad;
		this.dscPronostico = dscPronostico;
	}

	public Long getId_pronostico() {
		return id_pronostico;
	}

	public void setId_pronostico(Long id_pronostico) {
		this.id_pronostico = id_pronostico;
	}

	public Date getFechapronostico() {
		return fechaPronostico;
	}

	public void setFechapronostico(Date fechaPronostico) {
		this.fechaPronostico = fechaPronostico;
	}

	public int getprobabilidadLluvia() {
		return probabilidadLluvia;
	}

	public void setprobabilidadLluvia(int probabilidadLluvia) {
		this.probabilidadLluvia = probabilidadLluvia;
	}

	public int getcantLluvia() {
		return cantLluvia;
	}

	public void setcantLluvia(int cantLluvia) {
		this.cantLluvia = cantLluvia;
	}

	
	public Ciudad getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Ciudad id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	
	public String getdscPronostico() {
		return dscPronostico;
	}

	public void setdscPronostico(String dscPronostico) {
		this.dscPronostico = dscPronostico;
	}

	@Override
	public String toString() {
		return "Pronostico [id_pronostico=" + id_pronostico + ", fecha=" + fechaPronostico + ", probabilidad Lluvia=" + probabilidadLluvia + ", cant. Lluvia="
				+ cantLluvia + ", dsc pronostico=" + dscPronostico + ", ciudad=" + id_ciudad + "]";
	}
	
}
