/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Impresion;

import Negocio.Entidades.Factura;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Administrador
 */
public class ManejadorImpresion {
    Connection conn = null;

    public ManejadorImpresion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/binladen", "root", "leviatan");
            //JOptionPane.showMessageDialog(null, "Conexión establecida");
        } catch (Exception ex) {
        }
    }

    public void imprimirFacturaA(Factura factura) {
        try {
            String archivoCadena = null;
            Map parametro = new HashMap();
//            parametro.put("factura", factura.getId().toString());
            //este es el parámetro, se pueden agregar más parámetros
            //basta con poner mas parametro.put
            //Ej:
//            parametro.put("nombre", factura.getNumero());
            FacturaBDataSource facturaDS = new FacturaBDataSource();
            facturaDS.addFactura(factura);
            archivoCadena = "FacturaA.jasper";
            if (archivoCadena == null) {
                JOptionPane.showMessageDialog(null,"No se encuentra el archivo", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(archivoCadena);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null,"Error cargando el reporte maestro: " + e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            //Reporte diseñado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, facturaDS);
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Factura A");
            jviewer.setVisible(true);
        } catch (Exception j) {
            JOptionPane.showMessageDialog(null,"Error:" + j.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public void imprimirFacturaB(Factura factura) {
        try {
            String archivoCadena = null;
            Map parametro = new HashMap();
            FacturaADataSource facturaDS = new FacturaADataSource();
            facturaDS.addFactura(factura);
            archivoCadena = "FacturaB.jasper";
            if (archivoCadena == null) {
                JOptionPane.showMessageDialog(null,"No se encuentra el archivo", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(archivoCadena);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null,"Error cargando el reporte maestro: " + e.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            //Reporte diseñado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, facturaDS);
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Factura B");
            jviewer.setVisible(true);
        } catch (Exception j) {
            JOptionPane.showMessageDialog(null,"Error:" + j.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cerrar() {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }

}
