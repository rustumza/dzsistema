/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.Reportes;

import Negocio.Reportes.ExpertoEvolucionComprasClienteRespectoAUnProducto;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author rustu
 */
public class ControladorEvolucionComprasClienteRespectoAUnProducto {

    PantallaEvolucionComprasClienteRespectoAUnProducto pantalla;
    ExpertoEvolucionComprasClienteRespectoAUnProducto experto;

    public ControladorEvolucionComprasClienteRespectoAUnProducto(){
        experto = new ExpertoEvolucionComprasClienteRespectoAUnProducto();
    }

    public void iniciarPantalla(){
        pantalla = new PantallaEvolucionComprasClienteRespectoAUnProducto(this);
    }

    public void buscarProducto() {
        
        try{
            String codigo = pantalla.getCodigoProducto().getText();
            int codigoInt = Integer.parseInt(codigo);
            experto.buscarHitorialProducto(codigoInt);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El código de producto ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
        }
    }
}
