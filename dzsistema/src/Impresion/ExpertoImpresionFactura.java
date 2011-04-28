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
public class ExpertoImpresionFactura {

    void imprimir(Factura factura) {
        ManejadorImpresion manejador = new ManejadorImpresion();
        if(factura.getTipoFactura().getNombre().equals("A")){
            manejador.imprimirFacturaA(factura);
        }
        else{
            manejador.imprimirFacturaB(factura);
        }
    }
}
