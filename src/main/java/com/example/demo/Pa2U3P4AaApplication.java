package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4AaApplication implements CommandLineRunner{
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		List<CuentaBancaria> cuentas=new ArrayList<>();
//		CuentaBancaria c=new CuentaBancaria();
//		c.setNumero("654321");
//		c.setSaldo(new BigDecimal(200));
//		c.setTipo("Ahorro");
//		cuentas.add(c);
//		
//		Propietario p=new Propietario();
//		p.setApellido("Tuquerres");
//		p.setCedula("1714458237");
//		p.setNombre("Jaime");
//		p.setCuentasBancarias(cuentas);
//		c.setPropietario(p);
//		
//		this.bancariaService.guardar(c);
		
		//this.iTransferenciaService.realizar("123456", "654321", new BigDecimal(30));
		
		System.out.println("Reporte de transferencia");
		List<Transferencia> reporteTrans=this.iTransferenciaService.seleccionarTodas();
		for(Transferencia f:reporteTrans) {
			System.out.println(f);
		}
		
	}
}
