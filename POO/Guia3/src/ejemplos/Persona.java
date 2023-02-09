package ejemplos;

import javax.swing.*;

public class Persona {
	
	public String nombre;
	public String id;
	public String carrera;
	public String nMaterias;
	
	public String m1, m2 ,m3 ,m4, m5;
	

	public Persona(String _nombre, String _id, String _carrera, String _nMaterias) {
		
		nombre = _nombre;
		carrera = _carrera;
		id = _id;
		nMaterias = _nMaterias;

	}
	
	public void ingresoDatosEstudiante() {
		
		JOptionPane.showMessageDialog(null,"Sistema de información estudiantil");
		nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		id = JOptionPane.showInputDialog("Ingrese su identificación de estudiante");
		carrera = JOptionPane.showInputDialog("Ingrese el nombre de la carrera a la que pertenece");
		nMaterias = JOptionPane.showInputDialog("Ingrese la cantidad de materias que esta cursando");

	}
	
	public void ingresoDatosMaterias() {
		
		m1 = JOptionPane.showInputDialog("Ingrese el nombre de la materia 1");
		m2 = JOptionPane.showInputDialog("Ingrese el nombre de la materia 2");
		m3 = JOptionPane.showInputDialog("Ingrese el nombre de la materia 3");
		m4 = JOptionPane.showInputDialog("Ingrese el nombre de la materia 4");
		m5 = JOptionPane.showInputDialog("Ingrese el nombre de la materia 5");
		JOptionPane.showMessageDialog(null, "Su nombre es: "+m1+"\n"+"Su ID es: " + m2 + "\n" +"Su carrera es: " +m3 +"\n" + "Usted cursa : "+m4 + " Materias" + "\n" + m5);


		
	}
	
	public void mostrarDatos() {
		
		System.out.println(nombre);
		System.out.println(id);
		System.out.println(carrera);
		System.out.println(nMaterias);

		
		
	}
	

}
