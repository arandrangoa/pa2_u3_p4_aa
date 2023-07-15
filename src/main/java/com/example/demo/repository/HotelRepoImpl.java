package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitacion;
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
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("select h from Hotel h inner join h.habitaciones ha",Hotel.class);
		List<Hotel> listaHoteles=myQuery.getResultList();
		for(Hotel h:listaHoteles) {
			h.getHabitaciones().size();
		}
		return listaHoteles;
		
		//select f from Factura f join f.detalles de
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		// TODO Auto-generated method stub
		
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("select h from Hotel h right join h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("select h from Hotel h left join h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery=this.entityManager.createQuery("select ha from Hotel h left join h.habitaciones ha",Habitacion.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFullOuterJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("select h from Hotel h full join h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// TODO Auto-generated method stub
		//select h.* from hotel h, habitacion ha where h.htl_id=ha.habi_id_hotel
		//select h from Hotel h, habitacion ha where h=ha.hotel
		
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("select h from Hotel h, Habitacion ha where h=ha.hotel",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("select h from Hotel h join fetch h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	

}
