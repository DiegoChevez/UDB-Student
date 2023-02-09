package ejemplos;

import javax.swing.*;


public class Estudiantes {

	public static void main(String[] args) {

		Persona persona = new Persona("Erick","FG220265","Computacion","21");
		
		JOptionPane.showMessageDialog(null, "Su nombre es: "+persona.nombre+"\n"+"Su ID es: " + persona.id + "\n" +"Su carrera es: " +persona.carrera +"\n" + "Usted cursa : "+persona.nMaterias + " Materias");

		
		persona.mostrarDatos();
		persona.ingresoDatosEstudiante();
		persona.ingresoDatosMaterias();
	
		JOptionPane.showMessageDialog(null, "Su nombre es: "+persona.nombre+"\n"+"Su ID es: " + persona.id + "\n" +"Su carrera es: " +persona.carrera +"\n" + "Usted cursa : "+persona.nMaterias + " Materias");
	
	}

}
