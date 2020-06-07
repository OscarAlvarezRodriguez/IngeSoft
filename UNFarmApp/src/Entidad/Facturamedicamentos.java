package Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "facturamedicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturamedicamentos.findAll", query = "SELECT f FROM Facturamedicamentos f")
    , @NamedQuery(name = "Facturamedicamentos.findByIdmedicamento", query = "SELECT f FROM Facturamedicamentos f WHERE f.facturamedicamentosPK.idmedicamento = :idmedicamento")
    , @NamedQuery(name = "Facturamedicamentos.findByIdfactura", query = "SELECT f FROM Facturamedicamentos f WHERE f.facturamedicamentosPK.idfactura = :idfactura")
    , @NamedQuery(name = "Facturamedicamentos.findByCantidadvendida", query = "SELECT f FROM Facturamedicamentos f WHERE f.cantidadvendida = :cantidadvendida")})
public class Facturamedicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturamedicamentosPK facturamedicamentosPK;
    @Basic(optional = false)
    @Column(name = "CANTIDADVENDIDA")
    private short cantidadvendida;
    @JoinColumn(name = "IDMEDICAMENTO", referencedColumnName = "IDMEDICAMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicamento medicamento;
    @JoinColumn(name = "IDFACTURA", referencedColumnName = "IDFACTURA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public Facturamedicamentos() {
    }

    public Facturamedicamentos(FacturamedicamentosPK facturamedicamentosPK) {
        this.facturamedicamentosPK = facturamedicamentosPK;
    }

    public Facturamedicamentos(FacturamedicamentosPK facturamedicamentosPK, short cantidadvendida) {
        this.facturamedicamentosPK = facturamedicamentosPK;
        this.cantidadvendida = cantidadvendida;
    }

    public Facturamedicamentos(short idmedicamento, int idfactura) {
        this.facturamedicamentosPK = new FacturamedicamentosPK(idmedicamento, idfactura);
    }

    public FacturamedicamentosPK getFacturamedicamentosPK() {
        return facturamedicamentosPK;
    }

    public void setFacturamedicamentosPK(FacturamedicamentosPK facturamedicamentosPK) {
        this.facturamedicamentosPK = facturamedicamentosPK;
    }

    public short getCantidadvendida() {
        return cantidadvendida;
    }

    public void setCantidadvendida(short cantidadvendida) {
        this.cantidadvendida = cantidadvendida;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturamedicamentosPK != null ? facturamedicamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturamedicamentos)) {
            return false;
        }
        Facturamedicamentos other = (Facturamedicamentos) object;
        if ((this.facturamedicamentosPK == null && other.facturamedicamentosPK != null) || (this.facturamedicamentosPK != null && !this.facturamedicamentosPK.equals(other.facturamedicamentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Facturamedicamentos[ facturamedicamentosPK=" + facturamedicamentosPK + " ]";
    }

}
