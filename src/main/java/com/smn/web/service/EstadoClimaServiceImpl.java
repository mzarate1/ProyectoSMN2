package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.EstadoClima;
import com.smn.web.repository.EstadoClimaRepository;
/**
 * 
 * @author Kruger Lisandro
 *
 */
@Service
public class EstadoClimaServiceImpl implements EstadoClimaService {

	@Autowired
	private EstadoClimaRepository repositorio;

	@Override
	public List<EstadoClima> listarEstadoClima() {
		return repositorio.findAll();
	}

}
