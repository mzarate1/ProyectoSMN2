package com.smn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsutaClimaController {
	
	@GetMapping({"/ConsultarClima"})
	public String mostrarHome() {
		return "consultarClima";
	}
	
}
