package Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdmedicamento", query = "SELECT m FROM Medicamento m WHERE m.idmedicamento = :idmedicamento")
    , @NamedQuery(name = "Medicamento.findByPrecioventa", query = "SELECT m FROM Medicamento m WHERE m.precioventa = :precioventa")
    , @NamedQuery(name = "Medicamento.findByStock", query = "SELECT m FROM Medicamento m WHERE m.stock = :stock")})
public class Medicamento implements Serializable {

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
    private Short stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamento")
    private List<Facturamedicamentos> facturamedicamentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamento")
    private List<Compramedicamento> compramedicamentoList;
    @JoinColumn(name = "IDMEDICAMENTOINVIMA", referencedColumnName = "IDMEDICAMENTOINVIMA")
    @OneToOne(optional = false)
    private Medicamentoinvima idmedicamentoinvima;

    public Medicamento() {
    }

    public Medicamento(Short idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public Medicamento(int precioventa, short stock) {
        this.precioventa = precioventa;
        this.stock = stock;
    }

    public Short getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(Short idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }

    public Short getStock() {
        return stock;
    }

    public void setStock(Short stock) {
        this.stock = stock;
    }

    @XmlTransient
    public List<Facturamedicamentos> getFacturamedicamentosList() {
        return facturamedicamentosList;
    }

    public void setFacturamedicamentosList(List<Facturamedicamentos> facturamedicamentosList) {
        this.facturamedicamentosList = facturamedicamentosList;
    }

    @XmlTransient
    public List<Compramedicamento> getCompramedicamentoList() {
        return compramedicamentoList;
    }

    public void setCompramedicamentoList(List<Compramedicamento> compramedicamentoList) {
        this.compramedicamentoList = compramedicamentoList;
    }

    public Medicamentoinvima getIdmedicamentoinvima() {
        return idmedicamentoinvima;
    }

    public void setIdmedicamentoinvima(Medicamentoinvima idmedicamentoinvima) {
        this.idmedicamentoinvima = idmedicamentoinvima;
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
        return "Entidad.Medicamento[ idmedicamento=" + idmedicamento + " ]";
    }

}
