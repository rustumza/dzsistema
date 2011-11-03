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
import java.util.ArrayList;
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
            
            

            List<MovimientoStock> lista = buscarUltimosMovimientos(producto);
            /**Date fechaInicio = new MetodosUtilesParaLosDos().fechaUnMesAnterior(new Date());
            Date fechaLimite = new Date(100, 0, 1);
            while((lista == null || lista.isEmpty()) && fechaLimite.before(fechaInicio)){
                lista = new MovimientoStockJpaController().buscarMovimientosStockEntreFechas(producto.getStock(), fechaInicio, new Date());
                fechaInicio = new MetodosUtilesParaLosDos().fechaUnMesAnterior(fechaInicio);
            }
            */
            if(lista == null){
                movStock.setStockDespuesDelMovimiento(cantidad);
            }else{
                MovimientoStock ultimo = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(lista);
                movStock.setStockDespuesDelMovimiento(ultimo.getStockDespuesDelMovimiento() + cantidad);
            }
            TipoMovimiento tipMov = new TipoMovimientoJpaController().buscarPorNombre("Ingreso");
            movStock.setTipoMovimiento(tipMov);
            producto.getStock().addMovimiento(movStock);
            new StockJpaController().edit(producto.getStock());
            producto.getStock().setMovimientos(new ArrayList<MovimientoStock>());
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
                List<MovimientoStock> lista = buscarUltimosMovimientos(producto);
                /*Date fechaInicio = new MetodosUtilesParaLosDos().fechaUnMesAnterior(new Date());
                Date fechaLimite = new Date(100, 0, 1);
                List<MovimientoStock> lista = null;
                while((lista == null || lista.isEmpty()) && fechaLimite.before(fechaInicio)){
                    lista = new MovimientoStockJpaController().buscarMovimientosStockEntreFechas(producto.getStock(), fechaInicio, new Date());
                    fechaInicio = new MetodosUtilesParaLosDos().fechaUnMesAnterior(fechaInicio);
                }
                */
                MovimientoStock ultimo = null;
                 
                if(lista == null){
                   throw new StockExcepcion(2);
                }else{
                    ultimo = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(lista);
                    if(cantidad > ultimo.getStockDespuesDelMovimiento()){
                        throw new StockExcepcion(2);
                   }
                }
                movStock.setStockDespuesDelMovimiento(ultimo.getStockDespuesDelMovimiento() - cantidad);
                TipoMovimiento tipMov = new TipoMovimientoJpaController().buscarPorNombre("Egreso");
                movStock.setTipoMovimiento(tipMov);
                producto.getStock().addMovimiento(movStock);
                new StockJpaController().edit(producto.getStock());
                producto.getStock().setMovimientos(new ArrayList<MovimientoStock>());
                return producto;

            }catch(StockExcepcion ex){
                throw new StockExcepcion(2);
            }catch (NonexistentEntityException ex) {
                throw new StockExcepcion(3);
            }catch (Exception ex) {
                throw new StockExcepcion(3);
            }

    }

    public List<MovimientoStock> buscarUltimosMovimientos(Producto prod){

            Date fechaInicio = new MetodosUtilesParaLosDos().fechaUnMesAnterior(new Date());
            List<MovimientoStock> lista = null;
            Date fechaLimite = new Date(100, 0, 1);
            while((lista == null || lista.isEmpty()) && fechaLimite.before(fechaInicio)){
                lista = new MovimientoStockJpaController().buscarMovimientosStockEntreFechas(prod.getStock(), fechaInicio, new Date());
                if(fechaInicio.compareTo(fechaLimite) == 0){
                    break;
                }
                fechaInicio = new MetodosUtilesParaLosDos().fechaUnAnioAnterior(fechaInicio);
            }
            if(lista == null || lista.isEmpty()){
                return null;
            }else{
                return lista;
                //MovimientoStock ultimo = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(lista);
                //movStock.setStockDespuesDelMovimiento(ultimo.getStockDespuesDelMovimiento() + cantidad);
            }
    }


    public Producto getProducto(){
        return producto;
    }
}

            
            