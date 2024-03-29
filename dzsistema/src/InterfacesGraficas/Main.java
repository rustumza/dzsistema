/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import Negocio.Entidades.CondicionDeVenta;
import Negocio.Entidades.CondicionDeVentaJpaController;
import Negocio.Entidades.CondicionFrenteAlIva;
import Negocio.Entidades.CondicionFrenteAlIvaJpaController;
import Negocio.Entidades.Numerador;
import Negocio.Entidades.NumeradorJpaController;
import Negocio.Entidades.Producto;
import Negocio.Entidades.ProductoJpaController;
import Negocio.Entidades.Stock;
import Negocio.Entidades.StockJpaController;
import Negocio.Entidades.TipoFactura;
import Negocio.Entidades.TipoFacturaJpaController;
import Negocio.Entidades.TipoMovimiento;
import Negocio.Entidades.TipoMovimientoJpaController;
import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juampa
 */
public class Main {

    public static void main(String[] args) {

        //Lanza splash screen
        PantallaPresentacion pantalla = new PantallaPresentacion();
        pantalla.setVisible (true);
        
        //Script de inicializacion de Base de Datos
        CondicionFrenteAlIvaJpaController fachadaCFI = new CondicionFrenteAlIvaJpaController();
        //Verifica si la base de datos se inicializo
        if(fachadaCFI.getCondicionFrenteAlIvaCount() == 0){
            //Inicializa condiciones de Venta
            CondicionDeVentaJpaController fachadaCV = new CondicionDeVentaJpaController();
            CondicionDeVenta condicion = new CondicionDeVenta();
            CondicionDeVenta condicion1 = new CondicionDeVenta();
            CondicionDeVenta condicion2 = new CondicionDeVenta();
            condicion.setNombre("Contado");
            condicion1.setNombre("Cuenta Corriente");
            condicion2.setNombre("Tarjeta");
            fachadaCV.create(condicion);
            fachadaCV.create(condicion1);
            fachadaCV.create(condicion2);
            //Inicializa los tipos de factura
            TipoFacturaJpaController fachadaTP = new TipoFacturaJpaController();
            TipoFactura tipo = new TipoFactura();
            TipoFactura tipo1 = new TipoFactura();
            tipo.setCodigo(1);
            tipo.setNombre("A");
            tipo1.setCodigo(6);
            tipo1.setNombre("B");
            fachadaTP.create(tipo);
            fachadaTP.create(tipo1);
            //Guardo las condiciones de venta de cada tipo de factura
            tipo1.addCondicion(condicion);
            tipo1.addCondicion(condicion1);
            tipo1.addCondicion(condicion2);
            tipo.addCondicion(condicion);
            tipo.addCondicion(condicion1);
            try {
                fachadaTP.edit(tipo);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fachadaTP.edit(tipo1);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Inicializa la Condicion Frente al Iva
            CondicionFrenteAlIva iva = new CondicionFrenteAlIva();
            CondicionFrenteAlIva iva1 = new CondicionFrenteAlIva();
            CondicionFrenteAlIva iva2 = new CondicionFrenteAlIva();
            CondicionFrenteAlIva iva3 = new CondicionFrenteAlIva();
            CondicionFrenteAlIva iva4 = new CondicionFrenteAlIva();
            iva.setNombre("Responsable Inscripto");
            iva.setTipoDeFactura(tipo);
            iva1.setNombre("Monotributista");
            iva1.setTipoDeFactura(tipo1);
            iva2.setNombre("Consumidor Final");
            iva2.setTipoDeFactura(tipo1);
            iva3.setNombre("Exento");
            iva3.setTipoDeFactura(tipo1);
            iva4.setNombre("No Responsable");
            iva4.setTipoDeFactura(tipo1);
            fachadaCFI.create(iva);
            fachadaCFI.create(iva1);
            fachadaCFI.create(iva2);
            fachadaCFI.create(iva3);
            fachadaCFI.create(iva4);
            //Inicializa numerador
            NumeradorJpaController fachadaN = new NumeradorJpaController();
            Numerador numerador = new Numerador();
            numerador.setFacturaA(1);
            numerador.setFacturaB(2);
            fachadaN.create(numerador);
        }
        //Verifica si se inicializo la base de datos en su version 1.1
        ///*
        TipoMovimientoJpaController fachadaTM = new TipoMovimientoJpaController();
        if(fachadaTM.getTipoMovimientoCount() == 0){
            //Inicializa los tipos de movimiento de stock
            TipoMovimiento tipo = new TipoMovimiento();
            tipo.setNombre("Ingreso");
            TipoMovimiento tipo1 = new TipoMovimiento();
            tipo1.setNombre("Egreso");
            fachadaTM.create(tipo);
            fachadaTM.create(tipo1);
            //Verifico que todos los productos tengan stock si no tienen les agrego uno
            ProductoJpaController fachadaProd = new ProductoJpaController();
            List<Producto> productos = fachadaProd.findProductoEntities();
            for(int i = 0; i<productos.size(); i++){
                if(productos.get(i).getStock() == null){
                    try {
                        Stock stock = new Stock();
                        StockJpaController fachadaStock = new StockJpaController();
                        fachadaStock.create(stock);
                        productos.get(i).setStock(stock);
                        fachadaProd.edit(productos.get(i));
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
           
          // Setea como se ven las pantallas y arranca el sistema
        pantalla.dispose();
        new ControladorPantallaPrincipal().iniciarPantalla();
        }

}
