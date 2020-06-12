package Recursos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class Funciones {

    public final Color fondoTxt = new Color(0, 0, 0, 15);
    public final Color fondoTxtError = new Color(255, 0, 0, 63);
    public final Color colorPrincipal = new Color(12, 183, 242);
    public final Color azulApp = new Color(8, 83, 148);

    public void setStyleJTextField(JTextField tf) {
        tf.setBackground(fondoTxt);
        tf.setFont(new Font("Leelawadee", 0, 18));
        tf.setBorder(new MatteBorder(3, 3, 3, 3, colorPrincipal));

    }

    public void setStyleJTextArea(JTextArea jta, JScrollPane scrollPane) {
        scrollPane.getViewport().setOpaque(false);
        jta.setBackground(fondoTxt);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setOpaque(false);
        jta.setFont(new Font("Leelawadee", 0, 18));
        jta.setBorder(new MatteBorder(3, 3, 3, 3, colorPrincipal));
    }

    public void setStyleJComboBox(JComboBox box) {
        box.setBackground(new Color(0, 0, 0, 0));
        box.setBorder(new MatteBorder(3, 3, 3, 3, colorPrincipal));
        box.setFont(new Font("Leelawadee", 0, 18));
        box.setForeground(Color.BLACK);

    }

    public ImageIcon setImageBackground(String direccion, Component o) {
        ImageIcon imagen = new ImageIcon(this.getClass().getResource(direccion));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(o.getWidth(), o.getHeight(), Image.SCALE_SMOOTH));
        return imagen;
    }

    public void setStyleJButon(JButton jb) {
        jb.setOpaque(false);
        int delta = 30;
        Color sinFondo = new Color(0, 0, 0, 0);
        Color fondoNormal = new Color(12, 183, 242, 255);
        Color fondoPresionado = new Color(12, 183 - delta, 242, 255);
        Color fondoClaro = new Color(12, 183 + delta, 242, 255);
        jb.setVerticalAlignment(JButton.CENTER);
        jb.setHorizontalAlignment(JButton.CENTER);
        jb.setVerticalTextPosition(JButton.CENTER);
        jb.setHorizontalTextPosition(JButton.CENTER);
        jb.setFont(new Font("Leelawadee", 1, 18));
        jb.setForeground(fondoNormal);
        jb.setBackground(sinFondo);
        jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoNormal));
        jb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jb.setForeground(fondoClaro);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoClaro));

            }

            @Override
            public void mousePressed(MouseEvent e) {
                jb.setForeground(fondoPresionado);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoPresionado));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jb.setForeground(fondoNormal);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoNormal));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jb.setForeground(fondoClaro);
                jb.setBackground(sinFondo);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoClaro));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                jb.setBackground(sinFondo);
                jb.setForeground(fondoNormal);
                jb.setBorder(new MatteBorder(4, 4, 4, 4, fondoNormal));
            }
        });

    }

    public void setStyleJButonBack(JLabel jl) {

        jl.setIcon(setImageBackground("/Recursos/botonSalir/salir.png", jl));

        jl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jl.setIcon(setImageBackground("/Recursos/botonSalir/salirClaro.png", jl));

            }

            @Override
            public void mousePressed(MouseEvent e) {

                jl.setIcon(setImageBackground("/Recursos/botonSalir/salirPresionado.png", jl));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jl.setIcon(setImageBackground("/Recursos/botonSalir/salir.png", jl));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jl.setIcon(setImageBackground("/Recursos/botonSalir/salirClaro.png", jl));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jl.setIcon(setImageBackground("/Recursos/botonSalir/salir.png", jl));
            }
        });

    }

    public void setStyleJLabel(JLabel jl) {
        jl.setOpaque(true);
        jl.setBackground(azulApp);
        jl.setForeground(Color.WHITE);
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setVerticalTextPosition(JLabel.CENTER);
        jl.setHorizontalTextPosition(JLabel.CENTER);
        jl.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        jl.setFont(new Font("Leelawadee", 1, 20));
    }

    public void setStyleJTable(JTable jt, JScrollPane jsp) {
        jsp.getViewport().setOpaque(false);
        jt.setOpaque(false);
        JTableHeader jtableHeader = jt.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderTable());
        jt.setTableHeader(jtableHeader);
        jt.setDefaultRenderer(Object.class, new allTable());
        jsp.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

    }

    public void setStyleJScrollPane(JScrollPane jsp) {

        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setComponentZOrder(jsp.getVerticalScrollBar(), 0);
        jsp.setComponentZOrder(jsp.getViewport(), 1);
        jsp.getVerticalScrollBar().setOpaque(false);
        jsp.getVerticalScrollBar().setUI(new MyScrollBarUI());
    }

    public static class HeaderTable implements TableCellRenderer {

        public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) c).setSize(20, c.getWidth());
            ((JLabel) c).setFont(new Font("Leelawadee", 0, 14));
            ((JLabel) c).setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
            ((JLabel) c).setOpaque(true);
            c.setBackground(new Color(200, 200, 200));
            c.setForeground(Color.BLACK);
            return c;
        }

    }

    public static class allTable implements TableCellRenderer {

        public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setFont(new Font("Leelawadee", 0, 12));
            c.setForeground(Color.BLACK);

            if (isSelected) {
                c.setBackground(Color.BLACK);
                c.setForeground(Color.WHITE);
            } else {

                if (row % 2 == 0) {
                    c.setBackground(new Color(111, 168, 220));
                } else {
                    c.setBackground(Color.WHITE);
                }
            }
            return c;
        }
    }

    public static class MyScrollBarUI extends BasicScrollBarUI {

        private final int delta = 30;
        private final Color defaultColor = new Color(12, 183, 242, 100);
        private final Color draggingColor = new Color(12, 183 - delta, 242, 100);
        private final Color rolloverColor = new Color(12, 183 + delta, 242, 100);
        private final Dimension d = new Dimension();

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return d;
                }
            };
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return new JButton() {
                @Override
                public Dimension getPreferredSize() {
                    return d;
                }
            };
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
           
                Color color;
                JScrollBar sb = (JScrollBar) c;
                if (!sb.isEnabled() || r.width > r.height) {
                    return;
                } else if (isDragging) {
                    color = draggingColor;
                } else if (isThumbRollover()) {
                    color = rolloverColor;
                } else {
                    color = defaultColor;
                }
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(color);
                g2.setPaint(color);
                g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
                g2.setPaint(Color.WHITE);
                g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
                g2.dispose();
        }

        @Override
        protected void setThumbBounds(int x, int y, int width, int height) {
            super.setThumbBounds(x, y, width, height);
            scrollbar.repaint();
        }
    }
}
