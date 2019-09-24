/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import vistas.frm_ver_empleados;
import clases.cl_empleado;
import clases.cl_varios;
import java.awt.event.KeyEvent;

/**
 *
 * @author BACA VARGAS
 */
public class frm_reg_empleado extends javax.swing.JInternalFrame {

    public static int id_empleado;
    public static String accion;
    cl_empleado c_empleados = new cl_empleado();
    cl_varios c_varios = new cl_varios();

    public frm_reg_empleado() {
        initComponents();
        if (accion.equals("modificar")) {
            c_empleados.setId_empleados(id_empleado);
            c_empleados.obtener_datos();
            txt_nombre.setText(c_empleados.getNombres());
            txt_apellido.setText(c_empleados.getApellidos());
            txt_usuario.setText(c_empleados.getUsuario());
            txt_contraseña.setText(c_empleados.getContraseña());
            txt_nur_documento.setText(c_empleados.getNur_documento());
        }

    }

    private void llenar() {
        if (accion.equals("registrar")) {
            c_empleados.obtener_codigo();
        }
        c_empleados.setNombres(txt_nombre.getText());
        c_empleados.setApellidos(txt_apellido.getText());
        c_empleados.setUsuario(txt_usuario.getText());
        c_empleados.setContraseña(txt_contraseña.getText());
        c_empleados.setNur_documento(txt_nur_documento.getText());
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
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nur_documento = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        chb_estado = new javax.swing.JCheckBox();
        cbx_cargo = new javax.swing.JComboBox<>();

        setTitle("Agregar Usuario / Empleado");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Usuario");

        jLabel5.setText("Contraseña");

        jLabel6.setText("Estado");

        jLabel7.setText("Cargo");

        txt_nombre.setEnabled(false);
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
        });

        txt_apellido.setEnabled(false);
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyReleased(evt);
            }
        });

        txt_usuario.setEnabled(false);
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyReleased(evt);
            }
        });

        txt_contraseña.setEnabled(false);
        txt_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseñaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contraseñaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contraseñaKeyReleased(evt);
            }
        });

        jLabel8.setText("DNI:");

        txt_nur_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nur_documentoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nur_documentoKeyPressed(evt);
            }
        });

        jToolBar1.setFloatable(false);

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setEnabled(false);
        btn_reg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        jToolBar1.add(btn_reg);

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

        chb_estado.setText("Activo");
        chb_estado.setEnabled(false);

        cbx_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_cargo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chb_estado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addComponent(txt_contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addComponent(txt_nur_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_cargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nur_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        btn_reg.setEnabled(false);
        llenar();
        c_empleados.insertar();
        frm_ver_empleados frm_empleado = new frm_ver_empleados();
        c_varios.llamar_ventana_completa(frm_empleado);
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
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased
        txt_nombre.setText(txt_nombre.getText().toUpperCase());
    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_nombre.getText().length() > 1) {
                this.txt_apellido.setEnabled(true);
                txt_apellido.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_nombreKeyPressed

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_apellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyReleased
        // TODO add your handling code here:
        txt_apellido.setText(txt_apellido.getText().toUpperCase());
    }//GEN-LAST:event_txt_apellidoKeyReleased

    private void txt_apellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_apellido.getText().length() > 1) {
                this.txt_usuario.setEnabled(true);
                txt_usuario.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_apellidoKeyPressed

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_usuarioKeyTyped

    private void txt_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyReleased
        // TODO add your handling code here:
        txt_usuario.setText(txt_usuario.getText().toUpperCase());
    }//GEN-LAST:event_txt_usuarioKeyReleased

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_usuario.getText().length() > -1) {
                this.txt_contraseña.setEnabled(true);
                txt_contraseña.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void txt_contraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseñaKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_contraseñaKeyTyped

    private void txt_contraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseñaKeyReleased
        txt_contraseña.setText(txt_contraseña.getText().toUpperCase());
    }//GEN-LAST:event_txt_contraseñaKeyReleased

    private void txt_contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseñaKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_contraseña.getText().length() > 1) {
                this.txt_nur_documento.setEnabled(true);

                txt_nur_documento.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_contraseñaKeyPressed

    private void txt_nur_documentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nur_documentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_nur_documento.getText().length() > 1) {
                chb_estado.setEnabled(true);
                chb_estado.requestFocus();

            }
        }
    }//GEN-LAST:event_txt_nur_documentoKeyPressed

    private void txt_nur_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nur_documentoKeyTyped
        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txt_nur_documento, 11);
    }//GEN-LAST:event_txt_nur_documentoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JComboBox<String> cbx_cargo;
    private javax.swing.JCheckBox chb_estado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nur_documento;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
