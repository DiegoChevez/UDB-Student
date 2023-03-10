package sv.edu.udb.datos;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.util.Conexion;
import sv.edu.udb.beans.AlumnoBeans;

public class AlumnoDatos {

    private final String SQL_INSERT = "INSERT INTO alumno(Cod_alumno, Nombre, Apellido, Edad, Direccion) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE alumno SET Cod_alumno=?, Nombre=?, Apellido=?, Edad=?, Direccion=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM alumno WHERE Cod_alumno = ?";

    private final String SQL_SELECT = "SELECT Cod_alumno,Nombre,Apellido,Edad,Direccion FROM alumno";


    public int insert(AlumnoBeans alumnoBeans) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registros afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setInt(index++, alumnoBeans.getIdAlumno());
            stmt.setString(index++, alumnoBeans.getNombreAlumno());
            stmt.setString(index++, alumnoBeans.getApellidoAlumno());
            stmt.setInt(index++, alumnoBeans.getEdadAlumno());
            stmt.setString(index++, alumnoBeans.getDireccionAlumno());
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

    public int update(AlumnoBeans alumnoBeans) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, alumnoBeans.getNombreAlumno());
            stmt.setString(index++, alumnoBeans.getApellidoAlumno());
            stmt.setInt(index++, alumnoBeans.getEdadAlumno());
            stmt.setString(index++, alumnoBeans.getDireccionAlumno());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(int idAlumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idAlumno);
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
    public DefaultTableModel selectAlumno(){
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
