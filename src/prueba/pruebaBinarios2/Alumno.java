package prueba.pruebaBinarios2;

import java.io.Serializable;

public class Alumno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre, id;
	private int edad;
	
	public Alumno (String nombre, String id, int edad) {
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
