package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.respository.IHotelRepository;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository;
	
	
	@Override
	public void crear(Hotel hotel) {
		// TODO Auto-generated method stub
		List<Habitacion> habitaciones = hotel.getHabitaciones();
		for(Habitacion h : habitaciones) {
			h.setValorIncluido(h.getValor().multiply(new BigDecimal(1.12)));
		}
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.actualizar(hotel);
	}

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.hotelRepository.eliminar(id);
	}

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> BuscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarFetchJoin();
	}



}
