package sv.edu.udb.complementario.form.datos;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

import sv.edu.udb.complementario.form.beans.AlumnoBeans;
import sv.edu.udb.complementario.form.beans.MateriaBeans;
import sv.edu.udb.complementario.form.util.Conexion;
public class MateriasDatos {
    private final String SQL_INSERT = "INSERT INTO materia(Cod_materia, Nombre, Descripcion) VALUES(?,?,?)";
    private final String SQL_UPDATE = "UPDATE materia SET Cod_materia=?, Nombre=?, Descripcion=? WHERE Cod_materia=?";
    private final String SQL_DELETE = "DELETE FROM materia WHERE Cod_materia = ?";
    private final String SQL_SELECT = "SELECT Cod_materia,Nombre,Descripcion FROM materia";

    public int insert(MateriaBeans materiaBeans){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registros afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setInt(index++, materiaBeans.getCodMateria());
            stmt.setString(index++, materiaBeans.getNombreMateria());
            stmt.setString(index, materiaBeans.getDescripcionMateria());
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

    public int delete(int codMateria) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, codMateria);
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

    public int update(MateriaBeans materiaBeans) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = sv.edu.udb.complementario.form.util.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setInt(index++, materiaBeans.getCodMateria());
            stmt.setString(index++, materiaBeans.getNombreMateria());
            stmt.setString(index, materiaBeans.getDescripcionMateria());
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

    public DefaultTableModel selectMateria(){

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
