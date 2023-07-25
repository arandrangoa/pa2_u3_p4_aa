package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaServiceImpl implements IPruebaService{

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba");
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba2() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba 2");
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba Supports");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba NotSupported");
	}

	@Override
	@Transactional(value = TxType.REQUIRED) //Por defecto sino se pone el value esta en required
	public void pruebaRequired() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba Required");
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba Requires_New");
		
	}

}
