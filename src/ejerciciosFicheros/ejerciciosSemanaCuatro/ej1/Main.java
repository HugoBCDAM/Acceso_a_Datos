package ejerciciosFicheros.ejerciciosSemanaCuatro.ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		File f = new File("temperaturas.dat");
		
		DataOutputStream dout;
		DataInputStream din;
		double media = 0.0, maxima = Double.MIN_VALUE, minima = Double.MAX_VALUE;
		int cant = 0;
		
		try {
			dout = new DataOutputStream(new FileOutputStream(f));
			
			dout.writeDouble(18.5);
			dout.writeDouble(19.2);
			dout.writeDouble(21.7);
			dout.writeDouble(23.1);
			dout.writeDouble(22.8);
			dout.writeDouble(20.4);
			
			dout.close();
			
			din = new DataInputStream(new FileInputStream(f));
			
			try {
		        while (true) {
		            double d = din.readDouble();

		            media += d;
		            cant++;

		            if (d > maxima) {
		                maxima = d;
		            }

		            if (d < minima) {
		                minima = d;
		            }
		        }
		    } catch (EOFException e) {
		        System.out.println("Se ha llegado al final del archivo");
		    }
			
			din.close();
			
			media /= cant;
			
			System.out.println("Máxima: " + maxima);
			System.out.println("Mínima: " + minima);
			System.out.println("Media: " + media);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
