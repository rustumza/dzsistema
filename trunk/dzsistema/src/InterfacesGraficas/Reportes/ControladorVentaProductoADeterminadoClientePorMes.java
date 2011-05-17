/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.Reportes;

import Negocio.Entidades.Cliente;
import Negocio.Reportes.DtoResultado;
import Negocio.Reportes.ExpertoProductoADeterminadoClientePorMes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rustu
 */
public class ControladorVentaProductoADeterminadoClientePorMes {
    ExpertoProductoADeterminadoClientePorMes experto = new ExpertoProductoADeterminadoClientePorMes();

    public List<Cliente> buscarClientePorCodigo(int codigo) {
        return experto.buscarClientePorCodigo(codigo);
    }

    public List<DtoResultado> generarReporte(Cliente seleccionado, Date inicio, Date fin) {
        return experto.generarReporte(seleccionado, inicio, fin);
    }

    public List<Cliente> buscarClientePorParteDelNombre(String nombre) {
        return experto.buscarClientePorParteDelNombre(nombre);
    }

}
