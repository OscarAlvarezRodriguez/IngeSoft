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
}
