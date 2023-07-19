package com.example.demo.respository;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepository {

public void insertar(Estudiante estudiante);
	
	public void eliminar(String cedula);
	
	public Estudiante seleccionarPorNumero(String cedula);
}
