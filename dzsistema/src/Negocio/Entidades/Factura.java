/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author juampa
 */
@Entity
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private int numero;
    private int remitoNro;
    private float total;
    private boolean estado;
    @ManyToOne
    private CondicionDeVenta condicionDeVenta;
    @ManyToOne
    private TipoFactura tipoFactura;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    List<DetalleFactura> detallesDeFactura;

    public Factura() {
         detallesDeFactura = new ArrayList<DetalleFactura>();
    }

    public void addDetalle(DetalleFactura detalle) {
        //if (!getDetallesDeFactura().contains(detalle)) {
        if (!estaEnLaLista(detalle)) {
            getDetallesDeFactura().add(detalle);
            if (detalle.getFactura() != null) {
                detalle.getFactura().getDetallesDeFactura().remove(detalle);
            }
            detalle.setFactura(this);
        }
    }

    public List<DetalleFactura> getDetallesDeFactura() {
        return detallesDeFactura;
    }

    public CondicionDeVenta getCondicionDeVenta() {
        return condicionDeVenta;
    }

    public void setCondicionDeVenta(CondicionDeVenta condicionDeVenta) {
        this.condicionDeVenta = condicionDeVenta;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getRemitoNro() {
        return remitoNro;
    }

    public void setRemitoNro(int remitoNro) {
        this.remitoNro = remitoNro;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.Entidades.Factura[id=" + id + "]";
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public void vaciarListaDeDetalles(){
        detallesDeFactura = new ArrayList<DetalleFactura>();

    }
//este metodo es para probar!!!
    private boolean estaEnLaLista(DetalleFactura detalle) {
        for (DetalleFactura detalleFactura : detallesDeFactura) {
            if(detalle==detalleFactura)
                return true;
        }
        return false;
    }
}
