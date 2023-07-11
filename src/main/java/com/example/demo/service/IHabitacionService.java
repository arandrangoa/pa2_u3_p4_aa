package com.example.demo.service;

import com.example.demo.modelo.Habitacion;

public interface IHabitacionService {
	
	public void insertar(Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
	public Habitacion buscar(Habitacion id);
	public void elminar(Habitacion id);


}
