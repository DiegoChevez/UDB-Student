package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class RadioButton extends JFrame {
    private JRadioButton rbtOpcion1;
    private JRadioButton rbtOpcion2;
    private JRadioButton rbtOpcion3;
    private JLabel lblTitulo;
    private JLabel lblImage;
    private JPanel pnlImg;

    public RadioButton(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlImg);
        this.setMinimumSize(new Dimension(400, 400));
        this.setLocationRelativeTo(getParent());


        rbtOpcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImage.setIcon(new
                        ImageIcon(getClass().getResource("/sv/edu/udb/img/redbull.png")));
            }
        });
        rbtOpcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImage.setIcon(new
                        ImageIcon(getClass().getResource("/sv/edu/udb/img/mercedes.png")));

            }
        });

        rbtOpcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImage.setIcon(new
                        ImageIcon(getClass().getResource("/sv/edu/udb/img/ferrari.png")));

            }
        });
    }

    private void createUIComponents() {


    }
    public static void main(String[] args) {


        JFrame frame = new RadioButton("Seleccione una Imagen");
        frame.setVisible(true);


    }

}
