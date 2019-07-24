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
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author BACA VARGAS
 */
public class frm_reg_pedido extends javax.swing.JInternalFrame {

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
        ArrayList<ArrayList> clas_mesa = this.c_mesa.obtener_mesass();
        JButton boton[] = new JButton[20];

        for (int i = 0; i < 20; i++) {
            boton[i] = new JButton(String.valueOf(i + 1));
            boton[i].setFont(new Font("Arial", Font.BOLD, 18));
            boton[i].setOpaque(true);
            boton[i].setHorizontalTextPosition(SwingConstants.CENTER);
            boton[i].setVerticalTextPosition(SwingConstants.CENTER);
        }
        jd_mesa.setLayout(new GridLayout(5, 4, 4, 4));

        for (int i = 0; i < 20; i++) {
            jd_mesa.add(boton[i]);
            if (i >= clas_mesa.size()) {
                boton[i].setEnabled(false);
                boton[i].addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        
                    }
                });
            }

        }
        for (int i = 0; i < clas_mesa.size(); i++) {
            if ("1".equals(clas_mesa.get(i).get(1).toString())) {
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
        for (int i = 0; i < 18; i++) {
            if (i < plato.size()) {
                n_plato = plato.get(i).get(1).toString();
                comidas[i] = "<html><p> " + n_plato + "</p></html>";
                enable[i] = true;
                id_plato[i] = Integer.parseInt(plato.get(i).get(0).toString());
            } else {
                n_plato = i + "";
                comidas[i] = "<html><p> Boton desactivado" + n_plato + "</p></html>";
                enable[i] = false;
                id_plato[i] = 0;
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
        System.out.println("El plato seleccionado es: " + this.c_plato.getNombre() + " y su costo es: " + this.c_plato.getPrecio());

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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

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

        jLabel3.setText("5");

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
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Guardar");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("S/ 130.00");

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
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog jd_mesa;
    // End of variables declaration//GEN-END:variables
}
