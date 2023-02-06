package complementarios;

import java.util.HashMap;
import java.util.Scanner;

public class Hashmap {



    public static void main(String[] args) {
    	
    	String carnet, nombres;
    	
		HashMap<String, String> estudiantes = new HashMap<String, String>();
   	
    	System.out.println(estudiantes);
    	
    	
    	Scanner reader = new Scanner (System.in);
    	int select = 0 ; 
        
        while(select != 4){
       
            try{
                System.out.println("Elige opción:\n1.- Ingreso de estudiante" +
                        "\n2.- Ver estudiantes\n" +
                        "3.- Buscar estudiantes\n" +
                        "4.- Salir\n");
                select = reader.nextInt();

                switch(select){
                    case 1:
                        System.out.println("Ingrese las credenciales");
                        System.out.println("Ingrese el carnet del estudiante");
                        reader.next();
                        carnet = reader.nextLine();
                        System.out.println("Ingrese los nombres del estudiante");
                        nombres = reader.nextLine();
                    	estudiantes.put(carnet, nombres);
                        System.out.println("Registrado con exito!");
                        
                        break;
                    case 2:

                    	System.out.println(estudiantes);
                		
                        break;
                    case 3:
                    	
                    	System.out.println("Ingrese el carnet del estudiante");
                    	carnet = reader.next();
                    	System.out.println("El carnet es: "+carnet+" pertenece a "+estudiantes.get(carnet));

                    	
                    	
                        break;	
                    case 4:
                    	System.out.println("Este es el cuarto case");
                        break;    
                    default:
                    	System.out.println("Solo numeros del 1 al 4");
                        break;
                        }

                
            }catch(Exception e){
                System.out.println("No puede ingresar palabras, solo numeros");
                reader.next();
            }

        }

    }
}