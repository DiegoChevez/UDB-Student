package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sv.edu.udb.complementario.form.beans.AlumnoBeans;
import sv.edu.udb.complementario.form.datos.AlumnoDatos;

import javax.swing.table.DefaultTableModel;

public class AlumView extends JFrame {
    private JTextField txtCodAlumno;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtEdad;
    private JTextField txtDireccion;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnRegresar;
    private JPanel pnlAlumno;
    private JLabel lblCodAlumno;
    private JLabel lblNombre;
    private JLabel lblApellidos;
    private JLabel lblEdad;
    private JLabel lblDireccion;
    private JTable tblAlumno;
    private JButton btnLimpiar;
    DefaultTableModel modelo = null;

    AlumnoBeans alumnoBeans = null;

    AlumnoDatos alumnoDatos = new AlumnoDatos();

    public AlumView(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlAlumno);
        this.setMinimumSize(new Dimension(600, 600));
        this.setLocationRelativeTo(getParent());

        modelo = alumnoDatos.selectAlumno();
        tblAlumno.setModel(modelo);

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            btnEliminar();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });
        tblAlumno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerAlumno(e);
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int codAlumno;
                String nombreAlumno;
                String apellidoAlumno;
                int edadAlumno;
                String direccionAlumno;

                if (txtCodAlumno.getText().isEmpty()){
                    codAlumno = 0;
                }else{
                    codAlumno = Integer.parseInt(txtCodAlumno.getText());
                }

                nombreAlumno = txtNombre.getText();
                apellidoAlumno = txtApellidos.getText();
                edadAlumno = Integer.parseInt(txtEdad.getText());
                direccionAlumno = txtDireccion.getText();

                alumnoBeans = new AlumnoBeans(codAlumno, nombreAlumno, apellidoAlumno, edadAlumno, direccionAlumno);

                alumnoDatos.insert(alumnoBeans);

                modelo=alumnoDatos.selectAlumno();
                tblAlumno.setModel(modelo);

            }
        });

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView menuView = new MenuView(title);
                menuView.setVisible(true);
            }
        });
    }
        private void btnEliminar(){
            alumnoDatos.delete(Integer.parseInt(txtCodAlumno.getText()));
            btnLimpiar();
            modelo = alumnoDatos.selectAlumno();
            tblAlumno.setModel(modelo);
        }

        private void btnLimpiar(){
        txtCodAlumno.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");
        }

        private void tblObtenerAlumno(MouseEvent e){
            int fila = tblAlumno.rowAtPoint(e.getPoint());
            int columna = tblAlumno.columnAtPoint(e.getPoint());

            if((fila > -1 )&&(columna > -1)){
                txtCodAlumno.setText(modelo.getValueAt(fila,0).toString());
                txtNombre.setText(modelo.getValueAt(fila,1).toString());
                txtApellidos.setText(modelo.getValueAt(fila,2).toString());
                txtEdad.setText(modelo.getValueAt(fila,3).toString());
                txtDireccion.setText(modelo.getValueAt(fila,4).toString());
            }

        }





    public static void main(String[] args) {
        JFrame frame = new AlumView("Ingreso de datos");
        frame.setVisible(true);
    }

}
