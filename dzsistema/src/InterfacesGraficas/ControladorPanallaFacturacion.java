/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import Impresion.ControladorImpresionFactura;
import InterfacesGraficas.exceptions.ClienteExcepcion;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.DetalleFactura;
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
import javax.swing.DefaultComboBoxModel;
import Negocio.Facturacion.DtoFactura;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;



/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    private PantallaFacturacion pantalla;
    private ExpertoFacturar experto;
    //private Factura factura;
    private final String[] CondicionesDeVentaA = {"Contado", "Cuenta Corriente"};
    private final String[] CondicionesDeVentaB = {"Contado", "Cuenta Corriente", "Tarjeta"};


    boolean guardado = false;

    public ControladorPanallaFacturacion() {
        experto = new ExpertoFacturar();
    }
     public boolean isGuardado() {
        return guardado;
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
        getPantalla().getAnulada().setEnabled(false);
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
                    buscarClientePorNumero(String.valueOf(listaDeClientes.get(0).getCodigo()));
                    getPantalla().getCondicionDeVenta().requestFocus();
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
                getPantalla().getCondicionDeVenta().requestFocus();
            }else{
                getPantalla().getNumeroCliente().requestFocus();
            }
        }
    }


    public void buscarClientePorNumero(String numeroCliente) {
        if(!(numeroCliente.equals(""))){
            try{
                DtoFactura dto = experto.buscarClientePorNumero(numeroCliente);
                cargarDatosClienteYFactura(dto);
                actualizarTablaEImpuestosYTotales(dto);
                getPantalla().getCondicionDeVenta().requestFocus();
            }catch(ClienteExcepcion e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNumeroCliente().requestFocus();

            }
        }else{
            if(experto.getDtoFactura().getFactura().getCliente() != null){
                pantalla.getNumeroCliente().setText(String.valueOf(experto.getDtoFactura().getFactura().getCliente().getCodigo()));
                pantalla.getNumeroCliente().setEnabled(false);
                getPantalla().getCondicionDeVenta().requestFocus();
            }else{
                getPantalla().getCuit().requestFocus();
            }
        }
    }

    public void buscarClientePorCuit(String cuitSinFormato) {
        if(!(cuitSinFormato.equals(""))){
            if(Validar.controlCUIT(cuitSinFormato)){
                String cuit = Validar.formatearCUIT(cuitSinFormato);
                try{
                    DtoFactura dto = experto.buscarClientePorCuit(cuit);
                    cargarDatosClienteYFactura(dto);
                    actualizarTablaEImpuestosYTotales(dto);
                    getPantalla().getCondicionDeVenta().requestFocus();
                }catch(ClienteExcepcion e){
                    JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    pantalla.getCuit().requestFocus();

                }
            }else{
                JOptionPane.showMessageDialog(null, "El CUIT ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getCuit().requestFocus();
            }
        }else{
            if(experto.getDtoFactura().getFactura().getCliente() != null){
                pantalla.getCuit().setText(experto.getDtoFactura().getFactura().getCliente().getCUIT());
                pantalla.getCuit().setEnabled(false);
                getPantalla().getCondicionDeVenta().requestFocus();
            }else{
                getPantalla().getNombre().requestFocus();
            }
        }

    }

    


     public void cargarDatosClienteYFactura(DtoFactura dto){

        if(dto.getFactura().getCliente() != null){
            getPantalla().getNombre().setText(dto.getFactura().getCliente().getNombre());
            getPantalla().getCuit().setText(dto.getFactura().getCliente().getCUIT());
            getPantalla().getDomicilio().setText(dto.getFactura().getCliente().getDomicilio());
            getPantalla().getNumeroCliente().setText(String.valueOf(dto.getFactura().getCliente().getCodigo()));
            getPantalla().getIva().setText(dto.getFactura().getCliente().getCondicionFrenteAlIva().getNombre());
            getPantalla().getTipoFactura().setText(dto.getFactura().getTipoFactura().getNombre());
            getPantalla().getCodigoFactura().setText("N° 0" + dto.getFactura().getTipoFactura().getCodigo());
            pantalla.getNombre().setEnabled(false);
            pantalla.getNumeroCliente().setEnabled(false);
            pantalla.getCuit().setEnabled(false);

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
        }else{
            getPantalla().getNombre().setText("");
            getPantalla().getCuit().setText("");
            getPantalla().getDomicilio().setText("");
            getPantalla().getNumeroCliente().setText("");
            getPantalla().getIva().setText("");
            getPantalla().getTipoFactura().setText("");
            getPantalla().getCodigoFactura().setText("");
            pantalla.getNombre().setEnabled(true);
            pantalla.getNumeroCliente().setEnabled(true);
            pantalla.getCuit().setEnabled(true);
            getPantalla().getSubtotal().setVisible(true);
            getPantalla().getSubtotalLabel().setVisible(true);

            getPantalla().getIva21().setVisible(true);
            getPantalla().getIva21Label().setVisible(true);

            getPantalla().getIva105().setVisible(true);
            getPantalla().getIva105Label().setVisible(true);
            getPantalla().getCondicionDeVenta().setModel(new DefaultComboBoxModel());

        }

        
        
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
        getPantalla().getAgregar().setText("Agregar");
        filaAEditar = -1;
        getPantalla().getCantidad().requestFocus();
    }

    private int filaAEditar=-1;

    public void cargarFilaDetalleParaEditar(int filaSeleccionada) {
        //cargar la fila a la que se le hizo doble clic en los campos de edición asi se modifica
        DtoFactura dto = experto.getDtoFactura();
        DetalleFactura det = dto.getListaDeDetalles().get(filaSeleccionada);
        getPantalla().getCantidad().setText(String.valueOf(det.getCantidad()));
        getPantalla().getCodigo().setText(String.valueOf(det.getProducto().getCodigo()));
        getPantalla().getDescripcion().setText(det.getProducto().getDescripcion());
        getPantalla().getPrecioUnitario().setText(String.valueOf(det.getPrecioUnitario()));
        getPantalla().getImporte().setText(String.valueOf(det.getPrecioTotal()));
        getPantalla().getAgregar().setText("Actualizar");
        filaAEditar=filaSeleccionada;


    }

    public void buscarProductoYSuInformacion() {
        //buscar el producto con el codigo que me trae
            String codigo = getPantalla().getCodigo().getText();
            if(!(codigo.equals(""))){
                try{
                    Integer.parseInt(codigo);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "El código de producto ingresado no es un número", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    pantalla.getCodigo().requestFocus();
                    return;
                }
                Producto producto = experto.buscarProductoConFechaDeFactura(codigo);
                if(producto != null ){
                    getPantalla().getFecha().setEnabled(false);
                    getPantalla().getCodigo().setText(String.valueOf(producto.getCodigo()));
                    getPantalla().getDescripcion().setText(producto.getDescripcion());
                    DtoFactura dto = experto.getDtoFactura();
                    if(dto.getFactura().getTipoFactura().getNombre().equals("A") | dto.getFactura().getTipoFactura().getNombre().equals("a")){
                        getPantalla().getPrecioUnitario().setText(String.valueOf(producto.getPreciosHistoricos().get(0).getPrecio()));
                    }else{
                        float importe = producto.getPreciosHistoricos().get(0).getPrecio() * producto.getPorcentajeDeIva()/100 + producto.getPreciosHistoricos().get(0).getPrecio();
                        importe = ((float)Math.round(importe * 100))/100;
                        getPantalla().getPrecioUnitario().setText(String.valueOf(importe));

                    }

                    calcularImporteYSetearImporte();
                    pantalla.getPrecioUnitario().requestFocus();
                }else{
                    JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No se ha encontrado el producto buscado", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    pantalla.getCodigo().requestFocus();
                    return;
                }
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
        float importeFinal = ((float)Math.round(importe * 100))/100;
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
                float a = Float.valueOf(getPantalla().getCantidad().getText());
                if(a<=0){
                    JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ha ingresado una cantidad incorrecta", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    getPantalla().getCantidad().requestFocus();
                    return;
                }
        }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ha ingresado una cantidad incorrecta", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                getPantalla().getCantidad().requestFocus();
                return;
        }
        try{
            Float.valueOf(getPantalla().getPrecioUnitario().getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ha ingresado un precio unitario incorrecto", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(pantalla.getCantidad().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Escriba una cantidad válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            getPantalla().getCantidad().requestFocus();
            return;
        }else if(pantalla.getCodigo().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado el producto", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            getPantalla().getCodigo().requestFocus();
            return;
        }else if(pantalla.getPrecioUnitario().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Esciba un precio unitario válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            getPantalla().getPrecioUnitario().requestFocus();
            return;
        }else if(pantalla.getImporte().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No ha ingresado el importe", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            getPantalla().getImporte().requestFocus();
            return;
        }else{
            DtoFactura dtoFactura = null;
            if(filaAEditar == -1){
                if(experto.getDtoFactura().getListaDeDetalles().size() < 15){
                    DTODetallesDeFacturaParaGUI dto = new DTODetallesDeFacturaParaGUI();
                    dto.setCantidad(Float.valueOf(getPantalla().getCantidad().getText()));
                    dto.setCodigo(getPantalla().getCodigo().getText());
                    dto.setPrecioUnitario(Float.valueOf(getPantalla().getPrecioUnitario().getText()));
                    dto.setImporte(Float.valueOf(getPantalla().getImporte().getText()));
                    for (DetalleFactura deta : experto.getDtoFactura().getListaDeDetalles()) {
                        if(deta.getProducto().getCodigo() == Integer.parseInt(dto.getCodigo())){
                            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ya se ha ingresado este producto en esta factura", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                            getPantalla().getCodigo().requestFocus();
                            return;
                        }
                    }
                    dtoFactura = experto.AgregarDetalleALaFactura(dto);
                }else{
                    JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ha llegado al límite de productos que puede vender por factura (15 productos)", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    dtoFactura = experto.getDtoFactura();
                    actualizarTablaEImpuestosYTotales(dtoFactura);
                    getPantalla().getCantidad().requestFocus();
                    return;
                }
            }else{
                DTODetallesDeFacturaParaGUI dto = new DTODetallesDeFacturaParaGUI();
                dto.setCantidad(Float.valueOf(getPantalla().getCantidad().getText()));
                dto.setCodigo(getPantalla().getCodigo().getText());
                dto.setPrecioUnitario(Float.valueOf(getPantalla().getPrecioUnitario().getText()));
                dto.setImporte(Float.valueOf(getPantalla().getImporte().getText()));
                for (DetalleFactura deta : experto.getDtoFactura().getListaDeDetalles()) {
                    if(deta.getProducto().getCodigo() == Integer.parseInt(dto.getCodigo())){
                        if(deta != experto.getDtoFactura().getListaDeDetalles().get(filaAEditar)){
                            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ya se ha ingresado este producto en esta factura", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }
                dtoFactura = experto.editarDetalleALaFactura(dto, filaAEditar);

            }
            actualizarTablaEImpuestosYTotales(dtoFactura);
            getPantalla().getCantidad().requestFocus();
            getPantalla().getAgregar().setText("Agregar");
            filaAEditar = -1;
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

        //alinear a la derecha las columnas
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.RIGHT);
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(0).setCellRenderer(tcr); //cantidad
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(1).setCellRenderer(tcr); //codigo
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(3).setCellRenderer(tcr); //precio unitario
        getPantalla().getTablaDetallesFactura().getColumnModel().getColumn(4).setCellRenderer(tcr); //importe

        if(dto.getFactura().getCliente() != null){
            if(dto.getFactura().getTipoFactura().getNombre().equals("A") | dto.getFactura().getTipoFactura().getNombre().equals("a")){
                float subtotal = 0;
                float total = 0;
                float iva21 = 0;
                float iva105 = 0;
                for (DetalleFactura detalleFactura : listaDetalles) {
                    if(detalleFactura.getPorcentajeDeIva() == 21){
                        float iva = detalleFactura.getPrecioTotal() * (detalleFactura.getPorcentajeDeIva()/100);
                        iva = ((float)Math.round(iva * 100))/100;
                        iva21 += iva;
                        total += detalleFactura.getPrecioTotal() + iva;
                        subtotal += detalleFactura.getPrecioTotal();
                    }else{
                        float iva = detalleFactura.getPrecioTotal() * (detalleFactura.getPorcentajeDeIva()/100);
                        iva = ((float)Math.round(iva * 100))/100;
                        iva105 += iva;
                        total += detalleFactura.getPrecioTotal() + iva;
                        subtotal += detalleFactura.getPrecioTotal();
                    }
                }

                total = ((float)Math.round(total * 100))/100;
                subtotal = ((float)Math.round(subtotal * 100))/100;
                iva105 = ((float)Math.round(iva105 * 100))/100;
                iva21 = ((float)Math.round(iva21 * 100))/100;
                experto.settotal(total);
                experto.setSubtotal(subtotal);
                experto.setIva105(iva105);
                experto.setIva21(iva21);
                getPantalla().getSubtotal().setText(Validar.formatearFloatAStringConDosDecimalesYPunto(subtotal));
                getPantalla().getIva21().setText(Validar.formatearFloatAStringConDosDecimalesYPunto(iva21));
                getPantalla().getIva105().setText(Validar.formatearFloatAStringConDosDecimalesYPunto(iva105));
                getPantalla().getTotal().setText(Validar.formatearFloatAStringConDosDecimalesYPunto(total));

                //REVISAR LOS DE IMPUESTO Y SUBTOTAL2
            }else{
                float total = 0;
                for (DetalleFactura detalleFactura : listaDetalles) {
                    total += detalleFactura.getPrecioTotal();
                }
                total = ((float)Math.round(total * 100))/100;
                experto.settotal(total);
                getPantalla().getTotal().setText(Validar.formatearFloatAStringConDosDecimalesYPunto(total));
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
        getPantalla().getEliminar().setEnabled(false);

    }

    public int guardarFactura() {
        pantalla.getGuardar().setEnabled(false);
        pantalla.getImprimir().setEnabled(false);
        bloquearTodo();
        if(pantalla.getNumeroFactura().getText().equals("")){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Escriba un número de factura válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            desbloquearParcial();
            getPantalla().getNumeroFactura().requestFocus();
            return 1;
        }else{
            long numeroFactura = 0;
            try{
                numeroFactura = Long.parseLong(pantalla.getNumeroFactura().getText());
                experto.guardarNumeroFacutra(numeroFactura);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "El número de factura no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getGuardar().setEnabled(true);
                pantalla.getImprimir().setEnabled(true);
                desbloquearParcial();
                getPantalla().getNumeroFactura().requestFocus();
                return 1;
            }
        }

        if(experto.getDtoFactura().isEsFacuraNueva() && experto.existeFacturaConEseNumeroDeFactura()){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Ya existe una factura con este número de factura", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            desbloquearParcial();
            getPantalla().getNumeroFactura().requestFocus();
            return 1;
        }

        if(!experto.esPosteriorFechaDeFacturaRespectoAFacturasAnteriores()){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "La fecha ingresada debe ser posterior a la de las facturas anteriores", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            desbloquearTodo();
            getPantalla().getFecha().requestFocus();
            return 1;

        }

        if(!pantalla.getRemitoNro().getText().equals("")){
            long nroRemito = 0;
            try{
                nroRemito = Long.parseLong(pantalla.getRemitoNro().getText());
                experto.guardarNumeroRemito(nroRemito);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "El número de remito no es váildo", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getGuardar().setEnabled(true);
                pantalla.getImprimir().setEnabled(true);
                desbloquearParcial();
                getPantalla().getRemitoNro().requestFocus();
                return 1;
            }
        }

        DtoFactura dto = experto.getDtoFactura();
        if(dto.getFactura().getCliente() == null){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No se ha seleccionado un cliente", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            desbloquearTodo();
            getPantalla().getNombre().requestFocus();
            return 1;
        }

        int condDeVenta = 1;
        if(pantalla.getCondicionDeVenta().getModel().getSelectedItem().equals("Contado")){
            condDeVenta = 1;
        }
        else if(pantalla.getCondicionDeVenta().getModel().getSelectedItem().equals("Cuenta Corriente")){
            condDeVenta = 2;
        }
        else if(pantalla.getCondicionDeVenta().getModel().getSelectedItem().equals("Tarjeta")){
            condDeVenta = 3;
        }
        experto.guardarCondicionDeVenta(condDeVenta);


        
        if(dto.getFactura().getFecha() == null){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Escriba una fecha válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            desbloquearTodo();
            getPantalla().getFecha().requestFocus();
            return 1;
        }

        if(dto.getListaDeDetalles().isEmpty()){
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No se han agregado productos", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            desbloquearParcial();
            getPantalla().getCantidad().requestFocus();
            return 1;
        }

        try{
            experto.guardarFactura();
            guardado = true;
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Factura guardada", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getImprimir().setEnabled(true);
            return 0;

        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Error al guardar la factura", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            desbloquearTodo();
            return 1;
        }

        
        
        
    }

    public void imprimir() {
        int retorno = 0;
        if(!guardado){
            retorno = guardarFactura();
            guardado = true;
        }
        if(retorno == 0){
            if(experto.getDtoFactura().getFactura() != null){
                ControladorImpresionFactura contImp = new ControladorImpresionFactura();
                contImp.imprimir(experto.getDtoFactura().getFactura());
            }else{
                JOptionPane.showMessageDialog( getPantalla().getPanelInfoCliene(), "Error al imprimir, no se a creado una factura", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void limpiarPantalla() {
        int rta = JOptionPane.NO_OPTION;
        rta=JOptionPane.showConfirmDialog(pantalla.getPanelInfoCliene(),"¿Está seguro que desea cancelar todo y limpiar la pantalla?", "¡Atención!", JOptionPane.YES_NO_OPTION);
        if(rta==JOptionPane.YES_OPTION){
            //TO DO
            experto = new ExpertoFacturar();
            cargarDatosClienteYFactura(experto.getDtoFactura());
            actualizarTablaEImpuestosYTotales(experto.getDtoFactura());
            pantalla.getAnulada().setEnabled(false);
            desbloquearTodo();
            pantalla.getGuardar().setEnabled(true);
            pantalla.getImprimir().setEnabled(true);
            guardado = false;
            pantalla.getAgregar().setText("Agregar");
        }

    }

    public void limpiarSoloPantalla(){
     
        pantalla.getAnulada().setEnabled(false);
        desbloquearTodo();
        pantalla.getGuardar().setEnabled(true);
        pantalla.getImprimir().setEnabled(true);
        pantalla.getAgregar().setText("Agregar");
        guardado = false;

    }



    

    void compararFechaFactura() {

        if(!(pantalla.getFecha().getText().equals(""))){
            int rta;
            //reviso si ya tiene fecha la factura, si tiene, pregunto si desea modificar, si no tiene, no pregunto nada
                if(experto.getDtoFactura().getFactura().getFecha()!=null){
                    try{
                        Date fech = Validar.validarFecha(pantalla.getFecha().getText());
                        if(fech.compareTo(experto.getDtoFactura().getFactura().getFecha())==0){
                            pantalla.getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                            return;
                        }
                    }catch(fechaException e){
                        JOptionPane.showMessageDialog( getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                        if(experto.getDtoFactura().getFactura().getFecha() != null){
                            getPantalla().getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                        }else{
                            getPantalla().getFecha().setText("");
                        }
                        getPantalla().getFecha().requestFocus();

                    }catch(NullPointerException ex){
                        JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Escriba una fecha válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                        if(experto.getDtoFactura().getFactura().getFecha() != null){
                            getPantalla().getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                        }else{
                            getPantalla().getFecha().setText("");
                        }
                        getPantalla().getFecha().requestFocus();

                    }
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
                        if(e.getCodigo() == 5){
                            JOptionPane.showMessageDialog( getPantalla().getPanelInfoCliene(), "Ha ingresado una fecha anterior al 06/06/2010", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog( getPantalla().getPanelInfoCliene(), e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if(experto.getDtoFactura().getFactura().getFecha() != null){
                            getPantalla().getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                        }else{
                            getPantalla().getFecha().setText("");
                        }
                        getPantalla().getFecha().requestFocus();

                    }catch(NullPointerException ex){
                        JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Escriba una fecha válida", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                        if(experto.getDtoFactura().getFactura().getFecha() != null){
                            getPantalla().getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                        }else{
                            getPantalla().getFecha().setText("");
                        }
                        getPantalla().getFecha().requestFocus();

                    }

                }else{
                    if(experto.getDtoFactura().getFactura().getFecha()==null){
                        pantalla.getFecha().setText("");
                    }else{
                        pantalla.getFecha().setText(Validar.formatearFechaAString(experto.getDtoFactura().getFactura().getFecha()));
                    }
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
        pantalla.getAgregar().setText("Agregar");
        filaAEditar = -1;
        getPantalla().getCantidad().requestFocus();

    }

    void ponerFechaEnModoIngreso() {

        if(!(pantalla.getFecha().getText().equals(""))){
            pantalla.getFecha().setText(Validar.formatearFechaConBarrasAFechaConFormatoDeIngreso(pantalla.getFecha().getText()));

        }
    }

    void verificarSiHayCliente() {

        if(experto.getDtoFactura().getFactura().getFecha() == null){
            getPantalla().getFecha().requestFocus();
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Antes de seleccionar un producto debe ingresar la fecha de facturación", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
        }else if(experto.getDtoFactura().getFactura().getCliente() == null){
            getPantalla().getNombre().requestFocus();
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "Antes de seleccionar un producto debe seleccionar un cliente", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
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
        getPantalla().getIva().setEnabled(false);
        getPantalla().getTipoFactura().setEnabled(false);
        getPantalla().getCodigoFactura().setEnabled(false);
        pantalla.getNumeroCliente().setEnabled(false);



        getPantalla().getCondicionDeVenta().setEnabled(false);
        getPantalla().getRemitoNro().setEnabled(false);

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

    private void desbloquearParcial() {


        getPantalla().getCondicionDeVenta().setEnabled(true);
        getPantalla().getRemitoNro().setEnabled(true);
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

    private void desbloquearTodo() {


        getPantalla().getCondicionDeVenta().setEnabled(true);
        getPantalla().getRemitoNro().setEnabled(true);
        getPantalla().getNumeroFactura().setEnabled(true);

        pantalla.getCantidad().setEnabled(true);
        pantalla.getCodigo().setEnabled(true);
        pantalla.getDescripcion().setEnabled(true);
        pantalla.getPrecioUnitario().setEnabled(true);
        pantalla.getImporte().setEnabled(true);
        pantalla.getAgregar().setEnabled(true);
        pantalla.getCancelarDetalle().setEnabled(true);
        pantalla.getTablaDetallesFactura().setEnabled(true);




        getPantalla().getNombre().setEnabled(true);
        getPantalla().getNumeroCliente().setEnabled(true);
        getPantalla().getCuit().setEnabled(true);
        getPantalla().getDomicilio().setEnabled(true);
        getPantalla().getIva().setEnabled(true);
        getPantalla().getTipoFactura().setEnabled(true);
        getPantalla().getCodigoFactura().setEnabled(true);


        pantalla.getFecha().setEnabled(true);

    }


    public void guardarNumeroFactura() {
        if(!pantalla.getNumeroFactura().getText().equals("")){
            try{
                long numero = Long.parseLong(pantalla.getNumeroFactura().getText());
                experto.guardarNumeroFacutra(numero);
                
            }catch(NumberFormatException e){                
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "El número de factura ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNumeroFactura().requestFocus();
            }
        }
    }


    void colocarCuitEnFormatoParaEditar() {
        pantalla.getCuit().setText(Validar.desformatearCUIT(pantalla.getCuit().getText()));
    }



//ACA COMIENZA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE

    private PantallaElegirCliente pantallaElefirCliente;
    private List<Cliente> listaClientes;

    public void iniciarPantallaElegirCliente(List<Cliente> listaDeClientes) {

        pantallaElefirCliente = new PantallaElegirCliente(this);
        this.listaClientes = listaDeClientes;
        CargarTablaClientes();
        pantallaElefirCliente.getTabla().getColumnModel().getColumn(0).setPreferredWidth(45);  //cantidad
        pantallaElefirCliente.getTabla().getColumnModel().getColumn(1).setPreferredWidth(200);  //codigo
        pantallaElefirCliente.getTabla().getColumnModel().getColumn(2).setPreferredWidth(90); //descripcion
        pantallaElefirCliente.setVisible(true);
        pantallaElefirCliente.setLocationRelativeTo(pantalla.getPanelDatosCliente());

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
        pantalla.getNombre().requestFocus();
     }

     private void cerrarPantallaSeleccionCliente(){
        pantallaElefirCliente.dispose();

     }

//ACA TERMINA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE



//ACA COMIENZA EL CONTROL DE LA PANTALLA PARA BUSCAR FACTURA

     private PantallaBuscarFactura pantallaBuscarFactura;

     public void iniciarPantallaBuscarFacura() {

        pantallaBuscarFactura = new PantallaBuscarFactura(this);
        pantallaBuscarFactura.setVisible(true);
    }

     public void buscarFactura() {
        try{
            String numero = pantallaBuscarFactura.getNumeroDeFactura().getText();
            String tipo = (String) pantallaBuscarFactura.getTipoFactura().getSelectedItem();
            long numeroLong = Long.parseLong(numero);
            pantallaBuscarFactura.dispose();
            DtoFactura dto = experto.abrirFactura(numeroLong, tipo);
            if(dto.getFactura() == null){
                JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "No se ha encontado una facura con ese numero", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                experto = new ExpertoFacturar();
            }else{
                limpiarSoloPantalla();
                cargarDatosFacturaAbierta(dto);
            }
        }catch(NumberFormatException e){
            pantallaBuscarFactura.dispose();
            JOptionPane.showMessageDialog(getPantalla().getPanelInfoCliene(), "El número de factura ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            iniciarBusquedaDeFactura();
        }

    }






//ACA TERMINA EL CONTROL DE LA PANTALLA PARA BUSCAR FACUTURA




}
