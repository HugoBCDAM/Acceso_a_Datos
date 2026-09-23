package ejerciciosFicheros.ejercicio1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GestionArchivos {

	public static void main(String[] args) {
		
		try (Scanner leer = new Scanner(System.in)){
			
			int opcion;
			do {
				System.out.println("1. Crear carpeta almacén\n2. Crear un fichero vacío\n3. Listar Contenido\n4. Mostrar información de un fichero\n5. Copiar un fichero\n"
						+ "6. Renombrar/mover un fichero\n7. Eliminar un fichero\n0. Salir\n");
				
				System.out.print("Elige una opción del menú: ");
				opcion = leer.nextInt();
				
				leer.nextLine();
				Path carpetaAlmacen = Path.of("almacen");
				switch(opcion) {
				case 1:
					crearCarpetaAlmacen(carpetaAlmacen);
					break;
				case 2:
					crearFicheroVacio(leer, carpetaAlmacen);
					break;
				case 3:
					listarContenido(carpetaAlmacen);
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7: break;
				}
				
			} while (opcion != 0);
			
			leer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void listarContenido(Path carpetaAlmacen) {
		if (Files.exists(carpetaAlmacen)) {
			System.out.println("\nLa carpeta almacén tiene: ");
			File[] elementos = carpetaAlmacen.toFile().listFiles();
			
			for (File elemento : elementos) {
				if (elemento.isDirectory()) {
					System.out.println("[DIR] " + elemento.getName());
				} else {
					System.out.println("[FILE] " + elemento.getName());
				}
			}
			
			System.out.println("\n");
		} else {
			System.out.println("\nNo se puede listar el contenido de la carpeta almacén porque no existe\n");
		}
	}

	private static void crearFicheroVacio(Scanner leer, Path carpetaAlmacen) throws IOException {
		Path ficheroVacio;
		String nombre;
		do {
			System.out.print("\nDime el nombre del fichero: ");
			nombre = leer.nextLine();
			
			if (nombre.isBlank()) {
				System.out.println("\nEl nombre del fichero no puede estar vacío");
			}
		} while (nombre.isBlank());
		
		if (Files.exists(carpetaAlmacen)) {
			ficheroVacio = carpetaAlmacen.resolve(nombre);
			
			if (!Files.exists(ficheroVacio)) {
				Files.createFile(ficheroVacio);
				System.out.println("\nSe ha creado el fichero llamado " + ficheroVacio.getFileName() + "\n");
			} else {
				System.out.println("\nNo se puede crear el fichero porque ya existe uno con el nombre: " + ficheroVacio.getFileName() + "\n");
			}
		} else {
			System.out.println("\nNo se puede crear el fichero porque no existe la carpeta almacén\n");
		}
	}

	private static void crearCarpetaAlmacen(Path carpetaAlmacen) throws IOException {
		if (!Files.exists(carpetaAlmacen)) {
			Files.createDirectories(carpetaAlmacen);
			System.out.println("\nLa carpeta almacén fue creada\n");
		} else {
			System.out.println("\nLa carpeta almacén ya existe\n");
		}
	}

}
