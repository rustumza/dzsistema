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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import validar.fechaException;

/**
 *
 * @author rustu
 */
public class ExpertoEvolucionComprasClienteRespectoAUnProducto {

    public List<DtoMesCantidadProducto> buscarHitorialProducto(int codigo, Date fechaInicio, Date fechaFin, int codigoCliente, boolean mostrarMesesEnCero) throws fechaException{

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
        if(mostrarMesesEnCero){
            listaDeDto = agregarMesesEnCero(listaDeDto, fechaInicio, fechaFin);
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

    private List<DtoMesCantidadProducto> agregarMesesEnCero(List<DtoMesCantidadProducto> listaDeDto, Date fechaInicio, Date fechaFin) {
        List<DtoMesCantidadProducto> retorno = new ArrayList<DtoMesCantidadProducto>();
        boolean bandera = true;
        int primerMesFaltante = fechaInicio.getMonth()+1;
        int primerAnioFaltante = (fechaInicio.getYear() + 1900);
        int mesFinal = fechaFin.getMonth()+1;
        int anioFinal = fechaFin.getYear()+1900;
        


        /*DtoMesCantidadProducto dto;
        while(true){
            dto = new DtoMesCantidadProducto(mesAGenerar, anioAGenerar, 0);
            if(true){
            }


        }*/

        //TERMINAR!!!!
            while(bandera){
                while(true){
                    if(listaDeDto.isEmpty()){
                        for (int i = primerAnioFaltante; i <= anioFinal; i++) {
                            if(anioFinal == i){
                                for (int j = primerMesFaltante; j < mesFinal; j++) {
                                    retorno.add(new DtoMesCantidadProducto(i, j, 0));

                                }
                                primerMesFaltante = 1;
                            }else{
                                for (int j = primerMesFaltante; j < 13; j++) {
                                    retorno.add(new DtoMesCantidadProducto(i, j, 0));
                                }
                                primerMesFaltante = 1;
                            }


                        }
                        bandera = false;
                        break;
                        
                    }
                    DtoMesCantidadProducto dto = listaDeDto.get(0);
                    if(dto.getAnio()>primerAnioFaltante){
                        for (int i = primerMesFaltante; i < 13; i++) {
                            retorno.add(new DtoMesCantidadProducto(primerAnioFaltante, i, 0));
                        }
                        primerAnioFaltante++;
                        primerMesFaltante = 1;
                    }else{
                        if(dto.getMes()>primerMesFaltante){
                            retorno.add(new DtoMesCantidadProducto(primerAnioFaltante, primerMesFaltante, 0));
                            if(primerMesFaltante==12){
                                primerMesFaltante = 1;
                                primerAnioFaltante++;
                            }else{
                                primerMesFaltante++;
                            }
                        }else{
                            retorno.add(dto);
                            listaDeDto.remove(0);
                            if(primerMesFaltante==12){
                                primerMesFaltante = 1;
                                primerAnioFaltante++;
                            }else{
                                primerMesFaltante++;
                            }
                            if(anioFinal <=  primerAnioFaltante & mesFinal <= primerMesFaltante){
                                bandera = false;
                            }
                            break;
                        }

                    }
                    if(anioFinal <=  primerAnioFaltante & mesFinal<= primerMesFaltante){
                        bandera = false;
                        break;

                    }
                }

        }


        return retorno;
    }

}
