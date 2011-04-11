/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import Negocio.Facturacion.ExpertoFacturar;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    PantallaFacturacion pantalla;
    ExpertoFacturar experto;

    public ControladorPanallaFacturacion() {
        experto = new ExpertoFacturar();
    }

    
    public void iniciarPantalla() {
        try{
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
        }
        catch(Exception ex) {
            System.out.println("Fallo lookandfell");
        }
        pantalla = new PantallaFacturacion(this);
        configurarTabla();
        pantalla.setVisible(true);

    }


    public void configurarTabla() {

        JTable tabla = pantalla.getTablaDetallesFactura();

        //Asigmo el modelo
        tabla.setModel(new ModeloTablaProducto());

/*
        //prueba
        String[] columnName = {"Cantidad", "Código", "Descripción", "P. Unitario", "Importe"};
        String[][] datos = {{" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "},
                            {" "," "," "," "," "}};
                            
        tabla.setModel(new DefaultTableModel(datos, columnName));
*/
        //Tamaño de las columnas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);  //cantidad
        tabla.getColumnModel().getColumn(1).setPreferredWidth(70);  //codigo
        tabla.getColumnModel().getColumn(2).setPreferredWidth(400); //descripcion
        tabla.getColumnModel().getColumn(3).setPreferredWidth(70);  //precio unitario
        tabla.getColumnModel().getColumn(4).setPreferredWidth(70);  //importe

    }

    void buscarClientePorNombre(String text) {
        //si trae mas de una hacer metodo qeu llame a la pantalla para elegir
    }

    void buscarClientePorCiut(String text) {
        
    }

    void buscarClientePorNumero(String text) {

    }

     void habilitarCampoNombre() {
        pantalla.getNombre().setEnabled(true);
    }

    void habilitarCampoNumero() {
        pantalla.getNumeroCliente().setEnabled(true);
    }

    void habilitarCampoCuit() {
        pantalla.getCuit().setEnabled(true);
    }

    void cancelarCargaDetalle() {
        pantalla.getCantidad().setText("");
        pantalla.getCodigo().setText("");
        pantalla.getDescripcion().setText("");
        pantalla.getPrecioUnitario().setText("");
        pantalla.getImporte().setText("");
    }

    void cargarFilaDetalleParaEditar(int fila) {
        //cargar la fila a la que se le hizo doble clic en los campos de edición asi se modifica
    }

    void buscarProductoYSuInformacion(String text) {
        //buscar el producto con el codigo que me trae
    }

    void agregarDetalleALaTabla() {
        //agregar detalle a la tabla
    }

    void guardarFactura() {
        
    }

    void imprimir() {
        guardarFactura();
        //imprimir
    }

    void limpiarPantalla() {
        //limpiar pantalla
    }

}
