/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

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
        // Script de inicializacion de Base de Datos (Hay que completarlo)
        //Inicializa la Condicion Frente al Iva
//        CondicionFrenteAlIva iva = new CondicionFrenteAlIva();
//        CondicionFrenteAlIva iva1 = new CondicionFrenteAlIva();
//        iva.setNombre("Responsable Inscripto");
//        iva1.setNombre("Monotributista");
//        CondicionFrenteAlIvaJpaController fachada = new CondicionFrenteAlIvaJpaController();
//        fachada.create(iva);
//        fachada.create(iva1);

        //pruebas locas
        //Creo factura y la guardo con detalle
//        FacturaJpaController facha = new FacturaJpaController();
//        Factura d = new Factura();
//        facha.create(d);
//        DetalleFactura d1 = new DetalleFactura();
//        d.addDetalle(d1);
//        try {
//            facha.edit(d);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // Destruyo factura y detalle en cadena
//        FacturaJpaController facha = new FacturaJpaController();
//        long aux = 201;
//        try {
//            facha.destroy(aux);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //Pruebas producto
//        ProductoJpaController facha = new ProductoJpaController();
//        Producto p = new Producto();
//        facha.create(p);
//        PrecioHistorico h = new PrecioHistorico();
//        p.addPrecio(h);
//        try {
//            facha.edit(p);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

            // Setea como se ven las pantallas y arranca el sistema
          new ControladorPanallaFacturacion().iniciarPantalla();
        }

}
