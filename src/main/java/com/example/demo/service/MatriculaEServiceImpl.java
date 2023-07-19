package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;
import com.example.demo.respository.IEstudianteRepository;
import com.example.demo.respository.IMatriculaERepository;

@Service
public class MatriculaEServiceImpl implements IMatriculaEService{

	@Autowired
	private IMatriculaERepository eRepository;
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	
	@Override
	public void insertarMatricula(String cedula, List<Materia> codigosMatria) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteRepository.seleccionarPorNumero(cedula);
		Matricula matricula = new Matricula();
		
		matricula.setEstudiante(estudiante);
		matricula.setCosto(new BigDecimal(100));
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setNumeroMatricula("1");
		
		for(Materia var : codigosMatria) {
			matricula.setMateria(var);
		}
		
		this.eRepository.insertarMatricula(matricula);
	}

	@Override
	public Matricula buscarPorEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.eRepository.buscarPorEstudiante(estudiante);
	}

}
