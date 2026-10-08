package ejerciciosFicheros.ejerciciosSemanaCuatro.ej6;

import java.io.Serializable;

public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre, departamento;
	private double salario;
	private static int totalEmpleados;
	
	public Empleado(int id, String nombre, String departamento, double salario) {
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
		Empleado.totalEmpleados++;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", salario=" + salario
				+ "]";
	}
	
	public static int getTotalEmpleados() {
		return totalEmpleados;
	}

	public static void setTotalEmpleados(int totalEmpleados) {
		Empleado.totalEmpleados = totalEmpleados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
