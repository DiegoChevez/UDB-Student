package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sv.edu.udb.complementario.form.beans.AlumnoBeans;
import sv.edu.udb.complementario.form.beans.MateriaBeans;
import sv.edu.udb.complementario.form.datos.MateriasDatos;

import javax.swing.table.DefaultTableModel;
public class MateriasView extends JFrame{
    private JTextField txtCodMateria;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnRegresar;
    private JPanel pnlMaterias;
    private JLabel lblCodMateria;
    private JLabel lblNombre;
    private JLabel lblDescripcion;
    private JTable tblMaterias;
    private JButton btnLimpiar;

    DefaultTableModel modelo = null;

    MateriaBeans materiaBeans = null;
    MateriasDatos materiasDatos = new MateriasDatos();
    public MateriasView(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMaterias);
        this.setMinimumSize(new Dimension(600, 600));
        this.setLocationRelativeTo(getParent());

        modelo = materiasDatos.selectMateria();
        tblMaterias.setModel(modelo);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int codMateria;
                String nombreMateria;
                String descripcionMateria;

                if (txtCodMateria.getText().isEmpty()){
                    codMateria = 0;
                }else{
                    codMateria = Integer.parseInt(txtCodMateria.getText());
                }
                nombreMateria = txtNombre.getText();
                descripcionMateria = txtDescripcion.getText();

                materiaBeans = new MateriaBeans(codMateria, nombreMateria, descripcionMateria);

                materiasDatos.insert(materiaBeans);

                modelo=materiasDatos.selectMateria();
                tblMaterias.setModel(modelo);



            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarMaterias();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            btnLimpiarMaterias();
            }
        });
        tblMaterias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                obtenerDatosAlumno(e);
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int codMateria;
                String nombreMateria;
                String descripcionMateria;


                if (txtCodMateria.getText().isEmpty()){
                    codMateria = 0;
                }else{
                    codMateria = Integer.parseInt(txtCodMateria.getText());
                }

                codMateria =Integer.parseInt(txtCodMateria.getText()) ;
                nombreMateria = txtNombre.getText();
                descripcionMateria = txtDescripcion.getText();

                materiaBeans = new MateriaBeans(codMateria, nombreMateria, descripcionMateria);

                materiasDatos.update(materiaBeans);

                modelo= materiasDatos.selectMateria();
                tblMaterias.setModel(modelo);
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

    private void btnEliminarMaterias(){
        materiasDatos.delete(Integer.parseInt(txtCodMateria.getText()));
        btnLimpiarMaterias();
        modelo = materiasDatos.selectMateria();
        tblMaterias.setModel(modelo);
    }

    private void btnLimpiarMaterias(){
        txtCodMateria.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
    }

    private void obtenerDatosAlumno(MouseEvent e){
        int fila = tblMaterias.rowAtPoint(e.getPoint());
        int columna = tblMaterias.columnAtPoint(e.getPoint());

        if((fila > -1 )&&(columna > -1)){
            txtCodMateria.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila,1).toString());
            txtDescripcion.setText(modelo.getValueAt(fila,2).toString());
        }
    }


    public static void main(String[] args) {
        JFrame frame = new MateriasView("Ingreso de datos");
        frame.setVisible(true);
    }

}
