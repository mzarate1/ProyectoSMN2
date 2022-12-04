package com.smn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smn.web.model.EstadoClima;
import com.smn.web.service.EstadoClimaServiceImpl;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Controller
public class EstadoClimaController {
	
	@Autowired
	private EstadoClimaServiceImpl servicioEstadoClima;
	
	public List<EstadoClima> getAllEstadoClimas() {
		return this.servicioEstadoClima.listarEstadoClima();
	}
}
