package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

    @Id
    @Column(length = 11)
    private String cedula_Empleado;
    @Column(nullable = false, length = 25)
    private String nombre_Empleado;
    @Column(nullable = false, length = 15)
    private String telefono;
    @Column(nullable = false, length = 32)
    private String direccion_Empleado;
    @Column(nullable = false, length = 25)
    private String apellido_Empleado;
    @Column(nullable = false, length = 20)
    private String contrasenia;
    @Column(nullable = false, length = 50)
    private String correo;

    public Empleado() {
    }

    public String getCedulaEmpleado() {
        return cedula_Empleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedula_Empleado = cedulaEmpleado;
    }

    public String getNombreEmpleado() {
        return nombre_Empleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombre_Empleado = nombreEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefono;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefono = telefonoEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccion_Empleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccion_Empleado = direccionEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellido_Empleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellido_Empleado = apellidoEmpleado;
    }

    public String getContraseniaEmpleado() {
        return contrasenia;
    }

    public void setContraseniaEmpleado(String contreseniaEmpleado) {
        this.contrasenia = contreseniaEmpleado;
    }

    public String getCorreoEmpleado() {
        return correo;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correo = correoEmpleado;
    }

}
