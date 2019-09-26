//
package forms;

import clases.cl_proveedor;
import clases.cl_varios;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;

import vistas.frm_ver_proveedor;

public class frm_reg_proveedor extends javax.swing.JDialog {

    public static int id_proveedor;

    //accion -> agregar= true, Modificar = false
    public static boolean accion;
    cl_proveedor c_proveedores = new cl_proveedor();
    cl_varios c_varios = new cl_varios();
    JInternalFrame jif;

    public frm_reg_proveedor(Frame owner, boolean modal, JInternalFrame jif) {
        super(owner, modal);
        initComponents();
        this.jif = jif;
        if (!accion) {
            btn_reg_edi.setText("Modificar");
            btn_reg_edi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/application_edit.png")));
            btn_reg_edi.setEnabled(true);
            txt_nudocumento.setEditable(false);
            c_proveedores.setId_proveedor(id_proveedor);
            c_proveedores.obtener_datos();
//            txt_codigo.setText(String.valueOf(c_proveedores.getId_proveedor()));
            txt_nudocumento.setText(c_proveedores.getNum_documento());
            txt_razon_social.setText(c_proveedores.getRazon_social());
            txt_telefono.setText(String.valueOf(c_proveedores.getTelefono()));
            txt_celular.setText(String.valueOf(c_proveedores.getCelular()));
            txt_email.setText(c_proveedores.getEmail());
            txt_diereccion.setText(c_proveedores.getDireccion());
            
            combo_condicion.setSelectedItem(c_proveedores.getCondicion());
            combo_estado.setSelectedItem(c_proveedores.getEstado());
            
            txt_razon_social.setEnabled(true);
            txt_telefono.setEnabled(true);
            txt_celular.setEnabled(true);
            txt_email.setEnabled(true);
            txt_diereccion.setEnabled(true);
            combo_condicion.setEnabled(true);
            combo_estado.setEnabled(true);

        }
        this.setLocationRelativeTo(null);
    }

    public void llenar() {
        if (!accion) {
//            c_proveedores.setId_proveedor(Integer.parseInt(txt_codigo.getText()));

        }
        if (accion) {
            c_proveedores.setId_proveedor(c_proveedores.obtenr_codigo());
        }
        c_proveedores.setNum_documento(txt_nudocumento.getText());
        c_proveedores.setRazon_social(txt_razon_social.getText());
        c_proveedores.setTelefono(Integer.parseInt(txt_telefono.getText()));
        c_proveedores.setCelular(Integer.parseInt(txt_celular.getText()));
        c_proveedores.setDireccion(txt_diereccion.getText());
        c_proveedores.setEmail(txt_email.getText());
        c_proveedores.setEstado(combo_estado.getSelectedItem()+"");
        c_proveedores.setCondicion(combo_condicion.getSelectedItem()+"");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nudocumento = new javax.swing.JTextField();
        txt_razon_social = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_diereccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btn_reg_edi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_cer = new javax.swing.JButton();
        combo_condicion = new javax.swing.JComboBox<>();
        combo_estado = new javax.swing.JComboBox<>();

        setTitle("Registrar Proveedor");

        jLabel2.setText("Documento:");

        jLabel3.setText("Razon Social:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Celular:");

        jLabel6.setText("Email:");

        jLabel7.setText("Direccion:");

        jLabel8.setText("Condicion:");

        txt_nudocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nudocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nudocumentoKeyTyped(evt);
            }
        });

        txt_razon_social.setEnabled(false);
        txt_razon_social.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_razon_socialKeyPressed(evt);
            }
        });

        txt_telefono.setEnabled(false);
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyPressed(evt);
            }
        });

        txt_celular.setEnabled(false);
        txt_celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_celularKeyPressed(evt);
            }
        });

        txt_email.setEnabled(false);
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });

        txt_diereccion.setEnabled(false);
        txt_diereccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_diereccionKeyPressed(evt);
            }
        });

        jLabel9.setText("Estado:");

        jToolBar1.setFloatable(false);

        btn_reg_edi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_reg_edi.setText("Registrar");
        btn_reg_edi.setEnabled(false);
        btn_reg_edi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reg_edi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_reg_edi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reg_ediActionPerformed(evt);
            }
        });
        btn_reg_edi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_reg_ediKeyPressed(evt);
            }
        });
        jToolBar1.add(btn_reg_edi);
        jToolBar1.add(jSeparator1);

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setFocusable(false);
        btn_cer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_cer);

        combo_condicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Habido", "No habido" }));
        combo_condicion.setEnabled(false);
        combo_condicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_condicionActionPerformed(evt);
            }
        });

        combo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Baja de oficio" }));
        combo_estado.setEnabled(false);
        combo_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_estadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_razon_social)
                    .addComponent(txt_email)
                    .addComponent(txt_diereccion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nudocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txt_celular, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txt_telefono)
                            .addComponent(combo_condicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nudocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_diereccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_condicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reg_ediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reg_ediActionPerformed
        llenar();

        //frm_ver_proveedor frm_proveedor = new frm_ver_proveedor();
        if (accion) {
            c_proveedores.insertar();
            //c_varios.llamar_ventana_completa(frm_proveedor);
        } else {
            llenar();
            c_proveedores.modificar();
            //c_varios.llamar_ventana_completa(frm_proveedor);

        }
        this.dispose();
        ((frm_ver_proveedor) jif).llenar_tabla();
    }//GEN-LAST:event_btn_reg_ediActionPerformed

    private void btn_reg_ediKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_reg_ediKeyPressed

    }//GEN-LAST:event_btn_reg_ediKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_nudocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nudocumentoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_nudocumentoKeyTyped

    private void txt_nudocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nudocumentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_nudocumento.getText().length() > 7) {
                txt_razon_social.setEnabled(true);
                txt_razon_social.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_nudocumentoKeyPressed

    private void txt_razon_socialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_razon_socialKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_razon_social.getText().length() > 2) {
                txt_telefono.setEnabled(true);
                txt_telefono.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_razon_socialKeyPressed

    private void txt_telefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_telefono.getText().length() > 3) {
                txt_celular.setEnabled(true);
                txt_celular.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_telefonoKeyPressed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_email.getText().length() > 3) {
                txt_diereccion.setEnabled(true);
                txt_diereccion.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_emailKeyPressed

    private void txt_celularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_celularKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_celular.getText().length() > 7) {
                txt_email.setEnabled(true);
                txt_email.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_celularKeyPressed

    private void txt_diereccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diereccionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_diereccion.getText().length() > 1) {
                combo_condicion.setEnabled(true);
                //jComboBox1.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_diereccionKeyPressed

    private void combo_condicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_condicionActionPerformed
        if (combo_condicion.getSelectedIndex() > 0) {
            
            combo_estado.setEnabled(true);
             btn_reg_edi.setEnabled(combo_estado.getSelectedIndex() > 0);
        } else {
            combo_estado.setEnabled(false);
            btn_reg_edi.setEnabled(false);
        }
    }//GEN-LAST:event_combo_condicionActionPerformed

    private void combo_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_estadoActionPerformed
        if (combo_estado.getSelectedIndex() > 0) {
            btn_reg_edi.setEnabled(true);
        } else {
            btn_reg_edi.setEnabled(false);
        }
    }//GEN-LAST:event_combo_estadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    public static javax.swing.JButton btn_reg_edi;
    private javax.swing.JComboBox<String> combo_condicion;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_diereccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nudocumento;
    private javax.swing.JTextField txt_razon_social;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
