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
import com.smn.web.model.Provincia;
import com.smn.web.service.CiudadServiceImpl;
import com.smn.web.service.ProvinciaServiceImpl;

@Controller
public class CiudadController {

	@Autowired
	private CiudadServiceImpl servicio;
	
	@Autowired
    private ProvinciaServiceImpl servicioProvincia;

	@GetMapping("/ciudades")
	public String listarCiudades(Model modelo) {
		modelo.addAttribute("ciudades", servicio.listarCiudades());
		return "ciudades"; // nos retorna el archivo provincias
	}
		
	@GetMapping("/ciudades/nuevo")
	public String mostrarFomularioCiudad(Model modelo) {
		Ciudad ciudad = new Ciudad ();
		modelo.addAttribute("ciudades", ciudad);
		return "crear_ciudad";
	}
	
	@ModelAttribute("allProvincias")
    public List<Provincia> getAllProvincias() {
        return this.servicioProvincia.listarProvincias();
    }
	
	
	@PostMapping("/ciudades")
	public String guardarCiudad(@ModelAttribute("ciudad") Ciudad ciudad) {
		servicio.guardarCiudad(ciudad);
		return "redirect:/ciudades";
	}
	
	
	@GetMapping("/ciudades/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("ciudad", servicio.obtenerCiudadId(id));
		return "editar_ciudad";
	}

	@PostMapping("/ciudades/{id}")
	public String actualizarCiudad(@PathVariable Long id, @ModelAttribute("ciudad") Ciudad ciudad, Model modelo) {
		Ciudad ciudadExistente = servicio.obtenerCiudadId(id);
		ciudadExistente.setNombre_ciudad(ciudad.getNombre_ciudad());
		ciudadExistente.setId_provincia(ciudad.getId_provincia());
		servicio.actualizarCiudad(ciudadExistente);
		return "redirect:/ciudades";
	}

	@GetMapping("/ciudades/{id}")
	public String eliminarCiudad(@PathVariable Long id, @ModelAttribute("ciudad") Ciudad ciudad, Model modelo) {
		Ciudad ciudadExistente = servicio.obtenerCiudadId(id);
		servicio.eliminarCiudad(ciudadExistente);
		return "redirect:/ciudades";
	}
	
}