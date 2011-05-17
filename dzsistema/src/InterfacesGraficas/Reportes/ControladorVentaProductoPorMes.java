/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.Reportes;

import Negocio.Reportes.DtoResultado;
import Negocio.Reportes.ExpertoVentaProductoPorMes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juampa
 */
public class ControladorVentaProductoPorMes {
    ExpertoVentaProductoPorMes experto = new ExpertoVentaProductoPorMes();

    public List<DtoResultado> generarReporte(Date inicio, Date fin) {
        return experto.generarReporte(inicio, fin);
    }

}
