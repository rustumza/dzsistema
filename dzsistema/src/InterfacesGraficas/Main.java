/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;

/**
 *
 * @author juampa
 */
public class Main {

    public static void main(String[] args) {

        //Para probar persistencia
//        Cliente cliente = new Cliente();
//        ClienteJpaController fachada = new ClienteJpaController();
//        fachada.create(cliente);

        //Arranca pantalla principal
        PantallaFacturacion iu = new PantallaFacturacion();
        iu.setVisible(true);
        
        }

}
