package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG=LoggerFactory.getLogger(Main.class);
	
	public static Integer getId() {
		return 8;
	}
	
	public static String getIdHO() {
		LOG.info("Metodos refernciados y HO");
		return "Alex Andrango";
		}
	
	
	public static void aceptar(String arg) {
		String cadena="Alex";
		LOG.info(cadena+" "+arg);
	}
	
	public static Boolean evaluar(Integer valor) {
		Boolean b=valor.compareTo(7)==0;	
		return b;
	}
	
	public static String aplicar(Integer valor) {
		String valorFinal=valor.toString().concat("Alex");
		
		return valorFinal;
		
	}
	
	public static Integer procesar(Integer numero) {
		Integer valorFinal=numero+100;
		return valorFinal;
	}

}
