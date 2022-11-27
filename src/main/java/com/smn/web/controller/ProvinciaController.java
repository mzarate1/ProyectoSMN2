package com.smn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smn.web.model.Provincia;
import com.smn.web.service.ProvinciaServiceImpl;

@Controller
public class ProvinciaController {

	@Autowired
	private ProvinciaServiceImpl servicio;

	@GetMapping("/provincias")
	public String listarProvincias(Model modelo) {
		modelo.addAttribute("provincias", servicio.listarProvincias());
		return "provincias"; // nos retorna el archivo provincias
	}

	@GetMapping("/provincias/nuevo")
	public String mostrarFomularioProvincia(Model modelo) {
		Provincia provincia = new Provincia();
		modelo.addAttribute("provincia", provincia);
		return "crear_provincia";
	}

	@PostMapping("/provincias")
	public String guardarProvincia(@ModelAttribute("provincia") Provincia provincia) {
		servicio.guardarProvincia(provincia);
		return "redirect:/provincias";
	}

	@GetMapping("/provincias/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("provincia", servicio.obtenerProvinciaId(id));
		return "editar_provincia";
	}

	@PostMapping("/provincias/{id}")
	public String actualizarProvincia(@PathVariable Long id, @ModelAttribute("provincia") Provincia provincia,
			Model modelo) {
		Provincia provinciaExistente = servicio.obtenerProvinciaId(id);
		//provinciaExistente.setId_provincia(id);
		provinciaExistente.setNombre_provincia(provincia.getNombre_provincia());

		servicio.actualizarProvincia(provinciaExistente);
		return "redirect:/provincias";
	}

	@GetMapping("/provincias/{id}")
	public String eliminarProvincia(@PathVariable Long id) {
		servicio.eliminarProvincia(id);
		return "redirect:/provincias";
	}
	
	@ModelAttribute("allProvincias")
    public List<Provincia> getAllProvincias() {
        return this.servicio.listarProvincias();
    }
	
}
