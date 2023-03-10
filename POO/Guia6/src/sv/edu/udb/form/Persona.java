package sv.edu.udb.form;

import sv.edu.udb.datos.PersonasDatos;
import sv.edu.udb.beans.PersonaBeans;
import sv.edu.udb.datos.OcupacionesDatos;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Persona extends JFrame {
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox cmbSexo;
    private JButton btnObtenerDatos;
    private JPanel pnlPersona;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JButton btnLimpiar;
    private JLabel lblTelefono;
    private JLabel lblSexo;
    private JTable tblDatos;
    private JTextField txtFechaNacimiento;
    private JComboBox cmbOcupacion;
    private JLabel lblOcupacion;
    private JLabel lblFechaNacimiento;
    private JButton btnEliminar;
    DefaultTableModel modelo = null;
    PersonaBeans personaBeans = null;
    PersonasDatos personaDatos = new PersonasDatos();
    OcupacionesDatos ocupacionesDatos = new OcupacionesDatos();


    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 600));
        this.setLocationRelativeTo(getParent());

        modelo = personaDatos.selectPersona();
        tblDatos.setModel(modelo);
        cmbOcupacion.setModel(ocupacionesDatos.selectOcupaciones());

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id;
                String nombres;
                int edad;
                String telefono;
                String sexo;
                int idOcupacion;
                String fechaNacimiento;
                if (txtId.getText().isEmpty()){
                    id = 0;
                }else{
                    id = Integer.parseInt(txtId.getText());
                }
                nombres = txtNombre.getText();
                edad = Integer.parseInt(txtEdad.getText());
                telefono = txtTelefono.getText();
                sexo = cmbSexo.getSelectedItem().toString();
                idOcupacion = ocupacionesDatos.getIdOcupacion(cmbOcupacion.getSelectedItem().toString());
                fechaNacimiento = txtFechaNacimiento.getText();
                personaBeans = new
                        PersonaBeans(id,nombres,edad,telefono,sexo,idOcupacion,fechaNacimiento);
                if(btnObtenerDatos.getText().equals("Guardar")) {
                    personaDatos.insert(personaBeans);
                }else if (btnObtenerDatos.getText().equals("Editar")) {
                    personaDatos.update(personaBeans);
                }
                modelo=personaDatos.selectPersona();
                tblDatos.setModel(modelo);



            }
        });

        // * Método botón limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            btnLimpiar();

            }
        });

        // ? Evento de mouse en tblDatos

        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDato(e);
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarDatos();
            }
        });
    }

    public void btnEliminarDatos() {
        personaDatos.delete(Integer.parseInt(txtId.getText()));
        btnLimpiar();
        modelo=personaDatos.selectPersona();
        tblDatos.setModel(modelo);
    }

    // ? Pasar datos seleccionados a sus respectivos campos JTextField
    private void tblObtenerDato(MouseEvent e) {
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtEdad.setText(modelo.getValueAt(fila,2).toString());
            txtTelefono.setText(modelo.getValueAt(fila,3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(fila,4).toString());
            cmbOcupacion.setSelectedItem(modelo.getValueAt(fila,5).toString());
            txtFechaNacimiento.setText(modelo.getValueAt(fila,6).toString());
            btnObtenerDatos.setText("Editar");
        }
    }


    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
        cmbOcupacion.setSelectedIndex(0);
        txtFechaNacimiento.setText("");
        btnObtenerDatos.setText("Guardar");
    }
    public static void main(String[] args) {
            JFrame frame = new Persona("Ingreso de datos");
            frame.setVisible(true);
    }

}
