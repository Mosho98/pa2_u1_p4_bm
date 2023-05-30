package com.example.demo.banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CuentaBancaria {
	
	private String numero;
	
	private String cedulaPropietario;
	
	private BigDecimal saldo;
	
	private String tipo;
	
	private LocalDate fechaApertura;

	
	//SET Y GET
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

	public String getCedulaPropietario() {
		return cedulaPropietario;
	}

	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", cedulaPropietario=" + cedulaPropietario + ", saldo=" + saldo
				+ ", tipo=" + tipo + ", fechaApertura=" + fechaApertura + "]";
	}
	
	
	
	

}
