package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.repository.ITransferenciaRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepo.insertar(transferencia);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizar(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//Cuenta Origen
				//1-Consultar la cuenta origen por el numero de cuenta
				CuentaBancaria cuentaOrigen=this.bancariaService.seleccionarPorNumero(ctaOrigen);
				
				//2-Consultar el saldo de la cuenta Origen
				BigDecimal saldoCtaOrigen=cuentaOrigen.getSaldo();
				
				BigDecimal montoDebitar=monto;
				
				//3-Validar si el saldo es suficiente
				
			
					//6-Si si es suficiente realizar la resta del saldo origen - monto
					BigDecimal nuevoSaldoOrigen=saldoCtaOrigen.subtract(montoDebitar);
					
					//7-Actualizamos el nuevo saldo de la cuenta origen
					cuentaOrigen.setSaldo(nuevoSaldoOrigen);
					this.bancariaService.actualizar(cuentaOrigen);
					
					//8-Consultamos la cuenta de destino por el numero
					
					CuentaBancaria cuentaDestino=this.bancariaService.seleccionarPorNumero(ctaDestino);
					
					//9-Consultamos el saldo de la cuenta destino
					
					BigDecimal saldoCtaDestino=cuentaDestino.getSaldo();
					
					//10-Realizamos la suma del saldo destino + monto
					
					BigDecimal nuevoSaldoDestino=saldoCtaDestino.add(monto);
					
					//11-Actualizamos el nuevo saldo de la cuenta destino 
					
					cuentaDestino.setSaldo(nuevoSaldoDestino);
					this.bancariaService.actualizar(cuentaDestino);
					
					//12-Creamos la transferencia 
					Transferencia transfer=new Transferencia();
					transfer.setCuentaOrigen(cuentaOrigen);
					transfer.setCuentaDestino(cuentaDestino);
					transfer.setFecha(LocalDate.now());
					transfer.setMonto(monto);
					
					this.iTransferenciaRepo.insertar(transfer);
					
					
					if(cuentaOrigen.getSaldo().compareTo(new BigDecimal(0))==-1) {
						throw new RuntimeException();
					}
					
				}
				
	

	@Override
	public List<Transferencia> seleccionarTodas() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepo.seleccionarTodas();
	}

}
