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
import com.smn.web.model.Provincia;
import com.smn.web.service.CiudadServiceImpl;
import com.smn.web.service.ProvinciaServiceImpl;

@Controller
public class ProvinciaController {

	@Autowired
	private ProvinciaServiceImpl servicio;
	
	@Autowired
	private CiudadServiceImpl servicioCiudad;

	@GetMapping("/provincias")
	public String listarProvincias(Model modelo) {
		modelo.addAttribute("provincias", servicio.listarProvincias());
		return "provincias";
	}
	
	@ModelAttribute("allProvincias")
	public List<Provincia> getAllProvincias() {
		return this.servicio.listarProvincias();
	}

	@GetMapping("/provincias/nuevo")
	public String mostrarFomularioProvincia(Model modelo) {
		Provincia provincia = new Provincia();
		modelo.addAttribute("provincia", provincia);
		return "crear_provincia";
	}

	@PostMapping("/provincia/agregar")
	public String guardarProvincia(@Valid @ModelAttribute("provincia") Provincia provincia, BindingResult result,
			Model modelo) {

		if (result.hasErrors()) 
		{
			modelo.addAttribute("provincia", provincia);
			System.out.println("Hubo errores");
			return "crear_provincia";
		}

		try 
		{
			provincia.setNombre_provincia(provincia.getNombre_provincia().toUpperCase());
			servicio.guardarProvincia(provincia);
			return "redirect:/provincias";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

	@GetMapping("/provincias/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("provincia", servicio.obtenerProvinciaId(id));
		return "editar_provincia";
	}

	@PostMapping("/provincias/{id}")
	public String actualizarProvincia(@PathVariable Long id, @Valid @ModelAttribute("provincia") Provincia provincia, BindingResult result, Model modelo) {
		Provincia provinciaExistente = servicio.obtenerProvinciaId(id);

		if (result.hasErrors()) 
		{
			modelo.addAttribute("provincia", provinciaExistente);
			System.out.println("Hubo errores");
			return "editar_provincia";
		}

		try 
		{
			provinciaExistente.setNombre_provincia(provincia.getNombre_provincia().toUpperCase());
			servicio.actualizarProvincia(provinciaExistente);
			return "redirect:/provincias";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

	@GetMapping("/provincias/{id}")
	public String eliminarProvincia(@PathVariable Long id) {
		
		List<Ciudad> listaCiudades = servicioCiudad.listarCiudades();
		
		for (Ciudad ciudad : listaCiudades) 
		{	
			if(ciudad.getProvincia().getId_provincia() == id)
			{
				servicioCiudad.eliminarCiudad(ciudad);
			}
		}
		
		try 
		{
			Provincia provinciaExistente = servicio.obtenerProvinciaId(id);
			servicio.eliminarProvincia(provinciaExistente);
			return "redirect:/provincias";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

}
