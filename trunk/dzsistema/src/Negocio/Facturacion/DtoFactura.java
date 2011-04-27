/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Facturacion;

import Negocio.Entidades.DetalleFactura;
import Negocio.Entidades.Factura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rustu
 */
public class DtoFactura {

    private Factura factura;
    private boolean esFacuraNueva;
    private List<DetalleFactura> listaDeDetallesAEliminar;
    private List<DetalleFactura> listaDeDetalles;

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * @return the esFacuraNueva
     */
    public boolean isEsFacuraNueva() {
        return esFacuraNueva;
    }

    /**
     * @param esFacuraNueva the esFacuraNueva to set
     */
    public void setEsFacuraNueva(boolean esFacuraNueva) {
        this.esFacuraNueva = esFacuraNueva;
    }

    /**
     * @return the listaDeDetallesAEliminar
     */
    List<DetalleFactura> getListaDeDetallesAEliminar() {
        return listaDeDetallesAEliminar;
    }

    /**
     * @param listaDeDetallesAEliminar the listaDeDetallesAEliminar to set
     */
    void setListaDeDetallesAEliminar(List<DetalleFactura> listaDeDetallesAEliminar) {
        this.listaDeDetallesAEliminar = listaDeDetallesAEliminar;
    }

    /**
     * @return the listaDeDetalles
     */
    public List<DetalleFactura> getListaDeDetalles() {
        return listaDeDetalles;
    }

    /**
     * @param listaDeDetalles the listaDeDetalles to set
     */
    public void setListaDeDetalles(List<DetalleFactura> listaDeDetalles) {
        this.listaDeDetalles = listaDeDetalles;
    }


    public void addDetalleNuevo(DetalleFactura detalleFactura) {
        if (!contieneDetalle(detalleFactura, listaDeDetalles)) {
            listaDeDetalles.add(detalleFactura);
        }
    }

   private boolean contieneDetalle(DetalleFactura detalleFactura, List<DetalleFactura> lista){

       for (DetalleFactura detalleFactura1 : lista) {
           if(detalleFactura == detalleFactura1)
               return true;
       }
       return false;
   }

   public void eliminarDetalle(int numeroDeElementoAeliminar){

       
       if(!contieneDetalle(listaDeDetalles.get(numeroDeElementoAeliminar), listaDeDetallesAEliminar)){
           listaDeDetallesAEliminar.add(listaDeDetalles.get(numeroDeElementoAeliminar));
           listaDeDetalles.remove(numeroDeElementoAeliminar);
       }

   }

   /**
    * elimina todos los detalles, poniendolos en el arreglo listaDeDetallesAEliminar
    */
   void eliminarTodosLosDetalles() {
        for (DetalleFactura detalleFactura : listaDeDetalles) {

            if(!contieneDetalle(detalleFactura, listaDeDetallesAEliminar)){
               listaDeDetallesAEliminar.add(detalleFactura);
               listaDeDetalles.remove(detalleFactura);
            }

        }
    }
}
