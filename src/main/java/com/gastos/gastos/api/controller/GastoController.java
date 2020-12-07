package com.gastos.gastos.api.controller;

import java.time.LocalDate;
import java.time.YearMonth;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gastos.gastos.api.dto.GastoDto;
import com.gastos.gastos.api.dto.input.GastoInputDto;
import com.gastos.gastos.domain.model.Gasto;
import com.gastos.gastos.domain.repository.GastoRepository;
import com.gastos.gastos.domain.service.GastoRegisterService;

@RestController
@RequestMapping(value="/gastos")
@CrossOrigin(origins = "http://localhost:3000")
public class GastoController {
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	private GastoRegisterService gastoRegister;
	
	@Autowired
	private GastoRepository gastoRepository;
	
	@GetMapping
	public List<GastoDto> listar (@RequestParam int ano, @RequestParam int mes) {
		LocalDate dataInicial = LocalDate.of(ano, mes, 1);
		LocalDate dataFinal = YearMonth.of(ano, mes).atEndOfMonth();
		
		List<Gasto> gastos = gastoRepository.findByDataBetween(dataInicial, dataFinal);
		
		return gastos.stream()
			.map((gasto) -> modelMapper.map(gasto, GastoDto.class))
			.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public GastoDto detalhar (@PathVariable Long id) {
		return modelMapper.map(gastoRegister.getOrFail(id), GastoDto.class);
	}

	@PostMapping
	public GastoDto salvar (@RequestBody GastoInputDto gastoInput) {
		Gasto gasto = modelMapper.map(gastoInput, Gasto.class); 
		
		gasto = gastoRegister.register(gasto);
		
		return modelMapper.map(gasto, GastoDto.class); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir (@PathVariable Long id) {
		gastoRegister.unregister(id);
	}
	
}
