package HashMap;

import java.util.HashMap;
import java.util.Iterator;


public class OpcionesHashMap {

	public void ingresoDatos(String carnet, String nombre, HashMap <String,String> pooStudents) {
		if(pooStudents.containsKey(carnet)) {
			
			System.out.println("Error! Alumno ya registrado");
			
		}else {
			
			pooStudents.put(carnet, nombre);
			System.out.println("");

			
		}
		
	} 
	
	
	public void verEstudiante(HashMap<String, String> pooStudents) {
		
		String carnet;
		Iterator<String> estudiantes = pooStudents.keySet().iterator();
		System.out.println("Los siguientes estudiantes estan registrados para POO: ");
		while(estudiantes.hasNext()) {
			
			carnet = estudiantes.next();
			System.out.println(carnet + " - " + pooStudents.get(carnet));
			}
			
	}
		
		
	
	public  void buscarEstudiante(String carnet, HashMap <String,String> pooStudents) {
			

		if(pooStudents.containsKey(carnet)) {
			
			System.out.println(carnet + " - " + pooStudents.get(carnet));
			
		}else {
			
			System.out.println("No existe ningun alumno con ese carnet");
			
		}
			
	    }
      }
	
