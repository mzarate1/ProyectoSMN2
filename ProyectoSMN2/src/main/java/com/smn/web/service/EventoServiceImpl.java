package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.Evento;
import com.smn.web.repository.EventoRepository;


@Service
public class EventoServiceImpl implements EventoService {
	
	@Autowired
	EventoRepository repositorio;
	
	@Override
	public List<Evento> listarEvento() {
		return repositorio.findAll();
	}

	@Override
	public Evento guardarEvento(Evento evento) {
		return repositorio.save(evento);
	}

	@Override
	public Evento obtenerEventoId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Evento actualizarEvento (Evento evento) {
		return repositorio.save(evento);
	}

	@Override
	public void eliminarEvento(Evento evento) {
		repositorio.delete(evento);
	}

}
