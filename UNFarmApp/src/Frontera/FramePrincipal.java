package Frontera;

import Recursos.Funciones;

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
    public static final int INTFronteraAdministrador = 7;
    public static final int INTFronteraGestionMed = 8;
    public static final int INTFronteraComprarMed = 9;
    public static final int INTFronteraGestionarCliente = 10;
    public static final int INTFronteraVenderMed = 11;
    public static final int INTFronteraEditMedicamento = 12;
    public static final int INTFronteraAgregarMed = 13;
    public static final int INTFronteraGestionarDomicilio = 14;
    public static final int INTfronteraRegAdministrador = 15;
    public static final int INTfronteraEditarDrogueria = 16;
    public static final int INTFronteraMenuEmpleado = 17;

    FronteraSplash splash;
    FronteraRegEmpleado empleado = new FronteraRegEmpleado();
    FronteraRegDrogueria drogueria = new FronteraRegDrogueria();
    FronteraAutEmpleado autenticarEmpleado = new FronteraAutEmpleado();
    FronteraEditCliente editarCliente = new FronteraEditCliente();
    FronteraRegCliente regCliente = new FronteraRegCliente();
    FronteraMenuAdministrador menuAdministrador = new FronteraMenuAdministrador();
    FronteraGestionMed gestionMed = new FronteraGestionMed();
    FronteraComprarMed ComprarMed = new FronteraComprarMed();
    FronteraGestionarClientes gestionClientes = new FronteraGestionarClientes();
    FronteraVentaMed venderMed = new FronteraVentaMed();
    FronteraEditMedicamento editMedicamento = new FronteraEditMedicamento();
    FronteraAgregarMed agregarMed = new FronteraAgregarMed();
    FronteraGestionarDomicilios gestionDomicilio = new FronteraGestionarDomicilios();
    FronteraRegAdministrador regAdministrador = new FronteraRegAdministrador();
    FronteraEditarDrogueria editDrogueria = new FronteraEditarDrogueria();
    FronteraMenuEmpleado menuEmpleado = new FronteraMenuEmpleado();

    Funciones f = new Funciones();

    javax.swing.JLabel logo = new javax.swing.JLabel();

    void ChangePanel(int n) {
        //All Frames are Visible(false)
        this.setVisible(true);
        splash.setVisible(false);
        empleado.setVisible(false);
        drogueria.setVisible(false);
        autenticarEmpleado.setVisible(false);
        editarCliente.setVisible(false);
        regCliente.setVisible(false);
        menuAdministrador.setVisible(false);
        gestionMed.setVisible(false);
        ComprarMed.setVisible(false);
        gestionClientes.setVisible(false);
        venderMed.setVisible(false);
        editMedicamento.setVisible(false);
        agregarMed.setVisible(false);
        gestionDomicilio.setVisible(false);
        regAdministrador.setVisible(false);
        editDrogueria.setVisible(false);
        menuEmpleado.setVisible(false);

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
                splash.showAgain();
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
            case INTFronteraAdministrador:
                menuAdministrador.setVisible(true);
                scroll.setViewportView(menuAdministrador);
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
            case INTFronteraGestionarCliente:
                gestionClientes.setVisible(true);
                scroll.setViewportView(gestionClientes);
                break;
            case INTFronteraVenderMed:
                venderMed.setVisible(true);
                scroll.setViewportView(venderMed);
                break;
            case INTFronteraEditMedicamento:
                editMedicamento.setVisible(true);
                scroll.setViewportView(editMedicamento);
                break;
            case INTFronteraAgregarMed:
                agregarMed.setVisible(true);
                scroll.setViewportView(agregarMed);
                break;
            case INTFronteraGestionarDomicilio:
                gestionDomicilio.setVisible(true);
                scroll.setViewportView(gestionDomicilio);
                break;
            case INTfronteraRegAdministrador:
                regAdministrador.setVisible(true);
                scroll.setViewportView(regAdministrador);
                break;
            case INTfronteraEditarDrogueria:
                editDrogueria.setVisible(true);
                scroll.setViewportView(editDrogueria);
                break;
            case INTFronteraMenuEmpleado:
                menuEmpleado.setVisible(true);
                scroll.setViewportView(menuEmpleado);
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

        jpPrincipal.setVisible(false);
        splash = new FronteraSplash();
        splash.setVisible(true);
        scroll.setViewportView(splash);

        try {
            f.setStyleJScrollPane(scroll);
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
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
