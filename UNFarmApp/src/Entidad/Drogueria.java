package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Drogueria")
public class Drogueria implements Serializable {

    @Id
    @Column(length = 20)
    private String nit_Drogueria;
    @Column(nullable = false, length = 32)
    private String nombre_Drogueria;
    @Column(nullable = false, length = 32)
    private String direccion__Drogueria;
    @Column(nullable = false, length = 15)
    private String telefono;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 32)
    private String representante_Legal;

    public Drogueria() {
    }

    public String getNitDrogueria() {
        return nit_Drogueria;
    }

    public void setNitDrogueria(String nitDrogueria) {
        this.nit_Drogueria = nitDrogueria;
    }

    public String getNombreDrogueria() {
        return nombre_Drogueria;
    }

    public void setNombreDrogueria(String nombreDrogueria) {
        this.nombre_Drogueria = nombreDrogueria;
    }

    public String getDireccionDrogueria() {
        return direccion__Drogueria;
    }

    public void setDireccionDrogueria(String direccionDrogueria) {
        this.direccion__Drogueria = direccionDrogueria;
    }

    public String getTelefonoDrogueria() {
        return telefono;
    }

    public void setTelefonoDrogueria(String telefonoDrogueria) {
        this.telefono = telefonoDrogueria;
    }

    public String getEmailDrogueria() {
        return email;
    }

    public void setEmailDrogueria(String emailDrogueria) {
        this.email = emailDrogueria;
    }

    public String getRepresentanteLegalDrogueria() {
        return representante_Legal;
    }

    public void setRepresentanteLegalDrogueria(String representanteLegalDrogueria) {
        this.representante_Legal = representanteLegalDrogueria;
    }

}
