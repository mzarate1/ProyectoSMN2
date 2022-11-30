package com.smn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smn.web.model.Usuarios;
import com.smn.web.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repositorio;
	
	@Override
	public List<Usuarios> listarUsuarios() {
		return repositorio.findAll();
	}
		
	
	@Override
	public Usuarios obtenerUsuarioId(Long id) {
		return repositorio.findById(id).get();
	}

}
