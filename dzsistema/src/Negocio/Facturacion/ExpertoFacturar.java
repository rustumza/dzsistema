/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Facturacion;

import InterfacesGraficas.DTODetallesDeFacturaParaGUI;
import InterfacesGraficas.exceptions.ClienteExcepcion;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.CondicionFrenteAlIva;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.PrecioHistorico;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import java.util.ArrayList;
import validar.fechaException;
import validar.Validar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ExpertoFacturar {

    private DtoFactura dto;

    

    public ExpertoFacturar(){
        dto = new DtoFactura();
        dto.setFactura(new Factura());
        dto.setEsFacuraNueva(true);
        dto.getFactura().setEstado(true);
        dto.setListaDeDetalles(new ArrayList<DetalleFactura>());
        dto.setListaDeDetallesAEliminar(new ArrayList<DetalleFactura>());

    }
    public DtoFactura getDtoFactura(){
        return dto;
    }

    public List<Cliente> buscarClientePorNombre(String nombre) throws ClienteExcepcion{
        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorNombre(nombre);
        if(listaDeClientes == null || listaDeClientes.isEmpty()){
            throw new ClienteExcepcion(1);
        }else{
            return listaDeClientes;
        }
    }

    public DtoFactura buscarClientePorCuit(String cuit)  throws ClienteExcepcion{
        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorCUIT(cuit);
        if(listaDeClientes == null || listaDeClientes.isEmpty()){
            throw new ClienteExcepcion(3);
        }else{
            armarFacturaConCliente(listaDeClientes.get(0));
            return dto;
        }
    }

    public DtoFactura buscarClientePorNumero(String numeroCliente)  throws ClienteExcepcion{

        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorCodigo(numeroCliente);
        if(listaDeClientes == null || listaDeClientes.isEmpty()){
            throw new ClienteExcepcion(2);
        }else{
            armarFacturaConCliente(listaDeClientes.get(0));
            return dto;
        }
    }


    private void armarFacturaConCliente(Cliente cliente){
        dto.getFactura().setCliente(cliente);
        dto.getFactura().setTipoFactura(dto.getFactura().getCliente().getCondicionFrenteAlIva().getTipoDeFactura());
        dto.setListaDeDetalles(new ArrayList<DetalleFactura>());
        dto.setListaDeDetallesAEliminar(new ArrayList<DetalleFactura>());
    }


    /*private void cargarFechaYNumeroDeFactura() {
        factura.setFecha(validar.Validar.formatearFechaADate(new Date()));
        //factura.setNumero(buscarUltimoNumeroFactura(factura.getTipoFactura().getNombre()));
        factura.setEstado(true);
    }*/

    /*private int buscarUltimoNumeroFactura(String nombre) {

        //buscar el ultimo numero utilizado para ese tipo de factura
        return 0;
        //TO //DO
    }*/

    public Producto buscarProductoConFechaDeFactura(String codigo) {
        //Busca el producto pero solo trae el precio historico correspondiente a la fecha de la factura
        ProductoJpaController productoJpa = new ProductoJpaController();
        int codigoInt = Integer.parseInt(codigo);
        List<Producto> listaDeProductos = productoJpa.buscarPorCodigo(codigoInt);
        Producto producto = listaDeProductos.get(0);
        List<PrecioHistorico> preciosHistoricos = producto.getPreciosHistoricos();
        Date fechaFactura = dto.getFactura().getFecha();
        int anterior;
        PrecioHistorico ph = null;
        for (PrecioHistorico precioHistorico : preciosHistoricos) {
            /*negativo si FechaDesdeQueEntroEnVigencia es mas vieja
             * 0 si FechaDesdeQueEntroEnVigencia igual
             * positiva si FechaDesdeQueEntroEnVigencia es mas nueva
             */

            int comparacion = precioHistorico.getFechaDesdeQueEntroEnVigencia().compareTo(fechaFactura);
            if(comparacion<=0){
                ph = precioHistorico;
            }else{
                break;
            }
        }
        List<PrecioHistorico> listaConElPrecioHistorico = new ArrayList<PrecioHistorico>();
        listaConElPrecioHistorico.add(ph);
        producto.setPreciosHistoricos(listaConElPrecioHistorico);
        return producto;
        
        //TO DO
    }

    private Producto buscarProducto(String codigo){
        //esto es para buscar un producto con todos los precios historicos
        ProductoJpaController productoJpa = new ProductoJpaController();
        int codigoInt = Integer.parseInt(codigo);
        List<Producto> listaDeProductos = productoJpa.buscarPorCodigo(codigoInt);
        Producto producto = listaDeProductos.get(0);
        return producto;
    }

    public DtoFactura AgregarDetalleALaFactura(DTODetallesDeFacturaParaGUI dtodetalle){
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setProducto(buscarProducto(dtodetalle.getCodigo()));
        detalleFactura.setPorcentajeDeIva(detalleFactura.getProducto().getPorcentajeDeIva());
        detalleFactura.setCantidad(dtodetalle.getCantidad());
        detalleFactura.setPrecioUnitario(dtodetalle.getPrecioUnitario());
        float importe = detalleFactura.getCantidad() * detalleFactura.getPrecioUnitario();
        detalleFactura.setPrecioTotal(Math.round(importe * 100)/100);
        if(detalleFactura.getPrecioTotal() != dtodetalle.getImporte()){
            //VER COMO MANEJAR ESTE ERROR //TO DO
        }
        dto.addDetalleNuevo(detalleFactura);
        return dto;
    }

    public void cambiarFechaDeFactura(String fecha) throws fechaException{

        dto.getFactura().setFecha(validar.Validar.validarFecha(fecha));
        

    }

    public boolean sonFechasIguales(String fecha) throws fechaException{

        Date fechaDate = Validar.validarFecha(fecha);
        if(0 == fechaDate.compareTo(dto.getFactura().getFecha()))
            return true;
        else
            return false;
    }

    public void guardarFactura() {
        FacturaJpaController jpa = new FacturaJpaController();
        //TO DO hacer todas las validaciones
        jpa.create(dto.getFactura());
    }

    //TO DO2 reveer este metodo
    public DtoFactura eliminarDetalleFactura(int filaSeleccionada) {
        if(filaSeleccionada <= dto.getFactura().getDetallesDeFactura().size()){
            dto.eliminarDetalle(filaSeleccionada);
            return dto;
        }else{

        //TIRAR EXCEPCION   //TO DO
            return null;
        }
    }

    public DtoFactura eliminarTodosLosDetallesDeFactura() {
        dto.eliminarTodosLosDetalles();
        return dto;

    }

    
}
