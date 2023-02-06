package HashMap;

import java.util.HashMap;
import java.util.*;

public class HashMapUse {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String carnet, nombre;
		int Opcion;
		
		OpcionesHashMap op = new OpcionesHashMap();
		
		HashMap<String, String> pooStudents = new HashMap<String, String>();
		Scanner reader = new Scanner(System.in); 
		
	    pooStudents.put("FG220265","ErickFuentes");
		pooStudents.put("CZ220876","BryanCornejo");
		
		System.out.println(pooStudents);
		
		try {
			
do {
				
				System.out.println("----------------------Menú---------------------");
				System.out.println("| 1. Ingreso estudiantes                      |");
				System.out.println("| 2. Ver estudiantes                          |");
				System.out.println("| 3. Buscar estudiante                        |");
				System.out.println("| 4. Salir                                    |");
				System.out.println("-----------------------------------------------");
				
					
					System.out.println("Seleccionar Opción: ");
					Opcion = reader.nextInt();

					switch(Opcion) {
					
					case 1:
						
						System.out.println("Introduce el carnet del estudiante: ");
						carnet = reader.next();
						System.out.println("Introduce el nombre del estudiante");
						nombre = reader.next();
						op.ingresoDatos(carnet ,nombre, pooStudents);
						
						break;
						
					case 2:
						
						System.out.println("Listado de estudiantes de POO");
						op.verEstudiante(pooStudents);
						break;
						
					case 3:
						
						System.out.println("Introduzca el carnet del estudiante a buscar: ");
						carnet = reader.next();
						op.buscarEstudiante(carnet, pooStudents);
					
						
						break;
					
					case 4:
						
						break;
					
					default:
						
						System.out.print("Opción no valida intentelo de nuevo");
						break;
					 }
			}while(Opcion!=4);
			
			System.out.println("Saliendo del programa");

			
		}catch(InputMismatchException e) {
			
			System.out.println("No se aceptan letras");
			reader.next();
			
	  }		
			
	}

  }


		
	      

         
