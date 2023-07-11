package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepoImpl implements IhotelRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// TODO Auto-generated method stub
		//select * from hotel h inner join habitacion ha on h.htl_id=ha.habi_id_hotel
		//select h from Hotel h join Habitacion h.habitaciones ha
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("select h from Hotel h join h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}

	

}
