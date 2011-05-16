/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

import InterfacesGraficas.Reportes.PantallaElegirProducto;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author juampa
 */
public class ExpertoVentaProductoPorMes {

    Producto encontrado;

    public List<Producto> buscarProductoPorCodigo(int codigo) {
        ProductoJpaController fachada = new ProductoJpaController();
        List<Producto> encontrados = fachada.buscarPorCodigo(codigo);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

    public void generarReporte(Producto seleccionado, Date inicio, Date fin) {
        FacturaJpaController fachada = new FacturaJpaController();
        List<Factura> listaFacturas = fachada.buscarFacturaEntreFechasSinLaFechaFin(inicio, fin);
        float resultado = 0;
        for(int i=0; i<listaFacturas.size();i++){
            for(int j=0; j<listaFacturas.get(i).getDetallesDeFactura().size();j++){
                listaFacturas.get(i).getDetallesDeFactura().get(j).getProducto().equals(seleccionado);
                resultado = resultado + listaFacturas.get(i).getDetallesDeFactura().get(j).getPrecioTotal();
            }
        }
        JOptionPane.showMessageDialog(null, "Las ventas totales fueron:"+ resultado , "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<Producto> buscarProductoPorParteDelNombre(String nombre) {
        ProductoJpaController fachada = new ProductoJpaController();
        List<Producto> encontrados = fachada.buscarPorParteDelNombre(nombre);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

}
