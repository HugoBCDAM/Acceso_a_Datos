package ejerciciosFicheros.ejerciciosSemanaCuatro.ej9;

import java.io.Serializable;

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int horas;
	private Profesor profesor;
	
	public Curso(String nombre, int horas, Profesor profesor) {
		this.nombre = nombre;
		this.horas = horas;
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + "\nDuración: " + this.getHoras() + " horas\nProfesor: " + this.getProfesor().getNombre() + "\nCorreo electrónico: " + this.getProfesor().getEmail();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
