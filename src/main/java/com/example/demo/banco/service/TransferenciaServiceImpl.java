package com.example.demo.banco.service;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Autowired
	@Qualifier("internacional")
	private MontoDebitarService debitarService;
	

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
		// TODO Auto-generated method stub
		//Cuenta Origen
		//1-Consultar la cuenta origen por el numero de cuenta
		CuentaBancaria ctaOrigen=this.cuentaBancariaRepository.seleccionarPorNumero(numeroCtaOrigen);
		
		//2-Consultar el saldo de la cuenta Origen
		BigDecimal saldoCtaOrigen=ctaOrigen.getSaldo();
		
		BigDecimal montoDebitar = this.debitarService.calcular(monto);
		//3-Validar si el saldo es suficiente
		
		if(montoDebitar.compareTo(saldoCtaOrigen)<=0) {
			//6-Si si es suficiente realizar la resta del saldo origen - monto
			BigDecimal nuevoSaldoOrigen=saldoCtaOrigen.subtract(montoDebitar);
			
			//7-Actualizamos el nuevo saldo de la cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaBancariaRepository.actualizar(ctaOrigen);
			
			//8-Consultamos la cuenta de destino por el numero
			
			CuentaBancaria ctaDestino=this.cuentaBancariaRepository.seleccionarPorNumero(numeroCtaDestino);
			
			//9-Consultamos el saldo de la cuenta destino
			
			BigDecimal saldoCtaDestino=ctaDestino.getSaldo();
			
			//10-Realizamos la suma del saldo destino + monto
			
			BigDecimal nuevoSaldoDestino=saldoCtaDestino.add(monto);
			
			//11-Actualizamos el nuevo saldo de la cuenta destino 
			
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaBancariaRepository.actualizar(ctaDestino);
			
			//12-Creamos la transferencia 
			Transferencia transfer=new Transferencia();
			transfer.setCuentaOrigen(ctaOrigen);
			transfer.setCuentaDesrtino(ctaDestino);
			transfer.setFecha(LocalDateTime.now());
			transfer.setMonto(monto);
			Double numero=Math.random();
			
			transfer.setNumero(numero.toString());
			this.transferenciaRepository.insertar(transfer);
			
		}else {
			//4-Si no es suficiente imprimir mensaje de no hay saldo suficiente
			System.out.println("Saldo no disponible, su saldo es: "+saldoCtaOrigen);
		}
		
		
		

}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.reporteTransferencia();
	}
}