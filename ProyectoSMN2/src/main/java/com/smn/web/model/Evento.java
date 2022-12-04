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
@Table(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_evento;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "fechaevento", nullable = false)
	private Date fechaevento;
		
	@Column(name = "dsc_evento", nullable = false, length = 150)
	private String dsc_evento;
	
	@JoinColumn(name = "id_ciudad", nullable = false)
	@ManyToOne()
	private Ciudad id_ciudad;

	public Evento() {
		super();
	}

	public Evento(Date fechaEvento, Ciudad id_ciudad, String dsc_evento) {
		super();
		this.fechaevento = fechaEvento;
		this.id_ciudad = id_ciudad;
		this.dsc_evento = dsc_evento;
	}

	public Evento(Long id_evento, Date fechaevento, Ciudad id_ciudad, String dsc_evento) {
		super();
		this.id_evento = id_evento;
		this.fechaevento = fechaevento;
		this.id_ciudad = id_ciudad;
		this.dsc_evento = dsc_evento;
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
	
	public String getdsc_evento() {
		return dsc_evento;
	}

	public void setdsc_evento(String dsc_evento) {
		this.dsc_evento = dsc_evento;
	}

	@Override
	public String toString() {
		return "Evento [id_evento=" + id_evento + ", fechaevento=" + fechaevento + ", dsc_evento=" + dsc_evento
				+ ", id_ciudad=" + id_ciudad + "]";
	}

	
}
