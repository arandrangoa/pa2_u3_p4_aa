package com.example.demo.respository;

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
public class HotelRepoImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		Hotel hotel = this.seleccionar(id);
		this.entityManager.remove(hotel);
	}

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// SELECT * FROM hotel h right join habitacion ha on h.hote_id =
		// ha.habi_id_hotel
		// SELECT h FROM Hotel h JOIN h.habitaciones ha
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha",
				Hotel.class);

		List<Hotel> listHoteles = myQuery.getResultList();
		// BAJO DEMANDA ES DECIR CON EL LAZY
		for (Hotel h : listHoteles) {
			h.getHabitaciones().size();
		}
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",
				Hotel.class);

		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha", Habitacion.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// SELECT * FROM hotel h, habitacion ha WHERE h.hote_id=ha.habi_id_hotel
		// SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel", Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

}
