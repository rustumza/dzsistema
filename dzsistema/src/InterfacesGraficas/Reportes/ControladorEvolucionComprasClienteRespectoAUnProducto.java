/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.Reportes;

import Negocio.Reportes.DtoMesCantidadProducto;
import Negocio.Reportes.ExpertoEvolucionComprasClienteRespectoAUnProducto;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import validar.fechaException;

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
        int anioInicioInt = 0;
        int anioFinInt = 0;
        int mesInicio = 0;
        int mesFin = 0;
        int codigoInt = 0;

        try{
            String codigo = pantalla.getCodigoProducto().getText();
            codigoInt = Integer.parseInt(codigo);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El código de producto ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;
        }
        try{
            String anioInicio = pantalla.getAnioInicio().getText();
            if(anioInicio.length() != 2){
                JOptionPane.showMessageDialog(null, "El año de inicio ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getAnioInicio().requestFocus();
            }
            anioInicioInt = Integer.parseInt(anioInicio);

            String mesInicioString = (String)pantalla.getMesInicioComboBox().getSelectedItem();
            mesInicio = 0;
            if(mesInicioString.equals("Enero")){
                mesInicio = 0;
            }else if(mesInicioString.equals("Febrero")){
                mesInicio = 1;
            }else if(mesInicioString.equals("Marzo")){
                mesInicio = 2;
            }else if(mesInicioString.equals("Abril")){
                mesInicio = 3;
            }else if(mesInicioString.equals("Mayo")){
                mesInicio = 4;
            }else if(mesInicioString.equals("Junio")){
                mesInicio = 5;
            }else if(mesInicioString.equals("Julio")){
                mesInicio = 6;
            }else if(mesInicioString.equals("Agosto")){
                mesInicio = 7;
            }else if(mesInicioString.equals("Setiembre")){
                mesInicio = 8;
            }else if(mesInicioString.equals("Octubre")){
                mesInicio = 9;
            }else if(mesInicioString.equals("Noviembre")){
                mesInicio = 10;
            }else if(mesInicioString.equals("Diciembre")){
                mesInicio = 11;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El año de inicio ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;
        }

        try{
            String anioFin = pantalla.getAnioFin().getText();
            anioFinInt = Integer.parseInt(anioFin);
            if(anioFin.length() != 2){
                JOptionPane.showMessageDialog(null, "El año de fin ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getAnioFin().requestFocus();
            }

            String mesFinString = (String)pantalla.getMesFinComboBox().getSelectedItem();
            mesFin = 0;
            if(mesFinString.equals("Enero")){
                mesFin = 0;
            }else if(mesFinString.equals("Febrero")){
                mesFin = 1;
            }else if(mesFinString.equals("Marzo")){
                mesFin = 2;
            }else if(mesFinString.equals("Abril")){
                mesFin = 3;
            }else if(mesFinString.equals("Mayo")){
                mesFin = 4;
            }else if(mesFinString.equals("Junio")){
                mesFin = 5;
            }else if(mesFinString.equals("Julio")){
                mesFin = 6;
            }else if(mesFinString.equals("Agosto")){
                mesFin = 7;
            }else if(mesFinString.equals("Setiembre")){
                mesFin = 8;
            }else if(mesFinString.equals("Octubre")){
                mesFin = 9;
            }else if(mesFinString.equals("Noviembre")){
                mesFin = 10;
            }else if(mesFinString.equals("Diciembre")){
                mesFin = 11;
            }


       
       }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El año de inicio ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;
       }
       try{
            Date fechaInicio = new Date((anioInicioInt-1900),mesInicio,1);
            Date fechaFin = new Date((anioFinInt-1900),mesFin,1);
            List<DtoMesCantidadProducto> listaDtoResultante = experto.buscarHitorialProducto(codigoInt, fechaInicio, fechaFin);
       }catch(fechaException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getAnioInicio().requestFocus();

        }
    }
}
