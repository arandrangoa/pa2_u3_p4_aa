package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Materia;
import com.example.demo.respository.IMateriaRepository;

@Service
public class MateriaServiceImpl implements IMateriaService{

	
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	
	@Override
	public void guardarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertarMateria(materia);
	}

}
