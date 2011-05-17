/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas.Reportes;


import Negocio.Reportes.DtoMesCantidadProducto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author diego
 */


public class ModeloTablaReporteEvolucionCompraClienteProducto extends AbstractTableModel {




    //private List<DetalleFactura> listaDetalles;
    public static String[] columnName = {"Mes/Año","Cantidad"};

    List<DtoMesCantidadProducto> datos;



    public ModeloTablaReporteEvolucionCompraClienteProducto(){
        super();
        datos = new ArrayList<DtoMesCantidadProducto>();

    }

    public ModeloTablaReporteEvolucionCompraClienteProducto(List<DtoMesCantidadProducto> lista){
        super();
        datos = lista;

    }


    //Permitir que se editen los campos
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //como simpre devuelve false, no se puede editar ningun campo
    }


    public void setListaDetalles(List<DtoMesCantidadProducto> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<DtoMesCantidadProducto>();
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

        DtoMesCantidadProducto detalle = datos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                String mes = null;
                if(detalle.getMes() == 1){
                    mes = "Enero";
                }else if(detalle.getMes() == 2){
                    mes = "Febrero";
                }else if(detalle.getMes() == 3){
                    mes = "Marzo";
                }else if(detalle.getMes() == 4){
                    mes = "Abril";
                }else if(detalle.getMes() == 5){
                    mes = "Mayo";
                }else if(detalle.getMes() == 6){
                    mes = "Junio";
                }else if(detalle.getMes() == 7){
                    mes = "Julio";
                }else if(detalle.getMes() == 8){
                    mes = "Agosto";
                }else if(detalle.getMes() == 9){
                    mes = "Setiembre";
                }else if(detalle.getMes() == 10){
                    mes = "Octubre";
                }else if(detalle.getMes() == 11){
                    mes = "Noviembre";
                }else if(detalle.getMes() == 12){
                    mes = "Diciembre";
                }

                String result = (mes + " " + detalle.getAnio());
                return result;
            case 1:
                return String.valueOf(detalle.getCantidad());
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    public void addRow(DtoMesCantidadProducto DTODetalle) {
        if (datos == null) {
            datos = new ArrayList<DtoMesCantidadProducto>();
        }
        datos.add(DTODetalle);
        fireTableDataChanged();
    }

    public void addAllRow(List<DtoMesCantidadProducto> nuevaLista) {
        if (datos == null) {
            datos = new ArrayList<DtoMesCantidadProducto>();
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
