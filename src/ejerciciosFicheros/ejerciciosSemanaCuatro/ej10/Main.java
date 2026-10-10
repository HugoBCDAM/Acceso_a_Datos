package ejerciciosFicheros.ejerciciosSemanaCuatro.ej10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Carlos García", "carlos@gmail.com", "1234ABCD");
		
		File f = new File("usuarios.dat");
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
			out.writeObject(usuario);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
			Usuario u = (Usuario) in.readObject();
			
			System.out.println(u.toString());	
			/* 
			 * El atributo password contendrá el valor null ya que a la hora de deseralizar,
			 * este atributo contendrá el valor por defecto de cada tipo (null para objetos, 0 para números, false para booleanos).
			 * Se utiliza para proteger datos sensibles como contraseñas.
			*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
