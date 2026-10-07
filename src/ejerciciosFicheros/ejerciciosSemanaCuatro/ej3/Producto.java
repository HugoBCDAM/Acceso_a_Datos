package ejerciciosFicheros.ejerciciosSemanaCuatro.ej3;

import java.io.Serializable;

public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static int totalProductos;
	private int cod, unidades;
	String nombre;
	double precio, valorTotal;
	
	public Producto(int cod, String nombre, int unidades, double precio) {
		this.cod = cod;
		this.nombre = nombre;
		this.unidades = unidades;
		this.precio = precio;
		Producto.totalProductos++;
	}
	
	public void calcularTotal() {
		this.setValorTotal(this.getPrecio() * this.getUnidades());
	}
	
	@Override
	public String toString() {
		return "Código: " + this.getCod() + "\nNombre: " + this.getNombre() + "\nUnidades: " + this.getUnidades() + "\nPrecio: " + this.getPrecio() +
				"\nPrecio total: " + this.getValorTotal();
	}

	public static int getTotalProductos() {
		return totalProductos;
	}

	public static void setTotalProductos(int totalProductos) {
		Producto.totalProductos = totalProductos;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
