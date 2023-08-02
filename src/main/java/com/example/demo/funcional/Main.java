package com.example.demo.funcional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
		System.out.println("**************1-SUPPLIER CON LAMBDA***********************");
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
//		
//		//Metodos referenciados
		MetodosReferenciados metodos=new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4=MetodosReferenciados::getId;
		LOG.info("Supplier metodo referenciado: "+supplier4.getId());
		
		//2-CONSUMER
		System.out.println("**************2-CONSUMER CON CLASE***********************");
		IPersonaConsumer<String> consumer1= new PersonaConsumerImpl();
		LOG.info("Consumer clase: ");
		consumer1.accept("Alex Andrango");
		
		System.out.println("**************2-CONSUMER CON LAMBDA***********************");
		IPersonaConsumer<String> consumer2= cadena->{
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Consumer lambda: ");
		consumer2.accept("Alex Andrango 2");
		
		//Metodos referenciados
		IPersonaConsumer<String> consumer3=MetodosReferenciados::aceptar;
		LOG.info("Consumer metodos referenciados: ");
		consumer3.accept("Alex Andrango 3");
		
		
		
		//3-PREDICATE
		System.out.println("**************3-PREDICATE CON LAMBDA***********************");
		//LAMBDAS
		
		IPersonaPredicate<Integer> predicate1= valor->valor.compareTo(8)==0;
		LOG.info("Predicate lambda: "+predicate1.evaluar(4));
		
		IPersonaPredicate<Integer> predicate2= valor->{
			Integer valor2=10;
			valor=valor+valor2;
			if(valor.compareTo(100)>0) {
				return true;
			}else {
				return false;
			}
		};
		LOG.info("Predicate lambda 2: "+predicate2.evaluar(95));
		

		
		IPersonaPredicate<String> predicate3= caracter->caracter.contains("z");
		LOG.info("Predicate lambda 3: "+predicate3.evaluar("alex"));
		
		IPersonaBiPredicate<String, String> predicate4=(letra,cadena)->cadena.contains(letra);
		LOG.info("Predicate lambda 4: "+predicate4.evaluar("e","Alex"));
		
		//Metodos referenciados
		IPersonaPredicate<Integer> predicate5=MetodosReferenciados::evaluar;
		LOG.info("Predicate metodo referenciado: "+predicate5.evaluar(7));
		
		
		
		//4-FUNCTION
		System.out.println("**************3-FUCTION CON LAMBDA***********************");
		IPersonaFunction<String, Integer> function1= numero->numero.toString();
		LOG.info("Fuction lambda 1: "+function1.aplicar(8));
		
		IPersonaFunction<String, Integer> function2= numero->{
			String valorFinal=numero.toString().concat("valor");
			return valorFinal;
		};
		LOG.info("Fuction lambda 2: "+function2.aplicar(10));
		
		//Metodos referenciados
		IPersonaFunction<String, Integer> function3=MetodosReferenciados::aplicar;
		LOG.info("Function metodo referenciado: "+function3.aplicar(7));
		
		//5-UnaryOperator
		System.out.println("**************3-UNARYOPERATOR CON LAMBDA***********************");
		IPersonaUnaryOperator<Integer> unary1= numero-> numero+(numero*2);
		LOG.info("UnaryOperator lambda 1: "+unary1.evaluar(3));
		
		IPersonaUnaryOperatorFunction<Integer> unary2= numero-> numero+(numero*2);
		LOG.info("UnaryOperator lambda 2: "+unary2.aplicar(3));
		
		//Metodos referenciados
		IPersonaUnaryOperator<Integer> unary3=MetodosReferenciados::procesar;
		LOG.info("UnaryOperator metodo referenciado: "+unary3.evaluar(7));
		
		//Metodos High Order
		MetodosHighOrder highOrder=new MetodosHighOrder();
		//1-Clase
		IPersonaSupplier<String> supplierHO= new PersonaSupplierImpl();
		MetodosHighOrder.metodoSup(supplierHO);
		//2-Lambdas
		MetodosHighOrder.metodoSup(()->"1727193847HO");
		//3-Metodos referenciados
		MetodosHighOrder.metodoSup(MetodosReferenciados::getIdHO);
		
		
		//Metodos High Order Consumer
		//1-Clase
		MetodosHighOrder.metodoCons(new PersonaConsumerImpl(),"Clase Consumer");
		//2-Lambdas
		MetodosHighOrder.metodoCons(cadena->LOG.info(cadena),"Lambdas Consumer");
		//3-Metodos refernciados
		MetodosHighOrder.metodoCons(MetodosReferenciados::aceptar, "Metodos refernciados");
		
		//*Interfaces funcionales JAVA
		//1-Supplier
		
		Stream<String> lista=Stream.generate(()-> "1727193847").limit(10);
		lista.forEach(cadena->LOG.info(cadena));
		
		//2-Consumer
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
		listaNumeros.forEach( cadena->{
			LOG.info(""+cadena);
		});
		
		//3-Predicate
		Stream<Integer> listaFinal=listaNumeros.stream().filter(numero->numero>=5);
		listaFinal.forEach(numero->LOG.info("valor: "+numero));
		
		//4-Function
		Stream<String> listaCambiada=listaNumeros.stream().map(numero->{
			Integer num=10;
			num=numero+num;
			return "N: "+num;
		});
		listaCambiada.forEach(cadena->LOG.info(cadena));
		
		//5-UnaryOperator
		Stream<Integer> listaCambiada2=listaNumeros.stream().map(numero->{
			Integer num=10;
			num=numero+num;
			return num;
		});
		listaCambiada2.forEach(cadena->LOG.info(""+cadena));
		
	
	}

}
