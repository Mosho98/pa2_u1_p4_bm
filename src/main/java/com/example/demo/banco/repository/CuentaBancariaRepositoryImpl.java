package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;

@Repository
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository{

	private static List<CuentaBancaria> baseDatos=new ArrayList<>();

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		baseDatos.add(cuentaBancaria);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.eliminar(cuentaBancaria.getNumero());
		this.insertar(cuentaBancaria);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		CuentaBancaria cuenta=this.seleccionarPorNumero(numero);
		baseDatos.remove(cuenta);
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		CuentaBancaria cuentaEncontrado=new CuentaBancaria();
		for(CuentaBancaria cuenta:baseDatos) {
			if(numero.equals(cuenta.getNumero())) {
				cuentaEncontrado=cuenta;
			}
		}
		return cuentaEncontrado;
	}
	}


