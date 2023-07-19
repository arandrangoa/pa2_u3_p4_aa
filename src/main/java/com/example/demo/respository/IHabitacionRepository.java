package com.example.demo.respository;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHabitacionRepository {
	public void insertar(Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
    public Habitacion seleccionar(Integer id);
	public void eliminar(Integer id);
	
}
