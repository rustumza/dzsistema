/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaABMCliente.java
 *
 * Created on 06/04/2011, 10:09:32
 */

package InterfacesGraficas;

import Negocio.ABM.ControladorABMProducto;
import Negocio.Entidades.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import validar.Validar;
/**
 *
 * @author rustu
 */
public class PantallaABMProducto extends javax.swing.JFrame {

    ControladorABMProducto controlador = new ControladorABMProducto();
    List<Producto> listaProductos;
    Producto productoAModificar;
    PantallaAltaModificacionProducto amp;

    /** Creates new form PantallaABMCliente */
    public PantallaABMProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        listaProductos = controlador.ObtenerProductos();
        CargarTabla();
    }

    //Muestra todos los afiliados en tabla
    public void CargarTabla() {
        try {

            Object[][] datos = null;

            datos = new Object[listaProductos.size()][3];
            for (int i = 0; i < listaProductos.size(); i++) {
                datos[i][0] = listaProductos.get(i).getCodigo();
                datos[i][1] = listaProductos.get(i).getDescripcion();
                datos[i][2] = listaProductos.get(i).getPorcentajeDeIva();
            }

            String[] columnNames = {"Código", "Nombre", "IVA"};
            jTableProductos.setModel(new DefaultTableModel(datos, columnNames) {

                boolean[] canEdit = new boolean[]{
                    true, true, true
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
        jTableProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jButtonbuscarTodos = new javax.swing.JButton();
        jButtonBuscarCodigo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonBuscarNombre = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonElimiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonVerPrecios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Productos");
        setResizable(false);

        jTableProductos.setAutoCreateRowSorter(true);
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "IVA"
            }
        ));
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Código");

        jTextFieldCodigo.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jButtonbuscarTodos.setText("Todos");
        jButtonbuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbuscarTodosActionPerformed(evt);
            }
        });

        jButtonBuscarCodigo.setText("Buscar");
        jButtonBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCodigoActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre");

        jTextFieldNombre.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jButtonBuscarNombre.setText("Buscar");
        jButtonBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarCodigo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarNombre)))
                .addGap(155, 155, 155)
                .addComponent(jButtonbuscarTodos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarNombre)
                    .addComponent(jButtonbuscarTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonElimiar.setText("Dar de Baja");
        jButtonElimiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimiarActionPerformed(evt);
            }
        });

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonVerPrecios.setText("Ver Precios");
        jButtonVerPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerPreciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonElimiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVerPrecios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevo)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonElimiar)
                    .addComponent(jButton1)
                    .addComponent(jButtonVerPrecios)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        // TODO add your handling code here:
        int seleccion = jTableProductos.getSelectedRow();
        productoAModificar = listaProductos.get(seleccion);
}//GEN-LAST:event_jTableProductosMouseClicked

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
        if (jTextFieldCodigo.getText().isEmpty() == false){
            if(Validar.controlCodigo(jTextFieldCodigo.getText())){
                listaProductos = controlador.buscarProductoPorCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
                CargarTabla();
                limpiarFields();
            } else{
                JOptionPane.showMessageDialog(null, "El Código ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un Código válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jButtonbuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbuscarTodosActionPerformed
        // TODO add your handling code here:
        listaProductos = controlador.ObtenerProductos();
        CargarTabla();
}//GEN-LAST:event_jButtonbuscarTodosActionPerformed

    private void jButtonBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCodigoActionPerformed
        // TODO add your handling code here:
        if (jTextFieldCodigo.getText().isEmpty() == false){
            if(Validar.controlCodigo(jTextFieldCodigo.getText())){
                listaProductos = controlador.buscarProductoPorCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
                CargarTabla();
                limpiarFields();
            } else{
                JOptionPane.showMessageDialog(null, "El Código ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un Código válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_jButtonBuscarCodigoActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNombre.getText().isEmpty() == false){
            if(Validar.controlCodigo(jTextFieldNombre.getText())){
                listaProductos = controlador.buscarProductoPorNombre(jTextFieldCodigo.getText());
                CargarTabla();
                limpiarFields();
            } else{
                JOptionPane.showMessageDialog(null, "El Nombre ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un Nombre válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarNombreActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNombre.getText().isEmpty() == false){
            if(Validar.controlApellido(jTextFieldNombre.getText())){
                listaProductos = controlador.buscarProductoPorNombre(jTextFieldCodigo.getText());
                CargarTabla();
                limpiarFields();
            } else{
                JOptionPane.showMessageDialog(null, "El Nombre ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un Nombre válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscarNombreActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        // TODO add your handling code here:
        amp = new PantallaAltaModificacionProducto(this.controlador);
        amp.setGUI(this);
        amp.setVisible(true);
}//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        if (jTableProductos.getSelectedRow() != -1) {
            amp = new PantallaAltaModificacionProducto(this.controlador);
            amp.setGUI(this);
            amp.modificarProducto(productoAModificar);
            amp.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione un Producto para modificar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        listaProductos = controlador.ObtenerProductos();
        CargarTabla();
}//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonElimiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimiarActionPerformed
        if (jTableProductos.getSelectedRow() != -1) {
            for(int i=0;i<jTableProductos.getRowCount();i++){
                if(jTableProductos.isRowSelected(i)){
                        productoAModificar = listaProductos.get(i);
                        controlador.bajaProducto(productoAModificar);
                }
            }
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione un Producto para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        listaProductos = controlador.ObtenerProductos();
        CargarTabla();
}//GEN-LAST:event_jButtonElimiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonVerPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerPreciosActionPerformed
        // TODO add your handling code here:
            PantallaPreciosHistoricos iu = new PantallaPreciosHistoricos(productoAModificar, controlador);
            iu.setVisible(true);
    }//GEN-LAST:event_jButtonVerPreciosActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaABMProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscarCodigo;
    private javax.swing.JButton jButtonBuscarNombre;
    private javax.swing.JButton jButtonElimiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonVerPrecios;
    private javax.swing.JButton jButtonbuscarTodos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarFields() {
        jTextFieldNombre.setText("");
        jTextFieldCodigo.setText("");
    }

}
