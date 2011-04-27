/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import InterfacesGraficas.exceptions.ClienteExcepcion;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.CondicionFrenteAlIva;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
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
import javax.swing.DefaultComboBoxModel;
import Negocio.Facturacion.DtoFactura;


/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    private PantallaFacturacion pantalla;
    private ExpertoFacturar experto;
    //private Factura factura;
    private final String[] CondicionesDeVentaA = {"Contado", "Cuenta corriente"};
    private final String[] CondicionesDeVentaB = {"Contado", "Cuenta corriente", "Tarjeta"};

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
        configurarTablaInicial();
        getPantalla().setVisible(true);
        getPantalla().getAnulada().setEnabled(true);
        getPantalla().getAnulada().setSelected(false);

    }


    public void configurarTablaInicial() {

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

    public void buscarClientePorNombre(String nombre) {
        if(!(nombre.equals(""))){
            try{
                List<Cliente> listaDeClientes = experto.buscarClientePorNombre(nombre);
                if(listaDeClientes.size() == 1){
                    //si tre un solo cliente
                    experto.buscarClientePorNumero(String.valueOf(listaDeClientes.get(0).getCodigo()));
                }else{
                    //si trae muchos clientes
                    iniciarPantallaElegirCliente(listaDeClientes);
                }
            }catch(ClienteExcepcion e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNombre().requestFocus();
            }
        }else{
            if(experto.getDtoFactura().getFactura().getCliente() != null){
                pantalla.getNombre().setText(experto.getDtoFactura().getFactura().getCliente().getNombre());
                pantalla.getNombre().setEnabled(false);
            }
        }
    }

    public void buscarClientePorCuit(String cuit) {
        if(!(cuit.equals(""))){
            try{
                DtoFactura dto = experto.buscarClientePorCuit(cuit);
                cargarDatosClienteYFactura(dto);
            }catch(ClienteExcepcion e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getCuit().requestFocus();
                
            }
        }else{
            if(experto.getDtoFactura().getFactura().getCliente() != null){
                pantalla.getCuit().setText(experto.getDtoFactura().getFactura().getCliente().getCUIT());
                pantalla.getCuit().setEnabled(false);
            }
        }
    }

    public void buscarClientePorNumero(String numeroCliente) {
        if(!(numeroCliente.equals(""))){
            try{
                DtoFactura dto = experto.buscarClientePorNumero(numeroCliente);
                cargarDatosClienteYFactura(dto);
            }catch(ClienteExcepcion e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNumeroCliente().requestFocus();
                
            }
        }else{
            if(experto.getDtoFactura().getFactura().getCliente() != null){
                pantalla.getNumeroCliente().setText(String.valueOf(experto.getDtoFactura().getFactura().getCliente().getCodigo()));
                pantalla.getNumeroCliente().setEnabled(false);
            }
        }
    }


     public void cargarDatosClienteYFactura(DtoFactura dto){

        getPantalla().getNombre().setText(dto.getFactura().getCliente().getNombre());
        getPantalla().getCuit().setText(dto.getFactura().getCliente().getCUIT());
        getPantalla().getDomicilio().setText(dto.getFactura().getCliente().getDomicilio());
        getPantalla().getNumeroCliente().setText(String.valueOf(dto.getFactura().getCliente().getCodigo()));
        getPantalla().getIva().setText(dto.getFactura().getCliente().getCondicionFrenteAlIva().getNombre());
        getPantalla().getTipoFactura().setText(dto.getFactura().getTipoFactura().getNombre());
        getPantalla().getCodigoFactura().setText("N° 0" + dto.getFactura().getTipoFactura().getCodigo());
        getPantalla().getAnulada().setSelected(!dto.getFactura().isEstado());
        if(dto.getFactura().getNumero() != 0){
            getPantalla().getNumeroFactura().setText(String.valueOf(dto.getFactura().getNumero()));
        }else{
            getPantalla().getNumeroFactura().setText("");
        }
        if(dto.getFactura().getFecha() != null){
            pantalla.getFecha().setText(Validar.formatearFechaAString(dto.getFactura().getFecha()));
        }else{
            getPantalla().getFecha().setText("");
        }
        if(dto.getFactura().getRemitoNro() != 0){
            getPantalla().getRemitoNro().setText(String.valueOf(dto.getFactura().getRemitoNro()));
        }else{
            getPantalla().getRemitoNro().setText("");
        }
        if(dto.getFactura().getTipoFactura().getNombre().equals("b") | dto.getFactura().getTipoFactura().getNombre().equals("B")){
            //deshabilitar el impuestos
            getPantalla().getSubtotal().setVisible(false);
            getPantalla().getSubtotalLabel().setVisible(false);
            
            getPantalla().getIva21().setVisible(false);
            getPantalla().getIva21Label().setVisible(false);
            
            getPantalla().getIva105().setVisible(false);
            getPantalla().getIva105Label().setVisible(false);
            

            getPantalla().getCondicionDeVenta().setModel(new DefaultComboBoxModel(CondicionesDeVentaB));
        }else{

            //Habilitar impuestos
            getPantalla().getSubtotal().setVisible(true);
            getPantalla().getSubtotalLabel().setVisible(true);

            getPantalla().getIva21().setVisible(true);
            getPantalla().getIva21Label().setVisible(true);

            getPantalla().getIva105().setVisible(true);
            getPantalla().getIva105Label().setVisible(true);

            getPantalla().getCondicionDeVenta().setModel(new DefaultComboBoxModel(CondicionesDeVentaA));

        }

        pantalla.getNombre().setEnabled(false);
        pantalla.getNumeroCliente().setEnabled(false);
        pantalla.getCuit().setEnabled(false);
        

        pantalla.getFecha().setText(Validar.formatearFechaAString(dto.getFactura().getFecha()));
        actualizarTablaEImpuestosYTotales(dto);

    }



    public void habilitarCampoNombre() {
        //if(!getPantalla().getAnulada().isSelected()) //ANULADOMARCA
            getPantalla().getNombre().setEnabled(true);
    }

    public void habilitarCampoNumero() {
        //if(!getPantalla().getAnulada().isSelected()) //ANULADOMARCA
            getPantalla().getNumeroCliente().setEnabled(true);
    }

    public void habilitarCampoCuit() {
        //if(!getPantalla().getAnulada().isSelected()) //ANULADOMARCA
            getPantalla().getCuit().setEnabled(true);
    }

    public void cancelarCargaDetalle() {
        limpiarSectorDeIngresoDeDetalle();
        getPantalla().getEliminar().setEnabled(false);
    }

    public void cargarFilaDetalleParaEditar(int filaSeleccionada) {
        //cargar la fila a la que se le hizo doble clic en los campos de edición asi se modifica
        DtoFactura dto = experto.getDtoFactura();
        DetalleFactura det = dto.getListaDeDetalles().get(filaSeleccionada);
        getPantalla().getCantidad().setText(String.valueOf(det.getCantidad()));
        getPantalla().getCodigo().setText(String.valueOf(det.getProducto().getCodigo()));
        getPantalla().getDescripcion().setText(det.getProducto().getDescripcion());
        getPantalla().getPrecioUnitario().setText(String.valueOf(det.getPrecioUnitario()));
        getPantalla().getImporte().setText(String.valueOf(det.getPrecioTotal()));

    }

    public void buscarProductoYSuInformacion() {
        //buscar el producto con el codigo que me trae
            String codigo = getPantalla().getCodigo().getText();
            if(!(codigo.equals(""))){
                try{
                    Integer.parseInt(codigo);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "El código de producto ingresado no es un número entero", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    pantalla.getCodigo().requestFocus();
                    return;
                }
                Producto producto = experto.buscarProductoConFechaDeFactura(codigo);
                getPantalla().getFecha().setEnabled(false);
                getPantalla().getCodigo().setText(String.valueOf(producto.getCodigo()));
                getPantalla().getDescripcion().setText(producto.getDescripcion());
                DtoFactura dto = experto.getDtoFactura();
                if(dto.getFactura().getTipoFactura().getNombre().equals("A") | dto.getFactura().getTipoFactura().getNombre().equals("a")){
                    getPantalla().getPrecioUnitario().setText(String.valueOf(producto.getPreciosHistoricos().get(0).getPrecio()));
                }else{
                    float importe = producto.getPreciosHistoricos().get(0).getPrecio() * producto.getPorcentajeDeIva()/100 + producto.getPreciosHistoricos().get(0).getPrecio();
                    getPantalla().getPrecioUnitario().setText(String.valueOf(importe));

                }
                
                calcularImporteYSetearImporte();
        }

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

        try{
            Integer.parseInt(getPantalla().getCodigo().getText());
        }catch(NumberFormatException e){
            //no hacer nada, porque al perder el foco, trata de buscar un producto con trata de buscar el producto y lanza el cartel de error
            return;
        }
        try{
                Float.valueOf(getPantalla().getCantidad().getText());
        }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ha ingresado una cantidad incorrecta", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
                return;
        }
        if(pantalla.getCantidad().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado la cantidad", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if(pantalla.getCodigo().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado el producto", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if(pantalla.getPrecioUnitario().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado el precio unitario", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if(pantalla.getImporte().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado el importe", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
        }else{

            DTODetallesDeFacturaParaGUI dto = new DTODetallesDeFacturaParaGUI();
            dto.setCantidad(Float.valueOf(getPantalla().getCantidad().getText()));
            dto.setCodigo(getPantalla().getCodigo().getText());

            try{
                dto.setPrecioUnitario(Float.valueOf(getPantalla().getPrecioUnitario().getText()));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ha ingresado un precio unitario incorrecto", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            dto.setImporte(Float.valueOf(getPantalla().getImporte().getText()));
            DtoFactura dtoFactura = experto.AgregarDetalleALaFactura(dto);
            actualizarTablaEImpuestosYTotales(dtoFactura);
            getPantalla().getCantidad().requestFocus();
        }
    }

    private void actualizarTablaEImpuestosYTotales(DtoFactura dto) {
        //sacar lista de detalles de factura de la factura
        List<DetalleFactura> listaDetalles = dto.getListaDeDetalles();
        getPantalla().getTablaDetallesFactura().setModel(new ModeloTablaProducto(listaDetalles));
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(0).setPreferredWidth(70);  //cantidad
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(1).setPreferredWidth(70);  //codigo
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(2).setPreferredWidth(400); //descripcion
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(3).setPreferredWidth(70);  //precio unitario
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(4).setPreferredWidth(70);  //importe

        if(experto.getDtoFactura().getFactura().getCliente() != null){
            if(dto.getFactura().getTipoFactura().getNombre().equals("A") | dto.getFactura().getTipoFactura().getNombre().equals("a")){
                float subtotal = 0;
                float total = 0;
                float iva21 = 0;
                float iva105 = 0;
                for (DetalleFactura detalleFactura : listaDetalles) {
                    if(detalleFactura.getPorcentajeDeIva() == 21){
                        float iva = detalleFactura.getPrecioTotal() * (detalleFactura.getPorcentajeDeIva()/100);
                        iva21 += iva;
                        total += detalleFactura.getPrecioTotal() + iva;
                        subtotal += detalleFactura.getPrecioTotal();
                    }else{
                        float iva = detalleFactura.getPrecioTotal() * (detalleFactura.getPorcentajeDeIva()/100);
                        iva105 += iva;
                        total += detalleFactura.getPrecioTotal() + iva;
                        subtotal += detalleFactura.getPrecioTotal();
                    }
                }
                getPantalla().getSubtotal().setText(String.valueOf(subtotal));
                getPantalla().getIva21().setText(String.valueOf(iva21));
                getPantalla().getIva105().setText(String.valueOf(iva105));
                getPantalla().getTotal().setText(String.valueOf(total));

                //REVISAR LOS DE IMPUESTO Y SUBTOTAL2
            }else{
                float total = 0;
                for (DetalleFactura detalleFactura : listaDetalles) {
                    total += detalleFactura.getPrecioTotal();
                }
                getPantalla().getTotal().setText(String.valueOf(total));
            }
        }else{
            getPantalla().getSubtotal().setText(String.valueOf(""));
            getPantalla().getIva21().setText(String.valueOf(""));
            getPantalla().getIva105().setText(String.valueOf(""));
            getPantalla().getTotal().setText(String.valueOf(""));

        }
        getPantalla().getCantidad().setText("");
        getPantalla().getCodigo().setText("");
        getPantalla().getDescripcion().setText("");
        getPantalla().getImporte().setText("");
        getPantalla().getPrecioUnitario().setText("");

    }

    public void guardarFactura() {
        if(pantalla.getNumeroFactura().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado número de factura", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int numeroFactura = 0;
            try{
                Integer.parseInt(pantalla.getNumeroFactura().getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ha ingresado un número de factura incorrecto", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            experto.guardarNumeroFacutra(numeroFactura);
            //experto.guardarNumeroRemito(numeroFactura);
            //experto.guardarCondicionDeVenta(numeroFactura);
            experto.guardarFactura();
        }
    }

    public void imprimir() {
        guardarFactura();
        //imprimir
    }

    public void limpiarPantalla() {
            
        int rta=JOptionPane.showConfirmDialog(pantalla.getPanelInfoCliene(),"¿Está seguro que desea cancelar todo y limpiar la pantalla?", "¡Atención!", JOptionPane.YES_NO_OPTION);
        if(rta==JOptionPane.YES_OPTION){
            //TO DO
            experto = new ExpertoFacturar();

            //Habilitar impuestos
            getPantalla().getSubtotal().setVisible(true);
            getPantalla().getSubtotalLabel().setVisible(true);

            getPantalla().getSubtotal().setVisible(true);
            getPantalla().getSubtotalLabel().setVisible(true);

            getPantalla().getIva21().setVisible(true);
            getPantalla().getIva21Label().setVisible(true);

            getPantalla().getIva105().setVisible(true);
            getPantalla().getIva105Label().setVisible(true);

        }


    }



    

    void compararFechaFactura() {

        if(!(pantalla.getFecha().getText().equals(""))){
            int rta;
            //reviso si ya tiene fecha la factura, si tiene, pregunto si desea modificar, si no tiene, no pregunto nada
            if(experto.getDtoFactura().getFactura().getFecha()!=null){
                rta=JOptionPane.showConfirmDialog(pantalla.getPanelInfoCliene(),"¿Está seguro que desea cambiar la fecha?", "¡Atención!", JOptionPane.YES_NO_OPTION);
            }else{
                rta = JOptionPane.YES_OPTION;
            }
            //basado en la respuesta, es lo que hago
            if(rta==JOptionPane.YES_OPTION){
                
                try{
                   experto.cambiarFechaDeFactura(pantalla.getFecha().getText());
                   experto.eliminarTodosLosDetallesDeFactura();
                   actualizarTablaEImpuestosYTotales(experto.getDtoFactura());
                   pantalla.getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));

                }catch(fechaException e){
                    JOptionPane.showMessageDialog( getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Error!", JOptionPane.INFORMATION_MESSAGE);
                    if(experto.getDtoFactura().getFactura().getFecha() != null){
                        getPantalla().getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                    }else{
                        getPantalla().getFecha().setText("");
                    }
                    getPantalla().getFecha().requestFocus();

                }catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado fecha", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
                    if(experto.getDtoFactura().getFactura().getFecha() != null){
                        getPantalla().getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                    }else{
                        getPantalla().getFecha().setText("");
                    }
                    getPantalla().getFecha().requestFocus();

                }
        }
        }else{
            if(experto.getDtoFactura().getFactura().getFecha()==null){
                pantalla.getFecha().setText("");
            }else{
                pantalla.getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
            }
        }
         
    }
    
    
    void limpiarSectorDeIngresoDeDetalle() {
        getPantalla().getCantidad().setText("");
        getPantalla().getCodigo().setText("");
        getPantalla().getDescripcion().setText("");
        getPantalla().getPrecioUnitario().setText("");
        getPantalla().getImporte().setText("");
    }

    void eliminarDetalle(int filaSeleccionada) {
        DtoFactura dto = experto.eliminarDetalleFactura(filaSeleccionada);
        limpiarSectorDeIngresoDeDetalle();
        getPantalla().getEliminar().setEnabled(false);
        actualizarTablaEImpuestosYTotales(dto);

    }

    void ponerFechaEnModoIngreso() {



        if(!(pantalla.getFecha().getText().equals(""))){
            pantalla.getFecha().setText(Validar.formatearFechaConBarrasAFechaConFormatoDeIngreso(pantalla.getFecha().getText()));

        }
    }

    void verificarSiHayCliente() {

        if(experto.getDtoFactura().getFactura().getFecha() == null){
            getPantalla().getFecha().requestFocus();
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Antes de seleccionar un producto debe ingresar la fecha de facturación", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if(experto.getDtoFactura().getFactura().getCliente() == null){
            getPantalla().getNombre().requestFocus();
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Antes de seleccionar un producto debe seleccionar un cliente", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

     /**
     * @return the pantalla
     */
    public PantallaFacturacion getPantalla() {
        return pantalla;
    }

    
    public void iniciarBusquedaDeFactura() {
        iniciarPantallaBuscarFacura();
        
    }

    private void cargarDatosFacturaAbierta(DtoFactura dto) {
        cargarDatosClienteYFactura(dto);
        actualizarTablaEImpuestosYTotales(dto);
        pantalla.getAnulada().setEnabled(true);
        
    }


    private void bloquearTodo(){

        getPantalla().getNombre().setEnabled(false);
        getPantalla().getCuit().setEnabled(false);
        getPantalla().getDomicilio().setEnabled(false);
        getPantalla().getNumeroCliente().setEnabled(false);
        getPantalla().getIva().setEnabled(false);
        getPantalla().getTipoFactura().setEnabled(false);
        getPantalla().getCodigoFactura().setEnabled(false);


            //deshabilitar el impuestos
            getPantalla().getSubtotal().setEnabled(false);
            getPantalla().getSubtotalLabel().setEnabled(false);

            getPantalla().getIva21().setEnabled(false);
            getPantalla().getIva21Label().setEnabled(false);

            getPantalla().getIva105().setEnabled(false);
            getPantalla().getIva105Label().setEnabled(false);


            getPantalla().getCondicionDeVenta().setEnabled(false);


        pantalla.getNombre().setEnabled(false);
        pantalla.getNumeroCliente().setEnabled(false);
        pantalla.getCuit().setEnabled(false);


        pantalla.getFecha().setEnabled(false);
        getPantalla().getNumeroFactura().setEnabled(false);

        pantalla.getCantidad().setEnabled(false);
        pantalla.getCodigo().setEnabled(false);
        pantalla.getDescripcion().setEnabled(false);
        pantalla.getPrecioUnitario().setEnabled(false);
        pantalla.getImporte().setEnabled(false);
        pantalla.getAgregar().setEnabled(false);
        pantalla.getEliminar().setEnabled(false);
        pantalla.getCancelarDetalle().setEnabled(false);
        pantalla.getTablaDetallesFactura().setEnabled(false);

    }

     public void anularFactura() {
        if(pantalla.getAnulada().isSelected()){
            DtoFactura dto= experto.anularFactura();
            //bloquearTodo();  //ANULADOMARCA
        }else{
            DtoFactura dto= experto.desanularFactura();
            //desbloquearTodo();
        }
    }

    private void desbloquearTodo() {


        getPantalla().getCondicionDeVenta().setEnabled(false);
        getPantalla().getNumeroFactura().setEnabled(true);

        pantalla.getCantidad().setEnabled(true);
        pantalla.getCodigo().setEnabled(true);
        pantalla.getDescripcion().setEnabled(true);
        pantalla.getPrecioUnitario().setEnabled(true);
        pantalla.getImporte().setEnabled(true);
        pantalla.getAgregar().setEnabled(true);
        pantalla.getCancelarDetalle().setEnabled(true);
        pantalla.getTablaDetallesFactura().setEnabled(true);
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

//ACA TERMINA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE



//ACA COMIENZA EL CONTROL DE LA PANTALLA PARA BUSCAR FACTURA

     private PantallaBuscarFactura pantallaBuscarFactura;

     public void iniciarPantallaBuscarFacura() {

        pantallaBuscarFactura = new PantallaBuscarFactura(this);
        getPantalla().setVisible(true);

    }

     public void buscarFactura(String numero) {
        try{
            int numeroInt = Integer.parseInt(numero);
            FacturaJpaController jpa = new FacturaJpaController();
            pantallaBuscarFactura.dispose();
            DtoFactura dto = experto.abrirFactura(numeroInt);
            cargarDatosFacturaAbierta(dto);
        }catch(NumberFormatException e){
            pantallaBuscarFactura.dispose();
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Lo ingresado no es un número", "¡Error!", JOptionPane.INFORMATION_MESSAGE);
            iniciarBusquedaDeFactura();
        }

    }

   


   
//ACA TERMINA EL CONTROL DE LA PANTALLA PARA BUSCAR FACUTURA




}
