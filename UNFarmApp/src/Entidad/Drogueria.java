package Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "drogueria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drogueria.findAll", query = "SELECT d FROM Drogueria d")
    , @NamedQuery(name = "Drogueria.findByNitdrogueria", query = "SELECT d FROM Drogueria d WHERE d.nitdrogueria = :nitdrogueria")
    , @NamedQuery(name = "Drogueria.findByNombredrogueria", query = "SELECT d FROM Drogueria d WHERE d.nombredrogueria = :nombredrogueria")
    , @NamedQuery(name = "Drogueria.findByDirecciondrogueria", query = "SELECT d FROM Drogueria d WHERE d.direcciondrogueria = :direcciondrogueria")
    , @NamedQuery(name = "Drogueria.findByTelefono", query = "SELECT d FROM Drogueria d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Drogueria.findByEmail", query = "SELECT d FROM Drogueria d WHERE d.email = :email")
    , @NamedQuery(name = "Drogueria.findByRepresentantelegal", query = "SELECT d FROM Drogueria d WHERE d.representantelegal = :representantelegal")})
public class Drogueria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NITDROGUERIA")
    private String nitdrogueria;
    @Basic(optional = false)
    @Column(name = "NOMBREDROGUERIA")
    private String nombredrogueria;
    @Basic(optional = false)
    @Column(name = "DIRECCIONDROGUERIA")
    private String direcciondrogueria;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "REPRESENTANTELEGAL")
    private String representantelegal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nitdrogueria")
    private List<Factura> facturaList;

    public Drogueria() {
    }

    public Drogueria(String nitdrogueria) {
        this.nitdrogueria = nitdrogueria;
    }

    public Drogueria(String nitdrogueria, String nombredrogueria, String direcciondrogueria, String telefono, String email, String representantelegal) {
        this.nitdrogueria = nitdrogueria;
        this.nombredrogueria = nombredrogueria;
        this.direcciondrogueria = direcciondrogueria;
        this.telefono = telefono;
        this.email = email;
        this.representantelegal = representantelegal;
    }

    public String getNitdrogueria() {
        return nitdrogueria;
    }

    public void setNitdrogueria(String nitdrogueria) {
        this.nitdrogueria = nitdrogueria;
    }

    public String getNombredrogueria() {
        return nombredrogueria;
    }

    public void setNombredrogueria(String nombredrogueria) {
        this.nombredrogueria = nombredrogueria;
    }

    public String getDirecciondrogueria() {
        return direcciondrogueria;
    }

    public void setDirecciondrogueria(String direcciondrogueria) {
        this.direcciondrogueria = direcciondrogueria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepresentantelegal() {
        return representantelegal;
    }

    public void setRepresentantelegal(String representantelegal) {
        this.representantelegal = representantelegal;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nitdrogueria != null ? nitdrogueria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drogueria)) {
            return false;
        }
        Drogueria other = (Drogueria) object;
        if ((this.nitdrogueria == null && other.nitdrogueria != null) || (this.nitdrogueria != null && !this.nitdrogueria.equals(other.nitdrogueria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Drogueria[ nitdrogueria=" + nitdrogueria + " ]";
    }

}
