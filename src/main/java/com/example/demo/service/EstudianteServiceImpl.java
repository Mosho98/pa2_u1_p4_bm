package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public void crear(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String numeroCedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(numeroCedula);
	}

	@Override
	public void borrar(String numeroCedula) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(numeroCedula);
	}

	@Override
	public List<Estudiante> reporteDeTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarTodos();
	}

}
