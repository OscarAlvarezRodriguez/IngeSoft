package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MedicamentoVendido")
public class MedicamentoVendido extends Medicamento implements Serializable {

    @Column(nullable = false)
    private int cantidadVendidaMedicamento;
    @Column(nullable = false)
    private int idFacturaMedicamento;

    public MedicamentoVendido() {
    }

    public int getCantidadVendidaMedicamento() {
        return cantidadVendidaMedicamento;
    }

    public void setCantidadVendidaMedicamento(int cantidadVendidaMedicamento) {
        this.cantidadVendidaMedicamento = cantidadVendidaMedicamento;
    }

    public int getIdFacturaMedicamento() {
        return idFacturaMedicamento;
    }

    public void setIdFacturaMedicamento(int idFacturaMedicamento) {
        this.idFacturaMedicamento = idFacturaMedicamento;
    }

}
