/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.ABM;

import Negocio.Entidades.PrecioHistorico;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import Negocio.Entidades.Stock;
import Negocio.Entidades.StockJpaController;
import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juampa
 */
class ExpertoABMProducto {

    List<Producto> ObtenerProductos() {
        ProductoJpaController fachada = new ProductoJpaController();
        return fachada.buscarDeAlta();
    }

    List<Producto> buscarProductoPorCodigo(int codigo) {
        ProductoJpaController fachada = new ProductoJpaController();
        List<Producto> encontrados = fachada.buscarPorCodigo(codigo);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

    List<Producto> buscarProductoPorParteDelNombre(String nombre) {
        ProductoJpaController fachada = new ProductoJpaController();
        List<Producto> encontrados = fachada.buscarPorParteDelNombre(nombre);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

    void bajaProducto(Producto productoAModificar) {
        try {
            ProductoJpaController fachada = new ProductoJpaController();
            productoAModificar.setEstado(false);
            fachada.edit(productoAModificar);
            JOptionPane.showMessageDialog(null, "Producto dado de baja", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error, vuelva a intentarlo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ExpertoABMCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error, vuelva a intentarlo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ExpertoABMCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void guardarProducto(int codigo, String descripcion, Float IVA, PrecioHistorico ph, Long id) {
        ProductoJpaController fachada = new ProductoJpaController();
        Producto producto;
        //Verifica si es nuevo
        if (id == null) {
            producto = new Producto();
            //Agrega precio inicial
            if(ph != null){
                producto.addPrecio(ph);
            }
            //Crea, guarda y agrega stock
            StockJpaController fachadaS = new StockJpaController();
            Stock stock = new Stock();
            fachadaS.create(stock);
            producto.setStock(stock);

        } else {
            producto = fachada.findProducto(id);
        }
        if(producto.getId() != null || fachada.buscarPorCodigo(codigo).isEmpty()){
            producto.setCodigo(codigo);
            producto.setDescripcion(descripcion);
            producto.setPorcentajeDeIva(IVA);
            producto.setEstado(true);
            try {
                if (id == null) {
                    fachada.create(producto);
                } else {
                    fachada.edit(producto);
                }
                JOptionPane.showMessageDialog(null, "Se guardaron los datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Se produjo un error", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Código repetido/s, Ingrese nuevamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
