package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "materia")
@Entity
public class Materia {

	@Id
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@Column(name="mtra_id")
	private Integer id;
	
	@Column(name="mtra_nombre")
	private String nombre;
	
	@Column(name="mtra_codigo")
	private String codigo;
	
	@Column(name="mtra_numero_creditos")
	private String numCreditos;
	
	@OneToMany(mappedBy = "materia")
	private List<Matricula> matriculas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mtra_id_semestre")
	private Semestre semestre;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(String numCreditos) {
		this.numCreditos = numCreditos;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", numCreditos=" + numCreditos + "]";
	}
	
	
	
	
}
