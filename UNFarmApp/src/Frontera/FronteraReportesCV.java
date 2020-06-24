package Frontera;

import Control.GestionarMed;
import Control.ReporteVenta;
import Entidad.Compramedicamento;
import Entidad.Empleado;
import Entidad.Facturamedicamentos;
import Recursos.Funciones;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
        f.setStyleJComboBox(cbAccion);
        f.setStyleJTable(tablaMed, jScrollPane2);
        f.setStyleJLabelBig(jlFondo);
        f.setStyleJLabelBig(jlTitulo);
        f.setStyleJLabelSmall(jlCompra);
        f.setStyleJLabelSmall(jlVenta);
        f.setStyleJLabelSmall(jlBalance);
        f.setStyleJButon(btnActualizar);
        f.setStyleJButon(btnGuardar);
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

    private void cargar() {
        cargarCompras(new String());
        cargarVentas(new String());
        tablaMed.setPreferredSize(new java.awt.Dimension(tablaMed.getWidth(),
                tablaMed.getRowCount() * tablaMed.getRowHeight()));
        tablaMed.repaint();
        tablaMed.revalidate();
    }

    private long cargarCompras(String fecha) {
        long total = 0;
        List<Compramedicamento> listaCompras = reporteVenta.obtenerInfoCompras(fecha);
        Object object[] = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaCompras.size(); i++) {
            int rows = tablaMed.getRowCount();
            long precioTotal = listaCompras.get(i).getCantidad() * listaCompras.get(i).getPreciounitario();
            modelo.addRow(object);
            modelo.setValueAt(listaCompras.get(i).getMedicamento().getIdmedicamentoinvima().getNombremedicamento(), rows, 0);
            modelo.setValueAt(listaCompras.get(i).getCompramedicamentoPK().getIdcompra(), rows, 1);
            modelo.setValueAt(listaCompras.get(i).getCantidad(), rows, 2);
            modelo.setValueAt("Comprar", rows, 3);
            modelo.setValueAt(listaCompras.get(i).getMedicamento().getPrecioventa(), rows, 4);
            modelo.setValueAt(precioTotal, rows, 5);
            modelo.setValueAt(dateFormat.format(listaCompras.get(i).getCompra().getFecha()), rows, 6);
            total = total + precioTotal;
        }
        return total;
    }

    private long cargarVentas(String fecha) {
        long total = 0;
        List<Facturamedicamentos> listaVentas = reporteVenta.obtenerfacturas(fecha);
        Object object[] = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaVentas.size(); i++) {
            int rows = tablaMed.getRowCount();
            long precioTotal = listaVentas.get(i).getCantidadvendida() * listaVentas.get(i).getMedicamento().getPrecioventa();
            modelo.addRow(object);
            modelo.setValueAt(listaVentas.get(i).getMedicamento().getIdmedicamentoinvima().getNombremedicamento(), rows, 0);
            modelo.setValueAt(listaVentas.get(i).getFacturamedicamentosPK().getIdfactura(), rows, 1);
            modelo.setValueAt(listaVentas.get(i).getCantidadvendida(), rows, 2);
            modelo.setValueAt("Vender", rows, 3);
            modelo.setValueAt(listaVentas.get(i).getMedicamento().getPrecioventa(), rows, 4);
            modelo.setValueAt(precioTotal, rows, 5);
            modelo.setValueAt(dateFormat.format(listaVentas.get(i).getFactura().getFecha()), rows, 6);
            total = total + precioTotal;

        }
        return total;
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
        jlUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMed = new javax.swing.JTable();
        jlNombre = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbAccion = new javax.swing.JComboBox<>();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();
        jlBalance = new javax.swing.JLabel();
        jlVenta = new javax.swing.JLabel();
        jlCompra = new javax.swing.JLabel();
        jlFondo = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 700));
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

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));
        add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 65, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Fecha Vendido");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 130, -1));

        btnActualizar.setBackground(new java.awt.Color(0, 158, 15));
        btnActualizar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnActualizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 160, 29));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, 150));

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

        cbAccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Vender", "Comprar" }));
        cbAccion.setPreferredSize(new java.awt.Dimension(300, 30));
        add(cbAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 245, -1));
        add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 240, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 158, 15));
        btnGuardar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(110, 30));
        btnGuardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 640, -1, -1));

        jlTitulo.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Listado de Medicamentos Registrados");
        jlTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlTitulo.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 880, 30));

        jlBalance.setBackground(new java.awt.Color(51, 51, 255));
        jlBalance.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jlBalance.setForeground(new java.awt.Color(255, 255, 255));
        jlBalance.setText("=BalanceGeneral");
        jlBalance.setOpaque(true);
        jlBalance.setPreferredSize(new java.awt.Dimension(245, 30));
        add(jlBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 640, -1, -1));

        jlVenta.setBackground(new java.awt.Color(51, 51, 255));
        jlVenta.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jlVenta.setForeground(new java.awt.Color(255, 255, 255));
        jlVenta.setText("+PrecioVenta");
        jlVenta.setOpaque(true);
        jlVenta.setPreferredSize(new java.awt.Dimension(245, 30));
        add(jlVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, -1, -1));

        jlCompra.setBackground(new java.awt.Color(51, 51, 255));
        jlCompra.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jlCompra.setForeground(new java.awt.Color(255, 255, 255));
        jlCompra.setText("-PrecioCompra");
        jlCompra.setOpaque(true);
        jlCompra.setPreferredSize(new java.awt.Dimension(245, 30));
        add(jlCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, -1, -1));

        jlFondo.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlFondo.setPreferredSize(new java.awt.Dimension(880, 50));
        add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        int seleccion = cbAccion.getSelectedIndex();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = dateFormat.format(dcFecha.getDate());
        DecimalFormat df = new DecimalFormat("##,###,###");

        switch (seleccion) {
            case 0:
                jlVenta.setText("+ " + df.format(cargarVentas(fecha)));
                jlCompra.setText("- " + df.format(cargarCompras(fecha)));
                break;
            case 1:
                jlVenta.setText("+ " + df.format(cargarVentas(fecha)));
                jlCompra.setText("- " + "0");
                break;
            case 2:
                jlCompra.setText("- " + df.format((cargarCompras(fecha))));
                jlVenta.setText("+ " + "0");
                break;
            default:
                break;
        }
        String compra = jlCompra.getText().substring(2).replaceAll("\\.", "");
        String venta = jlVenta.getText().substring(2).replaceAll("\\.", "");
        jlBalance.setText("= " + df.format(Long.valueOf(venta) - Long.valueOf(compra)));
        tablaMed.setPreferredSize(new java.awt.Dimension(tablaMed.getWidth(),
                tablaMed.getRowCount() * tablaMed.getRowHeight()));
        tablaMed.repaint();
        tablaMed.revalidate();
    }//GEN-LAST:event_btnActualizarActionPerformed

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            String url = "jdbc:mysql://localhost:3306/unfarmapp";
            String password = "";
            String user = "root";
            String path = "src\\Recursos\\Reportes\\ReportesCV.jasper";
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            Map parameter = new HashMap();
            parameter.put("fecha", dcFecha.getDate());
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint print = JasperFillManager.fillReport(reporte, parameter, conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAccion;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlBalance;
    private javax.swing.JLabel jlCompra;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JLabel jlVenta;
    private javax.swing.JTable tablaMed;
    // End of variables declaration//GEN-END:variables
}
