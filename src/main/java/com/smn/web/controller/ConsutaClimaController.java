package com.smn.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class ConsutaClimaController {

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
		ClimaForm climaForm = new ClimaForm();
		modelo.addAttribute("climaForm", climaForm);
		return "crear_clima"; 
	}

	@PostMapping("/clima/agregar")
	public String guardarCiudad(@Valid @ModelAttribute("climaForm") ClimaForm climaForm, BindingResult result, Model modelo) {

		if (result.hasErrors()) {
			modelo.addAttribute("climaForm", climaForm);
			System.out.println("Hubo errores");
			return "crear_clima";
		}
		
		Clima clima = climaForm.toModel();
		servicioClima.guardarClima(clima);
		
		return "redirect:/consultar_clima";
	}

	@GetMapping("/consultar_clima/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("climaForm", servicioClima.obtenerClimaId(id));
		return "editar_clima";
	}

	@PostMapping("/consultar_clima/{id}")
	public String actualizarClima(@PathVariable Long id, @Valid @ModelAttribute("climaForm") ClimaForm climaForm, BindingResult result, Model modelo) {
		Clima climaExistente = servicioClima.obtenerClimaId(id);

		if (result.hasErrors()) {
			// modelo.addAttribute("clima",  clima); Valida con mensajes pero luego aparece un Error de metodo incompatible 
			modelo.addAttribute("climaForm", climaExistente);
			System.out.println("Hubo errores");
			return "editar_clima";
		}

		climaExistente.setFecha(climaForm.getFecha());
		climaExistente.setTemperatura(climaForm.getTemperatura());
		climaExistente.setHumedad(climaForm.getHumedad());
		climaExistente.setId_estado(climaForm.getId_estado());
		climaExistente.setId_ciudad(climaForm.getId_ciudad());
		servicioClima.actualizarClima(climaExistente);

		return "redirect:/consultar_clima";
	}

	@GetMapping("/consultar_clima/{id}")
	public String eliminarClima(@PathVariable Long id, @ModelAttribute("clima") Clima clima, Model modelo) {
		Clima climaExistente = servicioClima.obtenerClimaId(id);
		servicioClima.eliminarClima(climaExistente);
		return "redirect:/consultar_clima";
	}

}
