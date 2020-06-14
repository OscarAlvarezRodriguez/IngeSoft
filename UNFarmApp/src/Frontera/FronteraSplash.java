package Frontera;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class FronteraSplash extends javax.swing.JPanel implements Runnable {

    Thread tiempo = null;
    Control.RegistrarDrogueria ddao = new Control.RegistrarDrogueria();
    Control.RegistrarAdministrador regAdmin = new Control.RegistrarAdministrador();

    public FronteraSplash() {
        initComponents();
        jlLogo.setSize(350, 350);
        jlLogo.setIcon(setImageBackground("/Recursos/logo.png", jlLogo));
        showAgain();

    }

    public void showAgain() {
        tiempo = new Thread(this);
        tiempo.start();
    }

    private ImageIcon setImageBackground(String direccion, Component o) {
        ImageIcon imagen = new ImageIcon(this.getClass().getResource(direccion));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(o.getWidth(), o.getHeight(), Image.SCALE_SMOOTH));
        return imagen;
    }

    @Override
    public void paintComponent(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Recursos/fondo.png"));
        g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 550));

        jlLogo.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UNFarmApp");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlLogo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        do {
            try {
                tiempo = null;
                Thread.sleep(2000);
                if (regAdmin.registrarAdministrador()) {
                    App.getInstance().ChangePanel(FramePrincipal.INTfronteraRegAdministrador);
                    App.getInstance().framePrincipal.regAdministrador.allSetEmpty();
                } else if (ddao.verDrogueria()) {
                    App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
                    App.getInstance().framePrincipal.autenticarEmpleado.allSetEmpty();
                } else {
                    App.getInstance().ChangePanel(FramePrincipal.INTFronteraRegDrogueria);
                    App.getInstance().framePrincipal.drogueria.allSetEmpty();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(FronteraSplash.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (tiempo != null);
    }
}
