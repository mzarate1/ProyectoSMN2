package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.Ciudad;
import com.smn.web.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService{
	
	@Autowired
	private CiudadRepository repositorio;

	@Override
	public List<Ciudad> listarCiudades() {
		return repositorio.findAll();
	}

	@Override
	public Ciudad guardarCiudad(Ciudad ciudad) {
		return repositorio.save(ciudad);
	}

	@Override
	public Ciudad obtenerCiudadId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Ciudad actualizarCiudad(Ciudad ciudad) {
		return repositorio.save(ciudad);
	}

	@Override
	public void eliminarCiudad(Ciudad ciudad) {
		repositorio.delete(ciudad);
	}

}
