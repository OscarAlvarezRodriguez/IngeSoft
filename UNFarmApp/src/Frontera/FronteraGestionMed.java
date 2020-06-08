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

public class FronteraGestionMed extends javax.swing.JPanel {

    Funciones f = new Funciones();
    DefaultTableModel modelo;
    MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    public FronteraGestionMed() {
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
        f.setStyleJTable(tablaMed, jScrollPane2);
        f.setStyleJLabel(jlTitulo1);
        f.setStyleJButon(btnEliminar);
        f.setStyleJButon(btnAgregar);
        f.setStyleJButon(btnEditar);
        f.setStyleJButon(btnCerrarSesion);
        jlSalir.setSize(60, 60);
        f.setStyleJButonBack(jlSalir);

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
            tablaMed.setModel(modelo);
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
        List<Medicamento> listaClientes = medicamentoDAO.leertodo(m);
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getNombremedicamento(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getTitular(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getDescripcion(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPrincipioactivo(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPresentacion(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getStock(), i, 5);
            modelo.setValueAt(listaClientes.get(i).getPrecioventa(), i, 6);
        }
    }

    private void cargar() {

        List<Medicamento> listaClientes = medicamentoDAO.leertodo();
        Object object[] = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            modelo.addRow(object);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getNombremedicamento(), i, 0);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getTitular(), i, 1);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getDescripcion(), i, 2);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPrincipioactivo(), i, 3);
            modelo.setValueAt(listaClientes.get(i).getIdmedicamentoinvima().getPresentacion(), i, 4);
            modelo.setValueAt(listaClientes.get(i).getStock(), i, 5);
            modelo.setValueAt(listaClientes.get(i).getPrecioventa(), i, 6);
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
        txtPresentacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
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
        jlNombre = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 750));

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));

        jlSalir.setPreferredSize(new java.awt.Dimension(60, 60));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlSalirMouseReleased(evt);
            }
        });

        jlTitulo1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setText("Listado de Medicamentos Registrados");
        jlTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlTitulo1.setPreferredSize(new java.awt.Dimension(300, 50));

        jlUsuario.setPreferredSize(new java.awt.Dimension(150, 150));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo de Presentacion");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new java.awt.Dimension(170, 30));

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

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Descripción");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setPreferredSize(new java.awt.Dimension(170, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cliente");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setPreferredSize(new java.awt.Dimension(170, 30));

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

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Medicamento");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 30));

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

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Principio Activo");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new java.awt.Dimension(170, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("TItular");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setPreferredSize(new java.awt.Dimension(170, 30));

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
        jScrollPane2.setViewportView(tablaMed);

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

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 22)); // NOI18N
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

        btnAgregar.setBackground(new java.awt.Color(0, 158, 15));
        btnAgregar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnAgregar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Medicamentos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrinAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jlTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPrinAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jlTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusGained
        if (txtPresentacion.getBackground().equals(f.fondoTxtError)) {
            txtPresentacion.setBackground(f.fondoTxt);
            txtPresentacion.setText("");
        }
    }//GEN-LAST:event_txtPresentacionFocusGained

    private void txtPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusLost

    }//GEN-LAST:event_txtPresentacionFocusLost

    private void txtPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != 32) {
            evt.consume();
        }


    }//GEN-LAST:event_txtPresentacionKeyTyped

    private void txtClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteFocusGained

    private void txtClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteFocusLost

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped

    }//GEN-LAST:event_txtClienteKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedFocusGained

    private void txtMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedFocusLost

    private void txtMedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedKeyTyped

    }//GEN-LAST:event_txtMedKeyTyped

    private void txtPrinActFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrinActFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrinActFocusGained

    private void txtPrinActFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrinActFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrinActFocusLost

    private void txtPrinActKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrinActKeyTyped

    }//GEN-LAST:event_txtPrinActKeyTyped

    private void txtTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitularKeyTyped

    }//GEN-LAST:event_txtTitularKeyTyped

    private void txtTitularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitularFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitularFocusLost

    private void txtTitularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitularFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitularFocusGained

    private void txtPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyPressed

    }//GEN-LAST:event_txtPresentacionKeyPressed

    private void txtPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyReleased
        search();
    }//GEN-LAST:event_txtPresentacionKeyReleased

    private void txtMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedKeyReleased
        search();
    }//GEN-LAST:event_txtMedKeyReleased

    private void txtPrinActKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrinActKeyReleased
        search();
    }//GEN-LAST:event_txtPrinActKeyReleased

    private void txtTitularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitularKeyReleased
        search();
    }//GEN-LAST:event_txtTitularKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        search();
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Salir?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraAutEmpleado);
            allSetEmpty();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jlSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMouseReleased
         App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenu);
    }//GEN-LAST:event_jlSalirMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
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
    private javax.swing.JTable tablaMed;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMed;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtPrinAct;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
