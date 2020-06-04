package Frontera;

import Recursos.Funciones;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FramePrincipal extends javax.swing.JFrame {

    /*
    Definition of Jpanel on Numbers 
    everytime that one add Fronter
    update  "Void Change Panel"
    Add     Public Static int INTFronteraXXXXX
    Add in the costructor 
     add(new Panel);
        new Panel.setBounds(jpPrincipal.getBounds());
        new Panel.setVisible(true);
    
     */
    public static final int INTFramePrincipal = 0;
    public static final int INTFronteraRegDrogueria = 1;
    public static final int INTFronteraEmpleado = 2;
    public static final int INTFronteraSplash = 3;
    public static final int INTFronteraAutEmpleado = 4;
    public static final int INTFronteraRegCliente = 5;
    public static final int INTFronteraEditCliente = 6;
    public static final int INTFronteraMenu = 7;

    FronteraSplash splash = new FronteraSplash();
    FronteraRegEmpleado empleado = new FronteraRegEmpleado();
    FronteraRegDrogueria drogueria = new FronteraRegDrogueria();
    FronteraAutEmpleado autenticarEmpleado = new FronteraAutEmpleado();
    FronteraEditCliente editarCliente = new FronteraEditCliente();
    FronteraRegCliente regCliente = new FronteraRegCliente();
    FronteraMenuEmpleado menuEmpleado =  new FronteraMenuEmpleado();
    Funciones f = new Funciones();

    JLabel logo = new JLabel();

    void ChangePanel(int n) {
        //All Frames are Visible(false)
        this.setVisible(true);
        splash.setVisible(false);
        empleado.setVisible(false);
        drogueria.setVisible(false);
        autenticarEmpleado.setVisible(false);
        editarCliente.setVisible(false);
        regCliente.setVisible(false);
        menuEmpleado.setVisible(false);

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
                regCliente.setVisible(true);
                break;
            case INTFronteraMenu:
                menuEmpleado.setVisible(true);
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
        setIconImage(f.setImageBackground("/Recursos/logo.png", logo).getImage());

        addPanel(jpPrincipal);
        addPanel(autenticarEmpleado);
        addPanel(drogueria);
        addPanel(editarCliente);
        addPanel(empleado);
        addPanel(regCliente);
        addPanel(splash);
        addPanel(menuEmpleado);

        jpPrincipal.setVisible(false);
        splash.setVisible(true);

        App.getInstance().setFramePrincipal(this);
    }

    private void addPanel(JPanel New) {
        add(New);
        New.setBounds(jpPrincipal.getBounds());
        New.setVisible(false);
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
