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
@Table(name = "compramedicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compramedicamento.findAll", query = "SELECT c FROM Compramedicamento c")
    , @NamedQuery(name = "Compramedicamento.findByIdmedicamento", query = "SELECT c FROM Compramedicamento c WHERE c.compramedicamentoPK.idmedicamento = :idmedicamento")
    , @NamedQuery(name = "Compramedicamento.findByIdcompra", query = "SELECT c FROM Compramedicamento c WHERE c.compramedicamentoPK.idcompra = :idcompra")
    , @NamedQuery(name = "Compramedicamento.findByPreciounitario", query = "SELECT c FROM Compramedicamento c WHERE c.preciounitario = :preciounitario")
    , @NamedQuery(name = "Compramedicamento.findByCantidad", query = "SELECT c FROM Compramedicamento c WHERE c.cantidad = :cantidad")})
public class Compramedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompramedicamentoPK compramedicamentoPK;
    @Basic(optional = false)
    @Column(name = "PRECIOUNITARIO")
    private int preciounitario;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private short cantidad;
    @JoinColumn(name = "IDMEDICAMENTO", referencedColumnName = "IDMEDICAMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicamento medicamento;
    @JoinColumn(name = "IDCOMPRA", referencedColumnName = "IDCOMPRA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compra compra;

    public Compramedicamento() {
    }

    public Compramedicamento(CompramedicamentoPK compramedicamentoPK) {
        this.compramedicamentoPK = compramedicamentoPK;
    }

    public Compramedicamento(int preciounitario, short cantidad) {
        this.preciounitario = preciounitario;
        this.cantidad = cantidad;
    }

    public Compramedicamento(short idmedicamento, int idcompra) {
        this.compramedicamentoPK = new CompramedicamentoPK(idmedicamento, idcompra);
    }

    public CompramedicamentoPK getCompramedicamentoPK() {
        return compramedicamentoPK;
    }

    public void setCompramedicamentoPK(CompramedicamentoPK compramedicamentoPK) {
        this.compramedicamentoPK = compramedicamentoPK;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compramedicamentoPK != null ? compramedicamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compramedicamento)) {
            return false;
        }
        Compramedicamento other = (Compramedicamento) object;
        if ((this.compramedicamentoPK == null && other.compramedicamentoPK != null) || (this.compramedicamentoPK != null && !this.compramedicamentoPK.equals(other.compramedicamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Compramedicamento[ compramedicamentoPK=" + compramedicamentoPK + " ]";
    }

}
