package ejerciciosFicheros.ejerciciosSemanaCuatro.ej5;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("Juan", "Alberto Nuñez", 20, "12345J");
		Persona p2 = new Persona("Pedro", "Sanchez Sanchez", 21, "67890P");
		Persona p3 = new Persona("Ana", "Ballesteros Luna", 22, "09876A");
		
		File f = new File("personas.dat");
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
			out.writeObject(p1);
			out.writeObject(p2);
			out.writeObject(p3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				Persona p = (Persona) in.readObject();
				System.out.println(p.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
