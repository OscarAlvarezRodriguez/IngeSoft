package Entidad;

public class Medicamento {

    private int idMedicamento;
    private int cantidadMedicamento;
    private String nombreMedicamento;
    private int precioVentaMedicamento;
    private String titularMedicamento;
    private String DescripcionMedicamento;

    private String presentacionMedicamento;

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
