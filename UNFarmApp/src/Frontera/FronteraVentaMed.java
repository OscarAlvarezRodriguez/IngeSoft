package Frontera;

import Control.VenderMed;
import Entidad.Cliente;
import Entidad.Compramedicamento;
import Entidad.Empleado;
import Entidad.Factura;
import Entidad.Facturamedicamentos;
import Entidad.FacturamedicamentosPK;
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

public class FronteraVentaMed extends javax.swing.JPanel {

    Funciones f = new Funciones();
    ArrayList<Compramedicamento> compras = new ArrayList<>();
    Long PrecioTotal = Long.valueOf("0");
    DefaultTableModel modelo, modelo1;
    VenderMed venderMed = new VenderMed();
    Empleado empleado;
    Cliente globClient;

    public FronteraVentaMed() {
        initComponents();
        allSetEmpty();
        CrearModelo();
        cargar();

        jlLogo.setSize(100, 100);
        jlLogo.setIcon(f.setImageBackground("/Recursos/logo.png", jlLogo));

        jlUsuario.setSize(150, 150);
        jlUsuario.setIcon(f.setImageBackground("/Recursos/usuario.png", jlUsuario));

    }

    public void setNombreUsuario(Empleado em, Cliente client) {

        if (em != null && client != null) {
            empleado = em;

            jlNombre.setText(em.getNombreempleado() + " " + em.getApellidoempleado());
            txtCliente.setText(client.getNombre() + " " + client.getApellido());
            txtCliente.setEditable(false);
            empleado = em;
            globClient = client;
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
        f.setStyleJTextArea(txtDescripcion, ScrollDes);
        jlSalir.setSize(60, 60);
        f.setStyleJButonBack(jlSalir);
        f.setStyleJButon(btnCerrarSesion);
        f.setStyleJButon(btnBorrar);
        f.setStyleJButon(btnComprar);
        f.setStyleJButon(btnAgregar);
        f.setStyleJTable(tablaMed, ScrollTablaMed);
        f.setStyleJTable(TablaMedVendido, ScrollMedComprado);
        f.setStyleJLabelBig(jlMed);
        f.setStyleJLabelBig(jlMedSel);
        try {
            if (TablaMedVendido.getRowCount() > 0) {
                while (TablaMedVendido.getRowCount() > 0) {
                    modelo1.removeRow(0);
                }
                TablaMedVendido.setPreferredSize(new java.awt.Dimension(TablaMedVendido.getWidth(),
                        TablaMedVendido.getRowCount() * TablaMedVendido.getRowHeight()));
                TablaMedVendido.repaint();
                TablaMedVendido.revalidate();
            }
        } catch (Exception e) {
        }

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
                        "Cantidad Vendida",
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
            TablaMedVendido.setModel(modelo1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    public void search() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Medicamentoinvima mi = new Medicamentoinvima(
                txtMed.getText(),
                txtTitular.getText(),
                txtDescripcion.getText(),
                txtPresentacion.getText(), txtPrinAct.getText());
        Medicamento m = new Medicamento();
        m.setIdmedicamentoinvima(mi);
        List<Medicamento> listaClientes = venderMed.filtrarMedicamentos(m);
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
        tablaMed.setPreferredSize(new java.awt.Dimension(tablaMed.getWidth(),
                tablaMed.getRowCount() * tablaMed.getRowHeight()));
        tablaMed.repaint();
        tablaMed.revalidate();
    }

    private void cargar() {

        List<Medicamento> listaClientes = venderMed.obtenerTodosMedicamentos();
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
        jlNombre = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPresentacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
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
        TablaMedVendido = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlMedSel = new javax.swing.JLabel();
        jlMed = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1030, 1000));

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));

        jlSalir.setPreferredSize(new java.awt.Dimension(60, 60));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlSalirMouseReleased(evt);
            }
        });

        jlNombre.setFont(new java.awt.Font("Leelawadee", 0, 22)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("\"Nombre de Usuario Actual\"");
        jlNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlNombre.setPreferredSize(new java.awt.Dimension(300, 50));

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
        tablaMed.setPreferredSize(new java.awt.Dimension(800, 100));
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

        TablaMedVendido.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaMedVendido.setPreferredSize(new java.awt.Dimension(780, 100));
        TablaMedVendido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaMedVendidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TablaMedVendidoFocusLost(evt);
            }
        });
        TablaMedVendido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMedVendidoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablaMedVendidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TablaMedVendidoMouseExited(evt);
            }
        });
        ScrollMedComprado.setViewportView(TablaMedVendido);

        btnAgregar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnComprar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("$ Vender");
        btnComprar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("Borrar");
        btnBorrar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vender Medicamentos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));

        jlMedSel.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlMedSel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMedSel.setText("Listado de Medicamentos Seleccionados");
        jlMedSel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlMedSel.setPreferredSize(new java.awt.Dimension(300, 50));

        jlMed.setFont(new java.awt.Font("Leelawadee", 0, 28)); // NOI18N
        jlMed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMed.setText("Listado de Medicamentos ");
        jlMed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlMed.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrinAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(ScrollDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jlMed, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(ScrollTablaMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jlMedSel, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(ScrollMedComprado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtPrinAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jlMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(ScrollTablaMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlMedSel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(ScrollMedComprado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
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

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped

    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusLost

    }//GEN-LAST:event_txtClienteFocusLost

    private void txtClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusGained
        if (txtCliente.getBackground().equals(f.fondoTxtError)) {
            txtCliente.setBackground(f.fondoTxt);
            txtCliente.setText("");
        }
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


    private void tablaMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedMouseClicked

    }//GEN-LAST:event_tablaMedMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int[] seleccionar = tablaMed.getSelectedRows();
        Object object[] = null;
        if (seleccionar.length == 0) {
            JOptionPane.showMessageDialog(null,
                    "No Hay ningún Medicamento Seleccionado\n Por Favor Seleccione Un Medicamento",
                    "Ninguna Seleccion",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < seleccionar.length; i++) {
                boolean esta = false;
                for (int j = 0; j < TablaMedVendido.getRowCount(); j++) {
                    if (tablaMed.getValueAt(seleccionar[i], 0) == TablaMedVendido.getValueAt(j, 0)) {
                        esta = true;
                        JOptionPane.showMessageDialog(null, tablaMed.getValueAt(seleccionar[i], 1) + " Ya Esta Agregado",
                                "Medicamento Ya Agregado",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if (!esta) {
                    int rows = TablaMedVendido.getRowCount();
                    modelo1.addRow(object);
                    modelo1.setValueAt(tablaMed.getValueAt(seleccionar[i], 0), rows, 0);
                    modelo1.setValueAt(tablaMed.getValueAt(seleccionar[i], 1), rows, 1);
                    modelo1.setValueAt(Short.valueOf("0"), rows, 2);
                    modelo1.setValueAt(venderMed.obtenerMed((Short) tablaMed.getValueAt(seleccionar[i], 0)).getPrecioventa(), rows, 3);
                }
            }
            TablaMedVendido.setPreferredSize(new java.awt.Dimension(TablaMedVendido.getWidth(),
                    TablaMedVendido.getRowCount() * TablaMedVendido.getRowHeight()));
            TablaMedVendido.repaint();
            TablaMedVendido.revalidate();
        }
        tablaMed.clearSelection();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        TablaMedVendido.editCellAt(-1, -1);
        TablaMedVendido.clearSelection();
        final String ci = "Cantidad del medicamento no permitida";
        final String si = "La compra excede el límite del precio";
        final String co = "Correcto";
        final String fg = "Factura Generada Exitosamente";
        final String ca = "La cantidad solicitada es superior al inventario disponible";
        long precio = 0;
        boolean hacer = true;

        for (int i = 0;
                i < TablaMedVendido.getRowCount();
                i++) {
            if (TablaMedVendido.getValueAt(i, 2) == null) {
                JOptionPane.showMessageDialog(null,
                        "Algun Espacio Esta Vacio, Por Favor Diligrncie Todos Los Campos",
                        "Campos Vacios",
                        JOptionPane.ERROR_MESSAGE);
                hacer = false;
                break;
            } else {
                precio = precio + (Integer) TablaMedVendido.getValueAt(i, 3);
                Factura factura = new Factura();
                factura.setPreciototal(precio);
                Facturamedicamentos facturamedicamentos = new Facturamedicamentos();
                facturamedicamentos.setCantidadvendida((short) TablaMedVendido.getValueAt(i, 2));
                String validar = venderMed.validarDatos(factura,
                        facturamedicamentos,
                        (short) TablaMedVendido.getValueAt(i, 0));
                switch (validar) {
                    case ci:
                        JOptionPane.showMessageDialog(null,
                                "La cantidad del medicamento debe estar entre 1 y 2000 unidades",
                                "Cantidad del medicamento no permitida",
                                JOptionPane.ERROR_MESSAGE);
                        hacer = false;
                        break;
                    case ca:
                        JOptionPane.showMessageDialog(null,
                                "La cantidad solicitada es superior al inventario disponible",
                                "Stock sobrepasado",
                                JOptionPane.ERROR_MESSAGE);
                        hacer = false;
                        break;
                    case si:
                        JOptionPane.showMessageDialog(null,
                                "El valor de la compra debe ser menor a 10.000.000 pesos",
                                "La compra excede el límite del precio",
                                JOptionPane.ERROR_MESSAGE);
                        hacer = false;
                        break;
                    default:
                        break;
                }

                if (!hacer) {
                    break;
                }
            }
        }
        if (hacer) {
            ArrayList<Short> cantidad = new ArrayList<>();
            ArrayList<Short> ID = new ArrayList<>();
            ArrayList<Integer> precioUnit = new ArrayList<>();
            for (int i = 0; i < TablaMedVendido.getRowCount(); i++) {
                for (int j = 0; j < TablaMedVendido.getColumnCount(); j++) {
                    if (j == 0) {
                        ID.add((Short) TablaMedVendido.getValueAt(i, j));
                    }
                    if (j == 2) {
                        cantidad.add((Short) TablaMedVendido.getValueAt(i, j));
                    }
                    if (j == 3) {
                        Long aux = Long.parseLong(String.valueOf((Integer) TablaMedVendido.getValueAt(i, j)));
                        precioUnit.add((Integer) TablaMedVendido.getValueAt(i, j));
                        PrecioTotal = PrecioTotal + aux * (Short) TablaMedVendido.getValueAt(i, j - 1);
                    }
                    Compramedicamento c = new Compramedicamento(
                            (Integer) TablaMedVendido.getValueAt(i, 3),
                            (Short) TablaMedVendido.getValueAt(i, 2));
                    compras.add(c);
                }

            }
            if (venderMed.vender(cantidad, ID)) {
                Date date = new Date(System.currentTimeMillis());
                
                Factura c = new Factura(PrecioTotal, date);
                PrecioTotal = Long.valueOf("0");
                c.setCedulacliente(globClient);
                c.setCedulaempleado(empleado);
                c.setNitdrogueria(new DAO.DrogueriaDAO().leer());
                int IDCompra = venderMed.registrarFactura(c);
                for (int i = 0; i < ID.size(); i++) {
                    FacturamedicamentosPK PK = new FacturamedicamentosPK(ID.get(i), IDCompra);
                    Facturamedicamentos cm = new Facturamedicamentos(PK);
                    cm.setCantidadvendida(cantidad.get(i));
                    venderMed.RegistrarFacturaMed(cm);
                }
                
               
                while (modelo1.getRowCount() > 0) {
                    modelo1.removeRow(0);
                }
                TablaMedVendido.setPreferredSize(new java.awt.Dimension(TablaMedVendido.getWidth(),
                        TablaMedVendido.getRowCount() * TablaMedVendido.getRowHeight()));
                TablaMedVendido.repaint();
                TablaMedVendido.revalidate();
                TablaMedVendido.clearSelection();

                JLabel lb = new JLabel();
                lb.setSize(50, 50);
                JOptionPane.showMessageDialog(null,
                        "La Venta Se Ha Registrado Satisfactoriamente",
                        "Venta Exitosa",
                        JOptionPane.OK_OPTION,
                        f.setImageBackground("/recursos/exito.png", lb)
                );
                TablaMedVendido.clearSelection();
                venderMed.crearDomicilio(c);
            } else {
                JOptionPane.showMessageDialog(null,
                        "La Lista Esta Vacia, Por Favor Agregue Algun Medicamento",
                        "Lista Vacia",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int[] eliminar = TablaMedVendido.getSelectedRows();
        int cofirmacion;
        TablaMedVendido.editCellAt(-1, -1);
        if (TablaMedVendido.getRowCount() == 0) {
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
                    TablaMedVendido.setPreferredSize(new java.awt.Dimension(TablaMedVendido.getWidth(), 0));
                    TablaMedVendido.repaint();
                    TablaMedVendido.revalidate();
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
                    TablaMedVendido.setPreferredSize(new java.awt.Dimension(TablaMedVendido.getWidth(),
                            TablaMedVendido.getRowCount() * TablaMedVendido.getRowHeight()));
                    TablaMedVendido.repaint();
                    TablaMedVendido.revalidate();
                }
            }
            btnComprar.setText("$ Vender");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tablaMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedFocusLost


    }//GEN-LAST:event_tablaMedFocusLost

    private void TablaMedVendidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaMedVendidoFocusLost

        long valor = 0;
        for (int i = 0; i < TablaMedVendido.getRowCount(); i++) {
            if (TablaMedVendido.getValueAt(i, 3) != null && TablaMedVendido.getValueAt(i, 2) != null) {
                valor = valor + ((Integer) TablaMedVendido.getValueAt(i, 3) * (Short) TablaMedVendido.getValueAt(i, 2));
            }
        }
        btnComprar.setText("$ " + new DecimalFormat("##,###,###").format(valor));


    }//GEN-LAST:event_TablaMedVendidoFocusLost

    private void tablaMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaMedFocusGained


    }//GEN-LAST:event_tablaMedFocusGained

    private void TablaMedVendidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaMedVendidoFocusGained

        long valor = 0;
        for (int i = 0; i < TablaMedVendido.getRowCount(); i++) {
            if (TablaMedVendido.getValueAt(i, 3) != null && TablaMedVendido.getValueAt(i, 2) != null) {
                valor = valor + ((Integer) TablaMedVendido.getValueAt(i, 3) * (Short) TablaMedVendido.getValueAt(i, 2));
            }
        }
        btnComprar.setText("$ " + new DecimalFormat("##,###,###").format(valor));
    }//GEN-LAST:event_TablaMedVendidoFocusGained

    private void TablaMedVendidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMedVendidoMouseClicked
        if (evt.getClickCount() == 1) {
            long valor = 0;
            for (int i = 0; i < TablaMedVendido.getRowCount(); i++) {
                if (TablaMedVendido.getValueAt(i, 3) != null && TablaMedVendido.getValueAt(i, 2) != null) {
                    valor = valor + ((Integer) TablaMedVendido.getValueAt(i, 3) * (Short) TablaMedVendido.getValueAt(i, 2));
                }
            }
            btnComprar.setText("$ " + new DecimalFormat("##,###,###").format(valor));

        }

    }//GEN-LAST:event_TablaMedVendidoMouseClicked

    private void TablaMedVendidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMedVendidoMouseEntered

    }//GEN-LAST:event_TablaMedVendidoMouseEntered

    private void TablaMedVendidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMedVendidoMouseExited

        long valor = 0;
        for (int i = 0; i < TablaMedVendido.getRowCount(); i++) {
            if (TablaMedVendido.getValueAt(i, 3) != null && TablaMedVendido.getValueAt(i, 2) != null) {
                valor = valor + ((Integer) TablaMedVendido.getValueAt(i, 3) * (Short) TablaMedVendido.getValueAt(i, 2));
            }
        }
        btnComprar.setText("$ " + new DecimalFormat("##,###,###").format(valor));


    }//GEN-LAST:event_TablaMedVendidoMouseExited

    private void ScrollMedCompradoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ScrollMedCompradoFocusLost

    }//GEN-LAST:event_ScrollMedCompradoFocusLost

    private void ScrollMedCompradoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrollMedCompradoMouseExited

    }//GEN-LAST:event_ScrollMedCompradoMouseExited

    private void jlSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMouseReleased

        allSetEmpty();
        if (empleado.getEstado().equals("ADMINISTRADOR")) {
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenuAdministrador);
        } else {
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraMenuEmpleado);
        }
    }//GEN-LAST:event_jlSalirMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollDes;
    private javax.swing.JScrollPane ScrollMedComprado;
    private javax.swing.JScrollPane ScrollTablaMed;
    private javax.swing.JTable TablaMedVendido;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMed;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtPrinAct;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
