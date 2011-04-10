/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.CellRendererPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author rustu
 */
public class ControladorPanallaFacturacion {

    PantallaFacturacion iu;
    
    
    public void configurarTabla() {

        JTable tabla = iu.getTablaDetallesFactura();


        //Asigmo el modelo
        tabla.setModel(new ModeloTablaProducto());


        //setUpSportColumn(tabla.getColumnModel().getColumn(2));



        //Tamaño de las columnas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70); //cantidad
        //tabla.getColumnModel().getColumn(0).setHeaderValue(new Float(null));
        tabla.getColumnModel().getColumn(1).setPreferredWidth(70); //codigo
        
        
        /*JLabel jl = new JLabel();
        jl.setHorizontalAlignment(JLabel.RIGHT);
        DefaultCellEditor dce = new DefaultCellEditor(jl){
            @Override
            public Object getCellEditorValue() {
                return new Integer(4);
            }};


        tabla.getColumnModel().getColumn(0).setCellEditor(dce);
         *
         *
         * 
         */
        tabla.getColumnModel().getColumn(2).setPreferredWidth(400); //descripcion
        tabla.getColumnModel().getColumn(3).setPreferredWidth(70); //precio unitario
        //tabla.getColumnModel().getColumn(3).setHeaderValue(new Float(null));
        tabla.getColumnModel().getColumn(4).setPreferredWidth(70); //importe
        //tabla.getColumnModel().getColumn(4).setHeaderValue(new Float(null));




    }

/*
     public void setUpSportColumn(TableColumn sportColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Chasing toddlers");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Teaching high school");
        comboBox.addItem("None");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);

        //Set up tool tip for the sport column header.
        TableCellRenderer headerRenderer = sportColumn.getHeaderRenderer();
        if (headerRenderer instanceof DefaultTableCellRenderer) {
            ((DefaultTableCellRenderer)headerRenderer).setToolTipText(
                     "Click the sport to see a list of choices");
        }
    }

*/

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

}
