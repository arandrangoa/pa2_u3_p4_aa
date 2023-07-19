package com.example.demo.respository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Hotel;
import com.example.demo.modelo.MatriculaV;
import com.example.demo.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepoImpl implements IVehiculoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void insertarVehiculo(Vehiculo vehiculo) {
	this.entityManager.persist(vehiculo);
		
	}


	@Override
	public int eliminarPorPlaca(String placa) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Vehiculo e WHERE e.placa = :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		myQuery.executeUpdate();
		return myQuery.executeUpdate();
		
	}


	@Override
	public int actualizarPorAnio(String modelo, String anio) {
		Query myQuery = this.entityManager.createQuery("UPDATE Vehiculo e SET e.modelo = :datoModelo WHERE e.anio = :datoAnio");
		myQuery.setParameter("datoModelo", modelo);
		myQuery.setParameter("datoAnio", anio);
		
		return myQuery.executeUpdate();
	}


	@Override
	public List<Vehiculo> seleccionarInnerJoin() {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v INNER JOIN v.matriculaV ma",
				Vehiculo.class);
		return myQuery.getResultList();
	}


	@Override
	public List<Vehiculo> seleccionarOuterRightJoin() {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT h FROM Vehiculo h RIGHT JOIN h.matriculaV ha",
				Vehiculo.class);		
		return myQuery.getResultList();
	}


	@Override
	public List<Vehiculo> seleccionarOuterLeftJoin() {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT h FROM Vehiculo h LEFT JOIN h.matriculaV ha",
				Vehiculo.class);

		return myQuery.getResultList();
	}


	@Override
	public List<Vehiculo> seleccionarOuterFullJoin() {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT h FROM Vehiculo h FULL JOIN h.matriculaV ha",
				Vehiculo.class);

		return myQuery.getResultList();
	}


	@Override
	public List<Vehiculo> seleccionarWhereJoin() {
		TypedQuery<Vehiculo> myQuery = this.entityManager
				.createQuery("SELECT h FROM Vehiculo h, MatriculaV ha WHERE ha = h.matriculaV", Vehiculo.class);

		return myQuery.getResultList();
	}


	@Override
	public List<Vehiculo> seleccionarFetchJoin() {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT h FROM Vehiculo h JOIN FETCH h.matriculaV ha",
				Vehiculo.class);

		return myQuery.getResultList();
	}


	
	
	

}
