package com.example.demo.service;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);
	
	public void eliminar(String cedula);
	
	public Estudiante seleccionarPorNumero(String cedula);
}
