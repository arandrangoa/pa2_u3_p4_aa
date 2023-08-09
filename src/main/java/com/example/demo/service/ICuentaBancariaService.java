package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public void guardar(CuentaBancaria cuentaBancaria);
	
	public String agregar2(CuentaBancaria cuentaBancaria);
	
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria seleccionarPorNumero(String numero);
	
	public void agregarAsincrono(CuentaBancaria cuentaBancaria);
	
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria cuentaBancaria);

}
