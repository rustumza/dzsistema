/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

import InterfacesGraficas.exceptions.ClienteExcepcion;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import validar.fechaException;

/**
 *
 * @author rustu
 */
public class ExpertoEvolucionComprasClienteRespectoAUnProducto {

    public List<DtoMesCantidadProducto> buscarHitorialProducto(int codigo, Date fechaInicio, Date fechaFin, int codigoCliente) throws fechaException{

        if(!fechaFin.after(fechaInicio)){
            //fecha inicio posterio a fecha fin
            throw new fechaException(6);
        }else if(!new Date().after(fechaInicio)){
            //fecha inicio posterior fecha actual
            throw new fechaException(7);
        }
        if(fechaInicio.before(new Date(110, 05, 06))){
            //fecha inicio anterior al 6/6/2010
            throw new fechaException(8);
        }
        Cliente cli = null;
        ClienteJpaController jpaCliente = new ClienteJpaController();
        List<Cliente> listaClientes = jpaCliente.buscarPorCodigo(String.valueOf(codigoCliente));
        if(listaClientes.isEmpty()){
            throw new ReporteException(1);
        }else{
            cli=listaClientes.get(0);
        }


        FacturaJpaController jpaFactura = new FacturaJpaController();
        List<Factura> listaDeFacturas = jpaFactura.buscarFacturaEntreFechasSinLaFechaFinYConCliente(fechaInicio, fechaFin, cli);
        List<DtoMesCantidadProducto> listaDeDto = new ArrayList<DtoMesCantidadProducto>();

        for (Factura factura : listaDeFacturas) {
            for (DetalleFactura detalle : factura.getDetallesDeFactura()) {
                if(detalle.getProducto().getCodigo() == codigo){
                    Date fechaFactura = factura.getFecha();
                    int anio = fechaFactura.getYear()+1900;
                    int mes = fechaFactura.getMonth()+1;
                    boolean bandera =false;
                    for (DtoMesCantidadProducto mesCantidadProducto : listaDeDto) {

                        if(mesCantidadProducto.getAnio() == anio & mesCantidadProducto.getMes() == mes){
                            mesCantidadProducto.setCantidad(mesCantidadProducto.getCantidad() + detalle.getCantidad());
                            bandera = true;
                            break;
                        }

                    }
                    if(!bandera){
                            listaDeDto.add(new DtoMesCantidadProducto(anio, mes, detalle.getCantidad()));
                    }
                }
            }
        }
        return listaDeDto;
    }


    public Producto buscarProducto(int codigo){

        ProductoJpaController jpa = new ProductoJpaController();
        List<Producto> listaProducto = jpa.buscarPorCodigo(codigo);
        if(listaProducto.isEmpty())
            return null;
        else
            return listaProducto.get(0);

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

    public Cliente buscarClientePorCuit(String cuit)  throws ClienteExcepcion{
        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorCUIT(cuit);
        if(listaDeClientes == null || listaDeClientes.isEmpty()){
            throw new ClienteExcepcion(3);
        }else{
            return listaDeClientes.get(0);
        }
    }

    public Cliente buscarClientePorNumero(String numeroCliente)  throws ClienteExcepcion{

        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorCodigo(numeroCliente);
        if(listaDeClientes == null || listaDeClientes.isEmpty()){
            throw new ClienteExcepcion(2);
        }else{
            return listaDeClientes.get(0);
        }
    }

}
