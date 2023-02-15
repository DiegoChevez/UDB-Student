package complementario.settings.registros;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import complementario.settings.Conexion;


import complementario.settings.MetodosCRUD;

@SuppressWarnings("unused")
public class Reportes extends MetodosCRUD{

	
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;


	
	@Override
	public void crearRegistros() {
		
	String idS = JOptionPane.showInputDialog(null,"Ingrese el ID del estudiante ");
	int id = Integer.parseInt(idS);
	
	String consulta = "SELECT `Cod_alumno`, `Nombre` FROM `alumno` WHERE `Cod_alumno` = '"+id+"'"; 
	try {
		Conexion connection = new Conexion();
		
		try {
			Connection con = connection.getConnection();
			ps = con.prepareStatement(consulta);
			
			String materia = JOptionPane.showInputDialog(null, "Ingrese la materia");
			
			String consulta2 = "SELECT `Cod_materia`, `Nombre` FROM `materia` WHERE `Nombre` = '"+materia+"'";
			ps = con.prepareStatement(consulta2);
			String consultaReporte = "INSERT INTO `alumno_materia`(`Cod_alumno`, `Cod_materia`) VALUES ('"+id+"','"+materia+"')";
			ps = con.prepareStatement(consultaReporte);
			JOptionPane.showMessageDialog(null, "Registrado exitosamente");
			ps.executeUpdate();

			
		}catch(SQLException e) {
			e.printStackTrace();

		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void mostrarRegistros() throws SQLException {
		Conexion connection = new Conexion();
		Connection con = connection.getConnection();

		
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/escuela","root", "");
			Statement s = conexion.createStatement();
			ResultSet rs;
			rs = s.executeQuery("SELECT * FROM `alumno_materia`,`alumno`,`materia` WHERE `alumno_materia`.`Cod_alumno`=`alumno`.`Cod_alumno` & `alumno_materia`.`Cod_materia`=`materia`.`Cod_materia`;");
			while(rs.next()) {
				
				JOptionPane.showMessageDialog(null, "ID: "+rs.getInt(1)+"\nNombre: "+rs.getString(5)+"\nDescripción: " + 
				rs.getString(11));
			}
			
		
	}

	@Override
	public void actualizarRegistros() {
		
		
		
	}

	@Override
	public void eliminarRegistros() {
		
		
		
		
	}

}
