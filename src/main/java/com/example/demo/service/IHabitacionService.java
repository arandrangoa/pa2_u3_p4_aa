package com.example.demo.service;

import com.example.demo.modelo.Habitacion;

public interface IHabitacionService {

	public void crear(Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
    public Habitacion seleccionar(Integer id);
	public void eliminar(Integer id);
}
