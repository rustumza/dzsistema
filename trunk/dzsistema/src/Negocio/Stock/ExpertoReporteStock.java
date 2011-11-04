/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Stock;

import InterfacesGraficas.DTOStockProducto;
import Negocio.Entidades.MovimientoStock;
import Negocio.Entidades.MovimientoStockJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ExpertoReporteStock {

    public List<DTOStockProducto> buscarStocks(Date fecha, boolean mostrarProductosSinStock) {
        //Creo la lista de dtos
        List<DTOStockProducto> resultado = new ArrayList();
        //Traigo todos los productos
        ProductoJpaController fachadaProducto = new ProductoJpaController();
        List<Producto> productos = fachadaProducto.findProductoEntities();
        //Cargo la lista de dto con los datos de los productos y sus stock
        for(int i = 0; i<productos.size(); i++){
            //Busco la lista de los ultimos movimientos (1 mes para atras) de stock segun el parametro fecha para obtener el stock del momento
            MetodosUtilesParaLosDos util = new MetodosUtilesParaLosDos();
            MovimientoStockJpaController fachadaMovimientos = new MovimientoStockJpaController();
            List<MovimientoStock> movimientos = fachadaMovimientos.buscarMovimientosStockEntreFechas(productos.get(i).getStock(), util.fechaUnMesAnterior(fecha), fecha);
            //Si la lista de movimientos no esta vacia creo un dto y guardo
            if(!movimientos.isEmpty()){
                MovimientoStock movimiento = util.ultimoMovimientoDeLaLista(movimientos);
                //Verifico si quiero mostrar productos con stock 0
                if(movimiento.getStockDespuesDelMovimiento() != 0){
                    DTOStockProducto dto = new DTOStockProducto();
                    dto.setCodigo(productos.get(i).getCodigo());
                    dto.setNombre(productos.get(i).getDescripcion());
                    dto.setStock(movimiento.getStockDespuesDelMovimiento());
                    resultado.add(dto);
                }
                else{
                    if(mostrarProductosSinStock){
                        DTOStockProducto dto = new DTOStockProducto();
                        dto.setCodigo(productos.get(i).getCodigo());
                        dto.setNombre(productos.get(i).getDescripcion());
                        dto.setStock(movimiento.getStockDespuesDelMovimiento());
                        resultado.add(dto);
                    }
                }
            }
            //Si la lista estaba vasia busco movimientos desde la fecha hacia atras
            else{
                //Si la lista de movimientos no esta vacia creo un dto y guardo
                if(!fachadaMovimientos.buscarMovimientosDesdeFechaHaciaAtras(productos.get(i).getStock(), fecha).isEmpty()){
                    MovimientoStock movimiento = util.ultimoMovimientoDeLaLista(fachadaMovimientos.buscarMovimientosDesdeFechaHaciaAtras(productos.get(i).getStock(), fecha));
                    //Verifico si quiero mostrar productos con stock 0
                    if(movimiento.getStockDespuesDelMovimiento() != 0){
                        DTOStockProducto dto = new DTOStockProducto();
                        dto.setCodigo(productos.get(i).getCodigo());
                        dto.setNombre(productos.get(i).getDescripcion());
                        dto.setStock(movimiento.getStockDespuesDelMovimiento());
                        resultado.add(dto);
                    }
                    else{
                        if(mostrarProductosSinStock){
                            DTOStockProducto dto = new DTOStockProducto();
                            dto.setCodigo(productos.get(i).getCodigo());
                            dto.setNombre(productos.get(i).getDescripcion());
                            dto.setStock(movimiento.getStockDespuesDelMovimiento());
                            resultado.add(dto);
                        }
                    }
                }
            }
        }
        return resultado;
    }

}
