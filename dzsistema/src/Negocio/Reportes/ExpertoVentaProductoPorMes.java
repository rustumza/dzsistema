/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

import InterfacesGraficas.Reportes.PantallaElegirProducto;
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
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

    public void generarReporte(List<Producto> listaProductos, String año, String mes) {
        FacturaJpaController fachada = new FacturaJpaController();
        Date inicio = null;
        Date fin = null;
        fachada.buscarFacturaEntreFechas(inicio, fin);
    }

    public List<Producto> buscarProductoPorParteDelNombre(String nombre) {
        ProductoJpaController fachada = new ProductoJpaController();
        List<Producto> encontrados = fachada.buscarPorParteDelNombre(nombre);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

}
