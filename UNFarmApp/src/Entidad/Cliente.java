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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCedulacliente", query = "SELECT c FROM Cliente c WHERE c.cedulacliente = :cedulacliente")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cliente.findByDireccioncliente", query = "SELECT c FROM Cliente c WHERE c.direccioncliente = :direccioncliente")
    , @NamedQuery(name = "Cliente.findByDescripciondireccion", query = "SELECT c FROM Cliente c WHERE c.descripciondireccion = :descripciondireccion")
    , @NamedQuery(name = "Cliente.findByEliminado", query = "SELECT c FROM Cliente c WHERE c.eliminado = :eliminado")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULACLIENTE")
    private String cedulacliente;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "DIRECCIONCLIENTE")
    private String direccioncliente;
    @Column(name = "DESCRIPCIONDIRECCION")
    private String descripciondireccion;
    @Basic(optional = false)
    @Column(name = "ELIMINADO")
    private boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulacliente")
    private List<Factura> facturaList;

    public Cliente() {
    }

    public Cliente(String cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public Cliente(String cedulacliente, String nombre, String apellido, String telefono, String direccioncliente, String descripciondireccion, boolean eliminado) {
        this.cedulacliente = cedulacliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccioncliente = direccioncliente;
        this.descripciondireccion = descripciondireccion;
        this.eliminado = eliminado;
    }

    public String getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(String cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }

    public String getDescripciondireccion() {
        return descripciondireccion;
    }

    public void setDescripciondireccion(String descripciondireccion) {
        this.descripciondireccion = descripciondireccion;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
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
        hash += (cedulacliente != null ? cedulacliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cedulacliente == null && other.cedulacliente != null) || (this.cedulacliente != null && !this.cedulacliente.equals(other.cedulacliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Cliente[ cedulacliente=" + cedulacliente + " ]";
    }

}
