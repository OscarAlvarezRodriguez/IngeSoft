package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Domicilio")
public class Domicilio implements Serializable{

    @Id
    private int idDomicilio;
    @Column(nullable = false)
    private String estadoDomicilio;

    public Domicilio() {
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    private void setIdDomicilio() {
    }

    public String getEstadoDomicilio() {
        return estadoDomicilio;
    }

    public void setEstadoDomicilio(String estadoDomicilio) {
        this.estadoDomicilio = estadoDomicilio;
    }

}
