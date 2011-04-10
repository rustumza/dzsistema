/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import Negocio.Entidades.Cliente;
import Negocio.Entidades.ClienteJpaController;
import Negocio.Entidades.CondicionFrenteAlIva;
import Negocio.Entidades.CondicionFrenteAlIvaJpaController;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author juampa
 */
public class Main {

    public static void main(String[] args) {
        // Script de inicializacion de Base de Datos (Hay que completarlo)
        //Inicializa la Condicion Frente al Iva
//        CondicionFrenteAlIva iva = new CondicionFrenteAlIva();
//        CondicionFrenteAlIva iva1 = new CondicionFrenteAlIva();
//        iva.setNombre("Responsable Inscripto");
//        iva1.setNombre("Monotributista");
//        CondicionFrenteAlIvaJpaController fachada = new CondicionFrenteAlIvaJpaController();
//        fachada.create(iva);
//        fachada.create(iva1);

        // Setea como se ven las pantallas y arranca el sistema
        
            new ControladorPanallaFacturacion().iniciar();
        
        }

}
