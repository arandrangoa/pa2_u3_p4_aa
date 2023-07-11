package com.example.demo.repository;

import com.example.demo.modelo.Habitacion;

public interface IHabitacionRepo {
	
	public void insertar(Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
	public Habitacion buscar(Habitacion id);
	public void elminar(Habitacion id);

}
