/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import clases.cl_conectar;
import clases.cl_detalle_ingreso;
import clases.cl_ingreso;
import clases.cl_productos;
import clases.cl_proveedor;
import clases.cl_varios;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.Notification;
import objetos.cl_llenar_combobox;
import objetos.cla_producto;
import objetos.o_combobox;
import vistas.frm_ver_ingresos;

/**
 *
 * @author luis
 */
public class frm_reg_ingreso extends javax.swing.JInternalFrame {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    cl_ingreso c_ingreso = new cl_ingreso();
    cl_detalle_ingreso c_detalle = new cl_detalle_ingreso();
    cl_proveedor c_proveedor = new cl_proveedor();
    cl_productos c_producto = new cl_productos();

    cl_llenar_combobox m_combobox = new cl_llenar_combobox();

    DefaultTableModel detalle;
    TextAutoCompleter tac_productos = null;

    int fila_seleccionada;
    int id_usuario = 1;

    /**
     * Creates new form frm_reg_ingreso
     */
    public frm_reg_ingreso() {
        initComponents();
        txt_fecha.setText(c_varios.formato_fecha_vista(c_varios.getFechaActual()));
        txt_fecha.requestFocus();
        m_combobox.verTodosDocumentosSunat(cbx_tido);
        modelo_ingreso();
    }

    private void modelo_ingreso() {
        //formato de tabla detalle de venta
        detalle = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        detalle.addColumn("Id");
        detalle.addColumn("Producto");
        detalle.addColumn("Marca");
        detalle.addColumn("Cant.");
        detalle.addColumn("Costo");
        detalle.addColumn("Parcial");
        t_detalle.setModel(detalle);
        t_detalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        t_detalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        t_detalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        t_detalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        t_detalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        t_detalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        c_varios.centrar_celda(t_detalle, 0);
        c_varios.centrar_celda(t_detalle, 2);
        c_varios.derecha_celda(t_detalle, 3);
        c_varios.derecha_celda(t_detalle, 4);
        c_varios.derecha_celda(t_detalle, 5);
    }

    private void cargar_productos() {
        try {
            if (tac_productos != null) {
                tac_productos.removeAllItems();
            }
            tac_productos = new TextAutoCompleter(txt_buscar_productos, new AutoCompleterCallback() {
                @Override
                public void callback(Object selectedItem) {
                    Object itemSelected = selectedItem;
                    c_producto.setId_producto(0);
                    if (itemSelected instanceof cla_producto) {
                        int pcodigo = ((cla_producto) itemSelected).getId();
                        String pnombre = ((cla_producto) itemSelected).getNombre();
                        System.out.println("producto seleccionado " + pnombre);
                        c_producto.setId_producto(pcodigo);
                    } else {
                        System.out.println("El item es de un tipo desconocido");
                    }
                }
            });

            tac_productos.setMode(0);
            tac_productos.setCaseSensitive(false);
            Statement st = c_conectar.conexion();
            String sql = "select * from insumos";
            ResultSet rs = c_conectar.consulta(st, sql);
            while (rs.next()) {
                int id_producto = rs.getInt("idinsumo");
                String descripcion = rs.getString("descripcion")
                        + "    |    Cantidad: S/ " + c_varios.formato_numero(rs.getDouble("cant_actual")) + "    |    Costo: S/ " + c_varios.formato_numero(rs.getDouble("costo_cigv"));
                tac_productos.addItem(new cla_producto(id_producto, descripcion));
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getLocalizedMessage());
            System.out.println(e.getLocalizedMessage());
        }
    }

    private boolean valida_tabla(int producto) {
        //estado de ingreso
        boolean ingresar = false;
        int cuenta_iguales = 0;

        //verificar fila no se repite
        int contar_filas = t_detalle.getRowCount();
        if (contar_filas == 0) {
            ingresar = true;
        }

        if (contar_filas > 0) {
            for (int j = 0; j < contar_filas; j++) {
                int id_producto_fila = Integer.parseInt(t_detalle.getValueAt(j, 0).toString());
                if (producto == id_producto_fila) {
                    ingresar = false;
                    cuenta_iguales++;
                    JOptionPane.showMessageDialog(null, "El Producto a Ingresar ya existe en la lista");
                } else {
                    ingresar = true;
                }
            }
        }

        if (cuenta_iguales == 0) {
            ingresar = true;
        }
        return ingresar;
    }

    private void limpiar_buscar() {
        txt_buscar_productos.setText("");
        txt_cingreso.setText("");
        txt_cactual.setText("");
        txt_costo.setText("");
        txt_cingreso.setEnabled(false);
        txt_cactual.setEnabled(false);
        txt_costo.setEnabled(false);
        btn_agregar_producto.setEnabled(true);
        txt_buscar_productos.requestFocus();
    }

    private double calcular_total() {
        double total = 0;
        int contar_filas = t_detalle.getRowCount();
        for (int i = 0; i < contar_filas; i++) {
            total = total + Double.parseDouble(t_detalle.getValueAt(i, 6).toString());
        }
        c_ingreso.setTotal(total);
        lbl_total.setText("S/ " + c_varios.formato_totales(total));
        return total;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_serie = new javax.swing.JTextField();
        cbx_tido = new javax.swing.JComboBox<>();
        txt_fecha = new javax.swing.JFormattedTextField();
        txt_numero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ruc_proveedor = new javax.swing.JTextField();
        btn_buscar_proveedor = new javax.swing.JButton();
        btn_add_proveedor = new javax.swing.JButton();
        txt_razon_social = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_buscar_productos = new javax.swing.JTextField();
        btn_add_producto = new javax.swing.JButton();
        txt_cactual = new javax.swing.JTextField();
        txt_cingreso = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();
        btn_agregar_producto = new javax.swing.JButton();
        btn_recargar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_detalle = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btn_guardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_salir = new javax.swing.JButton();

        setTitle("Reg. Documento de Ingreso de Mercaderia");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Documento"));

        jLabel1.setText("Fecha:");

        jLabel2.setText("Documento:");

        jLabel3.setText("Serie - Numero:");

        txt_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_serie.setEnabled(false);
        txt_serie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_serieKeyPressed(evt);
            }
        });

        cbx_tido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOLETA", "FACTURA", "GUIA REMISION", "NOTA DE INGRESO" }));
        cbx_tido.setEnabled(false);
        cbx_tido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_tidoKeyPressed(evt);
            }
        });

        try {
            txt_fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fechaKeyPressed(evt);
            }
        });

        txt_numero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero.setEnabled(false);
        txt_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_numeroKeyPressed(evt);
            }
        });

        jLabel4.setText("Proveedor:");

        txt_ruc_proveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc_proveedor.setEnabled(false);
        txt_ruc_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ruc_proveedorActionPerformed(evt);
            }
        });
        txt_ruc_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ruc_proveedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ruc_proveedorKeyTyped(evt);
            }
        });

        btn_buscar_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/find.png"))); // NOI18N
        btn_buscar_proveedor.setToolTipText("Buscar Proveedor");
        btn_buscar_proveedor.setEnabled(false);

        btn_add_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_add_proveedor.setToolTipText("agregar Proveedor");
        btn_add_proveedor.setEnabled(false);
        btn_add_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_proveedorActionPerformed(evt);
            }
        });

        txt_razon_social.setEnabled(false);

        lbl_total.setFont(new java.awt.Font("Ubuntu Condensed", 1, 36)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("S/ 0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txt_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_numero, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addComponent(txt_fecha)
                                .addComponent(cbx_tido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_razon_social, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ruc_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_add_proveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscar_proveedor)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_add_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_buscar_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ruc_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Productos"));

        jLabel8.setText("Producto:");

        jLabel9.setText("C. Actual: ");

        jLabel10.setText("Cantidad:");

        txt_buscar_productos.setEnabled(false);
        txt_buscar_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscar_productosKeyPressed(evt);
            }
        });

        btn_add_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btn_add_producto.setToolTipText("agregar Producto");
        btn_add_producto.setEnabled(false);
        btn_add_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_productoActionPerformed(evt);
            }
        });

        txt_cactual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_cactual.setEnabled(false);

        txt_cingreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_cingreso.setEnabled(false);
        txt_cingreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cingresoKeyPressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Costo:");

        txt_costo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_costo.setEnabled(false);
        txt_costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_costoKeyPressed(evt);
            }
        });

        btn_agregar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/accept.png"))); // NOI18N
        btn_agregar_producto.setText("Agregar");
        btn_agregar_producto.setEnabled(false);
        btn_agregar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_productoActionPerformed(evt);
            }
        });

        btn_recargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/arrow_redo.png"))); // NOI18N
        btn_recargar.setEnabled(false);
        btn_recargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_recargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cactual, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_agregar_producto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_recargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add_producto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_buscar_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_recargar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cactual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_agregar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos a Ingresar"));

        t_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "GUITARRA ACUSTICA | XAMFER", "AUIONET", "15.00", "160.00", "190.00", "2850.00"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID.", "Producto", "Marca", "Cant.", "Costo", "Precio", "Parcial"
            }
        ));
        t_detalle.setShowVerticalLines(false);
        t_detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_detalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_detalle);
        if (t_detalle.getColumnModel().getColumnCount() > 0) {
            t_detalle.getColumnModel().getColumn(0).setPreferredWidth(40);
            t_detalle.getColumnModel().getColumn(1).setPreferredWidth(400);
            t_detalle.getColumnModel().getColumn(2).setPreferredWidth(150);
            t_detalle.getColumnModel().getColumn(3).setPreferredWidth(60);
            t_detalle.getColumnModel().getColumn(4).setPreferredWidth(60);
            t_detalle.getColumnModel().getColumn(5).setPreferredWidth(60);
            t_detalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cross.png"))); // NOI18N
        jButton7.setText("Eliminar Producto");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Filas:");

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("1");

        jToolBar1.setFloatable(false);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/accept.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setEnabled(false);
        btn_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_guardar);
        jToolBar1.add(jSeparator1);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.setFocusable(false);
        btn_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_salir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(361, 361, 361)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
        frm_ver_ingresos formulario = new frm_ver_ingresos();
        c_varios.llamar_ventana(formulario);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void txt_fechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fechaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_fecha.getText().length() == 10) {
                cbx_tido.setEnabled(true);
                cbx_tido.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_fechaKeyPressed

    private void cbx_tidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_tidoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            o_combobox cla_tido = (o_combobox) cbx_tido.getSelectedItem();
            c_ingreso.setId_documento(cla_tido.getId());
            txt_serie.setEnabled(true);
            txt_serie.requestFocus();
        }
    }//GEN-LAST:event_cbx_tidoKeyPressed

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
                txt_ruc_proveedor.setEnabled(true);
                btn_add_proveedor.setEnabled(true);
                btn_buscar_proveedor.setEnabled(true);
                txt_ruc_proveedor.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_numeroKeyPressed

    private void txt_ruc_proveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ruc_proveedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_ruc_proveedor.getText().length() == 11) {
                c_proveedor.setNum_documento(txt_ruc_proveedor.getText());
                boolean existe = c_proveedor.buscarRUC();
                if (existe) {
                    //validar documento
                    c_ingreso.setId_proveedor(c_proveedor.getId_proveedor());
                    c_ingreso.setSerie(txt_serie.getText());
                    c_ingreso.setNumero(Integer.parseInt(txt_numero.getText()));
                    boolean existe_documento = c_ingreso.comprobar_documento();
                    if (existe_documento) {
                        JOptionPane.showMessageDialog(null, "ESTE DOCUMENTO YA ESTA INGRESADO, SALIR DE LA VENTANA");
                        btn_salir.doClick();
                    } else //cargar datos de proveedor
                    {
                        c_proveedor.obtener_datos();
                    }
                    txt_razon_social.setText(c_proveedor.getRazon_social());
                    txt_buscar_productos.setEnabled(true);
                    txt_buscar_productos.requestFocus();
                } else {
                    /*Frame f = JOptionPane.getRootFrame();
                    frm_reg_proveedor dialog = new frm_reg_proveedor(f, true);
                    frm_reg_proveedor.txt_ndoc.setText(c_proveedor.getRuc());
                    frm_reg_proveedor.accion = "registrar";
                    frm_reg_proveedor.origen = "reg_ingreso";
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);*/
                
                }

            }
        }
    }//GEN-LAST:event_txt_ruc_proveedorKeyPressed

    private void txt_ruc_proveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ruc_proveedorKeyTyped
        c_varios.limitar_caracteres(evt, txt_ruc_proveedor, 11);
        c_varios.solo_numeros(evt);
    }//GEN-LAST:event_txt_ruc_proveedorKeyTyped

    private void txt_buscar_productosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_productosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_buscar_productos.getText().length() > 25) {
                if (c_producto.obtener_datos()) {
                    //validar que no existe en la tabla
                    if (valida_tabla(c_producto.getId_producto())) {
                        txt_costo.setText(c_varios.formato_numero(c_producto.getCosto()));
                        txt_cactual.setText(c_producto.getCan_actual()+ "");
                        txt_cingreso.setText("1");
                        txt_cingreso.setEnabled(true);
                        txt_cingreso.requestFocus();
                    } else {
                        c_producto.setId_producto(0);
                        limpiar_buscar();
                        JOptionPane.showMessageDialog(null, "ESTE PRODUCTO YA ESTA SELECCIONADO");
                    }
                } else {
                    c_producto.setId_producto(0);
                    limpiar_buscar();
                    JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR PRODUCTO");
                }
            }

            if (txt_buscar_productos.getText().length() == 0) {
                //si nro de filas es mayor a 0 entonces ir a datos generales
                int contar_filas = t_detalle.getRowCount();
                if (contar_filas > 0) {
                    btn_guardar.setEnabled(true);
                    btn_guardar.requestFocus();
                }
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            limpiar_buscar();
        }
    }//GEN-LAST:event_txt_buscar_productosKeyPressed

    private void txt_cingresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cingresoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String tcantidad = txt_cingreso.getText();
            if (c_varios.isNumeric(tcantidad)) {
                txt_costo.setEnabled(true);
                txt_costo.selectAll();
                txt_costo.requestFocus();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            limpiar_buscar();
        }
    }//GEN-LAST:event_txt_cingresoKeyPressed

    private void txt_costoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String tcosto = txt_costo.getText();
            if (c_varios.esDecimal(tcosto)) {
                double dcosto = Double.parseDouble(tcosto);
                if (dcosto > 0) {
                    txt_cingreso.setEnabled(true);
                    txt_cingreso.selectAll();
                    txt_cingreso.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "COSTO NO PUEDE SER CERO (0)");
                    txt_costo.selectAll();
                    txt_costo.requestFocus();
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            limpiar_buscar();
        }
    }//GEN-LAST:event_txt_costoKeyPressed

    private void btn_agregar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_productoActionPerformed
        double costo = Double.parseDouble(txt_costo.getText());
        int cantidad = Integer.parseInt(txt_cingreso.getText());
        double parcial = costo * cantidad;
        Object fila[] = new Object[5];
        fila[0] = c_producto.getId_producto();
        fila[1] = c_producto.getDescripcion();
        fila[2] = cantidad;
        fila[3] = c_varios.formato_numero(costo);
        fila[4] = c_varios.formato_numero(parcial);

        detalle.addRow(fila);
        calcular_total();
        limpiar_buscar();
        // btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_agregar_productoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de Guardar el ingreso de Mercaderia?");

        if (JOptionPane.OK_OPTION == confirmado) {
            c_ingreso.setFecha(c_varios.formato_fecha_mysql(txt_fecha.getText()));
            c_ingreso.setId_proveedor(c_proveedor.getId_proveedor());
            c_ingreso.setId_usuario(id_usuario);
            c_ingreso.setSerie(txt_serie.getText());
            c_ingreso.setNumero(Integer.parseInt(txt_numero.getText()));
            c_ingreso.obtener_codigo();

            boolean registrado = c_ingreso.insertar();

            c_detalle.setId_ingreso(c_ingreso.getId_ingreso());
            if (registrado) {
                int nro_filas = t_detalle.getRowCount();
                for (int i = 0; i < nro_filas; i++) {
                    c_detalle.setId_insumo(Integer.parseInt(t_detalle.getValueAt(i, 0).toString()));
                    c_detalle.setCantidad(Integer.parseInt(t_detalle.getValueAt(i, 3).toString()));
                    c_detalle.setCosto(Double.parseDouble(t_detalle.getValueAt(i, 4).toString()));

                    c_detalle.insertar();
                }

                Notification.show("Ingreso de Mercaderia", "se guardo correctamente");
                frm_ver_ingresos formulario = new frm_ver_ingresos();
                c_varios.llamar_ventana(formulario);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_add_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_proveedorActionPerformed
    /*    Frame f = JOptionPane.getRootFrame();
        frm_reg_proveedor dialog = new frm_reg_proveedor(f, true);
        frm_reg_proveedor.txt_ndoc.setText(c_proveedor.getRuc());
        frm_reg_proveedor.accion = "registrar";
        frm_reg_proveedor.origen = "reg_ingreso";
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
*/
    }//GEN-LAST:event_btn_add_proveedorActionPerformed

    private void btn_add_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_productoActionPerformed
    /*    Frame f = JOptionPane.getRootFrame();
        frm_reg_producto.registrar = true;
        frm_reg_producto dialog = new frm_reg_producto(f, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
*/
    }//GEN-LAST:event_btn_add_productoActionPerformed

    private void btn_recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_recargarActionPerformed
        cargar_productos();
        txt_buscar_productos.requestFocus();
    }//GEN-LAST:event_btn_recargarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        detalle.removeRow(fila_seleccionada);
        calcular_total();
        txt_buscar_productos.requestFocus();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void t_detalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_detalleMouseClicked
        if (evt.getClickCount() == 2) {
            fila_seleccionada = t_detalle.getSelectedRow();
            jButton7.setEnabled(true);
        }
    }//GEN-LAST:event_t_detalleMouseClicked

    private void txt_ruc_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ruc_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ruc_proveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_producto;
    private javax.swing.JButton btn_add_proveedor;
    private javax.swing.JButton btn_agregar_producto;
    private javax.swing.JButton btn_buscar_proveedor;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_recargar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cbx_tido;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable t_detalle;
    private javax.swing.JTextField txt_buscar_productos;
    private javax.swing.JTextField txt_cactual;
    private javax.swing.JTextField txt_cingreso;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JFormattedTextField txt_fecha;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_razon_social;
    private javax.swing.JTextField txt_ruc_proveedor;
    private javax.swing.JTextField txt_serie;
    // End of variables declaration//GEN-END:variables
}
