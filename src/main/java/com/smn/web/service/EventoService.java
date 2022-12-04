package com.smn.web.service;

import java.util.List;

import com.smn.web.model.Evento;


public interface EventoService {
	
	public List<Evento> listarEvento();
	
	public Evento guardarEvento(Evento evento);
	
	public Evento obtenerEventoId(Long id);
	
	public Evento actualizarEvento(Evento evento);
	
	public void eliminarEvento(Evento evento);
}
