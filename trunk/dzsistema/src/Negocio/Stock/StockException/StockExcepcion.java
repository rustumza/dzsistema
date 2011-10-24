/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Stock.StockException;

/**
 *
 * @author rustu
 */
public class StockExcepcion extends Exception{


    private final int codigo;

    /**Recibe el código de error, para mostrar un mensaje de error
     *
     * @param codigo Indica el motivo del error:
     **
     **          0 - "Error: no existe el stock"
     **          1 - "Error en las fechas seleccionadas para informe de stock"
     **          2 - "Cantidad a retirar superior a la cantidad disponible"
     **          3 - "Error al guardar el stock"
     **          
     */
    public StockExcepcion(int codigo) {
        super();
        this.codigo = codigo;
    }
    /**No recibe codigo de error, solo muestra el mensaje de error por default: "Error: no se ha encontrado ningun cliente"
     *
     */
    public StockExcepcion(){
        super();
        codigo = 0;
    }

    /**Devuelve el mensaje de error
     *
     * @return mensaje de error predefinido, tipo String
     */
    @Override
    public String getMessage() {
        if(codigo == 1){
            return "Error en las fechas seleccionadas para informe de stock";
        }else if(codigo == 2) {
            return "Cantidad a retirar superior a la cantidad disponible";
        }else if(codigo == 3){
            return "Error al guardar el stock";
        }
        else return "Error: no existe el stock";
    }

    /**Devuelve el código de error
     *
     * @return código de error, tipo int
     */
    public int getCodigo() {
        return codigo;
    }


}
