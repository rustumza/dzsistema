/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ExpertoVentaProductoPorMes {

    public List<DtoResultado> generarReporte(Date inicio, Date fin) {
        FacturaJpaController fachada = new FacturaJpaController();
        List<Factura> listaFacturas = fachada.buscarFacturaEntreFechasSinLaFechaFin(inicio, fin);
        List<DtoResultado> resultado = new ArrayList();
        boolean estaba = false;
        for(int i=0; i<listaFacturas.size();i++){
            for(int j=0; j<listaFacturas.get(i).getDetallesDeFactura().size();j++){
                Producto producto = listaFacturas.get(i).getDetallesDeFactura().get(j).getProducto();
                for(int k=0;k<resultado.size();k++){
                    if(resultado.get(k).getProducto().equals(producto)){
                        resultado.get(k).setTotal(resultado.get(k).getTotal() + listaFacturas.get(i).getDetallesDeFactura().get(j).getPrecioTotal());
                        estaba = true;
                    }
                }
                if(!estaba){
                    DtoResultado nuevo = new DtoResultado();
                    nuevo.setProducto(producto);
                    nuevo.setTotal(listaFacturas.get(i).getDetallesDeFactura().get(j).getPrecioTotal());
                    resultado.add(nuevo);
                }
                estaba = false;
            }
        }
        return resultado;
    }

}
