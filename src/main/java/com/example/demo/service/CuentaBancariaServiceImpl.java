package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.respository.ICuentaBancariaRepo;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepo bancariaRepo;
	
	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepo.insertar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepo.seleccionarPorNumero(numero);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepo.actualizar(cuentaBancaria);
	}

}
