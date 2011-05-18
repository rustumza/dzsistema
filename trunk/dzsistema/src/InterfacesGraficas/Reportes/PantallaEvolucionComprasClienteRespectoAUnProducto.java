/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaEvolucionComprasClienteRespectoAUnProducto.java
 *
 * Created on 14/05/2011, 17:11:35
 */

package InterfacesGraficas.Reportes;

import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author rustu
 */
public class PantallaEvolucionComprasClienteRespectoAUnProducto extends javax.swing.JFrame {
    private ControladorEvolucionComprasClienteRespectoAUnProducto controlador;
    /** Creates new form PantallaEvolucionComprasClienteRespectoAUnProducto */
    public PantallaEvolucionComprasClienteRespectoAUnProducto(ControladorEvolucionComprasClienteRespectoAUnProducto controlador) {
        initComponents();
        String[] meses = {"Enero", "Febrero", "Marzo" , "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre","Octubre", "Noviembre", "Diciembre"};
        mesInicioComboBox.setModel(new DefaultComboBoxModel(meses));
        mesFinComboBox.setModel(new DefaultComboBoxModel(meses));
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

        codigoProductoLabel = new javax.swing.JLabel();
        codigoProducto = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        fechaInicioLabel = new javax.swing.JLabel();
        fechaFinLabel = new javax.swing.JLabel();
        mesInicioComboBox = new javax.swing.JComboBox();
        mesFinComboBox = new javax.swing.JComboBox();
        anioInicio = new javax.swing.JTextField();
        anioFin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        nombreProductoLabel = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        mesInicioLabel = new javax.swing.JLabel();
        anioInicioLabel = new javax.swing.JLabel();
        mesFinLabel = new javax.swing.JLabel();
        anioFinLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        numeroLabel = new javax.swing.JLabel();
        cuitLabel = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JTextField();
        numeroCliente = new javax.swing.JTextField();
        cuitCliente = new javax.swing.JTextField();
        limpiarPantalla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Evolucion venta de producto");

        codigoProductoLabel.setText("Código Producto");

        codigoProducto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoProductoActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        fechaInicioLabel.setText("Fecha inicio");

        fechaFinLabel.setText("Fecha fin");

        mesInicioComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mesInicioComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mesInicioComboBoxKeyPressed(evt);
            }
        });

        mesFinComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mesFinComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mesFinComboBoxKeyPressed(evt);
            }
        });

        anioInicio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        anioInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioInicioActionPerformed(evt);
            }
        });

        anioFin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        anioFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioFinActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        nombreProductoLabel.setText("Nombre Producto");

        nombreProducto.setEnabled(false);
        nombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProductoActionPerformed(evt);
            }
        });

        mesInicioLabel.setText("Mes");

        anioInicioLabel.setText("Año");

        mesFinLabel.setText("Mes");

        anioFinLabel.setText("Año");

        nombreLabel.setText("Nombre");

        numeroLabel.setText("Número");

        cuitLabel.setText("CUIT");

        nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreClienteActionPerformed(evt);
            }
        });

        numeroCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numeroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroClienteActionPerformed(evt);
            }
        });

        cuitCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cuitCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuitClienteActionPerformed(evt);
            }
        });

        limpiarPantalla.setText("Limpiar Pantalla");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(numeroLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuitLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuitCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(nombreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreProductoLabel)
                                    .addComponent(codigoProductoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicioLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limpiarPantalla))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(mesFinLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mesFinComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(mesInicioLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mesInicioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(anioInicioLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(anioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(anioFinLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(anioFin)))
                                .addGap(103, 103, 103))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fechaFinLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoProductoLabel)
                    .addComponent(codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreProductoLabel)
                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLabel)
                    .addComponent(numeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuitLabel)
                    .addComponent(cuitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaInicioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mesInicioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesInicioLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaFinLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mesFinLabel)
                            .addComponent(mesFinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscar)
                            .addComponent(limpiarPantalla)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anioInicioLabel)
                            .addComponent(anioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anioFinLabel)
                            .addComponent(anioFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        controlador.buscarEvolucion();
    }//GEN-LAST:event_buscarActionPerformed

    private void codigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoProductoActionPerformed
        controlador.buscarProducto();
    }//GEN-LAST:event_codigoProductoActionPerformed

    private void nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProductoActionPerformed
        getMesInicioComboBox().requestFocus();
    }//GEN-LAST:event_nombreProductoActionPerformed

    private void anioInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioInicioActionPerformed
        getMesFinComboBox().requestFocus();
    }//GEN-LAST:event_anioInicioActionPerformed

    private void anioFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioFinActionPerformed
        getBuscar().requestFocus();
    }//GEN-LAST:event_anioFinActionPerformed

    private void nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreClienteActionPerformed
        controlador.buscarClientePorNombre(nombreCliente.getText());
    }//GEN-LAST:event_nombreClienteActionPerformed

    private void numeroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroClienteActionPerformed
        controlador.buscarClientePorNumero(numeroCliente.getText());
    }//GEN-LAST:event_numeroClienteActionPerformed

    private void cuitClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuitClienteActionPerformed
        controlador.buscarClientePorCuit(cuitCliente.getText());
    }//GEN-LAST:event_cuitClienteActionPerformed

    private void mesInicioComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesInicioComboBoxKeyPressed
        if (evt.getKeyCode()==10)
            {
                getAnioInicio().requestFocus();
            }


    }//GEN-LAST:event_mesInicioComboBoxKeyPressed

    private void mesFinComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesFinComboBoxKeyPressed
        if (evt.getKeyCode()==10)
            {
                getAnioFin().requestFocus();
            }

    }//GEN-LAST:event_mesFinComboBoxKeyPressed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaEvolucionComprasClienteRespectoAUnProducto().setVisible(true);
            }
        });
    }
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anioFin;
    private javax.swing.JLabel anioFinLabel;
    private javax.swing.JTextField anioInicio;
    private javax.swing.JLabel anioInicioLabel;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField codigoProducto;
    private javax.swing.JLabel codigoProductoLabel;
    private javax.swing.JTextField cuitCliente;
    private javax.swing.JLabel cuitLabel;
    private javax.swing.JLabel fechaFinLabel;
    private javax.swing.JLabel fechaInicioLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarPantalla;
    private javax.swing.JComboBox mesFinComboBox;
    private javax.swing.JLabel mesFinLabel;
    private javax.swing.JComboBox mesInicioComboBox;
    private javax.swing.JLabel mesInicioLabel;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JLabel nombreProductoLabel;
    private javax.swing.JTextField numeroCliente;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the anioFin
     */
    public javax.swing.JTextField getAnioFin() {
        return anioFin;
    }

    /**
     * @param anioFin the anioFin to set
     */
    public void setAnioFin(javax.swing.JTextField anioFin) {
        this.anioFin = anioFin;
    }

    /**
     * @return the anioFinLabel
     */
    public javax.swing.JLabel getAnioFinLabel() {
        return anioFinLabel;
    }

    /**
     * @param anioFinLabel the anioFinLabel to set
     */
    public void setAnioFinLabel(javax.swing.JLabel anioFinLabel) {
        this.anioFinLabel = anioFinLabel;
    }

    /**
     * @return the anioInicio
     */
    public javax.swing.JTextField getAnioInicio() {
        return anioInicio;
    }

    /**
     * @param anioInicio the anioInicio to set
     */
    public void setAnioInicio(javax.swing.JTextField anioInicio) {
        this.anioInicio = anioInicio;
    }

    /**
     * @return the anioInicioLabel
     */
    public javax.swing.JLabel getAnioInicioLabel() {
        return anioInicioLabel;
    }

    /**
     * @param anioInicioLabel the anioInicioLabel to set
     */
    public void setAnioInicioLabel(javax.swing.JLabel anioInicioLabel) {
        this.anioInicioLabel = anioInicioLabel;
    }

    /**
     * @return the buscar
     */
    public javax.swing.JButton getBuscar() {
        return buscar;
    }

    /**
     * @param buscar the buscar to set
     */
    public void setBuscar(javax.swing.JButton buscar) {
        this.buscar = buscar;
    }

    /**
     * @return the codigoProducto
     */
    public javax.swing.JTextField getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(javax.swing.JTextField codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the codigoProductoLabel
     */
    public javax.swing.JLabel getCodigoProductoLabel() {
        return codigoProductoLabel;
    }

    /**
     * @param codigoProductoLabel the codigoProductoLabel to set
     */
    public void setCodigoProductoLabel(javax.swing.JLabel codigoProductoLabel) {
        this.codigoProductoLabel = codigoProductoLabel;
    }

    /**
     * @return the cuitCliente
     */
    public javax.swing.JTextField getCuitCliente() {
        return cuitCliente;
    }

    /**
     * @param cuitCliente the cuitCliente to set
     */
    public void setCuitCliente(javax.swing.JTextField cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    /**
     * @return the cuitLabel
     */
    public javax.swing.JLabel getCuitLabel() {
        return cuitLabel;
    }

    /**
     * @param cuitLabel the cuitLabel to set
     */
    public void setCuitLabel(javax.swing.JLabel cuitLabel) {
        this.cuitLabel = cuitLabel;
    }

    /**
     * @return the fechaFinLabel
     */
    public javax.swing.JLabel getFechaFinLabel() {
        return fechaFinLabel;
    }

    /**
     * @param fechaFinLabel the fechaFinLabel to set
     */
    public void setFechaFinLabel(javax.swing.JLabel fechaFinLabel) {
        this.fechaFinLabel = fechaFinLabel;
    }

    /**
     * @return the fechaInicioLabel
     */
    public javax.swing.JLabel getFechaInicioLabel() {
        return fechaInicioLabel;
    }

    /**
     * @param fechaInicioLabel the fechaInicioLabel to set
     */
    public void setFechaInicioLabel(javax.swing.JLabel fechaInicioLabel) {
        this.fechaInicioLabel = fechaInicioLabel;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the jTable1
     */
    public javax.swing.JTable getTabla() {
        return tabla;
    }

    /**
     * @param jTable1 the jTable1 to set
     */
    public void setTabla(javax.swing.JTable jTable1) {
        this.tabla = jTable1;
    }

    /**
     * @return the limpiarPantalla
     */
    public javax.swing.JButton getLimpiarPantalla() {
        return limpiarPantalla;
    }

    /**
     * @param limpiarPantalla the limpiarPantalla to set
     */
    public void setLimpiarPantalla(javax.swing.JButton limpiarPantalla) {
        this.limpiarPantalla = limpiarPantalla;
    }

    /**
     * @return the mesFinComboBox
     */
    public javax.swing.JComboBox getMesFinComboBox() {
        return mesFinComboBox;
    }

    /**
     * @param mesFinComboBox the mesFinComboBox to set
     */
    public void setMesFinComboBox(javax.swing.JComboBox mesFinComboBox) {
        this.mesFinComboBox = mesFinComboBox;
    }

    /**
     * @return the mesFinLabel
     */
    public javax.swing.JLabel getMesFinLabel() {
        return mesFinLabel;
    }

    /**
     * @param mesFinLabel the mesFinLabel to set
     */
    public void setMesFinLabel(javax.swing.JLabel mesFinLabel) {
        this.mesFinLabel = mesFinLabel;
    }

    /**
     * @return the mesInicioComboBox
     */
    public javax.swing.JComboBox getMesInicioComboBox() {
        return mesInicioComboBox;
    }

    /**
     * @param mesInicioComboBox the mesInicioComboBox to set
     */
    public void setMesInicioComboBox(javax.swing.JComboBox mesInicioComboBox) {
        this.mesInicioComboBox = mesInicioComboBox;
    }

    /**
     * @return the mesInicioLabel
     */
    public javax.swing.JLabel getMesInicioLabel() {
        return mesInicioLabel;
    }

    /**
     * @param mesInicioLabel the mesInicioLabel to set
     */
    public void setMesInicioLabel(javax.swing.JLabel mesInicioLabel) {
        this.mesInicioLabel = mesInicioLabel;
    }

    /**
     * @return the nombreCliente
     */
    public javax.swing.JTextField getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(javax.swing.JTextField nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the nombreLabel
     */
    public javax.swing.JLabel getNombreLabel() {
        return nombreLabel;
    }

    /**
     * @param nombreLabel the nombreLabel to set
     */
    public void setNombreLabel(javax.swing.JLabel nombreLabel) {
        this.nombreLabel = nombreLabel;
    }

    /**
     * @return the nombreProducto
     */
    public javax.swing.JTextField getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(javax.swing.JTextField nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the nombreProductoLabel
     */
    public javax.swing.JLabel getNombreProductoLabel() {
        return nombreProductoLabel;
    }

    /**
     * @param nombreProductoLabel the nombreProductoLabel to set
     */
    public void setNombreProductoLabel(javax.swing.JLabel nombreProductoLabel) {
        this.nombreProductoLabel = nombreProductoLabel;
    }

    /**
     * @return the numeroCliente
     */
    public javax.swing.JTextField getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * @param numeroCliente the numeroCliente to set
     */
    public void setNumeroCliente(javax.swing.JTextField numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    /**
     * @return the numeroLabel
     */
    public javax.swing.JLabel getNumeroLabel() {
        return numeroLabel;
    }

    /**
     * @param numeroLabel the numeroLabel to set
     */
    public void setNumeroLabel(javax.swing.JLabel numeroLabel) {
        this.numeroLabel = numeroLabel;
    }
    
}
