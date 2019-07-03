//
package forms;

import clases.cl_proveedor;
import clases.cl_varios;
import com.sun.glass.events.KeyEvent;
import vistas.frm_ver_proveedor;

public class frm_reg_proveedor extends javax.swing.JInternalFrame {

    public static int id_proveedor;
    public static String accion;
    cl_proveedor c_proveedores = new cl_proveedor();
    cl_varios c_varios = new cl_varios();

    public frm_reg_proveedor() {
        initComponents();
        if (accion.equals("modificar")) {
            c_proveedores.setId_proveedor(id_proveedor);
            c_proveedores.obtener_datos();
            txt_codigo.setText(String.valueOf(c_proveedores.getId_proveedor()));
            txt_nudocumento.setText(c_proveedores.getNum_documento());
            txt_razon_social.setText(c_proveedores.getRazon_social());
            txt_telefono.setText(String.valueOf(c_proveedores.getTelefono()));
            txt_celular.setText(String.valueOf(c_proveedores.getCelular()));
            txt_email.setText(c_proveedores.getEmail());
            txt_diereccion.setText(c_proveedores.getDireccion());
            txt_condicion.setText(c_proveedores.getCondicion());
            txt_estado.setText(c_proveedores.getEstado());
        }
    }

    public void llenar() {
        if (accion.equals("modificar")) {
            c_proveedores.setId_proveedor(Integer.parseInt(txt_codigo.getText()));

        }
        if (accion.equals("grabar")) {
            c_proveedores.setId_proveedor(c_proveedores.obtenr_codigo());
        }
        c_proveedores.setNum_documento(txt_nudocumento.getText());
        c_proveedores.setRazon_social(txt_razon_social.getText());
        c_proveedores.setTelefono(Integer.parseInt(txt_telefono.getText()));
        c_proveedores.setCelular(Integer.parseInt(txt_celular.getText()));
        c_proveedores.setDireccion(txt_diereccion.getText());
        c_proveedores.setEmail(txt_email.getText());
        c_proveedores.setEstado(txt_estado.getText());
        c_proveedores.setCondicion(txt_condicion.getText());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nudocumento = new javax.swing.JTextField();
        txt_razon_social = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_diereccion = new javax.swing.JTextField();
        txt_estado = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        txt_condicion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jLabel1.setText("Codigo");

        jLabel2.setText("N_documeento");

        jLabel3.setText("Razon_Social");

        jLabel4.setText("Telefono");

        jLabel5.setText("Celular");

        jLabel6.setText("Email");

        jLabel7.setText("Direccion");

        jLabel8.setText("Condicion");

        txt_codigo.setEnabled(false);

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

        txt_estado.setEnabled(false);
        txt_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadoActionPerformed(evt);
            }
        });
        txt_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_estadoKeyPressed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setEnabled(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });
        btn_reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_regKeyPressed(evt);
            }
        });

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setFocusable(false);
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        txt_condicion.setEnabled(false);
        txt_condicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_condicionActionPerformed(evt);
            }
        });
        txt_condicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_condicionKeyPressed(evt);
            }
        });

        jLabel9.setText("Estado");

        jButton5.setText("Modificar");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_reg)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btn_cer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(txt_nudocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)
                        .addComponent(txt_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(70, 70, 70)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(79, 79, 79)
                        .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(88, 88, 88)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_condicion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diereccion, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
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
                    .addComponent(txt_condicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        c_proveedores.insertar();
        frm_ver_proveedor frm_proveedor = new frm_ver_proveedor();
        c_varios.llamar_ventana_completa(frm_proveedor);
        this.dispose();
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed

    }//GEN-LAST:event_btn_regKeyPressed

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
                txt_condicion.setEnabled(true);
                txt_condicion.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_diereccionKeyPressed

    private void txt_estadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_estado.getText().length() > 0) {
               if(txt_codigo.getText().equals("")){
                   btn_reg.setEnabled(true);
                   btn_reg.requestFocus();
               }
               else
               {
                   jButton5.setEnabled(true);
                   jButton5.requestFocus();
               }
            }
        }
    }//GEN-LAST:event_txt_estadoKeyPressed

    private void txt_condicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_condicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_condicionActionPerformed

    private void txt_condicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_condicionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_condicion.getText().length() > 0) {
                txt_estado.setEnabled(true);
                txt_estado.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_condicionKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        llenar();
        c_proveedores.modificar();
        frm_ver_proveedor frm_proveedor=new frm_ver_proveedor();
        c_varios.llamar_ventana_completa(frm_proveedor);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_condicion;
    private javax.swing.JTextField txt_diereccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_nudocumento;
    private javax.swing.JTextField txt_razon_social;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
