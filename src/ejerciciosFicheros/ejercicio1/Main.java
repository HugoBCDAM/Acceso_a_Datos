package ejerciciosFicheros.ejercicio1;

import java.io.File;
import java.io.IOException;

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
			
			System.out.println("\n=== EJERCICIO 3 ===");
			if (carpeta.exists()) {
				System.out.println("La carpeta está creada");
			} else {
				System.out.println("La carpeta no está creada");
			}
			
			/* EJERCICIO 4 */
			File d = new File("proyecto/datos/copias/informes/");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
