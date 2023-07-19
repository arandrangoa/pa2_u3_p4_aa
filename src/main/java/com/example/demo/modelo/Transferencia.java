package com.example.demo.modelo;

import java.math.BigDecimal;

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

@Table(name = "transferencia")
@Entity
public class Transferencia {

	@Id
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
	@Column(name="trans_id")
	private Integer id;
	
	@Column(name="trans_fecha")
	private String fecha;
	
	@Column(name="trans_monto")
	private BigDecimal monto;
	
	
	@ManyToOne
	@JoinColumn(name="trans_id_cta_origen")
	private CuentaBancaria cuentaOrigen;

	@ManyToOne
	@JoinColumn(name="trans_id_cta_destino")
	private CuentaBancaria cuentaDestino;

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	
	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + "]";
	}

	
	
	
	
	
	
}
