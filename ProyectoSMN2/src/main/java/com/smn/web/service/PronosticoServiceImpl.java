package com.smn.web.service;

import java.time.LocalDate;
//import java.time.LocalDate;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.controller.PronosticoBuscarForm;
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
	public List<Pronostico> listarPronosticosFecha(LocalDate date) {
		return repositorio.findByFecha(date);
	}


	@Override
	public Pronostico guardarPronostico(Pronostico pronostico) {
		return repositorio.save(pronostico);
	}

	@Override
	public Pronostico obtenerPronosticoId(long id_pronostico) {
		return repositorio.findById(id_pronostico).get();
	}

	@Override
	public Pronostico actualizarPronostico (Pronostico pronostico) {
		return repositorio.save(pronostico);
	}

	@Override
	public void eliminarPronostico(Pronostico pronostico) {
		repositorio.delete(pronostico);
	}
	
	public List<Pronostico> filter(PronosticoBuscarForm filter) {
	return repositorio.findByFilter(filter.getIdCiudadSeleccionada(),filter.getFechaactual(),filter.getFechaextendida());
	}

}
