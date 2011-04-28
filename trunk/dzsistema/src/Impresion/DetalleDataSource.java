/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Impresion;

import Negocio.Entidades.DetalleFactura;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author rustu
 */
public class DetalleDataSource implements JRDataSource {

    private int indicadorOrdenActual = -1;
    private List<DetalleFactura> listaDetalles;
   
    public DetalleDataSource() {
    }

//    public OrdenesReparacionDataSource(List<DTOOrden> nuevaListaDtoOrdenes) {
//        listaOrdenes = new ArrayList<DTOOrden>();
//        listaOrdenes.addAll(listaOrdenes);
//        fallasDataSource = new FallasTecnicasDataSource();
//        semaforosDataSource = new SemaforoDataSource();
//    }

    public void addDetalle(DetalleFactura nuevoDetalle) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DetalleFactura>();
        }
        listaDetalles.add(nuevoDetalle);
    }

    public void addAllDetalle(List<DetalleFactura> nuevaLista) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DetalleFactura>();
        }
        listaDetalles.addAll(nuevaLista);
    }

    public boolean next() throws JRException {
        ++indicadorOrdenActual;
        if (indicadorOrdenActual < listaDetalles.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("cantidad")) {
            valor = String.valueOf(listaDetalles.get(indicadorOrdenActual).getCantidad());
        } else if (jrf.getName().equals("codigo")) {
            valor = String.valueOf(listaDetalles.get(indicadorOrdenActual).getProducto().getCodigo());
        } else if (jrf.getName().equals("descripcion")) {
            valor = String.valueOf(listaDetalles.get(indicadorOrdenActual).getProducto().getDescripcion());
        } else if (jrf.getName().equals("precioUnitario")) {
            valor = String.valueOf(listaDetalles.get(indicadorOrdenActual).getPrecioUnitario());
        } else if (jrf.getName().equals("importe")) {
            valor = String.valueOf(listaDetalles.get(indicadorOrdenActual).getPrecioTotal());
        }
        return valor;
    }


    public boolean isVacio() {
        return (listaDetalles == null) ? true : false;
    }
}