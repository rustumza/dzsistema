/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaVentaProductoPorMes.java
 *
 * Created on 14/05/2011, 17:08:48
 */

package InterfacesGraficas.Reportes;

import Negocio.Entidades.Cliente;
import Negocio.Reportes.DtoResultado;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import validar.Validar;
/**
 *
 * @author rustu
 */
public class PantallaVentaProductoADeterminadoClientePorMes extends javax.swing.JFrame {
    List<Cliente> listaClientes = new Vector();
    Cliente ClienteSeleccionado;
    ControladorVentaProductoADeterminadoClientePorMes controlador = new ControladorVentaProductoADeterminadoClientePorMes();

    /** Creates new form PantallaVentaProductoPorMes */
    public PantallaVentaProductoADeterminadoClientePorMes() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAño = new javax.swing.JTextField();
        jComboBoxMes = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jButtonBuscarCodigo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonBuscarNombre = new javax.swing.JButton();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas productos de determinado cliente");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Fechas"));

        jLabel1.setText("Año");

        jLabel3.setText("Mes");

        jTextFieldAño.setPreferredSize(new java.awt.Dimension(10, 20));
        jTextFieldAño.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAñoFocusLost(evt);
            }
        });

        jComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBoxMes.setPreferredSize(new java.awt.Dimension(82, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMes, 0, 126, Short.MAX_VALUE))
                .addGap(177, 177, 177))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cliente"));

        jLabel8.setText("Número:");

        jTextFieldCodigo.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jButtonBuscarCodigo.setText("Buscar");
        jButtonBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCodigoActionPerformed(evt);
            }
        });

        jLabel9.setText("Nombre");

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

        jTextFieldCliente.setEnabled(false);

        jLabel2.setText("Cliente Seleccionado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBuscarNombre)
                            .addComponent(jButtonBuscarCodigo)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonGenerar.setText("Generar");
        jButtonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGenerar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonGenerar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarActionPerformed
        try{
        // variable logica para validar si se puede guardar o modificar
        boolean condicion = true;
        // Valida Año
        if (jTextFieldAño.getText().isEmpty() == false){
            if(!Validar.ValidarAño(jTextFieldAño.getText())){
                condicion=false;
                JOptionPane.showMessageDialog(null, "El año ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            condicion=false;
            JOptionPane.showMessageDialog(null, "Escriba un año válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
        //Creamos fecha Inicio
        int año = Integer.parseInt(jTextFieldAño.getText()) + 2000;
        int mes = 1;
        if(jComboBoxMes.getSelectedItem().toString().equals("Enero")){
            mes = 01;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Febrero")){
            mes = 02;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Marzo")){
            mes = 03;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Abril")){
            mes = 04;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Mayo")){
            mes = 05;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Junio")){
            mes = 06;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Julio")){
            mes = 07;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Agosto")){
            mes = 8;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Septiembre")){
            mes = 9;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Octubre")){
            mes = 10;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Noviembre")){
            mes = 11;
        }else if (jComboBoxMes.getSelectedItem().toString().equals("Diciembre")){
            mes = 12;
        }
        Date inicio = new Date(año-1900, mes-1, 1);
        //Creamos fecha Fin
        if(mes == 12){
            año = año+1;
            mes = 1;
        }
        else{
            mes = mes +1;
        }
        Date fin = new Date (año-1900, mes-1, 1);
        //Valida fechas
        Date hoy = new Date();
        Date primera = new Date (2010-1900, 6-1, 6);
        //Valido la fecha menor
        if(inicio.getYear() < primera.getYear()){
            condicion=false;
            JOptionPane.showMessageDialog(null, "La fecha ingresada no es válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            if(inicio.getYear() == primera.getYear()){
                if(inicio.getMonth() < primera.getMonth()){
                    condicion=false;
                    JOptionPane.showMessageDialog(null, "La fecha ingresada no es válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //Valido la fecha mayor
//        if(fin.getYear() > hoy.getYear()){
//            condicion=false;
//            JOptionPane.showMessageDialog(null, "La fecha ingresada no es válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
//        }
//        else{
//            if(fin.getYear() == hoy.getYear()){
//                if(fin.getMonth() > hoy.getMonth()+1){
//                    condicion=false;
//                    JOptionPane.showMessageDialog(null, "La fecha ingresada no es válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        }
        //Valida Producto
        if (jTextFieldCliente.getText().isEmpty()){
            condicion=false;
            JOptionPane.showMessageDialog(null, "Seleccione un cliente", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
        //Genera el reporte
        if(condicion){

            ClienteSeleccionado = listaClientes.get(0);
            List<DtoResultado> resultado = controlador.generarReporte(ClienteSeleccionado, inicio, fin);
            PantallaResultado pantalla = new PantallaResultado(resultado, jComboBoxMes.getSelectedItem().toString(), Integer.toString(año));
            pantalla.setVisible(true);
            }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "Error al generar", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGenerarActionPerformed

    private void jButtonBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCodigoActionPerformed
        if (jTextFieldCodigo.getText().isEmpty() == false){
            if(Validar.controlCodigo(jTextFieldCodigo.getText())){
                try{
                listaClientes = controlador.buscarClientePorCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "El número ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                }
                try{
                jTextFieldCliente.setText(listaClientes.get(0).getNombre());
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "El número ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                }
                limpiarFieldsProducto();
            } else{
                JOptionPane.showMessageDialog(null, "El número ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un número válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscarCodigoActionPerformed

    private void jButtonBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarNombreActionPerformed
        if (jTextFieldNombre.getText().isEmpty() == false){
            listaClientes = controlador.buscarClientePorParteDelNombre(jTextFieldNombre.getText());
            if(!listaClientes.isEmpty()){
                if(listaClientes.size() <= 1){
                    jTextFieldCliente.setText(listaClientes.get(0).getNombre());
                }
                else{
                    PantallaElegirCliente iu = new PantallaElegirCliente(listaClientes);
                    iu.setVisible(true);
                    iu.setGUI(this);
                }
                limpiarFieldsProducto();
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un nombre válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonBuscarNombreActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed

        if (jTextFieldCodigo.getText().isEmpty() == false){
            if(Validar.controlCodigo(jTextFieldCodigo.getText())){
                try{
                listaClientes = controlador.buscarClientePorCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "El número ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                }
                jTextFieldCliente.setText(listaClientes.get(0).getNombre());
                limpiarFieldsProducto();
            } else{
                JOptionPane.showMessageDialog(null, "El número ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un número válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        if (jTextFieldNombre.getText().isEmpty() == false){
            listaClientes = controlador.buscarClientePorParteDelNombre(jTextFieldNombre.getText());
            if(!listaClientes.isEmpty()){
                if(listaClientes.size() <= 1){
                    jTextFieldCliente.setText(listaClientes.get(0).getNombre());
                }
                else{
                    PantallaElegirCliente iu = new PantallaElegirCliente(listaClientes);
                    iu.setVisible(true);
                    iu.setGUI(this);
                }
                limpiarFieldsProducto();
            }
        } else{
            JOptionPane.showMessageDialog(null, "Escriba un nombre válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldAñoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAñoFocusLost
        if (jTextFieldAño.getText().isEmpty() == false){
            if(!Validar.ValidarAño(jTextFieldAño.getText())){
                JOptionPane.showMessageDialog(null, "El año ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldAño.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Escriba un año válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldAño.setText("");
        }
    }//GEN-LAST:event_jTextFieldAñoFocusLost

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PantallaVentaProductoPorMes().setVisible(true);
//            }
//        });
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarCodigo;
    private javax.swing.JButton jButtonBuscarNombre;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGenerar;
    private javax.swing.JComboBox jComboBoxMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    public void setjTextFieldProducto(Cliente cliente) {
        jTextFieldCliente.setText(cliente.getNombre());
        listaClientes.clear();
        listaClientes.add(cliente);
    }

    private void limpiarFieldsProducto() {
        jTextFieldNombre.setText("");
        jTextFieldCodigo.setText("");
    }

}
