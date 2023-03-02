package sv.edu.udb.form;

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
    DefaultTableModel modelo = null;
    // ? Conección del archivo CSV en un String, luego se crea un objeto File con la ruta del archivo
    private final String ruta = System.getProperty("user.dir") + "\\src\\sv\\edu\\udb\\util\\datosJava.csv";
    File file = new File(ruta);

    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 600));
        this.setLocationRelativeTo(getParent());

        Object[][] data = null;
        String[] columns = {
        };

        modelo = new DefaultTableModel(data, columns);

        tblDatos.setModel(modelo);

        // * Try catch para leer el archivo CSV y mostrarlo en la tabla con BufferedReader y FileReader.
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String primeraLinea = br.readLine().trim();
            String[]  nombreColumnas = primeraLinea.split(";");
            DefaultTableModel modeloTabla = (DefaultTableModel) tblDatos.getModel();
            modeloTabla.setColumnIdentifiers(nombreColumnas);

            Object[] tablaLineas = br.lines().toArray();

            for(int i = 0; i < tablaLineas.length; i++){
                String linea = tablaLineas[i].toString().trim();
                String[] datosRow = linea.split(";");
                modeloTabla.addRow(datosRow);
            }

        }catch (Exception e){

            System.out.println("Error al leer el archivo");

        }


        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id;
                String nombres;
                String edad;
                String telefono;
                String sexo;

                id = txtId.getText();
                nombres = txtNombre.getText();
                edad = txtEdad.getText();
                telefono = txtTelefono.getText();
                sexo = cmbSexo.getSelectedItem().toString();

                JOptionPane.showMessageDialog(null, "Datos Obtenidos: \n ID: " + id +
                        "\n nombres: " + nombres + "\n Edad: " + edad + "\n Telefono: " + telefono +
                        "\n Sexo: " + sexo);

                Object[] newRow = {
                        id,
                        nombres,
                        edad,
                        telefono,
                        sexo
                };
                modelo.addRow(newRow);

                // * Try catch para escribir en el archivo CSV con BufferedWriter y FileWriter
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                    bw.write(id + ";" + nombres + ";" + edad + ";" + telefono + ";" + sexo + "\n");
                    bw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // * Método botón limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtId.setText("");
                txtNombre.setText("");
                txtEdad.setText("");
                txtTelefono.setText("");
                cmbSexo.setSelectedIndex(0);

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
    }
        // ? Pasar datos seleccionados a sus respectivos campos JTextField
    private void tblObtenerDato(MouseEvent e) {
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)) {

            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtNombre.setText(modelo.getValueAt(fila, 1).toString());
            txtEdad.setText(modelo.getValueAt(fila, 2).toString());
            txtTelefono.setText(modelo.getValueAt(fila, 3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(fila, 4).toString());

        }
    }
    public static void main(String[] args) {
            JFrame frame = new Persona("Ingreso de datos");
            frame.setVisible(true);

            // ? Obtener la ruta del proyecto
            String SO = System.getProperty("user.dir");
            System.out.println(SO);
    }

}
