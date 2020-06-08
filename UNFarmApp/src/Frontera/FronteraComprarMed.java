package Frontera;

import Control.ComprarMedicamento;
import DAO.CompraDAO;
import Entidad.Compra;
import Entidad.Compramedicamento;
import Entidad.CompramedicamentoPK;
import Entidad.Empleado;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import Recursos.Funciones;
import java.awt.Graphics;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FronteraComprarMed extends javax.swing.JPanel {

    Funciones f = new Funciones();
    ArrayList<Compramedicamento> compras = new ArrayList<>();
    Long PrecioTotal = Long.valueOf("0");
    DefaultTableModel modelo, modelo1;
    ComprarMedicamento comprarMedicamento = new ComprarMedicamento();

    public FronteraComprarMed() {
        initComponents();
        allSetEmpty();
        CrearModelo();
        cargar();

        jlLogo.setSize(100, 100);
        jlLogo.setIcon(f.setImageBackground("/Recursos/logo.png", jlLogo));

        jlUsuario.setSize(100, 100);
        jlUsuario.setIcon(f.setImageBackground("/Recursos/usuario.png", jlUsuario));

    }

    public void setNombreUsuario(Empleado em) {
        jlNombre.setText(em.getNombreempleado() + " " + em.getApellidoempleado());
    }

    public void allSetEmpty() {

        txtProv.setText("");
        txtDescripcion.setText("");
        txtTitular.setText("");
        txtMed.setText("");
        txtPresentacion.setText("");
        txtPrinAct.setText("");
        txtTitular.setText("");
        f.setStyleJTextField(txtProv);
        f.setStyleJTextField(txtTitular);
        f.setStyleJTextField(txtMed);
        f.setStyleJTextField(txtPresentacion);
        f.setStyleJTextField(txtPrinAct);
        f.setStyleJTextField(txtTitular);
        f.setStyleJTextArea(txtDescripcion, jScrollPane1);
        jlSalir.setSize(60, 60);
        f.setStyleJButonBack(jlSalir);
        f.setStyleJButon(btnActualizar1);
        f.setStyleJTable(tablaMed, jScrollPane2);
        f.setStyleJTable(TablaMedComprado, jScrollPane4);

    }

    private void CrearModelo() {

        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "ID",
                        "Medicamento",
                        "Titular",
                        "Descripcion",
                        "Principio Activo",
                        "Presentacion"}) {

                Class[] types = new Class[]{
                    java.lang.Short.class,
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

            modelo1 = (new DefaultTableModel(
                    null, new String[]{
                        "ID",
                        "Medicamento",
                        "Cantidad Comprada",
                        "Precio Unitario + IVA"}) {
                Class[] types = new Class[]{
                    java.lang.Short.class,
                    java.lang.String.class,
                    java.lang.Short.class,
                    java.lang.Integer.class
                };
                boolean[] canEdit = new boolean[]{
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
        Medicamentoinvima mi = new Medicamentoinvima(
                Short.parseShort("0"),
                txtMed.getText(),
                txtTitular.getText(),
                txtDescripcion.getText(),
                txtPresentacion.getText(), txtPrinAct.getText());
        Medicamento m = new Medicamento();
        m.setIdmedicamentoinvima(mi);
        List<Medicamento> listaClientes = comprarMedicamento.filtrarMedicamentos(m);
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamento(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getNombremedicamento(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getTitular(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getDescripcion(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPrincipioactivo(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPresentacion(), i, 5);
        }
    }

    private void cargar() {

        List<Medicamento> listaClientes = comprarMedicamento.obtenerTodosMedicamentos();
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamento(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getNombremedicamento(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getTitular(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getDescripcion(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPrincipioactivo(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPresentacion(), i, 5);
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
        jlNombre = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPresentacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProv = new javax.swing.JTextField();
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
        btnComprar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

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
        jLabel3.setText("Proveedor");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 202, -1, -1));

        txtProv.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtProv.setPreferredSize(new java.awt.Dimension(300, 30));
        txtProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProvFocusLost(evt);
            }
        });
        txtProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProvKeyTyped(evt);
            }
        });
        add(txtProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 202, 250, -1));

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
        tablaMed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaMedFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tablaMedFocusLost(evt);
            }
        });
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
        TablaMedComprado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaMedCompradoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TablaMedCompradoFocusLost(evt);
            }
        });
        TablaMedComprado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMedCompradoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaMedComprado);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 800, 130));

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, -1, -1));

        btnComprar.setText("jButton1");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 770, 150, 30));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setText("jButton2");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 770, -1, -1));
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

    private void txtProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvKeyTyped

    }//GEN-LAST:event_txtProvKeyTyped

    private void txtProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProvFocusLost
        if (!txtProv.getText().equals("")) {
            if (!comprarMedicamento.validarProveedor(txtProv.getText())) {
                JOptionPane.showMessageDialog(null,
                        "El Proveedor Debe Tener Entre 5 y 32 Caracteres",
                        "Longitud Proveedor No Válido",
                        JOptionPane.ERROR_MESSAGE);
                txtProv.setBackground(f.fondoTxtError);

            }
        }
    }//GEN-LAST:event_txtProvFocusLost

    private void txtProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProvFocusGained
        if (txtProv.getBackground().equals(f.fondoTxtError)) {
            txtProv.setBackground(f.fondoTxt);
            txtProv.setText("");
        }
    }//GEN-LAST:event_txtProvFocusGained

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


    private void tablaMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedMouseClicked

    }//GEN-LAST:event_tablaMedMouseClicked

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed

        int[] seleccionar = tablaMed.getSelectedRows();
        Object object[] = null;
        if (seleccionar.length == 0) {
            JOptionPane.showMessageDialog(null,
                    "No Hay nungun Medicamento Seleccionado\n Por Favor Seleccione Un Medicamento",
                    "Ninguna Seleccion",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < seleccionar.length; i++) {
                boolean esta = false;
                for (int j = 0; j < TablaMedComprado.getRowCount(); j++) {
                    if (tablaMed.getValueAt(seleccionar[i], 0) == TablaMedComprado.getValueAt(j, 0)) {
                        esta = true;
                        JOptionPane.showMessageDialog(null, tablaMed.getValueAt(seleccionar[i], 1) + " Ya Esta Agregado",
                                "Medicamento Ya Agregado",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if (!esta) {
                    int rows = TablaMedComprado.getRowCount();
                    modelo1.addRow(object);
                    modelo1.setValueAt(tablaMed.getValueAt(seleccionar[i], 0), rows, 0);
                    modelo1.setValueAt(tablaMed.getValueAt(seleccionar[i], 1), rows, 1);
                    modelo1.setValueAt(Short.valueOf("0"), rows, 2);
                    modelo1.setValueAt(0, rows, 3);
                }
            }
        }
        tablaMed.clearSelection();
    }//GEN-LAST:event_AgregarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed

        TablaMedComprado.editCellAt(-1, -1);
        boolean hacer = true;

        for (int i = 0; i < TablaMedComprado.getRowCount(); i++) {
            for (int j = 0; j < TablaMedComprado.getColumnCount(); j++) {
                if (((Short) TablaMedComprado.getValueAt(i, 2) <= 0
                        || (int) TablaMedComprado.getValueAt(i, 3) <= 0)
                        || txtProv.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "El Precio Y La Cantidad No Pueden Ser Menores O Iguales A Cero "
                            + "\n El Provedor Debe Estar Diligenciado",
                            "Datos Incorrectos",
                            JOptionPane.ERROR_MESSAGE);
                    hacer = false;
                    break;
                }
            }
            if (!hacer) {
                break;
            }
        }
        if (hacer) {
            ArrayList<Short> cantidad = new ArrayList<>();
            ArrayList<Short> ID = new ArrayList<>();
            ArrayList<Integer> precioUnit = new ArrayList<>();
            for (int i = 0; i < TablaMedComprado.getRowCount(); i++) {
                for (int j = 0; j < TablaMedComprado.getColumnCount(); j++) {
                    if (j == 0) {
                        ID.add((Short) TablaMedComprado.getValueAt(i, j));
                    }
                    if (j == 2) {
                        cantidad.add((Short) TablaMedComprado.getValueAt(i, j));
                    }
                    if (j == 3) {
                        Long aux = Long.parseLong(String.valueOf((Integer) TablaMedComprado.getValueAt(i, j)));
                        precioUnit.add((Integer) TablaMedComprado.getValueAt(i, j));
                        PrecioTotal = PrecioTotal + aux;
                    }
                    Compramedicamento c = new Compramedicamento(
                            (Integer) TablaMedComprado.getValueAt(i, 3),
                            (Short) TablaMedComprado.getValueAt(i, 2));
                    compras.add(c);
                }

            }
            if (comprarMedicamento.comprar(cantidad, ID)) {
                Date date = new Date(System.currentTimeMillis());
                Compra c = new Compra(txtProv.getText(), PrecioTotal, date);
                int IDCompra = comprarMedicamento.registroCompra(c);
                for (int i = 0; i < ID.size(); i++) {
                    CompramedicamentoPK PK = new CompramedicamentoPK(ID.get(i), IDCompra);
                    Compramedicamento cm = new Compramedicamento(PK);
                    cm.setCantidad(cantidad.get(i));
                    cm.setPreciounitario(precioUnit.get(i));
                    comprarMedicamento.registroCompraMed(cm);
                }
                JLabel lb = new JLabel();
                lb.setSize(50, 50);
                JOptionPane.showMessageDialog(null,
                        "La Compra Se Ha Registrado Satisfactoriamente",
                        "Compra Exitosa",
                        JOptionPane.OK_OPTION,
                        f.setImageBackground("/recursos/exito.png", lb)
                );
                TablaMedComprado.clearSelection();
            } else {
                JOptionPane.showMessageDialog(null,
                        "La Lista Esta Vacia, Por Favor Agregue Algun Medicamento",
                        "Lista Vacia",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int[] eliminar = TablaMedComprado.getSelectedRows();
        int cofirmacion;
        TablaMedComprado.editCellAt(-1, -1);
        if (TablaMedComprado.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,
                    "No Hay Medicamentos En La Tabla\n Por Favor Agregue Un Medicamento",
                    "Ninguna Seleccion",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            if (eliminar.length == 0) {
                cofirmacion = JOptionPane.showConfirmDialog(null,
                        "¿Desea Borrar Todos Los Elementos?",
                        "Borrar Lista",
                        JOptionPane.YES_NO_OPTION);
                if (cofirmacion == JOptionPane.YES_OPTION) {
                    while (modelo1.getRowCount() > 0) {
                        modelo1.removeRow(0);
                    }
                }
            } else {
                cofirmacion = JOptionPane.showConfirmDialog(null,
                        "¿Desea Borrar Los Elementos Seleccionados?",
                        "Borrar Lista Seleccionada",
                        JOptionPane.YES_NO_OPTION);
                if (cofirmacion == JOptionPane.YES_OPTION) {
                    for (int i = eliminar.length - 1; i >= 0; i--) {
                        modelo1.removeRow(eliminar[i]);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedFocusLost


    }//GEN-LAST:event_tablaMedFocusLost

    private void TablaMedCompradoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaMedCompradoFocusLost


    }//GEN-LAST:event_TablaMedCompradoFocusLost

    private void tablaMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedFocusGained


    }//GEN-LAST:event_tablaMedFocusGained

    private void TablaMedCompradoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaMedCompradoFocusGained

    }//GEN-LAST:event_TablaMedCompradoFocusGained

    private void TablaMedCompradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMedCompradoMouseClicked
        if (evt.getClickCount() == 1) {
            int valor = 0;
            for (int i = 0; i < TablaMedComprado.getRowCount(); i++) {
                Object f = TablaMedComprado.getValueAt(i, 1);
                if ((Integer) TablaMedComprado.getValueAt(i, 3) != null) {
                    valor = valor + (Integer) TablaMedComprado.getValueAt(i, 3);
                }
            }
            btnComprar.setText(String.valueOf(valor) + " $$$");
        }
    }//GEN-LAST:event_TablaMedCompradoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTable TablaMedComprado;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTable tablaMed;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMed;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtPrinAct;
    private javax.swing.JTextField txtProv;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
