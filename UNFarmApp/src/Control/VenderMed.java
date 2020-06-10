package Control;

import DAO.MedicamentoDAO;
import DAO.VenderDAO;
import Entidad.Factura;
import Entidad.Facturamedicamentos;
import Entidad.Medicamento;
import java.util.ArrayList;
import java.util.List;

public class VenderMed {

    private MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    private VenderDAO aO = new VenderDAO();
    private final String ci = "Cantidad del medicamento no permitida";
    private final String si = "La compra excede el límite del precio";
    private final String co = "Correcto";
    private final String fg = "Factura Generada Exitosamente";

    public VenderMed(){
    }
    
    public String validarDatos(Factura venta){
        for(int i=0; i<venta.getFacturamedicamentosList().size(); i++){
            if(!validarCantidad(venta.getFacturamedicamentosList().get(i).getCantidadvendida()).equals(co)){
                return(ci);
            }
        }
        if(!validarPrecio(venta.getPreciototal()).equals(co)){
            return(si);
        }
        int id = aO.crear(venta);
        if(id < 0){
            return("Error generación de ID");
        }
        return(fg);
    }
    
    public String validarCantidad(short cantidad){
        if (cantidad <= 2000){
            return (co);
        }
        return(ci);
    }
    
    public String validarPrecio(long precio){
        if (precio < 10000000){
            return (co);
        }
        return(si);
    }

    public List<Medicamento> obtenerTodosMedicamentos() {
        List<Medicamento> medicamentos = medicamentoDao.leertodo();
        return medicamentos;
    }

    public List<Medicamento> filtrarMedicamentos(Medicamento medicamento) {
        List<Medicamento> medicamentos = medicamentoDao.leertodo(medicamento);
        return medicamentos;
    }

    public boolean vender(ArrayList<Short> cantidad, ArrayList<Short> idMedicamento) {
        boolean isCompra = false;
        try {
            for (int i = 0; i < cantidad.size(); i++) {
                Medicamento medicamentoAntiguo = medicamentoDao.leer(idMedicamento.get(i));
                Medicamento medicamentoNuevo = medicamentoAntiguo;
                int suma = medicamentoAntiguo.getStock() - cantidad.get(i) ;
                medicamentoNuevo.setStock(Short.parseShort(String.valueOf(suma)));
                isCompra = medicamentoDao.actualizar(medicamentoAntiguo, medicamentoNuevo);
            }
        } catch (NumberFormatException e) {
        }
        return isCompra;
    }

    public int registrarFactura(Factura c) {
        int ID = aO.crear(c);
        return ID;
    }

    public void RegistrarFacturaMed(Facturamedicamentos c) {
        
        aO.crearFactura(c);
    }
}
