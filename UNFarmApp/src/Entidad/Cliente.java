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
    @Column(length = 11)
    private String cedulaCliente;
    @Column(nullable = false, length = 20)
    private String nombre;
    @Column(nullable = false, length = 15)
    private String telefono;
    @Column(nullable = false, length = 32)
    private String direccionCliente;
    @Column(nullable = false, length = 32)
    private String descripcionDireccion;
    @Column(nullable = false, length = 20)
    private String apellido;
    @Column(nullable = false)
    private boolean eliminado=false; // por defecto cada cliente registrado automáticamente está en estado activo 
    //recordar que false= cliente activo y true= cliente inactivo

    public Cliente() {
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombre;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombre = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefono;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefono = telefonoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDescripcionDireccionCliente() {
        return descripcionDireccion;
    }

    public void setDescripcionDireccionCliente(String descripcionDireccionCliente) {
        this.descripcionDireccion = descripcionDireccionCliente;
    }

    public String getApellidoCliente() {
        return apellido;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellido = apellidoCliente;
    }
    
    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

}
