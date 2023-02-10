package ejemplos;

import javax.swing.*;

public class Persona {
	
	public String nombre;
	public String id;
	public String carrera;
	public String nMaterias;
	
	public String m1, m2 ,m3 ,m4, m5;
	

	public Persona(String nombre, String id, String carrera, String nMaterias, String m1, String m2, String m3, String m4, String m5) {
		
		this.nombre = nombre;
		this.carrera = carrera;
		this.id = id;
		this.nMaterias = nMaterias;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.m4 = m4;
		this.m5 = m5;

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


		
	}
	
	public void mostrarDatosEstudiante() {
		
		JOptionPane.showMessageDialog(null,"Nombre: "+nombre+"\nID: "+id+"\nCarrera: "+carrera+"\nCantidad de materias: "+nMaterias );	
		
	}
	
	public void mostrarDatosMateria() {
		
		JOptionPane.showMessageDialog(null, "Nombre de materia 1: " + m1 + "\nNombre de materia 2: " + m2 + "\nNombre de materia 3: " + m3 +"\nNombre de materia 4: " + m4 + "\nNombre de materia 5: "  + m5);
		
	}

}
