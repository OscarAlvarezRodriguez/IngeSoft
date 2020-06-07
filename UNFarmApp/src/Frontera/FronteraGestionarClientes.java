package Frontera;

import DAO.MedicamentoDAO;
import Entidad.Empleado;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import Recursos.Funciones;
import java.awt.Graphics;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FronteraGestionarClientes extends javax.swing.JPanel {

    Funciones f = new Funciones();
    DefaultTableModel modelo;
    MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    public FronteraGestionarClientes() {
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
        jlNombre.setText(em.getNombreempleado() + " " + em.getApellidoempleado());
    }

    public void allSetEmpty() {

        txtNombre.setText("");
        txtDescripcion.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtApellido.setText("");
        f.setStyleJTextField(txtNombre);
        f.setStyleJTextField(txtApellido);
        f.setStyleJTextField(txtCedula);
        f.setStyleJTextField(txtDireccion);
        f.setStyleJTextField(txtTelefono);
        f.setStyleJTextField(txtApellido);
        f.setStyleJTextArea(txtDescripcion, jScrollPane1);
        f.setStyleJTable(tablaClientes, jScrollPane2);
        f.setStyleJLabel(jlTitulo1);
        f.setStyleJButon(btnEliminar);
        f.setStyleJButon(btnRegistrar);
        f.setStyleJButon(btnEditar);
        f.setStyleJButon(btnCerrarSesion);
        jlSalir.setSize(60, 60);
        f.setStyleJButonBack(jlSalir);

    }

    private void CrearModelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Cedula",
                        "Nombre",
                        "Apellido",
                        "Telefono",
                        "Direccion",
                        "Descipcion"
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
                    true,
                    true,
                    true,
                    true,
                    true
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

    private void search() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private void cargar() {
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
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jlNombre = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));
        add(jlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 11, -1, -1));

        jlSalir.setPreferredSize(new java.awt.Dimension(60, 60));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlSalirMousePressed(evt);
            }
        });
        add(jlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jlTitulo1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setText("Listado de Clientes registrados");
        jlTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 880, 30));

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));
        add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Direccion");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtDireccion.setPreferredSize(new java.awt.Dimension(250, 30));
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Descripción");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nombre");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        txtNombre.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtNombre.setPreferredSize(new java.awt.Dimension(300, 30));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 250, -1));

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
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 690, 160, 29));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("N° Cedula");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        txtCedula.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtCedula.setPreferredSize(new java.awt.Dimension(250, 30));
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCedulaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtTelefono.setPreferredSize(new java.awt.Dimension(250, 30));
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Celular/Telefono");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Apellido");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        txtApellido.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtApellido.setPreferredSize(new java.awt.Dimension(250, 30));
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(880, 150));

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
        jScrollPane2.setViewportView(tablaClientes);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(250, 114));

        txtDescripcion.setColumns(1);
        txtDescripcion.setRows(1);
        txtDescripcion.setTabSize(1);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 250, 70));

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 320, 20));

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
        add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 160, 29));

        btnEditar.setBackground(new java.awt.Color(0, 158, 15));
        btnEditar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnEditar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 160, 29));

        btnRegistrar.setBackground(new java.awt.Color(0, 158, 15));
        btnRegistrar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnRegistrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 690, 160, 29));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Clientes");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 330, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        if (txtDireccion.getBackground().equals(f.fondoTxtError)) {
            txtDireccion.setBackground(f.fondoTxt);
            txtDireccion.setText("");
        }
    }//GEN-LAST:event_txtDireccionFocusGained

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost

    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != 32) {
            evt.consume();
        }


    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaFocusGained

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped

    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped

    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped

    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoFocusLost

    private void txtApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoFocusGained

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed

    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        search();
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        search();
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        search();
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        search();
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        search();
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void jlSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMousePressed
        App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenu);
    }//GEN-LAST:event_jlSalirMousePressed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
        allSetEmpty();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlTitulo1;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
