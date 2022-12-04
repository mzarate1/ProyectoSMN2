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
@Table(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_evento;
	
	@Column(name = "fechaevento", nullable = false)
	private Date fechaevento;
		
	@Column(name = "dscEvento", nullable = false)
	private String dscEvento;
	
	@JoinColumn(name = "id_ciudad", nullable = false)
	@ManyToOne()
	private Ciudad id_ciudad;

	public Evento() {
		super();
	}

	public Evento(Date fechaEvento, Ciudad id_ciudad, String dscEvento) {
		super();
		this.fechaevento = fechaEvento;
		this.id_ciudad = id_ciudad;
		this.dscEvento = dscEvento;
	}

	public Evento(Long id_evento, Date fechaevento, Ciudad id_ciudad, String dscEvento) {
		super();
		this.id_evento = id_evento;
		this.fechaevento = fechaevento;
		this.id_ciudad = id_ciudad;
		this.dscEvento = dscEvento;
	}

	public Long getId_evento() {
		return id_evento;
	}

	public void setId_evento(Long id_evento) {
		this.id_evento = id_evento;
	}

	public Date getFechaevento() {
		return fechaevento;
	}

	public void setFechaevento(Date fechaEvento) {
		this.fechaevento = fechaEvento;
	}

	public Ciudad getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Ciudad id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	
	public String getdscEvento() {
		return dscEvento;
	}

	public void setdscEvento(String dscEvento) {
		this.dscEvento = dscEvento;
	}

	@Override
	public String toString() {
		return "Evento [=" + id_evento + ", fecha=" + fechaevento + ", dsc evento=" + dscEvento + ", ciudad=" + id_ciudad + "]";
	}
	
}
