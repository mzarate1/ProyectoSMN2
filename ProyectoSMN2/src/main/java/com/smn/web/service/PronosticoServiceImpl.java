package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.controller.PronosticoBuscarForm;
import com.smn.web.model.Pronostico;
import com.smn.web.repository.PronosticoRepository;
import com.tsti.smn.excepciones.Excepcion;


@Service
public class PronosticoServiceImpl implements PronosticoService {
	
	@Autowired
	PronosticoRepository repositorio;
	
	@Override
	public List<Pronostico> listarPronosticos() {
		return repositorio.findAll();
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
	@Override
	public List<Pronostico> filter(PronosticoBuscarForm filter) throws Exception {
		if( filter.getIdCiudadSeleccionada()==null)
			throw new Excepcion("Es necesario ingresar una ciudad");
		else
			return repositorio.findByIdCiudadFecha(filter.getIdCiudadSeleccionada(),filter.getFechaactual(),filter.getFechaextendida());
	}

}
