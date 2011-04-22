/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import Negocio.Entidades.Cliente;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import Negocio.Entidades.Producto;
import validar.fechaException;
import validar.Validar;
import Negocio.Facturacion.ExpertoFacturar;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.lang.Math.*;
import java.util.ArrayList;


/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    private PantallaFacturacion pantalla;
    private ExpertoFacturar experto;
    private boolean deseaCambiarFecha;
    //private Factura factura;

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
        getPantalla().setVisible(true);


    }


    public void configurarTabla() {

        JTable tabla = getPantalla().getTablaDetallesFactura();

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
            JOptionPane.showMessageDialog(getPantalla(), "No se ha encontrado un cliente con ese nombre", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
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

        getPantalla().getNombre().setText(factura.getCliente().getNombre());
        getPantalla().getCuit().setText(factura.getCliente().getCUIT());
        getPantalla().getDomicilio().setText(factura.getCliente().getDomicilio());
        getPantalla().getNumeroCliente().setText(String.valueOf(factura.getCliente().getCodigo()));
        getPantalla().getIva().setText(factura.getCliente().getCondicionFrenteAlIva().getNombre());
        getPantalla().getTipoFactura().setText(factura.getTipoFactura().getNombre());
        getPantalla().getCodigoFactura().setText("N° 0" + factura.getTipoFactura().getCodigo());
        
        if(factura.getTipoFactura().getNombre().equals("b") | factura.getTipoFactura().getNombre().equals("B")){
            //deshabilitar el impuestos
            getPantalla().getSubtotal().setVisible(false);
            getPantalla().getSubtotalLabel().setVisible(false);
            
            getPantalla().getSubtotal2().setVisible(false);
            getPantalla().getSubtotal2Label().setVisible(false);
            
            getPantalla().getImporte().setVisible(false);
            getPantalla().getImpuestosLabel().setVisible(false);
            
            getPantalla().getIvaInsc().setVisible(false);
            getPantalla().getIvaIsncLabel().setVisible(false);
        }else{

            //Habilitar impuestos
            getPantalla().getSubtotal().setVisible(true);
            getPantalla().getSubtotalLabel().setVisible(true);

            getPantalla().getSubtotal2().setVisible(true);
            getPantalla().getSubtotal2Label().setVisible(true);

            getPantalla().getImporte().setVisible(true);
            getPantalla().getImpuestosLabel().setVisible(true);

            getPantalla().getIvaInsc().setVisible(true);
            getPantalla().getIvaIsncLabel().setVisible(true);

        }
        

        pantalla.getFecha().setText(Validar.formatearFechaAString(factura.getFecha()));
        cargarCondicionDeVenta();

    }



    public void habilitarCampoNombre() {
        getPantalla().getNombre().setEnabled(true);
    }

    public void habilitarCampoNumero() {
        getPantalla().getNumeroCliente().setEnabled(true);
    }

    public void habilitarCampoCuit() {
        getPantalla().getCuit().setEnabled(true);
    }

    public void cancelarCargaDetalle() {
        limpiarIngresoDeDetalle();
        getPantalla().getEliminar().setEnabled(false);
    }

    public void cargarFilaDetalleParaEditar(int filaSeleccionada) {
        //cargar la fila a la que se le hizo doble clic en los campos de edición asi se modifica
        Factura fac = experto.getFactura();
        DetalleFactura det = fac.getDetallesDeFactura().get(filaSeleccionada);
        getPantalla().getCantidad().setText(String.valueOf(det.getCantidad()));
        getPantalla().getCodigo().setText(String.valueOf(det.getProducto().getCodigo()));
        getPantalla().getDescripcion().setText(det.getProducto().getDescripcion());
        getPantalla().getPrecioUnitario().setText(String.valueOf(det.getPrecioUnitario()));
        getPantalla().getImporte().setText(String.valueOf(det.getPrecioTotal()));

    }

    public void buscarProductoYSuInformacion() {
        //buscar el producto con el codigo que me trae
        Producto producto = experto.buscarProducto(getPantalla().getCodigo().getText(),getPantalla().getFecha().getText());
        getPantalla().getFecha().setEnabled(false);
        getPantalla().getCodigo().setText(String.valueOf(producto.getCodigo()));
        getPantalla().getDescripcion().setText(producto.getDescripcion());
        Factura factura = experto.getFactura();
        if(factura.getTipoFactura().getNombre().equals("A") | factura.getTipoFactura().getNombre().equals("a")){
            getPantalla().getPrecioUnitario().setText(String.valueOf(producto.getPreciosHistoricos().get(0).getPrecio()));
        }else{
            float importe = producto.getPreciosHistoricos().get(0).getPrecio() * producto.getPorcentajeDeIva()/100 + producto.getPreciosHistoricos().get(0).getPrecio();
            getPantalla().getPrecioUnitario().setText(String.valueOf(importe));

        }
        //pantalla.getImporte().setText(producto.getPrecioHistorico()); // acordarse de ver si es factura a o b para colocar el importe con o sin iva //TO DO
        calcularImporteYSetearImporte();


    }

    public void calcularImporteYSetearImporte() {
        float cantidad = 0;
        float precioUnitario = 0;
        try{
            cantidad = Float.valueOf(getPantalla().getCantidad().getText());
            precioUnitario = Float.valueOf(getPantalla().getPrecioUnitario().getText());
        }catch(NumberFormatException e){
            return;
        }catch(NullPointerException ex){
            return;
        }
        float importe = cantidad * precioUnitario;
        float importeFinal = Math.round(importe * 100)/100;
        getPantalla().getImporte().setText(String.valueOf(importeFinal));


    }

    public void agregarDetalleFactura() {
        DTODetallesDeFacturaParaGUI dto = new DTODetallesDeFacturaParaGUI();
        dto.setCantidad(Float.valueOf(getPantalla().getCantidad().getText()));
        dto.setCodigo(getPantalla().getCodigo().getText());
        dto.setPrecioUnitario(Float.valueOf(getPantalla().getPrecioUnitario().getText()));
        dto.setImporte(Float.valueOf(getPantalla().getImporte().getText()));
        Factura fac = experto.AgregarDetalleALaFactura(dto);
        actualizarTablaEImpuestosYTotales(fac);
    }

    private void actualizarTablaEImpuestosYTotales(Factura fac) {
        //sacar lista de detalles de factura de la factur
        List<DetalleFactura> listaDetalles = new ArrayList<DetalleFactura>();
        getPantalla().getTablaDetallesFactura().setModel(new ModeloTablaProducto(listaDetalles));
        if(fac.getTipoFactura().getNombre().equals("A") | fac.getTipoFactura().getNombre().equals("a")){
            float subtotal = 0;
            float total = 0;
            float ivaInsc = 0;
            for (DetalleFactura detalleFactura : listaDetalles) {
                float iva = detalleFactura.getPrecioTotal() * (detalleFactura.getPorcentajeDeIva()/100);
                ivaInsc = + iva;
                total =+ detalleFactura.getPrecioTotal() + iva;
                subtotal =+ detalleFactura.getPrecioTotal();
            }
            getPantalla().getSubtotal().setText(String.valueOf(subtotal));
            getPantalla().getIvaInsc().setText(String.valueOf(ivaInsc));
            getPantalla().getTotal().setText(String.valueOf(total));

            //REVISAR LOS DE IMPUESTO Y SUBTOTAL2
        }else{
            float total = 0;
            for (DetalleFactura detalleFactura : listaDetalles) {
                total =+ detalleFactura.getPrecioTotal();
            }
            getPantalla().getTotal().setText(String.valueOf(total));
        }

    }

    public void guardarFactura() {
        experto.guardarFactura();
    }

    public void imprimir() {
        guardarFactura();
        //imprimir
    }

    public void limpiarPantalla() {
            
        int rta=JOptionPane.showConfirmDialog(pantalla,"¿Está seguro que desea cancelar todo y limpiar la pantalla?", "¡Atención!", JOptionPane.YES_NO_OPTION);
        if(rta==JOptionPane.YES_OPTION){
            //TO DO
            experto = new ExpertoFacturar();

            //Habilitar impuestos
            getPantalla().getSubtotal().setVisible(true);
            getPantalla().getSubtotalLabel().setVisible(true);

            getPantalla().getSubtotal2().setVisible(true);
            getPantalla().getSubtotal2Label().setVisible(true);

            getPantalla().getImporte().setVisible(true);
            getPantalla().getImpuestosLabel().setVisible(true);

            getPantalla().getIvaInsc().setVisible(true);
            getPantalla().getIvaIsncLabel().setVisible(true);

        }


    }



    private void cargarCondicionDeVenta() {
        //cargar la condicion de venta basado en la factura obtenida al buscar cliente
        //TODO
    }


    void compararFechaFactura() {

        int rta=JOptionPane.showConfirmDialog(pantalla,"¿Está seguro que desea cambiar la fecha?", "¡Atención!", JOptionPane.YES_NO_OPTION);

        if(rta==JOptionPane.YES_OPTION){
            try{
               experto.cambiarFechaDeFactura(getPantalla().getFecha().getText());
               experto.eliminarTodosLosDetallesDeFactura();
               actualizarTablaEImpuestosYTotales(experto.getFactura());

            }catch(fechaException e){
                JOptionPane.showMessageDialog( getPantalla(), e.getMessage(), "¡Error!", JOptionPane.INFORMATION_MESSAGE);
                getPantalla().getFecha().requestFocus();

            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(getPantalla(), "No ha ingresado ninguan fecha", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
                getPantalla().getFecha().requestFocus();


        }
        }else{
            pantalla.getFecha().setText(Validar.formatearFechaAString(experto.getFactura().getFecha()));

        }
         
    }
    
    
    void limpiarIngresoDeDetalle() {
        getPantalla().getCantidad().setText("");
        getPantalla().getCodigo().setText("");
        getPantalla().getDescripcion().setText("");
        getPantalla().getPrecioUnitario().setText("");
        getPantalla().getImporte().setText("");
    }

    void eliminarDetalle(int filaSeleccionada) {
        Factura fac = experto.eliminarDetalleFactura(filaSeleccionada);
        limpiarIngresoDeDetalle();
        getPantalla().getEliminar().setEnabled(false);
        getPantalla().getTablaDetallesFactura().setModel(new ModeloTablaProducto(fac.getDetallesDeFactura()));
    }






//ACA COMIENZA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE

    private PantallaElegirCliente pantallaElefirCliente;
    private List<Cliente> listaClientes;

    public void iniciarPantallaElegirCliente(List<Cliente> listaDeClientes) {

        pantallaElefirCliente = new PantallaElegirCliente(this);
        this.listaClientes = listaDeClientes;
        CargarTablaClientes();
        getPantalla().setVisible(true);

    }

     public  void CargarTablaClientes() {
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

    /**
     * @return the pantalla
     */
    public PantallaFacturacion getPantalla() {
        return pantalla;
    }


//ACA TERMINA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE




}
