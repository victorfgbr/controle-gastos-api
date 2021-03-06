package com.gastos.gastos.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Gasto {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	@Column (name = "data_gasto")
	private LocalDate data;
	
	@ManyToMany
	@JoinTable(name = "gastos_usuarios",
				joinColumns = @JoinColumn(name = "gasto_id"),
				inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Usuario> usuarios = new ArrayList<>(); 
 
}
