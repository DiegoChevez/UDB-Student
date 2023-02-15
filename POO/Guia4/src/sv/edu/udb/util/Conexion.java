package sv.edu.udb.util;
import java.sql.*;

public class Conexion {
	
	
	private Connection conexion = null; 
	private Statement s = null; 
	@SuppressWarnings("unused")
	private ResultSet rs = null;
	@SuppressWarnings("unused")
	private String ingresoempleados = "";
	
	public Conexion() throws SQLException{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/guia4","root","rafael");
			s = conexion.createStatement();
			
			
		}catch(ClassNotFoundException e1) {
			
			System.out.println("ERROR: No encuentro el driver de la BD: "+e1.getMessage());
			
		}
		
		
		
	}
	
	
	public void setRs(String sql) {
		
		try {
			
			this.rs = s.executeQuery(sql);
			
		}catch(SQLException e2) {
			
			System.out.println("ERROR: Fallo en SQL: "+e2.getMessage());
			
			
		}
			
	}
	
	public void setQuery(String sql) throws SQLException{
		
		this.s.executeUpdate(sql);

	}
	
	public void cerrarConexion() throws SQLException{
		
		conexion.close();
		
	}


	public ResultSet setRs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
