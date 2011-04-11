/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import Negocio.Entidades.Cliente;
import Negocio.Entidades.Factura;
import Negocio.Entidades.Producto;
import Negocio.Facturacion.ExpertoFacturar;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.lang.Math.*;

/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    private PantallaFacturacion pantalla;
    private ExpertoFacturar experto;
    private Factura factura;

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

    public void buscarClientePorNombre(String text) {
        List<Cliente> listaDeClientes = experto.buscarClientePorNombre(text);
        if(listaDeClientes.isEmpty()){
            //si no trae ningun cliente
            JOptionPane.showMessageDialog(pantalla, "No se ha encontrado un cliente con ese nombre", "", JOptionPane.INFORMATION_MESSAGE);
        }else if(listaDeClientes.size() == 1){
            //si tre un solo cliente
            experto.buscarClientePorNumero(String.valueOf(listaDeClientes.get(0).getCodigo()));
        }else{
            //si trae muchos clientes
            iniciarPantallaElegirCliente(listaDeClientes);
        }
        
    }

    public void buscarClientePorCiut(String text) {
        Factura fac = experto.buscarClientePorCuit(text);
        cargarDatosClienteYFactura(fac);
    }

    public void buscarClientePorNumero(String text) {
        Factura fac = experto.buscarClientePorNumero(text);
        cargarDatosClienteYFactura(fac);
    }


    public void cargarDatosClienteYFactura(Factura factura){
        this.factura = factura;
        pantalla.getNombre().setText(factura.getCliente().getNombre());
        pantalla.getCuit().setText(factura.getCliente().getCUIT());
        pantalla.getDomicilio().setText(factura.getCliente().getDomicilio());
        pantalla.getNumeroCliente().setText(String.valueOf(factura.getCliente().getCodigo()));
        pantalla.getIva().setText(factura.getCliente().getCondicionFrenteAlIva().getNombre());
        pantalla.getTipoFactura().setText(factura.getTipoFactura().getNombre());
        pantalla.getCodigoFactura().setText("N° 0" + factura.getTipoFactura().getCodigo());
        //pantalla.getFecha().setText(factura.getFecha().); buscar el metodo para mostrar la fecha // TO DO
        cargarCondicionDeVenta();

    }



    public void habilitarCampoNombre() {
        pantalla.getNombre().setEnabled(true);
    }

    public void habilitarCampoNumero() {
        pantalla.getNumeroCliente().setEnabled(true);
    }

    public void habilitarCampoCuit() {
        pantalla.getCuit().setEnabled(true);
    }

    public void cancelarCargaDetalle() {
        pantalla.getCantidad().setText("");
        pantalla.getCodigo().setText("");
        pantalla.getDescripcion().setText("");
        pantalla.getPrecioUnitario().setText("");
        pantalla.getImporte().setText("");
    }

    public void cargarFilaDetalleParaEditar(int fila) {
        //cargar la fila a la que se le hizo doble clic en los campos de edición asi se modifica
    }

    public void buscarProductoYSuInformacion(String text) {
        //buscar el producto con el codigo que me trae
        Producto producto = experto.buscarProducto(text);
        pantalla.getCodigo().setText(String.valueOf(producto.getCodigo()));
        pantalla.getDescripcion().setText(producto.getDescripcion());
        producto.getPrecioHistorico().getPrecio();
        //pantalla.getImporte().setText(producto.getPrecioHistorico()); // acordarse de ver si es factura a o b para colocar el importe con o sin iva //TO DO
        calcularImporteYSetearImporte();


    }

    public void calcularImporteYSetearImporte() {
        float cantidad = 0;
        float precioUnitario = 0;
        try{
            cantidad = Float.valueOf(pantalla.getCantidad().getText());
            precioUnitario = Float.valueOf(pantalla.getPrecioUnitario().getText());
        }catch(NumberFormatException e){
            return;
        }catch(NullPointerException ex){
            return;
        }
        float importe = cantidad * precioUnitario;
        float importeFinal = Math.round(importe * 100)/100;
        pantalla.getImporte().setText(String.valueOf(importeFinal));


    }

    public void agregarDetalleALaTabla() {
        //agregar detalle a la tabla
    }

    public void guardarFactura() {
        
    }

    public void imprimir() {
        guardarFactura();
        //imprimir
    }

    public void limpiarPantalla() {
        //limpiar pantalla
    }


//ACA COMIENZA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE

    PantallaElegirCliente pantallaElefirCliente;
    List<Cliente> listaClientes;

    public void iniciarPantallaElegirCliente(List<Cliente> listaDeClientes) {

        pantallaElefirCliente = new PantallaElegirCliente(this);
        this.listaClientes = listaDeClientes;
        CargarTabla();
        pantalla.setVisible(true);

    }

     public  void CargarTabla() {
        try {

            Object[][] datos = null;

            datos = new Object[listaClientes.size()][4];
            for (int i = 0; i < listaClientes.size(); i++) {
                datos[i][0] = listaClientes.get(i).getCodigo();
                datos[i][1] = listaClientes.get(i).getNombre();
                datos[i][2] = listaClientes.get(i).getCUIT();


            }

            String[] columnNames = {"Código", "Nombre", "CUIT"};
            pantallaElefirCliente.getTabla().setModel(new DefaultTableModel(datos, columnNames) {



                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            });

        } catch (NullPointerException e) {
        }
     }


     public void clienteSeleccionado(int filaSeleccionada){
        cerrarPantallaSeleccionCliente();
        buscarClientePorNumero(String.valueOf(listaClientes.get(filaSeleccionada).getCodigo()));


     }

     public void cancelarSeleccionDeCliente(){
        cerrarPantallaSeleccionCliente();
     }

     private void cerrarPantallaSeleccionCliente(){
        pantallaElefirCliente.dispose();

     }

    private void cargarCondicionDeVenta() {
        //cargar la condicion de venta basado en la factura obtenida al buscar cliente
        //TODO
    }




}
