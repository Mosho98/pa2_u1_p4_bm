package com.example.demo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class Pa2U1P4BmApplication implements CommandLineRunner{

	@Autowired
	private IEstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4BmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante estu1 = new Estudiante();
		
		estu1.setNombre("Bryan");
		estu1.setApellido("Mullo");
		estu1.setCedula("1753054285");
		estu1.setFechaNacimiento(LocalDateTime.of(1998, 9,9,12,50));
		
		
		Estudiante estu2 = new Estudiante();
		estu2.setNombre("Alex");
		estu2.setApellido("Andrango");
		estu2.setCedula("123456789");
		estu2.setFechaNacimiento(LocalDateTime.of(1998, 9,9,12,50));
		
		//1.Guardar
		this.estudianteService.crear(estu1);
		this.estudianteService.crear(estu2);
		
		
		//5.Imprimir reporte
				List<Estudiante> reporte = this.estudianteService.reporteDeTodos();
				System.out.println("/////////////////////////////////////////////////");
				System.out.println("REPORTE DE ESTUDIANTE");
				for(Estudiante estu: reporte) {
					System.out.println(estu);
				}
				
				
		//2. Actualizar
				estu1.setApellido("Paucar");
				this.estudianteService.modificar(estu1);
				
				List<Estudiante> reporte2 = this.estudianteService.reporteDeTodos();
				System.out.println("/////////////////////////////////////////////////");
				System.out.println("REPORTE DE ESTUDIANTE 2");
				for(Estudiante estu: reporte2) {
					System.out.println(estu);
				}
				
		//3. Eliminar
				this.estudianteService.borrar("1753054285");
				System.out.println("/////////////////////////////////////////////////");
				List<Estudiante> reporte3 = this.estudianteService.reporteDeTodos();
				System.out.println("REPORTE DE ESTUDIANTE 3");
				for(Estudiante estu: reporte3) {
					System.out.println(estu);
				}
				
		//4. Buscar por cedula
				Estudiante buscarCedula = this.estudianteService.buscarPorCedula("123456789");
				System.out.println("/////////////////////////////////////////////////");
				System.out.println("BUSCAR POR CEDULA");
				System.out.println(buscarCedula);
				
				Estudiante buscarCedula1 = this.estudianteService.buscarPorCedula("12345678");
				System.out.println("BUSCAR POR CEDULA QUE NO EXISTE");
				System.out.println(buscarCedula1);
				
				
				
		
	
	}

}
