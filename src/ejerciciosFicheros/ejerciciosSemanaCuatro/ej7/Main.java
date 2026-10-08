package ejerciciosFicheros.ejerciciosSemanaCuatro.ej7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		boolean prestado;
		ArrayList<Libro> libros = new ArrayList<>();
		int opcion;
		
		do {
			System.out.println("Menú:\n1. Añadir libro\n2. Mostrar libros\n3. Guardar catálogo\n4. Cargar catálogo\n0. Salir");
			opcion = leer.nextInt();
			
			leer.nextLine();
			
			switch(opcion) {
			case 1:
				aniadirLibro(leer, libros);
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				break;
			}
		} while (opcion != 0);
		
		leer.close();
	}

	private static void aniadirLibro(Scanner leer, ArrayList<Libro> libros) {
		int anioPublicacion;
		String isbn;
		String titulo;
		String autor;
		System.out.print("Dime el isbn: ");
		isbn = leer.nextLine();
		
		System.out.print("Dime el titulo: ");
		titulo = leer.nextLine();
		
		System.out.print("Dime el autor: ");
		autor = leer.nextLine();
		
		System.out.println("Dime el año de publicación: ");
		anioPublicacion = leer.nextInt();
		
		leer.nextLine();
		
		libros.add(new Libro(isbn, titulo, autor, anioPublicacion));
		
		System.out.println("¡Libro añadido!");
	}

}
