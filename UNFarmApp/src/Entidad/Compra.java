package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Compra")
public class Compra implements Serializable {

    @Id
    @Column(nullable = false)
    private int idCompra;
    @Column(nullable = false, length = 32)
    private String nombreProveedor;
    @Column(nullable = false)
    private long precioTotal;

    public Compra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra() {
    }

    public String getNombreProvedorCompra() {
        return nombreProveedor;
    }

    public void setNombreProvedorCompra(String nombreProvedorCompra) {
        this.nombreProveedor = nombreProvedorCompra;
    }

    public long getPrecioTotalCompra() {
        return precioTotal;
    }

    public void setPrecioTotalCompra(long precioTotalCompra) {
        this.precioTotal = precioTotalCompra;
    }

}
