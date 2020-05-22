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
    private int cantidadMedicamento;
    @Column(nullable = false, length = 60)
    private String nombreMedicamento;
    @Column(nullable = false, length = 10)
    private String precioVentaMedicamento;
    @Column(nullable = false, length = 25)
    private String titularMedicamento;
    @Column(nullable = false, length = 50)
    private String DescripcionMedicamento;
    @Column(nullable = false, length = 20)
    private String presentacionMedicamento;
    @Column(nullable = false, length = 90)
    private String principioActivoMedicamento;

    public Medicamento() {
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento() {
    }

    public int getCantidadMedicamento() {
        return cantidadMedicamento;
    }

    public void setCantidadMedicamento(int cantidadMedicamento) {
        this.cantidadMedicamento = cantidadMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getPrecioVentaMedicamento() {
        return precioVentaMedicamento;
    }

    public void setPrecioVentaMedicamento(String precioVentaMedicamento) {
        this.precioVentaMedicamento = precioVentaMedicamento;
    }

    public String getTitularMedicamento() {
        return titularMedicamento;
    }

    public void setTitularMedicamento(String titularMedicamento) {
        this.titularMedicamento = titularMedicamento;
    }

    public String getDescripcionMedicamento() {
        return DescripcionMedicamento;
    }

    public void setDescripcionMedicamento(String DescripcionMedicamento) {
        this.DescripcionMedicamento = DescripcionMedicamento;
    }

    public String getPresentacionMedicamento() {
        return presentacionMedicamento;
    }

    public void setPresentacionMedicamento(String presentacionMedicamento) {
        this.presentacionMedicamento = presentacionMedicamento;
    }

    public String getPrincipioActivoMedicamento() {
        return principioActivoMedicamento;
    }

    public void setPrincipioActivoMedicamento(String principioActivoMedicamento) {
        this.principioActivoMedicamento = principioActivoMedicamento;
    }

}
