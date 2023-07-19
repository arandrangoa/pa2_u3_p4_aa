package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "provincia")
@Entity
public class Provincia {
	@Id
	@SequenceGenerator(name = "seq_prov", sequenceName = "seq_prov", allocationSize = 1)
	@GeneratedValue(generator = "seq_prov", strategy = GenerationType.SEQUENCE)
	@Column(name="prov_id")
	private Integer id;
	
	@Column(name="prov_nombre")
	private String nombre;
	
	@Column(name="prov_capital")
	private String capital;
	
	@Column(name="prov_habitantes")
	private String numHabitantes;
	
	@OneToMany(mappedBy = "provincia")
	private List<Estudiante> estudiantes;

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getNumHabitantes() {
		return numHabitantes;
	}

	public void setNumHabitantes(String numHabitantes) {
		this.numHabitantes = numHabitantes;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", capital=" + capital + ", numHabitantes="
				+ numHabitantes + "]";
	}
	
	
	
	
	
	

}
