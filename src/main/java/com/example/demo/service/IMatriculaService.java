package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.MatriculaV;

public interface IMatriculaService {
	public void guardar(MatriculaV matriculaV);

	public List<MatriculaV> buscarInnerJoin();
	public List<MatriculaV> buscarOuterRightJoin();
	public List<MatriculaV> buscarOuterLeftJoin();
		
	public List<MatriculaV> BuscarOuterFullJoin();
	
	public List<MatriculaV> buscarWhereJoin();
	public List<MatriculaV> buscarFetchJoin();
}
