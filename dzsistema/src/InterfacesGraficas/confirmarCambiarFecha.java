/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * confirmarCambiarFecha.java
 *
 * Created on 20/04/2011, 12:17:02
 */

package InterfacesGraficas;

import java.awt.Component;

/**
 *
 * @author rustu
 */
public class confirmarCambiarFecha extends javax.swing.JFrame {

    /** Creates new form confirmarCambiarFecha */
    public confirmarCambiarFecha(Component PantallaFacturacion) {
        initComponents();
        this.setLocationRelativeTo(PantallaFacturacion);
        this.setTitle("!Atención¡");
        this.setAlwaysOnTop(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seguroQueDeseaCancelar = new javax.swing.JLabel();
        si = new javax.swing.JButton();
        no = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seguroQueDeseaCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        seguroQueDeseaCancelar.setText("¿Está seguro que desea cambiar la fecha?");

        si.setText("SÍ");

        no.setText("NO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seguroQueDeseaCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(si, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seguroQueDeseaCancelar)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(si)
                        .addComponent(no))
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton no;
    private javax.swing.JLabel seguroQueDeseaCancelar;
    private javax.swing.JButton si;
    // End of variables declaration//GEN-END:variables

}
