/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.ABM;

import Negocio.Entidades.Cliente;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ControladorABMCliente {
    ExpertoABMCliente experto;

    public List<Cliente> buscarAfiliadoPorCUIT(int parseInt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<Cliente> buscarAfiliadoPorCodigo(String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<Cliente> ObtenerClientes() {
        List<Cliente> lista = experto.ObtenerClientes();
        return lista;
    }

    public void bajaCliente(Cliente clienteAModificar) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<Cliente> buscarAfiliadoPorNombre(String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}