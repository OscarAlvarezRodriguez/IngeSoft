package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Factura")
public class Factura implements Serializable {

    @Id
    private int idFactura;
    @Column(nullable = false)
    private long precioTotalFactura;

    public Factura() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura() {
    }

    public long getPrecioTotalFactura() {
        return precioTotalFactura;
    }

    public void setPrecioTotalFactura(long precioTotalFactura) {
        this.precioTotalFactura = precioTotalFactura;
    }

}
