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

    public void generarReporte(Cliente seleccionado, Date inicio, Date fin) {
        FacturaJpaController fachada = new FacturaJpaController();
        List<Factura> listaFacturas = fachada.buscarFacturaEntreFechasSinLaFechaFin(inicio, fin);
        float resultado = 0;
        for(int i=0; i<listaFacturas.size();i++){
            for(int j=0; j<listaFacturas.get(i).getDetallesDeFactura().size();j++){
                listaFacturas.get(i).getDetallesDeFactura().get(j).getProducto().equals(seleccionado);
                resultado = resultado + listaFacturas.get(i).getDetallesDeFactura().get(j).getPrecioTotal();
            }
        }
        JOptionPane.showMessageDialog(null, "Las ventas totales fueron:"+ resultado , "Informacion", JOptionPane.INFORMATION_MESSAGE);
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
