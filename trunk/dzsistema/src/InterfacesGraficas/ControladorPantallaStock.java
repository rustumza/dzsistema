/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import Negocio.Entidades.MovimientoStock;
import Negocio.Entidades.Producto;
import Negocio.Stock.ExpertoStock;
import Negocio.Stock.MetodosUtilesParaLosDos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rustu
 */
public class ControladorPantallaStock {

    ExpertoStock experto;
    PantallaStock pantalla;

    public ControladorPantallaStock(){
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

        Producto prod = experto.agregarStock(cantidadInt);
        cargarDatosStockEnPantalla(new MetodosUtilesParaLosDos().ordenarMovimientosPorFechaDescendente(prod.getStock().getMovimientos()));
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

        Producto prod = experto.restarStock(cantidadInt);
        cargarDatosStockEnPantalla(new MetodosUtilesParaLosDos().ordenarMovimientosPorFechaDescendente(prod.getStock().getMovimientos()));

    }

    private void cargarDatosStockEnPantalla(List<MovimientoStock> listaOrdenadaDeMovimientos) {

        MovimientoStock mov = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(listaOrdenadaDeMovimientos);
        pantalla.getStockActual().setText(String.valueOf(mov.getStockDespuesDelMovimiento()));
        pantalla.getTablaUltimosMovimientos().setModel(new ModeloTablaUltimosMovimientos(listaOrdenadaDeMovimientos));
    }
}
