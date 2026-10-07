package ejerciciosFicheros.ejerciciosSemanaCuatro.ej4;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import ejerciciosFicheros.ejerciciosSemanaCuatro.ej3.Producto;

public class Main {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		File f = new File("productos.dat");
		int cod;
		boolean existe = false;
		
		if (f.exists()) {
			System.out.print("Introduzca el código del producto: ");
			cod = leer.nextInt();
			
			try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(f))) {
				while (true) {
					Producto p = (Producto) oin.readObject();
					
					if (p.getCod() == cod) {
						System.out.println("Datos del producto:");
						p.calcularTotal();
						System.out.println(p.toString());
						existe = true;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				System.out.println("");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			if (!existe) {
				System.out.println("No existe ningún producto con el código indicado");
			}
		} else {
			System.out.println("El archivo productos.dat no existe");
		}
		
		leer.close();
	}

}
