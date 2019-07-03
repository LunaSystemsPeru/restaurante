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
public  static int id_empleado;
public  static String accion;
  cl_empleado c_empleados=new cl_empleado();
  cl_varios c_varios=new cl_varios();
    public frm_reg_empleado() {
        initComponents();
        txt_codigo.setText(String.valueOf(id_empleado));
        if(accion.equals("modificar")){
            c_empleados.setId_empleados(id_empleado);
            c_empleados.obtener_datos();
            txt_nombre.setText(c_empleados.getNombres());
            txt_apellido.setText(c_empleados.getApellidos());
            txt_usuario.setText(c_empleados.getUsuario());
            txt_contraseña.setText(c_empleados.getContraseña());
            txt_nur_documento.setText(c_empleados.getNur_documento());
            txt_estado.setText(c_empleados.getEstado());
            txt_cargo.setText(c_empleados.getCargo());
            
        }
    
    }
  private void llenar(){
       if (accion.equals("registrar")) {
            txt_codigo.setText(String.valueOf(c_empleados.obtener_codigo()));
        } 
        if (accion.equals("modificar")) {
            c_empleados.setId_empleados(Integer.parseInt(txt_codigo.getText()));
        } 
      c_empleados.setNombres(txt_nombre.getText());
      c_empleados.setApellidos(txt_apellido.getText());
      c_empleados.setUsuario(txt_usuario.getText());
      c_empleados.setContraseña(txt_contraseña.getText());
      c_empleados.setNur_documento(txt_nur_documento.getText());
      c_empleados.setEstado(txt_estado.getText());
      c_empleados.setCargo(txt_cargo.getText());
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
        txt_codigo = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JTextField();
        txt_estado = new javax.swing.JTextField();
        txt_cargo = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_nur_documento = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Codigo");

        jLabel2.setText(" Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Usuario");

        jLabel5.setText("Contraseña");

        jLabel6.setText("Estado");

        jLabel7.setText("Cargo");

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

        txt_apellido.setEnabled(false);
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });

        txt_usuario.setEnabled(false);
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
        });

        txt_contraseña.setEnabled(false);
        txt_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contraseñaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contraseñaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contraseñaKeyTyped(evt);
            }
        });

        txt_estado.setEnabled(false);
        txt_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_estadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_estadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_estadoKeyTyped(evt);
            }
        });

        txt_cargo.setEnabled(false);
        txt_cargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cargoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cargoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cargoKeyTyped(evt);
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

        jLabel8.setText("Nur_Documento");

        txt_nur_documento.setEnabled(false);
        txt_nur_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nur_documentoKeyPressed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_reg)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_nur_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(67, 67, 67)
                                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btn_cer))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(34, 34, 34)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nur_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        btn_reg.setEnabled(false);
        llenar();
        c_empleados.insertar();
        frm_ver_empleados frm_empleado=new frm_ver_empleados();
        c_varios.llamar_ventana_completa(frm_empleado);
        this.dispose();
        
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
     if(evt.getKeyCode()==KeyEvent.VK_ENTER){
         llenar();
     }
    }//GEN-LAST:event_btn_regKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        // TODO add your handling code here:
        char caracter=evt.getKeyChar();
        if(Character.isDigit(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased
       txt_nombre.setText(txt_nombre.getText().toUpperCase());
    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          if(txt_nombre.getText().length()>1){
              this.txt_apellido.setEnabled(true);
              txt_apellido.requestFocus();
          }
      }
    }//GEN-LAST:event_txt_nombreKeyPressed

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        // TODO add your handling code here:
        char caracter=evt.getKeyChar();
        if(Character.isDigit(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_apellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyReleased
        // TODO add your handling code here:
        txt_apellido.setText(txt_apellido.getText().toUpperCase());
    }//GEN-LAST:event_txt_apellidoKeyReleased

    private void txt_apellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_apellido.getText().length()>1){
                 this.txt_usuario.setEnabled(true);
                txt_usuario.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_apellidoKeyPressed

    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
        // TODO add your handling code here:
        char caracter=evt.getKeyChar();
        if(Character.isDigit(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_usuarioKeyTyped

    private void txt_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyReleased
        // TODO add your handling code here:
        txt_usuario.setText(txt_usuario.getText().toUpperCase());
    }//GEN-LAST:event_txt_usuarioKeyReleased

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_usuario.getText().length()>-1){
                 this.txt_contraseña.setEnabled(true);
              txt_contraseña.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void txt_contraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseñaKeyTyped
       char caracter = evt.getKeyChar();
        if(Character.isDigit(caracter)){
            evt.consume();
    }
    }//GEN-LAST:event_txt_contraseñaKeyTyped

    private void txt_contraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseñaKeyReleased
        txt_contraseña.setText(txt_contraseña.getText().toUpperCase());
    }//GEN-LAST:event_txt_contraseñaKeyReleased

    private void txt_contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraseñaKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_contraseña.getText().length()>1){
                 this.txt_nur_documento.setEnabled(true);

                txt_nur_documento.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_contraseñaKeyPressed

    private void txt_estadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyTyped
        // TODO add your handling code here:
        char caracter=evt.getKeyChar();
        if(Character.isLetter(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_estadoKeyTyped

    private void txt_estadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_estadoKeyReleased

    private void txt_estadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_estado.getText().length()>-1){
                this.txt_cargo.setEnabled(true);
                txt_cargo.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_estadoKeyPressed

    private void txt_cargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cargoKeyTyped
        // TODO add your handling code here:
        char caracter=evt.getKeyChar();
        if(Character.isDigit(caracter)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_cargoKeyTyped

    private void txt_cargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cargoKeyReleased
        // TODO add your handling code here:
        txt_cargo.setText(txt_cargo.getText().toUpperCase());
    }//GEN-LAST:event_txt_cargoKeyReleased

    private void txt_cargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cargoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_cargo.getText().length()>1){
               
             if(txt_codigo.getText().length()>=0){
                 this.jButton3.setEnabled(true);
                 jButton3.requestFocus();
                 
                 
             }
             else{
                 frm_reg_empleado.btn_reg.setEnabled(true);
                  btn_reg.requestFocus();
             }
            }
        }
    }//GEN-LAST:event_txt_cargoKeyPressed

    private void txt_nur_documentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nur_documentoKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txt_nur_documento.getText().length()>1){
                this.txt_estado.setEnabled(true);
                txt_estado.requestFocus();
                
            }
        }
    }//GEN-LAST:event_txt_nur_documentoKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
      llenar();
      c_empleados.modificar();
      frm_ver_empleados frm_empleados = new frm_ver_empleados();
        c_varios.llamar_ventana(frm_empleados);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nur_documento;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
