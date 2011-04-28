/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Impresion;

import Negocio.Entidades.Factura;

/**
 *
 * @author juampa
 */
public class ControladorImpresionFactura {
    ExpertoImpresionFactura experto = new ExpertoImpresionFactura();

    public void imprimir(Factura factura){
        experto.imprimir(factura);
    }

}
