/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaPreciosHistoricos.java
 *
 * Created on 10/04/2011, 20:48:12
 */

package InterfacesGraficas;

import Negocio.ABM.ControladorABMProducto;
import Negocio.Entidades.PrecioHistorico;
import Negocio.Entidades.PrecioHistoricoJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juampa
 */
public class PantallaPreciosHistoricos extends javax.swing.JFrame {
    private Producto producto;
    private PrecioHistorico precioAModificar;
    private ControladorABMProducto controlador;

    /** Creates new form PantallaPreciosHistoricos */
    public PantallaPreciosHistoricos() {
        initComponents();
    }

    public PantallaPreciosHistoricos(Producto productoAModificar, ControladorABMProducto controladorABM) {
        initComponents();
        this.setLocationRelativeTo(null);
        producto = productoAModificar;
        controlador = controladorABM;
        CargarTabla();
    }

    public void CargarTabla() {
        try {

            Object[][] datos = null;

            datos = new Object[producto.getPreciosHistoricos().size()][2];
            for (int i = 0; i < producto.getPreciosHistoricos().size(); i++) {
                String strDate = new SimpleDateFormat("EEEE dd/MM/yyyy").format(producto.getPreciosHistoricos().get(i).getFechaDesdeQueEntroEnVigencia());
                datos[i][0] =  strDate;
                datos[i][1] = producto.getPreciosHistoricos().get(i).getPrecio();
            }

            String[] columnNames = {"Fecha", "Precio Unitario"};
            jTablePrecios.setModel(new DefaultTableModel(datos, columnNames) {

                boolean[] canEdit = new boolean[]{
                    true, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

        } catch (NullPointerException e) {
        }


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrecios = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Precios");

        jTablePrecios.setAutoCreateRowSorter(true);
        jTablePrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Precio Unitario"
            }
        ));
        jTablePrecios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePreciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePrecios);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("Eliminar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButton3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePreciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePreciosMouseClicked
        // TODO add your handling code here:
        int seleccion = jTablePrecios.getSelectedRow();
        precioAModificar = producto.getPreciosHistoricos().get(seleccion);
}//GEN-LAST:event_jTablePreciosMouseClicked

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:
        //TO DO
        if (jTablePrecios.getSelectedRow() != -1) {
            if(producto.getPreciosHistoricos().size()>1){
                for(int i=0;i<jTablePrecios.getRowCount();i++){
                    if(jTablePrecios.isRowSelected(i)){
                        //Destruyo elemento
                        PrecioHistoricoJpaController fachada1 = new PrecioHistoricoJpaController();
                        try {
                            fachada1.destroy(producto.getPreciosHistoricos().get(i).getId());
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(PantallaPreciosHistoricos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //Quito elemento de la lista
                        producto.getPreciosHistoricos().remove(i);
                        ProductoJpaController fachada = new ProductoJpaController();
                        try {
                            fachada.edit(producto);
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(PantallaPreciosHistoricos.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(PantallaPreciosHistoricos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null, "Precio Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No puede eliminar el precio", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione un Precio para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        CargarTabla();
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
        PantallaAltaModificacionPrecio iu = new PantallaAltaModificacionPrecio(producto);
        iu.setGUI(this);
        iu.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPreciosHistoricos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrecios;
    // End of variables declaration//GEN-END:variables

}
