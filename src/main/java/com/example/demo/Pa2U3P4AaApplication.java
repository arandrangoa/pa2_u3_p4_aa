package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.funcional.Main;
import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4AaApplication implements CommandLineRunner{
	
	private static final Logger LOG=LoggerFactory.getLogger(Pa2U3P4AaApplication.class);
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("Hilo: "+Thread.currentThread().getName()); //Esto me indica el hilo con el que se esta ejecutando mi programa
		
		/*
		//Inicio
		long tiempoInicial=System.currentTimeMillis();
		for(int i=0; i<=30; i++) {
			CuentaBancaria cO=new CuentaBancaria();
			cO.setNumero(String.valueOf(i));
			cO.setSaldo(new BigDecimal(100));
			cO.setTipo("Ahorro");
			this.bancariaService.guardar(cO);
		}
		//Fin
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		*/
		
		//this.iTransferenciaService.realizar("123456", "654321", new BigDecimal(10));
		
//		//Inicio
//		long tiempoInicial=System.currentTimeMillis();
//		List<CuentaBancaria> lista=new ArrayList<>();
//		for(int i=0; i<=100; i++) {
//			CuentaBancaria cO=new CuentaBancaria();
//			cO.setNumero(String.valueOf(i));
//			cO.setSaldo(new BigDecimal(100));
//			cO.setTipo("Ahorro");
//			lista.add(cO);
//		}
//		
//		//lista.stream().forEach(cta->this.bancariaService.guardar(cta));
//		lista.parallelStream().forEach(cta->this.bancariaService.guardar(cta));
//		
//		//Fin
//		long tiempoFinal=System.currentTimeMillis();
//		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
//		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
//		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		

		//Inicio
		long tiempoInicial=System.currentTimeMillis();
		List<CuentaBancaria> lista=new ArrayList<>();
		for(int i=0; i<=100; i++) {
			CuentaBancaria cO=new CuentaBancaria();
			cO.setNumero(String.valueOf(i));
			cO.setSaldo(new BigDecimal(100));
			cO.setTipo("Ahorro");
			lista.add(cO);
		}
		
		//lista.stream().forEach(cta->this.bancariaService.guardar(cta));
		
		Stream<String>listaFinal =lista.parallelStream().map(cta->this.bancariaService.agregar2(cta));
		LOG.info("Se guardaron las siguientes cuentas");
		listaFinal.forEach(cadena->LOG.info(cadena));
		
		//Fin
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);

		
	}
}
