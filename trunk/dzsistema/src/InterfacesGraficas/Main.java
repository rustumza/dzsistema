/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.CondicionFrenteAlIva;
import Negocio.Entidades.CondicionFrenteAlIvaJpaController;

/**
 *
 * @author juampa
 */
public class Main {

    public static void main(String[] args) {
        // Script de inicializacion de Base de Datos (Hay que completarlo)
        //Inicializa la Condicion Frente al Iva
        CondicionFrenteAlIva iva = new CondicionFrenteAlIva();
        CondicionFrenteAlIva iva1 = new CondicionFrenteAlIva();
        iva.setNombre("Responsable Inscripto");
        iva.setNombre("Monotributista");
        CondicionFrenteAlIvaJpaController fachada = new CondicionFrenteAlIvaJpaController();
        fachada.create(iva);

        //Arranca pantalla principal
        PantallaFacturacion iu = new PantallaFacturacion();
        iu.setVisible(true);
        
        
        }

}
