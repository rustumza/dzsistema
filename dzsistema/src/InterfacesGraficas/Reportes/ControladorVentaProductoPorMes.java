/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.Reportes;

import Negocio.Entidades.Producto;
import Negocio.Reportes.ExpertoVentaProductoPorMes;
import java.util.List;

/**
 *
 * @author rustu
 */
public class ControladorVentaProductoPorMes {
    ExpertoVentaProductoPorMes experto = new ExpertoVentaProductoPorMes();

    public List<Producto> buscarProductoPorCodigo(int codigo) {
        return experto.buscarProductoPorCodigo(codigo);
    }

    public void generarReporte(List<Producto> listaProductos, String año, String mes) {
        experto.generarReporte(listaProductos, año, mes);
    }

    public List<Producto> buscarProductoPorParteDelNombre(String nombre) {
        return experto.buscarProductoPorParteDelNombre(nombre);
    }

}
