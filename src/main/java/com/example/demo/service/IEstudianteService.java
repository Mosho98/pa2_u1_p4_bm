package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteService {
	public void crear(Estudiante estudiante);
	public void modificar(Estudiante estudiante);
	public Estudiante buscarPorCedula(String cedula);
	public void borrar(String cedula);
	public List<Estudiante> reporteDeTodos();
}
