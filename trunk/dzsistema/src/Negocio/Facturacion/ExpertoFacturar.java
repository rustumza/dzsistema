/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Facturacion;

import InterfacesGraficas.DTODetallesDeFacturaParaGUI;
import InterfacesGraficas.exceptions.ClienteExcepcion;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.CondicionDeVentaJpaController;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.DetalleFacturaJpaController;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.PrecioHistorico;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import validar.fechaException;
import validar.Validar;
import java.util.Date;
import java.util.List;
import org.eclipse.persistence.internal.jpa.parsing.DotNode;

/**
 *
 * @author juampa
 */
public class ExpertoFacturar {

    private DtoFactura dto;

    

    public ExpertoFacturar(){
        dto = new DtoFactura();
        dto.setFactura(new Factura());
        dto.getFactura().setSubtotal(0);
        dto.getFactura().setIva105(0);
        dto.getFactura().setIva21(0);
        dto.getFactura().setTotal(0);
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
        List<Cliente> listaDeClientes = clienteControler.buscarPorParteDelNombre(nombre);
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
        dto.eliminarTodosLosDetalles();
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
        if(!(listaDeProductos.isEmpty())){
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
        }else
            return null;
        
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
        detalleFactura.setPrecioTotal(((float)Math.round(importe * 100))/100);
        if(detalleFactura.getPrecioTotal() != dtodetalle.getImporte()){
            //VER COMO MANEJAR ESTE ERROR //TO DO
        }
        dto.addDetalleNuevo(detalleFactura);
        return dto;
    }
    public DtoFactura editarDetalleALaFactura(DTODetallesDeFacturaParaGUI dtodetalle, int filaAEditar) {
        DetalleFactura detalleFactura = dto.getListaDeDetalles().get(filaAEditar);
        detalleFactura.setProducto(buscarProducto(dtodetalle.getCodigo()));
        detalleFactura.setPorcentajeDeIva(detalleFactura.getProducto().getPorcentajeDeIva());
        detalleFactura.setCantidad(dtodetalle.getCantidad());
        detalleFactura.setPrecioUnitario(dtodetalle.getPrecioUnitario());
        float importe = detalleFactura.getCantidad() * detalleFactura.getPrecioUnitario();
        detalleFactura.setPrecioTotal(((float)Math.round(importe * 100))/100);
        if(detalleFactura.getPrecioTotal() != dtodetalle.getImporte()){
            //VER COMO MANEJAR ESTE ERROR //TO DO
        }
        return dto;
    }

    public void cambiarFechaDeFactura(String fecha) throws fechaException{

        Date date = validar.Validar.validarFecha(fecha);
        if(0 >= date.compareTo(validar.Validar.validarFecha("060610"))){
            throw new fechaException(5);
        }
        dto.getFactura().setFecha(date);
        

    }

    public boolean sonFechasIguales(String fecha) throws fechaException{

        Date fechaDate = Validar.validarFecha(fecha);
        if(0 == fechaDate.compareTo(dto.getFactura().getFecha()))
            return true;
        else
            return false;
    }

    public void guardarFactura(){
        FacturaJpaController jpa = new FacturaJpaController();
        DetalleFacturaJpaController jpaDetalle = new DetalleFacturaJpaController();

        if(dto.isEsFacuraNueva()){
            for (DetalleFactura det : dto.getListaDeDetalles()) {
                dto.getFactura().addDetalle(det);
            }
            jpa.create(dto.getFactura());

        }else{
            for (DetalleFactura det : dto.getListaDeDetallesAEliminar()) {
                try {
                    jpaDetalle.destroy(det.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                jpa.edit(dto.getFactura());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
            }
            


        }

        //agrego los detalles o los actualizo

         /* ESTO ES LO QUE HAGA NORMALMENTE
        for (DetalleFactura detalle : dto.getListaDeDetalles()) {
            if(detalle.getId() != null){
                try {
                    //hacer update detalle viejos
                    jpaDetalle.edit(detalle);
                    dto.getFactura().addDetalle(detalle);
                    
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                //guardarlo detalle nuevo
                jpaDetalle.create(detalle);
                dto.getFactura().addDetalle(detalle);
            }
        }

        */
          /*  //elimino los detalles que estan para eliminiar
            for (DetalleFactura detalleAEliminar : dto.getListaDeDetallesAEliminar()) {
                if(detalleAEliminar.getId() != null){
                    try {
                        jpaDetalle.destroy(detalleAEliminar.getId());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        //ESTA LINEAS QUE VIENE LAS AGREGUE PARA PROBAR
        for (DetalleFactura det : dto.getListaDeDetalles()) {
            dto.getFactura().addDetalle(det);
        }

        //HASTA ACA!!
        if(dto.getFactura().getId() != null){
            // si la factura no es nueva, la actualizo
            try {
                jpa.edit(dto.getFactura());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ExpertoFacturar.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }else{
            // si la factura es nueva, la guardo
            jpa.create(dto.getFactura());
        }*/
    }

    //TO DO2 reveer este metodo
    public DtoFactura eliminarDetalleFactura(int filaSeleccionada) {
        if(filaSeleccionada < dto.getListaDeDetalles().size()){
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


    public DtoFactura abrirFactura(long numero, String tipo){
        FacturaJpaController jpa = new FacturaJpaController();

        dto = new DtoFactura();
        dto.setFactura(null);
        List<Factura> listaFactura = jpa.buscarPorNumero(numero);
        if(!listaFactura.isEmpty())
            for (Factura factura : listaFactura) {
                if(factura.getTipoFactura().getNombre().equals(tipo)){
                    dto.setFactura(factura);
                    dto.setEsFacuraNueva(false);
                    dto.setListaDeDetalles(dto.getFactura().getDetallesDeFactura());
                    dto.setListaDeDetallesAEliminar(new ArrayList<DetalleFactura>());
                }
        }
        //dto.getFactura().vaciarListaDeDetalles();
        return dto;
    }

    public DtoFactura anularFactura() {
        dto.getFactura().setEstado(false);
        return dto;
    }

    public DtoFactura desanularFactura(){
        dto.getFactura().setEstado(true);
        return dto;
    }

    public void guardarNumeroFacutra(long numeroFactura) {
        
        dto.getFactura().setNumero(numeroFactura);
    }

    public boolean existeFacturaConEseNumeroDeFactura(){
        FacturaJpaController jpa = new FacturaJpaController();
        List<Factura> lista = jpa.buscarPorNumero(dto.getFactura().getNumero());
        boolean retorno = false;
        for (Factura factura : lista) {
            if(factura.getNumero() == dto.getFactura().getNumero()){
                if(factura.getTipoFactura().getNombre().equals(dto.getFactura().getTipoFactura().getNombre())){
                    retorno = true;
                    break;
                }
            }
        }

        return retorno;
    }

    public void guardarNumeroRemito(long nroRemito) {
        dto.getFactura().setRemitoNro(nroRemito);
    }

    public void guardarCondicionDeVenta(int condDeVenta) {
        CondicionDeVentaJpaController jpa = new CondicionDeVentaJpaController();
        dto.getFactura().setCondicionDeVenta(jpa.findCondicionDeVenta((long)condDeVenta));

    }

    public void settotal(float total) {
        dto.getFactura().setTotal(total);
    }

    public void setSubtotal(float subtotal) {
        dto.getFactura().setSubtotal(subtotal);
    }

    public void setIva21(float iva21) {
        dto.getFactura().setIva21(iva21);
    }

    public void setIva105(float iva105) {
        dto.getFactura().setIva105(iva105);
    }

    public boolean esPosteriorFechaDeFacturaRespectoAFacturasAnteriores() {

        FacturaJpaController jpa = new FacturaJpaController();
        for (long i = (dto.getFactura().getNumero()-1) ; i>0; i--) {
            List<Factura> lista = jpa.buscarPorNumero(i);
            for (Factura factura : lista) {
                if(factura.getTipoFactura().getNombre().equals(dto.getFactura().getTipoFactura().getNombre())){
                    if(0 < factura.getFecha().compareTo(dto.getFactura().getFecha())){
                        return false;
                    }else{
                        return true;
                    }
                }
            }

        }

        return true;
    }


}
