package conexion.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	@SuppressWarnings("unused")
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/";
		String bd = "personabdd";
		Connection conn = null;
		conn = DriverManager.getConnection(url + bd, "root","");
		PreparedStatement ps = null;
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("Select * from persona");
		while(rs.next()) {
			
			System.out.println(rs.getInt("id_persona") + " "+ rs.getString("nombre_persona") + " " + rs.getInt("edad_persona") + " " + rs.getString("telefono_persona") + " " + rs.getString("sexo_persona") + " " + rs.getInt("id_ocupacion") + " " + rs.getString("fecha_nac"));
			
		}
		conn.close();
	}
}