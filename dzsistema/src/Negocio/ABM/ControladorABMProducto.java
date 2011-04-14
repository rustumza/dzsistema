/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.ABM;

import Negocio.Entidades.PrecioHistorico;
import Negocio.Entidades.Producto;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ControladorABMProducto {
    ExpertoABMProducto experto = new ExpertoABMProducto();

    public List<Producto> ObtenerProductos() {
        return experto.ObtenerProductos();
    }

    public List<Producto> buscarProductoPorCodigo(int codigo) {
        return experto.buscarProductoPorCodigo(codigo);
    }

    public List<Producto> buscarProductoPorNombre(String nombre) {
        return experto.buscarProductoPorNombre(nombre);
    }

    public void bajaProducto(Producto productoAModificar) {
        experto.bajaProducto(productoAModificar);
    }

    public void guardarProducto(int codigo, String descripcion, Float IVA, PrecioHistorico ph, Long id) {
        experto.guardarProducto(codigo, descripcion, IVA, ph, id);
    }

}
