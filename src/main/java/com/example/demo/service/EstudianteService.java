package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface EstudianteService {
	
	public void crear(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public Estudiante buscarPorCedula(String numeroCedula);

	public void borrar(String numeroCedula);
	
	public List<Estudiante> reporteDeTodos();

}
