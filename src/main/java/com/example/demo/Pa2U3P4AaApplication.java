package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4AaApplication implements CommandLineRunner{
	
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Hotel> listaHotel1=this.hotelService.buscarInnerJoin();
		
		System.out.println("***************SELECCIONAR INNER JOIN CON LAZY********************");
		for(Hotel h:listaHotel1) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones:");
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}
		
		System.out.println("***************SELECCIONAR JOIN FETCHC********************");
		
		List<Hotel> listaHotel2=this.hotelService.buscarFetchJoin();
		for(Hotel h:listaHotel2) {
			System.out.println(h.getNombre());
			System.out.println(" FETCH Tiene las siguientes habitaciones:");
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}	
		
		Hotel h=new Hotel();
		
		Habitacion ha1=new Habitacion();
		ha1.setNumero("T1");
		ha1.setValor(new BigDecimal(50));
		ha1.setHotel(h);
		
		
		Habitacion ha2=new Habitacion();
		ha2.setNumero("T2");
		ha2.setValor(new BigDecimal(80));
		ha2.setHotel(h);
		
		List<Habitacion> habitaciones=new ArrayList<>();
		habitaciones.add(ha1);
		habitaciones.add(ha2);
		
		h.setDireccion("Carcelen");
		h.setHabitaciones(habitaciones);
		h.setNombre("Travesia");
		
		this.hotelService.guardar(h);
		
		
	}

}
