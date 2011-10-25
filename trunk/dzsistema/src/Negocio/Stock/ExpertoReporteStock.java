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

    public List<DTOStockProducto> buscarStocks(Date fecha) {
        //Creo la lista de dtos
        List<DTOStockProducto> resultado = new ArrayList();
        //Traigo todos los productos
        ProductoJpaController fachadaProducto = new ProductoJpaController();
        List<Producto> productos = fachadaProducto.findProductoEntities();
        //Cargo la lista de dto con los datos de los productos y sus stock
        for(int i = 0; i<productos.size(); i++){
            DTOStockProducto dto = new DTOStockProducto();
            dto.setCodigo(productos.get(i).getCodigo());
            dto.setNombre(productos.get(i).getDescripcion());
            //Busco ultimo movimiento de stock segun el parametro fecha y obtengo el stock del momento
            MetodosUtilesParaLosDos util = new MetodosUtilesParaLosDos();
            MovimientoStockJpaController fachadaMovimientos = new MovimientoStockJpaController();
            MovimientoStock movimiento = util.ultimoMovimientoDeLaLista(fachadaMovimientos.buscarMovimientosStockEntreFechas(productos.get(i).getStock(), fecha, util.fechaUnMesAnterior(fecha)));
            dto.setStock(movimiento.getStockDespuesDelMovimiento());
            resultado.add(dto);
        }
        return resultado;
    }

}
