package com.example.demo.respository;

import java.util.List;

import com.example.demo.modelo.MatriculaV;
import com.example.demo.modelo.Vehiculo;

public interface IMatriculaRepository {

	public void insertarMatricula(MatriculaV matricula);
	public int eliminarPorPlaca(String placa);

	public List<MatriculaV> seleccionarInnerJoin();
	
	public List<MatriculaV> seleccionarOuterRightJoin();
	public List<MatriculaV> seleccionarOuterLeftJoin();
	public List<MatriculaV> seleccionarOuterFullJoin();
	public List<MatriculaV> seleccionarWhereJoin();
	public List<MatriculaV> seleccionarFetchJoin();
}
