package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

}
