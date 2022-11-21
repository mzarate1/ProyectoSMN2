package com.smn.web.service;

import java.util.List;

import com.smn.web.model.Clima;

public interface ClimaService {
	
	public List<Clima> listarClimas();
	
	public Clima guardarClima(Clima clima);
	
	public Clima obtenerClimaId(Long id);
	
	public Clima actualizarClima(Clima clima);
	
	public void eliminarClima(Clima clima);
}
