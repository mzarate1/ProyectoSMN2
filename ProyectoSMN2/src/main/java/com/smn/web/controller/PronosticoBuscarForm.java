package com.smn.web.controller;

import java.util.Date;
import java.util.List;

import com.smn.web.model.Ciudad;

public class PronosticoBuscarForm {
	
	private Long IdCiudadSeleccionada;
	private Date fechaactual;
	private Date fechaextendida;

	public Date getFechaactual() {
		return fechaactual;
	}
	public void setFechaactual(Date fechaactual) {
		this.fechaactual = fechaactual;
	}
	public Date getFechaextendida() {
		return fechaextendida;
	}
	public void setFechaextendida(Date fechaextendida) {
		this.fechaextendida = fechaextendida;
	}
	public Long getIdCiudadSeleccionada() {
		return IdCiudadSeleccionada;
	}
	public void setIdCiudadSeleccionada(Long idCiudadSeleccionada) {
		IdCiudadSeleccionada = idCiudadSeleccionada;
	}
	public void setIdCiudadSeleccionada(List<Ciudad> listarCiudades) {
		
	}
	

}
