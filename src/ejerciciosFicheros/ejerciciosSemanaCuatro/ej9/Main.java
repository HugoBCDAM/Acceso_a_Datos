package ejerciciosFicheros.ejerciciosSemanaCuatro.ej9;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		File f = new File("cursos.dat");
		
		Profesor p1 = new Profesor("Carlos García", "carlos@gmail.com");
		Profesor p2 = new Profesor("María López", "maria@gmail.com");
		Profesor p3 = new Profesor("Javier Martín", "javier@gmail.com");

		Curso c1 = new Curso("Java", 60, p1);
		Curso c2 = new Curso("Bases de datos", 45, p2);
		Curso c3 = new Curso("Programación web", 80, p3);
		
		ArrayList <Curso> cursos = new ArrayList<>();
		
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
			for (int i = 0; i < cursos.size(); i++) {
				out.writeObject(cursos.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				Curso c = (Curso) in.readObject();
				System.out.println(c.toString() + "\n");
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
