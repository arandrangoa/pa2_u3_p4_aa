package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.repository.CuentaBancariaRepoImpl;
import com.example.demo.repository.ICuentaBancariaRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
	
	private static final Logger LOG=LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private ICuentaBancariaRepo bancariaRepo;
	
	@Autowired
	private IPruebaService iPruebaService;
	
	@Override

	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		LOG.info("Hilo service: "+Thread.currentThread().getName());
		//SUMAR RESTAR MULTIPLICAR: LOGICA QUE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepo.insertar(cuentaBancaria);
		
	}
	
	@Override
	public String agregar2(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		
		LOG.info("Hilo service: "+Thread.currentThread().getName());
		//SUMAR RESTAR MULTIPLICAR: LOGICA QUE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepo.insertar(cuentaBancaria);
		return cuentaBancaria.getNumero();
	}
	
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba");
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepo.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepo.actualizar(cuentaBancaria);
	}

	@Override
	@Async
	public void agregarAsincrono(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		LOG.info("Hilo service: "+Thread.currentThread().getName());
		//SUMAR RESTAR MULTIPLICAR: LOGICA QUE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepo.insertar(cuentaBancaria);
		
		
	}

	@Override
	@Async
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		
		LOG.info("Hilo service: "+Thread.currentThread().getName());
		//SUMAR RESTAR MULTIPLICAR: LOGICA QUE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepo.insertar(cuentaBancaria);
		return CompletableFuture.completedFuture(cuentaBancaria.getNumero());
	}
		
	
	
}




