package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.repository.IhotelRepo;

@Service
public class HotelServiceImpl implements IHotelService{
	
	@Autowired
	private IhotelRepo ihotelRepo;

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.ihotelRepo.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.ihotelRepo.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.ihotelRepo.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.ihotelRepo.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarFullOuterJoin() {
		// TODO Auto-generated method stub
		return this.ihotelRepo.seleccionarFullOuterJoin();
	}

	@Override
	public List<Hotel> BuscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.ihotelRepo.seleccionarWhereJoin();
	}



}
