package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {

    private String nombreCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private String descripcionDireccionCliente;
    private String apellidoCliente;
    @Id
    private String cedulaCliente;

    public Cliente(String cedulaCliente, String nombreCliente, String telefonoCliente, String direccionCliente, String descripcionDireccionCliente, String apellidoCliente) {
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccionCliente = direccionCliente;
        this.descripcionDireccionCliente = descripcionDireccionCliente;
        this.apellidoCliente = apellidoCliente;

    }

    public Cliente() {
        this("q", "w", "e", "r", "t", "y");
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
