/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author diego
 */


public class ModeloTablaProducto extends AbstractTableModel {




    //private List<DetalleFactura> listaDetalles;
    public static String[] columnName = {"Cantidad", "Código", "Descripción", "P. Unitario", "Importe"};
    //boolean[] canEdit = new boolean[]{true, true, false, true, false}; //este arreglo en un principio permitia elegir que campos eran editables

    List<DTODetallesDeFacturaParaGUI> datos;



    public ModeloTablaProducto(){
        super();
        datos = new ArrayList<DTODetallesDeFacturaParaGUI>();

    }


    //Permitir que se editen los campos
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //como simpre devuelve false, no se puede editar ningun campo
    }


    public void setListaDetalles(List<DTODetallesDeFacturaParaGUI> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<DTODetallesDeFacturaParaGUI>();
        }
        datos = nuevaLista;
        fireTableDataChanged();
    }

    public int getRowCount() {
        return datos.size();
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (datos == null) {
            return null;
        }

        DTODetallesDeFacturaParaGUI detalle = datos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                //return detalle.getFalla();
            case 1:
                //return detalle.getEstadoFalla();
            case 2:
                //return detalle.getComentario();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DTODetallesDeFacturaParaGUI DTODetalle) {
        if (datos == null) {
            datos = new ArrayList<DTODetallesDeFacturaParaGUI>();
        }
        datos.add(DTODetalle);
        fireTableDataChanged();
    }

    public void addAllRow(List<DTODetallesDeFacturaParaGUI> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<DTODetallesDeFacturaParaGUI>();
        }
        datos.addAll(nuevaLista);
        fireTableDataChanged();
    }

    public Object getRow(int rowIndex) {
        return datos.get(rowIndex);
    }

    public void clear() {
        if (datos == null) {
            return;
        }
        datos.clear();
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        datos.remove(rowIndex);
        fireTableDataChanged();
    }

}
