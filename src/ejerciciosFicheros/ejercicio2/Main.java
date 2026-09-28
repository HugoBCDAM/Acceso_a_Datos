package ejerciciosFicheros.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* EJERCICIO 1 */
		Path p = Path.of("mensaje.txt");
		
		try {
			if (!Files.exists(p)) {
				Files.createFile(p);
			}
			
			FileWriter fw = new FileWriter(p.toFile(), true); // PARA QUE NO BORRE CUANDO SE EJECUTA DENUEVO, SE LE PONE "true" AL FINAL DEL CONSTRUCTOR
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < 3; i++) {
				bw.write("hola");
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
			/* EJERCICIO 2 */
			System.out.println("=== EJERCICIO 2 ===");
			FileReader fr = new FileReader(p.toFile());
			int caracter;
			
			while ((caracter = fr.read()) != -1) {
				System.out.print((char) caracter);
			}
			
			fr.close();
			
			/* EJERCICIO 3 */
			System.out.println("\n=== EJERCICIO 3 ===");
			FileReader fr2 = new FileReader(p.toFile());
			BufferedReader br = new BufferedReader(fr2);
			String linea;
			int contLinea = 1;
			
			while ((linea = br.readLine()) != null) {
				System.out.println(contLinea + ": " + linea);
				contLinea++;
			}
			
			br.close();
			
			/* EJERCICIO 4 */
			System.out.println("\n=== EJERCICIO 4 ===");
			FileReader fr3 = new FileReader(p.toFile());
			BufferedReader br2 = new BufferedReader(fr3);
			
			int caracteres = 0, lineas = 0, lineasVacias = 0;
			String linea2;
			
			while ((linea2 = br2.readLine()) != null) {
				lineas++;
				caracteres += linea2.length();
				
				if (linea2.isEmpty()) {
					lineasVacias++;
				}
			}
			
			System.out.println("Número de líneas: " + lineas);
			System.out.println("Total de carácteres: " + caracteres);
			System.out.println("Número de líneas vacías: " + lineasVacias);
			
			br2.close();
			
			/* EJERCICIO 5 */
			Scanner leer = new Scanner(System.in);
			System.out.println("\n=== EJERCICIO 5 ===");
			System.out.print("Introduce una palabra: ");
			String palabra = leer.nextLine();
			
			FileReader fr4 = new FileReader(p.toFile());
			BufferedReader br3 = new BufferedReader(fr4);
			String linea3;
			int totalPalabras = 0;
			
			while ((linea3 = br3.readLine()) != null) {
				if (linea3.contains(palabra)) {
					totalPalabras++;
				}
			}
			
			System.out.println("El total de líneas que contienen la palabra " + palabra + " son: " + totalPalabras);
			
			leer.close();
			br3.close();
			
			
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
