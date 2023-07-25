package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaService;

@SpringBootApplication
public class Pa2U3P4AaApplication implements CommandLineRunner{
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Main: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		CuentaBancaria c=new CuentaBancaria();
		c.setNumero("741852");
		c.setSaldo(new BigDecimal(100));
		c.setTipo("Ahorro");
		
		this.bancariaService.guardar(c);
		
	}
}
