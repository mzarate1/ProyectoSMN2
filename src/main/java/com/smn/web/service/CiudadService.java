package com.smn.web.service;

import java.util.List;

import com.smn.web.model.Ciudad;
/**
 * 
 * @author Kruger Lisandro
 *
 */
public interface CiudadService {
	
	public List<Ciudad> listarCiudades();
	
	public Ciudad guardarCiudad(Ciudad ciudad);
	
	public Ciudad obtenerCiudadId(Long id);
	
	public Ciudad actualizarCiudad(Ciudad ciudad);
	
	public void eliminarCiudad(Ciudad ciudad);
}
