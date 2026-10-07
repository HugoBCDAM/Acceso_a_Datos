package ejerciciosFicheros.ejerciciosSemanaCuatro.ej3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		int finalizacion = 0, cod, unidades;
		String nombre;
		double precio, valorAlmacen = 0;
		File f = new File("productos.dat");
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
			do {
				System.out.println("Introduce el codigo del producto");
				cod = leer.nextInt();
				
				leer.nextLine();
				
				System.out.println("Introduce el nombre del producto");
				nombre = leer.nextLine();
				
				System.out.println("Introduce cuantas unidades hay");
				unidades = leer.nextInt();
				
				leer.nextLine();
				
				System.out.println("Introduce el precio");
				precio = leer.nextDouble();
				
				
				Producto p = new Producto(cod, nombre, unidades, precio);
					
				out.writeObject(p);
				System.out.println("¡Producto añadido!");
				
				System.out.println("¿Desea seguir introduciendo productos? Introduzca el \"0\" para salir y cualquier otro número para continuar");
				finalizacion = leer.nextInt();
				
				if (finalizacion == 0) {
					System.out.println("Saliendo...");
				}
			} while(finalizacion != 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Productos del almacén:");
		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				Producto p = (Producto) oin.readObject();
				
				p.calcularTotal();
				System.out.println("--------------------");
				System.out.println(p.toString());
				valorAlmacen += p.getValorTotal();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------");
		System.out.println("Valor total del almacén: " + valorAlmacen);
		leer.close();

	}

}
