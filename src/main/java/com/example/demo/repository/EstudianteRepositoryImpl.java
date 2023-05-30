package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository{

	private static List<Estudiante> baseDatos=new ArrayList<>();
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		baseDatos.add(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.eliminar(estudiante.getNumeroCedula());
		this.insertar(estudiante);
	}

	@Override
	public Estudiante seleccionar(String numeroCedula) {
		// TODO Auto-generated method stub
		Estudiante estuEncontrado=new Estudiante();
		for(Estudiante estu:baseDatos) {
			if(numeroCedula.equals(estu.getNumeroCedula())) {
				estuEncontrado=estu;
			}
		}
		return estuEncontrado;
	}

	@Override
	public void eliminar(String numeroCedula) {
		// TODO Auto-generated method stub
		Estudiante estu=this.seleccionar(numeroCedula);
		baseDatos.remove(estu);
	}

	@Override
	public List<Estudiante> seleccionarTodos() {
		// TODO Auto-generated method stub
		return baseDatos;
	}
	

	
	

}
