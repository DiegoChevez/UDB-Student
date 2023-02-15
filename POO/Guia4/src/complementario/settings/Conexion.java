package complementario.settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


@SuppressWarnings("unused")
public class Conexion {

	private Connection conexion = null;
	private Statement s = null;
	private ResultSet rs = null;
	
	public Conexion() throws SQLException{

		
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela?useServerPrepStmts=true","root", "");
		s = conexion.createStatement();
		System.out.println("Conexion Exitosa");
		
		}
	
		catch (ClassNotFoundException e1) {
			
		System.out.println("ERROR: No encuentro el driver de la BD: "+e1.getMessage());
		
			}
	
		catch(Exception e2) {
			
			JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión \nCerrando el sistema...");
			System.exit(0);
			
		}
	
	}

	public Connection getConnection() {
		
		return conexion;
		
	}
	
	public void closeConnection() throws SQLException {
		
		
		conexion.close();
		System.out.println("Conexion cerrada");
		
	}
	
	
	
}
