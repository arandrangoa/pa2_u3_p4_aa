package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.MatriculaV;
import com.example.demo.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarMatricula(MatriculaV matricula) {
		this.entityManager.persist(matricula);
		
	}

	@Override
	public int eliminarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MatriculaV> seleccionarInnerJoin() {
		TypedQuery<MatriculaV> myQuery = this.entityManager.createQuery("SELECT v FROM MatriculaV v INNER JOIN v.vehiculo ma",
				MatriculaV.class);
		return myQuery.getResultList();
	}

	@Override
	public List<MatriculaV> seleccionarOuterRightJoin() {
		TypedQuery<MatriculaV> myQuery = this.entityManager.createQuery("SELECT h FROM MatriculaV h RIGHT JOIN h.vehiculo ha",
				MatriculaV.class);

		
		return myQuery.getResultList();
	}

	@Override
	public List<MatriculaV> seleccionarOuterLeftJoin() {
		TypedQuery<MatriculaV> myQuery = this.entityManager.createQuery("SELECT h FROM MatriculaV h LEFT JOIN h.vehiculo ha",
				MatriculaV.class);

		return myQuery.getResultList();
	}
	

	@Override
	public List<MatriculaV> seleccionarOuterFullJoin() {
		TypedQuery<MatriculaV> myQuery = this.entityManager.createQuery("SELECT h FROM MatriculaV h FULL JOIN h.vehiculo ha",
				MatriculaV.class);

		return myQuery.getResultList();
	}

	@Override
	public List<MatriculaV> seleccionarWhereJoin() {
		TypedQuery<MatriculaV> myQuery = this.entityManager
				.createQuery("SELECT h FROM MatriculaV h, Vehiculo ha WHERE ha = h.vehiculo", MatriculaV.class);

		return myQuery.getResultList();
	}

	@Override
	public List<MatriculaV> seleccionarFetchJoin() {
		TypedQuery<MatriculaV> myQuery = this.entityManager.createQuery("SELECT h FROM MatriculaV h JOIN FETCH h.vehiculo ha",
				MatriculaV.class);

		return myQuery.getResultList();
	}
	
	

	
}
