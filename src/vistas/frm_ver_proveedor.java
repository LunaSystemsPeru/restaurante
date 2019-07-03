
package vistas;

import clases.cl_proveedor;
import clases.cl_varios;
import forms.frm_reg_proveedor;
import java.awt.event.KeyEvent;

public class frm_ver_proveedor extends javax.swing.JInternalFrame {
cl_proveedor c_proveedor=new cl_proveedor();
cl_varios c_varios=new cl_varios();
int fila;
    public frm_ver_proveedor() {
        initComponents();
        String query="select * from proveedor ORDER by num_documento DESC";
        c_proveedor.ver_proveedores(t_proveedor, query);
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ver_compras = new javax.swing.JButton();
        btn_ver_productos = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_proveedor = new javax.swing.JTable();
        btn_reg = new javax.swing.JButton();

        btn_ver_compras.setText("Ver Compras");
        btn_ver_compras.setEnabled(false);
        btn_ver_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ver_comprasActionPerformed(evt);
            }
        });

        btn_ver_productos.setText("Ver Ingresos");
        btn_ver_productos.setEnabled(false);
        btn_ver_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ver_productosActionPerformed(evt);
            }
        });

        btn_modificar.setText("Modifcar");
        btn_modificar.setEnabled(false);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/find.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        t_proveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        t_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_proveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_proveedor);

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_reg.setText("Registrar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ver_compras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ver_productos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_reg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ver_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver_comprasActionPerformed
//        if (i > -1) {
//            btn_ver_compras.setEnabled(false);
//            File miDir = new File(".");
//            try {
//                c_proveedor.setRuc(t_proveedor.getValueAt(i, 0).toString());
//                System.out.println("Directorio actual: " + miDir.getCanonicalPath());
//                Map<String, Object> parametros = new HashMap<>();
//                String rpt_proveedor = c_proveedor.getRuc();
//                String path = miDir.getCanonicalPath();
//                String direccion = path + "//reports//subreports//";
//                //String direccion = path + "\\reports\\subreports\\";
//                System.out.println(direccion);
//                //    parametros.put("SUBREPORT_DIR", direccion);
//                parametros.put("proveedor", rpt_proveedor);
//                c_varios.ver_reporte("rpt_compras_proveedor", parametros);
//            } catch (IOException e) {
//                JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
//            }
//        } else {
//            JOptionPane.showInternalMessageDialog(this, "no ha seleccionado un vehiculo");
//        }

        btn_modificar.setEnabled(false);
        btn_ver_compras.setEnabled(false);
        btn_ver_productos.setEnabled(false);
    }//GEN-LAST:event_btn_ver_comprasActionPerformed

    private void btn_ver_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver_productosActionPerformed
//        if (i > -1) {
//            btn_ver_compras.setEnabled(false);
//            File miDir = new File(".");
//            try {
//                c_proveedor.setRuc(t_proveedor.getValueAt(i, 0).toString());
//                System.out.println("Directorio actual: " + miDir.getCanonicalPath());
//                Map<String, Object> parametros = new HashMap<>();
//                String rpt_proveedor = c_proveedor.getRuc();
//                String path = miDir.getCanonicalPath();
//                String direccion = path + "//reports//subreports//";
//                //String direccion = path + "\\reports\\subreports\\";
//                System.out.println(direccion);
//                //    parametros.put("SUBREPORT_DIR", direccion);
//                parametros.put("proveedor", rpt_proveedor);
//                c_varios.ver_reporte("rpt_productos_proveedor", parametros);
//            } catch (IOException e) {
//                JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
//            }
//        } else {
//            JOptionPane.showInternalMessageDialog(this, "no ha seleccionado un vehiculo");
//        }

        btn_modificar.setEnabled(false);
        btn_ver_compras.setEnabled(false);
        btn_ver_productos.setEnabled(false);
    }//GEN-LAST:event_btn_ver_productosActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
       
       if(fila>-1){
           frm_reg_proveedor.accion="modificar";
           frm_reg_proveedor.id_proveedor=Integer.parseInt(t_proveedor.getValueAt(fila,0).toString());
            frm_reg_proveedor frm_proveedor=new frm_reg_proveedor();
        c_varios.llamar_ventana_completa(frm_proveedor);
        this.dispose(); 
       } 
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txt_buscar.setText("");
        }
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        String query = "select * from proveedor "
        + "where raz_soc_pro like '%" + txt_buscar.getText() + "%' or ruc_pro like '%" + txt_buscar.getText() + "%' "
        + "order by raz_soc_pro asc ";
        c_proveedor.ver_proveedores(t_proveedor, query);
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        frm_reg_proveedor.accion="grabar";
        frm_reg_proveedor frm_proveedor=new frm_reg_proveedor();
        c_varios.llamar_ventana_completa(frm_proveedor);
        this.dispose();
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){

        }
    }//GEN-LAST:event_btn_regKeyPressed

    private void t_proveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_proveedorMouseClicked
       fila=t_proveedor.getSelectedRow();
       if(fila>-1){
          btn_modificar.setEnabled(true);
          btn_modificar.requestFocus();
       }
    }//GEN-LAST:event_t_proveedorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_modificar;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JButton btn_ver_compras;
    private javax.swing.JButton btn_ver_productos;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_proveedor;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
