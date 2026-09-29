package ejerciciosFicheros.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

	public class GestorAplicaciones {
		
		public static void main(String[] args) {
			
			try (Scanner leer = new Scanner(System.in)) {
				int opcion;
				do {
					System.out.println("1. Crear fichero\n2. Añadir calificación\n3. Mostrar calificaciones\n"
							+ "4. Mostrar calificaciones aprobadas\n5. Calcular nota media\n6. Mostrar registros por nombre del alumno\n"
							+ "0. Salir\n");
					System.out.print("Elige una opción: ");
					opcion = leer.nextInt();
					
					leer.nextLine();
					
					Path p = Path.of("calificaciones.csv");
					
					switch (opcion) {
					case 1:
						crearFichero(p);
						break;
					case 2:
						aniadirCalificacion(leer, p);
						break;
					case 3:
						mostrarCalificaciones(p);
						break;
					case 4:
						mostrarCalificacionesAprobadas(p);
						break;
					case 5:
						calcularMedia(p);
						break;
					case 6:
						mostrarRegistrosAlumno(leer, p);
						break;
					}
					
				} while (opcion != 0);
				
				System.out.println("Saliendo del programa...");
				
			} catch (IOException e) {
				e.getMessage();
			} catch (InputMismatchException e) {
				e.getMessage();
			}
			
		}

		private static void mostrarRegistrosAlumno(Scanner leer, Path p) throws FileNotFoundException, IOException {
			FileReader fr = new FileReader(p.toFile());
			BufferedReader br = new BufferedReader(fr);
			
			System.out.print("\nDime el nombre del alumno: ");
			String nombre = leer.nextLine();
			
			String linea;
			String[] lineas;
			
			br.readLine();
			System.out.println("Registros del alumno " + nombre + ":");
			System.out.println("ID\tNOMBRE\tMÓDULO\tNOTA");
			
			while ((linea = br.readLine()) != null) {
				lineas = linea.split(";");
				
				if (lineas[1].equalsIgnoreCase(nombre)) {
					System.out.println(lineas[0] + "\t" + lineas[1] + " \t" + lineas[2] + "\t" + lineas[3]);
				}
			}
			
			br.close();
		}

		private static void calcularMedia(Path p) throws FileNotFoundException, IOException {
			double media = 0;
			int totalAlumnos = 0;
			
			FileReader fr = new FileReader(p.toFile());
			BufferedReader br = new BufferedReader(fr);
			
			String linea;
			String[] lineas;
			
			br.readLine();
			
			while ((linea = br.readLine()) != null) {
				lineas = linea.split(";");
				
				media += Double.parseDouble(lineas[3]);
				totalAlumnos++;
			}
			
			System.out.println("\nLa nota media de los alumnos es: " + media / totalAlumnos + "\n");
			
			br.close();
		}

		private static void mostrarCalificacionesAprobadas(Path p) throws FileNotFoundException, IOException {
			FileReader fr = new FileReader(p.toFile());
			BufferedReader br = new BufferedReader(fr);
			
			System.out.println("\nCalificaciones de los alumnos aprobados: ");
			
			br.readLine();
			System.out.println("ID\tNOMBRE\tMÓDULO\tNOTA");
			
			String linea;
			String[] lineas;
			
			while ((linea = br.readLine()) != null) {
				lineas = linea.split(";");
				
				if (Double.parseDouble(lineas[3]) >= 5.00) {
					System.out.println(lineas[0] + "\t" + lineas[1] + "\t" + lineas[2] + "\t" + lineas[3]);
				}
			}
			
			System.out.println();
			
			br.close();
		}

		private static void mostrarCalificaciones(Path p) throws FileNotFoundException, IOException {
			FileReader fr = new FileReader(p.toFile());
			BufferedReader br = new BufferedReader(fr);
			
			System.out.println("\nCalificaciones de los alumnos: ");
			
			br.readLine();
			System.out.println("ID\tNOMBRE\tMÓDULO\tNOTA");
			
			String linea;
			String[] lineas;
			
			while ((linea = br.readLine()) != null) {
				lineas = linea.split(";");
				System.out.println(lineas[0] + "\t" + lineas[1] + "\t" + lineas[2] + "\t" + lineas[3]);
			}
			
			System.out.println();
			
			br.close();
		}

		private static void aniadirCalificacion(Scanner leer, Path p) throws IOException {
			FileWriter fw = new FileWriter(p.toFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.print("\nDime el id del alumno: ");
			String id = leer.nextLine();
			
			System.out.print("Dime el nombre del alumno: ");
			String nombre = leer.nextLine();
			
			System.out.print("Dime el módulo del alumno: ");
			String modulo = leer.nextLine();
			
			System.out.print("Dime la nota del alumno:");
			String nota = leer.nextLine();
			
			bw.write(id + ";" + nombre + ";" + modulo + ";" + nota);
			bw.newLine();
			
			System.out.println();
			
			bw.close();
		}

		private static void crearFichero(Path p) throws IOException {
			if (!Files.exists(p)) {
				Files.createFile(p);
				FileWriter fw = new FileWriter(p.toFile());
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write("ID;NOMBRE;MÓDULO;NOTA");
				bw.newLine();
				
				bw.close();
				
				System.out.println("\nFichero creado\n");
			}
		}
		
	}
