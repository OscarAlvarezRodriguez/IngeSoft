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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByCedulaempleado", query = "SELECT e FROM Empleado e WHERE e.cedulaempleado = :cedulaempleado")
    , @NamedQuery(name = "Empleado.findByNombreempleado", query = "SELECT e FROM Empleado e WHERE e.nombreempleado = :nombreempleado")
    , @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empleado.findByDireccionempleado", query = "SELECT e FROM Empleado e WHERE e.direccionempleado = :direccionempleado")
    , @NamedQuery(name = "Empleado.findByApellidoempleado", query = "SELECT e FROM Empleado e WHERE e.apellidoempleado = :apellidoempleado")
    , @NamedQuery(name = "Empleado.findByContrasenia", query = "SELECT e FROM Empleado e WHERE e.contrasenia = :contrasenia")
    , @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo")
    , @NamedQuery(name = "Empleado.findByEstado", query = "SELECT e FROM Empleado e WHERE e.estado = :estado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULAEMPLEADO")
    private String cedulaempleado;
    @Basic(optional = false)
    @Column(name = "NOMBREEMPLEADO")
    private String nombreempleado;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "DIRECCIONEMPLEADO")
    private String direccionempleado;
    @Basic(optional = false)
    @Column(name = "APELLIDOEMPLEADO")
    private String apellidoempleado;
    @Basic(optional = false)
    @Column(name = "CONTRASENIA")
    private String contrasenia;
    @Basic(optional = false)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulaempleado")
    private List<Factura> facturaList;

    public Empleado() {
    }

    public Empleado(String cedulaempleado) {
        this.cedulaempleado = cedulaempleado;
    }

    public Empleado(String cedulaempleado, String nombreempleado, String telefono, String direccionempleado, String apellidoempleado, String contrasenia, String correo, String estado) {
        this.cedulaempleado = cedulaempleado;
        this.nombreempleado = nombreempleado;
        this.telefono = telefono;
        this.direccionempleado = direccionempleado;
        this.apellidoempleado = apellidoempleado;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.estado = estado;
    }

    public String getCedulaempleado() {
        return cedulaempleado;
    }

    public void setCedulaempleado(String cedulaempleado) {
        this.cedulaempleado = cedulaempleado;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionempleado() {
        return direccionempleado;
    }

    public void setDireccionempleado(String direccionempleado) {
        this.direccionempleado = direccionempleado;
    }

    public String getApellidoempleado() {
        return apellidoempleado;
    }

    public void setApellidoempleado(String apellidoempleado) {
        this.apellidoempleado = apellidoempleado;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (cedulaempleado != null ? cedulaempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.cedulaempleado == null && other.cedulaempleado != null) || (this.cedulaempleado != null && !this.cedulaempleado.equals(other.cedulaempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Empleado[ cedulaempleado=" + cedulaempleado + " ]";
    }

}
