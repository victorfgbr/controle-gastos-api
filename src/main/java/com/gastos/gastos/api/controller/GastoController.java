package com.gastos.gastos.api.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

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

import com.gastos.gastos.domain.model.Gasto;
import com.gastos.gastos.domain.repository.GastoRepository;
import com.gastos.gastos.domain.service.GastoRegisterService;

@RestController
@RequestMapping(value="/gasto")
@CrossOrigin(origins = "http://localhost:3000")
public class GastoController {
	
	@Autowired
	private GastoRegisterService gastoRegister;
	
	@Autowired
	private GastoRepository gastoRepository;
	
	@GetMapping
	public List<Gasto> listar (@RequestParam int ano, @RequestParam int mes) {
		LocalDate dataInicial = LocalDate.of(ano, mes, 1);
		LocalDate dataFinal = YearMonth.of(ano, mes).atEndOfMonth();
		return gastoRepository.findByDataBetween(dataInicial, dataFinal);
	}
	
	@GetMapping("/{id}")
	public Gasto detalhar (@PathVariable Long id) {
		return gastoRegister.getOrFail(id);
	}

	@PostMapping
	public Gasto salvar (@RequestBody Gasto gasto) {
		return gastoRegister.register(gasto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir (@PathVariable Long id) {
		System.out.println("excluir gasto " + id);
		gastoRegister.unregister(id);
	}
	
}
