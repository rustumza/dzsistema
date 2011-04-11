/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author juampa
 */
@Entity
public class PrecioHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDesdeQueEntroEnVigencia;
    private float precio;

    public Date getFechaDesdeQueEntroEnVigencia() {
        return fechaDesdeQueEntroEnVigencia;
    }

    public void setFechaDesdeQueEntroEnVigencia(Date fechaDesdeQueEntroEnVigencia) {
        this.fechaDesdeQueEntroEnVigencia = fechaDesdeQueEntroEnVigencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
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
        if (!(object instanceof PrecioHistorico)) {
            return false;
        }
        PrecioHistorico other = (PrecioHistorico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.Entidades.PrecioHistorico[id=" + id + "]";
    }

}