package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Transferencia;

public interface ITransferenciaRepo {
	
	public void insertar(Transferencia transferencia);
	
	public void realizar(String ctaOrigen,String ctaDestino, BigDecimal monto);
	
	public List<Transferencia> seleccionarTodas();

}
