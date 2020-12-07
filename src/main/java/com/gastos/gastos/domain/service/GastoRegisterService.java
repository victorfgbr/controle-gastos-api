package com.gastos.gastos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gastos.gastos.domain.model.Gasto;
import com.gastos.gastos.domain.repository.GastoRepository;

@Service
public class GastoRegisterService {

	@Autowired
	private GastoRepository gastoRepository;
	
	public Gasto register (Gasto gasto) {
		return gastoRepository.save(gasto);
	}
	
	public void unregister (Long id) {
		gastoRepository.deleteById(id);
	}
	
	public Gasto getOrFail (Long id) {
		return gastoRepository.findById(id).orElseThrow();
	}
}
