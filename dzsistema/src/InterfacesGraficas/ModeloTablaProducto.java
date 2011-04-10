/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Negocio.Entidades.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
/**
 *
 * @author diego
 */


public class ModeloTablaProducto extends AbstractTableModel {
    private static int cantidadDeColumnas = 5;
    private static int cantidadDeFlias = 15;



    //private List<DetalleFactura> listaDetalles;
    public static String[] columnName = {"Cantidad", "Código", "Descripción", "P. Unitario", "Importe"};
    boolean[] canEdit = new boolean[]{true, true, false, true, false};
    Object[][] datos = {{new Float(0.0), new Integer(0), " ", new Float(0.0), new Float(0.0)}};
            
            
            //new Object[cantidadDeFlias][cantidadDeColumnas];


    public ModeloTablaProducto(){
        super();


        /*for (int j = 0; j < cantidadDeFlias; j++) {
                datos[j][0] = new Float(0.0);
                datos[j][1] = new Integer(0);
                datos[j][2] = " ";
                datos[j][3] = new Float(0.0);
                datos[j][4] = new Float(0.0);
        }
*/


    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

    /*public void setCellEditable(boolean edit) {
        editable = edit;
    }*/

    /*public void setListaDetalles(List<DetalleFactura> nuevaLista) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DetalleFactura>();
        }
        listaDetalles = nuevaLista;
        fireTableDataChanged();
    }
*/
    public int getRowCount() {
        return datos.length;
    }

    public int getColumnCount() {
        return columnName.length;
    }

    /*public Object getValueAt(int rowIndex, int columnIndex) {

        if (listaDetalles == null) {
            return null;
        }

        DTODetalleInformeReparacion detalle = listaDetalles.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return detalle.getFalla();
            case 1:
                return detalle.getEstadoFalla();
            case 2:
                return detalle.getComentario();
            default:
                return "";
        }
    }*/

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

/*    public void addRow(DetalleFactura nuevoDetalle) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DetalleFactura>();
        }
        listaDetalles.add(nuevoDetalle);
        fireTableDataChanged();
    }

    public void addAllRow(List<DetalleFactura> nuevaLista) {
        if (listaDetalles == null) {
            listaDetalles = new ArrayList<DetalleFactura>();
        }
        listaDetalles.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return listaDetalles.get(rowIndex);
    }

    public void clear() {
        if (listaDetalles == null) {
            return;
        }
        listaDetalles.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        listaDetalles.remove(rowIndex);
        fireTableDataChanged();
    }
*/
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex][columnIndex];
    }

    public void agregarOtroItemBlanco(Object[] datos){


    }
}
