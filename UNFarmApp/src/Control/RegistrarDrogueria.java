package Control;
import Entidad.Drogueria;
/**
 *
 * @author Juan Montoya
 */
public class RegistrarDrogueria {
    public RegistrarDrogueria(){
    }
    public String ValidarDatos(Drogueria drogapp){
        if(!validarNit(drogapp.getNitDrogueria())){
            return("Nit no válido");
        }
        if(!validarNombre_drogueria(drogapp.getNombreDrogueria())){
            return("Longitud nombre incorrecta");
        }
        if(!validarDireccion(drogapp.getDireccionDrogueria())){
            return("Longitud dirección incorrecta");
        }
        if(!validarTelefono_drogueria(drogapp.getTelefonoDrogueria())){
            return("Telefono no válido");
        }
        if(!validarEmail(drogapp.getEmailDrogueria())){
            return("Email no válido");
        }
        if(!validarRepresentante(drogapp.getRepresentanteLegalDrogueria())){
            return("Longitud representante legal incorrecta");
        }
        return("Registro exitoso");
    }
    private boolean validarNit(String nit){
        return(nit.length()>10 && nit.length()<21);
    }
    private boolean validarNombre_drogueria(String nombred){
        return(nombred.length()>11 && nombred.length()<33);
    }
    private boolean validarDireccion(String direccion){
        return(direccion.length()>11 && direccion.length()<33);
    }
    private boolean validarTelefono_drogueria(String teldro){
        return(teldro.length()>5 && teldro.length()<12);
    }
    private boolean validarEmail(String email){
        return(email.length()>8 && email.length()<26 && email.matches(".+@.+"));
    }
    private boolean validarRepresentante(String representante){
        return(representante.length()>10 && representante.length()<33);
    }
}
