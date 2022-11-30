package com.smn.web.service;

import java.util.List;

import com.smn.web.model.Usuarios;

public interface UsuarioService {
	
	public List<Usuarios> listarUsuarios();

	public Usuarios obtenerUsuarioId(Long id);
	
}
