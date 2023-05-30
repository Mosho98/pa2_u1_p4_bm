package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface EstudianteRepository {
	
	public void insertar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public Estudiante seleccionar(String numeroCedula);

	public void eliminar(String numeroCedula);
	
	public List<Estudiante> seleccionarTodos();
	
}
