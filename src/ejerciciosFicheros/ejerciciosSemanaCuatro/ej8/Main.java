package ejerciciosFicheros.ejerciciosSemanaCuatro.ej8;

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
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		
		Vehiculo v1 = new Vehiculo("1234ABC", "Seat", "Ibiza", 85000, 450.50);
	    Vehiculo v2 = new Vehiculo("5678DEF", "Toyota", "Corolla", 120000, 700.00);
	    Vehiculo v3 = new Vehiculo("9012GHI", "BMW", "Serie 3", 60000, 1200.75);
	    
	    vehiculos.add(v1);
	    vehiculos.add(v2);
	    vehiculos.add(v3);
	    
	    File f = new File("vehiculos.dat");
	    
	    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
	    	for (int i = 0; i < vehiculos.size(); i++) {
	    		out.writeObject(vehiculos.get(i));
	    	}
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("======= VEHÍCULOS =======\n");
	    Vehiculo vehiculoCaro = null;
	    int masCienMil = 0, totalFacturado = 0;
	    double reparacionCara = 0;
	    
	    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
	    	while (true) {
	    		Vehiculo v = (Vehiculo) in.readObject();
	    		
	    		if (v.getKilometros() >= 100000) {
	    			masCienMil++;
	    		}
	    		
	    		if (v.getCosteReparacion() > reparacionCara) {
	    			reparacionCara = v.getCosteReparacion();
	    			vehiculoCaro = v;
	    		}
	    		
	    		totalFacturado += v.getCosteReparacion();
	    		
	    		System.out.println(v.toString());
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
	    
	    System.out.println("\n======= VEHÍCULOS =======\n");
	    System.out.println("Total de vehículos registrados: " + Vehiculo.getTotalVehiculos() + " vehículo");
	    System.out.println("Vehículos con más de 100.000 kilómetros: " + masCienMil);
	    System.out.println("El vehículo cuya reparación es la más cara: " + vehiculoCaro.toString());
	    System.out.println("Importe total facturado en reparaciones: " + totalFacturado);
	    
	}

}
