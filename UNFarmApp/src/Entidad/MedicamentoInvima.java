package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MedicamentoInvima")

public class MedicamentoInvima {

    @Id
    private short idMedicamentoInvima;
    @Column(nullable = false, length = 300)
    private String nombreMedicamento;
    @Column(nullable = false, length = 300)
    private String titular;
    @Column(nullable = false, length = 300)
    private String Descripcion;
    @Column(nullable = false, length = 300)
    private String presentacion;
    @Column(nullable = false, length = 300)
    private String principioActivo;

    public MedicamentoInvima(String nombreMedicamento, String titular, String Descripcion, String presentacion, String principioActivo) {
       
        this.nombreMedicamento = nombreMedicamento;
        this.titular = titular;
        this.Descripcion = Descripcion;
        this.presentacion = presentacion;
        this.principioActivo = principioActivo;
    }

    public MedicamentoInvima() {
    }

    
    public short getIdMedicamentoInvima() {
        return idMedicamentoInvima;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public String getTitular() {
        return titular;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setIdMedicamentoInvima(short idMedicamentoInvima) {
        this.idMedicamentoInvima = idMedicamentoInvima;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

}
