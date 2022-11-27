package com.smn.web.service;

import java.util.List;

import com.smn.web.model.Pronostico;


public interface PronosticoService {
	
	public List<Pronostico> listarPronosticos();
	
	public Pronostico guardarPronostico(Pronostico pronostico);
	
	public Pronostico obtenerPronosticoId(Long id);
	
	public Pronostico actualizarPronostico(Pronostico pronostico);
	
	public void eliminarPronostico(Pronostico pronostico);
}
