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

@Table(name = "semestre")
@Entity
public class Semestre {

	@Id
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@Column(name="smtr_id")
	private Integer id;
	
	@Column(name="smtr_nivel")
	private String nivel;
	
	@Column(name="smtr_periodo")
	private String periodo;
	
	@Column(name="smtr_facultad")
	private String facultad;
	
	@OneToMany(mappedBy = "semestre")
	private List<Materia> materias;

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", nivel=" + nivel + ", periodo=" + periodo + ", facultad=" + facultad + "]";
	}
	
	
	
}
