/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Stock;

import Negocio.Entidades.MovimientoStock;
import Negocio.Entidades.MovimientoStockJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.TipoMovimientoJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rustu
 */
public class MetodosUtilesParaLosDos {


    public List<MovimientoStock> ordenarMovimientosPorFechaDescendente(List<MovimientoStock> lista){
        List<MovimientoStock> listaOrdenada = new ArrayList<MovimientoStock>();
        while(!lista.isEmpty()){
            MovimientoStock movAux = null;
            movAux = lista.get(0);
            for (MovimientoStock movimientoStock : lista) {
                if(movAux.getFecha().after(movimientoStock.getFecha())){
                    movAux = movimientoStock;
                }
            }
            listaOrdenada.add(movAux);
            lista.remove(movAux);
        }
        return listaOrdenada;
    }

    public MovimientoStock ultimoMovimientoDeLaLista(List<MovimientoStock> lista){

        return lista.get((lista.size())-1);
    }

    public Date fechaUnMesAnterior(Date fecha){

        int nuevoMes;
        if(fecha.getMonth() == 0){
            nuevoMes = 11;
        }else{
            nuevoMes = fecha.getMonth() - 1;
        }
        int nuevoDia;
        if(fecha.getDate()>=28){
           nuevoDia = 28;
        }else{
            nuevoDia= fecha.getDate();
        }
        Date fechaRetorno = new Date(fecha.getYear(), nuevoMes, nuevoDia);

        return fechaRetorno;
    }

}
