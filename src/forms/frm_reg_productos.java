package forms;

import clases.cl_productos;
import clases.cl_varios;
import com.sun.glass.events.KeyEvent;
import vistas.frm_ver_productos;

public class frm_reg_productos extends javax.swing.JInternalFrame {

    cl_productos c_producto = new cl_productos();
    public static int id_producto;
    public static String accion;
    cl_varios c_varios = new cl_varios();

    public frm_reg_productos() {
        initComponents();
        if (accion.equals("modificar")) {

            c_producto.setId_producto(id_producto);
            c_producto.obtener_datos();
            txt_codigo.setText(String.valueOf(c_producto.getId_producto()));
            txt_nombre.setText(c_producto.getDescripcion());
            txt_cantidad.setText(String.valueOf(c_producto.getCan_actual()));
            txt_estado.setText(String.valueOf(c_producto.getEstado()));
        }
    }

    private void llenar() {
        if (accion.equals("grabar")) {
            c_producto.setId_producto(c_producto.obtener_codigo());
        }
        if (accion.equals("modificar")) {
            c_producto.setId_producto(Integer.parseInt(txt_codigo.getText()));
        }
        c_producto.setDescripcion(txt_nombre.getText());
        c_producto.setCan_actual(Integer.parseInt(txt_cantidad.getText()));
        c_producto.setEstado(Integer.parseInt(txt_estado.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_estado = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();

        jLabel1.setText(" Codigo");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Cant_Actual");

        jLabel4.setText("Estado");

        txt_codigo.setEnabled(false);

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

        txt_cantidad.setEnabled(false);
        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });

        txt_estado.setEnabled(false);
        txt_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_estadoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_estadoKeyTyped(evt);
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

        btn_modificar.setText("Modifcar");
        btn_modificar.setEnabled(false);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(82, 82, 82)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btn_cer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(59, 59, 59)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(85, 85, 85)
                        .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        c_producto.insertar();
        frm_ver_productos frm_productos = new frm_ver_productos();
        c_varios.llamar_ventana_completa(frm_productos);
        this.dispose();

    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            llenar();
        }
    }//GEN-LAST:event_btn_regKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased
        // TODO add your handling code here:
        txt_nombre.setText(txt_nombre.getText().toUpperCase());
    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_nombre.getText().length() > 3) {
                txt_cantidad.setEnabled(true);

                txt_cantidad.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_nombreKeyPressed

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isLetter(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void txt_cantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_cantidad.getText().length() > 0) {
                txt_estado.setEnabled(true);
                txt_estado.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_cantidadKeyPressed

    private void txt_estadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isLetter(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_estadoKeyTyped

    private void txt_estadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_estado.getText().length() > 0) {
               
                if (txt_codigo.getText().equals("")) {
                    btn_reg.setEnabled(true);
                    btn_reg.requestFocus();
                    btn_reg.doClick();
                   
                } else {
                  btn_modificar.setEnabled(true);
                    btn_modificar.requestFocus();
                    btn_modificar.doClick();

                    
                }
            }
        }
    }//GEN-LAST:event_txt_estadoKeyPressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        llenar();
        c_producto.modificar();
        frm_ver_productos frm_productos = new frm_ver_productos();
        c_varios.llamar_ventana_completa(frm_productos);
        this.dispose();

    }//GEN-LAST:event_btn_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_modificar;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
