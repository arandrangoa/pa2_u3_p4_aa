package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitacion;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepoImpl implements IHabitacionRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
	}

	@Override
	public Habitacion buscar(Habitacion id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void elminar(Habitacion id) {
		// TODO Auto-generated method stub
		Habitacion habi=this.buscar(id);
		this.entityManager.remove(habi);
	}




}
