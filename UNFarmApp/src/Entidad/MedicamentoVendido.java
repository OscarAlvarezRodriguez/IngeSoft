package Entidad;

public class MedicamentoVendido extends Medicamento {

    private int cantidadVendidaMedicamento;
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
