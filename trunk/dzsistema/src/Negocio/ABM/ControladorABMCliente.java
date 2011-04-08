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
    ExpertoABMCliente experto = new ExpertoABMCliente();

    public List<Cliente> buscarAfiliadoPorCodigo(String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<Cliente> ObtenerClientes() {
        List<Cliente> lista = experto.ObtenerClientes();
        return lista;
    }

    public void bajaCliente(Cliente clienteAModificar) {
        experto.bajaCliente(clienteAModificar);
    }

    public List<Cliente> buscarAfiliadoPorNombre(String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void guardarCliente(int codigo, String nombre, String CUIT, String direccion, Long id) {
        experto.guardarAfiliado(codigo, nombre, CUIT, direccion, id);
    }

    public List<Cliente> buscarAfiliadoPorCUIT(String CUIT) {
        return experto.buscarAfiliadoPorCUIT(CUIT);
    }

}
