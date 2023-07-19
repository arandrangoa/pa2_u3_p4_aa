package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitacion;
import com.example.demo.respository.IHabitacionRepository;

@Service
public class HabitacionServiceImpl implements IHabitacionService{

	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Override
	public void crear(Habitacion habitacion) {
		// TODO Auto-generated method stub
		
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.actualizar(habitacion);
	}

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepository.eliminar(id);
	}
	


}
