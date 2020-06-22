package Frontera;

import Control.GestionarMed;
import Control.ReporteVenta;
import Entidad.Compramedicamento;
import Entidad.Empleado;
import Entidad.Facturamedicamentos;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import Recursos.Funciones;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FronteraReportesCV extends javax.swing.JPanel {

    Funciones f = new Funciones();
    DefaultTableModel modelo;
    GestionarMed gestionarMed = new GestionarMed();
    ReporteVenta reporteVenta = new ReporteVenta();
    Empleado e;

    public FronteraReportesCV() {
        initComponents();
        allSetEmpty();
        CrearModelo();
        cargar();
        jlLogo.setSize(100, 100);
        jlLogo.setIcon(f.setImageBackground("/Recursos/logo.png", jlLogo));

        jlUsuario.setSize(150, 150);
        jlUsuario.setIcon(f.setImageBackground("/Recursos/usuario.png", jlUsuario));

    }

    public void setNombreUsuario(Empleado em) {
        if (em != null) {
            e = em;

            jlNombre.setText(em.getNombreempleado() + " " + em.getApellidoempleado());
        }
    }

    public void allSetEmpty() {
        f.setStyleJComboBox(cbEstado);
        f.setStyleJTable(tablaMed, jScrollPane2);
        f.setStyleJLabel(jlTitulo1);
        f.setStyleJButon(btnEliminar);
        f.setStyleJButon(btnCerrarSesion);
        jlSalir.setSize(60, 60);
        f.setStyleJButonBack(jlSalir);

    }

    private void CrearModelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Nombre",
                        "ID",
                        "Cantidad",
                        "Accion",
                        "PrecioUnitario",
                        "Precio Total",
                        "Fecha Vendido"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.Integer.class,
                    java.lang.Short.class,
                    java.lang.String.class,
                    java.lang.Integer.class,
                    java.lang.Long.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false

                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }

            });
            tablaMed.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    public void search() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Medicamentoinvima mi = new Medicamentoinvima();
        Medicamento m = new Medicamento();
        m.setIdmedicamentoinvima(mi);
        List<Medicamento> listaClientes = gestionarMed.listaDeMedicamentos(m);
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamento(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getNombremedicamento(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getTitular(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getDescripcion(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPrincipioactivo(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPresentacion(), i, 5);
            modelo.setValueAt(listaClientes.get(i).getStock(), i, 6);
            modelo.setValueAt(listaClientes.get(i).getPrecioventa(), i, 7);
        }
        tablaMed.setPreferredSize(new java.awt.Dimension(tablaMed.getWidth(),
                tablaMed.getRowCount() * tablaMed.getRowHeight()));
        tablaMed.repaint();
        tablaMed.revalidate();
    }

    private void cargar() {

        List<Facturamedicamentos> listaVentas = reporteVenta.obtenerfacturas();
        Object object[] = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaVentas.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaVentas.get(i).getMedicamento().getIdmedicamentoinvima().getNombremedicamento(), i, 0);
            modelo.setValueAt(listaVentas.get(i).getFacturamedicamentosPK().getIdfactura(), i, 1);
            modelo.setValueAt(listaVentas.get(i).getCantidadvendida(), i, 2);
            modelo.setValueAt("Vender", i, 3);
            modelo.setValueAt(listaVentas.get(i).getMedicamento().getPrecioventa(), i, 4);
            modelo.setValueAt(listaVentas.get(i).getFactura().getPreciototal(), i, 5);
            modelo.setValueAt(dateFormat.format(listaVentas.get(i).getFactura().getFecha()), i, 6);
        }
        tablaMed.setPreferredSize(new java.awt.Dimension(tablaMed.getWidth(),
                tablaMed.getRowCount() * tablaMed.getRowHeight()));
        tablaMed.repaint();
        tablaMed.revalidate();
        List<Compramedicamento> listaCompras = reporteVenta.obtenerInfoCompras();
        
        for (int i = 0; i <  listaCompras.size(); i++) {
            int rows = tablaMed.getRowCount();
            modelo.addRow(object);
            modelo.setValueAt(listaCompras.get(i).getMedicamento().getIdmedicamentoinvima().getNombremedicamento(), rows, 0);
            modelo.setValueAt(listaCompras.get(i).getCompramedicamentoPK().getIdcompra(), rows, 1);
            modelo.setValueAt(listaCompras.get(i).getCantidad(), rows, 2);
            modelo.setValueAt("Comprar", rows, 3);
            modelo.setValueAt(listaCompras.get(i).getMedicamento().getPrecioventa(), rows, 4);
            modelo.setValueAt(listaCompras.get(i).getCompra().getPreciototal(), rows, 5);
            modelo.setValueAt(dateFormat.format(listaCompras.get(i).getCompra().getFecha()), rows, 6);
        }
        tablaMed.setPreferredSize(new java.awt.Dimension(tablaMed.getWidth(),
                tablaMed.getRowCount() * tablaMed.getRowHeight()));
        tablaMed.repaint();
        tablaMed.revalidate();
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
        jlSalir = new javax.swing.JLabel();
        jlTitulo1 = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMed = new javax.swing.JTable();
        jlNombre = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));
        add(jlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, -1));

        jlSalir.setPreferredSize(new java.awt.Dimension(60, 60));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlSalirMouseReleased(evt);
            }
        });
        add(jlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jlTitulo1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setText("Listado de Medicamentos Registrados");
        jlTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 381, 880, 30));

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));
        add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 65, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Fecha Vendido");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 130, -1));

        btnEliminar.setBackground(new java.awt.Color(0, 158, 15));
        btnEliminar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnEliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, 160, 29));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Accion");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 130, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(880, 150));

        tablaMed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaMed.setGridColor(new java.awt.Color(0, 0, 0));
        tablaMed.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tablaMed.setMinimumSize(new java.awt.Dimension(0, 0));
        tablaMed.setPreferredSize(new java.awt.Dimension(880, 120));
        tablaMed.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tablaMed);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 411, -1, 150));

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 22)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 225, 320, 20));

        btnCerrarSesion.setBackground(new java.awt.Color(0, 158, 15));
        btnCerrarSesion.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(150, 30));
        btnCerrarSesion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 255, 160, 29));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Medicamentos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 17, 330, 30));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cbEstado.setPreferredSize(new java.awt.Dimension(300, 30));
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
            }
        });
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });
        add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 245, -1));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 240, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int[] i = tablaMed.getSelectedRows();
        if (i.length == 0) {
            JOptionPane.showMessageDialog(null,
                    "Ningun Elemento Seleccionado\n"
                    + " Por Favor Selecione Algun Cliente Todos Los Campos",
                    "Selccion Vacia",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int in = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Elimiar " + (String) tablaMed.getValueAt(i[0], 1) + " ?", "Elimiar Medicamento", JOptionPane.YES_NO_OPTION);
            if (in == JOptionPane.YES_OPTION) {
                Medicamento viejo = gestionarMed.leerMedicamento((Short) tablaMed.getValueAt(i[0], 0));
                Medicamento nuevo = viejo;
                nuevo.setStock(Short.valueOf("-1"));
                gestionarMed.actualizarMedicamento(viejo, nuevo);
                search();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Salir?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
            allSetEmpty();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void jlSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMouseReleased
        allSetEmpty();
        if (e.getEstado().equals("ADMINISTRADOR")) {

            App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenuAdministrador);
            App.getInstance().framePrincipal.menuAdministrador.setNombreUsuario(e);

        }

        if (e.getEstado().equals("ACTIVO")) {

            App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenuEmpleado);
            App.getInstance().framePrincipal.menuEmpleado.setNombreUsuario(e);

        }
    }//GEN-LAST:event_jlSalirMouseReleased

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
        search();
    }//GEN-LAST:event_cbEstadoItemStateChanged

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbEstado;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlTitulo1;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTable tablaMed;
    // End of variables declaration//GEN-END:variables
}
