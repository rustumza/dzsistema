/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaBuscarFactura.java
 *
 * Created on 27/04/2011, 01:24:33
 */

package InterfacesGraficas;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author rustu
 */
public class PantallaBuscarFactura extends javax.swing.JFrame {

    ControladorPanallaFacturacion controlador;
    /** Creates new form PantallaBuscarFactura */
    public PantallaBuscarFactura(ControladorPanallaFacturacion controlador) {
       initComponents();
       this.controlador = controlador;
       this.setLocationRelativeTo(null);
       String[] tiposDeFactura = {"A", "B"};
       tipoFactura.setModel(new DefaultComboBoxModel(tiposDeFactura));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCerrar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        numeroDeFactura = new javax.swing.JTextField();
        numeroDeFacturaLabel = new javax.swing.JLabel();
        tipoFacturaLabel = new javax.swing.JLabel();
        tipoFactura = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar factura");
        setAlwaysOnTop(true);

        jButtonCerrar.setText("Cancelar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        numeroDeFacturaLabel.setText("N° de factura");

        tipoFacturaLabel.setText("Tipo de factura");

        tipoFactura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoFacturaLabel)
                            .addComponent(numeroDeFacturaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroDeFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(tipoFactura, 0, 147, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroDeFacturaLabel)
                    .addComponent(numeroDeFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoFacturaLabel)
                    .addComponent(tipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCerrar)
                    .addComponent(jButtonAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        controlador.buscarFactura();
}//GEN-LAST:event_jButtonAceptarActionPerformed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaBuscarFactura().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JTextField numeroDeFactura;
    private javax.swing.JLabel numeroDeFacturaLabel;
    private javax.swing.JComboBox tipoFactura;
    private javax.swing.JLabel tipoFacturaLabel;
    // End of variables declaration//GEN-END:variables

    public JComboBox getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(JComboBox tipoFactura) {
        this.tipoFactura = tipoFactura;
    }
    // End of variables declaration

    /**
     * @return the jButtonAceptar
     */
    public javax.swing.JButton getjButtonAceptar() {
        return jButtonAceptar;
    }

    /**
     * @param jButtonAceptar the jButtonAceptar to set
     */
    public void setjButtonAceptar(javax.swing.JButton jButtonAceptar) {
        this.jButtonAceptar = jButtonAceptar;
    }

    /**
     * @return the jButtonCerrar
     */
    public javax.swing.JButton getjButtonCerrar() {
        return jButtonCerrar;
    }

    /**
     * @param jButtonCerrar the jButtonCerrar to set
     */
    public void setjButtonCerrar(javax.swing.JButton jButtonCerrar) {
        this.jButtonCerrar = jButtonCerrar;
    }

    /**
     * @return the numeroDeFactura
     */
    public javax.swing.JTextField getNumeroDeFactura() {
        return numeroDeFactura;
    }

    /**
     * @param numeroDeFactura the numeroDeFactura to set
     */
    public void setNumeroDeFactura(javax.swing.JTextField numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    /**
     * @return the numeroDeFacturaLabel
     */
    public javax.swing.JLabel getNumeroDeFacturaLabel() {
        return numeroDeFacturaLabel;
    }

    /**
     * @param numeroDeFacturaLabel the numeroDeFacturaLabel to set
     */
    public void setNumeroDeFacturaLabel(javax.swing.JLabel numeroDeFacturaLabel) {
        this.numeroDeFacturaLabel = numeroDeFacturaLabel;
    }

}
