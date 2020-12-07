package com.gastos.gastos.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class GastoDto {
	
	private Long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	private LocalDate data;
	
}
