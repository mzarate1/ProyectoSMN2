package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.EstadoClima;
import com.smn.web.repository.EstadoClimaRepository;

@Service
public class EstadoClimaServiceImpl implements EstadoClimaService {

	@Autowired
	private EstadoClimaRepository repositorio;

	@Override
	public List<EstadoClima> listarEstadoClima() {
		return repositorio.findAll();
	}

	@Override
	public EstadoClima guardarEstadoClima(EstadoClima estadoClima) {
		return repositorio.save(estadoClima);
	}

	@Override
	public EstadoClima obtenerEstadoClimaId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public EstadoClima actualizarEstadoClima(EstadoClima estadoClima) {
		return repositorio.save(estadoClima);
	}

	@Override
	public void eliminarEstadoClima(EstadoClima estadoClima) {
		repositorio.delete(estadoClima);
	}

}
