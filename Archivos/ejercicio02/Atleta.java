package Archivos.ejercicio02;

import java.io.Serializable;

public class Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;
	private double peso;
	private int estatura;
	public Atleta(String nombre, int edad, double peso, int estatura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.estatura = estatura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getEstatura() {
		return estatura;
	}
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}
	

}
