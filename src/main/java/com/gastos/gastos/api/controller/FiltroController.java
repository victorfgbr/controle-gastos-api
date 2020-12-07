package com.gastos.gastos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gastos.gastos.domain.model.FiltroMes;
import com.gastos.gastos.domain.repository.FiltroMesRepository;

@RestController
@RequestMapping(value="/filtros")
public class FiltroController {
	
	@Autowired
	private FiltroMesRepository filtroMesRepository;
	
	@GetMapping("/meses")
	public List<FiltroMes> listarMeses () {
		return filtroMesRepository.findAll();
	}
}

