package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Domicilio")
public class Domicilio implements Serializable {

    @Id
    private int idDomicilio;
    @Column(nullable = false)
    private byte estado;

    public Domicilio() {
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    private void setIdDomicilio() {
    }

    public byte getEstadoDomicilio() {
        return estado;
    }

    public void setEstadoDomicilio(byte estadoDomicilio) {
        this.estado = estadoDomicilio;
    }

}
