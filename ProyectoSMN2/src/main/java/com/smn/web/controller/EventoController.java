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
import com.smn.web.model.Evento;
import com.smn.web.service.CiudadServiceImpl;
import com.smn.web.service.EventoServiceImpl;


@Controller
public class EventoController {
	
	@Autowired
	private EventoServiceImpl servicioEvento;
	
	@Autowired
	private CiudadServiceImpl servicioCiudad;
	
	@GetMapping("/consultar_evento")
	public String listado_evento(Model modelo) {
		modelo.addAttribute("listado_evento",servicioEvento.listarEvento());
		return "consultar_evento";
	}
			
	
	@ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.servicioCiudad.listarCiudades();
    }
	
	@GetMapping("/evento/nuevo")
	public String mostrarFomularioEvento(Model modelo) {
		Evento evento = new Evento();
		modelo.addAttribute("evento", evento);
		return "crear_evento";
	}
	
	@PostMapping("/evento/agregar")
	public String guardarCiudad(@ModelAttribute("evento") Evento evento) {
		servicioEvento.guardarEvento(evento);
		return "redirect:/consultar_evento";
	}
	
	@GetMapping("/consultar_evento/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("evento", servicioEvento.obtenerEventoId(id));
		return "editar_evento";
	}

	@PostMapping("/consultar_evento/{id}")
	public String actualizarevento(@PathVariable Long id, @ModelAttribute("evento") Evento evento, Model modelo) {
		Evento eventoExistente = servicioEvento.obtenerEventoId(id);
		eventoExistente.setFechaevento(evento.getFechaevento());
		eventoExistente.setdscEvento(evento.getdscEvento());
		eventoExistente.setId_ciudad(evento.getId_ciudad());
		return "redirect:/consultar_evento";
	}

	@GetMapping("/consultar_evento/{id}")
	public String eliminarEvento(@PathVariable Long id, @ModelAttribute("evento") Evento evento, Model modelo) {
		Evento eventoExistente = servicioEvento.obtenerEventoId(id);
		servicioEvento.eliminarEvento(eventoExistente);
		return "redirect:/consultar_evento";
	}
	
}
