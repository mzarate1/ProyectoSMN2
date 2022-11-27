package com.smn.web.service;

import java.util.List;

import com.smn.web.model.EstadoClima;

public interface EstadoClimaService {

	public List<EstadoClima> listarEstadoClima();
	
	public EstadoClima guardarEstadoClima(EstadoClima estadoClima);
	
	public EstadoClima obtenerEstadoClimaId(Long id);
	
	public EstadoClima actualizarEstadoClima(EstadoClima estadoClima);
	
	public void eliminarEstadoClima(EstadoClima estadoClima);
}
