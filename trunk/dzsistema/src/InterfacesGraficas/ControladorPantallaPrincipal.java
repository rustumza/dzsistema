/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author rustu
 */
public class ControladorPantallaPrincipal {
    PantallaPrincipal pantalla;



    public void iniciarPantalla(){

        try{
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
        }
        catch(Exception ex) {
            System.out.println("Fallo lookandfell");
        }

        pantalla = new PantallaPrincipal(this);
        getPantalla().setVisible(true);
    }
    
     public PantallaPrincipal getPantalla() {
        return pantalla;
    }

    public void setPantalla(PantallaPrincipal pantalla) {
        this.pantalla = pantalla;
    }

    public void facturar() {
        pantalla.dispose();
        new ControladorPanallaFacturacion(this).iniciarPantalla();
        
    }

    public void stock() {
        pantalla.dispose();
        new ControladorPantallaStock(this).iniciarPantalla();
        
    }

    public void acercaDe() {
        new PantallaAcercaDe().setVisible(true);
    }

    public void salir() {

    }

}
