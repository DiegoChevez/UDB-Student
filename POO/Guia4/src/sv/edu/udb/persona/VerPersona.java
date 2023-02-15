package sv.edu.udb.persona;

import java.sql.*;

public class VerPersona {

	public VerPersona() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/personabdd","root","");
			
			Statement s = conexion.createStatement();
			
			ResultSet rs = s.executeQuery("select * from persona");
			
			while(rs.next()) {
				
				System.out.println("ID " + rs.getInt(1) + "\nNombre: "+rs.getString(2) + "\nEdad: " + rs.getString(3) + "\nTelefono: " + rs.getString(4));
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
			}
			
			
		}catch(ClassNotFoundException e1) {
			System.out.println("ERROR:No encuentro el driver de la BD:"+e1.getMessage());

			
		}catch (SQLException e2) {
			System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
			 }
	}

	
	public static void main (String[] args ) {
		
		new VerPersona();
		
	} 
	
		

		

}


