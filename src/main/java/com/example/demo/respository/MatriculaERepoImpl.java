package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Matricula;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaERepoImpl implements IMatriculaERepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertarMatricula(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	public Matricula buscarPorEstudiante(Estudiante estudiante) {
		TypedQuery<Matricula> myQuery = this.entityManager.createQuery("SELECT h FROM Matricula h, Estudiante ha WHERE h = ha.matriculas",
				Matricula.class);

		return myQuery.getSingleResult();
	}

}
