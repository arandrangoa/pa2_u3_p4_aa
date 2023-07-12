package com.example.demo;

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
		
		List<Hotel> listaHotel1=this.hotelService.buscarOuterRightJoin();
		
		System.out.println("***************SELECCIONAR OUTER RIGHT JOIN********************");
		for(Hotel h:listaHotel1) {
			System.out.println(h);
		}
		
		List<Hotel> listaHotel2=this.hotelService.buscarOuterLeftJoin();
		
		System.out.println("***************SELECCIONAR OUTER LEFT JOIN********************");
		for(Hotel h:listaHotel2) {
			System.out.println(h);
		}
		
		List<Habitacion> listaHotel3=this.hotelService.buscarHabitacionOuterLeftJoin();
		
		System.out.println("***************SELECCIONAR HABITACIONES OUTER LEFT JOIN********************");
		for(Habitacion h:listaHotel3) {
			System.out.println(h);
		}
		
		List<Hotel> listaHotel4=this.hotelService.buscarFullOuterJoin();
		
		System.out.println("***************SELECCIONAR FULL OUTER JOIN********************");
		for(Hotel h:listaHotel4) {
			System.out.println(h);
		}
		
		List<Hotel> listaHotel5=this.hotelService.BuscarWhereJoin();
		
		System.out.println("***************SELECCIONAR WHERE JOIN********************");
		for(Hotel h:listaHotel5) {
			System.out.println(h);
		}
		
		
		
	}

}
