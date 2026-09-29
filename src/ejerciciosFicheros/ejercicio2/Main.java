package ejerciciosFicheros.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
			
			br3.close();
			
			/* EJERCICIO 7 */
			Path p2 = Path.of("alumnos.csv");
			if (!Files.exists(p2)) {
				Files.createFile(p2);
			}
			
			FileWriter fw2 = new FileWriter(p2.toFile());
			BufferedWriter bw2 = new BufferedWriter(fw2);
			
			bw2.write("ID;NOMBRE;EDAD;CICLO");
			bw2.newLine();
			bw2.write("1;Carlos;20;SMR");
			bw2.newLine();
			bw2.write("2;Luis;21;DAM");
			bw2.newLine();
			bw2.write("3;Ana;19;SMR");
			bw2.newLine();
			bw2.write("4;Adrián;20;ASIR");
			bw2.newLine();
			bw2.write("5;Carolina;21;DAW");
			
			bw2.flush();
			
			/* EJERCICIO 8 */
			System.out.println("\n=== EJERCICIO 8 ===");
			FileReader fr5 = new FileReader(p2.toFile());
			BufferedReader br4 = new BufferedReader(fr5);
			
			String linea4;
			String[] campos;
			
			br4.readLine();
			
			System.out.println("ID\tNOMBRE\tEDAD\tCICLO");
			
			while ((linea4 = br4.readLine()) != null) {
				campos = linea4.split(";");
				System.out.println(campos[0] + "\t" + campos[1] + "\t" + campos[2] + "\t" + campos[3]);
			}
			
			br4.close();
			
			/* EJERCICIO 9 */
			System.out.println("\n=== EJERCICIO 9 ===");
			FileReader fr6 = new FileReader(p2.toFile());
			BufferedReader br5 = new BufferedReader(fr6);
			
			String linea5;
			String[] campos2;
			
			br5.readLine();
			
			System.out.println("ID\tNOMBRE\tEDAD\tCICLO");
			
			while ((linea5 = br5.readLine()) != null) {
				campos2 = linea5.split(";");
				
				if (campos2[3].equalsIgnoreCase("DAM")) {
					System.out.println(campos2[0] + "\t" + campos2[1] + "\t" + campos2[2] + "\t" + campos2[3]);
				}
			}
			
			br5.close();
			
			/* EJERCICIO 10 */
			System.out.println("\n=== EJERCICIO 10 ===");
			FileReader fr7 = new FileReader(p2.toFile());
			BufferedReader br6 = new BufferedReader(fr7);
			
			String linea6;
			String[] campos3;
			int media = 0, totalLineas = 0;
			
			br6.readLine();
			
			while ((linea6 = br6.readLine()) != null) {
				campos3 = linea6.split(";");
				media += Integer.parseInt(campos3[2]);
				totalLineas++;
			}
			
			br6.close();
			
			System.out.println("La edad media de los alumnos es: " + media / totalLineas);
			
			/* EJERCICIO 11 */
			FileReader fr8 = new FileReader(p2.toFile());
			BufferedReader br7 = new BufferedReader(fr8);
			
			String linea7;
			String[] campos4;
			ArrayList<Alumno> alumnos = new ArrayList<>();
			
			br7.readLine();
			
			while ((linea7 = br7.readLine()) != null) {
				campos4 = linea7.split(";");
				
				String id = campos4[0];
				String nombre = campos4[1];
				int edad = Integer.parseInt(campos4[2]);
				String ciclo = campos4[3];
				
				Alumno alumno = new Alumno(id, nombre, edad, ciclo);
				
				alumnos.add(alumno);
			}
			
			br7.close();
			bw2.close();
			
			/* EJERCICIO 12 */
			Path p3 = Path.of("salida_alumnos.csv");
			
			if (!Files.exists(p3)) {
				Files.createFile(p3);
			}
			
			FileWriter fw3 = new FileWriter(p3.toFile());
			BufferedWriter bw3 = new BufferedWriter(fw3);
			
			bw3.write("ID;NOMBRE;EDAD;CICLO");
			bw3.newLine();
			
			// Utilizo el arraylist con los alumnos creado en el ejercicio 11
			for (Alumno alumno : alumnos) {
				bw3.write(alumno.getId() + ";" + alumno.getNombre() + ";" + alumno.getEdad() + ";" + alumno.getCiclo());
				bw3.newLine();
			}
			
			bw3.close();
			leer.close();
			
			/* EJERCICIO 13 */
			System.out.println("\n=== EJERCICIO 13 ===");
			Path p4 = Path.of("caracteres.txt");
			
			if (!Files.exists(p4)) {
				Files.createFile(p4);
			}
			
			Files.writeString(p4, "¿Cómo estas? España, niño, áéíóú", StandardCharsets.UTF_8);
			
			FileReader fr9 = new FileReader(p4.toFile());
			BufferedReader br8 = Files.newBufferedReader(p4, StandardCharsets.UTF_8);
			
			String linea8;
			
			while ((linea8 = br8.readLine()) != null) {
				System.out.println(linea8);
			}
			
			br8.close();
			fr9.close();
			
			/* EJERCICIO 14 */
			System.out.println("\n=== EJERCICIO 14 ===");
			Path p5 = Path.of("files.txt");
			
			if (!Files.exists(p5)) {
				Files.createFile(p5);
			}
			
			Files.writeString(p5, "Hola, ¿Cómo estás?");
			
			System.out.println(Files.readString(p5));
			
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
