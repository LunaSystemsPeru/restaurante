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
    cl_mesas c_mesa = new cl_mesas();
    cl_platos c_plato = new cl_platos();

    /**
     * Creates new form frm_reg_pedido
     */
    public frm_reg_pedido() {
        initComponents();
        llamar_dialog_mesa();
        llamar_clasificacion();
        formato_items();
    }

    private void llamar_dialog_plato(){
        jd_producto_seleccionado.setModal(true);
        jd_producto_seleccionado.setSize(500,340);
        
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
                String num_mesa=array_mesa.get(i).get(0).toString();
                boton[i].addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        lbl_num_mesa.setText(num_mesa);
                        jd_mesa.dispose();
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
        System.out.println(diferencia);

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
        ArrayList<ArrayList> plato = this.c_plato.obtener_platos();
        String[] comidas = new String[18];
        String n_plato = "";
        boolean[] enable = new boolean[18];
        int id_plato[] = new int[18];
        Color[] color_letra=new Color[18];
        for (int i = 0; i < 18; i++) {
            if (i < plato.size()) {
                n_plato = plato.get(i).get(1).toString();
                comidas[i] = "<html><p> " + n_plato + "</p></html>";
                enable[i] = true;
                id_plato[i] = Integer.parseInt(plato.get(i).get(0).toString());
                color_letra[i]=new Color(0,0,0);
            } else {
                n_plato = i + "";
                comidas[i] = "<html><p> Boton desactivado" + n_plato + "</p></html>";
                enable[i] = false;
                id_plato[i] = 0;
                color_letra[i]=new Color(240,240,240);
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
        jTextField3 = new javax.swing.JTextField();
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
        tabla_platos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

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

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("1");
        jd_producto_seleccionado.getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 60, 60));
        jd_producto_seleccionado.getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 480, 20));

        jButton8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        jButton8.setText("Añadir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jd_producto_seleccionado.getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 140, 40));

        setTitle("Agregar Pedido Mesa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Platos"));
        jPanel1.setPreferredSize(new java.awt.Dimension(676, 325));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        tabla_platos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_platos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla_platos.setAutoscrolls(false);
        tabla_platos.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tabla_platos);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Guardar");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("S/ ");

        jButton2.setText("E");
        jButton2.setBorder(null);

        jButton3.setText("D");
        jButton3.setHideActionText(true);

        jButton4.setText("L");

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("0.00");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_num_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int c=Integer.parseInt(this.jTextField3.getText());
        if(c<99){
            c++;
        }
        this.jTextField3.setText(c+"");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int c=Integer.parseInt(this.jTextField3.getText());
        if(c>1){
            c--;
        }
        this.jTextField3.setText(c+"");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        double precio=Double.parseDouble(this.c_plato.getPrecio());
        int cantidad=Integer.parseInt(this.jTextField3.getText());
        Object[] fila={txt_nombre_plato.getText(),cantidad,precio,this.c_plato.getIdplatos()};
        this.jTextField3.setText("1");
        double total=precio*cantidad+Double.parseDouble(this.jLabel6.getText());
        this.jLabel6.setText(total+"");
        this.mostrar.addRow(fila);
        this.jd_producto_seleccionado.dispose();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void formato_items(){
        mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            

            mostrar.addColumn("Plato");
            mostrar.addColumn("Cantidad");
            mostrar.addColumn("Precio");
            mostrar.addColumn("");
            tabla_platos.setModel(mostrar);
            tabla_platos.getColumnModel().getColumn(0).setPreferredWidth(320);
            tabla_platos.getColumnModel().getColumn(0).setResizable(false);
            tabla_platos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla_platos.getColumnModel().getColumn(1).setResizable(false);
            tabla_platos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla_platos.getColumnModel().getColumn(2).setResizable(false);
            tabla_platos.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabla_platos.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla_platos.getColumnModel().getColumn(3).setMinWidth(0);
            tabla_platos.getColumnModel().getColumn(3).setResizable(false);
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JDialog jd_mesa;
    private javax.swing.JDialog jd_producto_seleccionado;
    private javax.swing.JLabel lbl_num_mesa;
    private javax.swing.JTable tabla_platos;
    private javax.swing.JTextField txt_nombre_plato;
    // End of variables declaration//GEN-END:variables
}
