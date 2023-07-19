package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Vehiculo;

public interface IVehiculoService {

	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarInnerJoin();
	public List<Vehiculo> buscarOuterRightJoin();
	public List<Vehiculo> buscarOuterLeftJoin();
		
	public List<Vehiculo> BuscarOuterFullJoin();
	
	public List<Vehiculo> buscarWhereJoin();
	public List<Vehiculo> buscarFetchJoin();
}
