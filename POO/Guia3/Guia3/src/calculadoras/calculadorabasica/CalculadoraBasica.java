package calculadoras.calculadorabasica;

import java.util.*;

public class CalculadoraBasica {
	
	@SuppressWarnings("resource")
	public static void main (String[]args) {
		
		MetodosAritmeticos operaciones= new MetodosAritmeticos();
		
		Scanner reader = new Scanner(System.in);
	
		int opciones;
		int numero1, numero2, resultado = 0;
		
		boolean validacion = true;
		
		do { 
			try {
			
				do {
					
					
					System.out.println("---------------Menu-------------------");
					System.out.println("1. Suma");
					System.out.println("2. Resta");
					System.out.println("3. Multiplicación ");
					System.out.println("4. División");
					System.out.println("0. Salir");
					System.out.println("----------------------------------------");
					System.out.println("Ingrese una opción");
					
					opciones=reader.nextInt();
					switch (opciones) {
					
					case 1: 
						System.out.println("Ingrese el primer número: ");
						numero1= reader.nextInt();
						System.out.println("Ingrese el segundo número: ");
						numero2= reader.nextInt();
						
						
						
						operaciones.suma(numero1, numero2, resultado);
						break;
						
					case 2:
					System.out.println("Ingrese el primer número: ");
					numero1= reader.nextInt();
					System.out.println("Ingrese el segundo número: ");
					numero2= reader.nextInt();
					
					operaciones.resta(numero1, numero2, resultado);
					break;
					
					case 3:
						System.out.println("Ingrese el primer número: ");
						numero1= reader.nextInt();
						System.out.println("Ingrese el segundo número: ");
						numero2= reader.nextInt();
						
						operaciones.multiplicacion(numero1, numero2, resultado);
						break;
						
					case 4: 
						System.out.println("Ingrese el primer número: ");
						numero1= reader.nextInt();
						System.out.println("Ingrese el segundo número: ");
						numero2= reader.nextInt();
						
						operaciones.division(numero1, numero2, resultado);
						break;
						
					case 0:
						break;
							
						default:
							System.out.println("valor no válido");
							break;
					} 
					
				} while (opciones!=0);
			
		}
		catch (InputMismatchException e) {
			
			System.out.println("No se permiten letras");
			reader.nextLine();
			
		}
		
			
		} while(validacion);
		
		
		
		
	}
	
}
