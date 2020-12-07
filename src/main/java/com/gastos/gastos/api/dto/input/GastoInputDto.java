package com.gastos.gastos.api.dto.input;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class GastoInputDto {
	
	private String descricao;
	
	private BigDecimal valor;
	
	private LocalDate data;
}
