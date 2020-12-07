package com.gastos.gastos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastos.gastos.domain.model.Usuario;
import com.gastos.gastos.domain.repository.UsuarioRepository;

@Service
public class UsuarioRegisterService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario register (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void unregister (Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario getOrFail (Long id) {
		return usuarioRepository.findById(id).orElseThrow();
	}
}
