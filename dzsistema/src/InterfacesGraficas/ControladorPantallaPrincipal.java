/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import javax.swing.UIManager;

import javax.swing.UIManager.*;
/**
 *
 * @author rustu
 */
public class ControladorPantallaPrincipal {
    PantallaPrincipal pantalla;



    public void iniciarPantalla(){
        
        
        

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                //System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            
        } catch (Exception e) {
            System.out.println("Fallo lookandfell");
            e.printStackTrace();
        }
        
        
        

//        try{
//            //UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
//            //UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
//            //UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
//            //UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
//            //UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
//            //PlafOptions.setAsLookAndFeel();
//            //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
//        }
//        catch(Exception ex) {
//            System.out.println("Fallo lookandfell");
//        }

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
        new PantallaAcercaDe(pantalla).setVisible(true);
    }

    public void salir() {
        pantalla.dispose();
        System.exit(0);
    }

}
