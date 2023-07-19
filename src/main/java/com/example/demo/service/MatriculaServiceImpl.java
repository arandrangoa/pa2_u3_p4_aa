package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.MatriculaV;
import com.example.demo.respository.IMatriculaRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	@Override
	public List<MatriculaV> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<MatriculaV> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<MatriculaV> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<MatriculaV> BuscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<MatriculaV> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarWhereJoin();
	}

	@Override
	public void guardar(MatriculaV matriculaV) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertarMatricula(matriculaV);
	}

	@Override
	public List<MatriculaV> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarFetchJoin();
	}

	
}
