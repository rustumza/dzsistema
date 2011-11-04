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
        jButtonAceptar.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Fecha");

        jLabel1.setText("Fecha");

        jTextFieldFecha.setPreferredSize(new java.awt.Dimension(87, 28));
        jTextFieldFecha.setRequestFocusEnabled(false);
        jTextFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFechaActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        Date fecha = Validar.validarFecha(Validar.formatearFechaConBarrasAFechaConFormatoDeIngreso(jTextFieldFecha.getText()));
        fecha.setSeconds(59);
        fecha.setHours(23);
        fecha.setMinutes(59);
        controlador.iniciarPantalla(fecha);
        this.dispose();
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
            jButtonAceptar.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldFechaActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaSeleccionarFecha().setVisible(true);
            }
        });
    }

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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldFecha;
    // End of variables declaration//GEN-END:variables

}
