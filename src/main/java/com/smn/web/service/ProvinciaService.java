package com.smn.web.service;

import java.util.List;

import com.smn.web.model.Provincia;
/**
 * 
 * @author Kruger Lisandro
 *
 */
public interface ProvinciaService {

	public List<Provincia> listarProvincias();
	
	public Provincia guardarProvincia(Provincia provincia);
	
	public Provincia obtenerProvinciaId(Long id);
	
	public Provincia actualizarProvincia(Provincia provincia);
	
	public void eliminarProvincia(Provincia provincia);
	
}
