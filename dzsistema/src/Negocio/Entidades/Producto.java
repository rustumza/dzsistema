/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author juampa
 */
@Entity
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int codigo;
    private String descripcion;
    private float porcentajeDeIva;
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL)
    List<PrecioHistorico> preciosHistoricos;

    public void setPreciosHistoricos(List<PrecioHistorico> preciosHistoricos) {
        this.preciosHistoricos = preciosHistoricos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Producto() {
         preciosHistoricos = new ArrayList<PrecioHistorico>();
    }

    public void addPrecio(PrecioHistorico precio) {
        if (!getPreciosHistoricos().contains(precio)) {
            getPreciosHistoricos().add(precio);
            if (precio.getProducto() != null) {
                precio.getProducto().getPreciosHistoricos().remove(precio);
            }
            precio.setProducto(this);
        }
    }

    public List<PrecioHistorico> getPreciosHistoricos() {
        return preciosHistoricos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPorcentajeDeIva() {
        return porcentajeDeIva;
    }

    public void setPorcentajeDeIva(float porcentajeDeIva) {
        this.porcentajeDeIva = porcentajeDeIva;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.Entidades.Producto[id=" + id + "]";
    }

}
