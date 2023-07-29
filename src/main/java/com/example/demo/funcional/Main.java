package com.example.demo.funcional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG=LoggerFactory.getLogger(Main.class);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IPersona per=new PersonaImpl();
		per.caminar();
		
		//Dentro de la buena practica empresarial no se utiliza el sysout,la buena practica es utilizar looger
		
		//1.-Supplier
		//Implementacion por Clases
		System.out.println("**************1-SUPPLIER CON CLASE***********************");
		IPersonaSupplier<String> supplier1=new PersonaSupplierImpl();
		LOG.info("Supplier clase: "+supplier1.getId());
		
		//Lambdas
		System.out.println("**************2-CONSUMER CON LAMBDA***********************");
		//si no recibe ningun parametro se debe poner el parentesis vacio
		//Cuando existe una sola linea de expresiones en el cuerpo no hace falta el return
		IPersonaSupplier<String> supplier2= ()->  "1727193847";
		LOG.info("Supplier lambda: "+supplier2.getId());
		
		IPersonaSupplier<String> supplier3= ()-> {
			String cedula="1727193847";
			cedula=cedula+"zzzz";
			return cedula;
		};
		LOG.info("Supplier lambda2: "+supplier3.getId());
		
	}

}
