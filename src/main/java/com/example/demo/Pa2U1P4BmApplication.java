package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.MatriculaCalculo;
import com.example.demo.modelo.Profesor;

@SpringBootApplication
public class Pa2U1P4BmApplication implements CommandLineRunner{

	@Autowired
	private Profesor profe2;
	
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
		System.out.println(profe.getApellido());
		
		System.out.println(profe2);
		profe2.setApellido("Teran");
		System.out.println(profe2.getApellido());
		Profesor profe3;
		profe3 = profe;
		profe.setApellido("Paucar");
		System.out.println(profe3);
		
		MatriculaCalculo mat = new MatriculaCalculo();
		mat.realizarMatricula("1");
	
	}

}
