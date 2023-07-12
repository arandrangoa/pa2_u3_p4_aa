package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHotelService {
	
	public List<Hotel> buscarInnerJoin();
	
	public List<Hotel> buscarOuterRightJoin();
	
	public List<Hotel> buscarOuterLeftJoin();
	
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	
	public List<Hotel> buscarFullOuterJoin();
	
	public List<Hotel> BuscarWhereJoin();
}
