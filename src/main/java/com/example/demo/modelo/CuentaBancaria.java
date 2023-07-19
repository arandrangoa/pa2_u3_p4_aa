package com.example.demo.modelo;

import java.math.BigDecimal;
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

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
	@GeneratedValue(generator = "seq_cuenta_bancaria", strategy = GenerationType.SEQUENCE)
	@Column(name="cta_id")
	private Integer id;
	
	@Column(name="cta_numero")
	private String numero;
	
	@Column(name="cta_saldo")
	private BigDecimal saldo;
	
	@Column(name="cta_tipo")
	private String tipo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cta_id_propietario")
	private Propietario propietario;

	@OneToMany(mappedBy = "cuentaOrigen")
	private List<Transferencia> transferenciaOrigen;

	@OneToMany(mappedBy = "cuentaDestino")
	private List<Transferencia> transferenciaDestino;
	
	//GET Y SET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Transferencia> getTransferenciaOrigen() {
		return transferenciaOrigen;
	}

	public void setTransferenciaOrigen(List<Transferencia> transferenciaOrigen) {
		this.transferenciaOrigen = transferenciaOrigen;
	}

	public List<Transferencia> getTransferenciaDestino() {
		return transferenciaDestino;
	}

	public void setTransferenciaDestino(List<Transferencia> transferenciaDestino) {
		this.transferenciaDestino = transferenciaDestino;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}
	
	
	
	
	
	
	
	
}
