package Frontera;

import Control.AgregarMedicamento;
import Entidad.Compramedicamento;
import Entidad.Empleado;
import Entidad.Medicamento;
import Entidad.Medicamentoinvima;
import DAO.MedicamentoDAO;
import Recursos.Funciones;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FronteraAgregarMed extends javax.swing.JPanel {

    Funciones f = new Funciones();
    ArrayList<Compramedicamento> compras = new ArrayList<>();
    Long PrecioTotal = Long.valueOf("0");
    DefaultTableModel modelo, modelo1;
    AgregarMedicamento agregarMedicamento = new AgregarMedicamento();
    MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    public FronteraAgregarMed() {
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
            jlNombre.setText(em.getNombreempleado() + " " + em.getApellidoempleado());
        }
    }

    public void allSetEmpty() {
        txtDescripcion.setText("");
        txtTitular.setText("");
        txtMed.setText("");
        txtPresentacion.setText("");
        txtPrinAct.setText("");
        txtTitular.setText("");
        f.setStyleJTextField(txtTitular);
        f.setStyleJTextField(txtMed);
        f.setStyleJTextField(txtPresentacion);
        f.setStyleJTextField(txtPrinAct);
        f.setStyleJTextField(txtTitular);
        f.setStyleJTextArea(txtDescripcion, ScrollDes);
        jlSalir.setSize(60, 60);
        f.setStyleJButonBack(jlSalir);
        f.setStyleJButon(btnCerrarSesion);
        f.setStyleJButon(btnBorrar);
        f.setStyleJButon(btnRegistrar);
        f.setStyleJButon(btnAgregar);
        f.setStyleJTable(tablaMed, ScrollTablaMed);
        f.setStyleJTable(tablaMedSelec, ScrollMedComprado);
        f.setStyleJLabel(jlMed);
        f.setStyleJLabel(jlMedSel);

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
                        "Precio De Venta"
                    }) {
                Class[] types = new Class[]{
                    java.lang.Short.class,
                    java.lang.String.class,
                    java.lang.Integer.class
                };
                boolean[] canEdit = new boolean[]{
                    false,
                    false,
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
            tablaMedSelec.setModel(modelo1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    private void search() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Medicamentoinvima mi = new Medicamentoinvima(
                txtMed.getText(),
                txtTitular.getText(),
                txtDescripcion.getText(),
                txtPresentacion.getText(),
                txtPrinAct.getText());
        Medicamento m = new Medicamento();
        m.setIdmedicamentoinvima(mi);
        List<Medicamentoinvima> listaClientes = agregarMedicamento.leerTodos(mi);
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getNombremedicamento(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getTitular(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getDescripcion(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getPrincipioactivo(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getPresentacion(), i, 5);
        }
    }

    private void cargar() {

        List<Medicamentoinvima> listaClientes = agregarMedicamento.leerTodos();
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getNombremedicamento(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getTitular(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getDescripcion(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getPrincipioactivo(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getPresentacion(), i, 5);
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
        btnCerrarSesion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMed = new javax.swing.JTextField();
        txtPrinAct = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        ScrollTablaMed = new javax.swing.JScrollPane();
        tablaMed = new javax.swing.JTable();
        ScrollDes = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        ScrollMedComprado = new javax.swing.JScrollPane();
        tablaMedSelec = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlMedSel = new javax.swing.JLabel();
        jlMed = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 1000));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));
        add(jlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 11, -1, -1));

        jlSalir.setPreferredSize(new java.awt.Dimension(60, 60));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlSalirMouseReleased(evt);
            }
        });
        add(jlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 22)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1020, 20));

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));
        add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 52, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo de Presentacion");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, -1, -1));

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
        add(txtPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Descripción");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, -1));

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
        add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 251, 160, 29));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Medicamento");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 318, -1, -1));

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
        add(txtMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 317, -1, -1));

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
        add(txtPrinAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Principio Activo");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("TItular");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setPreferredSize(new java.awt.Dimension(170, 30));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 366, -1, -1));

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
        add(txtTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 366, -1, -1));

        ScrollTablaMed.setPreferredSize(new java.awt.Dimension(880, 150));

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
        tablaMed.setPreferredSize(new java.awt.Dimension(800, 10000));
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
        ScrollTablaMed.setViewportView(tablaMed);

        add(ScrollTablaMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 559, -1, -1));

        ScrollDes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollDes.setPreferredSize(new java.awt.Dimension(250, 114));

        txtDescripcion.setColumns(1);
        txtDescripcion.setRows(1);
        txtDescripcion.setTabSize(1);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        ScrollDes.setViewportView(txtDescripcion);

        add(ScrollDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, -1, -1));

        ScrollMedComprado.setPreferredSize(new java.awt.Dimension(780, 150));
        ScrollMedComprado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ScrollMedCompradoFocusLost(evt);
            }
        });
        ScrollMedComprado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScrollMedCompradoMouseExited(evt);
            }
        });

        tablaMedSelec.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMedSelec.setPreferredSize(new java.awt.Dimension(780, 10000));
        tablaMedSelec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaMedSelecFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tablaMedSelecFocusLost(evt);
            }
        });
        tablaMedSelec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMedSelecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaMedSelecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tablaMedSelecMouseExited(evt);
            }
        });
        ScrollMedComprado.setViewportView(tablaMedSelec);

        add(ScrollMedComprado, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 800, -1, -1));

        btnAgregar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 727, -1, -1));

        btnRegistrar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 961, -1, -1));

        btnBorrar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("Borrar");
        btnBorrar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 961, -1, -1));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Medicamentos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 11, 330, 30));

        jlMedSel.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlMedSel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMedSel.setText("Listado de Medicamentos Seleccionados");
        jlMedSel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlMedSel.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlMedSel, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 768, 780, 30));

        jlMed.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlMed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMed.setText("Listado de Medicamentos ");
        jlMed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlMed.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jlMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 523, 880, 30));
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Salir?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
            allSetEmpty();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

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
                for (int j = 0; j < tablaMedSelec.getRowCount(); j++) {
                    if (tablaMed.getValueAt(seleccionar[i], 0) == tablaMedSelec.getValueAt(j, 0)) {
                        esta = true;
                        break;
                    }
                }
                if (!esta) {
                    int rows = tablaMedSelec.getRowCount();
                    modelo1.addRow(object);
                    modelo1.setValueAt(tablaMed.getValueAt(seleccionar[i], 0), rows, 0);
                    modelo1.setValueAt(tablaMed.getValueAt(seleccionar[i], 1), rows, 1);
                    modelo1.setValueAt(0, rows, 2);
                }
            }
        }
        tablaMed.clearSelection();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        for (int i = 0; i < tablaMedSelec.getRowCount(); i++) {
            if (agregarMedicamento.validarPrecioventa((Integer) tablaMedSelec.getValueAt(i, 2)).equals("Precio fuera de rango")) {
                JOptionPane.showMessageDialog(null,
                        "el precio de" + (String) tablaMedSelec.getValueAt(i, 1) + " debe estar entre 100 y 10.000.000 de pesos",
                        "recio fuera de rango",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Medicamentoinvima medicamentoinvima = agregarMedicamento.leerMed(String.valueOf((Short) tablaMedSelec.getValueAt(i, 0)));
                Medicamento medicamento = new Medicamento(Short.valueOf("0"));
                medicamento.setIdmedicamentoinvima(medicamentoinvima);
                switch (agregarMedicamento.validarDatos(medicamento)) {
                    case "Medicamento ya agregado":
                        JOptionPane.showMessageDialog(null,
                                (String) tablaMedSelec.getValueAt(i, 1) + " Ya Esta Regitrado",
                                "Medicamento ya agregado",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    case "Medicamento restaurado": {
                        JLabel lb = new JLabel();
                        lb.setSize(50, 50);
                        JOptionPane.showMessageDialog(null,
                                (String) tablaMedSelec.getValueAt(i, 1) + " Ha Sido Restaurado",
                                "Medicamento restauradoo",
                                JOptionPane.OK_OPTION,
                                f.setImageBackground("/recursos/exito.png", lb));
                        break;
                    }
                    case "Error al restaurar medicamento":
                        JOptionPane.showMessageDialog(null,
                                (String) tablaMedSelec.getValueAt(i, 1) + " No Se Ha Podido Restaurar",
                                "Medicamento ya agregado",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    case "Medicamento agregado exitosamente": {
                        JLabel lb = new JLabel();
                        lb.setSize(50, 50);
                        JOptionPane.showMessageDialog(null,
                                (String) tablaMedSelec.getValueAt(i, 1) + " Ha Sido Agregado Exitosamente",
                                "Medicamento restauradoo",
                                JOptionPane.OK_OPTION,
                                f.setImageBackground("/recursos/exito.png", lb));
                        break;
                    }
                    default:
                        break;
                }
            }
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int[] eliminar = tablaMedSelec.getSelectedRows();
        int cofirmacion;
        tablaMedSelec.editCellAt(-1, -1);
        if (tablaMedSelec.getRowCount() == 0) {
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
            PrecioTotal = Long.valueOf("0");
            btnRegistrar.setText("$ Comprar");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tablaMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedFocusLost


    }//GEN-LAST:event_tablaMedFocusLost

    private void tablaMedSelecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedSelecFocusLost


    }//GEN-LAST:event_tablaMedSelecFocusLost

    private void tablaMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedFocusGained


    }//GEN-LAST:event_tablaMedFocusGained

    private void tablaMedSelecFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedSelecFocusGained

    }//GEN-LAST:event_tablaMedSelecFocusGained

    private void tablaMedSelecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedSelecMouseClicked

    }//GEN-LAST:event_tablaMedSelecMouseClicked

    private void tablaMedSelecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedSelecMouseEntered

    }//GEN-LAST:event_tablaMedSelecMouseEntered

    private void tablaMedSelecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedSelecMouseExited

    }//GEN-LAST:event_tablaMedSelecMouseExited

    private void ScrollMedCompradoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ScrollMedCompradoFocusLost

    }//GEN-LAST:event_ScrollMedCompradoFocusLost

    private void ScrollMedCompradoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrollMedCompradoMouseExited

    }//GEN-LAST:event_ScrollMedCompradoMouseExited

    private void jlSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMouseReleased
        App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenu);
    }//GEN-LAST:event_jlSalirMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollDes;
    private javax.swing.JScrollPane ScrollMedComprado;
    private javax.swing.JScrollPane ScrollTablaMed;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlMed;
    private javax.swing.JLabel jlMedSel;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTable tablaMed;
    private javax.swing.JTable tablaMedSelec;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMed;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtPrinAct;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
