/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.cl_documento_empresa;
import clases.cl_varios;
import java.awt.event.KeyEvent;
import objetos.cl_llenar_combobox;
import objetos.o_combobox;

public class frm_ver_mis_documento extends javax.swing.JInternalFrame {

    cl_documento_empresa c_documento = new cl_documento_empresa();
    cl_llenar_combobox c_llenar = new cl_llenar_combobox();

    int fila;
    cl_varios c_varios = new cl_varios();

    public frm_ver_mis_documento() {
        initComponents();
        c_llenar.verTodosDocumentosSunat(cbx_documentos);
        String query = "select de.idcomprobante, de.serie, ds.nombre, de.numero "
                + "from documentos_empresa as de "
                + "inner join documento_sunat as ds on ds.idcomprobante = de.idcomprobante";
        c_documento.mostrar(t_documento, query);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_agregar = new javax.swing.JDialog();
        jToolBar2 = new javax.swing.JToolBar();
        btn_jd_guardar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_jd_salir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbx_documentos = new javax.swing.JComboBox<>();
        txt_serie = new javax.swing.JTextField();
        txt_numero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_documento = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_eliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jd_agregar.setTitle("Agregar Documento a mi Negocio");

        jToolBar2.setFloatable(false);

        btn_jd_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_jd_guardar.setText("Guardar");
        btn_jd_guardar.setEnabled(false);
        btn_jd_guardar.setFocusable(false);
        btn_jd_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_jd_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_jd_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jd_guardarActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_jd_guardar);
        jToolBar2.add(jSeparator2);

        btn_jd_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        btn_jd_salir.setText("Salir");
        btn_jd_salir.setFocusable(false);
        btn_jd_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_jd_salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_jd_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jd_salirActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_jd_salir);

        jLabel4.setText("Documento SUNAT");

        jLabel5.setText("Serie");

        jLabel6.setText("Numero");

        cbx_documentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_documentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_documentosKeyPressed(evt);
            }
        });

        txt_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_serie.setEnabled(false);
        txt_serie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_serieKeyPressed(evt);
            }
        });

        txt_numero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero.setEnabled(false);
        txt_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_numeroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jd_agregarLayout = new javax.swing.GroupLayout(jd_agregar.getContentPane());
        jd_agregar.getContentPane().setLayout(jd_agregarLayout);
        jd_agregarLayout.setHorizontalGroup(
            jd_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jd_agregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_serie)
                    .addComponent(txt_numero)
                    .addComponent(cbx_documentos, 0, 234, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jd_agregarLayout.setVerticalGroup(
            jd_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_agregarLayout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_documentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setTitle("Ver Documentos SUNAT");

        jLabel2.setText("Encontados");

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/find.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busKeyTyped(evt);
            }
        });

        t_documento.setModel(new javax.swing.table.DefaultTableModel(
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
        t_documento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_documentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(t_documento);

        jToolBar1.setFloatable(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/accept.png"))); // NOI18N
        jButton4.setText("Grabar");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/application_edit.png"))); // NOI18N
        btn_modificar.setText("Modifcar");
        btn_modificar.setEnabled(false);
        btn_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_modificar);
        jToolBar1.add(jSeparator1);

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        btn_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_eliminar);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        jButton3.setText("Cerrar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (fila > -1) {

        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed

    }//GEN-LAST:event_txt_busKeyPressed

    private void txt_busKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyReleased

    }//GEN-LAST:event_txt_busKeyReleased

    private void txt_busKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyTyped
        // TODO add your handling code here:
        //        String buscar = txt_bus.getText();
        //        String query = "select id_cliente, documento, nombre, ventas, pagado "
        //        + "from clientes "
        //        + "where (documento like '%" + buscar + "%' or nombre like '%" + buscar + "%' or id_cliente = '" + buscar + "') and id_zona = '" + id_zona + "' "
        //        + "order by nombre asc";
        //        c_cliente.ver_clientes(t_clientes, query);
    }//GEN-LAST:event_txt_busKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jd_agregar.setModal(true);
        jd_agregar.setSize(400, 223);
        jd_agregar.setLocationRelativeTo(null);
        jd_agregar.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t_documentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_documentoMouseClicked
        fila = t_documento.getSelectedRow();
        if (fila > -1) {
            btn_modificar.setEnabled(true);
            btn_modificar.requestFocus();
        }
    }//GEN-LAST:event_t_documentoMouseClicked

    private void cbx_documentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_documentosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_serie.setEnabled(true);
            txt_serie.requestFocus();
        }
    }//GEN-LAST:event_cbx_documentosKeyPressed

    private void txt_serieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serieKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_serie.getText().length() > 0) {
                txt_numero.setEnabled(true);
                txt_numero.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_serieKeyPressed

    private void txt_numeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numeroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_numero.getText().length() > 0) {
                if (c_varios.isNumeric(txt_numero.getText())) {
                    btn_jd_guardar.setEnabled(true);
                    btn_jd_guardar.requestFocus();
                } else {
                    txt_numero.setText("");
                }
            }
        }
    }//GEN-LAST:event_txt_numeroKeyPressed

    private void btn_jd_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jd_salirActionPerformed
        this.jd_agregar.dispose();
    }//GEN-LAST:event_btn_jd_salirActionPerformed

    private void btn_jd_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jd_guardarActionPerformed
        o_combobox o_combo = (o_combobox) cbx_documentos.getSelectedItem();
        c_documento.setId_comprobante(o_combo.getId());
        c_documento.setSerie(txt_serie.getText());
        c_documento.setNumero(Integer.parseInt(txt_numero.getText()));
        c_documento.insertar();
        btn_jd_salir.doClick();
    }//GEN-LAST:event_btn_jd_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_jd_guardar;
    private javax.swing.JButton btn_jd_salir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cbx_documentos;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JDialog jd_agregar;
    private javax.swing.JTable t_documento;
    private javax.swing.JTextField txt_bus;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_serie;
    // End of variables declaration//GEN-END:variables
}
