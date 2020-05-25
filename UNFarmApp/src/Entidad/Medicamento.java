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
    @Column(nullable = false, length = 300)
    private String nombreMedicamento;
    @Column(nullable = false)
    private int precioVentaMedicamento;
    @Column(nullable = false, length = 200)
    private String titularMedicamento;
    @Column(nullable = false, length = 200)
    private String DescripcionMedicamento;
    @Column(nullable = false, length = 150)
    private String presentacionMedicamento;
    @Column(nullable = false, length = 300)
    private String principioActivoMedicamento;

    public Medicamento() {
    }

    public int getIdMedicamento() {
        return idMedicamento;
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

    public int getPrecioVentaMedicamento() {
        return precioVentaMedicamento;
    }

    public void setPrecioVentaMedicamento(int precioVentaMedicamento) {
        this.precioVentaMedicamento = precioVentaMedicamento;
    }

    public String getTitularMedicamento() {
        return titularMedicamento;
    }

    public String getDescripcionMedicamento() {
        return DescripcionMedicamento;
    }

    public String getPresentacionMedicamento() {
        return presentacionMedicamento;
    }

    public String getPrincipioActivoMedicamento() {
        return principioActivoMedicamento;
    }
}
