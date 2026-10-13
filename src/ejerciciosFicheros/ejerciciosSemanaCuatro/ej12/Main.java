package ejerciciosFicheros.ejerciciosSemanaCuatro.ej12;

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
		int opcion;
		ArrayList<Alumno> alumnos = new ArrayList<>();
		File f = new File("alumnos_serializados.dat");
		
		do {
			System.out.println("Menú:\n1. Añadir alumno\n2. Mostrar todos los alumnos\n3. Buscar alumno por expediente\n"
					+ "4. Mostrar alumnos aprobados\n5. Mostrar alumnos con mayor nota media\n6. Eliminar alumno\n"
					+ "7. Guardar datos\n8. Cargar datos\n0. Salir");
			System.out.print("\nElija una opcioón del menú: ");
			opcion = leer.nextInt();
			
			leer.nextLine();
			
			switch (opcion) {
			case 1:
				aniadirAlumno(leer, alumnos);
				break;
			case 2:
				mostrarAlumnos(alumnos);
				break;
			case 3:
				buscarExpediente(leer, alumnos);
				break;
			case 4:
				mostrarAprobados(alumnos);
				break;
			case 5:
				mostrarMayorNota(alumnos);
				break;
			case 6:
				eliminarAlumno(leer, alumnos);
				break;
			case 7:
				guardarDatos(alumnos, f);
				break;
			case 8:
				cargarDatos(alumnos, f);
				break;
			default:
				System.out.println("\nDebes introducir una opción válida del menú\n");
				break;
			}
		} while (opcion != 0);
		
		leer.close();
	}

	private static void cargarDatos(ArrayList<Alumno> alumnos, File f) {
		if (f.exists()) {
			ArrayList<Alumno> copia = new ArrayList<>();
			
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
				while (true) {
					Alumno a = (Alumno) in.readObject();
					copia.add(a);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				alumnos.clear();
				alumnos.addAll(copia);
				
				System.out.println("\nDatos cargados con éxito\n");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("\nEl archivo de guardado para poder leer no existe\n");
		}
	}

	private static void guardarDatos(ArrayList<Alumno> alumnos, File f) {
		if (alumnos.size() > 0) {
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
				for (int i = 0; i < alumnos.size(); i++) {
					out.writeObject(out);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("\nDatos guardados con éxito\n");
		} else {
			System.out.println("\nNo existe ningún alumno almacenado\n");
		}
	}

	private static void eliminarAlumno(Scanner leer, ArrayList<Alumno> alumnos) {
		String entrada;
		int num;
		
		if (alumnos.size() > 0) {
			try {
				System.out.print("\nIntroduzca el número de expediente del alumno: ");
				entrada = leer.nextLine();
				
				num = Integer.parseInt(entrada);
				boolean existe = false;
				
				for (int i = 0; i < alumnos.size(); i++) {
					if (alumnos.get(i).getNumExp() == num) {
						alumnos.remove(i);
						existe = true;
						break;
					}
				}
				
				if (!existe) {
					System.out.println("El alumno con el número de expediente: " + num + " no existe\n");
				} else {
					System.out.println("El alumno con el número de expediente: " + num + " eliminado\n");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Error: el valor introducido no es válido\n");
			}
		} else {
			System.out.println("\nNo existe ningún alumno almacenado\n");
		}
	}

	private static void mostrarMayorNota(ArrayList<Alumno> alumnos) {
		double notaMax = 0;
		
		if (alumnos.size() > 0) {
			for (int i = 0; i < alumnos.size(); i++) {
				if (alumnos.get(i).getNotaMedia() > notaMax) {
					notaMax = alumnos.get(i).getNotaMedia();
				}
			}
			
			System.out.println("\nAlumno/s con mayor nota media:");
			
			for (int i = 0; i < alumnos.size(); i++) {
				if (alumnos.get(i).getNotaMedia() == notaMax) {
					System.out.println(alumnos.get(i).toString());
				}
			}
		} else {
			System.out.println("\nNo existe ningún alumno almacenado\n");	
		}
	}

	private static void mostrarAprobados(ArrayList<Alumno> alumnos) {
		if (alumnos.size() > 0) {
			System.out.println("\nAlumnos aprobados:");
			
			for (int i = 0; i < alumnos.size(); i++) {
				if (alumnos.get(i).getNotaMedia() >= 5) {
					System.out.println(alumnos.get(i).toString());
				}
			}
			
			System.out.println("");
		} else {
			System.out.println("\nNo existe ningún alumno almacenado\n");
		}
	}

	private static void buscarExpediente(Scanner leer, ArrayList<Alumno> alumnos) {
		String entrada;
		boolean existe = false;
		
		if (alumnos.size() > 0) {
			try {
				int exp;
				System.out.print("\nIntroduce el número del expediente del alumno a buscar: ");
				entrada = leer.nextLine();
				
				exp = Integer.parseInt(entrada);
				
				for (int i = 0; i < alumnos.size(); i++) {
					if (alumnos.get(i).getNumExp() == exp) {
						System.out.println(alumnos.get(i).toString() + "\n");
						existe = true;
					}
				}
				
				if (!existe) {
					System.out.println("El alumno no existe");
				}
				
				System.out.println("");
			} catch (NumberFormatException e) {
				System.out.println("Error: el valor introducido no es válido\n");
			}
		} else  {
			System.out.println("\nNo existe ningún alumno guardado para poder buscar\n");
		}
	}

	private static void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		if (alumnos.size() > 0) {
			System.out.println("\n====== ALUMNOS ======\n");
			
			for (int i = 0; i < alumnos.size(); i++) {
				System.out.println(alumnos.get(i).toString());
			}

			System.out.println("\n====== ALUMNOS ======|n");
		} else {
			System.out.println("\nNo hay ningún alumno.\n");
		}
	}

	private static void aniadirAlumno(Scanner leer, ArrayList<Alumno> alumnos) {
		String entrada;
		
		try {
			int exp;
			System.out.print("\nIntroduzca el número de expediente del alumno: ");
			entrada = leer.nextLine();
			
			exp = Integer.parseInt(entrada);
			
			String nombre;
			System.out.print("Introduzca el nombre del alumno: ");
			nombre = leer.nextLine();
			
			if (nombre.isBlank()) {
				System.out.println("Error: el campo no puede estar vacío. Intentalo de nuevo");
				return;
			}
			
			String apellidos;
			System.out.print("Introduzca los apellidos del alumno: ");
			apellidos = leer.nextLine();
			
			if (apellidos.isBlank()) {
				System.out.println("Error: el campo no puede estar vacío. Intentalo de nuevo");
				return;
			}
			
			String ciclo;
			System.out.print("Introduzca el ciclo del alumno: ");
			ciclo = leer.nextLine();
			
			if (ciclo.isBlank()) {
				System.out.println("Error: el campo no puede estar vacío. Intentalo de nuevo");
				return;
			}
			
			double nota;
			System.out.print("Introduzca la nota del alumno: ");
			entrada = leer.nextLine();
			
			nota = Double.parseDouble(entrada);
			
			leer.nextLine();
			
			alumnos.add(new Alumno(exp, nombre, apellidos, ciclo, nota));
			
			System.out.println("Alumno añadido con éxito\n");
		} catch (NumberFormatException e) {
			System.out.println("Error: no introdujiste un valor válido\n");
			return;
		}
	}

}
