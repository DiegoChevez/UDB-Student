package sv.edu.udb.form;

import com.sun.tools.javac.Main;
import sv.edu.udb.beans.*;
import sv.edu.udb.datos.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlumnoMateria extends JFrame {

	private JLabel lblIdRegistro;
	private JLabel lblIdAlumno;
	private JLabel lblIdMateria;
	private JTable tblAlumnoMateria;
	private JButton btnAgregar;
	private JTextField txtIdRegistro;
	private JComboBox cmbIdMateria;
	private JButton btnBorrar;
	private JPanel pnlAlumnoMateria;
	private JComboBox cmbIdAlumno;

	DefaultTableModel modelo=null;
	InscripcionBeans inscripcionBeans = null;
	InscripcionDatos inscripcionDatos = new InscripcionDatos();
	CmbAlumnosDatos cmbAlumnosDatos = new CmbAlumnosDatos();

	public AlumnoMateria(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlAlumnoMateria);
		this.setMinimumSize(new Dimension(600, 500));
		this.setLocationRelativeTo(getParent());

		modelo =inscripcionDatos.selectReporte();
		tblAlumnoMateria.setModel(modelo);
		cmbAlumnosDatos.setModel(cmbAlumnosDatos.selectAlumnoNombre());


		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAgregar();
			}
		});


		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnBorrar();
			}
		});
		cmbIdMateria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public void btnBorrar(){
		inscripcionDatos.delete(Integer.parseInt(txtIdRegistro.getText()));
		modelo=inscripcionDatos.selectReporte();
		tblAlumnoMateria.setModel(modelo);
	}

	private void btnAgregar() {
		int idReporte;
		int idAlumno = 0;
		String nombreAlumno;
		int idMateria = 0;
		String nombreMateria;

		if (txtIdRegistro.getText().isEmpty()){
			idReporte = 0;
		}else{
			idReporte = Integer.parseInt(txtIdRegistro.getText());
		}

		nombreMateria = cmbIdMateria.getSelectedItem().toString();
		nombreAlumno = cmbIdAlumno.getSelectedItem().toString();



		inscripcionBeans = new InscripcionBeans(idReporte,idAlumno,nombreAlumno,idMateria,nombreMateria);

		modelo= inscripcionDatos.selectReporte();
		tblAlumnoMateria.setModel(modelo);
	}

	public static void main(String[] args) {
		JFrame frame = new AlumnoMateria("Registro de Inscripciones");
		frame.setVisible(true);
	}

}
