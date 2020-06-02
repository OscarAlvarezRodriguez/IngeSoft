package Recursos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Funciones {

    public final Color fondoTxt = new Color(0, 0, 0, 15);
    public final Color fondoTxtError = new Color(255, 0, 0, 63);
    public final Color colorPrincipal = new Color(12, 183, 242, 255);

    public void setStyleJTextField(JTextField tf) {
        tf.setBackground(fondoTxt);
        tf.setFont(new Font("Leelawadee", 0, 20));
        tf.setBorder(new MatteBorder(0, 0, 3, 0, colorPrincipal));

    }

    public ImageIcon setImageBackground(String direccion, Component o) {
        ImageIcon imagen = new ImageIcon(this.getClass().getResource(direccion));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(o.getWidth(), o.getHeight(), Image.SCALE_SMOOTH));
        return imagen;
    }

    public void setStyleJButon(JButton jb) {
        jb.setOpaque(false);
        int delta = 30;
        Color sinFondo = new Color(0, 0, 0, 0);
        Color fondoNormal = new Color(12, 183, 242, 255);
        Color fondoPresionado = new Color(12, 183 - delta, 242, 255);
        Color fondoClaro = new Color(12, 183 + delta, 242, 255);
        jb.setVerticalAlignment(JButton.CENTER);
        jb.setHorizontalAlignment(JButton.CENTER);
        jb.setVerticalTextPosition(JButton.CENTER);
        jb.setHorizontalTextPosition(JButton.CENTER);
        jb.setFont(new Font("Leelawadee", 1, 18));
        jb.setForeground(fondoNormal);
        jb.setBackground(sinFondo);
        jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoNormal));
        jb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jb.setForeground(fondoNormal);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoNormal));

            }

            @Override
            public void mousePressed(MouseEvent e) {
                jb.setForeground(fondoPresionado);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoPresionado));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jb.setForeground(fondoNormal);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoNormal));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jb.setForeground(fondoClaro);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoClaro));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                jb.setBackground(sinFondo);
                jb.setForeground(fondoNormal);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoNormal));
            }
        });

    }

}