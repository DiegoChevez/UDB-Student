package ejemplos;

import javax.swing.*;

import java.util.*;


@SuppressWarnings("unused")
public class Estudiantes {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		boolean validacion = true;
		
		Persona persona = new Persona("Erick", "FG220265" , "Computacion" , "21", "SES" , "POO" , "BDD", "SPL", "DGC");
			
		String opcion;
		
		
		int opcionInt;
		
		do {
			try {
				
				do {
					
					opcion = JOptionPane.showInputDialog(null,"Menú de opciones\n1. Ingreso de datos estudiante \n2. Mostrar datos estudiantes \n3. Ingreso datos de materia \n4. Mostrar datos materias \n0.Salir");
					opcionInt = Integer.parseInt(opcion);
					switch(opcionInt) {
					case 1:
						
						persona.ingresoDatosEstudiante();
						break;
					case 2:
						
						persona.mostrarDatosEstudiante();
						break;
					case 3:
						
						persona.ingresoDatosMaterias();
						break;
					case 4:
						
						persona.mostrarDatosMateria();
						break;
					case 0:
						System.exit(0);
						break;
						
					}
					
				}while(opcionInt != 0);
				
				
			}catch(NumberFormatException e) {
				
				JOptionPane.showMessageDialog(null, "Solo numeros");
				
			}
			
			
		}while(validacion);
				
	}

}
