/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import Negocio.Entidades.MovimientoStock;
import Negocio.Entidades.MovimientoStockJpaController;
import Negocio.Entidades.Producto;
import Negocio.Stock.ExpertoStock;
import Negocio.Stock.MetodosUtilesParaLosDos;
import Negocio.Stock.StockException.StockExcepcion;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rustu
 */
public class ControladorPantallaStock {

    ExpertoStock experto;
    PantallaStock pantalla;
    ControladorPantallaPrincipal controladorPantallaPrincipal;

    /*public ControladorPantallaStock(){
        experto = new ExpertoStock();
    }*/

    ControladorPantallaStock(ControladorPantallaPrincipal controlador) {
        controladorPantallaPrincipal = controlador;
        experto = new ExpertoStock();
    }


    public void iniciarPantalla(){
        pantalla = new PantallaStock(this);
        getPantalla().setVisible(true);
    }

    
    public PantallaStock getPantalla(){
        return pantalla;
    }

    public void buscarProducto() {
        String codigoString = pantalla.getCodigoDeBusquedaTextBox().getText();
        int codigoInt = 0;
        if(!(codigoString.equals(""))){
            try{
                codigoInt = Integer.parseInt(codigoString);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "El código de producto ingresado no es un número", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getCodigoDeBusquedaTextBox().requestFocus();
                return;
            }

            Producto producto = experto.buscarProducto(codigoInt);
            if(producto == null){
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "No se ha encontrado el producto buscado", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getCodigoDeBusquedaTextBox().requestFocus();
                return;
            }
            pantalla.getCodigoProductoEncontradoLabel().setText(String.valueOf(producto.getCodigo()));
            pantalla.getDescripcionProductoEncontradoLAbel().setText(producto.getDescripcion());
            List<MovimientoStock> listaOrdenadaDeMovimientos = new MetodosUtilesParaLosDos().ordenarMovimientosPorFechaDescendente(producto.getStock().getMovimientos());
            cargarDatosStockEnPantalla(listaOrdenadaDeMovimientos);
        }
    }

    public void agregarStock(){
        String cantidadString = pantalla.getNuevoStockTextField().getText();
        int cantidadInt = 0;
        if(!(cantidadString.equals(""))){
            try{
                cantidadInt = Integer.parseInt(cantidadString);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "La cantidad ingresada no es un número", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNuevoStockTextField().requestFocus();
                return;
            }
        
        }

        Producto prod = null;
        try {
            prod = experto.agregarStock(cantidadInt);
        } catch (StockExcepcion ex) {
            JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "Error al guardar el Stock, vuelva a intentarlo", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);

        }
        cargarDatosStockEnPantalla(new MovimientoStockJpaController().buscarMovimientosStockEntreFechas(prod.getStock(), new MetodosUtilesParaLosDos().fechaUnMesAnterior(new Date()), new Date()));
    }


    public void restarStock(){
        String cantidadString = pantalla.getNuevoStockTextField().getText();
        int cantidadInt = 0;
        if(!(cantidadString.equals(""))){
            try{
                cantidadInt = Integer.parseInt(cantidadString);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "La cantidad ingresada no es un número", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNuevoStockTextField().requestFocus();
                return;
            }

        }

        Producto prod = null;
        try {
            prod = experto.restarStock(cantidadInt);
        } catch (StockExcepcion ex) {
            if(ex.getCodigo() == 2){
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "La cantidad ingresada es mayor que la cantidad disponible", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNuevoStockTextField().requestFocus();
            }else{
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "Error al guardar el Stock, vuelva a intentarlo", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        cargarDatosStockEnPantalla(new MovimientoStockJpaController().buscarMovimientosStockEntreFechas(prod.getStock(), new MetodosUtilesParaLosDos().fechaUnMesAnterior(new Date()), new Date()));

    }

    private void cargarDatosStockEnPantalla(List<MovimientoStock> listaOrdenadaDeMovimientos) {

        MovimientoStock mov = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(listaOrdenadaDeMovimientos);
        pantalla.getStockActual().setText(String.valueOf(mov.getStockDespuesDelMovimiento()));
        pantalla.getTablaUltimosMovimientos().setModel(new ModeloTablaUltimosMovimientos(listaOrdenadaDeMovimientos));
    }


    public int salir(){

        pantalla.dispose();
        controladorPantallaPrincipal.iniciarPantalla();
        return JFrame.DISPOSE_ON_CLOSE;
    }
}
