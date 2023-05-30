package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.repository.CuentaBancariaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	private CuentaBancariaRepository bancariaRepository;
	

	@Override
	public void agregar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	public void modificar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public Transferencia buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		//1. consultar la cuenta de origen por el numero de cuenta
		CuentaBancaria ctaOrigen = this.bancariaRepository.seleccionarPorNumero(numeroCtaDestino);
		
		//2. consultar el saldo de la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		//3. validar si el saldo es suficiente
		if(monto.compareTo(saldoOrigen)<=0) {
			
			//5. si es suficiente ir al paso 6
			//6. ralizamos la resta del saldo origen - monto
			BigDecimal nuevoSaldoOrigen =  saldoOrigen.subtract(monto);
			//7. actualizamos el nuevo saldo de la ceunta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.bancariaRepository.actualizar(ctaOrigen);
			//8. Consultamos la cuenta de destino por el numero
			CuentaBancaria ctaDestino = this.bancariaRepository.seleccionarPorNumero(numeroCtaDestino);
			//9. Consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			//10. realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino= saldoDestino.add(monto);
			//11. actualizamos el nuevo saldo de la cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.bancariaRepository.actualizar(ctaDestino);
			//12. creamos la transferencia
			Transferencia transfer = new Transferencia();
			transfer.setCuentaOrigen(ctaOrigen);
			transfer.setCuentaDesrtino(ctaDestino);
			transfer.setMonto(monto);
			Double numero = Math.random();
			transfer.setNumero(numero.toString());
			transfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertar(transfer);
		}else {
			
			//4. si no es suficiente imprimir mensaje de no hay saldo
			System.out.println("Saldo no disponible, su saldo es: " + saldoOrigen);
		}
		
		
		
	}

}
