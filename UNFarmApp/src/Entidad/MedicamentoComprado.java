package Entidad;

public class MedicamentoComprado extends Medicamento {

    private int cantidadCompradaMedicamento;
    private int precioUnitarioMedicamento;
    private int idCompraMedicamento;

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
