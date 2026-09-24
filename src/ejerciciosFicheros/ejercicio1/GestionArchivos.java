package ejerciciosFicheros.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
					mostrarInformacion(leer, carpetaAlmacen);
					break;
				case 5:
					copiarFichero(leer, carpetaAlmacen);
					break;
				case 6:
					renombrarMover(leer, carpetaAlmacen);
					break;
				case 7: 
					eliminarFichero(leer, carpetaAlmacen);
					break;
				}
				
			} while (opcion != 0);
			
			System.out.println("Saliendo del programa...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void mostrarInformacion(Scanner leer, Path carpetaAlmacen) {
		if (Files.exists(carpetaAlmacen)) {
			System.out.println("Dime el nombre del fichero a mostrar");
			String nombre = leer.nextLine();
			
			Path ruta = carpetaAlmacen.resolve(nombre);
			
			if (Files.exists(ruta)) {
				System.out.println("Información del fichero:");
				try (BufferedReader br = new BufferedReader(new FileReader(ruta.toFile()))){
					String linea;
					
					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
					}
				} catch (IOException e) {
					e.getMessage();
				}
			} else {
				System.out.println("No se puede mostrar la información del fichero porque no existe");
			}
		} else {
			System.out.println("No se puede mostrar información de ningún fichero porque la carpeta almacen no existe");
		}
	}

	private static void eliminarFichero(Scanner leer, Path carpetaAlmacen) throws IOException {
		if (Files.exists(carpetaAlmacen)) {
			System.out.println("Dime el nombre del fichero que quieres eliminar");
			String nombre = leer.nextLine();
			
			Path eliminar = carpetaAlmacen.resolve(nombre);
			
			if (Files.exists(eliminar)) {
				Files.delete(eliminar);
				System.out.println("La eliminación del fichero se realizó con éxito");
			} else {
				System.out.println("No se puede eliminar el fichero porque no existe");
			}
		} else {
			System.out.println("No se puede eliminar ningún fichero porque no existe la carpeta almacen");
		}
	}

	private static void renombrarMover(Scanner leer, Path carpetaAlmacen) throws IOException {
		if (Files.exists(carpetaAlmacen)) {
			System.out.println("Dime el nombre del fichero que quieres renombrar/mover");
			String nombre = leer.nextLine();
			
			Path renombrar = carpetaAlmacen.resolve(nombre);
			
			if (Files.exists(renombrar)) {
				System.out.println("Dime la ruta para poder renombrar o mover el fichero");
				String ruta = leer.nextLine();
				
				Path rutaCompleta = Path.of(ruta);
				
				Files.move(renombrar, rutaCompleta);
				
				System.out.println("Nombre del fichero cambiado o fichero movido con éxito");
			} else {
				System.out.println("El fichero especificado no existe");
			}
		} else {
			System.out.println("No se puede renombrar o mover un fichero porque no existe la carpeta almacen");
		}
	}

	private static void copiarFichero(Scanner leer, Path carpetaAlmacen) throws IOException {
		if (Files.exists(carpetaAlmacen)) {
			System.out.println("Dime el nombre del fichero que quieres copiar");
			String nombre = leer.nextLine();
			
			Path copiar = carpetaAlmacen.resolve(nombre);
			
			if (Files.exists(copiar)) {
				System.out.println("Dime la ruta que quieres que tenga el archivo que se copió y el nombre del mismo");
				String ruta = leer.nextLine();
				
				Path rutaCopia = Path.of(ruta);
				
				Files.copy(copiar, rutaCopia);
				
				System.out.println("La copia se realizó con éxito");
			} else {
				System.out.println("No se puede copiar porque el fichero especificado no existe");
			}
		} else {
			System.out.println("No se puede copiar ningún fichero porque la carpeta almacen no existe");
		}
	}

	private static void listarContenido(Path carpetaAlmacen) {
		if (Files.exists(carpetaAlmacen)) {
			System.out.println("\nLa carpeta almacén tiene: ");
			File[] elementos = carpetaAlmacen.toFile().listFiles();
			
			if (elementos != null) {
				for (File elemento : elementos) {
					if (elemento.isDirectory()) {
						System.out.println("[DIR] " + elemento.getName());
					} else {
						System.out.println("[FILE] " + elemento.getName());
					}
				}
			} else {
				System.out.println("No hay nada dentro de la carpeta almacén");
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
