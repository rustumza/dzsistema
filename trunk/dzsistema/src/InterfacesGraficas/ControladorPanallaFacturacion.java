/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.JTable;
import javax.swing.UIManager;
/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    PantallaFacturacion iu;
    
    

    public void iniciar() {
        try{
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
        }
        catch(Exception ex) {
            System.out.println("Fallo lookandfell");
        }
        iu = new PantallaFacturacion(this);
        configurarTabla();
        iu.setVisible(true);
    }


    public void configurarTabla() {

        JTable tabla = iu.getTablaDetallesFactura();

        //Asigmo el modelo
        tabla.setModel(new ModeloTablaProducto());

        //Tamaño de las columnas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);  //cantidad
        tabla.getColumnModel().getColumn(1).setPreferredWidth(70);  //codigo
        tabla.getColumnModel().getColumn(2).setPreferredWidth(400); //descripcion
        tabla.getColumnModel().getColumn(3).setPreferredWidth(70);  //precio unitario
        tabla.getColumnModel().getColumn(4).setPreferredWidth(70);  //importe

    }

}
