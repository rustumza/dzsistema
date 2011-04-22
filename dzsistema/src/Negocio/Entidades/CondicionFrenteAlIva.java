/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author juampa
 */
@Entity
public class CondicionFrenteAlIva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @ManyToOne
    private TipoFactura tipoDeFactura;

    public TipoFactura getTipoDeFactura() {
        return tipoDeFactura;
    }

    public void setTipoDeFactura(TipoFactura tipoDeFactura) {
        this.tipoDeFactura = tipoDeFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof CondicionFrenteAlIva)) {
            return false;
        }
        CondicionFrenteAlIva other = (CondicionFrenteAlIva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    //TO DO consultar al juampi por los toString estos
    @Override
    public String toString() {
        return "Negocio.Entidades.CondicionFrenteAlIva[id=" + id + "]";
    }



}
