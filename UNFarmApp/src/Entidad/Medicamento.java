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
    private int idMedicamento;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false, length = 300)
    private String nombreMedicamento;
    @Column(nullable = false, length = 300)
    private String precioVenta;
    @Column(nullable = false, length = 300)
    private String titular;
    @Column(nullable = false, length = 300)
    private String Descripcion;
    @Column(nullable = false, length = 300)
    private String presentacion;
    @Column(nullable = false, length = 300)
    private String principioActivo;
    @Column(nullable = false)
    private int stock;

    public Medicamento() {
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento() {
    }

    public int getCantidadMedicamento() {
        return cantidad;
    }

    public void setCantidadMedicamento(int cantidadMedicamento) {
        this.cantidad = cantidadMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getPrecioVentaMedicamento() {
        return precioVenta;
    }

    public void setPrecioVentaMedicamento(String precioVentaMedicamento) {
        this.precioVenta = precioVentaMedicamento;
    }

    public String getTitularMedicamento() {
        return titular;
    }

    public void setTitularMedicamento(String titularMedicamento) {
        this.titular = titularMedicamento;
    }

    public String getDescripcionMedicamento() {
        return Descripcion;
    }

    public void setDescripcionMedicamento(String DescripcionMedicamento) {
        this.Descripcion = DescripcionMedicamento;
    }

    public String getPresentacionMedicamento() {
        return presentacion;
    }

    public void setPresentacionMedicamento(String presentacionMedicamento) {
        this.presentacion = presentacionMedicamento;
    }

    public String getPrincipioActivoMedicamento() {
        return principioActivo;
    }

    public void setPrincipioActivoMedicamento(String principioActivoMedicamento) {
        this.principioActivo = principioActivoMedicamento;
    }

    public int getStockMedicamento() {
        return stock;
    }

    public void setStockMedicamento(int stockMedicamento) {
        this.stock = stockMedicamento;
    }

}
