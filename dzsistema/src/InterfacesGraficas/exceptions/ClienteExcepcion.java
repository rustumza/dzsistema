/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.exceptions;

/**
 *
 * @author rustu
 */
public class ClienteExcepcion extends Exception{


    private final int codigo;

    /**Recibe el código de error, para mostrar un mensaje de error
     *
     * @param codigo Indica el motivo del error:
     **
     **          0 - "Error: no se ha encontrado un cliente"
     **          1 - "No se ha encontrado un cliente con ese nombre"
     **          2 - "No se ha encontrado un cliente con ese número de cliente"
     **          3 - "No se ha encontrado un cliente con ese cuit"
     **          
     */
    public ClienteExcepcion(int codigo) {
        super();
        this.codigo = codigo;
    }
    /**No recibe codigo de error, solo muestra el mensaje de error por default: "Error: no se ha encontrado ningun cliente"
     *
     */
    public ClienteExcepcion(){
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
        else if(codigo == 2)
            return "No se ha encontrado un cliente con ese número de cliente";
        else if(codigo == 3)
            return "No se ha encontrado un cliente con ese cuit";
        else return "Error: no se ha encontrado un cliente";
    }

    /**Devuelve el código de error
     *
     * @return código de error, tipo int
     */
    public int getCodigo() {
        return codigo;
    }


}
