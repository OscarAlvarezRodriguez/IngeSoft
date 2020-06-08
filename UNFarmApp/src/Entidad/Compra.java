package Entidad;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByIdcompra", query = "SELECT c FROM Compra c WHERE c.idcompra = :idcompra")
    , @NamedQuery(name = "Compra.findByNombreproveedor", query = "SELECT c FROM Compra c WHERE c.nombreproveedor = :nombreproveedor")
    , @NamedQuery(name = "Compra.findByPreciototal", query = "SELECT c FROM Compra c WHERE c.preciototal = :preciototal")
    , @NamedQuery(name = "Compra.findByFecha", query = "SELECT c FROM Compra c WHERE c.fecha = :fecha")})
public class Compra implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<Compramedicamento> compramedicamentoList;

    public Compra() {
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Compra(String nombreproveedor, long preciototal, Date fecha) {
        this.nombreproveedor = nombreproveedor;
        this.preciototal = preciototal;
        this.fecha = fecha;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public long getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(long preciototal) {
        this.preciototal = preciototal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Compramedicamento> getCompramedicamentoList() {
        return compramedicamentoList;
    }

    public void setCompramedicamentoList(List<Compramedicamento> compramedicamentoList) {
        this.compramedicamentoList = compramedicamentoList;
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
        return "Entidad.Compra[ idcompra=" + idcompra + " ]";
    }

}
