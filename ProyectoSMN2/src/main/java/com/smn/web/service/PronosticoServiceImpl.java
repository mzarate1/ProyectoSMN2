package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.Pronostico;
import com.smn.web.repository.PronosticoRepository;


@Service
public class PronosticoServiceImpl implements PronosticoService {
	
	@Autowired
	PronosticoRepository repositorio;
	
	@Override
	public List<Pronostico> listarPronosticos() {
		return repositorio.findAll();
	}
	
	@Override
	public List <Pronostico> listarCiudadPronostico(Long IdCiudadSeleccionada) {
		return repositorio.findByIdCiudad(IdCiudadSeleccionada);
	}

	@Override
	public Pronostico guardarPronostico(Pronostico pronostico) {
		return repositorio.save(pronostico);
	}

	@Override
	public Pronostico obtenerPronosticoId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Pronostico actualizarPronostico (Pronostico pronostico) {
		return repositorio.save(pronostico);
	}

	@Override
	public void eliminarPronostico(Pronostico pronostico) {
		repositorio.delete(pronostico);
	}

}
