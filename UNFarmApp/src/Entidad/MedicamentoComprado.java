package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CompraMedicamento")
public class MedicamentoComprado extends Medicamento implements Serializable {

    @Column(nullable = false)
    private int idCompra;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private int precioUnitario;

    public MedicamentoComprado() {
    }

    public int getCantidadCompradaMedicamento() {
        return cantidad;
    }

    public void setCantidadCompradaMedicamento(int cantidadCompradaMedicamento) {
        this.cantidad = cantidadCompradaMedicamento;
    }

    public int getPrecioUnitarioMedicamento() {
        return precioUnitario;
    }

    public void setPrecioUnitarioMedicamento(int precioUnitarioMedicamento) {
        this.precioUnitario = precioUnitarioMedicamento;
    }

    public int getIdCompraMedicamento() {
        return idCompra;
    }

    public void setIdCompraMedicamento(int idCompraMedicamento) {
        this.idCompra = idCompraMedicamento;
    }

}
