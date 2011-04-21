/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Facturacion;

import InterfacesGraficas.DTODetallesDeFacturaParaGUI;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.Producto;
import validar.fechaException;
import validar.Validar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ExpertoFacturar {

    private Factura factura;
    private boolean esFacuraNueva;
    

    public ExpertoFacturar(){
        factura = new Factura();
        factura.setFecha(validar.Validar.formatearFechaADate(new Date()));
        esFacuraNueva = true;

    }
    public Factura getFactura(){
        return factura;
    }

    public List<Cliente> buscarClientePorNombre(String text) {
        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorNombre(text);
        return listaDeClientes;
        
    }

    public Factura buscarClientePorCuit(String text) {
        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorNombre(text);
        armarFacturaConCliente(listaDeClientes.get(0));
        cargarFechaYNumeroDeFactura();
        return factura;
    }

    public Factura buscarClientePorNumero(String text) {

        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorCUIT(text);
        armarFacturaConCliente(listaDeClientes.get(0));
        cargarFechaYNumeroDeFactura();
        return factura;
    }


    private void armarFacturaConCliente(Cliente cliente){
        factura.setCliente(cliente);
        factura.setTipoFactura(factura.getCliente().getCondicionFrenteAlIva().getTipoDeFactura());
    }


    private void cargarFechaYNumeroDeFactura() {
        factura.setFecha(validar.Validar.formatearFechaADate(new Date()));
        factura.setNumero(buscarUltimoNumeroFactura(factura.getTipoFactura().getNombre()));
        factura.setEstado(true);
    }

    private int buscarUltimoNumeroFactura(String nombre) {
        //buscar el ultimo numero utilizado para ese tipo de factura
        return 0;
        //TO DO
    }

    public Producto buscarProducto(String nombre, String fecha) {
        //SETEAR ESA FECHA A LA FACTURA
        //busco producto con la fecha de la factura
        return null;
        //TO DO
    }

    private Producto buscarProducto(String nombre){
        //esto es para buscar un producto que no importe la fecha del precio historico
        //TO DO
        return null;
    }

    public Factura AgregarDetalleALaFactura(DTODetallesDeFacturaParaGUI dto){
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setProducto(buscarProducto(dto.getCodigo()));
        detalleFactura.setPorcentajeDeIva(detalleFactura.getProducto().getPorcentajeDeIva());
        detalleFactura.setCantidad(dto.getCantidad());
        detalleFactura.setPrecioUnitario(dto.getPrecioUnitario());
        float importe = detalleFactura.getCantidad() * detalleFactura.getPrecioUnitario();
        detalleFactura.setPrecioTotal(Math.round(importe * 100)/100);
        if(detalleFactura.getPrecioTotal() != dto.getImporte()){
            //VER COMO MANEJAR ESTE ERROR //TO DO
        }
        factura.addDetalle(detalleFactura);
        return factura;
    }

    public Factura cambiarFechaDeFactura(String text) throws fechaException{

        factura.setFecha(validar.Validar.validarFecha(text));
        return factura;

    }

    public boolean sonFechasIguales(String fecha) throws fechaException{

        Date fechaDate = Validar.validarFecha(fecha);
        if(0 == fechaDate.compareTo(factura.getFecha()))
            return true;
        else
            return false;
    }

    public void guardarFactura() {
        FacturaJpaController jpa = new FacturaJpaController();
        //TO DO hacer todas las validaciones
        jpa.create(factura);
    }

    public Factura eliminarDetalleFactura(int filaSeleccionada) {
        if(filaSeleccionada <= factura.getDetallesDeFactura().size()){
            factura.getDetallesDeFactura().remove(filaSeleccionada);
            return factura;
        }else{

        //TIRAR EXCEPCION   //TO DO
            return null;
        }
    }






}
