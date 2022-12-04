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
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Entity
@Table(name = "clima")
public class Clima {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_clima;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	
	@Column(name = "temperatura", nullable = false)
	private int temperatura;

	@Column(name = "humedad", nullable = false)
	private int humedad;
	
	@JoinColumn(name = "id_estado", nullable = false)
	@ManyToOne()
	private EstadoClima estado;
	
	@JoinColumn(name = "id_ciudad", nullable = false)
	@ManyToOne()
	private Ciudad ciudad;

	public Clima() {
		super();
	}

	public Clima(Long id_clima, Date fecha, int temperatura, int humedad, EstadoClima estado, Ciudad ciudad) {
		super();
		this.id_clima = id_clima;
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.humedad = humedad;
		this.estado = estado;
		this.ciudad = ciudad;
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

	public EstadoClima getEstado() {
		return estado;
	}

	public void setEstado(EstadoClima estado) {
		this.estado = estado;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Clima [id_clima=" + id_clima + ", fecha=" + fecha + ", temperatura=" + temperatura + ", humedad="
				+ humedad + ", id_estado=" + estado + ", id_ciudad=" + ciudad + "]";
	}
	
}