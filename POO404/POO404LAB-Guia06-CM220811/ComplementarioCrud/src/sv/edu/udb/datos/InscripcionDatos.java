package sv.edu.udb.datos;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.util.Conexion;
import sv.edu.udb.beans.*;

public class InscripcionDatos {
	private final String SQL_INSERT = "INSERT INTO alumno_materia(Cod_alumno, Cod_materia) VALUES (?,?)";

	private final String SQL_DELETE = "DELETE FROM alumno_materia where Cod_Reporte = ?";

	private final String SQL_SELECT = "SELECT alumno_materia.Cod_Reporte, alumno.Nombre AS alumno, materia.Nombre AS " +
			"materia FROM alumno_materia INNER JOIN alumno on alumno_materia.Cod_alumno = alumno.Cod_alumno INNER " +
			"JOIN materia on alumno_materia.Cod_materia = materia.Cod_materia";



	public int insert(InscripcionBeans inscripcionBeans) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			int index = 1;//contador de columnas
			stmt.setInt(index++, inscripcionBeans.getIdReporte());
			stmt.setInt(index++, inscripcionBeans.getIdAlumno());
			stmt.setInt(index++, inscripcionBeans.getIdMateria());
			System.out.println("Ejecutando query:" + SQL_INSERT);
			rows = stmt.executeUpdate();//no. registros afectados
			System.out.println("Registros afectados:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return rows;
	}

	public int delete(int idReporte) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			System.out.println("Ejecutando query:" + SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, idReporte);
			rows = stmt.executeUpdate();
			System.out.println("Registros eliminados:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return rows;
	}

	public DefaultTableModel selectReporte(){
		DefaultTableModel dtm = new DefaultTableModel();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			int numberOfColumns = meta.getColumnCount();
//Formando encabezado
			for (int i = 1; i <= numberOfColumns; i++) {
				dtm.addColumn(meta.getColumnLabel(i));
			}
//Creando las filas para el JTable
			while (rs.next()) {
				Object[] fila = new Object[numberOfColumns];
				for (int i = 0; i < numberOfColumns; i++) {
					fila[i]=rs.getObject(i+1);
				}
				dtm.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			Conexion.close(conn);
		}
		return dtm;
	}


}
