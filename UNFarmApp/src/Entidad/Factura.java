package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Factura")
public class Factura implements Serializable {

    @Id
    private int idFactura;
    @Column(nullable = false)
    private long precioTotal;
    @Temporal(TemporalType.DATE)
    private Date fecha;


    public Factura() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura() {
    }

    public long getPrecioTotalFactura() {
        return precioTotal;
    }

    public void setPrecioTotalFactura(long precioTotalFactura) {
        this.precioTotal = precioTotalFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
