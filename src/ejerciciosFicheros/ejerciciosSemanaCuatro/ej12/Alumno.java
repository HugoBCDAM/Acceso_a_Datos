package ejerciciosFicheros.ejerciciosSemanaCuatro.ej12;

import java.io.Serializable;

public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numExp;
	private String nombre, apellidos, ciclo;
	private double notaMedia;
	
	public Alumno(int numExp, String nombre, String apellidos, String ciclo, double nota) {
		this.numExp = numExp;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciclo = ciclo;
		this.notaMedia = nota;
	}

	@Override
	public String toString() {
		return "Alumno [numExp=" + numExp + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo
				+ ", notaMedia=" + notaMedia + "]";
	}

	public int getNumExp() {
		return numExp;
	}

	public void setNumExp(int numExp) {
		this.numExp = numExp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
