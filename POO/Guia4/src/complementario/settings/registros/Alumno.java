package complementario.settings.registros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import complementario.settings.Conexion;

@SuppressWarnings("unused")
public class Alumno extends Datos {

	
	
	public String apellido;
	public int edad;
	public String direccion; 
	
	
	Statement s;
	ResultSet rs;
	PreparedStatement ps = null;
	
	public Alumno(String nombre, String apellido, int edad, String direccion) {
		super(nombre);
				
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		
	}

	@Override
	public void crearRegistros() {
		
		nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno");
		apellido = JOptionPane.showInputDialog("Ingrese el apellido del alumno");
		String edads = JOptionPane.showInputDialog("Ingrese la edad del alumno");
		edad = Integer.parseInt(edads);
		direccion = JOptionPane.showInputDialog("Ingrese la dirección del alumno");

		try {
			Conexion connection = new Conexion();
			

			String insertTableSQL = "INSERT INTO alumno" + "(Cod_alumno, Nombre, Apellido, Edad, Direccion) VALUES" + 
			"(?,?,?,?,?)";
			
			try {
				Connection con = connection.getConnection();
				ps = con.prepareStatement(insertTableSQL);
				
				ps.setInt(1, 0);
				ps.setString(2, nombre);
				ps.setString(3, apellido);
				ps.setInt(4, edad);
				ps.setString(5, direccion);
				
				ps.executeUpdate();
						
				JOptionPane.showMessageDialog(null, "Registrado exitosamente");
		    	connection.closeConnection();

				
			}catch(SQLException e) {
				
		    	connection.closeConnection();

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();

		}

				
		
	}

	@Override
	public void mostrarRegistros() throws SQLException {
		
		Conexion connection = new Conexion();
		connection.getConnection();
		Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela","root", "");
		Statement s = conexion.createStatement();
		ResultSet rs;

		rs = s.executeQuery("select * from alumno");
		while(rs.next()) {
			
			JOptionPane.showMessageDialog(null, "ID: "+rs.getInt(1)+"\nNombre: "+rs.getString(2)+"\nApellido: " + 
			rs.getString(3) + "\nEdad: "+ rs.getInt(4) + "\nDirecció: " +rs.getString(5));
			
		}
    	connection.closeConnection();

		
	}

	@Override
	public void actualizarRegistros() {
		

		String idS = JOptionPane.showInputDialog(null, "Ingrese el ID de la mataeria a modificar");
		int id = Integer.parseInt(idS);
		nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre del alumno");
		apellido = JOptionPane.showInputDialog(null, "Introduzca el apellido del alumno");
		String edadS = JOptionPane.showInputDialog(null, "Introduzca la edad del alumno");
		edad = Integer.parseInt(edadS);
		direccion = JOptionPane.showInputDialog(null, "Introduzca la dirección del alumno");

		
		try {
			
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela","root", "");
			Statement s = conexion.createStatement();
			
			int valor = s.executeUpdate("UPDATE `alumno` SET `Cod_alumno`='"+ id +"',`Nombre`='"+nombre+"',`Apellido`='"+apellido+"',`Edad`='"+edad+"',`Direccion`='"+direccion+"' WHERE `Cod_alumno` ='"+id+"'");
			
if(valor == 1) {
				
				JOptionPane.showMessageDialog(null, "Materia modificada correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null, "Esta materia no existe en los registros");
				
			}
			conexion.close();
			
		}catch(SQLException e) {
			
			e.printStackTrace();

			
		}
		
	}

	@Override
	public void eliminarRegistros() {
		
		String idS = JOptionPane.showInputDialog(null,"Ingrese el ID de la materia a eliminar");
		int id = Integer.parseInt(idS);
		
		try {
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela","root", "");
			Statement s = conexion.createStatement();
			
			int valor = s.executeUpdate("DELETE FROM alumno where Cod_alumno='" + id +"'");
			
			if(valor == 1) {
				
				JOptionPane.showMessageDialog(null, "Materia eliminada correctamente");
				
			}else {
				JOptionPane.showMessageDialog(null, "Esta materia no existe en los registros");
				
			}
			conexion.close();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

}

	


