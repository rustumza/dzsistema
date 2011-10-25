/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaStock.java
 *
 * Created on 19/10/2011, 12:23:15
 */

package InterfacesGraficas;

import InterfacesGraficas.Reportes.ControladorReporteStock;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author rustu
 */
public class PantallaStock extends javax.swing.JFrame {


    private ControladorPantallaStock controlador;

    public PantallaStock() {
        initComponents();
    }

    public PantallaStock(ControladorPantallaStock controladorP) {
        
        this.controlador = controladorP;
        initComponents();
        this.setLocationRelativeTo(null);
        
        //toma el evento cuando cierro la pantalla, y asi puedo volver a la pantalla principal
          addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controlador.salir();
            }
        });


        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProducto = new javax.swing.JPanel();
        codigoDeBusquedaLabel = new javax.swing.JLabel();
        codigoDeBusquedaTextBox = new javax.swing.JTextField();
        buscarProducto = new javax.swing.JButton();
        codigoLabel = new javax.swing.JLabel();
        descripcionLable = new javax.swing.JLabel();
        codigoProductoEncontradoLabel = new javax.swing.JLabel();
        descripcionProductoEncontradoLAbel = new javax.swing.JLabel();
        panelStock = new javax.swing.JPanel();
        movimientoStockLabel = new javax.swing.JLabel();
        stockActualLabel = new javax.swing.JLabel();
        stockActual = new javax.swing.JLabel();
        nuevoStockTextField = new javax.swing.JTextField();
        agregarButton = new javax.swing.JButton();
        quitarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        panelUltimosMovimientos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUltimosMovimientos = new javax.swing.JTable();
        menu = new javax.swing.JMenuBar();
        reportes = new javax.swing.JMenu();
        jMenuItemStockActual = new javax.swing.JMenuItem();
        jMenuItemStockPorFecha = new javax.swing.JMenuItem();
        producto = new javax.swing.JMenu();
        menuNuevoProducto = new javax.swing.JMenuItem();
        menuModificarProducto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("C&C IT Solutions - v1.1 - Stock");
        setResizable(false);

        panelProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Producto"));

        codigoDeBusquedaLabel.setText("Código de producto");

        buscarProducto.setText("Buscar");
        buscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductoActionPerformed(evt);
            }
        });

        codigoLabel.setText("Código");

        descripcionLable.setText("Descripción");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addComponent(codigoDeBusquedaLabel)
                        .addGap(32, 32, 32)
                        .addComponent(codigoDeBusquedaTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addComponent(codigoLabel)
                        .addGap(48, 48, 48)
                        .addComponent(codigoProductoEncontradoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addComponent(descripcionLable)
                        .addGap(18, 18, 18)
                        .addComponent(descripcionProductoEncontradoLAbel, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))))
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoDeBusquedaLabel)
                    .addComponent(codigoDeBusquedaTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoLabel)
                    .addComponent(codigoProductoEncontradoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcionLable)
                    .addComponent(descripcionProductoEncontradoLAbel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelStock.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Stock"));

        movimientoStockLabel.setText("Movimientos de Stock (cantidad de cajas)");

        stockActualLabel.setText("Stock actual: ");

        nuevoStockTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoStockTextFieldActionPerformed(evt);
            }
        });

        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        quitarButton.setText("Quitar");
        quitarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");

        javax.swing.GroupLayout panelStockLayout = new javax.swing.GroupLayout(panelStock);
        panelStock.setLayout(panelStockLayout);
        panelStockLayout.setHorizontalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addComponent(movimientoStockLabel)
                        .addGap(4, 4, 4)
                        .addComponent(nuevoStockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addComponent(stockActualLabel)
                        .addGap(6, 6, 6)
                        .addComponent(stockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelStockLayout.setVerticalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStockLayout.createSequentialGroup()
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockActualLabel)
                    .addComponent(stockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movimientoStockLabel)
                    .addComponent(nuevoStockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarButton)
                    .addComponent(quitarButton)
                    .addComponent(cancelarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelUltimosMovimientos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ultimos movimientos"));

        tablaUltimosMovimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaUltimosMovimientos);

        javax.swing.GroupLayout panelUltimosMovimientosLayout = new javax.swing.GroupLayout(panelUltimosMovimientos);
        panelUltimosMovimientos.setLayout(panelUltimosMovimientosLayout);
        panelUltimosMovimientosLayout.setHorizontalGroup(
            panelUltimosMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUltimosMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelUltimosMovimientosLayout.setVerticalGroup(
            panelUltimosMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUltimosMovimientosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reportes.setText(" Reportes");

        jMenuItemStockActual.setText("Stock actual");
        jMenuItemStockActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStockActualActionPerformed(evt);
            }
        });
        reportes.add(jMenuItemStockActual);

        jMenuItemStockPorFecha.setText("Stock por fecha");
        jMenuItemStockPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStockPorFechaActionPerformed(evt);
            }
        });
        reportes.add(jMenuItemStockPorFecha);

        menu.add(reportes);

        producto.setText("producto");

        menuNuevoProducto.setText("Nuevo Producto");
        menuNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoProductoActionPerformed(evt);
            }
        });
        producto.add(menuNuevoProducto);

        menuModificarProducto.setText("Modificar Producto");
        menuModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarProductoActionPerformed(evt);
            }
        });
        producto.add(menuModificarProducto);

        menu.add(producto);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUltimosMovimientos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelUltimosMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public void setAgregarButton(JButton agregarButton) {
        this.agregarButton = agregarButton;
    }

    public JButton getBuscarProducto() {
        return buscarProducto;
    }

    public void setBuscarProducto(JButton buscarProducto) {
        this.buscarProducto = buscarProducto;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public void setCancelarButton(JButton cancelarButton) {
        this.cancelarButton = cancelarButton;
    }

    public JLabel getCodigoDeBusquedaLabel() {
        return codigoDeBusquedaLabel;
    }

    public void setCodigoDeBusquedaLabel(JLabel codigoDeBusquedaLabel) {
        this.codigoDeBusquedaLabel = codigoDeBusquedaLabel;
    }

    public JTextField getCodigoDeBusquedaTextBox() {
        return codigoDeBusquedaTextBox;
    }

    public void setCodigoDeBusquedaTextBox(JTextField codigoDeBusquedaTextBox) {
        this.codigoDeBusquedaTextBox = codigoDeBusquedaTextBox;
    }

    public JLabel getCodigoLabel() {
        return codigoLabel;
    }

    public void setCodigoLabel(JLabel codigoLabel) {
        this.codigoLabel = codigoLabel;
    }

    public JLabel getCodigoProductoEncontradoLabel() {
        return codigoProductoEncontradoLabel;
    }

    public void setCodigoProductoEncontradoLabel(JLabel codigoProductoEncontradoLabel) {
        this.codigoProductoEncontradoLabel = codigoProductoEncontradoLabel;
    }

    public ControladorPantallaStock getControlador() {
        return controlador;
    }

    public void setControlador(ControladorPantallaStock controlador) {
        this.controlador = controlador;
    }

    public JLabel getDescripcionLable() {
        return descripcionLable;
    }

    public void setDescripcionLable(JLabel descripcionLable) {
        this.descripcionLable = descripcionLable;
    }

    public JLabel getDescripcionProductoEncontradoLAbel() {
        return descripcionProductoEncontradoLAbel;
    }

    public void setDescripcionProductoEncontradoLAbel(JLabel descripcionProductoEncontradoLAbel) {
        this.descripcionProductoEncontradoLAbel = descripcionProductoEncontradoLAbel;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JLabel getMovimientoStockLabel() {
        return movimientoStockLabel;
    }

    public void setMovimientoStockLabel(JLabel movimientoStockLabel) {
        this.movimientoStockLabel = movimientoStockLabel;
    }

    public JTextField getNuevoStockTextField() {
        return nuevoStockTextField;
    }

    public void setNuevoStockTextField(JTextField nuevoStockTextField) {
        this.nuevoStockTextField = nuevoStockTextField;
    }

    public JPanel getPanelProducto() {
        return panelProducto;
    }

    public void setPanelProducto(JPanel panelProducto) {
        this.panelProducto = panelProducto;
    }

    public JPanel getPanelStock() {
        return panelStock;
    }

    public void setPanelStock(JPanel panelStock) {
        this.panelStock = panelStock;
    }

    public JPanel getPanelUltimosMovimientos() {
        return panelUltimosMovimientos;
    }

    public void setPanelUltimosMovimientos(JPanel panelUltimosMovimientos) {
        this.panelUltimosMovimientos = panelUltimosMovimientos;
    }

    public JMenu getProducto() {
        return producto;
    }

    public void setProducto(JMenu producto) {
        this.producto = producto;
    }

    public JButton getQuitarButton() {
        return quitarButton;
    }

    public void setQuitarButton(JButton quitarButton) {
        this.quitarButton = quitarButton;
    }

    public JMenu getReportes() {
        return reportes;
    }

    public void setReportes(JMenu reportes) {
        this.reportes = reportes;
    }

    public JLabel getStockActual() {
        return stockActual;
    }

    public void setStockActual(JLabel stockActual) {
        this.stockActual = stockActual;
    }

    public JLabel getStockActualLabel() {
        return stockActualLabel;
    }

    public void setStockActualLabel(JLabel stockActualLabel) {
        this.stockActualLabel = stockActualLabel;
    }

    public JTable getTablaUltimosMovimientos() {
        return tablaUltimosMovimientos;
    }

    public void setTablaUltimosMovimientos(JTable tablaUltimosMovimientos) {
        this.tablaUltimosMovimientos = tablaUltimosMovimientos;
    }

    private void nuevoStockTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoStockTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoStockTextFieldActionPerformed

    private void buscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductoActionPerformed
        controlador.buscarProducto();
    }//GEN-LAST:event_buscarProductoActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        controlador.agregarStock();
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void quitarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarButtonActionPerformed
        controlador.restarStock();
    }//GEN-LAST:event_quitarButtonActionPerformed

    private void menuModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarProductoActionPerformed
       PantallaABMProducto iu = new PantallaABMProducto();
       iu.setVisible(true);
    }//GEN-LAST:event_menuModificarProductoActionPerformed

    private void menuNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoProductoActionPerformed
        PantallaAltaModificacionProducto iu = new PantallaAltaModificacionProducto();
        iu.setVisible(true);
    }//GEN-LAST:event_menuNuevoProductoActionPerformed

    private void jMenuItemStockPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStockPorFechaActionPerformed
        ControladorReporteStock controladorReporte = new ControladorReporteStock();
        controladorReporte.iniciarPantallaSeleccionarFecha();
    }//GEN-LAST:event_jMenuItemStockPorFechaActionPerformed

    private void jMenuItemStockActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStockActualActionPerformed
        ControladorReporteStock controladorReporte = new ControladorReporteStock();
        controladorReporte.iniciarPantalla();
    }//GEN-LAST:event_jMenuItemStockActualActionPerformed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaStock().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton buscarProducto;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel codigoDeBusquedaLabel;
    private javax.swing.JTextField codigoDeBusquedaTextBox;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JLabel codigoProductoEncontradoLabel;
    private javax.swing.JLabel descripcionLable;
    private javax.swing.JLabel descripcionProductoEncontradoLAbel;
    private javax.swing.JMenuItem jMenuItemStockActual;
    private javax.swing.JMenuItem jMenuItemStockPorFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuModificarProducto;
    private javax.swing.JMenuItem menuNuevoProducto;
    private javax.swing.JLabel movimientoStockLabel;
    private javax.swing.JTextField nuevoStockTextField;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JPanel panelStock;
    private javax.swing.JPanel panelUltimosMovimientos;
    private javax.swing.JMenu producto;
    private javax.swing.JButton quitarButton;
    private javax.swing.JMenu reportes;
    private javax.swing.JLabel stockActual;
    private javax.swing.JLabel stockActualLabel;
    private javax.swing.JTable tablaUltimosMovimientos;
    // End of variables declaration//GEN-END:variables

}
