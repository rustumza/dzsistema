/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Stock;

import Negocio.Entidades.MovimientoStock;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import Negocio.Entidades.TipoMovimiento;
import Negocio.Entidades.TipoMovimientoJpaController;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rustu
 */
public class ExpertoStock {

    Producto producto;



    public Producto buscarProducto(int codigo){
        //esto es para buscar un producto con todos los precios historicos
        ProductoJpaController productoJpa = new ProductoJpaController();
        List<Producto> listaDeProductos = productoJpa.buscarPorCodigo(codigo);
        if(listaDeProductos.isEmpty()){
            return null;
        }else{
            producto = listaDeProductos.get(0);
            return producto;
        }
    }


    public Producto agregarStock(int catidad){
        MovimientoStock movStock = new MovimientoStock();
        movStock.setFecha(new Date());
        movStock.setMovimiento(catidad);
        MovimientoStock ultimo = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(producto.getStock().getMovimientos());
        movStock.setStockDespuesDelMovimiento(ultimo.getStockDespuesDelMovimiento() + catidad);
        TipoMovimiento tipMov = new TipoMovimientoJpaController().buscarPorNombre("Ingreso");
        //TODO
        movStock.setTipoMovimiento(tipMov);

        

        return producto;
    }

    public Producto restarStock(int cantidad){


        return producto;
    }
}
