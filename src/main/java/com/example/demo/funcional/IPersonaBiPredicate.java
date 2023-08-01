package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaBiPredicate <T,R>{
	
	public Boolean evaluar(T arg, R arg2);

}
