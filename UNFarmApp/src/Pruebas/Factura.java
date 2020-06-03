/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author juanm
 */
@Entity
@Table(name = "factura", catalog = "unfarmapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura")
    , @NamedQuery(name = "Factura.findByNitdrogueria", query = "SELECT f FROM Factura f WHERE f.nitdrogueria = :nitdrogueria")
    , @NamedQuery(name = "Factura.findByCedulacliente", query = "SELECT f FROM Factura f WHERE f.cedulacliente = :cedulacliente")
    , @NamedQuery(name = "Factura.findByCedulaempleado", query = "SELECT f FROM Factura f WHERE f.cedulaempleado = :cedulaempleado")
    , @NamedQuery(name = "Factura.findByPreciototal", query = "SELECT f FROM Factura f WHERE f.preciototal = :preciototal")})
public class Factura implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFACTURA")
    private Integer idfactura;
    @Column(name = "NITDROGUERIA")
    private String nitdrogueria;
    @Column(name = "CEDULACLIENTE")
    private String cedulacliente;
    @Column(name = "CEDULAEMPLEADO")
    private String cedulaempleado;
    @Basic(optional = false)
    @Column(name = "PRECIOTOTAL")
    private long preciototal;
    @OneToMany(mappedBy = "idfactura")
    private List<Domicilio> domicilioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactura")
    private Collection<Domicilio> domicilioCollection;

    public Factura() {
    }

    public Factura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Factura(Integer idfactura, long preciototal) {
        this.idfactura = idfactura;
        this.preciototal = preciototal;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        Integer oldIdfactura = this.idfactura;
        this.idfactura = idfactura;
        changeSupport.firePropertyChange("idfactura", oldIdfactura, idfactura);
    }

    public String getNitdrogueria() {
        return nitdrogueria;
    }

    public void setNitdrogueria(String nitdrogueria) {
        String oldNitdrogueria = this.nitdrogueria;
        this.nitdrogueria = nitdrogueria;
        changeSupport.firePropertyChange("nitdrogueria", oldNitdrogueria, nitdrogueria);
    }

    public String getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(String cedulacliente) {
        String oldCedulacliente = this.cedulacliente;
        this.cedulacliente = cedulacliente;
        changeSupport.firePropertyChange("cedulacliente", oldCedulacliente, cedulacliente);
    }

    public String getCedulaempleado() {
        return cedulaempleado;
    }

    public void setCedulaempleado(String cedulaempleado) {
        String oldCedulaempleado = this.cedulaempleado;
        this.cedulaempleado = cedulaempleado;
        changeSupport.firePropertyChange("cedulaempleado", oldCedulaempleado, cedulaempleado);
    }

    public long getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(long preciototal) {
        long oldPreciototal = this.preciototal;
        this.preciototal = preciototal;
        changeSupport.firePropertyChange("preciototal", oldPreciototal, preciototal);
    }

    public List<Domicilio> getDomicilioList() {
        return domicilioList;
    }

    public void setDomicilioList(List<Domicilio> domicilioList) {
        this.domicilioList = domicilioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pruebas.Factura[ idfactura=" + idfactura + " ]";
    }

    public Collection<Domicilio> getDomicilioCollection() {
        return domicilioCollection;
    }

    public void setDomicilioCollection(Collection<Domicilio> domicilioCollection) {
        this.domicilioCollection = domicilioCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
