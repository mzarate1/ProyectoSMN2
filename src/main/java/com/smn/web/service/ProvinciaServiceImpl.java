package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.Provincia;
import com.smn.web.repository.ProvinciaRepository;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	private ProvinciaRepository repositorio;

	@Override
	public List<Provincia> listarProvincias() {
		return repositorio.findAll();
	}

	@Override
	public Provincia guardarProvincia(Provincia provincia) {
		return repositorio.save(provincia);
	}

	@Override
	public Provincia obtenerProvinciaId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Provincia actualizarProvincia(Provincia provincia) {
		return repositorio.save(provincia);
	}

	@Override
	public void eliminarProvincia(Long id) {
		repositorio.deleteById(id);
	}

}
