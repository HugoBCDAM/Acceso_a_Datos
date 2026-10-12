package ejerciciosFicheros.ejerciciosSemanaCuatro.ej11;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cod;
	private String nombre, telefono, email;
	private double saldoPendiente;
	
	public Cliente(int cod, String nombre, String telefono, String email, double saldoPendiente) {
		this.cod = cod;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.saldoPendiente = saldoPendiente;
	}

	@Override
	public String toString() {
		return "Cliente [cod=" + cod + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email
				+ ", saldoPendiente=" + saldoPendiente + "]";
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
