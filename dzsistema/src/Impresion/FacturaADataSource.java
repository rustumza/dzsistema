/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Impresion;

import Impresion.DetalleDataSource;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import java.net.URL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import validar.Validar;

/**
 *
 * @author juampa
 */
public class FacturaADataSource implements JRDataSource {

    private boolean next = true;
    private Factura factura;
    private DetalleDataSource detalleDataSource;
    private DetalleDataSource1 detalleDataSource1;
//    private int cantFilas = 0;

    public FacturaADataSource() {
    }

    public void addFactura(Factura factura) {
        if (factura == null) {
            factura = new Factura();
        }
        this.factura = factura;
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if (jrf.getName().equals("fecha")) {
            valor = Validar.formatearFechaAString(factura.getFecha());
        } else if (jrf.getName().equals("numero")) {
            valor = String.valueOf(factura.getNumero());
        }else if (jrf.getName().equals("nroRemito")) {
            valor = String.valueOf(factura.getRemitoNro());
        }else if (jrf.getName().equals("total")) {
            valor = Validar.formatearFloatAStringConDosDecimalesYComa(factura.getTotal());
        }else if (jrf.getName().equals("condicionDeVenta")) {
            valor = String.valueOf(factura.getCondicionDeVenta().getNombre());
        }else if (jrf.getName().equals("señor/es")) {
            valor = String.valueOf(factura.getCliente().getNombre());
        }else if (jrf.getName().equals("domicilio")) {
            valor = String.valueOf(factura.getCliente().getDomicilio());
        }else if (jrf.getName().equals("cuit")) {
            valor = String.valueOf(factura.getCliente().getCUIT());
        }else if (jrf.getName().equals("iva")) {
            valor = String.valueOf(factura.getCliente().getCondicionFrenteAlIva().getNombre());
        }else if (jrf.getName().equals("subtotal")) {
            valor = Validar.formatearFloatAStringConDosDecimalesYComa(factura.getSubtotal());
        }else if (jrf.getName().equals("iva21")) {
            valor = Validar.formatearFloatAStringConDosDecimalesYComa(factura.getIva21());
        }else if (jrf.getName().equals("iva105")) {
            valor = Validar.formatearFloatAStringConDosDecimalesYComa(factura.getIva105());
        }else if (jrf.getName().equals("detalles")) {
            detalleDataSource = new DetalleDataSource();
            detalleDataSource.addAllDetalle(factura.getDetallesDeFactura());
            valor = detalleDataSource;
        }else if (jrf.getName().equals("detalles1")) {
            detalleDataSource1 = new DetalleDataSource1();
            detalleDataSource1.addAllDetalle(factura.getDetallesDeFactura());
            valor = detalleDataSource1;
        }else if (jrf.getName().equals("dirdetalle")) {
            URL archivoCadena = null;
            archivoCadena = getClass().getResource("/Impresion/DetalleFactura.jasper");
            valor = String.valueOf(archivoCadena);
        }else if (jrf.getName().equals("dirdetalle1")) {
            URL archivoCadena = null;
            archivoCadena = getClass().getResource("/Impresion/DetalleFactura_1.jasper");
            valor = String.valueOf(archivoCadena);
        }
        return valor;
    }

    public boolean next() throws JRException {
        if(next == true){
            next = false;
            return true;
        }else{
            return false;
        }
    }
}
