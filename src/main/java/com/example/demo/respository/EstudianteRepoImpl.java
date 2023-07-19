package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.seleccionarPorNumero(cedula);
		this.entityManager.remove(estudiante);
	}

	@Override
	public Estudiante seleccionarPorNumero(String cedula) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula= :datoCedula", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	
	
}
