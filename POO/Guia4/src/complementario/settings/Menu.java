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
	        	conexion.closeConnection();

	        	break;
	             	        
	        case "Listar registros existentes":
	        
	        	alumno.mostrarRegistros();
	        	conexion.closeConnection();

	        	break;
	        
	        case "Actualizar registro":

	        	alumno.actualizarRegistros();
	        	conexion.closeConnection();

	        	break;
	        	
	        case "Eliminar registro":

	        	alumno.eliminarRegistros();
	        	conexion.closeConnection();

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
	        	conexion.closeConnection();

	        	
	        	break;
	             	        
	        case "Listar registros existentes":

	        	materia.mostrarRegistros();
	        	conexion.closeConnection();

	        	
	        	break;
	        
	        case "Actualizar registro":

	        	materia.actualizarRegistros();
	        	conexion.closeConnection();

	        	break;
	        	
	        case "Eliminar registro":

	        	materia.eliminarRegistros();
	        	conexion.closeConnection();

	        	
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
	        	conexion.closeConnection();

	        	break;
	             	        
	        case "Visualizar reporte":

	        	reporte.mostrarRegistros();
	        	conexion.closeConnection();

	        	break;
	        
	        case "Actualizar reporte":


	        	reporte.actualizarRegistros();
	        	conexion.closeConnection();

	        	break;	
	        	
	        case "Eliminar reporte":
	        	

	        	reporte.eliminarRegistros();
	        	conexion.closeConnection();

	        	
	        	break;
	        	
	        case "Regresar":
	        	conexion.closeConnection();
	        	return;		        	
	       	        	        
	        }
		}while(validacion);
		
	}
	
	
}
