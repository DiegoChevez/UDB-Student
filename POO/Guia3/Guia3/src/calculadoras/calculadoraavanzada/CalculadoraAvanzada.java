package calculadoras.calculadoraavanzada;

import java.util.*;

public class CalculadoraAvanzada {
	
	@SuppressWarnings("resource")
	public static void main (String[]args) {
		
		MetodosAvanzados operaciones= new MetodosAvanzados();
		
		Scanner reader = new Scanner(System.in);
	
		int opciones;
		int numero1, resultado = 0;
		double factorial = 1;
		
		boolean validacion = true;
		
		do { 
			try {
			
				do {
					
					
					System.out.println("---------------Menu-------------------");
					System.out.println("1. Potencia");
					System.out.println("2. Opuesto");
					System.out.println("3. Factorial");
					System.out.println("0. Salir");
					System.out.println("----------------------------------------");
					System.out.println("Ingrese una opción");
					
					opciones=reader.nextInt();
					switch (opciones) {
					
					case 1: 
						System.out.println("Ingrese el número: ");
						numero1= reader.nextInt();
						operaciones.potencia(numero1, resultado);
						break;
						
					case 2:
					System.out.println("Ingrese el número: ");
					numero1= reader.nextInt();
					operaciones.opuesto(numero1, resultado);
					break;
					
					case 3:
						System.out.println("Ingrese el primer número: ");
						numero1= reader.nextInt();
						
						operaciones.factorial(numero1, factorial, resultado);
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
