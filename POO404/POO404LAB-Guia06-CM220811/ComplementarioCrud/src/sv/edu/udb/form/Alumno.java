package sv.edu.udb.form;
import sv.edu.udb.datos.AlumnoDatos;
import sv.edu.udb.beans.AlumnoBeans;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Alumno extends JFrame{
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblEdad;
    private JLabel lblDireccion;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtDireccion;
    private JTable tblAlumnos;
    private JPanel pnlAlumno;
    private JButton btnObtenerDatos;
    private JButton btnEliminarDatos;
    private JButton btnLimpiar;
    private JTextField txtId;
    private JLabel lblId;

    DefaultTableModel modelo=null;
    AlumnoBeans alumnoBeans = null;
    AlumnoDatos alumnoDatos = new AlumnoDatos();

    public Alumno(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlAlumno);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        modelo = alumnoDatos.selectAlumno();
        tblAlumnos.setModel(modelo);

        Object [][] data=null;

        String[] colums = {
                "Id", "Nombres", "Apellido", "Edad" , "Direccion"
        };

        modelo= new DefaultTableModel(data, colums);
        tblAlumnos.setModel(modelo);

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }
        });


        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });

        btnEliminarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarDatos();
            }
        });
        tblAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDato(e);
            }
        });
    }

    public void btnEliminarDatos(){
        alumnoDatos.delete(Integer.parseInt(txtId.getText()));
        btnLimpiar();
        modelo=alumnoDatos.selectAlumno();
        tblAlumnos.setModel(modelo);
    }

    public void tblObtenerDatos(MouseEvent e){
        int fila = tblAlumnos.rowAtPoint(e.getPoint());
        int columna = tblAlumnos.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtApellido.setText(modelo.getValueAt(fila,2).toString());
            txtEdad.setText(modelo.getValueAt(fila,3).toString());
            txtDireccion.setText(modelo.getValueAt(fila,4).toString());
        }
    }

    private void btnObtenerDatos() {
        int id;
        String nombres;
        String apellidos;
        int edad;
        String direccion;

        if (txtId.getText().isEmpty()){
            id = 0;
        }else{
            id = Integer.parseInt(txtId.getText());
        }
        nombres = txtNombre.getText();
        apellidos = txtApellido.getText();
        edad = Integer.parseInt(txtEdad.getText());
        direccion = txtDireccion.getText();

        alumnoBeans = new AlumnoBeans(id,nombres,apellidos,edad,direccion);
        if(btnObtenerDatos.getText().equals("Guardar")) {
            alumnoDatos.insert(alumnoBeans);
        }else if (btnObtenerDatos.getText().equals("Editar")) {
            alumnoDatos.update(alumnoBeans);
        }
        modelo= alumnoDatos.selectAlumno();
        tblAlumnos.setModel(modelo);
    }

    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");

        btnObtenerDatos.setText("Guardar");
    }

    private void tblObtenerDato(MouseEvent e) {
        int fila = tblAlumnos.rowAtPoint(e.getPoint());
        int columna = tblAlumnos.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtApellido.setText(modelo.getValueAt(fila,2).toString());
            txtEdad.setText(modelo.getValueAt(fila,3).toString());
            txtDireccion.setText(modelo.getValueAt(fila,4).toString());
            btnObtenerDatos.setText("Editar");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new Alumno("Ingreso de Datos");
        frame.setVisible(true);
    }

}
