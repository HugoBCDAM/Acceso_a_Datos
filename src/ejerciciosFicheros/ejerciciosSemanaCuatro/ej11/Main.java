package ejerciciosFicheros.ejerciciosSemanaCuatro.ej11;

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
		ArrayList<Cliente> clientes = new ArrayList<>();
		File f = new File("clientes_backup.dat");
		
		do {
			System.out.println("Menú:\n1. Añadir cliente\n2. Mostrar clientes\n3. Buscar cliente\n"
					+ "4. Eliminar cliente\n5. Guardar copia de seguridad\n6. Recuperar copia de seguridad\n0. Salir");
			System.out.print("\nElija una opción del menú: ");
			opcion = leer.nextInt();
			
			leer.nextLine();
			
			switch(opcion) {
			case 1:
				aniadirCliente(leer, clientes);
				break;
			case 2:
				mostrarClientes(clientes);
				break;
			case 3:
				buscarCliente(leer, clientes);
				break;
			case 4:
				eliminarCliente(leer, clientes);
				break;
			case 5:
				guardarCopia(clientes, f);
				break;
			case 6:
				recuperarCopia(clientes, f);
				break;
			default:
				if (opcion != 0) {
					System.out.println("\nIntroduzca una opción válida del menú");
				}
				break;
			}
		} while (opcion != 0);
		
		System.out.println("\nSaliendo...");
		
		leer.close();
	}

	private static void recuperarCopia(ArrayList<Cliente> clientes, File f) {
		ArrayList <Cliente> copia = new ArrayList<>();
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				Cliente c = (Cliente) in.readObject();
				
				copia.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			clientes.clear();
			clientes.addAll(copia);
			
			System.out.println("\nCopia de seguridad recuperada con éxito.\n");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void guardarCopia(ArrayList<Cliente> clientes, File f) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
			for (int i = 0; i < clientes.size(); i++) {
				out.writeObject(clientes.get(i));
			}
			
			System.out.println("\nCopia de seguridad realizada con éxito.\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void eliminarCliente(Scanner leer, ArrayList<Cliente> clientes) {
		int cod;
		System.out.print("\nIntroduzca el código del cliente a eliminar: ");
		cod = leer.nextInt();
		
		leer.nextLine();
		
		boolean existe = false;
		
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCod() == cod) {
				clientes.remove(i);
				System.out.println("Cliente eliminado con éxito.\n");
				existe = true;
				break;
			}
		}
		
		if (!existe) {
			System.out.println("El cliente no existe.\n");
		}
	}

	private static void buscarCliente(Scanner leer, ArrayList<Cliente> clientes) {
		int cod;
		System.out.print("\nIntroduzca el código del cliente que quieres buscar: ");
		cod = leer.nextInt();
		
		leer.nextLine();
		
		boolean existe = false;
		
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCod() == cod) {
				System.out.println(clientes.get(i).toString() + "\n");
				existe = true;
				break;
			}
		}
		
		if (!existe) {
			System.out.println("El cliente no existe\n");
		}
	}

	private static void mostrarClientes(ArrayList<Cliente> clientes) {
		System.out.println("\n====== CLIENTES ======\n");
		
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).toString());
		}
		
		System.out.println("\n====== CLIENTES ======\n");
	}

	private static void aniadirCliente(Scanner leer, ArrayList<Cliente> clientes) {
		int cod;
		System.out.print("\nIntroduzca el código del cliente: ");
		cod = leer.nextInt();
		
		leer.nextLine();
		
		String nombre;
		System.out.print("Introduzca el nombre del cliente: ");
		nombre = leer.nextLine();
		
		String telefono;
		System.out.print("Introduzca el teléfono del cliente: ");
		telefono = leer.nextLine();
		
		String email;
		System.out.print("Introduzca el email del cliente: ");
		email = leer.nextLine();
		
		double saldoPendiente;
		System.out.print("Introduzca el saldo pendiente del cliente: ");
		saldoPendiente = leer.nextDouble();
		
		leer.nextLine();
		
		clientes.add(new Cliente(cod, nombre, telefono, email, saldoPendiente));
		
		System.out.println("Cliente añadido con éxito.\n");
	}

}
