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

    public void imprimir(Factura factura) {
        ManejadorImpresion manejador = new ManejadorImpresion();
        if(factura.getTipoFactura().getNombre().equals("A") | factura.getTipoFactura().getNombre().equals("a")){
            manejador.imprimirFacturaA(factura);
        }
        else{
            manejador.imprimirFacturaB(factura);
        }
    }
}
