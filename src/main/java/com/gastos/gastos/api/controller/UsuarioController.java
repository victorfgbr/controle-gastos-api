package com.gastos.gastos.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gastos.gastos.api.dto.UsuarioDto;
import com.gastos.gastos.api.dto.input.UsuarioInputDto;
import com.gastos.gastos.domain.model.Usuario;
import com.gastos.gastos.domain.repository.UsuarioRepository;
import com.gastos.gastos.domain.service.UsuarioRegisterService;

@RestController
@RequestMapping(value="/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	private UsuarioRegisterService usuarioRegister;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioDto> listar () {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return usuarios.stream()
			.map((usuario) -> modelMapper.map(usuario, UsuarioDto.class))
			.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public UsuarioDto detalhar (@PathVariable Long id) {
		return modelMapper.map(usuarioRegister.getOrFail(id), UsuarioDto.class);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDto salvar (@RequestBody UsuarioInputDto usuarioInput) {
		Usuario usuario = modelMapper.map(usuarioInput, Usuario.class); 
		
		usuario = usuarioRegister.register(usuario);
		
		return modelMapper.map(usuario, UsuarioDto.class); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir (@PathVariable Long id) {
		usuarioRegister.unregister(id);
	}
	
}
