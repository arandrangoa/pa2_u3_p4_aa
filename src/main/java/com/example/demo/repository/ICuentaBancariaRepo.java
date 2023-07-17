package com.example.demo.repository;

import com.example.demo.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	
	public void insertar(CuentaBancaria cuentaBancaria);
	
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria seleccionarPorNumero(String numero);
}
