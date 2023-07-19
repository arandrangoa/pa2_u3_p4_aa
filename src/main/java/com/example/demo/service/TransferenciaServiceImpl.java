package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.respository.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepo.insertar(transferencia);
	}

	@Override
	public void realizar(String ctaOrigen, String ctaDestino, BigDecimal monto) {
	
				CuentaBancaria cuentaOrigen=this.bancariaService.seleccionarPorNumero(ctaOrigen);			
				BigDecimal saldoCtaOrigen=cuentaOrigen.getSaldo();				
				BigDecimal montoDebitar=monto;
				
				if(montoDebitar.compareTo(saldoCtaOrigen)<=0) {			
					BigDecimal nuevoSaldoOrigen=saldoCtaOrigen.subtract(montoDebitar);
				
					cuentaOrigen.setSaldo(nuevoSaldoOrigen);
					this.bancariaService.actualizar(cuentaOrigen);
					
					CuentaBancaria cuentaDestino=this.bancariaService.seleccionarPorNumero(ctaDestino);
					
										
					BigDecimal saldoCtaDestino=cuentaDestino.getSaldo();
					
					BigDecimal nuevoSaldoDestino=saldoCtaDestino.add(monto);
					
					cuentaDestino.setSaldo(nuevoSaldoDestino);
					this.bancariaService.actualizar(cuentaDestino);
					
					Transferencia transfer=new Transferencia();
					transfer.setCuentaOrigen(cuentaOrigen);
					transfer.setCuentaDestino(cuentaDestino);
					transfer.setFecha("17/07/2023");
					transfer.setMonto(monto);
					
					this.iTransferenciaRepo.insertar(transfer);
					
				}else {
					
					System.out.println("Saldo no disponible, su saldo es: "+saldoCtaOrigen);
				}
				
	}

	@Override
	public List<Transferencia> seleccionarTodas() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepo.seleccionarTodas();
	}

}
