package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.Clima;
import com.smn.web.repository.ClimaRepository;

@Service
public class ClimaServiceImpl implements ClimaService{
	
	@Autowired
	ClimaRepository repositorio;
	
	@Override
	public List<Clima> listarClimas() {
		return repositorio.findAll();
	}

	@Override
	public Clima guardarClima(Clima clima) {
		return repositorio.save(clima);
	}

	@Override
	public Clima obtenerClimaId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Clima actualizarClima(Clima clima) {
		return repositorio.save(clima);
	}

	@Override
	public void eliminarClima(Clima clima) {
		repositorio.delete(clima);
	}

}
