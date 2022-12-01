package com.smn.web.controller;

import java.util.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;

import com.smn.web.model.Ciudad;
import com.smn.web.model.Clima;
import com.smn.web.model.EstadoClima;

public class ClimaForm {
	
	private Long id_clima;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@FutureOrPresent(message = "Fecha solo puede ser el presente o futuro")
	private Date fecha;
	
	@PositiveOrZero(message = "Temperatura debe estar entre 0° a 60°")
	@Max(60)
	private int temperatura;

	@PositiveOrZero(message = "Humedad debe estar entre 0% a 100%")
	@Max(100)
	private int humedad;
	
	@NotNull
	private EstadoClima estado;
	
	@NotNull
	private Ciudad ciudad;
	
	public ClimaForm() {
		super();
	}

	public ClimaForm(Long id_clima, Date fecha, int temperatura, int humedad, EstadoClima estado, Ciudad ciudad) {
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
	
	public Clima toModel() {
		
		Clima newClima = new Clima();
		newClima.setFecha(this.fecha);
		newClima.setTemperatura(this.temperatura);
		newClima.setHumedad(this.humedad);
		newClima.setEstado(this.estado);
		newClima.setCiudad(this.ciudad);
		
		return newClima;
	}

	@Override
	public String toString() {
		return "ClimaForm [id_clima=" + id_clima + ", fecha=" + fecha + ", temperatura=" + temperatura + ", humedad="
				+ humedad + ", id_estado=" + estado + ", id_ciudad=" + ciudad + "]";
	}
	
}
