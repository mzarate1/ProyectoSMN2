package com.smn.web.controller;

//import java.time.LocalDate;
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
	modelo.addAttribute("listado_pronostico", servicioPronostico.listarPronosticos());
		//LocalDate date = LocalDate.now();
		//modelo.addAttribute("listado_pronostico", servicioPronostico.listarPronosticosFecha(date));
		return "consultar_pronostico";
	}
	
	@ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.servicioCiudad.listarCiudades();
    }
	
	@GetMapping("/pronostico/nuevo")
	public String mostrarFomularioPronostico(Model modelo) {
		PronosticoForm pronosticoForm = new PronosticoForm();
		modelo.addAttribute("pronosticoForm", pronosticoForm);
		return "crear_pronostico";
	}
	@PostMapping("/pronostico/agregar") 
	public String guardarPronostico (@Valid PronosticoForm pronosticoForm, BindingResult result, Model modelo) {

		if (result.hasErrors()) {
			modelo.addAttribute("pronosticoForm", pronosticoForm);
			System.out.println("Hubo errores");
			return "crear_pronostico";
		}
		
		Pronostico pronostico = pronosticoForm.toModel();
		servicioPronostico.guardarPronostico(pronostico);
		
		return "redirect:/consultar_pronostico";
	}
	
	@GetMapping("/consultar_pronostico/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("pronosticoForm", servicioPronostico.obtenerPronosticoId(id));
		return "editar_pronostico";
	}

	@PostMapping("/consultar_pronostico/{id}")
	public String actualizarPronostico(@PathVariable Long id, @Valid @ModelAttribute("pronosticoForm") PronosticoForm pronosticoForm, BindingResult result, Model modelo) {
		Pronostico pronosticoExistente = servicioPronostico.obtenerPronosticoId(id);

		if (result.hasErrors()) {
			modelo.addAttribute("pronosticoForm", pronosticoExistente);
			System.out.println("Hubo errores");
			return "editar_pronostico";
		}							 
		pronosticoExistente.setFecha_pronostico(pronosticoForm.getFecha_pronostico());
		pronosticoExistente.setProbabilidad_lluvia(pronosticoForm.getProbabilidad_lluvia());
		pronosticoExistente.setCant_lluvia(pronosticoForm.getCant_lluvia());
		pronosticoExistente.setDsc_pronostico(pronosticoForm.getDsc_pronostico());
		pronosticoExistente.setId_ciudad(pronosticoForm.getId_ciudad());
		servicioPronostico.actualizarPronostico(pronosticoExistente);

		return "redirect:/consultar_pronostico";
	}
}
