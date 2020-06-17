package Control;

import DAO.CompraDAO;
import DAO.MedicamentoDAO;
import Entidad.Compra;
import Entidad.Compramedicamento;
import Entidad.Medicamento;
import java.util.ArrayList;
import java.util.List;

public class ComprarMedicamento {

    private final MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    private final CompraDAO aO = new CompraDAO();
    private final String vp = "Longitud nombre proveedor incorrecta";
    private final String ci = "Cantidad no permitida";
    private final String pn = "Precio no válido";
    private final String ce = "La cantidad excede la capacidad del inventario actual";
    private final String cr = "Compra registrada exitosamente";
    private final String co = "Correcto";
    
    public ComprarMedicamento(){
    }
    //para la validación de la compra se llama la función validar datos, la cual se encargará de mirar si el precio y la cantidad son correctas
    //verifica la longitud del nombre, el precio total y si la cantidad comprada + cantidad previa en stock no exceda las 2000 unidades
    //en la linea 49 de código de experimenta una función que evita crear una consulta en la clase dao, en caso de no funcionar, eliminar esta función
    public String validarDatos(Compra compra){
        if(!validarProveedor(compra.getNombreproveedor())){
            return(vp);
        }
        if(!validarPreciototal(compra.getPreciototal()).equals(co)){
            return(pn);
        }
        // aquí se recorre la lista de medicamentos comprados y verifica uno por uno la cantidad
        for(int i=0; i<compra.getCompramedicamentoList().size(); i++){
            String val = validarCantidad(compra.getCompramedicamentoList().get(i));
            if(!val.equals(co)){
                return(val);
            }
        }
        return(cr);
    }
    

    public String validarCantidad(Compramedicamento compra){
        if(compra.getCantidad() > 2000 || compra.getCantidad() <=0){
            return(ci);
        }
        else if(compra.getMedicamento().getStock()+compra.getCantidad() > 2000){ //verificar si compra.getMedicamento().getStock() es una operación válida
            return(ce);
        }
        return(co);
    }
    
    public String validarPreciototal(long preciototal){
        if (preciototal > 10000000 || preciototal < 100){
            return(pn);
        }
        return(co);
    }
    
    public boolean validarProveedor(String nombre) {
        if (nombre.length() > 4 && nombre.length() < 33 && !nombre.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Medicamento> obtenerTodosMedicamentos() {
        List<Medicamento> medicamentos = medicamentoDao.leertodo();
        return medicamentos;
    }

    public List<Medicamento> filtrarMedicamentos(Medicamento medicamento) {
        List<Medicamento> medicamentos = medicamentoDao.leertodo(medicamento);
        return medicamentos;
    }

    public boolean comprar(ArrayList<Short> cantidad, ArrayList<Short> idMedicamento) {
        boolean isCompra = false;
        try {
            for (int i = 0; i < cantidad.size(); i++) {
                Medicamento medicamentoAntiguo = medicamentoDao.leer(idMedicamento.get(i));
                Medicamento medicamentoNuevo = medicamentoAntiguo;
                int suma = cantidad.get(i) + medicamentoAntiguo.getStock();
                medicamentoNuevo.setStock(Short.parseShort(String.valueOf(suma)));
                isCompra = medicamentoDao.actualizar(medicamentoAntiguo, medicamentoNuevo);
            }
        } catch (NumberFormatException e) {
        }
        return isCompra;
    }

    public int registroCompra(Compra c) {
        int ID = aO.crear(c);
        return ID;
    }

    public void registroCompraMed(Compramedicamento c) {
        aO.crearCompra(c);
    }
}
