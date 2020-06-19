package Frontera;

import Control.GestionarDomicilio;
import DAO.FacturaDAO;
import Entidad.Domicilio;
import Entidad.Empleado;
import Recursos.Funciones;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
        jlUsuario.setIcon(f.setImageBackground("/Recursos/usuario.png", jlUsuario));

        imgNotita.setSize(75, 75);
        imgNotita.setIcon(f.setImageBackground("/Recursos/notita.png", imgNotita));
        
        imgCamion.setSize(75, 75);
        imgCamion.setIcon(f.setImageBackground("/Recursos/camion.png", imgCamion));
        
        imgCheck.setSize(75, 75);
        imgCheck.setIcon(f.setImageBackground("/Recursos/check.png", imgCheck));

        
    }

    public void setNombreUsuario(Empleado em) {
        if (em != null) {
            e=em;
            jlNombre.setText(em.getNombreempleado() + " " + em.getApellidoempleado());
        }
    }

    public void allSetEmpty() {
        f.setStyleJButon(btnEstado);
    }

    private void CrearModelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Medicamento",
                        "Laboratorio",
                        "Descrpicion",
                        "Tipo Presentacion",
                        "Concentracion",
                        "Cantidad",
                        "Precio unitario + IVA"
                    }) {
                Class[] types = new Class[]{
                    java.lang.String.class,
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
            tablaClientes.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    public void search() {
        
    }

    private void cargar() {
        list = domicilios.listaDeDomicilios();
        for (Iterator<Domicilio> iterator = list.iterator(); iterator.hasNext();) {
            Domicilio next = iterator.next();
            domiciliosPendientes.addItem(next.getIddomicilio().toString());
        }
        
        System.out.println(domiciliosPendientes.getSelectedItem().toString() + "WE");
        
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
        tablaClientes = new javax.swing.JTable();
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

        setMaximumSize(new java.awt.Dimension(75, 75));
        setPreferredSize(new java.awt.Dimension(1030, 750));

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));

        jlSalir.setPreferredSize(new java.awt.Dimension(60, 60));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlSalirMousePressed(evt);
            }
        });

        jlTitulo1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setText("Lista del Domicilio");
        jlTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setPreferredSize(new java.awt.Dimension(300, 50));

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Direccion");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new java.awt.Dimension(170, 30));

        jLabel3.setBackground(new java.awt.Color(191, 191, 191));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nombre");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Celular/Telefono");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new java.awt.Dimension(170, 30));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(880, 150));
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseReleased(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.setGridColor(new java.awt.Color(0, 0, 0));
        tablaClientes.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tablaClientes.setMinimumSize(new java.awt.Dimension(0, 0));
        tablaClientes.setPreferredSize(new java.awt.Dimension(880, 120));
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaClientesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClientes);

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));

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

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Domicilio");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));

        Jnombre.setBackground(new java.awt.Color(255, 255, 255));
        Jnombre.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        Jnombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jnombre.setFocusable(false);
        Jnombre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Jnombre.setPreferredSize(new java.awt.Dimension(170, 30));

        JDireccion.setBackground(new java.awt.Color(255, 255, 255));
        JDireccion.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        JDireccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDireccion.setFocusable(false);
        JDireccion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JDireccion.setPreferredSize(new java.awt.Dimension(170, 30));

        JTelefono.setBackground(new java.awt.Color(255, 255, 255));
        JTelefono.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        JTelefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTelefono.setFocusable(false);
        JTelefono.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JTelefono.setPreferredSize(new java.awt.Dimension(170, 30));

        Jdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        Jdescripcion.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        Jdescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jdescripcion.setFocusable(false);
        Jdescripcion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Jdescripcion.setPreferredSize(new java.awt.Dimension(170, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Domicilios pendientes");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));

        domiciliosPendientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                domiciliosPendientesItemStateChanged(evt);
            }
        });

        imgCheck.setText("\"");
        imgCheck.setMaximumSize(new java.awt.Dimension(75, 75));
        imgCheck.setMinimumSize(null);

        imgNotita.setText("\"");
        imgNotita.setMaximumSize(new java.awt.Dimension(75, 75));
        imgNotita.setMinimumSize(null);

        imgCamion.setText("\"");
        imgCamion.setMaximumSize(new java.awt.Dimension(75, 75));
        imgCamion.setMinimumSize(null);

        btnEstado.setText("Siguiente estado");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(domiciliosPendientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imgNotita, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(imgCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(imgCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEstado)
                        .addGap(102, 102, 102))))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(domiciliosPendientes))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imgNotita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(imgCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imgCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jlTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMousePressed

        allSetEmpty();
        if(e.getEstado().equals("ADMINISTRADOR")){
            
                App.getInstance().ChangePanel(FramePrincipal.INTFronteraAdministrador);
                App.getInstance().framePrincipal.menuAdministrador.setNombreUsuario(e);
                
            }
            
            if(e.getEstado().equals("ACTIVO")){
            
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

    private void tablaClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseReleased

    }//GEN-LAST:event_tablaClientesMouseReleased

    private void jScrollPane2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseReleased

    }//GEN-LAST:event_jScrollPane2MouseReleased

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        if(jProgressBar.getValue() == 0){
            jProgressBar.setValue(50);
        }else if(jProgressBar.getValue() == 50){
            jProgressBar.setValue(100);
        }else{
            
        }
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void domiciliosPendientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_domiciliosPendientesItemStateChanged
        Integer idDomicilio = Integer.parseInt(domiciliosPendientes.getSelectedItem().toString());
        
    }//GEN-LAST:event_domiciliosPendientesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDireccion;
    private javax.swing.JLabel JTelefono;
    private javax.swing.JLabel Jdescripcion;
    private javax.swing.JLabel Jnombre;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEstado;
    private javax.swing.JComboBox<String> domiciliosPendientes;
    private javax.swing.JLabel imgCamion;
    private javax.swing.JLabel imgCheck;
    private javax.swing.JLabel imgNotita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlTitulo1;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
