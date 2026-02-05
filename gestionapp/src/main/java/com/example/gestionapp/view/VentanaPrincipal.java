package com.example.gestionapp.view;

import com.example.gestionapp.model.Pedido;
import com.example.gestionapp.service.PedidoService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Generar informe");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Salir");
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
