package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Hotel;
import com.example.demo.repository.IhotelRepo;

@Service
public class HotelServiceImpl implements IHotelService{
	
	@Autowired
	private IhotelRepo ihotelRepo;

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.ihotelRepo.seleccionarInnerJoin();
	}



}
