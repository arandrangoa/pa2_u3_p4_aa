package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;

public interface IMatriculaEService {

public void insertarMatricula(String cedula, List<Materia> codigosMatria);
	
	public Matricula buscarPorEstudiante(Estudiante estudiante);
}
