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
import com.smn.web.model.Pronostico;
import com.smn.web.service.CiudadServiceImpl;
import com.smn.web.service.PronosticoServiceImpl;


@Controller
public class PronosticoController {
	
	@Autowired
	private PronosticoServiceImpl servicioPronostico;
	
	@Autowired
	private CiudadServiceImpl servicioCiudad;
	
	@GetMapping("/consultar_pronostico")
	public String listado_pronostico(Model modelo) {
		modelo.addAttribute("listado_pronostico",servicioPronostico.listarPronosticos());
		return "consultar_clima";
	}
			
	
	@ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.servicioCiudad.listarCiudades();
    }
	
	@GetMapping("/consultar_pronostico")
	public String mostrarFomularioPronostico(Model modelo) {
		Pronostico pronostico = new Pronostico();
		modelo.addAttribute("pronostico", pronostico);
		return "crear_pronostico";
	}
	
	@PostMapping("/pronostico/agregar")
	public String guardarCiudad(@ModelAttribute("pronostico") Pronostico pronostico) {
		servicioPronostico.guardarPronostico(pronostico);
		return "redirect:/consultar_pronostico";
	}
	
	@GetMapping("/consultar_pronostico/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("pronostico", servicioPronostico.obtenerPronosticoId(id));
		return "editar_pronostico";
	}

	@PostMapping("/consultar_pronostico/{id}")
	public String actualizarpronostico(@PathVariable Long id, @ModelAttribute("pronostico") Pronostico pronostico, Model modelo) {
		Pronostico pronoExistente = servicioPronostico.obtenerPronosticoId(id);
		pronoExistente.setFechapronostico(pronostico.getFechapronostico());
		pronoExistente.setprobabilidadLluvia(pronostico.getprobabilidadLluvia());
		pronoExistente.setcantLluvia(pronostico.getcantLluvia());
		pronoExistente.setdscPronostico(pronostico.getdscPronostico());
		pronoExistente.setId_ciudad(pronostico.getId_ciudad());
		return "redirect:/consultar_pronostico";
	}

	@GetMapping("/consultar_pronostico/{id}")
	public String eliminarPronostico(@PathVariable Long id, @ModelAttribute("pronostico") Pronostico pronostico, Model modelo) {
		Pronostico pronoExistente = servicioPronostico.obtenerPronosticoId(id);
		servicioPronostico.eliminarPronostico(pronoExistente);
		return "redirect:/consultar_pronostico";
	}
	
}
