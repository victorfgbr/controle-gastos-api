package com.gastos.gastos.domain.repository;

import java.util.List;

import com.gastos.gastos.domain.model.FiltroMes;

public interface FiltroMesRepository {

	List<FiltroMes> findAll ();
	
}
