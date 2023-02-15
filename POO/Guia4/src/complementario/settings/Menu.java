package complementario.settings;

import complementario.settings.registros.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class Menu {
	
	Alumno alumno = new Alumno("","",0,"");
	Materia materia = new Materia("","");
	Reportes reporte = new Reportes();
	
	public void menuAlumno() throws SQLException {
		

		boolean validacion = true;

		do {
			Conexion conexion = new Conexion();
	        conexion.closeConnection();
			String[] options1 = {"Crear registro", "Listar registros existentes", "Actualizar registro", "Eliminar registro","Regresar"};
	        String m = (String)JOptionPane.showInputDialog(null, "Escoja una acción a realizar", 
	                "Alumnos", JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
	        
	        switch (m) {
	                     
	        case "Crear registro":
	        	
	        	alumno.crearRegistros();
	        	
	        	break;
	             	        
	        case "Listar registros existentes":
	        
	        	alumno.mostrarRegistros();

	        	break;
	        
	        case "Actualizar registro":

	        	alumno.actualizarRegistros();
	        	
	        	break;
	        	
	        case "Eliminar registro":

	        	alumno.eliminarRegistros();
	        	
	        	break;
	        	
	        case "Regresar":
	        
		        conexion.closeConnection();

	        	
	        	return;	
	        
	     	        
	         }
	        
		}while(validacion);
		
		
	}
	
	public void menuMateria() throws SQLException {
		
		Conexion conexion = new Conexion();
        conexion.closeConnection();
		boolean validacion = true;

		do {

			String[] options1 = {"Crear registro", "Listar registros existentes", "Actualizar registro", "Eliminar registro","Regresar"};
	        String m = (String)JOptionPane.showInputDialog(null, "Escoja una acción a realizar", 
	                "Materia", JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
	        
	        
	        switch (m) {
	                     
	        case "Crear registro":

	        	materia.crearRegistros();
	        	
	        	
	        	break;
	             	        
	        case "Listar registros existentes":

	        	materia.mostrarRegistros();
	        	
	        	
	        	break;
	        
	        case "Actualizar registro":

	        	materia.actualizarRegistros();
	        	
	        	break;
	        	
	        case "Eliminar registro":

	        	materia.eliminarRegistros();
	        	
	        	
	        	break;
	        	
	        case "Regresar":
	          	
		        conexion.closeConnection();

	        	
	        	return;		        	
	       	        	        
	        }
		}while(validacion);
		
	}
	
	public void reportes() throws SQLException{
		
		Conexion conexion = new Conexion();
        conexion.closeConnection();

		boolean validacion = true;

		do {

			String[] options1 = {"Crear reporte", "Visualizar reporte", "Actualizar reporte", "Eliminar reporte","Regresar"};
	        String m = (String)JOptionPane.showInputDialog(null, "Escoja una acción a realizar", 
	                "Reportes", JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
	        
	        
	        switch (m) {
	                     
	        case "Crear reporte":

	        	reporte.crearRegistros();
	        	
	        	break;
	             	        
	        case "Visualizar reporte":

	        	reporte.mostrarRegistros();
	        	
	        	break;
	        
	        case "Actualizar reporte":

	        	JOptionPane.showMessageDialog(null, "Actualizar reporte");
	        	
	        	break;	
	        	
	        case "Eliminar reporte":
	        	
	        	JOptionPane.showMessageDialog(null, "Eliminar reporte");

	        	break;
	        	
	        case "Regresar":
	        	conexion.closeConnection();
	        	return;		        	
	       	        	        
	        }
		}while(validacion);
		
	}
	
	
}
