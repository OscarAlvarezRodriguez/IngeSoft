package Entidad;

public class Compra {

    private long idCompra;
    private String nombreProvedorCompra;
    private String precioTotalCompra;

    public Compra() {
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra() {
    }

    public String getNombreProvedorCompra() {
        return nombreProvedorCompra;
    }

    public void setNombreProvedorCompra(String nombreProvedorCompra) {
        this.nombreProvedorCompra = nombreProvedorCompra;
    }

    public String getPrecioTotalCompra() {
        return precioTotalCompra;
    }

    public void setPrecioTotalCompra(String precioTotalCompra) {
        this.precioTotalCompra = precioTotalCompra;
    }

}
