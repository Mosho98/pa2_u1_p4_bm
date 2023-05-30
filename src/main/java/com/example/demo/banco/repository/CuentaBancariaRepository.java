package com.example.demo.banco.repository;

import com.example.demo.banco.modelo.CuentaBancaria;

public interface CuentaBancariaRepository {
	
	public void insertar(CuentaBancaria cuentaBancaria);
	
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public void eliminar(String numero);
	
	public CuentaBancaria seleccionarPorNumero(String numero);
	

}
