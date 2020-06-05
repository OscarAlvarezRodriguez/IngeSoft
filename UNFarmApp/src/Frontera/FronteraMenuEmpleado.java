package Frontera;

import Entidad.Empleado;
import Recursos.Funciones;
import com.sun.prism.j2d.J2DPipeline;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FronteraMenuEmpleado extends javax.swing.JPanel {

    Funciones f = new Funciones();
    Empleado e;

    public FronteraMenuEmpleado() {
        initComponents();
        setStyleButtons();
        jlLogo.setSize(100, 100);
        jlLogo.setIcon(f.setImageBackground("/Recursos/logo.png", jlLogo));
        jlUsuario.setSize(150, 150);
        jlUsuario.setIcon(f.setImageBackground("/Recursos/usuario.png", jlUsuario));
    }

    public void setNombreUsuario(Empleado em) {
        e = em;
        jlNombre.setText(em.getNombreEmpleado() + " " + em.getApellidoEmpleado());
    }

    @Override
    public void paintComponent(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Recursos/fondo.png"));
        g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

    private void setStyleButtons() {
        f.setStyleJButon(btnComprar);
        f.setStyleJButon(btnVender);
        f.setStyleJButon(btnMedicamentos);
        f.setStyleJButon(btnDomicilios);
        f.setStyleJButon(btnReportDomicilio);
        f.setStyleJButon(btnClientes);
        f.setStyleJButon(btnComp_Vent);
        f.setStyleJButon(btnEditarEmpleado);
        f.setStyleJButon(btnDrogueria);
        f.setStyleJButon(btnCerrarSesion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlLogo = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();
        btnMedicamentos = new javax.swing.JButton();
        btnDomicilios = new javax.swing.JButton();
        btnReportDomicilio = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnComp_Vent = new javax.swing.JButton();
        btnEditarEmpleado = new javax.swing.JButton();
        btnDrogueria = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 22)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));

        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿Qué desea realizar el dia de hoy?");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(300, 50));

        btnComprar.setBackground(new java.awt.Color(204, 0, 0));
        btnComprar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar Medicamento");
        btnComprar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnComprar.setPreferredSize(new java.awt.Dimension(250, 40));
        btnComprar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnComprar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnVender.setBackground(new java.awt.Color(204, 0, 0));
        btnVender.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnVender.setForeground(new java.awt.Color(255, 255, 255));
        btnVender.setText("Vender a Domicilio");
        btnVender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVender.setPreferredSize(new java.awt.Dimension(250, 40));
        btnVender.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnVender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnMedicamentos.setBackground(new java.awt.Color(204, 0, 0));
        btnMedicamentos.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnMedicamentos.setForeground(new java.awt.Color(255, 255, 255));
        btnMedicamentos.setText("Gestionar Medicamentos");
        btnMedicamentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMedicamentos.setPreferredSize(new java.awt.Dimension(300, 40));
        btnMedicamentos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMedicamentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicamentosActionPerformed(evt);
            }
        });

        btnDomicilios.setBackground(new java.awt.Color(204, 0, 0));
        btnDomicilios.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnDomicilios.setForeground(new java.awt.Color(255, 255, 255));
        btnDomicilios.setText("Gestionar Domicilios");
        btnDomicilios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDomicilios.setPreferredSize(new java.awt.Dimension(250, 40));
        btnDomicilios.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDomicilios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnReportDomicilio.setBackground(new java.awt.Color(204, 0, 0));
        btnReportDomicilio.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnReportDomicilio.setForeground(new java.awt.Color(255, 255, 255));
        btnReportDomicilio.setText("Reporte Domicilios");
        btnReportDomicilio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportDomicilio.setPreferredSize(new java.awt.Dimension(250, 40));
        btnReportDomicilio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnReportDomicilio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnClientes.setBackground(new java.awt.Color(204, 0, 0));
        btnClientes.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("Gestionar Clientes");
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setPreferredSize(new java.awt.Dimension(250, 40));
        btnClientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnComp_Vent.setBackground(new java.awt.Color(204, 0, 0));
        btnComp_Vent.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnComp_Vent.setForeground(new java.awt.Color(255, 255, 255));
        btnComp_Vent.setText("Rporte C/V");
        btnComp_Vent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnComp_Vent.setPreferredSize(new java.awt.Dimension(250, 40));
        btnComp_Vent.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnComp_Vent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnEditarEmpleado.setBackground(new java.awt.Color(204, 0, 0));
        btnEditarEmpleado.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnEditarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarEmpleado.setText("Editar Perfil");
        btnEditarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarEmpleado.setPreferredSize(new java.awt.Dimension(250, 40));
        btnEditarEmpleado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditarEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnDrogueria.setBackground(new java.awt.Color(204, 0, 0));
        btnDrogueria.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnDrogueria.setForeground(new java.awt.Color(255, 255, 255));
        btnDrogueria.setText("Editar Drogueria");
        btnDrogueria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDrogueria.setPreferredSize(new java.awt.Dimension(250, 40));
        btnDrogueria.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDrogueria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnCerrarSesion.setBackground(new java.awt.Color(204, 0, 0));
        btnCerrarSesion.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(250, 40));
        btnCerrarSesion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(343, 343, 343)
                        .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDomicilios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                        .addComponent(btnDrogueria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEditarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnComp_Vent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReportDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(318, 318, 318)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 229, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDomicilios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComp_Vent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDrogueria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro Desea Salir?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicamentosActionPerformed
         App.getInstance().framePrincipal.gestionMed.setNombreUsuario(e);
        App.getInstance().ChangePanel(FramePrincipal.INTFronteraGestionMed);
    }//GEN-LAST:event_btnMedicamentosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnComp_Vent;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnDomicilios;
    private javax.swing.JButton btnDrogueria;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnMedicamentos;
    private javax.swing.JButton btnReportDomicilio;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlUsuario;
    // End of variables declaration//GEN-END:variables
}
