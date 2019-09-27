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
        jToolBar1 = new javax.swing.JToolBar();
        btn_reg = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_cer = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setTitle("Registro Documento Sunat");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Codigo Sunat:");

        jLabel4.setText("Abreviatura:");

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

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);
        btn_mod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_mod.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        jToolBar1.add(btn_mod);
        jToolBar1.add(jSeparator1);

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Salir");
        btn_cer.setFocusable(false);
        btn_cer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_cer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cod_sunat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_abreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 224, Short.MAX_VALUE))
                    .addComponent(txt_nombre))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_sunat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_abreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        c_documento_sunat.insertar();
        frm_ver_documento frm_documento = new frm_ver_documento();
        c_varios.llamar_ventana(frm_documento);
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
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_abreviatura;
    private javax.swing.JTextField txt_cod_sunat;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
