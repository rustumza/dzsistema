/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaSeleccionarFecha.java
 *
 * Created on 20/10/2011, 11:07:12
 */

package InterfacesGraficas.Reportes;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import validar.Validar;

/**
 *
 * @author juampa
 */
public class PantallaSeleccionarFecha extends javax.swing.JFrame {
    ControladorReporteStock controlador;

    /** Creates new form PantallaSeleccionarFecha */
    public PantallaSeleccionarFecha() {
        initComponents();
    }

    public PantallaSeleccionarFecha(ControladorReporteStock controlador) {
        initComponents();
        this.controlador = controlador;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jCheckBoxMostrarProductosEnCero = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Fecha");

        jButtonAceptar.setText("Generar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos"));

        jLabel1.setText("Fecha");

        jTextFieldFecha.setPreferredSize(new java.awt.Dimension(87, 28));
        jTextFieldFecha.setRequestFocusEnabled(false);
        jTextFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFechaActionPerformed(evt);
            }
        });

        jCheckBoxMostrarProductosEnCero.setText("Mostrar productos que estan en cero");
        jCheckBoxMostrarProductosEnCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMostrarProductosEnCeroActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jCheckBoxMostrarProductosEnCero, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxMostrarProductosEnCero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if(getjTextFieldFecha().getText().equals("")){
            getjTextFieldFecha().requestFocus();
            JOptionPane.showMessageDialog(null, "Escriba una fecha válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try{
                Validar.validarFechaConBarras(jTextFieldFecha.getText());
                Date fecha = Validar.validarFecha(Validar.formatearFechaConBarrasAFechaConFormatoDeIngreso(jTextFieldFecha.getText()));
                fecha.setSeconds(59);
                fecha.setHours(23);
                fecha.setMinutes(59);
                controlador.iniciarPantalla(fecha, jCheckBoxMostrarProductosEnCero.isSelected());
            }
            catch(validar.fechaException e){
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Escriba una fecha válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                getjTextFieldFecha().requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTextFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaActionPerformed

        if(getjTextFieldFecha().getText().equals("")){
            getjTextFieldFecha().requestFocus();
        }
        else{
            try{
            jTextFieldFecha.setText(Validar.formatearFechaAString(Validar.validarFecha(getjTextFieldFecha().getText())));
            }
            catch(validar.fechaException e){
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Escriba una fecha válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextFieldFechaActionPerformed

    private void jCheckBoxMostrarProductosEnCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMostrarProductosEnCeroActionPerformed
        getjTextFieldFecha().requestFocus();
    }//GEN-LAST:event_jCheckBoxMostrarProductosEnCeroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getjTextFieldFecha().setText(null);
        getjTextFieldFecha().requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed


    public ControladorReporteStock getControlador() {
        return controlador;
    }

    public void setControlador(ControladorReporteStock controlador) {
        this.controlador = controlador;
    }

    public JButton getjButtonAceptar() {
        return jButtonAceptar;
    }

    public void setjButtonAceptar(JButton jButtonAceptar) {
        this.jButtonAceptar = jButtonAceptar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JTextField getjTextFieldFecha() {
        return jTextFieldFecha;
    }

    public void setjTextFieldFecha(String jTextFieldFecha) {
        this.jTextFieldFecha.setText(jTextFieldFecha);
    }

    public boolean getjCheckBoxMostrarProductosEnCero() {
        return jCheckBoxMostrarProductosEnCero.isSelected();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JCheckBox jCheckBoxMostrarProductosEnCero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldFecha;
    // End of variables declaration//GEN-END:variables

}
