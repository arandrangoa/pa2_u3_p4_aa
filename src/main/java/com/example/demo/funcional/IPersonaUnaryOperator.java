package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator <T>{
	
	public T evaluar (T arg);

}
