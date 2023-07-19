package com.example.demo.respository;

import java.util.List;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

public interface IHotelRepository {
	public void insertar(Hotel hotel);
	public void actualizar(Hotel hotel);
    public Hotel seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public List<Hotel> seleccionarInnerJoin();
	
	public List<Hotel> seleccionarOuterRightJoin();
	public List<Hotel> seleccionarOuterLeftJoin();
	
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin();
	
	public List<Hotel> seleccionarOuterFullJoin();
	
	public List<Hotel> seleccionarWhereJoin();
	
	public List<Hotel> seleccionarFetchJoin();
	
	

}
