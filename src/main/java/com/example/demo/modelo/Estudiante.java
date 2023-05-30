package com.example.demo.modelo;

import java.time.LocalDateTime;

public class Estudiante {
	
	private String nombre;
	
	private String apellido;
	
	private String numeroCedula;
	
	private LocalDateTime fechaNacimiento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", numeroCedula=" + numeroCedula
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	
	

}
