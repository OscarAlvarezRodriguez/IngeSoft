package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FacturaMedicamentos")
public class MedicamentoVendido extends Medicamento implements Serializable {

    @Column(nullable = false)
    private short cantidadVendida;
    @Column(nullable = false)
    private int idFactura;

    public MedicamentoVendido() {
    }

    public short getCantidadVendidaMedicamento() {
        return cantidadVendida;
    }

    public void setCantidadVendidaMedicamento(short cantidadVendidaMedicamento) {
        this.cantidadVendida = cantidadVendidaMedicamento;
    }

    public int getIdFacturaMedicamento() {
        return idFactura;
    }

    public void setIdFacturaMedicamento(int idFacturaMedicamento) {
        this.idFactura = idFacturaMedicamento;
    }

}
