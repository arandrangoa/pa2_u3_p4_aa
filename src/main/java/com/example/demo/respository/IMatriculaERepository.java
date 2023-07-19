package com.example.demo.respository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Matricula;

public interface IMatriculaERepository {

	public void insertarMatricula(Matricula matricula);
	
	public Matricula buscarPorEstudiante(Estudiante estudiante);
	
	
}
