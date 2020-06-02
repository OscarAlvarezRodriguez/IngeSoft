package Frontera;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FramePrincipal extends javax.swing.JFrame {

    /*
    Definition of Jpanel on Numbers 
    everytime that one add Fronter
    update  "Void Change Panel"
    Add     Public Static int INTFronteraXXXXX
     */
    public static final int INTFramePrincipal = 0;
    public static final int INTFronteraRegDrogueria = 1;
    public static final int INTFronteraEmpleado = 2;
    public static final int INTFronteraSplash = 3;
    public static final int INTFronteraAutEmpleado = 4;
    public static final int INTFronteraRegCliente = 5;
    public static final int INTFronteraEditCliente = 6;

    FronteraSplash splash = new FronteraSplash();
    FronteraRegEmpleado empleado = new FronteraRegEmpleado();
    FronteraRegDrogueria drogueria = new FronteraRegDrogueria();
    FronteraAutEmpleado autenticarEmpleado = new FronteraAutEmpleado();
    FronteraEditCliente editarCliente = new FronteraEditCliente();
    //FronteraRegCliente regCliente = new FronteraRegCliente();

    JLabel logo = new JLabel();

    void ChangePanel(int n) {
        //All Frames are Visible(false)
        this.setVisible(true);
        splash.setVisible(false);
        empleado.setVisible(false);
        drogueria.setVisible(false);
        autenticarEmpleado.setVisible(false);
        editarCliente.setVisible(false);
        //regCliente.setVisible(false);

        switch (n) {
            case INTFronteraEmpleado:
                empleado.setVisible(true);
                break;
            case INTFronteraRegDrogueria:
                drogueria.setVisible(true);
                break;
            case INTFronteraSplash:
                splash.setVisible(true);
                break;
            case INTFronteraAutEmpleado:
                autenticarEmpleado.setVisible(true);
                break;
            case INTFronteraEditCliente:
                editarCliente.setVisible(true);
                break;
            case INTFronteraRegCliente:
                //regCliente.setVisible(true);
                break;
            default:
                break;
        }

    }

    public FramePrincipal() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("UNFarmApp");
        logo.setSize(1000, 1000);
        setIconImage(setImageBackground("/Recursos/logo.png", logo).getImage());

        jpPrincipal.setVisible(false);
        add(splash);
        splash.setBounds(jpPrincipal.getBounds());
        splash.setVisible(true);

        add(drogueria);
        drogueria.setBounds(jpPrincipal.getBounds());
        drogueria.setVisible(false);

        add(empleado);
        empleado.setBounds(jpPrincipal.getBounds());
        empleado.setVisible(false);

        add(autenticarEmpleado);
        autenticarEmpleado.setBounds(jpPrincipal.getBounds());
        autenticarEmpleado.setVisible(false);

        App.getInstance().setFramePrincipal(this);
    }

    public ImageIcon setImageBackground(String direccion, Component o) {
        ImageIcon imagen = new ImageIcon(this.getClass().getResource(direccion));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(o.getWidth(), o.getHeight(), Image.SCALE_SMOOTH));
        return imagen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(8, 83, 148));
        setFocusable(false);
        setResizable(false);

        jpPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables

}
