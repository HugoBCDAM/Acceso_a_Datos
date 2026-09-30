package prueba.pruebaBinarios2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		
		Grupo dam = new Grupo("DAM");
		dam.agregarAlumno(new Alumno("Pep", "1111A", 15));
		dam.agregarAlumno(new Alumno("Tom", "2222A", 17));
		
		try {
			FileOutputStream fos = new FileOutputStream("archivo.dat");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(dam);
			out.close();
			
			dam = null;
			
			FileInputStream fis = new FileInputStream("archivo.dat");
			ObjectInputStream in = new ObjectInputStream(fis);
			dam = (Grupo) in.readObject();
			in.close();
			
			System.out.println(dam.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
