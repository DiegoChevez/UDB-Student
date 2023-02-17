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
public class Materia extends Datos {
	
	PreparedStatement ps = null;
	
	public String descripcion;
	
	public Materia(String nombre, String descripcion) {
		super(nombre);

	this.descripcion = descripcion;
		
	}

	@Override
	public void crearRegistros() throws SQLException {
		
		nombre = JOptionPane.showInputDialog("Ingrese el nombre de la materia");
		descripcion = JOptionPane.showInputDialog("Ingrese los detalles de la materia");

		try {
			Conexion connection = new Conexion();
			

			String insertTableSQL = "INSERT INTO materia" + "(Cod_materia, Nombre, Descripcion) VALUES" + 
			"(?,?,?)";
			
			try {
				Connection con = connection.getConnection();
				ps = con.prepareStatement(insertTableSQL);
				
				ps.setInt(1, 0);
				ps.setString(2, nombre);
				ps.setString(3, descripcion);
				
				ps.executeUpdate();
						
				JOptionPane.showMessageDialog(null, "Registrado exitosamente");
				
			}catch(SQLException e) {
				
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		
	}

	@Override
	public void mostrarRegistros() throws SQLException {
		Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela","root", "");
		Statement s = conexion.createStatement();
		ResultSet rs;
		rs = s.executeQuery("select * from materia");
		while(rs.next()) {
			
			JOptionPane.showMessageDialog(null, "ID: "+rs.getInt(1)+"\nNombre: "+rs.getString(2)+"\nDescripción: " + 
			rs.getString(3));
		
	}
		
	}

	@Override
	public void actualizarRegistros() {
		
		String idS = JOptionPane.showInputDialog(null, "Ingrese el ID de la mataeria a modificar");
		int id = Integer.parseInt(idS);
		nombre = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre de la materia");
		descripcion = JOptionPane.showInputDialog(null, "Introduzca la nueva descripción de la materia");
		
		try {
			
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela","root", "");
			Statement s = conexion.createStatement();
			
			int valor = s.executeUpdate("UPDATE `materia` SET `Cod_materia`='"+ id +"',`Nombre`='"+ nombre +"',`Descripcion`='" + descripcion + "' WHERE `Cod_materia` ='" + id + "'");
			
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
	public void eliminarRegistros() throws SQLException {

		String idS = JOptionPane.showInputDialog(null,"Ingrese el ID de la materia a eliminar");
		int id = Integer.parseInt(idS);
		
		try {
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela","root", "");
			Statement s = conexion.createStatement();
			
			int valor = s.executeUpdate("DELETE FROM materia where Cod_materia='" + id +"'");
			
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
