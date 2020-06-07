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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura")
    , @NamedQuery(name = "Factura.findByPreciototal", query = "SELECT f FROM Factura f WHERE f.preciototal = :preciototal")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFACTURA")
    private Integer idfactura;
    @Basic(optional = false)
    @Column(name = "PRECIOTOTAL")
    private long preciototal;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Facturamedicamentos> facturamedicamentosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idfactura")
    private Domicilio domicilio;
    @JoinColumn(name = "CEDULACLIENTE", referencedColumnName = "CEDULACLIENTE")
    @ManyToOne(optional = false)
    private Cliente cedulacliente;
    @JoinColumn(name = "CEDULAEMPLEADO", referencedColumnName = "CEDULAEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado cedulaempleado;
    @JoinColumn(name = "NITDROGUERIA", referencedColumnName = "NITDROGUERIA")
    @ManyToOne(optional = false)
    private Drogueria nitdrogueria;

    public Factura() {
    }

    public Factura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Factura(Integer idfactura, long preciototal, Date fecha) {
        this.idfactura = idfactura;
        this.preciototal = preciototal;
        this.fecha = fecha;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
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
    public List<Facturamedicamentos> getFacturamedicamentosList() {
        return facturamedicamentosList;
    }

    public void setFacturamedicamentosList(List<Facturamedicamentos> facturamedicamentosList) {
        this.facturamedicamentosList = facturamedicamentosList;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Cliente getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(Cliente cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public Empleado getCedulaempleado() {
        return cedulaempleado;
    }

    public void setCedulaempleado(Empleado cedulaempleado) {
        this.cedulaempleado = cedulaempleado;
    }

    public Drogueria getNitdrogueria() {
        return nitdrogueria;
    }

    public void setNitdrogueria(Drogueria nitdrogueria) {
        this.nitdrogueria = nitdrogueria;
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
        return "Entidad.Factura[ idfactura=" + idfactura + " ]";
    }

}
