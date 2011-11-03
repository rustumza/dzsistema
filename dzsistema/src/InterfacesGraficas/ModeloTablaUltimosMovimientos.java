/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;


import Negocio.Entidades.MovimientoStock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author diego
 */


public class ModeloTablaUltimosMovimientos extends AbstractTableModel {




    //private List<DetalleFactura> listaDetalles;
    public static String[] columnName = {"Fecha", "Tipo movimiento", "Movimiento", "Stock después del movimiento"};
    //boolean[] canEdit = new boolean[]{true, true, false, true, false}; //este arreglo en un principio permitia elegir que campos eran editables

    List<MovimientoStock> datos;



    public ModeloTablaUltimosMovimientos(){
        super();
        datos = new ArrayList<MovimientoStock>();

    }

    public ModeloTablaUltimosMovimientos(List<MovimientoStock> lista){
        super();
        datos = lista;

    }


    //Permitir que se editen los campos
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //como simpre devuelve false, no se puede editar ningun campo
    }


    public void setListaDetalles(List<MovimientoStock> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<MovimientoStock>();
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

        MovimientoStock movimiento = datos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return armarFecha(movimiento.getFecha());
            case 1:
                return movimiento.getTipoMovimiento().getNombre();
            case 2:
                if(movimiento.getTipoMovimiento().getNombre().equals("Egreso"))
                    return "- " + String.valueOf(movimiento.getMovimiento());
                else
                    return String.valueOf(movimiento.getMovimiento());
            case 3:
                return String.valueOf(movimiento.getStockDespuesDelMovimiento());
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(MovimientoStock movimiento) {
        if (datos == null) {
            datos = new ArrayList<MovimientoStock>();
        }
        datos.add(movimiento);
        fireTableDataChanged();
    }

    public void addAllRow(List<MovimientoStock> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<MovimientoStock>();
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


    private String armarFecha(Date fecha){
        String fechaString = "";
        int dia = fecha.getDay();

        switch (dia) {
            case 0:
                fechaString += "Domingo ";break;
            case 1:
                fechaString += "Lunes ";break;
            case 2:
                fechaString += "Martes ";break;
            case 3:
                fechaString += "Miércoles ";break;
            case 4:
                fechaString += "Jueves ";break;
            case 5:
                fechaString += "Viernes ";break;
            case 6:
                fechaString += "Sábado ";break;
            default:
                fechaString += "";
        }

        fechaString += String.valueOf(fecha.getDate()) + " de ";

        switch (fecha.getMonth()){
                        case 0:fechaString = "Enero";break;
                        case 1:fechaString = "Febrero";break;
                        case 2:fechaString = "Marzo";break;
                        case 3:fechaString = "Abril";break;
                        case 4:fechaString = "Mayo";break;
                        case 5:fechaString = "Junio";break;
                        case 6:fechaString = "Julio";break;
                        case 7:fechaString = "Agosto";break;
                        case 8:fechaString = "Setiembre";break;
                        case 9:fechaString = "Octubre";break;
                        case 10:fechaString = "Noviembre";break;
                        case 11:fechaString = "Diciembre";break;
                    }

        fechaString += " de " + String.valueOf(fecha.getYear() + 1900);

        return fechaString;
    }

}
