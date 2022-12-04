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
import com.smn.web.model.Provincia;
import com.smn.web.service.CiudadServiceImpl;
import com.smn.web.service.ClimaServiceImpl;
import com.smn.web.service.ProvinciaServiceImpl;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Controller
public class CiudadController {

	@Autowired
	private CiudadServiceImpl servicio;

	@Autowired
	private ProvinciaServiceImpl servicioProvincia;
	
	@Autowired
	private ClimaServiceImpl servicioClima;

	@GetMapping("/ciudades")
	public String listarCiudades(Model modelo) {
		modelo.addAttribute("ciudades", servicio.listarCiudades());
		return "ciudades";
	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return this.servicio.listarCiudades();
	}

	@ModelAttribute("allProvincias")
	public List<Provincia> getAllProvincias() {
		return this.servicioProvincia.listarProvincias();
	}

	@GetMapping("/ciudad/nuevo")
	public String mostrarFomularioCiudad(Model modelo) {
		CiudadForm ciudadForm = new CiudadForm();
		modelo.addAttribute("ciudadForm", ciudadForm);
		return "crear_ciudad";
	}

	@PostMapping("/ciudad/agregar")
	public String guardarCiudad(@Valid @ModelAttribute("ciudadForm") CiudadForm ciudadForm, BindingResult result, Model modelo) {

		if (result.hasErrors()) 
		{
			modelo.addAttribute("ciudadForm", ciudadForm);
			System.out.println("Hubo errores");
			return "crear_ciudad";
		}
		try 
		{
			//ciudad.setNombre_ciudad(ciudad.getNombre_ciudad().toLowerCase());
			Ciudad ciudad = ciudadForm.toModel(); 
			servicio.guardarCiudad(ciudad);
			return "redirect:/ciudades";
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

	@GetMapping("/ciudades/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("ciudadForm", servicio.obtenerCiudadId(id));
		return "editar_ciudad";
	}

	@PostMapping("/ciudades/{id}")
	public String actualizarCiudad(@PathVariable Long id, @Valid @ModelAttribute("ciudadForm") CiudadForm ciudadForm, BindingResult result, Model modelo) {
		Ciudad ciudadExistente = servicio.obtenerCiudadId(id);

		if (result.hasErrors()) 
		{
			//modelo.addAttribute("ciudadForm", ciudadForm);
			modelo.addAttribute("ciudadForm", ciudadExistente);
			System.out.println("Hubo errores");
			return "editar_ciudad";
		}

		try 
		{
			ciudadExistente.setNombre_ciudad(ciudadForm.getNombre_ciudad());
			ciudadExistente.setProvincia(ciudadForm.getProvincia());
			servicio.actualizarCiudad(ciudadExistente);
			return "redirect:/ciudades";
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

	@GetMapping("/ciudades/{id}")
	public String eliminarCiudad(@PathVariable Long id, @ModelAttribute("ciudad") Ciudad ciudad, Model modelo) {
		
		List<Clima> listaClima = servicioClima.listarClimas();
		
		for (Clima clima : listaClima) 
		{
			if(clima.getCiudad().getId_ciudad() == id) 
			{
				servicioClima.eliminarClima(clima);
			}
		}
		
		try 
		{
			Ciudad ciudadExistente = servicio.obtenerCiudadId(id);
			servicio.eliminarCiudad(ciudadExistente);
			return "redirect:/ciudades";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

}