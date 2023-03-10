package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {
    private JButton btnAlumnoMaterias;
    private JButton btnAlumno;
    private JButton btnMaterias;
    private JPanel pnlMenu;

    public MenuView (String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMenu);
        this.setMinimumSize(new Dimension(600, 600));
        this.setLocationRelativeTo(getParent());
        btnAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlumView alumView = new AlumView(title);
                alumView.setVisible(true);
            }
        });
        btnMaterias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MateriasView materiasView = new MateriasView(title);
                materiasView.setVisible(true);
            }
        });
        btnAlumnoMaterias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlumnoMateriaView alumnoMateriaView = new AlumnoMateriaView(title);
                alumnoMateriaView.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new MenuView("Ingreso de datos");
        frame.setVisible(true);
    }

}
