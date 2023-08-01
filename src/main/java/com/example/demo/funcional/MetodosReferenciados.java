package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG=LoggerFactory.getLogger(Main.class);
	
	public Integer getId() {
		return 8;
	}
	
	public void aceptar(String arg) {
		String cadena="Alex";
		LOG.info(cadena+" "+arg);
	}
	
	public Boolean evaluar(Integer valor) {
		Boolean b=valor.compareTo(7)==0;	
		return b;
	}
	
	public String aplicar(Integer valor) {
		String valorFinal=valor.toString().concat("Alex");
		
		return valorFinal;
		
	}
	
	public Integer procesar(Integer numero) {
		Integer valorFinal=numero+100;
		return valorFinal;
	}

}
