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

import Negocio.ABM.ControladorABMCliente;
import Negocio.Entidades.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import validar.Validar;
/**
 *
 * @author rustu
 */
public class PantallaABMCliente extends javax.swing.JFrame {

    ControladorABMCliente controlador;
    List<Cliente> listaClientes;
    Cliente clienteAModificar;
    //AltaModificacionAfiliado ama;

    /** Creates new form PantallaABMCliente */
    public PantallaABMCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        listaClientes = controlador.ObtenerClientes();
        CargarTabla();
    }

    //Muestra todos los afiliados en tabla
    public  void CargarTabla() {
        try {

            Object[][] datos = null;

            datos = new Object[listaClientes.size()][5];
            for (int i = 0; i < listaClientes.size(); i++) {
                datos[i][0] = listaClientes.get(i).getCodigo();
                datos[i][1] = listaClientes.get(i).getCUIT();
                datos[i][2] = listaClientes.get(i).getNombre();
                datos[i][3] = listaClientes.get(i).getDomicilio();


            }

            String[] columnNames = {"DNI", "CUIT", "Nombre", "Domicilio"};
            jTableClientes.setModel(new DefaultTableModel(datos, columnNames) {

                boolean[] canEdit = new boolean[]{
                    true, true, true, true, true, true
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
        jTableClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCUIT = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();
        jButtonbuscarTodos = new javax.swing.JButton();
        jButtonBuscarCUIT = new javax.swing.JButton();
        jButtonBuscarCodigo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonBuscarNombre = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonElimiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Clientes");
        setResizable(false);

        jTableClientes.setAutoCreateRowSorter(true);
        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "CUIT", "Nombre", "Domicilio"
            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jLabel2.setText("CUIT:");

        jLabel3.setText("Código");

        jTextFieldCUIT.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextFieldCUIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCUITActionPerformed(evt);
            }
        });

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

        jButtonBuscarCUIT.setText("Buscar");
        jButtonBuscarCUIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCUITActionPerformed(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBuscarCUIT)
                            .addComponent(jButtonBuscarCodigo))
                        .addContainerGap(305, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(jButtonbuscarTodos))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonBuscarCUIT)
                    .addComponent(jTextFieldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarCodigo))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jButtonbuscarTodos))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarNombre))
                        .addContainerGap())))
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

        jButtonElimiar.setText("Baja");
        jButtonElimiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimiarActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonElimiar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevo)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonElimiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:
        int seleccion = jTableClientes.getSelectedRow();
        clienteAModificar = listaClientes.get(seleccion);
}//GEN-LAST:event_jTableClientesMouseClicked

    private void jTextFieldCUITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCUITActionPerformed
        // TODO add your handling code here:
        if (jTextFieldCUIT.getText().isEmpty() == false){
            if(Validar.controlCUIT(jTextFieldCUIT.getText())){
                listaClientes = controlador.buscarAfiliadoPorCUIT(Integer.parseInt(jTextFieldCUIT.getText()));
                CargarTabla();
                limpiarFields();
            } else{
                JOptionPane.showMessageDialog(null, "El CUIT ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un CUIT válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_jTextFieldCUITActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
        if (jTextFieldCodigo.getText().isEmpty() == false){
            if(Validar.controlCodigo(jTextFieldCodigo.getText())){
                listaClientes = controlador.buscarAfiliadoPorCodigo(jTextFieldCodigo.getText());
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
        listaClientes = controlador.ObtenerClientes();
        CargarTabla();
}//GEN-LAST:event_jButtonbuscarTodosActionPerformed

    private void jButtonBuscarCUITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCUITActionPerformed
        // TODO add your handling code here:
        if (jTextFieldCUIT.getText().isEmpty() == false){
            if(Validar.controlCUIT(jTextFieldCUIT.getText())){
                listaClientes = controlador.buscarAfiliadoPorCUIT(Integer.parseInt(jTextFieldCUIT.getText()));
                CargarTabla();
                limpiarFields();
            } else{
                JOptionPane.showMessageDialog(null, "El CUIT ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un CUIT válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_jButtonBuscarCUITActionPerformed

    private void jButtonBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCodigoActionPerformed
        // TODO add your handling code here:
        if (jTextFieldCodigo.getText().isEmpty() == false){
            if(Validar.controlCodigo(jTextFieldCodigo.getText())){
                listaClientes = controlador.buscarAfiliadoPorCodigo(jTextFieldCodigo.getText());
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
                listaClientes = controlador.buscarAfiliadoPorNombre(jTextFieldCodigo.getText());
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
            if(Validar.controlCodigo(jTextFieldNombre.getText())){
                listaClientes = controlador.buscarAfiliadoPorNombre(jTextFieldCodigo.getText());
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
//        ama = new AltaModificacionAfiliado(controlador);
//        ama.setGUI(this);
//        ama.setVisible(true);
}//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
//        if (jTableAfiliados.getSelectedRow() != -1) {
//            ama = new AltaModificacionAfiliado(controlador);
//            ama.setGUI(this);
//            ama.modificarArticulo(clienteAModificar);
//            ama.setVisible(true);
//        } else{
//            JOptionPane.showMessageDialog(null, "Seleccione un afiliado para modificar", "Información", JOptionPane.INFORMATION_MESSAGE);
//        }
//        listaClientes = controlador.ObtenerClientes();
//        CargarTabla();
}//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonElimiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimiarActionPerformed
        if (jTableClientes.getSelectedRow() != -1) {
            for(int i=0;i<jTableClientes.getRowCount();i++){
                if(jTableClientes.isRowSelected(i)){
                        clienteAModificar = listaClientes.get(i);
                        controlador.bajaCliente(clienteAModificar);
                }
            }
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione un afiliado para eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        listaClientes = controlador.ObtenerClientes();
        CargarTabla();
}//GEN-LAST:event_jButtonElimiarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaABMCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarCUIT;
    private javax.swing.JButton jButtonBuscarCodigo;
    private javax.swing.JButton jButtonBuscarNombre;
    private javax.swing.JButton jButtonElimiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonbuscarTodos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldCUIT;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarFields() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
