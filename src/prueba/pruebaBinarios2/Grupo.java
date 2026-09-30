package prueba.pruebaBinarios2;

import java.io.Serializable;
import java.util.ArrayList;

public class Grupo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Alumno> alumnos;
	
	public Grupo (String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
	}
	
	public void agregarAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
	
}
