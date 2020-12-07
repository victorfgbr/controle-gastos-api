package com.gastos.gastos.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastos.gastos.domain.model.Gasto;


public interface GastoRepository extends JpaRepository<Gasto, Long> {
	List<Gasto> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}
