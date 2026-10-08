package ejerciciosFicheros.ejerciciosSemanaCuatro.ej7;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		ArrayList<Libro> libros = new ArrayList<>();
		int opcion;
		File f = new File("biblioteca.dat");
		
		do {
			System.out.println("Menú:\n1. Añadir libro\n2. Mostrar libros\n3. Guardar catálogo\n4. Cargar catálogo\n0. Salir");
			opcion = leer.nextInt();
			
			leer.nextLine();
			
			switch(opcion) {
			case 1:
				aniadirLibro(leer, libros);
				break;
			case 2:
				mostrarLibros(libros);
				break;
			case 3:
				guardarCatalogo(libros, f);
				break;
			case 4:
				cargarCatalogo(libros, f);
				break;
			}
		} while (opcion != 0);
		
		leer.close();
	}

	private static void cargarCatalogo(ArrayList<Libro> libros, File f) {
		libros.clear();
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				libros.add((Libro) in.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("\nCatálogo cargado con éxito\n");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void guardarCatalogo(ArrayList<Libro> libros, File f) {
		if (libros.size() > 0) {
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
				for (int i = 0; i < libros.size(); i++) {
					out.writeObject(libros.get(i));
				}
				
				System.out.println("\nCatálogo guardado con éxito\n");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("\nNo existen libros para guardar en el catálogo\n");
		}
	}

	private static void mostrarLibros(ArrayList<Libro> libros) {
		if (libros.size() > 0) {
			System.out.println("\n------ LIBROS ------");
			
			for (int i = 0; i < libros.size(); i++) {
				System.out.println(libros.get(i).toString());
			}
			
			System.out.println("------ LIBROS ------\n");
		} else {
			System.out.println("\nNo hay libros en el catálogo, cargue el catálogo o añada uno\n");
		}
	}

	private static void aniadirLibro(Scanner leer, ArrayList<Libro> libros) {
		int anioPublicacion;
		String isbn;
		String titulo;
		String autor;
		System.out.print("\nDime el isbn: ");
		isbn = leer.nextLine();
		
		System.out.print("Dime el titulo: ");
		titulo = leer.nextLine();
		
		System.out.print("Dime el autor: ");
		autor = leer.nextLine();
		
		System.out.print("Dime el año de publicación: ");
		anioPublicacion = leer.nextInt();
		
		leer.nextLine();
		
		libros.add(new Libro(isbn, titulo, autor, anioPublicacion));
		
		System.out.println("\n¡Libro añadido!\n");
	}

}
