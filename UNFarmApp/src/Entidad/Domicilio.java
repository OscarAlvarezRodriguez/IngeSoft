package Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "domicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d")
    , @NamedQuery(name = "Domicilio.findByIddomicilio", query = "SELECT d FROM Domicilio d WHERE d.iddomicilio = :iddomicilio")
    , @NamedQuery(name = "Domicilio.findByEstado", query = "SELECT d FROM Domicilio d WHERE d.estado = :estado")})
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDOMICILIO")
    private Integer iddomicilio;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private short estado;
    @JoinColumn(name = "IDFACTURA")
    @OneToOne(optional = false)
    private Factura idfactura;

    public Domicilio() {
    }

    public Domicilio(Integer iddomicilio) {
        this.iddomicilio = iddomicilio;
    }

    public Domicilio(Integer iddomicilio, short estado) {
        this.iddomicilio = iddomicilio;
        this.estado = estado;
    }

    public Integer getIddomicilio() {
        return iddomicilio;
    }

    public void setIddomicilio(Integer iddomicilio) {
        this.iddomicilio = iddomicilio;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Factura getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Factura idfactura) {
        this.idfactura = idfactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddomicilio != null ? iddomicilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.iddomicilio == null && other.iddomicilio != null) || (this.iddomicilio != null && !this.iddomicilio.equals(other.iddomicilio))) {
            return false;
        }
        return true;
    }


}
