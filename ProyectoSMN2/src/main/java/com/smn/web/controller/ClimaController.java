package com.smn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smn.web.model.Ciudad;
import com.smn.web.model.Clima;
import com.smn.web.model.EstadoClima;
import com.smn.web.service.CiudadServiceImpl;
import com.smn.web.service.ClimaServiceImpl;
import com.smn.web.service.EstadoClimaServiceImpl;

@Controller
public class ClimaController {
	
	@Autowired
	private ClimaServiceImpl servicioClima;
	
	@Autowired
	private EstadoClimaServiceImpl servicioEstadoClima;
	
	@Autowired
	private CiudadServiceImpl servicioCiudad;
	
	@GetMapping("/consultar_clima")
	public String listado_clima(Model modelo) {
		modelo.addAttribute("listado_clima", servicioClima.listarClimas());
		return "consultar_clima";
	}
			
	@ModelAttribute("allEstadoClimas")
	public List<EstadoClima> getAllEstadoClimas() {
        return this.servicioEstadoClima.listarEstadoClima();
    }
	
	@ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.servicioCiudad.listarCiudades();
    }
	
	@GetMapping("/clima/nuevo")
	public String mostrarFomularioClima(Model modelo) {
		Clima clima = new Clima ();
		modelo.addAttribute("clima", clima);
		return "crear_clima";
	}
	
	@PostMapping("/clima/agregar")
	public String guardarCiudad(@ModelAttribute("clima") Clima clima) {
		servicioClima.guardarClima(clima);
		return "redirect:/consultar_clima";
	}
	
	@GetMapping("/consultar_clima/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("clima", servicioClima.obtenerClimaId(id));
		return "editar_clima";
	}

	@PostMapping("/consultar_clima/{id}")
	public String actualizarClima(@PathVariable Long id, @ModelAttribute("clima") Clima clima, Model modelo) {
		Clima climaExistente = servicioClima.obtenerClimaId(id);
		climaExistente.setFecha(clima.getFecha());
		climaExistente.setTemperatura(clima.getTemperatura());
		climaExistente.setHumedad(clima.getHumedad());
		climaExistente.setId_estado(clima.getId_estado());
		climaExistente.setId_ciudad(clima.getId_ciudad());
		return "redirect:/consultar_clima";
	}

	@GetMapping("/consultar_clima/{id}")
	public String eliminarClima(@PathVariable Long id, @ModelAttribute("clima") Clima clima, Model modelo) {
		Clima climaExistente = servicioClima.obtenerClimaId(id);
		servicioClima.eliminarClima(climaExistente);
		return "redirect:/consultar_clima";
	}
	
}
