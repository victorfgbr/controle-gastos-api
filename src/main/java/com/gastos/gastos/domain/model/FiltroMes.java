package com.gastos.gastos.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FiltroMes {

	@Id
	private String valor;
	
	private String nome;

}
