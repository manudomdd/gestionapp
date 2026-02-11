package com.example.gestionapp.view;

import com.example.gestionapp.model.Pedido;
import com.example.gestionapp.service.PedidoService;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
    private final PedidoService pedidoService;
    public final String[] TABLE_HEADERS = {"ID", "Producto", "Categoria", "Precio unitario", "Cantidad", "Fecha"}; 
    public DefaultTableModel model; 

    public VentanaPrincipal(PedidoService pedidoService) {
        this.pedidoService = pedidoService; 
        initComponents();
        initFunctions(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Menu");

        jMenuItem1.setText("Nuevo pedido");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ver pedidos");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Generar informe");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NuevoPedido nuevoPedido = new NuevoPedido(this, true, this.pedidoService); 
        nuevoPedido.setLocationRelativeTo(null);
        nuevoPedido.setVisible(true); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        String[] opciones = {"Todos", "Electronica", "Hogar", "Ropa", "Juguetes", "Alimentacion", "Otros"};

        String seleccion = (String) javax.swing.JOptionPane.showInputDialog(
                this,         
                "Selecciona una categoría para filtrar:", 
                "Filtrar Pedidos",             
                javax.swing.JOptionPane.QUESTION_MESSAGE, 
                null,                            
                opciones,                        
                opciones[0]);                    

        if (seleccion != null) {

            List<Pedido> listaFiltrada;

            if (seleccion.equals("Todos")) {
                listaFiltrada = pedidoService.listarTodos();
                for (Pedido p : listaFiltrada) {
                    Object[] row = {
                        p.getId_pedido(),
                        p.getProducto(),
                        p.getCategoria(),
                        p.getPrecioUnitario(),
                        p.getCantidad(),
                        p.getFechaPedido()
                    };
                    model.addRow(row);
                }
            } else {
                listaFiltrada = pedidoService.listarPorCategoria(seleccion);
            }

            model.setRowCount(0);

            if (listaFiltrada.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontraron pedidos en esta categoría.");
            } else {
                for (Pedido p : listaFiltrada) {
                    Object[] row = {
                        p.getId_pedido(),
                        p.getProducto(),
                        p.getCategoria(),
                        p.getPrecioUnitario(),
                        p.getCantidad(),
                        p.getFechaPedido()
                    };
                    model.addRow(row);
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                this, 
                "¿Estás seguro de que quieres salir de la aplicación?", 
                "Cerrar Aplicación", 
                javax.swing.JOptionPane.YES_NO_OPTION, 
                javax.swing.JOptionPane.QUESTION_MESSAGE
        );


        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            java.util.List<Pedido> listaPedidos = pedidoService.listarTodos();

            if (listaPedidos.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No hay pedidos para generar el reporte.");
                return;
            }

            listaPedidos.sort((p1, p2) -> p1.getCategoria().compareToIgnoreCase(p2.getCategoria()));

            java.io.InputStream reporteStream = getClass().getResourceAsStream("/pedidos_report.jrxml.xml");
            if (reporteStream == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encuentra el archivo pedidos_report.jrxml");
                return;
            }

            net.sf.jasperreports.engine.JasperReport reporteCompilado = 
                net.sf.jasperreports.engine.JasperCompileManager.compileReport(reporteStream);

            java.util.Map<String, Object> parametros = new java.util.HashMap<>();
            parametros.put("fechaInicio", new java.util.Date());
            parametros.put("fechaFin", new java.util.Date());
            parametros.put("categoriaFiltro", "Todas");

            net.sf.jasperreports.engine.data.JRBeanCollectionDataSource dataSource = 
                new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(listaPedidos);
            
            net.sf.jasperreports.engine.JasperPrint jasperPrint = 
                net.sf.jasperreports.engine.JasperFillManager.fillReport(reporteCompilado, parametros, dataSource);

            net.sf.jasperreports.view.JasperViewer viewer = 
                new net.sf.jasperreports.view.JasperViewer(jasperPrint, false);
            
            viewer.setTitle("Reporte de Pedidos");
            viewer.setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void initFunctions() {
        centerScreen(); 
        initTable(); 
        loadTable(); 
    }
    
    private void centerScreen() {
        this.setLocationRelativeTo(null);
    }
    
    private void initTable() {
        model = new DefaultTableModel(TABLE_HEADERS, 6); 
        jTable1.setModel(model); 
    }
    
    public void loadTable() {
        List<Pedido> lista = pedidoService.listarTodos();
        model.setRowCount(0);
        
        for (Pedido p : lista) {
            Object[] row = {p.getId_pedido(), p.getProducto(), p.getCategoria(), p.getPrecioUnitario(), p.getCantidad(), p.getFechaPedido()}; 
            model.addRow(row);
        }
    }
    
    public void addToTable(Object[] row) {
        model.addRow(row);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
