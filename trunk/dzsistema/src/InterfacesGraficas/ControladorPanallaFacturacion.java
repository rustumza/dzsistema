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
import Negocio.Facturacion.ExpertoFacturar;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.lang.Math.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;

/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    private PantallaFacturacion pantalla;
    private ExpertoFacturar experto;
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

        pantalla.getNombre().setText(factura.getCliente().getNombre());
        pantalla.getCuit().setText(factura.getCliente().getCUIT());
        pantalla.getDomicilio().setText(factura.getCliente().getDomicilio());
        pantalla.getNumeroCliente().setText(String.valueOf(factura.getCliente().getCodigo()));
        pantalla.getIva().setText(factura.getCliente().getCondicionFrenteAlIva().getNombre());
        pantalla.getTipoFactura().setText(factura.getTipoFactura().getNombre());
        pantalla.getCodigoFactura().setText("N° 0" + factura.getTipoFactura().getCodigo());
        
        if(factura.getTipoFactura().getNombre().equals("b") | factura.getTipoFactura().getNombre().equals("B")){
            //deshabilitar el impuestos
            pantalla.getSubtotal().setVisible(false);
            pantalla.getSubtotalLabel().setVisible(false);
            
            pantalla.getSubtotal2().setVisible(false);
            pantalla.getSubtotal2Label().setVisible(false);
            
            pantalla.getImporte().setVisible(false);
            pantalla.getImpuestosLabel().setVisible(false);
            
            pantalla.getIvaInsc().setVisible(false);
            pantalla.getIvaIsncLabel().setVisible(false);
        }else{

            //Habilitar impuestos
            pantalla.getSubtotal().setVisible(true);
            pantalla.getSubtotalLabel().setVisible(true);

            pantalla.getSubtotal2().setVisible(true);
            pantalla.getSubtotal2Label().setVisible(true);

            pantalla.getImporte().setVisible(true);
            pantalla.getImpuestosLabel().setVisible(true);

            pantalla.getIvaInsc().setVisible(true);
            pantalla.getIvaIsncLabel().setVisible(true);

        }
        

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
        limpiarIngresoDeDetalle();
        pantalla.getEliminar().setEnabled(false);
    }

    public void cargarFilaDetalleParaEditar(int filaSeleccionada) {
        //cargar la fila a la que se le hizo doble clic en los campos de edición asi se modifica
        Factura fac = experto.getFactura();
        DetalleFactura det = fac.getDetallesDeFactura().get(filaSeleccionada);
        pantalla.getCantidad().setText(String.valueOf(det.getCantidad()));
        pantalla.getCodigo().setText(String.valueOf(det.getProducto().getCodigo()));
        pantalla.getDescripcion().setText(det.getProducto().getDescripcion());
        pantalla.getPrecioUnitario().setText(String.valueOf(det.getPrecioUnitario()));
        pantalla.getImporte().setText(String.valueOf(det.getPrecioTotal()));

    }

    public void buscarProductoYSuInformacion() {
        //buscar el producto con el codigo que me trae
        Producto producto = experto.buscarProducto(pantalla.getCodigo().getText(),pantalla.getFecha().getText());
        pantalla.getFecha().setEnabled(false);
        pantalla.getCodigo().setText(String.valueOf(producto.getCodigo()));
        pantalla.getDescripcion().setText(producto.getDescripcion());
        Factura factura = experto.getFactura();
        if(factura.getTipoFactura().getNombre().equals("A") | factura.getTipoFactura().getNombre().equals("a")){
            pantalla.getPrecioUnitario().setText(String.valueOf(producto.getPreciosHistoricos().get(0).getPrecio()));
        }else{
            float importe = producto.getPreciosHistoricos().get(0).getPrecio() * producto.getPorcentajeDeIva()/100 + producto.getPreciosHistoricos().get(0).getPrecio();
            pantalla.getPrecioUnitario().setText(String.valueOf(importe));

        }
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

    public void agregarDetalleFactura() {
        DTODetallesDeFacturaParaGUI dto = new DTODetallesDeFacturaParaGUI();
        dto.setCantidad(Float.valueOf(pantalla.getCantidad().getText()));
        dto.setCodigo(pantalla.getCodigo().getText());
        dto.setPrecioUnitario(Float.valueOf(pantalla.getPrecioUnitario().getText()));
        dto.setImporte(Float.valueOf(pantalla.getImporte().getText()));
        Factura fac = experto.AgregarDetalleALaFactura(dto);
        actualizarTablaEImpuestosYTotales(fac);
    }

    private void actualizarTablaEImpuestosYTotales(Factura fac) {
        //sacar lista de detalles de factura de la factur
        List<DetalleFactura> listaDetalles = new ArrayList<DetalleFactura>();
        pantalla.getTablaDetallesFactura().setModel(new ModeloTablaProducto(listaDetalles));
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
            pantalla.getSubtotal().setText(String.valueOf(subtotal));
            pantalla.getIvaInsc().setText(String.valueOf(ivaInsc));
            pantalla.getTotal().setText(String.valueOf(total));

            //REVISAR LOS DE IMPUESTO Y SUBTOTAL2
        }else{
            float total = 0;
            for (DetalleFactura detalleFactura : listaDetalles) {
                total =+ detalleFactura.getPrecioTotal();
            }
            pantalla.getTotal().setText(String.valueOf(total));
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
        //TO DO
        experto = new ExpertoFacturar();

        //Habilitar impuestos
        pantalla.getSubtotal().setVisible(true);
        pantalla.getSubtotalLabel().setVisible(true);

        pantalla.getSubtotal2().setVisible(true);
        pantalla.getSubtotal2Label().setVisible(true);

        pantalla.getImporte().setVisible(true);
        pantalla.getImpuestosLabel().setVisible(true);

        pantalla.getIvaInsc().setVisible(true);
        pantalla.getIvaIsncLabel().setVisible(true);
    }



    private void cargarCondicionDeVenta() {
        //cargar la condicion de venta basado en la factura obtenida al buscar cliente
        //TODO
    }


    void compararFechaFactura() {
        
        try{
            Factura factura = experto.cambiarFechaDeFactura(pantalla.getFecha().getText());
            panta
        }catch(fechaException e){

            

        }
        //Mostrar pantalla para preguntar si quiere modificar la fecha

        //si quiere modificar, eliminar los detalles de la factura
        //sino, dejar todo como esta y no cambiar la fecha
    }
    
    
    void limpiarIngresoDeDetalle() {
        pantalla.getCantidad().setText("");
        pantalla.getCodigo().setText("");
        pantalla.getDescripcion().setText("");
        pantalla.getPrecioUnitario().setText("");
        pantalla.getImporte().setText("");
    }

    void eliminarDetalle(int filaSeleccionada) {
        Factura fac = experto.eliminarDetalleFactura(filaSeleccionada);
        limpiarIngresoDeDetalle();
        pantalla.getEliminar().setEnabled(false);
        pantalla.getTablaDetallesFactura().setModel(new ModeloTablaProducto(fac.getDetallesDeFactura()));
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

    private Date validarFechaIngresada(String fecha) throws fechaException {
        if(fecha.length()!=6){
            throw new fechaException(1);
        }
        try {
            String dia = fecha.substring(0, 2);
            Integer.valueOf(dia);
            String mes = fecha.substring(2, 4);
            Integer.valueOf(mes);
            String anio = fecha.substring(4, 6);
            Integer.valueOf(anio);
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date fechaDate = formatoFecha.parse(dia + "/" + mes + "/20" + anio );
            return fechaDate;
        }catch(NumberFormatException ne){
            throw new fechaException(2);
        }catch(ParseException e) {
            throw new fechaException(3);
        }

    }

    private String formatearFecha(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        return formatoFecha.format(fecha);
    
    }


}
