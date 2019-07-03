package forms;

import clases.cl_documento_sunat;
import clases.cl_varios;
import java.awt.event.KeyEvent;
import vistas.frm_ver_documento;

public class frm_reg_documento_sunat extends javax.swing.JInternalFrame {

    public static int id_documento;
    public static String accion;
    cl_documento_sunat c_documento_sunat = new cl_documento_sunat();
    cl_varios c_varios = new cl_varios();

    public frm_reg_documento_sunat() {
        initComponents();
        if (accion.equals("modificar")) {
            c_documento_sunat.setId_documento(id_documento);
            c_documento_sunat.obtener_datos();
            txt_nombre.setText(c_documento_sunat.getNombre());
            txt_cod_sunat.setText(c_documento_sunat.getCod_sunat());
            txt_abreviatura.setText(c_documento_sunat.getAbreviatura());
        }
    }

    public void llenar() {
        if (accion.equals("grabar")) {
            c_documento_sunat.setId_documento(c_documento_sunat.obtener_codigo());
        }
        c_documento_sunat.setNombre(txt_nombre.getText());
        c_documento_sunat.setCod_sunat(txt_cod_sunat.getText());
        c_documento_sunat.setAbreviatura(txt_abreviatura.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_cod_sunat = new javax.swing.JTextField();
        txt_abreviatura = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        jLabel2.setText("Nombre");

        jLabel3.setText("Cod_Sunat");

        jLabel4.setText("Abreviatura");

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombreKeyPressed(evt);
            }
        });

        txt_cod_sunat.setEnabled(false);
        txt_cod_sunat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_sunatKeyPressed(evt);
            }
        });

        txt_abreviatura.setEnabled(false);
        txt_abreviatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_abreviaturaKeyPressed(evt);
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
        btn_cer.setFocusable(false);
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });
        btn_mod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_modKeyPressed(evt);
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
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_abreviatura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(txt_cod_sunat, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cer)
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_reg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mod)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_cod_sunat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_abreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        c_documento_sunat.insertar();
        frm_ver_documento frm_documento = new frm_ver_documento();
        c_varios.llamar_ventana_completa(frm_documento);
        this.dispose();
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed

    }//GEN-LAST:event_btn_regKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_cod_sunat.setEnabled(true);
            txt_cod_sunat.requestFocus();
        }
    }//GEN-LAST:event_txt_nombreKeyPressed

    private void txt_abreviaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_abreviaturaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_abreviatura.getText().length() > 1) {
                btn_reg.setEnabled(true);
                btn_reg.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_abreviaturaKeyPressed

    private void txt_cod_sunatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_sunatKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_abreviatura.setEnabled(true);
            txt_abreviatura.requestFocus();
        }
    }//GEN-LAST:event_txt_cod_sunatKeyPressed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        // TODO add your handling code here:
        llenar();
        c_documento_sunat.modificar();
        frm_ver_documento frm_documento = new frm_ver_documento();
        c_varios.llamar_ventana_completa(frm_documento);
        this.dispose();
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_modKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_modKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    public static javax.swing.JButton btn_mod;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txt_abreviatura;
    private javax.swing.JTextField txt_cod_sunat;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
