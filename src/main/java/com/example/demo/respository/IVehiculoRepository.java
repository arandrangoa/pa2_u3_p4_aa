package com.example.demo.respository;

import java.util.List;

import com.example.demo.modelo.Vehiculo;

public interface IVehiculoRepository {


	public void insertarVehiculo(Vehiculo vehiculo);
	public int eliminarPorPlaca(String placa);
	public int actualizarPorAnio(String modelo, String anio);

	public List<Vehiculo> seleccionarInnerJoin();
	
	public List<Vehiculo> seleccionarOuterRightJoin();
	public List<Vehiculo> seleccionarOuterLeftJoin();
	
	public List<Vehiculo> seleccionarOuterFullJoin();
	
	public List<Vehiculo> seleccionarWhereJoin();
	
	public List<Vehiculo> seleccionarFetchJoin();

}
