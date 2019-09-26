/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import clases.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author BACA VARGAS
 */
public class frm_reg_pedido extends javax.swing.JInternalFrame {

    DefaultTableModel mostrar;
    cl_clas_platos c_clasificacion = new cl_clas_platos();
    cl_pedido c_pedido = new cl_pedido();
    cl_detalle_pedido c_detalle = new cl_detalle_pedido();

    cl_mesas c_mesa = new cl_mesas();
    cl_platos c_plato = new cl_platos();
    int fila = -1;

    public static String accion;

    public static int id_mesa;

    private double precio = 0;
    private int cantidad = 0;

    /**
     * Creates new form frm_reg_pedido
     */
    public frm_reg_pedido() {
        initComponents();
        llamar_dialog_mesa();
        llamar_clasificacion();
        formato_items();
        btn_editar.setEnabled(false);
        btn_eliminar.setEnabled(false);

    }

    private void llamar_dialog_plato() {
        jd_producto_seleccionado.setModal(true);
        jd_producto_seleccionado.setSize(500, 340);

        jd_producto_seleccionado.setLocationRelativeTo(null);
        jd_producto_seleccionado.setVisible(true);
    }

    private void llamar_dialog_mesa() {
        jd_mesa.setModal(true);
        jd_mesa.setSize(800, 400);
        llamar_mesas();
        jd_mesa.setLocationRelativeTo(null);
        jd_mesa.setVisible(true);

    }

    private void calcularSubTotal() {
        double total = 0;
        int contar_filas = tbl_pedido.getRowCount();
        for (int i = 0; i < contar_filas; i++) {
            total = total + Double.parseDouble(tbl_pedido.getValueAt(i, 3).toString());
        }
        this.txt_cantidad.setText("1");
        this.txt_cant_total.setText(total + "");
    }

    private void llamar_mesas() {
        //Creacion de botones
        ArrayList<ArrayList> array_mesa = this.c_mesa.obtener_mesass();
        JButton boton[] = new JButton[20];
        jd_mesa.setLayout(new GridLayout(5, 4, 4, 4));
        for (int i = 0; i < 20; i++) {
            boton[i] = new JButton(String.valueOf(i + 1));
            boton[i].setFont(new Font("Arial", Font.BOLD, 18));
            boton[i].setVerticalTextPosition(SwingConstants.CENTER);
        }

        for (int i = 0; i < 20; i++) {
            jd_mesa.add(boton[i]);
            if (i >= array_mesa.size()) {
                boton[i].setEnabled(false);
            } else {
                String num_mesa = array_mesa.get(i).get(0).toString();
                boton[i].addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        lbl_num_mesa.setText(num_mesa);
                        jd_mesa.dispose();
                        id_mesa = Integer.parseInt(num_mesa);
                    }
                });
            }

        }
        for (int i = 0; i < array_mesa.size(); i++) {
            if ("1".equals(array_mesa.get(i).get(1).toString())) {
                boton[i].setBackground(Color.red);
                boton[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/mesa_libre.png")));
            } else {
                boton[i].setBackground(Color.GREEN);
                boton[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/mesa_ocupada.png")));
            }
        }
    }

    private void llamar_clasificacion() {
        jPanel2.setLayout(new GridLayout(2, 6, 4, 4));

        JButton[] botones = new JButton[12];
        ArrayList<ArrayList> clas_plato = this.c_clasificacion.obtener_clasificaciones();
        int diferencia = 12 - clas_plato.size();
        //  System.out.println(diferencia);

        for (int i = 0; i < clas_plato.size(); i++) {
            final int contar = i;
            botones[i] = new JButton("Boton_" + i);

            botones[i].setBackground(new java.awt.Color(204, 204, 204));

            botones[i].setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

            botones[i].setText(clas_plato.get(i).get(1).toString());
            String id_clas = clas_plato.get(i).get(0).toString();

            botones[i].setContentAreaFilled(false);

            botones[i].setSize(100, 50);
            botones[i].setPreferredSize(new Dimension(100, 50));

            botones[i].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    llamar_platos(id_clas);

                }
            });

            jPanel2.add(botones[i]);
        }

        for (int i = 0; i < diferencia; i++) {
            final int contar = i;
            botones[i] = new JButton("Boton_" + i);

            botones[i].setBackground(new java.awt.Color(204, 204, 204));

            botones[i].setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

            botones[i].setText("");

            botones[i].setContentAreaFilled(false);

            botones[i].setSize(100, 50);
            botones[i].setPreferredSize(new Dimension(100, 50));
            botones[i].setEnabled(false);

            /*botones[i].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    llamar_platos(contar + "");
                }
            });*/
            jPanel2.add(botones[i]);
        }
    }

    private void llamar_platos(String id_tipo) {
        jPanel1.removeAll();
        jPanel1.setLayout(new GridLayout(3, 6, 4, 4));
        this.c_plato.setId_clases_platos(Integer.parseInt(id_tipo));
        ArrayList<ArrayList> plato = this.c_plato.obtener_platos();//obtener platos
        String[] comidas = new String[18];
        String n_plato = "";
        boolean[] enable = new boolean[18];
        int id_plato[] = new int[18];
        Color[] color_letra = new Color[18];
        for (int i = 0; i < 18; i++) {
            if (i < plato.size()) {
                n_plato = plato.get(i).get(1).toString();
                comidas[i] = "<html><p> " + n_plato + "</p></html>";
                enable[i] = true;
                id_plato[i] = Integer.parseInt(plato.get(i).get(0).toString());
                color_letra[i] = new Color(0, 0, 0);
            } else {
                n_plato = i + "";
                comidas[i] = "<html><p> Boton desactivado" + n_plato + "</p></html>";
                enable[i] = false;
                id_plato[i] = 0;
                color_letra[i] = new Color(240, 240, 240);
            }

        }

        JButton[] botones = new JButton[18];

        for (int i = 0; i < 18; i++) {
            final int contar = i;
            botones[i] = new JButton("Comida_" + i);

            botones[i].setBackground(new java.awt.Color(204, 204, 204));

            botones[i].setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

            botones[i].setText(comidas[i]);

            botones[i].setContentAreaFilled(false);

            botones[i].setSize(100, 70);
            botones[i].setPreferredSize(new Dimension(100, 70));
            botones[i].setEnabled(enable[i]);

            int idplato = id_plato[i];
            botones[i].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    llamar_agregar_plato(idplato);

                }
            });

            jPanel1.add(botones[i]);
        }
        jPanel1.repaint();
    }

    private void llamar_agregar_plato(int id_plato) {

        this.c_plato.setIdplatos(id_plato);
        this.c_plato.obtener_datos();
        txt_nombre_plato.setText(c_plato.getNombre());
        accion = "registrar";
        // txt_nombre_plato.setText(accion);
        //////////////////////////7
        llamar_dialog_plato();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_mesa = new javax.swing.JDialog();
        jd_producto_seleccionado = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre_plato = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txt_cantidad = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbl_num_mesa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pedido = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        txt_cant_total = new javax.swing.JLabel();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();

        jd_mesa.setTitle("Seleccione la Mesa");

        javax.swing.GroupLayout jd_mesaLayout = new javax.swing.GroupLayout(jd_mesa.getContentPane());
        jd_mesa.getContentPane().setLayout(jd_mesaLayout);
        jd_mesaLayout.setHorizontalGroup(
            jd_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        jd_mesaLayout.setVerticalGroup(
            jd_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        jd_producto_seleccionado.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Plato Seleccionado:");
        jd_producto_seleccionado.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        txt_nombre_plato.setEditable(false);
        txt_nombre_plato.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        txt_nombre_plato.setText("jTextField2");
        txt_nombre_plato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_platoActionPerformed(evt);
            }
        });
        jd_producto_seleccionado.getContentPane().add(txt_nombre_plato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, 461, 50));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Cantidad:");
        jd_producto_seleccionado.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jButton6.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jButton6.setText("-");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jd_producto_seleccionado.getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 60, 60));

        jButton7.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jButton7.setText("+");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jd_producto_seleccionado.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 60, 60));

        txt_cantidad.setEditable(false);
        txt_cantidad.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        txt_cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad.setText("1");
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        jd_producto_seleccionado.getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 60, 60));
        jd_producto_seleccionado.getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 480, 20));

        jButton8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        jButton8.setText("Añadir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jd_producto_seleccionado.getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 140, 40));

        setTitle("Agregar Pedido Mesa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Platos"));
        jPanel1.setPreferredSize(new java.awt.Dimension(676, 325));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Clasificacion"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Pedido"));

        jLabel1.setText("Mesa Nro:");

        jLabel2.setText("Usuario:");

        jTextField1.setText("Luis Oyanguren");

        lbl_num_mesa.setText("5");

        jScrollPane1.setHorizontalScrollBar(null);

        tbl_pedido.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_pedido.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_pedido.setAutoscrolls(false);
        tbl_pedido.setShowVerticalLines(false);
        tbl_pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pedido);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("S/ ");

        btn_salir.setText("Salir");
        btn_salir.setPreferredSize(new java.awt.Dimension(90, 25));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        txt_cant_total.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txt_cant_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_cant_total.setText("0.00");

        btn_editar.setText("Editar");
        btn_editar.setHideActionText(true);
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.setHideActionText(true);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.setHideActionText(true);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cant_total, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_num_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_num_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cant_total, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int c = Integer.parseInt(this.txt_cantidad.getText());
        if (c < 99) {
            c++;
        }
        this.txt_cantidad.setText(c + "");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int c = Integer.parseInt(this.txt_cantidad.getText());
        if (c > 1) {
            c--;
        }
        this.txt_cantidad.setText(c + "");
    }//GEN-LAST:event_jButton6ActionPerformed


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.precio = Double.parseDouble(this.c_plato.getPrecio());
        this.cantidad = Integer.parseInt(this.txt_cantidad.getText());
        float subTotal = (float) (this.cantidad * this.precio);
        Object[] fila = {txt_nombre_plato.getText(), cantidad, precio, subTotal, this.c_plato.getIdplatos()};
        if (accion.equals("registrar")) {
            this.mostrar.addRow(fila);
        }
        if (accion.equals("modificar")) {
            int i = 0;
            for (Object object : fila) {
                this.tbl_pedido.setValueAt(object, tbl_pedido.getSelectedRow(), i);
                i++;
            }
            i = 0;
        }
        calcularSubTotal();
        this.jd_producto_seleccionado.dispose();

    }//GEN-LAST:event_jButton8ActionPerformed


    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        //int id_cl_plato = Integer.parseInt(this.mostrar.getValueAt(tbl_pedido.getSelectedRow(), 4) + "");
        txt_nombre_plato.setText(this.mostrar.getValueAt(tbl_pedido.getSelectedRow(), 0) + "");
        txt_cantidad.setText(this.mostrar.getValueAt(tbl_pedido.getSelectedRow(), 1) + "");
        accion = "modificar";
        llamar_dialog_plato();

    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        int rowSelected = tbl_pedido.getSelectedRow();
        mostrar.removeRow(rowSelected);
        calcularSubTotal();
    }//GEN-LAST:event_btn_eliminarActionPerformed
    cl_varios c_varios = new cl_varios();

    public void llenarDatos() {
        c_pedido.setIdmesa(id_mesa);
        c_pedido.setFecha(c_varios.getFechaActual());
        c_pedido.setTotal(Float.parseFloat(txt_cant_total.getText()));
        c_pedido.setId_empleado(1);//CAMBIAR POR EL ID DE EMPLEADO AL INICIAR SESSION

    }

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        c_pedido.obtener_codigo();
        llenarDatos();

        c_pedido.insertar();

        c_detalle.setId_pedido(c_pedido.getId_pedido());

        int total_filas = tbl_pedido.getRowCount();
        if (total_filas >= 0) {
            for (int i = 0; i < total_filas; i++) {
                c_detalle.setCantidad(Integer.parseInt(tbl_pedido.getValueAt(i, 1).toString()));
                c_detalle.setPrecio(Double.parseDouble(tbl_pedido.getValueAt(i, 2).toString()));
                c_detalle.setId_plato(Integer.parseInt(tbl_pedido.getValueAt(i, 4).toString()));
                c_detalle.insertar();
            }
        }
        dispose();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_nombre_platoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_platoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_platoActionPerformed

    private void tbl_pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pedidoMouseClicked
        fila = tbl_pedido.getSelectedRow();
        btn_editar.setEnabled(true);
        btn_eliminar.setEnabled(true);
    }//GEN-LAST:event_tbl_pedidoMouseClicked

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void formato_items() {
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        mostrar.addColumn("Plato");
        mostrar.addColumn("Cantidad");
        mostrar.addColumn("Precio");
        mostrar.addColumn("Sub. Total");
        mostrar.addColumn("");
        tbl_pedido.setModel(mostrar);
        tbl_pedido.getColumnModel().getColumn(0).setPreferredWidth(305);
        tbl_pedido.getColumnModel().getColumn(0).setResizable(false);
        tbl_pedido.getColumnModel().getColumn(1).setPreferredWidth(65);
        tbl_pedido.getColumnModel().getColumn(1).setResizable(false);
        tbl_pedido.getColumnModel().getColumn(2).setPreferredWidth(65);
        tbl_pedido.getColumnModel().getColumn(2).setResizable(false);
        tbl_pedido.getColumnModel().getColumn(3).setPreferredWidth(75);
        tbl_pedido.getColumnModel().getColumn(3).setResizable(false);
        tbl_pedido.getColumnModel().getColumn(4).setPreferredWidth(0);
        tbl_pedido.getColumnModel().getColumn(4).setMaxWidth(0);
        tbl_pedido.getColumnModel().getColumn(4).setMinWidth(0);
        tbl_pedido.getColumnModel().getColumn(4).setResizable(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog jd_mesa;
    private javax.swing.JDialog jd_producto_seleccionado;
    private javax.swing.JLabel lbl_num_mesa;
    private javax.swing.JTable tbl_pedido;
    private javax.swing.JLabel txt_cant_total;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_nombre_plato;
    // End of variables declaration//GEN-END:variables
}
