/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import Negocio.Entidades.CondicionFrenteAlIva;
import Negocio.Entidades.CondicionFrenteAlIvaJpaController;
import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.DetalleFacturaJpaController;
import Negocio.Entidades.Factura;
import Negocio.Entidades.FacturaJpaController;
import Negocio.Entidades.PrecioHistorico;
import Negocio.Entidades.PrecioHistoricoJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juampa
 */
public class Main {

    public static void main(String[] args) {

        //Script de inicializacion de Base de Datos //TO DO
        CondicionFrenteAlIvaJpaController fachada = new CondicionFrenteAlIvaJpaController();
        //Verifica si la base de datos se inicializo
        if(fachada.getCondicionFrenteAlIvaCount() == 0){
            //Inicializa la Condicion Frente al Iva
            CondicionFrenteAlIva iva = new CondicionFrenteAlIva();
            CondicionFrenteAlIva iva1 = new CondicionFrenteAlIva();
            iva.setNombre("Responsable Inscripto");
            iva1.setNombre("Monotributista");
            fachada.create(iva);
            fachada.create(iva1);
        }

            // Setea como se ven las pantallas y arranca el sistema
          new ControladorPanallaFacturacion().iniciarPantalla();
        }

}
