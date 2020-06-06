/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.MedicamentoDAO;
import Entidad.Medicamento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ComprarMedicamento {
    
    MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    MedicamentoDAO.CombinacionMed combinacionMed =  new MedicamentoDAO.CombinacionMed();
    
    public List<String[]> obtenerMedicamentos(){
        List<MedicamentoDAO.CombinacionMed> medicamentos = combinacionMed.selectAll();
        List<String[]> listado = new ArrayList<String[]>(); 
        for (int i = 0; i < medicamentos.size(); i++) {
            String[] datos = new String[6];
            datos[0] = medicamentos.get(i).getNombreMedicamento();
            datos[1] = medicamentos.get(i).getTitular();
            datos[2] = medicamentos.get(i).getDescripcion();
            datos[3] = medicamentos.get(i).getPrincipioActivo();
            datos[4] = medicamentos.get(i).getPresentacion();
            datos[5] = Short.toString(medicamentos.get(i).getStock());
            listado.set(i, datos);
        }return listado;
    }
    
    public List<MedicamentoDAO.CombinacionMed> obtenerTodosMedicamentos(){
        List<MedicamentoDAO.CombinacionMed> medicamentos = combinacionMed.selectAll();
        return medicamentos;
    }
    
    public List<MedicamentoDAO.CombinacionMed> filtrarMedicamentos(MedicamentoDAO.CombinacionMed medicamento){
         List<MedicamentoDAO.CombinacionMed> medicamentos = combinacionMed.selectAll(medicamento);
         return medicamentos;
    }    
    
    public boolean comprar(short cantidad, int idMedicamento){
        Medicamento medicamentoAntiguo = medicamentoDao.leer(idMedicamento);
        Medicamento medicamentoNuevo = medicamentoAntiguo;
        medicamentoNuevo.setStockMedicamento(cantidad);
        return medicamentoDao.actualizar(medicamentoAntiguo, medicamentoNuevo);
    }
    
}
