package com.gastos.gastos.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gastos.gastos.domain.model.FiltroMes;

@Repository
public class FiltroMesRepositoryImpl implements FiltroMesRepository {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<FiltroMes> findAll() {
		
		String query = "select"
				+ " date_format(data_gasto, '%M, %Y') as nome,"
				+ " date_format(data_gasto, '%Y-%m') as valor"
				+ " from gasto"
				+ " group by nome"
				+ " order by valor desc;";
		
		return manager.createNativeQuery(query, FiltroMes.class).getResultList();
	}

}
