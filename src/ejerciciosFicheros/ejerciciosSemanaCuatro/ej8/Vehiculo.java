package ejerciciosFicheros.ejerciciosSemanaCuatro.ej8;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String matricula, marca, modelo;
	private int kilometros;
	private double costeReparacion;
	private static int totalVehiculos;
	
	public Vehiculo(String matricula, String marca, String modelo, int kilometros, double costeReparacion) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometros = kilometros;
		this.costeReparacion = costeReparacion;
		Vehiculo.totalVehiculos++;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", kilometros="
				+ kilometros + ", costeReparacion=" + costeReparacion + "]";
	}



	public static int getTotalVehiculos() {
		return totalVehiculos;
	}



	public static void setTotalVehiculos(int totalVehiculos) {
		Vehiculo.totalVehiculos = totalVehiculos;
	}



	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public double getCosteReparacion() {
		return costeReparacion;
	}

	public void setCosteReparacion(double costeReparacion) {
		this.costeReparacion = costeReparacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
