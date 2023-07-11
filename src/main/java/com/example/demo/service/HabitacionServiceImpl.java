package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitacion;
import com.example.demo.repository.IHabitacionRepo;

@Service
public class HabitacionServiceImpl implements IHabitacionService{
	
	@Autowired
	private IHabitacionRepo habitacionRepo;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepo.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepo.actualizar(habitacion);
	}

	@Override
	public Habitacion buscar(Habitacion id) {
		// TODO Auto-generated method stub
		return this.habitacionRepo.buscar(id);
	}

	@Override
	public void elminar(Habitacion id) {
		// TODO Auto-generated method stub
		this.habitacionRepo.elminar(id);
	}

}
