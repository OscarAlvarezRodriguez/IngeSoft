/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author juanm
 */
@Entity
@Table(name = "compra", catalog = "unfarmapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByIdcompra", query = "SELECT c FROM Compra c WHERE c.idcompra = :idcompra")
    , @NamedQuery(name = "Compra.findByNombreproveedor", query = "SELECT c FROM Compra c WHERE c.nombreproveedor = :nombreproveedor")
    , @NamedQuery(name = "Compra.findByPreciototal", query = "SELECT c FROM Compra c WHERE c.preciototal = :preciototal")})
public class Compra implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMPRA")
    private Integer idcompra;
    @Basic(optional = false)
    @Column(name = "NOMBREPROVEEDOR")
    private String nombreproveedor;
    @Basic(optional = false)
    @Column(name = "PRECIOTOTAL")
    private long preciototal;

    public Compra() {
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Compra(Integer idcompra, String nombreproveedor, long preciototal) {
        this.idcompra = idcompra;
        this.nombreproveedor = nombreproveedor;
        this.preciototal = preciototal;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        Integer oldIdcompra = this.idcompra;
        this.idcompra = idcompra;
        changeSupport.firePropertyChange("idcompra", oldIdcompra, idcompra);
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        String oldNombreproveedor = this.nombreproveedor;
        this.nombreproveedor = nombreproveedor;
        changeSupport.firePropertyChange("nombreproveedor", oldNombreproveedor, nombreproveedor);
    }

    public long getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(long preciototal) {
        long oldPreciototal = this.preciototal;
        this.preciototal = preciototal;
        changeSupport.firePropertyChange("preciototal", oldPreciototal, preciototal);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pruebas.Compra[ idcompra=" + idcompra + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
