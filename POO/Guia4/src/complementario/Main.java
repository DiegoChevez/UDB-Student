package complementario;

import java.sql.SQLException;

import javax.swing.*;
import complementario.settings.*;

public class Main {

	public static void main(String[] args) throws SQLException {
				
		boolean validacion = true;
		
		Menu menu = new Menu();
		
		do {
	
			
			String[] op = {"Alumno", "Materia", "Reportes", "Salir"};
            int x = JOptionPane.showOptionDialog(null, "Escoja una opción para seguir",
                    "Sistema de registro de datos escolares",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
         
			 
				switch (x) {
				
				case 0:
					
					menu.menuAlumno();
			        
					break;
				
				
				case 1:
					menu.menuMateria();
			        
					break;
					
				case 2:
					
					menu.reportes();
					
					break;
				
					
				case 3:
					
					System.exit(0);
					
					break;
				}
			
		}while(validacion);
			
	}

}
