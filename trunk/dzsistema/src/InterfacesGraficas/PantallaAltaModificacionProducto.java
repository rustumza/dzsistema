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

import Negocio.ABM.ControladorABMProducto;
import Negocio.Entidades.PrecioHistorico;
import Negocio.Entidades.Producto;
import java.util.Date;
import javax.swing.JOptionPane;
import validar.Validar;

/**
 *
 * @author golmir
 */
public class PantallaAltaModificacionProducto extends javax.swing.JFrame {

    /** Creates new form AltaModificacionArticulo */
    ControladorABMProducto controlador;
    PantallaABMProducto PantallaABMProducto;
    Producto producto = new Producto();

    public PantallaAltaModificacionProducto(ControladorABMProducto controlador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlador = controlador;
        jButtonPrecios.setEnabled(false);
        jTextFieldFecha.setText("06/06/2010");
        jTextFieldFecha.setEnabled(false);
    }

    public PantallaAltaModificacionProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        controlador = new ControladorABMProducto();
        jButtonPrecios.setEnabled(false);
        jTextFieldFecha.setText("06/06/2010");
        jTextFieldFecha.setEnabled(false);
    }

    public void modificarProducto(Producto productoAModificar) {
        producto = productoAModificar;
        jTextFieldCodigo.setText(Integer.toString(productoAModificar.getCodigo()));
        JTextFieldDescripcion.setText(productoAModificar.getDescripcion());
        jTextFieldIVA.setText(Float.toString(productoAModificar.getPorcentajeDeIva()));
        jTextFieldPU.setEnabled(false);
        jTextFieldFecha.setText("");
        jTextFieldFecha.setEnabled(false);
        jButtonPrecios.setEnabled(true);
    }

    void setGUI(PantallaABMProducto aThis) {
        PantallaABMProducto = aThis;
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
        jTextFieldIVA = new javax.swing.JTextField();
        jTextFieldtasaanual_r = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTextFieldDescripcion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPU = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jButtonguardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonPrecios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Producto");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("IVA:");

        jLabel6.setText("Descripción:");

        jLabel9.setText("Código:");

        jLabel2.setText("Precio Unitario:");

        jLabel3.setText("Fecha:");

        jTextFieldFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFechaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jTextFieldtasaanual_r, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldPU, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldFecha)
                            .addComponent(jTextFieldIVA)
                            .addComponent(JTextFieldDescripcion)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114)
                .addComponent(jTextFieldtasaanual_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jButtonPrecios.setText("Ver Precios");
        jButtonPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPrecios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonguardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonguardar)
                    .addComponent(jButton1)
                    .addComponent(jButtonPrecios))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonguardarActionPerformed
        // variable logica para validar si se puede guardar o modificar
        boolean condicion = true;
        // Valida Codigo
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
        // Valida Descripcion
        if (JTextFieldDescripcion.getText().isEmpty() == false){
            if(!Validar.controlApellido(JTextFieldDescripcion.getText())){
                condicion=false;
                JOptionPane.showMessageDialog(null, "El Nombre ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            condicion=false;
            JOptionPane.showMessageDialog(null, "Escriba un Nombre válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        // Valida IVA
        if (jTextFieldIVA.getText().isEmpty() == false){
            if(Validar.controlIVA(jTextFieldIVA.getText()).contains("falso")){
                condicion=false;
                JOptionPane.showMessageDialog(null, "El IVA ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                jTextFieldIVA.setText(Validar.controlIVA(jTextFieldIVA.getText()));
            }
        }
        else{
            condicion=false;
            JOptionPane.showMessageDialog(null, "Escriba un IVA válido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Verifica Precio Unitario, Fecha y los crea
        PrecioHistorico ph = null;
        if (jTextFieldPU.isEnabled()){
            if (!jTextFieldPU.getText().isEmpty() && !jTextFieldFecha.getText().isEmpty()){
                ph = new PrecioHistorico();
                //Valida Precio Unitario
                if(Validar.controlIVA(jTextFieldPU.getText()).contains("falso")){
                condicion=false;
                JOptionPane.showMessageDialog(null, "El Precio Unitario ingresado no es válido", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                jTextFieldPU.setText(Validar.controlIVA(jTextFieldPU.getText()));
                ph.setPrecio(Float.parseFloat(jTextFieldPU.getText()));
                }
                //Seteamos datos
                ph.setEstado(true);
                ph.setFechaDesdeQueEntroEnVigencia(Validar.validarFechaConBarras(jTextFieldFecha.getText()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Escriba un Precio Unitario Inicial y la Fecha de su Vigencia", "Información", JOptionPane.INFORMATION_MESSAGE);
                condicion=false;
            }
        }
        //Verifica condicion y guarda
        if(condicion){
        int codigo = Integer.parseInt(jTextFieldCodigo.getText());
        String descripcion = JTextFieldDescripcion.getText();
        Float IVA = Float.parseFloat(jTextFieldIVA.getText());
        Long id = producto.getId();
        controlador.guardarProducto(codigo, descripcion, IVA, ph, id);
        //Actualiza la tabla del ABM
        if(PantallaABMProducto != null){
            PantallaABMProducto.listaProductos = controlador.ObtenerProductos();
            PantallaABMProducto.CargarTabla();
        }
        this.dispose();
        }
    }//GEN-LAST:event_jButtonguardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreciosActionPerformed
        //add your handling code here:
        PantallaPreciosHistoricos iu = new PantallaPreciosHistoricos(producto, controlador);
        iu.setVisible(true);
    }//GEN-LAST:event_jButtonPreciosActionPerformed

    private void jTextFieldFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFechaFocusLost
        // TODO add your handling code here:
        try{
            Date fecha = Validar.validarFecha(jTextFieldFecha.getText());
            jTextFieldFecha.setText(Validar.formatearFechaAString(fecha));
        }
        catch(validar.fechaException e){
            JOptionPane.showMessageDialog(null, "Fecha mal ingresada", "Información", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldFecha.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldFechaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PantallaAltaModificacionProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldDescripcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPrecios;
    private javax.swing.JButton jButtonguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldIVA;
    private javax.swing.JTextField jTextFieldPU;
    private javax.swing.JTextField jTextFieldtasaanual_r;
    // End of variables declaration//GEN-END:variables
}
