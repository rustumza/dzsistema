/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Stock;

import Negocio.Entidades.MovimientoStock;
import Negocio.Entidades.MovimientoStockJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import Negocio.Entidades.StockJpaController;
import Negocio.Entidades.TipoMovimiento;
import Negocio.Entidades.TipoMovimientoJpaController;
import Negocio.Entidades.exceptions.NonexistentEntityException;
import Negocio.Stock.StockException.StockExcepcion;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    public Producto agregarStock(int cantidad) throws StockExcepcion{
        try {
            MovimientoStock movStock = new MovimientoStock();
            movStock.setFecha(new Date());
            movStock.setMovimiento(cantidad);
            
            Date fechaInicio = new MetodosUtilesParaLosDos().fechaUnMesAnterior(new Date());

            List<MovimientoStock> lista = new MovimientoStockJpaController().buscarMovimientosStockEntreFechas(producto.getStock(), fechaInicio, new Date());
            MovimientoStock ultimo = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(lista);
            movStock.setStockDespuesDelMovimiento(ultimo.getStockDespuesDelMovimiento() + cantidad);
            TipoMovimiento tipMov = new TipoMovimientoJpaController().buscarPorNombre("Ingreso");
            movStock.setTipoMovimiento(tipMov);
            producto.getStock().addMovimiento(movStock);
            new StockJpaController().edit(producto.getStock());
            return producto;
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ExpertoStock.class.getName()).log(Level.SEVERE, null, ex);
            throw new StockExcepcion(0);
        } catch (Exception ex) {
            Logger.getLogger(ExpertoStock.class.getName()).log(Level.SEVERE, null, ex);
            throw new StockExcepcion(0);
        }

        

        
    }

    public Producto restarStock(int cantidad) throws StockExcepcion{


        try {
                MovimientoStock movStock = new MovimientoStock();
                movStock.setFecha(new Date());
                movStock.setMovimiento(cantidad);

                Date fechaInicio = new MetodosUtilesParaLosDos().fechaUnMesAnterior(new Date());

                List<MovimientoStock> lista = new MovimientoStockJpaController().buscarMovimientosStockEntreFechas(producto.getStock(), fechaInicio, new Date());
                MovimientoStock ultimo = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(lista);
                if(cantidad > ultimo.getStockDespuesDelMovimiento()){
                    throw new StockExcepcion(2);
                }
                movStock.setStockDespuesDelMovimiento(ultimo.getStockDespuesDelMovimiento() - cantidad);
                TipoMovimiento tipMov = new TipoMovimientoJpaController().buscarPorNombre("Ingreso");
                movStock.setTipoMovimiento(tipMov);
                producto.getStock().addMovimiento(movStock);
                new StockJpaController().edit(producto.getStock());
                return producto;

            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ExpertoStock.class.getName()).log(Level.SEVERE, null, ex);
                throw new StockExcepcion(3);
            } catch (Exception ex) {
                Logger.getLogger(ExpertoStock.class.getName()).log(Level.SEVERE, null, ex);
                throw new StockExcepcion(3);
            }
    }
}
