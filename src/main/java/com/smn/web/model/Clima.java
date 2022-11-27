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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clima")
public class Clima {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_clima;
	
	@NotNull
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	
	@NotNull
	@Column(name = "temperatura", nullable = false)
	private int temperatura;
	
	@NotNull
	@Column(name = "humedad", nullable = false)
	private int humedad;
	
	@JoinColumn(name = "id_estado", nullable = false)
	@ManyToOne()
	private EstadoClima id_estado;
	
	@JoinColumn(name = "id_ciudad", nullable = false)
	@ManyToOne()
	private Ciudad id_ciudad;

	public Clima() {
		super();
	}

	public Clima(Date fecha, int temperatura, int humedad, EstadoClima id_estado, Ciudad id_ciudad) {
		super();
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.humedad = humedad;
		this.id_estado = id_estado;
		this.id_ciudad = id_ciudad;
	}

	public Clima(Long id_clima, Date fecha, int temperatura, int humedad, EstadoClima id_estado, Ciudad id_ciudad) {
		super();
		this.id_clima = id_clima;
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.humedad = humedad;
		this.id_estado = id_estado;
		this.id_ciudad = id_ciudad;
	}

	public Long getId_clima() {
		return id_clima;
	}

	public void setId_clima(Long id_clima) {
		this.id_clima = id_clima;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public EstadoClima getId_estado() {
		return id_estado;
	}

	public void setId_estado(EstadoClima id_estado) {
		this.id_estado = id_estado;
	}

	public Ciudad getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Ciudad id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	@Override
	public String toString() {
		return "Clima [id_clima=" + id_clima + ", fecha=" + fecha + ", temperatura=" + temperatura + ", humedad="
				+ humedad + ", id_estado=" + id_estado + ", id_ciudad=" + id_ciudad + "]";
	}
	
}
