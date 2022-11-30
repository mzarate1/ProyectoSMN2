package com.smn.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smn.web.model.Ciudad;
import com.smn.web.model.Pronostico;
import com.smn.web.service.CiudadService;
import com.smn.web.service.PronosticoService;

@Controller
@RequestMapping("/pronosticoBuscar")
public class PronosticoBuscarController {
	@Autowired
    private PronosticoService servicio;
	@Autowired
    private CiudadService servicioCiudad;
	
	
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	PronosticoBuscarForm form =  new PronosticoBuscarForm();
    	form.setIdCiudadSeleccionada(1L);
    	Date fechaactual = new Date();
    	form.setFechaactual(fechaactual);
    	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(fechaactual); 
	 	calendar.add(Calendar.DAY_OF_YEAR, 10);  
	 	form.setFechaextendida(calendar.getTime()); 
    	modelo.addAttribute("formBean",form);
    return "pronosticoBuscar";
    }
     
    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.servicioCiudad.listarCiudades();
    }
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean")  @Validated  PronosticoBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
         	
    	
    	if(action.equals("Buscar"))
    	{
    		try {
    			List<Pronostico> pronostico = servicio.filter(formBean);
            	modelo.addAttribute("resultados",pronostico);
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
        	modelo.addAttribute("formBean",formBean);
        	return "pronosticoBuscar";
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	
    	if(action.equals("Evento"))
    	{
    		return "redirect:/consultar_evento/{id}";
    	}
    		
    	return "redirect:/";
    	
    }
 
}
