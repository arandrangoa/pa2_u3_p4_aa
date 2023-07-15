package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentaBancaria")
public class CuentaBancaria {
	
	@Id
	@SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
	@GeneratedValue(generator = "seq_cuenta_bancaria", strategy = GenerationType.SEQUENCE)
	@Column(name="cuen_id")
	private Integer id;
	
	@Column(name="cuen_numero")
	private String numero;
	
	@Column(name="cuen_saldo")
	private BigDecimal saldo;
	
	@Column(name="cuen_tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="cuen_id_propietario")
	private Propietario propietario;
	
	

}
