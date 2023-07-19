package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.respository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Override
	public List<Vehiculo> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Vehiculo> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Vehiculo> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Vehiculo> BuscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Vehiculo> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarWhereJoin();
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.insertarVehiculo(vehiculo);
	}

	@Override
	public List<Vehiculo> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.seleccionarFetchJoin();
	}

	
}
