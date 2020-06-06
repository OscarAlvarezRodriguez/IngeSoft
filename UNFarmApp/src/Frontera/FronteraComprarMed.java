package Frontera;

import DAO.MedicamentoDAO;
import Entidad.Empleado;
import Recursos.Funciones;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FronteraComprarMed extends javax.swing.JPanel {

    Funciones f = new Funciones();
    DefaultTableModel modelo, modelo1;
    MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
    MedicamentoDAO.CombinacionMed concat = new MedicamentoDAO.CombinacionMed();

    public FronteraComprarMed() {
        initComponents();
        allSetEmpty();
        CrearModelo();
        cargar();
        f.setStyleJTable(tablaMed,jScrollPane2);
        jlLogo.setSize(100, 100);
        jlLogo.setIcon(f.setImageBackground("/Recursos/logo.png", jlLogo));
        jlSalir.setSize(60, 60);
        f.setStyleJButonBack(jlSalir);
        f.setStyleJButon(btnActualizar1);
        jlUsuario.setSize(100, 100);
        jlUsuario.setIcon(f.setImageBackground("/Recursos/usuario.png", jlUsuario));

    }

    public void setNombreUsuario(Empleado em) {
        jlNombre.setText(em.getNombreEmpleado() + " " + em.getApellidoEmpleado());
    }

    public void allSetEmpty() {

        txtCliente.setText("");
        txtDescripcion.setText("");
        txtTitular.setText("");
        txtMed.setText("");
        txtPresentacion.setText("");
        txtPrinAct.setText("");
        txtTitular.setText("");
        f.setStyleJTextField(txtCliente);
        f.setStyleJTextField(txtTitular);
        f.setStyleJTextField(txtMed);
        f.setStyleJTextField(txtPresentacion);
        f.setStyleJTextField(txtPrinAct);
        f.setStyleJTextField(txtTitular);
        f.setStyleJTextArea(txtDescripcion, jScrollPane1);

    }

    private void CrearModelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Medicamento",
                        "Titular",
                        "Descripcion",
                        "Principio Activo",
                        "Presentacion",
                        "Unidades Disponibles",
                        "Precio Unitario + IVA"}) {
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
            
             modelo1 = (new DefaultTableModel(
                    null, new String[]{
                        "Medicamento",
                        "Unidades Disponibles",
                        "Precio Unitario + IVA"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.Short.class,
                    java.lang.Integer.class
                };
                boolean[] canEdit = new boolean[]{
                    false,
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
            
            tablaMed.setModel(modelo);
            TablaMedComprado.setModel(modelo1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    private void search() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        concat = new MedicamentoDAO.CombinacionMed(txtMed.getText(),
                txtTitular.getText(),
                txtDescripcion.getText(),
                txtPresentacion.getText(),
                txtPrinAct.getText(),
                Short.parseShort(String.valueOf(0)),
                0);
          ArrayList<MedicamentoDAO.CombinacionMed> listaClientes = new MedicamentoDAO.CombinacionMed().selectAll(concat);
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getNombreMedicamento(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getTitular(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getDescripcion(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getPrincipioActivo(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getPresentacion(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getStock(), i, 5);
            modelo.setValueAt(listaClientes.get(i).getPrecioVenta(), i, 6);
        }
    }

    private void cargar() {
        ArrayList<MedicamentoDAO.CombinacionMed> listaClientes = new MedicamentoDAO.CombinacionMed().selectAll();
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getNombreMedicamento(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getTitular(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getDescripcion(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getPrincipioActivo(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getPresentacion(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getStock(), i, 5);
            modelo.setValueAt(listaClientes.get(i).getPrecioVenta(), i, 6);
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jlLogo = new javax.swing.JLabel();
        jlSalir = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPresentacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnActualizar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMed = new javax.swing.JTextField();
        txtPrinAct = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMed = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaMedComprado = new javax.swing.JTable();
        Agregar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 1000));
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

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 271, 20));

        jlUsuario.setPreferredSize(new java.awt.Dimension(100, 100));
        add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo de Presentacion");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 323, -1, -1));

        txtPresentacion.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtPresentacion.setPreferredSize(new java.awt.Dimension(250, 30));
        txtPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusLost(evt);
            }
        });
        txtPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyTyped(evt);
            }
        });
        add(txtPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 323, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Descripción");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 238, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cliente");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 202, -1, -1));

        txtCliente.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtCliente.setPreferredSize(new java.awt.Dimension(300, 30));
        txtCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClienteFocusLost(evt);
            }
        });
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });
        add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 202, 250, -1));

        btnActualizar1.setBackground(new java.awt.Color(0, 158, 15));
        btnActualizar1.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar1.setText("Cerrar Sesion");
        btnActualizar1.setPreferredSize(new java.awt.Dimension(150, 30));
        btnActualizar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnActualizar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });
        add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 160, 29));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Medicamento");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 202, -1, -1));

        txtMed.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtMed.setPreferredSize(new java.awt.Dimension(250, 30));
        txtMed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMedFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMedFocusLost(evt);
            }
        });
        txtMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMedKeyTyped(evt);
            }
        });
        add(txtMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 202, -1, -1));

        txtPrinAct.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtPrinAct.setPreferredSize(new java.awt.Dimension(250, 30));
        txtPrinAct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrinActFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrinActFocusLost(evt);
            }
        });
        txtPrinAct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrinActKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrinActKeyTyped(evt);
            }
        });
        add(txtPrinAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 283, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Principio Activo");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 283, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("TItular");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 243, -1, -1));

        txtTitular.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtTitular.setPreferredSize(new java.awt.Dimension(250, 30));
        txtTitular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTitularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTitularFocusLost(evt);
            }
        });
        txtTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitularKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTitularKeyTyped(evt);
            }
        });
        add(txtTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 243, -1, -1));

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
        tablaMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaMed);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 371, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 238, -1, -1));

        TablaMedComprado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TablaMedComprado);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 800, 130));

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jlSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMousePressed
        App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenu);
    }//GEN-LAST:event_jlSalirMousePressed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        search();
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitularKeyTyped

    }//GEN-LAST:event_txtTitularKeyTyped

    private void txtTitularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitularKeyReleased
        search();
    }//GEN-LAST:event_txtTitularKeyReleased

    private void txtTitularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitularFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitularFocusLost

    private void txtTitularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitularFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitularFocusGained

    private void txtPrinActKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrinActKeyTyped

    }//GEN-LAST:event_txtPrinActKeyTyped

    private void txtPrinActKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrinActKeyReleased
        search();
    }//GEN-LAST:event_txtPrinActKeyReleased

    private void txtPrinActFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrinActFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrinActFocusLost

    private void txtPrinActFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrinActFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrinActFocusGained

    private void txtMedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedKeyTyped

    }//GEN-LAST:event_txtMedKeyTyped

    private void txtMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedKeyReleased
        search();
    }//GEN-LAST:event_txtMedKeyReleased

    private void txtMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedFocusLost

    private void txtMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedFocusGained

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
        allSetEmpty();
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped

    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteFocusLost

    private void txtClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteFocusGained

    private void txtPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != 32) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPresentacionKeyTyped

    private void txtPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyReleased
        search();
    }//GEN-LAST:event_txtPresentacionKeyReleased

    private void txtPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyPressed

    }//GEN-LAST:event_txtPresentacionKeyPressed

    private void txtPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusLost

    }//GEN-LAST:event_txtPresentacionFocusLost

    private void txtPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusGained
        if (txtPresentacion.getBackground().equals(f.fondoTxtError)) {
            txtPresentacion.setBackground(f.fondoTxt);
            txtPresentacion.setText("");
        }
    }//GEN-LAST:event_txtPresentacionFocusGained
    
    int[] seleccionar;
    
    private void tablaMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedMouseClicked
        
         seleccionar= tablaMed.getSelectedRows();
    }//GEN-LAST:event_tablaMedMouseClicked

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        
        
        ArrayList<MedicamentoDAO.CombinacionMed> Agregar = new ArrayList<>();
        
        for( int j = 0; j<seleccionar.length; j++){
            
            MedicamentoDAO.CombinacionMed concat = new MedicamentoDAO.CombinacionMed(
            
                    (String)tablaMed.getValueAt(seleccionar[j],0),
                    null,
                    null,
                    null,
                    null,
                    (Short)tablaMed.getValueAt(seleccionar[j],5),
                    (Integer)tablaMed.getValueAt(seleccionar[j],6)
            
            );
                Agregar.add(concat);      
        }
        
        Object object[] = null;
        for (int i = 0; i < Agregar.size(); i++) {
            modelo1.addRow(object);
            modelo1.setValueAt(Agregar.get(i).getNombreMedicamento(), i, 0);
            modelo1.setValueAt(Agregar.get(i).getStock(), i, 1);
            modelo1.setValueAt(Agregar.get(i).getPrecioVenta(), i, 2);
        }
    }//GEN-LAST:event_AgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTable TablaMedComprado;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTable tablaMed;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMed;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtPrinAct;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
