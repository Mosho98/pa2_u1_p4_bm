package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.repository.CuentaBancariaRepository;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{
	
	@Autowired
	private CuentaBancariaRepository bancariaRepository;

	@Override
	public void agregar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	public void modificar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(numero);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		return this.bancariaRepository.seleccionarPorNumero(numero);
	}

}
