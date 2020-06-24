package Frontera;

import Control.GestionarDomicilio;
import Entidad.Cliente;
import Entidad.Domicilio;
import Entidad.Empleado;
import Entidad.Factura;
import Entidad.Facturamedicamentos;
import Recursos.Funciones;
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FronteraGestionarDomicilios extends javax.swing.JPanel {

    Funciones f = new Funciones();
    DefaultTableModel modelo;
    GestionarDomicilio domicilios = new GestionarDomicilio();
    Empleado e;
    List<Domicilio> list;

    public FronteraGestionarDomicilios() {
        initComponents();
        allSetEmpty();
        CrearModelo();
        cargar();
        jlLogo.setSize(100, 100);
        jlLogo.setIcon(f.setImageBackground("/Recursos/logo.png", jlLogo));

        jlUsuario.setSize(150, 150);
        JLabel jl = new JLabel();
        jl.setSize(40,40);
        jlUsuario.setIcon(f.setImageBackground("/Recursos/usuario.png", jlUsuario));
        imgNotita.setIcon(f.setImageBackground("/Recursos/notita.png", jl));
        imgCamion.setIcon(f.setImageBackground("/Recursos/camion.png", jl));
        imgCheck.setIcon(f.setImageBackground("/Recursos/check.png", jl));
        jProgressBar.setBackground(Color.red);

    }

    public void setNombreUsuario(Empleado em) {
        if (em != null) {
            e = em;
            jlNombre.setText(em.getNombreempleado() + " " + em.getApellidoempleado());
        }
    }

    public void allSetEmpty() {
        
        jlSalir.setSize(60, 60);
        
        f.setStyleJButon(btnEstado);
        f.setStyleJButonBack(jlSalir);
        f.setStyleJComboBox(domiciliosPendientes);
        f.setStyleJButon(btnCerrarSesion);
        f.setStyleJTable(tablaPedido, jScrollPane2);
        f.setStyleJLabelTable(JCedula);
        f.setStyleJLabelTable(JDireccion);
        f.setStyleJLabelTable(JPrecioFinal);
        f.setStyleJLabelTable(JTelefono);
        f.setStyleJLabelTable(Jdescripcion);
        f.setStyleJLabelTable(Jnombre);
        f.setStyleJLabelTable(jPrecio);
        f.setStyleJLabelBig(jlTitulo1);
        f.setStyleJLabelBig(jlTitulo2);
        f.setStyleJLabelBig(fondo);
    }

    private void CrearModelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Medicamento",
                        "Laboratorio",
                        "Descrpicion",
                        "Tipo Presentacion",
                        "Cantidad",
                        "Precio unitario + IVA"
                    }) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
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
            tablaPedido.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }


    public void cargar() {
        list = domicilios.listaDeDomicilios();
        domiciliosPendientes.removeAllItems();
        for (Iterator<Domicilio> iterator = list.iterator(); iterator.hasNext();) {
            Domicilio next = iterator.next();
            domiciliosPendientes.addItem(next.getIddomicilio().toString());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        jlNombre = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Jnombre = new javax.swing.JLabel();
        JDireccion = new javax.swing.JLabel();
        JTelefono = new javax.swing.JLabel();
        Jdescripcion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        domiciliosPendientes = new javax.swing.JComboBox<>();
        imgCheck = new javax.swing.JLabel();
        imgNotita = new javax.swing.JLabel();
        imgCamion = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        btnEstado = new javax.swing.JButton();
        Jlabel = new javax.swing.JLabel();
        JCedula = new javax.swing.JLabel();
        JPrecioFinal = new javax.swing.JLabel();
        jPrecio = new javax.swing.JLabel();
        jlTitulo2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(75, 75));
        setPreferredSize(new java.awt.Dimension(1030, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));
        add(jlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, -1));

        jlSalir.setPreferredSize(new java.awt.Dimension(60, 60));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlSalirMousePressed(evt);
            }
        });
        add(jlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, -1));

        jlTitulo1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setText("Lista del Pedido");
        jlTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 880, 30));

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));
        add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Direccion");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 30));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nombre");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(140, 30));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Celular/Telefono");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new java.awt.Dimension(140, 30));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(880, 150));
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseReleased(evt);
            }
        });

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPedido.setGridColor(new java.awt.Color(0, 0, 0));
        tablaPedido.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tablaPedido.setMinimumSize(new java.awt.Dimension(0, 0));
        tablaPedido.setPreferredSize(new java.awt.Dimension(880, 120));
        tablaPedido.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaPedidoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPedido);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, -1, -1));

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 211, 320, 20));

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
        add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 240, 160, 29));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Domicilio");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 330, 30));

        Jnombre.setBackground(new java.awt.Color(255, 255, 255));
        Jnombre.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        Jnombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jnombre.setFocusable(false);
        Jnombre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Jnombre.setPreferredSize(new java.awt.Dimension(220, 30));
        add(Jnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        JDireccion.setBackground(new java.awt.Color(255, 255, 255));
        JDireccion.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        JDireccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDireccion.setFocusable(false);
        JDireccion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JDireccion.setPreferredSize(new java.awt.Dimension(220, 30));
        add(JDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, -1, 30));

        JTelefono.setBackground(new java.awt.Color(255, 255, 255));
        JTelefono.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        JTelefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTelefono.setFocusable(false);
        JTelefono.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JTelefono.setPreferredSize(new java.awt.Dimension(220, 30));
        add(JTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        Jdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        Jdescripcion.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        Jdescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jdescripcion.setFocusable(false);
        Jdescripcion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Jdescripcion.setPreferredSize(new java.awt.Dimension(220, 30));
        add(Jdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 360, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Domicilios pendientes");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 190, -1));

        domiciliosPendientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                domiciliosPendientesItemStateChanged(evt);
            }
        });
        domiciliosPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domiciliosPendientesActionPerformed(evt);
            }
        });
        add(domiciliosPendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 190, 30));

        imgCheck.setMaximumSize(new java.awt.Dimension(75, 75));
        imgCheck.setPreferredSize(new java.awt.Dimension(40, 40));
        add(imgCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, -1, -1));

        imgNotita.setMaximumSize(new java.awt.Dimension(75, 75));
        imgNotita.setPreferredSize(new java.awt.Dimension(40, 40));
        add(imgNotita, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, -1, -1));

        imgCamion.setMaximumSize(new java.awt.Dimension(75, 75));
        imgCamion.setPreferredSize(new java.awt.Dimension(40, 40));
        add(imgCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, -1, -1));
        add(jProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 230, 10));

        btnEstado.setText("Siguiente estado");
        btnEstado.setPreferredSize(new java.awt.Dimension(120, 30));
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 230, 30));

        Jlabel.setBackground(new java.awt.Color(255, 255, 255));
        Jlabel.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        Jlabel.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jlabel.setText("Cedula");
        Jlabel.setFocusable(false);
        Jlabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Jlabel.setPreferredSize(new java.awt.Dimension(140, 30));
        add(Jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));

        JCedula.setBackground(new java.awt.Color(255, 255, 255));
        JCedula.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        JCedula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JCedula.setFocusable(false);
        JCedula.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JCedula.setPreferredSize(new java.awt.Dimension(220, 30));
        add(JCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

        JPrecioFinal.setBackground(new java.awt.Color(191, 191, 191));
        JPrecioFinal.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        JPrecioFinal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JPrecioFinal.setFocusable(false);
        JPrecioFinal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JPrecioFinal.setPreferredSize(new java.awt.Dimension(170, 30));
        add(JPrecioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 750, -1, -1));

        jPrecio.setBackground(new java.awt.Color(191, 191, 191));
        jPrecio.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPrecio.setText("Precio total");
        jPrecio.setFocusable(false);
        jPrecio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPrecio.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 750, 112, -1));

        jlTitulo2.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo2.setText("Datos De Usuario");
        jlTitulo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlTitulo2.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 360, 30));
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 360, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void jlSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMousePressed

        allSetEmpty();
        if (e.getEstado().equals("ADMINISTRADOR")) {

            App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenuAdministrador);
            App.getInstance().framePrincipal.menuAdministrador.setNombreUsuario(e);

        }

        if (e.getEstado().equals("ACTIVO")) {

            App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenuEmpleado);
            App.getInstance().framePrincipal.menuEmpleado.setNombreUsuario(e);

        }
    }//GEN-LAST:event_jlSalirMousePressed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Salir?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
            allSetEmpty();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void tablaPedidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidoMouseReleased

    }//GEN-LAST:event_tablaPedidoMouseReleased

    private void jScrollPane2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseReleased

    }//GEN-LAST:event_jScrollPane2MouseReleased

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        Domicilio d = new Domicilio();
        d.setIddomicilio(Integer.valueOf(domiciliosPendientes.getSelectedItem().toString()));
        d = domicilios.getDomicilio((String.valueOf(d.getIddomicilio())));
        
        if(d.getEstado()<2){
            if(d.getEstado()==0)
            {
                JOptionPane.showMessageDialog(null,
                    "Estado actualizado a 'En camino'",
                    "Estado Actualizado Exitosamente",
                    JOptionPane.CANCEL_OPTION);
            }
            else{
                JOptionPane.showMessageDialog(null,
                    "Estado actualizado a 'Entregado', pedido finalizado",
                    "Estado Finalizado Exitosamente",
                    JOptionPane.CANCEL_OPTION);
            }
            domicilios.actualizarEstado(d);
            ActualizarInfoEstado(d);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "El pedido ya está finalizado",
                    "Error al actualizar el estado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void domiciliosPendientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_domiciliosPendientesItemStateChanged
        if (domiciliosPendientes.getSelectedItem() != null) {
            Domicilio d = new Domicilio();
            d.setIddomicilio(Integer.valueOf(domiciliosPendientes.getSelectedItem().toString()));
            d = domicilios.getDomicilio((String.valueOf(d.getIddomicilio())));

            ActualizarInfo(d);

        }
    }//GEN-LAST:event_domiciliosPendientesItemStateChanged

    private void domiciliosPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domiciliosPendientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domiciliosPendientesActionPerformed

    private void ActualizarInfo(Domicilio d) {
        ActualizarInfoCliente(domicilios.getCliente_Domicilio(d));
        ActualizarInfoTabla(d.getIdfactura());
        ActualizarInfoEstado(d);
    }

    private void ActualizarInfoCliente(Cliente c) {
        Jnombre.setText(c.getNombre() + " " + c.getApellido());
        JCedula.setText(c.getCedulacliente());
        JTelefono.setText(c.getTelefono());
        JDireccion.setText(c.getDireccioncliente());
        Jdescripcion.setText(c.getDescripciondireccion());
    }

    private void ActualizarInfoTabla(Factura f) {
        List<Facturamedicamentos> list = f.getFacturamedicamentosList();
        JPrecioFinal.setText(String.valueOf(new DecimalFormat("##,###,###").format(f.getPreciototal())));
        Object object[] = null;
        
        while (modelo.getRowCount() > 0 ) {
            modelo.removeRow(0);
        }
        
        for (int i = 0; i < list.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(list.get(i).getMedicamento().getIdmedicamentoinvima().getNombremedicamento(), i, 0);
            modelo.setValueAt(list.get(i).getMedicamento().getIdmedicamentoinvima().getTitular(), i, 1);
            modelo.setValueAt(list.get(i).getMedicamento().getIdmedicamentoinvima().getDescripcion(), i, 2);
            modelo.setValueAt(list.get(i).getMedicamento().getIdmedicamentoinvima().getPresentacion(),i, 3);
            modelo.setValueAt(list.get(i).getCantidadvendida(), i, 4);
            modelo.setValueAt(list.get(i).getMedicamento().getPrecioventa(),i, 5);
        }
        
        tablaPedido.setPreferredSize(new java.awt.Dimension(tablaPedido.getWidth(),
                tablaPedido.getRowCount() * tablaPedido.getRowHeight()));
        tablaPedido.repaint();
        tablaPedido.revalidate();
        
    }
    
    private void ActualizarInfoEstado(Domicilio d) {
        short newEstate = d.getEstado();

        if (newEstate == 0) {
            jProgressBar.setValue(0);
        } else if (newEstate == 1) {
            jProgressBar.setValue(50);
        } else if (newEstate == 2) {
            jProgressBar.setValue(100);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JCedula;
    private javax.swing.JLabel JDireccion;
    private javax.swing.JLabel JPrecioFinal;
    private javax.swing.JLabel JTelefono;
    private javax.swing.JLabel Jdescripcion;
    private javax.swing.JLabel Jlabel;
    private javax.swing.JLabel Jnombre;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEstado;
    private javax.swing.JComboBox<String> domiciliosPendientes;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel imgCamion;
    private javax.swing.JLabel imgCheck;
    private javax.swing.JLabel imgNotita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jPrecio;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlTitulo1;
    private javax.swing.JLabel jlTitulo2;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTable tablaPedido;
    // End of variables declaration//GEN-END:variables

    

}
