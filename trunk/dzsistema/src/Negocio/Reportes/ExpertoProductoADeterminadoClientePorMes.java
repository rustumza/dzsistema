/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author juampa
 */
public class ExpertoProductoADeterminadoClientePorMes {

    Producto encontrado;

    public List<Cliente> buscarClientePorCodigo(int codigo) {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        List<Cliente> encontrados = fachadaCliente.buscarPorCodigo(Integer.toString(codigo));
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

    public List<DtoResultado> generarReporte(Cliente seleccionado, Date inicio, Date fin) {
        FacturaJpaController fachada = new FacturaJpaController();
        List<Factura> listaFacturas = fachada.buscarFacturaEntreFechasSinLaFechaFinYConCliente(inicio, fin, seleccionado);
        List<DtoResultado> resultado = new ArrayList();
        boolean estaba = false;
        for(int i=0; i<listaFacturas.size();i++){
            for(int j=0; j<listaFacturas.get(i).getDetallesDeFactura().size();j++){
                Producto producto = listaFacturas.get(i).getDetallesDeFactura().get(j).getProducto();
                for(int k=0;k<resultado.size();k++){
                    if(resultado.get(k).getProducto().equals(producto)){
                        resultado.get(k).setTotal(resultado.get(k).getTotal() + listaFacturas.get(i).getDetallesDeFactura().get(j).getPrecioTotal());
                        estaba = true;
                    }
                }
                if(!estaba){
                    DtoResultado nuevo = new DtoResultado();
                    nuevo.setProducto(producto);
                    nuevo.setTotal(listaFacturas.get(i).getDetallesDeFactura().get(j).getPrecioTotal());
                    resultado.add(nuevo);
                }
                estaba = false;
            }
        }
        return resultado;
    }

    public List<Cliente> buscarClientePorParteDelNombre(String nombre) {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        List<Cliente> encontrados = fachadaCliente.buscarPorParteDelNombre(nombre);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

}
