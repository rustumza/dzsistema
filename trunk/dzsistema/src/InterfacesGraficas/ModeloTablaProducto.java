/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;


import Negocio.Entidades.DetalleFactura;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import validar.Validar;
/**
 *
 * @author diego
 */


public class ModeloTablaProducto extends AbstractTableModel {




    //private List<DetalleFactura> listaDetalles;
    public static String[] columnName = {"Cantidad", "Código", "Descripción", "P. Unitario", "Importe"};
    //boolean[] canEdit = new boolean[]{true, true, false, true, false}; //este arreglo en un principio permitia elegir que campos eran editables

    List<DetalleFactura> datos;



    public ModeloTablaProducto(){
        super();
        datos = new ArrayList<DetalleFactura>();

    }

    public ModeloTablaProducto(List<DetalleFactura> lista){
        super();
        datos = lista;

    }


    //Permitir que se editen los campos
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //como simpre devuelve false, no se puede editar ningun campo
    }


    public void setListaDetalles(List<DetalleFactura> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<DetalleFactura>();
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

        DetalleFactura detalle = datos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return String.valueOf(detalle.getCantidad());
            case 1:
                return String.valueOf(detalle.getProducto().getCodigo());
            case 2:
                return detalle.getProducto().getDescripcion();
            case 3:
                return Validar.formatearFloatAStringConDosDecimalesYPunto(detalle.getPrecioUnitario());
            case 4:
                return Validar.formatearFloatAStringConDosDecimalesYPunto(detalle.getPrecioTotal());
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DetalleFactura DTODetalle) {
        if (datos == null) {
            datos = new ArrayList<DetalleFactura>();
        }
        datos.add(DTODetalle);
        fireTableDataChanged();
    }

    public void addAllRow(List<DetalleFactura> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<DetalleFactura>();
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
