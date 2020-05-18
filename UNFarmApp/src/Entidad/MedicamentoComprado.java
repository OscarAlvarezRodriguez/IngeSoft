package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MedicamentoComprado")
public class MedicamentoComprado extends Medicamento implements Serializable {

    @Column(nullable = false)
    private int idCompraMedicamento;
    @Column(nullable = false)
    private int cantidadCompradaMedicamento;
    @Column(nullable = false)
    private int precioUnitarioMedicamento;

    public MedicamentoComprado() {
    }

    public int getCantidadCompradaMedicamento() {
        return cantidadCompradaMedicamento;
    }

    public void setCantidadCompradaMedicamento(int cantidadCompradaMedicamento) {
        this.cantidadCompradaMedicamento = cantidadCompradaMedicamento;
    }

    public int getPrecioUnitarioMedicamento() {
        return precioUnitarioMedicamento;
    }

    public void setPrecioUnitarioMedicamento(int precioUnitarioMedicamento) {
        this.precioUnitarioMedicamento = precioUnitarioMedicamento;
    }

    public int getIdCompraMedicamento() {
        return idCompraMedicamento;
    }

    public void setIdCompraMedicamento(int idCompraMedicamento) {
        this.idCompraMedicamento = idCompraMedicamento;
    }

}
