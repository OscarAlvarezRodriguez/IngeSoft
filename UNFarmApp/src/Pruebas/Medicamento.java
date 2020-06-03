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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author juanm
 */
@Entity
@Table(name = "medicamento", catalog = "unfarmapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdmedicamento", query = "SELECT m FROM Medicamento m WHERE m.idmedicamento = :idmedicamento")
    , @NamedQuery(name = "Medicamento.findByPrecioventa", query = "SELECT m FROM Medicamento m WHERE m.precioventa = :precioventa")
    , @NamedQuery(name = "Medicamento.findByStock", query = "SELECT m FROM Medicamento m WHERE m.stock = :stock")})
public class Medicamento implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICAMENTO")
    private Short idmedicamento;
    @Basic(optional = false)
    @Column(name = "PRECIOVENTA")
    private int precioventa;
    @Basic(optional = false)
    @Column(name = "STOCK")
    private short stock;
    @JoinColumn(name = "IDMEDICAMENTOINVIMA", referencedColumnName = "IDMEDICAMENTOINVIMA")
    @ManyToOne
    private Medicamentoinvima idmedicamentoinvima;
    @JoinColumn(name = "IDMEDICAMENTOINVIMA", referencedColumnName = "IDMEDICAMENTOINVIMA", updatable = false, insertable = false)
    @ManyToOne
    private Medicamentoinvima idmedicamentoinvima2;

    public Medicamento() {
    }

    public Medicamento(Short idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public Medicamento(Short idmedicamento, int precioventa, short stock) {
        this.idmedicamento = idmedicamento;
        this.precioventa = precioventa;
        this.stock = stock;
    }

    public Short getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(Short idmedicamento) {
        Short oldIdmedicamento = this.idmedicamento;
        this.idmedicamento = idmedicamento;
        changeSupport.firePropertyChange("idmedicamento", oldIdmedicamento, idmedicamento);
    }

    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        int oldPrecioventa = this.precioventa;
        this.precioventa = precioventa;
        changeSupport.firePropertyChange("precioventa", oldPrecioventa, precioventa);
    }

    public short getStock() {
        return stock;
    }

    public void setStock(short stock) {
        short oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
    }

    public Medicamentoinvima getIdmedicamentoinvima() {
        return idmedicamentoinvima;
    }

    public void setIdmedicamentoinvima(Medicamentoinvima idmedicamentoinvima) {
        Medicamentoinvima oldIdmedicamentoinvima = this.idmedicamentoinvima;
        this.idmedicamentoinvima = idmedicamentoinvima;
        changeSupport.firePropertyChange("idmedicamentoinvima", oldIdmedicamentoinvima, idmedicamentoinvima);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicamento != null ? idmedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idmedicamento == null && other.idmedicamento != null) || (this.idmedicamento != null && !this.idmedicamento.equals(other.idmedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pruebas.Medicamento[ idmedicamento=" + idmedicamento + " ]";
    }

    public Medicamentoinvima getIdmedicamentoinvima2() {
        return idmedicamentoinvima2;
    }

    public void setIdmedicamentoinvima2(Medicamentoinvima idmedicamentoinvima2) {
        Medicamentoinvima oldIdmedicamentoinvima2 = this.idmedicamentoinvima2;
        this.idmedicamentoinvima2 = idmedicamentoinvima2;
        changeSupport.firePropertyChange("idmedicamentoinvima2", oldIdmedicamentoinvima2, idmedicamentoinvima2);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
