package ejerciciosFicheros.ejercicio2;

public class Alumno {
	
	private int edad;
	private String id, nombre, ciclo;
	
	public Alumno(String id, String nombre, int edad, String ciclo) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.ciclo = ciclo;
	}
	
	@Override
	public String toString() {
		return "Alumno [edad=" + edad + ", id=" + id + ", nombre=" + nombre + ", ciclo=" + ciclo + "]";
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	
	
}
