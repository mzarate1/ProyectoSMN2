package com.smn.web.controller;

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.smn.web.model.Ciudad;
import com.smn.web.model.Pronostico;

public class PronosticoForm {
	
	private long id_pronostico;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Future(message = "Fecha solo puede ser futura")
	private Date fecha_pronostico;
	
	@PositiveOrZero(message = "Probabilidad de lluvia debe estar entre 0% a 100%")
	@Max(100)
	private int probabilidad_lluvia;

	@PositiveOrZero(message = "Cantidad de lluvia en mm debe ser 0 o superior")
	private int cant_lluvia;
	
	@Size(min=2, max=250)
	private String dsc_pronostico;
	
	@NotNull
	private Ciudad id_ciudad;
	
	public PronosticoForm() {
		super();
	}

	public long getId_pronostico() {
	return id_pronostico;
	}


	public void setId_pronostico(long id_pronostico) {
		this.id_pronostico = id_pronostico;
	}

	public void setId_ciudad(Ciudad id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public Ciudad getId_ciudad() {
		return id_ciudad;
	}

	public Date getFecha_pronostico() {
		return fecha_pronostico;
	}

	public void setFecha_pronostico(Date fecha_pronostico) {
		this.fecha_pronostico = fecha_pronostico;
	}

	public int getProbabilidad_lluvia() {
		return probabilidad_lluvia;
	}

	public void setProbabilidad_lluvia(int probabilidad_lluvia) {
		this.probabilidad_lluvia = probabilidad_lluvia;
	}

	public int getCant_lluvia() {
		return cant_lluvia;
	}

	public void setCant_lluvia(int cant_lluvia) {
		this.cant_lluvia = cant_lluvia;
	}

	public String getDsc_pronostico() {
		return dsc_pronostico;
	}

	public void setDsc_pronostico(String dsc_pronostico) {
		this.dsc_pronostico = dsc_pronostico;
	}

	public PronosticoForm(long id_pronostico, Date fecha_pronostico,int probabilidad_lluvia, int cant_lluvia, String dsc_pronostico, Ciudad id_ciudad) {
		super();
		this.id_pronostico = id_pronostico;
		this.fecha_pronostico = fecha_pronostico;
		this.probabilidad_lluvia = probabilidad_lluvia;
		this.cant_lluvia = cant_lluvia;
		this.dsc_pronostico = dsc_pronostico;
		this.id_ciudad = id_ciudad;
	}

	public Pronostico toModel() {
		
		Pronostico p = new Pronostico();
		p.setFecha_pronostico(this.getFecha_pronostico());
		p.setProbabilidad_lluvia(this.getProbabilidad_lluvia());
		p.setCant_lluvia(this.getCant_lluvia());
		p.setDsc_pronostico(this.getDsc_pronostico());
		p.setId_ciudad(this.getId_ciudad());
		return p;
	}


	


	
	
	
}
