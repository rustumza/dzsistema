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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

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
        cargarDatosStockEnPantalla(null);
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
            List<MovimientoStock> listaOrdenadaDeMovimientos = experto.buscarUltimosMovimientos(producto);
            cargarDatosStockEnPantalla(listaOrdenadaDeMovimientos);
            pantalla.getNuevoStockTextField().requestFocus();
        }
    }

    public void agregarStock(){
        String cantidadString = pantalla.getNuevoStockTextField().getText();
        if(experto.getProducto() == null){
            JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "Debe seleccionar un producto", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getNuevoStockTextField().setText("");
            pantalla.getCodigoDeBusquedaTextBox().requestFocus();
            return;
        }
        int cantidadInt = 0;
        if(!(cantidadString.equals(""))){
            try{
                cantidadInt = Integer.parseInt(cantidadString);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "La cantidad ingresada no es un número", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);                
                pantalla.getNuevoStockTextField().requestFocus();
                return;
            }
        
        

            try {
                experto.agregarStock(cantidadInt);
            } catch (StockExcepcion ex) {
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "Error al guardar el Stock, vuelva a intentarlo", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);

            }
            cargarDatosStockEnPantalla(experto.buscarUltimosMovimientos(experto.getProducto()));
            pantalla.getNuevoStockTextField().requestFocus();
        }
    }


    public void restarStock(){
        String cantidadString = pantalla.getNuevoStockQuitarTextField().getText();
        int cantidadInt = 0;
        if(experto.getProducto() == null){
            JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "Debe seleccionar un producto", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getNuevoStockQuitarTextField().setText("");
            pantalla.getCodigoDeBusquedaTextBox().requestFocus();
            return;
        }
        if(!(cantidadString.equals(""))){
            try{
                cantidadInt = Integer.parseInt(cantidadString);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "La cantidad ingresada no es un número", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNuevoStockQuitarTextField().requestFocus();
                return;
            }

        

            try {
                experto.restarStock(cantidadInt);
            } catch (StockExcepcion ex) {
                if(ex.getCodigo() == 2){
                    JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "La cantidad ingresada es mayor que la cantidad disponible", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    pantalla.getNuevoStockQuitarTextField().requestFocus();
                    return;

                }else{
                    JOptionPane.showMessageDialog(getPantalla().getPanelStock(), "Error al guardar el Stock, vuelva a intentarlo", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                }
            }


            cargarDatosStockEnPantalla(experto.buscarUltimosMovimientos(experto.getProducto()));
            pantalla.getNuevoStockQuitarTextField().requestFocus();
        }
    }

    private void cargarDatosStockEnPantalla(List<MovimientoStock> listaOrdenadaDeMovimientos) {

        if(listaOrdenadaDeMovimientos == null){
            pantalla.getStockActual().setText("0");
        }else{
            MovimientoStock mov = new MetodosUtilesParaLosDos().ultimoMovimientoDeLaLista(listaOrdenadaDeMovimientos);
            pantalla.getStockActual().setText(String.valueOf(mov.getStockDespuesDelMovimiento()));
        }
        cargarTabla(listaOrdenadaDeMovimientos);
        pantalla.getNuevoStockTextField().setText("");
        pantalla.getNuevoStockQuitarTextField().setText("");
    }


    public void salir(){
        controladorPantallaPrincipal.iniciarPantalla();
    }

    public void cancelar() {
        pantalla.getNuevoStockTextField().setText("");
        pantalla.getNuevoStockQuitarTextField().setText("");
    }


    private void cargarTabla(List<MovimientoStock> lista){

        if(lista == null){
            pantalla.getTablaUltimosMovimientos().setModel(new ModeloTablaUltimosMovimientos());
        }else{
            pantalla.getTablaUltimosMovimientos().setModel(new ModeloTablaUltimosMovimientos(lista));
        }
        getPantalla().getTablaUltimosMovimientos().getColumnModel().getColumn(0).setPreferredWidth(85);  //fecha
        getPantalla().getTablaUltimosMovimientos().getColumnModel().getColumn(1).setPreferredWidth(50);  //tipo movimiento
        getPantalla().getTablaUltimosMovimientos().getColumnModel().getColumn(2).setPreferredWidth(60);  //movimiento
        getPantalla().getTablaUltimosMovimientos().getColumnModel().getColumn(3).setPreferredWidth(115);  //stock despues del movimiento

        //alinear a la derecha las columnas
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.RIGHT);
        getPantalla().getTablaUltimosMovimientos().getColumnModel().getColumn(2).setCellRenderer(tcr); //moviemiento
        getPantalla().getTablaUltimosMovimientos().getColumnModel().getColumn(3).setCellRenderer(tcr); //stock despues del movimiento



    }


}
