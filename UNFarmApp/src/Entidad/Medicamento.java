package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medicamento")
public class Medicamento implements Serializable {

    @Id
    private short idMedicamento;
    /*@Column(nullable = false)
    private short cantidad; */
    @Column(nullable = false, length = 300)
    private String nombreMedicamento;
    @Column(nullable = false, length = 300)
    private int precioVenta;
    @Column(nullable = false, length = 300)
    private String titular;
    @Column(nullable = false, length = 300)
    private String Descripcion;
    @Column(nullable = false, length = 300)
    private String presentacion;
    @Column(nullable = false, length = 300)
    private String principioActivo;
    @Column(nullable = false)
    private short stock;

    public Medicamento() {
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    /*public int getCantidadMedicamento() {
        return cantidad;
    }

    public void setCantidadMedicamento(short cantidadMedicamento) {
        this.cantidad = cantidadMedicamento;
    }*/

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public int getPrecioVentaMedicamento() {
        return precioVenta;
    }

    public void setPrecioVentaMedicamento(int precioVentaMedicamento) {
        this.precioVenta = precioVentaMedicamento;
    }

    public String getTitularMedicamento() {
        return titular;
    }

    public String getDescripcionMedicamento() {
        return Descripcion;
    }

    public String getPresentacionMedicamento() {
        return presentacion;
    }

    public String getPrincipioActivoMedicamento() {
        return principioActivo;
    }

    public short getStockMedicamento() {
        return stock;
    }

    public void setStockMedicamento(short stockMedicamento) {
        this.stock = stockMedicamento;
    }

}
