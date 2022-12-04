package com.smn.web.service;

import java.time.LocalDate;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;

import com.smn.web.controller.PronosticoBuscarForm;
import com.smn.web.model.Pronostico;


public interface PronosticoService {
	
	public List<Pronostico> listarPronosticos();
	
	public Pronostico guardarPronostico(Pronostico pronostico);
	
	public Pronostico obtenerPronosticoId(long id);
	
	public Pronostico actualizarPronostico(Pronostico pronostico);
	
	public void eliminarPronostico(Pronostico pronostico);
	
	public List<Pronostico> listarPronosticosFecha(LocalDate date);

	public List<Pronostico> filter(PronosticoBuscarForm formBean);

}
