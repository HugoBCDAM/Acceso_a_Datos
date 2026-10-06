package ejerciciosFicheros.ejerciciosSemanaCuatro.ej2;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int nExp, edad;
	String nombre;
	double nota;
	
	public Alumno(int nExp, String nombre, int edad, double nota) {
		this.nExp = nExp;
		this.nombre = nombre;
		this.edad = edad;
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "Expediente: " + this.getnExp() + "\nNombre: " + this.getNombre() + "\nEdad: " + this.getEdad() + 
				"\nNota Media: " + this.getNota();
	}

	public int getnExp() {
		return nExp;
	}

	public void setnExp(int nExp) {
		this.nExp = nExp;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
