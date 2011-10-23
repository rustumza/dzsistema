/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.Reportes;

import InterfacesGraficas.DTOStockProducto;
import Negocio.Stock.ExpertoReporteStock;
import java.util.Date;
import java.util.List;
import validar.Validar;

/**
 *
 * @author juampa
 */
public class ControladorReporteStock {

    PantallaReporteStock pantalla;
    PantallaSeleccionarFecha pantallaFecha;
    ExpertoReporteStock experto;

    public ControladorReporteStock(){
        experto = new ExpertoReporteStock();
    }

    public void iniciarPantalla(){
        //Aca llamo al experto para buscar los dto resultantes con la fecha actual
        Date fecha = new Date();
        List<DTOStockProducto> stocks = experto.buscarStocks(fecha);
        //Mando los dto en el contructor de la pantalla para que los cargue en la tabla y los muestre
        pantalla = new PantallaReporteStock();
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }

    public void iniciarPantalla(Date fecha){
        //Aca llamo al experto para buscar los dto resultantes segun fecha
        List<DTOStockProducto> stocks = experto.buscarStocks(fecha);
        //Envio los dto en el contructor de la pantalla para que los cargue en la tabla y los muestre
        pantalla = new PantallaReporteStock(stocks);
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }

    public void iniciarPantallaSeleccionarFecha(){
        pantallaFecha = new PantallaSeleccionarFecha(this);
        pantallaFecha.setLocationRelativeTo(null);
        pantallaFecha.setVisible(true);
    }

    public void formatearFecha(){
        pantallaFecha.setjTextFieldFecha(Validar.formatearFechaConBarrasAFechaConFormatoDeIngreso(pantallaFecha.getjTextFieldFecha().toString()));
    }

}
