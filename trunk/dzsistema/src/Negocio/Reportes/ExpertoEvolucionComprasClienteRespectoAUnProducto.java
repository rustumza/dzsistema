/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rustu
 */
public class ExpertoEvolucionComprasClienteRespectoAUnProducto {

    public void buscarHitorialProducto(int codigo) {
        FacturaJpaController jpaFactura = new FacturaJpaController();
        List<Factura> listaDeFacturas = jpaFactura.buscarTodasLasFacturas();
        List<dtoMesCantidadProducto> listaDeDto = new ArrayList<dtoMesCantidadProducto>();
        for (Factura factura : listaDeFacturas) {
            for (DetalleFactura detalle : factura.getDetallesDeFactura()) {
                if(detalle.getProducto().getCodigo() == codigo){
                    detalle.getCantidad();

                }
            }

        }
    }

}
