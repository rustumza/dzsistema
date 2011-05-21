/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.Reportes;

import InterfacesGraficas.PantallaFacturacion;
import InterfacesGraficas.exceptions.ClienteExcepcion;
import Negocio.Entidades.Cliente;
import Negocio.Entidades.Producto;
import Negocio.Reportes.DtoMesCantidadProducto;
import Negocio.Reportes.ExpertoEvolucionComprasClienteRespectoAUnProducto;
import Negocio.Reportes.ReporteException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import validar.Validar;
import validar.fechaException;

/**
 *
 * @author rustu
 */
public class ControladorEvolucionComprasClienteRespectoAUnProducto {

    PantallaEvolucionComprasClienteRespectoAUnProducto pantalla;
    ExpertoEvolucionComprasClienteRespectoAUnProducto experto;
    Cliente cliente = null;
    Producto prod = null;
    PantallaFacturacion pantallaFacturacion = null;
    public PantallaEvolucionComprasClienteRespectoAUnProducto getPantalla(){
        return pantalla;
    }

    public ControladorEvolucionComprasClienteRespectoAUnProducto(){
        experto = new ExpertoEvolucionComprasClienteRespectoAUnProducto();
    }
    
    public ControladorEvolucionComprasClienteRespectoAUnProducto(PantallaFacturacion pantallaFacturacion){
        experto = new ExpertoEvolucionComprasClienteRespectoAUnProducto();
        this.pantallaFacturacion = pantallaFacturacion;
    }
    
    public void iniciarPantalla(){
        pantalla = new PantallaEvolucionComprasClienteRespectoAUnProducto(this);
        pantalla.setLocationRelativeTo(pantallaFacturacion);
        pantalla.setVisible(true);
    }


    public void buscarProducto(){
        int codigoInt = 0;
        try{
            String codigo = pantalla.getCodigoProducto().getText();
            if(codigo.equals("")){
                return;
            }
            codigoInt = Integer.parseInt(codigo);
            prod = experto.buscarProducto(codigoInt);
            if(prod == null){
                JOptionPane.showMessageDialog(pantalla, "El producto ingresado no existe", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getCodigoProducto().requestFocus();

            }else{
                pantalla.getNombreProducto().setText(prod.getDescripcion());
                pantalla.getNombreCliente().requestFocus();
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(pantalla, "El código de producto ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;
        }

    }


    public void buscarEvolucion() {
        int anioInicioInt = 0;
        int anioFinInt = 0;
        int mesInicio = 0;
        int mesFin = 0;



        if(cliente == null){
            JOptionPane.showMessageDialog(pantalla, "No se ha buscado un cliente", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getNombreCliente().requestFocus();
            return;
        }
        if(prod == null){
            JOptionPane.showMessageDialog(pantalla, "No se ha buscado un producto", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;
        }        
        try{
            String anioInicio = pantalla.getAnioInicio().getText();
            if(anioInicio.length() != 2){
                JOptionPane.showMessageDialog(pantalla, "El año de inicio ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getAnioInicio().requestFocus();
                return;
            }
            anioInicioInt = Integer.parseInt("20" + anioInicio);

            String mesInicioString = (String)pantalla.getMesInicioComboBox().getSelectedItem();
            mesInicio = 0;
            if(mesInicioString.equals("Enero")){
                mesInicio = 0;
            }else if(mesInicioString.equals("Febrero")){
                mesInicio = 1;
            }else if(mesInicioString.equals("Marzo")){
                mesInicio = 2;
            }else if(mesInicioString.equals("Abril")){
                mesInicio = 3;
            }else if(mesInicioString.equals("Mayo")){
                mesInicio = 4;
            }else if(mesInicioString.equals("Junio")){
                mesInicio = 5;
            }else if(mesInicioString.equals("Julio")){
                mesInicio = 6;
            }else if(mesInicioString.equals("Agosto")){
                mesInicio = 7;
            }else if(mesInicioString.equals("Setiembre")){
                mesInicio = 8;
            }else if(mesInicioString.equals("Octubre")){
                mesInicio = 9;
            }else if(mesInicioString.equals("Noviembre")){
                mesInicio = 10;
            }else if(mesInicioString.equals("Diciembre")){
                mesInicio = 11;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(pantalla, "El año de inicio ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;
        }

        try{
            String anioFin = pantalla.getAnioFin().getText();
            if(anioFin.length() != 2){
                JOptionPane.showMessageDialog(pantalla, "El año de fin ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getAnioFin().requestFocus();
                return;
            }
            anioFinInt = Integer.parseInt("20" + anioFin);
            
            String mesFinString = (String)pantalla.getMesFinComboBox().getSelectedItem();
            mesFin = 0;
            if(mesFinString.equals("Enero")){
                mesFin = 1;
            }else if(mesFinString.equals("Febrero")){
                mesFin = 2;
            }else if(mesFinString.equals("Marzo")){
                mesFin = 3;
            }else if(mesFinString.equals("Abril")){
                mesFin = 4;
            }else if(mesFinString.equals("Mayo")){
                mesFin = 5;
            }else if(mesFinString.equals("Junio")){
                mesFin = 6;
            }else if(mesFinString.equals("Julio")){
                mesFin = 7;
            }else if(mesFinString.equals("Agosto")){
                mesFin = 8;
            }else if(mesFinString.equals("Setiembre")){
                mesFin = 9;
            }else if(mesFinString.equals("Octubre")){
                mesFin = 10;
            }else if(mesFinString.equals("Noviembre")){
                mesFin = 11;
            }else if(mesFinString.equals("Diciembre")){
                mesFin = 0;
                anioFinInt++;
            }

       }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(pantalla, "El año de inicio ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;
       }
       try{
            Date fechaInicio = new Date((anioInicioInt-1900),mesInicio,1);
            Date fechaFin = new Date((anioFinInt-1900),mesFin,1);
            List<DtoMesCantidadProducto> listaDtoResultante = experto.buscarHitorialProducto(prod.getCodigo(), fechaInicio, fechaFin, cliente.getCodigo(),pantalla.getMostrarMesesEnCero().isSelected());
            new PantallaTablaResultadosEvolucionComprasClientesRespectoAUnProducto().iniciar(cliente, prod, fechaInicio, fechaFin, listaDtoResultante);
       }catch(fechaException e){
            JOptionPane.showMessageDialog(pantalla, e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getAnioInicio().requestFocus();
            return;

       }catch(ReporteException e){
            JOptionPane.showMessageDialog(pantalla, e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
            pantalla.getCodigoProducto().requestFocus();
            return;

       }

    }



 public void buscarClientePorNombre(String nombre) {
        if(!(nombre.equals(""))){
            try{
                List<Cliente> listaDeClientes = experto.buscarClientePorNombre(nombre);
                if(listaDeClientes.size() == 1){
                    //si tre un solo cliente
                    buscarClientePorNumero(String.valueOf(listaDeClientes.get(0).getCodigo()));
                    pantalla.getMesInicioComboBox().requestFocus();
                }else{
                    //si trae muchos clientes
                    iniciarPantallaElegirCliente(listaDeClientes);
                }
            }catch(ClienteExcepcion e){
                JOptionPane.showMessageDialog(pantalla, e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNombreCliente().requestFocus();
            }
        }else{            
            pantalla.getNumeroCliente().requestFocus();
            
        }
    }


    public void buscarClientePorNumero(String numeroCliente) {
        if(!(numeroCliente.equals(""))){
            try{
                Cliente cliente = experto.buscarClientePorNumero(numeroCliente);
                cargarDatosClienteYFactura(cliente);
                pantalla.getMesInicioComboBox().requestFocus();
            }catch(ClienteExcepcion e){
                JOptionPane.showMessageDialog(pantalla, e.getMessage(), "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getNumeroCliente().requestFocus();

            }
        }else{
            pantalla.getCuitCliente().requestFocus();
            }
        }
    

    public void buscarClientePorCuit(String cuitSinFormato) {
        if(!(cuitSinFormato.equals(""))){
            if(Validar.controlCUIT(cuitSinFormato)){
                String cuit = Validar.formatearCUIT(cuitSinFormato);
                try{
                    Cliente cliente = experto.buscarClientePorCuit(cuit);
                    cargarDatosClienteYFactura(cliente);
                    pantalla.getMesInicioComboBox().requestFocus();
                }catch(ClienteExcepcion e){
                    JOptionPane.showMessageDialog(pantalla,e.getMessage() ,"¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                    pantalla.getCuitCliente().requestFocus();

                }
            }else{
                JOptionPane.showMessageDialog(null, "El CUIT ingresado no es válido", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                pantalla.getCuitCliente().requestFocus();
            }
        }else{
            pantalla.getNombreCliente().requestFocus();
            
        }

    }

    private void cargarDatosClienteYFactura(Cliente cliente) {
        pantalla.getNombreCliente().setText(cliente.getNombre());
        pantalla.getNumeroCliente().setText(String.valueOf(cliente.getCodigo()));
        pantalla.getCuitCliente().setText(cliente.getCUIT());
        this.cliente=cliente;

    }



    public void colocarCuitEnFormatoParaEditar() {
        pantalla.getCuitCliente().setText(Validar.desformatearCUIT(pantalla.getCuitCliente().getText()));
    }


//ACA COMIENZA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE

    private PantallaElegirClienteEvolucionDeCompras PantallaElegirClienteEvolucionDeCompras;
    private List<Cliente> listaClientes;

    public void iniciarPantallaElegirCliente(List<Cliente> listaDeClientes) {

        PantallaElegirClienteEvolucionDeCompras = new PantallaElegirClienteEvolucionDeCompras(this);
        this.listaClientes = listaDeClientes;
        CargarTablaClientes();
        PantallaElegirClienteEvolucionDeCompras.getTabla().getColumnModel().getColumn(0).setPreferredWidth(45);  //cantidad
        PantallaElegirClienteEvolucionDeCompras.getTabla().getColumnModel().getColumn(1).setPreferredWidth(200);  //codigo
        PantallaElegirClienteEvolucionDeCompras.getTabla().getColumnModel().getColumn(2).setPreferredWidth(90); //descripcion
        PantallaElegirClienteEvolucionDeCompras.setVisible(true);
        PantallaElegirClienteEvolucionDeCompras.setLocationRelativeTo(pantalla);

    }

     public  void CargarTablaClientes() {
        try {

            Object[][] datos = null;

            datos = new Object[listaClientes.size()][4];
            for (int i = 0; i < listaClientes.size(); i++) {
                datos[i][0] = listaClientes.get(i).getCodigo();
                datos[i][1] = listaClientes.get(i).getNombre();
                datos[i][2] = listaClientes.get(i).getCUIT();


            }

            String[] columnNames = {"Código", "Nombre", "CUIT"};
            PantallaElegirClienteEvolucionDeCompras.getTabla().setModel(new DefaultTableModel(datos, columnNames) {


                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            });

        } catch (NullPointerException e) {
        }
     }


     public void clienteSeleccionado(int filaSeleccionada){
        cerrarPantallaSeleccionCliente();
        buscarClientePorNumero(String.valueOf(listaClientes.get(filaSeleccionada).getCodigo()));
     }

     public void cancelarSeleccionDeCliente(){
        cerrarPantallaSeleccionCliente();
        pantalla.getNombreCliente().requestFocus();
     }

     private void cerrarPantallaSeleccionCliente(){
        PantallaElegirClienteEvolucionDeCompras.dispose();

     }

    public void limpiarPantalla() {
        //producto
        pantalla.getCodigoProducto().setText("");
        pantalla.getNombreProducto().setText("");
        prod = null;
        //cliente
        pantalla.getNombreCliente().setText("");
        pantalla.getNumeroCliente().setText("");
        pantalla.getCuitCliente().setText("");
        pantalla.getClienteSeleccionado().setText("");
        cliente = null;
        //años
        pantalla.getAnioInicio().setText("");
        pantalla.getAnioFin().setText("");
        pantalla.getMesInicioComboBox().setSelectedIndex(0);
        pantalla.getMesFinComboBox().setSelectedIndex(0);
        pantalla.getMostrarMesesEnCero().setSelected(false);

        
        
    }

//ACA TERMINA EL CONTROL DE LA PANTALLA PARA ELEGIR CLIENTE


}
