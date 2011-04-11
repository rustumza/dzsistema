/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Facturacion;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.Factura;
import Negocio.Entidades.Producto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ExpertoFacturar {

    private Factura factura;
    

    public ExpertoFacturar(){
        factura = new Factura();

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
        Factura fac = new Factura();
        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorNombre(text);
        fac = armarFacturaConCliente(listaDeClientes.get(0));
        factura = cargarFechaYNumeroDeFactura(fac);
        return factura;
    }

    public Factura buscarClientePorNumero(String text) {
        Factura fac = new Factura();
        ClienteJpaController clienteControler = new ClienteJpaController();
        List<Cliente> listaDeClientes = clienteControler.buscarPorCUIT(text);
        fac = armarFacturaConCliente(listaDeClientes.get(0));
        factura = cargarFechaYNumeroDeFactura(fac);
        return factura;
    }


    private Factura armarFacturaConCliente(Cliente cliente){
        Factura fac = new Factura();
        fac.setCliente(cliente);
        fac.setTipoFactura(fac.getCliente().getCondicionFrenteAlIva().getTipoDeFactura());
        return fac;
    }


    private Factura cargarFechaYNumeroDeFactura(Factura factura) {
        factura.setFecha(new Date());
        factura.setNumero(buscarUltimoNumeroFactura(factura.getTipoFactura().getNombre()));
        factura.setEstado(true);
        return factura;
    }

    private int buscarUltimoNumeroFactura(String nombre) {
        //buscar el ultimo numero utilizado para ese tipo de factura
        return 0;
        //TO DO
    }

    public Producto buscarProducto(String text) {
        //busco producto con la fecha de la factura
        return null;
        //TO DO
    }


}
