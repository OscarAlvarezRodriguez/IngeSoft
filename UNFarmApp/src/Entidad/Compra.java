package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Compra")
public class Compra implements Serializable{

    @Id
    @Column(length = 2)
    private long idCompra;
    @Column(nullable = false, length = 50)
    private String nombreProvedorCompra;
    @Column(nullable = false, length = 20)
    private String precioTotalCompra;

    public Compra() {
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra() {
    }

    public String getNombreProvedorCompra() {
        return nombreProvedorCompra;
    }

    public void setNombreProvedorCompra(String nombreProvedorCompra) {
        this.nombreProvedorCompra = nombreProvedorCompra;
    }

    public String getPrecioTotalCompra() {
        return precioTotalCompra;
    }

    public void setPrecioTotalCompra(String precioTotalCompra) {
        this.precioTotalCompra = precioTotalCompra;
    }

}
