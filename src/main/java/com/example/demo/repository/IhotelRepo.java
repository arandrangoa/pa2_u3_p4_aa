package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IhotelRepo {
	
	public List<Hotel> seleccionarInnerJoin();
	
	public List<Hotel> seleccionarOuterRightJoin();
	
	public List<Hotel> seleccionarOuterLeftJoin();
	
	
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin();
	
	
	public List<Hotel> seleccionarFullOuterJoin();

	
	public List<Hotel> seleccionarWhereJoin();
}
