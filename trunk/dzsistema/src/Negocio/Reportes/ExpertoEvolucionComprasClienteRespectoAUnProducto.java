/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import validar.fechaException;

/**
 *
 * @author rustu
 */
public class ExpertoEvolucionComprasClienteRespectoAUnProducto {

    public List<DtoMesCantidadProducto> buscarHitorialProducto(int codigo, Date fechaInicio, Date fechaFin) throws fechaException{

        if(fechaFin.after(fechaInicio)){
            //fecha inicio posterio a fecha fin
            throw new fechaException(6);
        }else if(new Date().after(fechaInicio)){
            //fecha inicio posterior fecha actual
            throw new fechaException(7);
        }

        FacturaJpaController jpaFactura = new FacturaJpaController();
        List<Factura> listaDeFacturas = jpaFactura.buscarFacturaEntreFechas(fechaInicio, fechaFin);
        List<DtoMesCantidadProducto> listaDeDto = new ArrayList<DtoMesCantidadProducto>();

        for (Factura factura : listaDeFacturas) {
            for (DetalleFactura detalle : factura.getDetallesDeFactura()) {
                if(detalle.getProducto().getCodigo() == codigo){
                    Date fechaFactura = factura.getFecha();
                    int anio = fechaFactura.getYear()+1900;
                    int mes = fechaFactura.getMonth()+1;
                    for (DtoMesCantidadProducto mesCantidadProducto : listaDeDto) {
                        if(mesCantidadProducto.getAnio() == anio & mesCantidadProducto.getMes() == mes){
                            mesCantidadProducto.setCantidad(mesCantidadProducto.getCantidad() + detalle.getCantidad());
                        }else{
                            listaDeDto.add(new DtoMesCantidadProducto(anio, mes, detalle.getCantidad()));
                        }

                    }
                }
            }
        }
        return listaDeDto;
    }


}
