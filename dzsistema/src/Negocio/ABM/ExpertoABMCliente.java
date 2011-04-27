/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.ABM;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.CondicionFrenteAlIvaJpaController;
import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juampa
 */
class ExpertoABMCliente {

    public List<Cliente> ObtenerClientes() {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        return fachadaCliente.buscarDeAlta();
    }

    void guardarAfiliado(int codigo, String nombre, String CUIT, String direccion, Long id, String iva) {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        Cliente cliente;
        //Verifica si es nuevo o a modificar
        boolean esnuevo = false;
        if (id == null) {
            cliente = new Cliente();
            esnuevo = true;
        } else {
            cliente = fachadaCliente.findCliente(id);
        }
        if((esnuevo && fachadaCliente.buscarPorCodigo(Integer.toString(codigo)).isEmpty() && fachadaCliente.buscarPorCUIT(CUIT).isEmpty()) || (!esnuevo)){
            cliente.setCodigo(codigo);
            cliente.setNombre(nombre);
            cliente.setCUIT(CUIT);
            cliente.setDomicilio(direccion);
            cliente.setEstado(true);
            CondicionFrenteAlIvaJpaController fachadaIva = new CondicionFrenteAlIvaJpaController();
            cliente.setCondicionFrenteAlIva(fachadaIva.buscarPorNombre(iva));
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
        else{
            JOptionPane.showMessageDialog(null, "Codigo y/o CUIT repetido/s", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void bajaCliente(Cliente clienteAModificar) {
        try {
            ClienteJpaController fachadaCliente = new ClienteJpaController();
            clienteAModificar.setEstado(false);
            fachadaCliente.edit(clienteAModificar);
            JOptionPane.showMessageDialog(null, "Cliente dado de baja", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error, vuelva a intentarlo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ExpertoABMCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error, vuelva a intentarlo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ExpertoABMCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> buscarAfiliadoPorCUIT(String CUIT) {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        List<Cliente> encontrados = fachadaCliente.buscarPorCUIT(CUIT);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

    List<Cliente> buscarAfiliadoPorCodigo(String codigo) {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        List<Cliente> encontrados = fachadaCliente.buscarPorCodigo(codigo);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

    List<Cliente> buscarClientePorParteDelNombre(String nombre) {
        ClienteJpaController fachadaCliente = new ClienteJpaController();
        List<Cliente> encontrados = fachadaCliente.buscarPorParteDelNombre(nombre);
        if(encontrados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        return encontrados;
    }

}
