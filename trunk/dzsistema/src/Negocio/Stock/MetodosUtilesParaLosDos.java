/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Stock;

import Negocio.Entidades.MovimientoStock;
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


    public List<MovimientoStock> bucarMovimientosEntreFechas(Producto producto, Date fechaInicio, Date fechaFin){

       //TODO

        return null;
    }

}
