package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Profesor;

@SpringBootApplication
public class Pa2U1P4BmApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4BmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mi primer proyecto");
		Profesor profe = new Profesor();
		profe.setApellido("Mullo");
		profe.setNombre("Bryan");
		profe.setCedula("1753054285");
		profe.setFechaNacimiento(LocalDateTime.now());
		
		System.out.println(profe);
	}

}
