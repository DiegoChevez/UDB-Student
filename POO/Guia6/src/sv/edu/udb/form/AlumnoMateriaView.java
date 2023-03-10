package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sv.edu.udb.complementario.form.beans.AlumnoMateriaBeans;
import sv.edu.udb.complementario.form.datos.AlumnoMateriasDatos;

import javax.swing.table.DefaultTableModel;
public class AlumnoMateriaView extends JFrame{
    private JTextField txtCodReporte;
    private JTextField txtCodAlumno;
    private JTextField txtCodMateria;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnRegresar;
    private JLabel lblCodReporte;
    private JLabel lblCodAlumno;
    private JLabel lblCodMateria;
    private JPanel pnlAlumnoMateria;
    private JTable tblAlumnoMateria;
    private JButton btnLimpiar;
    DefaultTableModel modelo = null;
    AlumnoMateriaBeans alumnoMateriaBeans = null;
    AlumnoMateriasDatos alumnoMateriasDatos = new AlumnoMateriasDatos();

    public AlumnoMateriaView(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlAlumnoMateria);
        this.setMinimumSize(new Dimension(600, 600));
        this.setLocationRelativeTo(getParent());

        modelo = alumnoMateriasDatos.selectReporte();
        tblAlumnoMateria.setModel(modelo);

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarReporte();
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int codReporte;
                int codAlumno;
                int codMateria;

                if(txtCodReporte.getText().isEmpty()){
                    codReporte = 0;
                }else {
                     codReporte = Integer.parseInt(txtCodReporte.getText());
                }

                codAlumno = Integer.parseInt(txtCodAlumno.getText());
                codMateria = Integer.parseInt(txtCodMateria.getText());

                alumnoMateriaBeans = new AlumnoMateriaBeans(codReporte, codAlumno, codMateria);

                alumnoMateriasDatos.insert(alumnoMateriaBeans);

                modelo=alumnoMateriasDatos.selectReporte();
                tblAlumnoMateria.setModel(modelo);

            }
        });
        tblAlumnoMateria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerReporte(e);
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            btnLimpiar();
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

    private void btnLimpiar(){
        txtCodReporte.setText("");
        txtCodMateria.setText("");
        txtCodAlumno.setText("");
    }

    private void btnEliminar(){
        alumnoMateriasDatos.delete(Integer.parseInt(txtCodReporte.getText()));
        btnLimpiar();
        modelo = alumnoMateriasDatos.selectReporte();
        tblAlumnoMateria.setModel(modelo);
    }

    private void tblObtenerReporte(MouseEvent e){
        int fila = tblAlumnoMateria.rowAtPoint(e.getPoint());
        int columna = tblAlumnoMateria.columnAtPoint(e.getPoint());

        if((fila > -1 )&&(columna > -1)) {
            txtCodReporte.setText(modelo.getValueAt(fila, 0).toString());
            txtCodAlumno.setText(modelo.getValueAt(fila, 1).toString());
            txtCodMateria.setText(modelo.getValueAt(fila, 2).toString());
        }
    }
    private void btnEliminarReporte(){
        alumnoMateriasDatos.delete(Integer.parseInt(txtCodMateria.getText()));
        btnEliminar();
        modelo = alumnoMateriasDatos.selectReporte();
        tblAlumnoMateria.setModel(modelo);
    }

    public static void main(String[] args) {
        JFrame frame = new AlumnoMateriaView("Ingreso de datos");
        frame.setVisible(true);
    }

}
