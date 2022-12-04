package com.smn.web.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PronosticoBuscarForm {
	
	private Long IdCiudadSeleccionada;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date Fechaactual;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date Fechaextendida;
	
	public Long getIdCiudadSeleccionada() {
		return IdCiudadSeleccionada;
	}
	public void setIdCiudadSeleccionada(Long idCiudadSeleccionada) {
		IdCiudadSeleccionada = idCiudadSeleccionada;
	}
	public Date getFechaactual() {
		return Fechaactual;
	}
	
	public void setFechaactual(Date fechaactual) {
		Fechaactual = fechaactual;
	}
	public Date getFechaextendida() {
		return Fechaextendida;
	}
	public void setFechaextendida(Date fechaextendida) {
		Fechaextendida = fechaextendida;
	}
	
	}
		


