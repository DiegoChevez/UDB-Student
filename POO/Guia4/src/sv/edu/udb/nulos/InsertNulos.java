package sv.edu.udb.nulos;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.edu.udb.util.Conexion;


public class InsertNulos {

	public static void main (String [] args) throws SQLException {
		
		Conexion con = new Conexion();
		
		String sql1 = "insert into empleados values (7,'','Torres',null)";
		
		con.setQuery(sql1);
		
		String sql = "select nombres from empleados";
		ResultSet rs;
		
		con.setRs(sql);
		
		rs= con.setRs();
		
		String nombre;
		
		while (rs.next()) {
			nombre = rs.getString(1);
			
			if(nombre == null) {
				
				System.out.println("Nombre 'Null': "+ nombre);
				
			}else if(nombre.equals("")){
				
				System.out.println("Nombre vacio: " + nombre);
				
			}else {
				
				System.out.println("Nombre con datos: "+ nombre);
				
			}
			
			
			
		}
		
		con.cerrarConexion();
		
	}
	
	
}
