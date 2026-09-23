package ejerciciosFicheros.ejercicio1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		
		/* EJERCICIO 2 */
		File f = new File("datos.txt");
		
		try {
			f.createNewFile();
			System.out.println("=== EJERCICIO 2 ===");
			System.out.println("Nombre: " + f.getName());
			System.out.println("Ruta absoluta: " + f.getAbsolutePath());
			System.out.println("Existe: " + f.exists());
			System.out.println("Directorio : " + f.isDirectory());
			System.out.println("Tamaño: " + f.length() + " bytes");
			
			/* EJERCICIO 3 */
			File carpeta = new File("documentos");
			
			carpeta.mkdir();
			System.out.println("\n=== EJERCICIO 3 ===");
			if (carpeta.exists()) {
				System.out.println("La carpeta está creada");
			} else {
				System.out.println("La carpeta no está creada");
			}
			
			/* EJERCICIO 4 */
			
			// CON FILE
			File d = new File("proyecto/datos/copias/informes");	
			d.mkdirs();
			
			// CON FILES
			Path p = Path.of("proyecto/datos/copias/informes");
			Files.createDirectories(p);
			
			/* EJERCICIO 5 */
			
			System.out.println("\n=== EJERCICIO 5 ===");
			
			File carpeta2 = new File("proyecto");
			File[] elementos = carpeta2.listFiles();
			
			if (elementos != null) {
				for (File elemento : elementos) {
					if (elemento.isDirectory()) {
						System.out.println("[DIR] " + elemento.getName());
					} else {
						System.out.println("[FILE] " + elemento.getName());
					}
				}
			}
			
			/* EJERCICIO 6 */
			
			System.out.println("\n=== EJERCICIO 6 ===");
			
			File carpeta3 = new File("proyecto");
			File[] elementos2 = carpeta3.listFiles();
			
			int ficheros = 0, directorios = 0;
			if (elementos2 != null) {
				for (File elemento : elementos) {
					if (elemento.isDirectory()) {
						System.out.println("[DIR] " + elemento.getName());
						directorios++;
					} else {
						System.out.println("[FILE] " + elemento.getName());
						ficheros++;
					}
				}
			}
			
			System.out.println("Directorios en total: " + directorios);
			System.out.println("Ficheros en total: " + ficheros);
			
			/* EJERCICIO 7 */
			
			System.out.println("\n=== EJERCICIO 7 ===");
			
			Path p2 = Path.of("datos/alumnos.txt");
			
			System.out.println("Ruta original: " + p2);
			System.out.println("Ruta absoluta: " + p2.toAbsolutePath());
			System.out.println("Nombre: " + p2.getFileName());
			System.out.println("Directorio padre: " + p2.getParent());
			
			/* EJERCICIO 8 */
			
			File carpetaDatos = new File("datos");
			
			if (!carpetaDatos.exists()) {
				carpetaDatos.mkdir();
			}
			
			Path a = Path.of(carpetaDatos.getPath(), "alumnos.txt");
			
			if (!Files.exists(a)) {
				Files.createFile(a);
			}
			
			/* EJERCICIO 9 */
			File carpetaCopias = new File("copias");
			
			if (!carpetaCopias.exists()) {
				carpetaCopias.mkdir();
			}
			
			Path a2 = Path.of("copias", "alumnos_backup.txt");
			if (!Files.exists(a2)) {
				Files.copy(a, a2);
			}
			
			/* EJERCICIO 10 */
			
			Path a3 = Path.of(carpetaDatos.getPath(), "alumnos_2026.txt");
			if (!Files.exists(a3)) {
				Files.move(a, a3);
			}
			
			/* EJERCICIO 11 */
			
			if (Files.exists(a2)) {
				Files.delete(a2);
			} else {
				System.out.println("El fichero no existe");
			}
			
			/* EJERCICIO 12 */
			
			System.out.println("\n=== EJERCICIO 12 ===");
			
			Path error = Path.of("error", "error.txt");
			Files.createFile(error);
				
		} catch (IOException e) {
			System.out.println("¡Se ha producido un error de entrada/salida!");
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
