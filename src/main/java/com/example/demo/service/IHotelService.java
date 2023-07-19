package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHotelService {
	public void crear(Hotel hotel);
	public void actualizar(Hotel hotel);
    public Hotel seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public List<Hotel> buscarInnerJoin();
	public List<Hotel> buscarOuterRightJoin();
	public List<Hotel> buscarOuterLeftJoin();
	
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	
	public List<Hotel> BuscarOuterFullJoin();
	
	public List<Hotel> buscarWhereJoin();
	
	public List<Hotel> buscarFetchJoin();
}
