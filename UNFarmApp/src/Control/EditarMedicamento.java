package Control;
import Entidad.Medicamento;
import DAO.MedicamentoDAO;

public class EditarMedicamento {
    private final MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
    private final String pi = "Precio de venta fuera de rango";
    private final String se = "Cantidad no válida";
    private final String co = "correcto";
    private final String ae = "Medicamento actualizado exitosamente";
    private final String ai = "Actualización medicamento incorrecta";
    
    public EditarMedicamento(){
    }
    
    public String validarDatos(Medicamento droga, Medicamento nuevadroga){
        if(!validarPrecioventa(nuevadroga.getPrecioventa()).equals(co)){
            return(pi);
        }
        if(!validarStock(nuevadroga.getStock()).equals(co)){
            return(se);
        }
        if(medicamentoDAO.actualizar(droga, nuevadroga)){
            return(ae);
        }
        return(ai);
    }
    
    public String validarPrecioventa(int precioventa){
        if(precioventa>=100 && precioventa <10000000 ){
            return(co);
        }
        return(pi);
    }
    
    public String validarStock(short stock){
        if(stock>=0 && stock<=2000){
            return(co);
        }
        return(se);
    }
}
