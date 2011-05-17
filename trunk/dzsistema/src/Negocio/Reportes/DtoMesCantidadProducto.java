/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;


/**
 *
 * @author rustu
 */
public class DtoMesCantidadProducto {


    float cantidad;
    int mes;
    int anio;

    public DtoMesCantidadProducto(int anio, int mes, float cantidad){
        this.anio = anio;
        this.mes = mes;
        this.cantidad = cantidad;

    }

    public DtoMesCantidadProducto(){

    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }


}
