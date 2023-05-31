package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.service.CuentaBancariaService;
import com.example.demo.banco.service.TransferenciaService;

@SpringBootApplication
public class Pa2U1P4AaApplication implements CommandLineRunner{
	
	@Autowired
	private TransferenciaService transferenciaService;
	@Autowired
	private CuentaBancariaService bancariaService;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		////////////////cta 1
		CuentaBancaria cta1 = new CuentaBancaria();
		cta1.setCedulaPropietario("1753054285");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("5678");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		this.bancariaService.agregar(cta1);
	
	
		////////////////////cta2
		CuentaBancaria cta2 = new CuentaBancaria();
		cta2.setCedulaPropietario("175305428500000");
		cta2.setFechaApertura(LocalDate.now());
		cta2.setNumero("7890");
		cta2.setSaldo(new BigDecimal(100));
		cta2.setTipo("A");
		this.bancariaService.agregar(cta2);
		
		
		
		this.transferenciaService.realizar("5678", "7890", new BigDecimal(10));
		
		System.out.println("SALDO ORIGEN: " + this.bancariaService.buscarPorNumero(cta1.getNumero()).getSaldo());
		System.out.println("SALDO DESTINO: " + this.bancariaService.buscarPorNumero(cta2.getNumero()).getSaldo());
		System.out.println("///////////////////////////////////////////////");
		
	
		List<Transferencia> reporte = new ArrayList<>();
		reporte = this.transferenciaService.buscarTodos();
		
		for(Transferencia var :reporte) {
			System.out.println(var);
		}
		
	}

}
