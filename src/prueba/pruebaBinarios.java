package prueba;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class pruebaBinarios {

	public static void main(String[] args) {
		
		boolean aprobado = true;
		String nombre = "PRG";
		int conv = 1;
		double nota = 7.8;
		
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("ejemplo.dat"));
			out.writeBoolean(aprobado);
			out.writeUTF(nombre);
			out.writeInt(conv);
			out.writeDouble(nota);
			out.close();
			
			DataInputStream in = new DataInputStream(new FileInputStream("ejemplo.dat"));
			System.out.println("Valor leido de aprobado: "+ in.readBoolean());
			System.out.println("Valor leido de nombre: "+ in.readUTF());
			System.out.println("Valor leido de convocatoria: "+ in.readInt());
			System.out.println("Valor leido de nota: "+ in.readDouble());
			in.close();
		} catch (FileNotFoundException e) { 
			System.out.println("No encontrado");
		} catch (IOException e) { 
			System.out.println("Problemas al escribir"); 
		}

	}

}
