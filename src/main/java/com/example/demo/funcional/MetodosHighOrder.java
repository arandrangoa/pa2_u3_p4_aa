package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	
	private static final Logger LOG=LoggerFactory.getLogger(MetodosHighOrder.class);
	
	public static void metodoSup(IPersonaSupplier<String> funcion) {
		LOG.info("High Order Supplier"+funcion.getId());
		
	}
	
	public static void metodoCons(IPersonaConsumer<String> funcion, String cadena) {
		funcion.accept(cadena);
	}

}
