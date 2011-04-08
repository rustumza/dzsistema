/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.ABM;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author juampa
 */
class ExpertoABMCliente {

    public List<Cliente> ObtenerClientes() {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        List<Cliente> listaClientes = fachadaCliente.findClienteEntities();
        return listaClientes;
    }

    void guardarAfiliado(int codigo, String nombre, String CUIT, String direccion, Long id) {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        Cliente cliente;
        if (id == null) {
            cliente = new Cliente();
        } else {
            cliente = fachadaCliente.findCliente(id);
        }

        cliente.setCodigo(codigo);
        cliente.setNombre(nombre);
        cliente.setCUIT(CUIT);
        cliente.setDomicilio(direccion);
        cliente.setEstado(true);
        try {
            if (id == null) {
                fachadaCliente.create(cliente);
            } else {
                fachadaCliente.edit(cliente);
            }
            JOptionPane.showMessageDialog(null, "Se guardaron los datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
