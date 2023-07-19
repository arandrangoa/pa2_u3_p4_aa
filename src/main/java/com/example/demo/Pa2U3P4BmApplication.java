package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.Provincia;
import com.example.demo.modelo.Semestre;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMatriculaEService;

@SpringBootApplication
public class Pa2U3P4BmApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4BmApplication.class, args);
	}

	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMatriculaEService eService;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Estudiante> estudiantes = new ArrayList<>();
		List<Materia> materias = new ArrayList<>();
		
		
		Estudiante e = new Estudiante();
		e.setNombre("Alex");
		e.setApellido("Andrango");
		e.setCedula("1727193847");
		
		estudiantes.add(e);
		
		Provincia p = new Provincia();
		p.setCapital("Guayaquil");
		p.setNombre("Guayas");
		p.setNumHabitantes("23000000");
		p.setEstudiantes(estudiantes);
		
		Materia m1 = new Materia();
		m1.setCodigo("1P");
		m1.setNombre("Programacion Avanzada 2");
		m1.setNumCreditos("40");
		
		Materia m2 = new Materia();
		m2.setCodigo("1B");
		m2.setNombre("Base de datos 2");
		m2.setNumCreditos("35");
		materias.add(m1);
		materias.add(m2);
		
		Semestre s = new Semestre();
		s.setNivel("7mo");
		s.setPeriodo("2023");
		s.setFacultad("Ingenieria Computacion");
		e.setProvincia(p);
		this.estudianteService.guardar(e);
		this.eService.insertarMatricula("1753054285", materias);
		
	
		
}
	
	

}
