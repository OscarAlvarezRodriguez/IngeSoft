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
    public static final int INTFronteraGestionMed = 8;
    public static final int INTFronteraComprarMed = 9;

    FronteraSplash splash = new FronteraSplash();
    FronteraRegEmpleado empleado = new FronteraRegEmpleado();
    FronteraRegDrogueria drogueria = new FronteraRegDrogueria();
    FronteraAutEmpleado autenticarEmpleado = new FronteraAutEmpleado();
    FronteraEditCliente editarCliente = new FronteraEditCliente();
    FronteraRegCliente regCliente = new FronteraRegCliente();
    FronteraMenuEmpleado menuEmpleado = new FronteraMenuEmpleado();
    FronteraGestionMed gestionMed = new FronteraGestionMed();
    FronteraComprarMed ComprarMed = new FronteraComprarMed();
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
        gestionMed.setVisible(false);
        ComprarMed.setVisible(false);

        switch (n) {
            case INTFronteraEmpleado:
                empleado.setVisible(true);
                scroll.setViewportView(empleado);
                break;
            case INTFronteraRegDrogueria:
                drogueria.setVisible(true);
                scroll.setViewportView(drogueria);
                break;
            case INTFronteraSplash:
                splash.setVisible(true);
                scroll.setViewportView(splash);
                break;
            case INTFronteraAutEmpleado:
                autenticarEmpleado.setVisible(true);
                scroll.setViewportView(autenticarEmpleado);
                break;
            case INTFronteraEditCliente:
                editarCliente.setVisible(true);
                scroll.setViewportView(editarCliente);
                break;
            case INTFronteraRegCliente:
                regCliente.setVisible(true);
                scroll.setViewportView(regCliente);
                break;
            case INTFronteraMenu:
                menuEmpleado.setVisible(true);
                scroll.setViewportView(menuEmpleado);
                break;
            case INTFronteraGestionMed:
                gestionMed.setVisible(true);
                scroll.setViewportView(gestionMed);
                break;
            case INTFronteraComprarMed:
                ComprarMed.setVisible(true);
                //Mete el JPanel dentro del scroll panel
                scroll.setViewportView(ComprarMed);
                break;
            default:
                break;
        }
        revalidate();
        repaint();

    }

    public FramePrincipal() {

        initComponents();
        App.getInstance().setFramePrincipal(this);

        setLocationRelativeTo(null);
        setTitle("UNFarmApp");
        logo.setSize(1000, 1000);
        jpPrincipal.setSize(1030, 550);
        setIconImage(f.setImageBackground("/Recursos/logo.png", logo).getImage());

        addPanel(jpPrincipal);
        addPanel(autenticarEmpleado);
        addPanel(drogueria);
        addPanel(editarCliente);
        addPanel(empleado);
        addPanel(regCliente);
        addPanel(splash);
        addPanel(menuEmpleado);
        addPanel(gestionMed);
        addPanel(ComprarMed);
        jpPrincipal.setVisible(false);
        splash.setVisible(true);
        scroll.setViewportView(splash);
    }
    
    
    private void addPanel(JPanel New) {
        scroll.setViewportView(New);
        New.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        jpPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(8, 83, 148));
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(1080, 600));
        setResizable(false);

        scroll.setPreferredSize(new java.awt.Dimension(1080, 600));

        jpPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpPrincipal.setPreferredSize(new java.awt.Dimension(1030, 550));

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        scroll.setViewportView(jpPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

}
