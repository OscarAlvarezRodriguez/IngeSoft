package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @Column(length = 12)
    private String cedulaCliente;
    @Column(nullable = false, length = 2)
    private String nombreCliente;
    @Column(nullable = false, length = 25)
    private String telefonoCliente;
    @Column(nullable = false, length = 15)
    private String direccionCliente;
    @Column(nullable = false, length = 32)
    private String descripcionDireccionCliente;
    @Column(nullable = false, length = 50)
    private String apellidoCliente;

    public Cliente() {
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDescripcionDireccionCliente() {
        return descripcionDireccionCliente;
    }

    public void setDescripcionDireccionCliente(String descripcionDireccionCliente) {
        this.descripcionDireccionCliente = descripcionDireccionCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

}
