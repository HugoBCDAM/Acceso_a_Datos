package ejerciciosFicheros.ejerciciosSemanaCuatro.ej2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		
		int exp, edad;
		String nombre;
		double nota;
		
		File f = new File("alumnos.dat");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Dime el número de expediente del alumno");
			exp = leer.nextInt();
			
			if (exp < 0) {
				System.out.println("No se puede introducir un número de expediente negativo");
				return;
			}
			
			leer.nextLine();
			
			System.out.println("Dime el nombre del alumno");
			nombre = leer.nextLine();
			
			if (nombre.isEmpty()) {
				System.out.println("El nombre del alumno no puede estar vacío");
				return;
			}
			
			System.out.println("Dime la edad del alumno");
			edad = leer.nextInt();
			
			if (edad < 0) {
				System.out.println("La edad no puede ser negativa");
				return;
			}
			
			leer.nextLine();
			
			System.out.println("Dime la nota del alumno");
			nota = leer.nextDouble();
			
			if (nota < 0) {
				System.out.println("No se puede tener nota negativa");
				return;
			}
			
			try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(f, true))) {
				dout.writeInt(exp);
				dout.writeUTF(nombre);
				dout.writeInt(edad);
				dout.writeDouble(nota);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try (DataInputStream din = new DataInputStream(new FileInputStream(f))) {
			while (true) {
				System.out.println("------------------");
				Alumno a = new Alumno(din.readInt(), din.readUTF(), din.readInt(), din.readDouble());
				System.out.println(a.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		leer.close();
	}

}
