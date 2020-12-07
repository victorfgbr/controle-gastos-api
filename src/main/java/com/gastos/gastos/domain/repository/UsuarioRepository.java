package com.gastos.gastos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastos.gastos.domain.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
