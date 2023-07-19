package com.example.demo.respository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Hotel;
import com.example.demo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class TransferenciaRepoImpl implements ITransferenciaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void realizar(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

	@Override
	public List<Transferencia> seleccionarTodas() {
		// TODO Auto-generated method stub
		TypedQuery<Transferencia> myQuery=this.entityManager.createQuery("select t from Transferencia t",Transferencia.class);
		
		return myQuery.getResultList();
	}
	}


