package com.example.demo.banco.service;

import com.example.demo.banco.modelo.CuentaBancaria;

public interface CuentaBancariaService {
	
	public void agregar(CuentaBancaria cuentaBancaria);
	
	public void modificar(CuentaBancaria cuentaBancaria);
	
	public void borrar(String numero);
	
	public CuentaBancaria buscarPorNumero(String numero);

}
