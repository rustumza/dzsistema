/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AltaModificacionArticulo.java
 *
 * Created on 25/08/2010, 20:44:19
 */
package InterfacesGraficas;

import Negocio.ABM.ControladorABMCliente;
import Negocio.Entidades.Cliente;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import validar.Validar;

/**
 *
 * @author golmir
 */
public class PantallaAltaModificacionCliente extends javax.swing.JFrame {

    /** Creates new form AltaModificacionArticulo */
    ControladorABMCliente controlador;
    PantallaABMCliente PantallaABMCliente;
    Cliente cliente = new Cliente();

    public PantallaAltaModificacionCliente(ControladorABMCliente controlador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlador = controlador;
    }

    public PantallaAltaModificacionCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        controlador = new ControladorABMCliente();
    }

    public void modificarCliente(Cliente clienteAModificar) {
        cliente = clienteAModificar;
        jTextFieldCodigo.setText(Integer.toString(clienteAModificar.getCodigo()));
        JTextFieldNombre.setText(clienteAModificar.getNombre());
        jTextFieldDireccion.setText(clienteAModificar.getDomicilio());
        jTextFieldCUIT.setText(clienteAModificar.getCUIT());
        jComboBoxIVA.setSelectedItem(clienteAModificar.getCondicionFrenteAlIva());
    }

    void setGUI(PantallaABMCliente aThis) {
        PantallaABMCliente = aThis;
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
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldtasaanual_r = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTextFieldNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxIVA = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCUIT = new javax.swing.JTextField();
        jButtonguardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Dirección");

        jLabel7.setText("Código:");

        jLabel6.setText("Nombre:");

        jLabel5.setText("IVA:");

        jComboBoxIVA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Responsable Inscripto", "Monotributista" }));

        jLabel9.setText("CUIT:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jTextFieldtasaanual_r, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxIVA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCodigo)
                    .addComponent(jTextFieldDireccion)
                    .addComponent(JTextFieldNombre)
                    .addComponent(jTextFieldCUIT, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addComponent(jTextFieldtasaanual_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonguardar.setText("Guardar");
        jButtonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonguardarActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonguardar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonguardar)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonguardarActionPerformed
        // variable logica para validar si se puede guardar o modificar
        boolean condicion = true;
        // Valida CUIT
        if (jTextFieldCUIT.getText().isEmpty() == false){
            if(!Validar.controlCUIT(jTextFieldCUIT.getText())){
                condicion=false;
                JOptionPane.showMessageDialog(null, "El CUIT ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            condicion=false;
            JOptionPane.showMessageDialog(null, "Escriba un CUIT válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        // Valida Nombre
        if (JTextFieldNombre.getText().isEmpty() == false){
            if(!Validar.controlApellido(JTextFieldNombre.getText())){
                condicion=false;
                JOptionPane.showMessageDialog(null, "El Nombre ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            condicion=false;
            JOptionPane.showMessageDialog(null, "Escriba un Nombre válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Valida Direccion
        if (jTextFieldDireccion.getText().isEmpty()){
            condicion = false;
            JOptionPane.showMessageDialog(null, "Escriba una Dirección válida", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Valida codigo
        if (jTextFieldCodigo.getText().isEmpty() == false){
            if(!Validar.controlCodigo(jTextFieldCodigo.getText())){
                condicion=false;
                JOptionPane.showMessageDialog(null, "El Código ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            condicion=false;
            JOptionPane.showMessageDialog(null, "Escriba un Código válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Verifica condicion y guarda
        if(condicion){
        int codigo = Integer.parseInt(jTextFieldCodigo.getText());
        String nombre = JTextFieldNombre.getText();
        String direccion = jTextFieldDireccion.getText();
        String CUIT = jTextFieldCUIT.getText();
        Long id = cliente.getId();
        String iva = jComboBoxIVA.getSelectedItem().toString();
        controlador.guardarCliente(codigo, nombre, CUIT,direccion, id, iva);
        //Actualiza la tabla del ABM
        PantallaABMCliente.listaClientes = controlador.ObtenerClientes();
        PantallaABMCliente.CargarTabla();
        this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonguardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PantallaAltaModificacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonguardar;
    private javax.swing.JComboBox jComboBoxIVA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCUIT;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldtasaanual_r;
    // End of variables declaration//GEN-END:variables
}
