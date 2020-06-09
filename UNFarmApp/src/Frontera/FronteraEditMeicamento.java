package Frontera;

import Control.EditarMedicamento;
import Entidad.Medicamento;
import Recursos.Funciones;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FronteraEditMeicamento extends javax.swing.JPanel {

    Funciones f = new Funciones();
    Medicamento medicamento = new Medicamento();
    EditarMedicamento editarMedicamento = new EditarMedicamento();

    public FronteraEditMeicamento() {
        initComponents();
        allSetEmpty();
        jlLogo.setSize(100, 100);
        jlLogo.setIcon(f.setImageBackground("/Recursos/logo.png", jlLogo));
        jlKit.setSize(100, 100);
        jlKit.setIcon(f.setImageBackground("/Recursos/medicamento.png", jlKit));
        f.setStyleJButon(btnCancelar);
        f.setStyleJButon(btnActualizar);

    }

    private void allSetEmpty() {

        txtDescripcion.setText("");
        txtMed.setText("");
        txtPrecio.setText("");
        txtPresentacion.setText("");
        txtPrinAct.setText("");
        txtStock.setText("");
        txtTitular.setText("");
        f.setStyleJTextField(txtMed);
        f.setStyleJTextField(txtPrecio);
        f.setStyleJTextField(txtPresentacion);
        f.setStyleJTextField(txtPrinAct);
        f.setStyleJTextField(txtStock);
        f.setStyleJTextField(txtTitular);
        f.setStyleJTextArea(txtDescripcion, jScrollPane1);

    }

    public boolean Init(Medicamento m) {
        if (m != null) {
            this.medicamento = m;
            txtDescripcion.setEditable(false);
            txtMed.setEditable(false);
            txtPresentacion.setEditable(false);
            txtPrinAct.setEditable(false);
            txtTitular.setEditable(false);
            txtDescripcion.setText(m.getIdmedicamentoinvima().getDescripcion());
            txtMed.setText(m.getIdmedicamentoinvima().getNombremedicamento());
            txtPresentacion.setText(m.getIdmedicamentoinvima().getPresentacion());
            txtPrinAct.setText(m.getIdmedicamentoinvima().getPrincipioactivo());
            txtTitular.setText(m.getIdmedicamentoinvima().getTitular());
            txtStock.setText(String.valueOf(m.getStock()));
            txtPrecio.setText(String.valueOf(m.getPrecioventa()));
            return true;
        } else {
            return false;
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
        jlKit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtMed = new javax.swing.JTextField();
        txtPrinAct = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        txtPresentacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1030, 550));

        jlLogo.setPreferredSize(new java.awt.Dimension(100, 100));

        jlKit.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 34)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar Medicamento");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 158, 15));
        btnActualizar.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(150, 40));
        btnActualizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Descripción");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setPreferredSize(new java.awt.Dimension(240, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(570, 120));

        txtDescripcion.setColumns(1);
        txtDescripcion.setRows(1);
        txtDescripcion.setTabSize(1);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Medicamento");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setPreferredSize(new java.awt.Dimension(240, 30));

        txtMed.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtMed.setPreferredSize(new java.awt.Dimension(570, 30));
        txtMed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMedFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMedFocusLost(evt);
            }
        });
        txtMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedActionPerformed(evt);
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
        txtPrinAct.setPreferredSize(new java.awt.Dimension(570, 30));
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
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Principio Activo");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setPreferredSize(new java.awt.Dimension(240, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("TItular");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setPreferredSize(new java.awt.Dimension(240, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo de Presentacion");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setPreferredSize(new java.awt.Dimension(240, 30));

        txtTitular.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtTitular.setPreferredSize(new java.awt.Dimension(570, 30));
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

        txtPresentacion.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtPresentacion.setPreferredSize(new java.awt.Dimension(570, 30));
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

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Stock");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel9.setPreferredSize(new java.awt.Dimension(240, 30));

        txtStock.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtStock.setPreferredSize(new java.awt.Dimension(570, 30));
        txtStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStockFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockFocusLost(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Precio De Venta");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel10.setPreferredSize(new java.awt.Dimension(240, 30));

        txtPrecio.setFont(new java.awt.Font("Leelawadee", 0, 20)); // NOI18N
        txtPrecio.setPreferredSize(new java.awt.Dimension(570, 30));
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioFocusLost(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(514, 514, 514)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrinAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPrinAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        allSetEmpty();
        App.getInstance().ChangePanel(FramePrincipal.INTFronteraGestionMed);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Medicamento medNuevo = medicamento;
        medNuevo.setPrecioventa(Integer.valueOf(txtPrecio.getText()));
        medNuevo.setStock(Short.parseShort(txtStock.getText()));

        if (editarMedicamento.validarDatos(medicamento, medNuevo).equals("Medicamento actualizado exitosamente")) {
            JLabel lb = new JLabel();
            lb.setSize(50, 50);
            JOptionPane.showMessageDialog(null,
                    "Medicamento Actualizado Exitosamente",
                    "Actualizacion exitosa",
                    JOptionPane.CLOSED_OPTION,
                    f.setImageBackground("/recursos/exito.png", lb)
            );
            allSetEmpty();
            App.getInstance().ChangePanel(FramePrincipal.INTFronteraGestionMed);
            App.getInstance().framePrincipal.gestionMed.search();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Algun Campo Esta Mal Diligenciado, Por Favor Verificarlos",
                    "Comprobar Campos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased

    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedFocusGained

    private void txtMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedFocusLost

    private void txtMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedKeyReleased

    }//GEN-LAST:event_txtMedKeyReleased

    private void txtMedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedKeyTyped

    }//GEN-LAST:event_txtMedKeyTyped

    private void txtPrinActFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrinActFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrinActFocusGained

    private void txtPrinActFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrinActFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrinActFocusLost

    private void txtPrinActKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrinActKeyReleased

    }//GEN-LAST:event_txtPrinActKeyReleased

    private void txtPrinActKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrinActKeyTyped

    }//GEN-LAST:event_txtPrinActKeyTyped

    private void txtTitularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitularFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitularFocusGained

    private void txtTitularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitularFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitularFocusLost

    private void txtTitularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitularKeyReleased

    }//GEN-LAST:event_txtTitularKeyReleased

    private void txtTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitularKeyTyped

    }//GEN-LAST:event_txtTitularKeyTyped

    private void txtPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusGained

    }//GEN-LAST:event_txtPresentacionFocusGained

    private void txtPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusLost

    }//GEN-LAST:event_txtPresentacionFocusLost

    private void txtPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyPressed

    }//GEN-LAST:event_txtPresentacionKeyPressed

    private void txtPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyReleased

    }//GEN-LAST:event_txtPresentacionKeyReleased

    private void txtPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyTyped


    }//GEN-LAST:event_txtPresentacionKeyTyped

    private void txtStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockFocusGained
        if (txtStock.getBackground().equals(f.fondoTxtError)) {
            txtStock.setBackground(f.fondoTxt);
            txtStock.setText("");
        }
    }//GEN-LAST:event_txtStockFocusGained

    private void txtStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockFocusLost
        if (!txtStock.getText().equals("")) {
            if (editarMedicamento.validarStock(Short.parseShort(txtStock.getText()))
                    .equals("Cantidad no válida")) {
                JOptionPane.showMessageDialog(null,
                        "La Cantidad Debe Tener Entre 0 y 2000 Unidades",
                        "Cantidad no válida",
                        JOptionPane.ERROR_MESSAGE);
                txtStock.setBackground(f.fondoTxtError);

            }
        }
    }//GEN-LAST:event_txtStockFocusLost

    private void txtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyPressed

    private void txtStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyReleased

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtStock.getText().length() == 4) {
            evt.consume();
        }

    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        if (txtPrecio.getBackground().equals(f.fondoTxtError)) {
            txtPrecio.setBackground(f.fondoTxt);
            txtPrecio.setText("");
        }
    }//GEN-LAST:event_txtPrecioFocusGained

    private void txtPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusLost
        if (!txtPrecio.getText().equals("")) {
            if (editarMedicamento.validarPrecioventa(Integer.valueOf(txtPrecio.getText()))
                    .equals("Precio de venta fuera de rango")) {
                JOptionPane.showMessageDialog(null,
                        "La Cantidad Debe Tener Entre 100 y 10.000.000 De Pesos",
                        "Precio de venta fuera de rango",
                        JOptionPane.ERROR_MESSAGE);
                txtPrecio.setBackground(f.fondoTxtError);

            }
        }
    }//GEN-LAST:event_txtPrecioFocusLost

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed

    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtPrecio.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlKit;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMed;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtPrinAct;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
