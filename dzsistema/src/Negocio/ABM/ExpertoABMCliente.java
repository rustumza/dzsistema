/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.ABM;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import java.util.List;

/**
 *
 * @author juampa
 */
class ExpertoABMCliente {

    List<Cliente> ObtenerClientes() {
        ClienteJpaController fachadaArticulo = new ClienteJpaController();
        List<Cliente> listaClientes = fachadaArticulo.findClienteEntities();
        return listaClientes;
    }

}
