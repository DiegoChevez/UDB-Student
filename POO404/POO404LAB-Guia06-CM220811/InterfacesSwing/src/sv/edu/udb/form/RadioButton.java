package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JFrame{
    private JRadioButton rbtOpcion1;
    private JRadioButton rbtOpcion2;
    private JRadioButton rbtOpcion3;
    private JLabel lblTitulo;
    private JLabel lblImagen;
    private JPanel pnlImg;

    public RadioButton(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlImg);
        this.setMinimumSize(new Dimension(400,400));
        this.setLocationRelativeTo(getParent());

        rbtOpcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lblImagen.setIcon( new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/img/perro.jpg")));

            }
        });
        rbtOpcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lblImagen.setIcon( new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/img/gato.jpg")));

            }
        });
        rbtOpcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lblImagen.setIcon( new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/img/zorro.jpg")));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new RadioButton("Seleccione una imagen");
        frame.setVisible(true);
    }
}


