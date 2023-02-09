package Ejercicio1;

import java.util.Scanner;

public class DatosEstudiante {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int menu;

		Estudiante funciones = new Estudiante("","", "", "","","", 0);

		do{
			System.out.println("					Menu");
			System.out.println("------------------------------------------------");
			System.out.println("|	1. Registrarse					|");
			System.out.println("|	2. Inscribir							|");
			System.out.println("|	3. Ver Informacion						|");
			System.out.println("|	4. Salir									|");
			System.out.println("------------------------------------------------");
			System.out.print("Ingresa tu opcion...\n");
			menu = reader.nextInt();

			switch (menu) {
				case 1 -> {
					funciones.registrar();
					System.out.println("------------------------------------------------");
					System.out.print("Ingresa tu opcion...\n");
					System.out.print("Deseas volver: [1]Si  [0]No\n");
					menu = reader.nextInt();
				}
				case 2 -> {
					funciones.materias();
					System.out.println("------------------------------------------------");
					System.out.print("Ingresa tu opcion...\n");
					System.out.print("Deseas volver: [1]Si  [0]No\n");
					menu = reader.nextInt();
				}
				case 3 -> {
					funciones.mostrar();
					System.out.print("Ingresa tu opcion...\n");
					System.out.print("Deseas volver: [1]Si  [0]No\n");
					menu = reader.nextInt();
				}
				case 4 -> System.exit(0);
				default -> System.exit(1);
			}
		}while(menu >= 1);
	}
}
