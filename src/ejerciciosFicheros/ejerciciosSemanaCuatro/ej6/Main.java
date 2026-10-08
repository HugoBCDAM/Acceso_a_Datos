package ejerciciosFicheros.ejerciciosSemanaCuatro.ej6;

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
		
		ArrayList<Empleado> empleados = new ArrayList<>();
		File f = new File("empleados.dat");
		
		Empleado e1 = new Empleado(1, "Ana", "Recursos Humanos", 25000);
		Empleado e2 = new Empleado(2, "Carlos", "Informática", 32000);
		Empleado e3 = new Empleado(3, "Laura", "Ventas", 28000);
		Empleado e4 = new Empleado(4, "Miguel", "Contabilidad", 30000);
		Empleado e5 = new Empleado(5, "Sara", "Marketing", 27000);
		
		empleados.add(e1);
		empleados.add(e2);
		empleados.add(e3);
		empleados.add(e4);
		empleados.add(e5);
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
			for (int i = 0; i < empleados.size(); i++) {
				out.writeObject(empleados.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		double media = 0.0;
		double alto = 0.0;
		Empleado empleadoAlto = null;
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				Empleado e = (Empleado) in.readObject();
				media += e.getSalario();
				
				if (e.getSalario() > alto) {
					alto = e.getSalario();
					empleadoAlto = e;
					
				}
				System.out.println(e.toString());
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
		
		System.out.println("Total empleados: " + Empleado.getTotalEmpleados());
		System.out.println("Salario medio: " + media / Empleado.getTotalEmpleados());
		System.out.println("Empleado con el salario más alto: " + empleadoAlto.toString());
	}

}
