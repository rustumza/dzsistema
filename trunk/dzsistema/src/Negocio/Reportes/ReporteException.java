/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Reportes;

/**
 *
 * @author rustu
 */

public class ReporteException extends IllegalArgumentException{
    private final int codigo;

    /**Recibe el código de error, para mostrar un mensaje de error
     *
     * @param codigo Indica el motivo del error:
     **
     **          0 - "Error al generar el reporte"
     **          1 - "No se ha encontrado un cliente con ese nombre"
     */
    public ReporteException(int codigo) {
        super();
        this.codigo = codigo;
    }
    /**No recibe codigo de error, solo muestra el mensaje de error por default: "Error en la fecha"
     *
     */
    public ReporteException(){
        super();
        codigo = 0;
    }

    /**Devuelve el mensaje de error
     *
     * @return mensaje de error predefinido, tipo String
     */
    @Override
    public String getMessage() {
        if(codigo == 1)
            return "No se ha encontrado un cliente con ese nombre";
        else return "Error al generar el reporte";
    }

    /**Devuelve el código de error
     *
     * @return código de error, tipo int
     */
    public int getCodigo() {
        return codigo;
    }

}