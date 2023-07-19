package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculaVehiculo")
public class MatriculaV {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula")
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Column(name = "matri_id") 
	private Integer id;
	
	@Column(name = "matri_placa")
	private String placa;
	
	@Column(name = "matri_nombre_propietario")
	private String nombre;
	
	@Column(name = "matri_fecha_matricula")
	private String fechaMatricula;
	
	@OneToOne
	@JoinColumn(name = "matri_id_vehiculo")
	private Vehiculo vehiculo;

	
	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(String fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "MatriculaV [id=" + id + ", placa=" + placa + ", nombre=" + nombre + ", fechaMatricula=" + fechaMatricula
				+ "]";
	}
	
	
	
	
	
}
