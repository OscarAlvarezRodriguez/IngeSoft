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
@Table(name = "medicamentoinvima", catalog = "unfarmapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Medicamentoinvima.findAll", query = "SELECT m FROM Medicamentoinvima m")
    , @NamedQuery(name = "Medicamentoinvima.findByIdmedicamentoinvima", query = "SELECT m FROM Medicamentoinvima m WHERE m.idmedicamentoinvima = :idmedicamentoinvima")
    , @NamedQuery(name = "Medicamentoinvima.findByNombremedicamento", query = "SELECT m FROM Medicamentoinvima m WHERE m.nombremedicamento = :nombremedicamento")
    , @NamedQuery(name = "Medicamentoinvima.findByTitular", query = "SELECT m FROM Medicamentoinvima m WHERE m.titular = :titular")
    , @NamedQuery(name = "Medicamentoinvima.findByDescripcion", query = "SELECT m FROM Medicamentoinvima m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Medicamentoinvima.findByPresentacion", query = "SELECT m FROM Medicamentoinvima m WHERE m.presentacion = :presentacion")
    , @NamedQuery(name = "Medicamentoinvima.findByPrincipioactivo", query = "SELECT m FROM Medicamentoinvima m WHERE m.principioactivo = :principioactivo")})
public class Medicamentoinvima implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICAMENTOINVIMA")
    private Short idmedicamentoinvima;
    @Basic(optional = false)
    @Column(name = "NOMBREMEDICAMENTO")
    private String nombremedicamento;
    @Basic(optional = false)
    @Column(name = "TITULAR")
    private String titular;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "PRESENTACION")
    private String presentacion;
    @Basic(optional = false)
    @Column(name = "PRINCIPIOACTIVO")
    private String principioactivo;
    @OneToMany(mappedBy = "idmedicamentoinvima")
    private List<Medicamento> medicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicamentoinvima2")
    private Collection<Medicamento> medicamentoCollection;

    public Medicamentoinvima() {
    }

    public Medicamentoinvima(Short idmedicamentoinvima) {
        this.idmedicamentoinvima = idmedicamentoinvima;
    }

    public Medicamentoinvima(Short idmedicamentoinvima, String nombremedicamento, String titular, String descripcion, String presentacion, String principioactivo) {
        this.idmedicamentoinvima = idmedicamentoinvima;
        this.nombremedicamento = nombremedicamento;
        this.titular = titular;
        this.descripcion = descripcion;
        this.presentacion = presentacion;
        this.principioactivo = principioactivo;
    }

    public Short getIdmedicamentoinvima() {
        return idmedicamentoinvima;
    }

    public void setIdmedicamentoinvima(Short idmedicamentoinvima) {
        Short oldIdmedicamentoinvima = this.idmedicamentoinvima;
        this.idmedicamentoinvima = idmedicamentoinvima;
        changeSupport.firePropertyChange("idmedicamentoinvima", oldIdmedicamentoinvima, idmedicamentoinvima);
    }

    public String getNombremedicamento() {
        return nombremedicamento;
    }

    public void setNombremedicamento(String nombremedicamento) {
        String oldNombremedicamento = this.nombremedicamento;
        this.nombremedicamento = nombremedicamento;
        changeSupport.firePropertyChange("nombremedicamento", oldNombremedicamento, nombremedicamento);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        String oldTitular = this.titular;
        this.titular = titular;
        changeSupport.firePropertyChange("titular", oldTitular, titular);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        String oldPresentacion = this.presentacion;
        this.presentacion = presentacion;
        changeSupport.firePropertyChange("presentacion", oldPresentacion, presentacion);
    }

    public String getPrincipioactivo() {
        return principioactivo;
    }

    public void setPrincipioactivo(String principioactivo) {
        String oldPrincipioactivo = this.principioactivo;
        this.principioactivo = principioactivo;
        changeSupport.firePropertyChange("principioactivo", oldPrincipioactivo, principioactivo);
    }

    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicamentoinvima != null ? idmedicamentoinvima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentoinvima)) {
            return false;
        }
        Medicamentoinvima other = (Medicamentoinvima) object;
        if ((this.idmedicamentoinvima == null && other.idmedicamentoinvima != null) || (this.idmedicamentoinvima != null && !this.idmedicamentoinvima.equals(other.idmedicamentoinvima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pruebas.Medicamentoinvima[ idmedicamentoinvima=" + idmedicamentoinvima + " ]";
    }

    public Collection<Medicamento> getMedicamentoCollection() {
        return medicamentoCollection;
    }

    public void setMedicamentoCollection(Collection<Medicamento> medicamentoCollection) {
        this.medicamentoCollection = medicamentoCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
