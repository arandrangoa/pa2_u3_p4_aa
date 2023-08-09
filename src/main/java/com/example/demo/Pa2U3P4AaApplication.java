package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.funcional.Main;
import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
@EnableAsync
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
		
		//Asincrono sin respuesta
	/*	LOG.info("Hilo: "+Thread.currentThread().getName()); //Esto me indica el hilo con el que se esta ejecutando mi programa

		//Inicio
		long tiempoInicial=System.currentTimeMillis();
		List<CuentaBancaria> lista=new ArrayList<>();
		for(int i=0; i<=10; i++) {
			CuentaBancaria cO=new CuentaBancaria();
			cO.setNumero(String.valueOf(i));
			cO.setSaldo(new BigDecimal(100));
			cO.setTipo("Ahorro");
			lista.add(cO);
			this.bancariaService.agregarAsincrono(cO);
		}

		//Fin
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		LOG.info("Se termino todo el proceso");
		*/
		
		
		
		//Asincrono futuro con respuesta
		LOG.info("Hilo: "+Thread.currentThread().getName()); //Esto me indica el hilo con el que se esta ejecutando mi programa

		long tiempoInicial=System.currentTimeMillis();
		List<CuentaBancaria> lista=new ArrayList<>();
		List<CompletableFuture<String>> listaRespuestas=new ArrayList<>();
		for(int i=0; i<=10; i++) {
			CuentaBancaria cO=new CuentaBancaria();
			cO.setNumero(String.valueOf(i));
			cO.setSaldo(new BigDecimal(100));
			cO.setTipo("Ahorro");
			lista.add(cO);
			CompletableFuture<String> respuesta=this.bancariaService.agregarAsincrono2(cO); //Se captura la respuesta en un objeto CompletableFuture
			listaRespuestas.add(respuesta);
		}
		
		//Sentencia que espera que termine de procesarce todos los hilos para obtener la respuesta
		CompletableFuture.allOf(listaRespuestas.get(0),listaRespuestas.get(1),listaRespuestas.get(2),listaRespuestas.get(3)
				,listaRespuestas.get(4),listaRespuestas.get(5),listaRespuestas.get(6),listaRespuestas.get(7)
				,listaRespuestas.get(8),listaRespuestas.get(9));
		
		LOG.info("Respuesta 0: "+listaRespuestas.get(0).get());

		//Fin
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		LOG.info("Se termino todo el proceso");

		
	}
}
