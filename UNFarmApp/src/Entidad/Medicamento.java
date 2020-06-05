package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Medicamento")
public class Medicamento implements Serializable {

    @Id
    private short idMedicamento;
    @Column(nullable = false, length = 300)
    private int precioVenta;
    @Column(nullable = false)
    private short stock;
    @OneToOne
    private MedicamentoInvima medinv;
    /*@Column(nullable = false, length = 300)
    private String nombreMedicamento;
 
    @Column(nullable = false, length = 300)
    private String titular;
    @Column(nullable = false, length = 300)
    private String Descripcion;
    @Column(nullable = false, length = 300)
    private String presentacion;
    @Column(nullable = false, length = 300)
    private String principioActivo;
    @Column(nullable = false)
    private short stock;*/

    public Medicamento() {
    }

    public short getIdMedicamento() {
        return idMedicamento;
    }
    
    public int getPrecioVentaMedicamento() {
        return precioVenta;
    }
    
    public short getStockMedicamento() {
        return stock;
    }
    
    public MedicamentoInvima getMedinv() {
        return medinv;
    }
    
    public void setPrecioVentaMedicamento(int precioVentaMedicamento) {
        this.precioVenta = precioVentaMedicamento;
    }

    public void setMedinv(MedicamentoInvima medinv) {
        this.medinv = medinv;
    }
    
    public void setStockMedicamento(short stockMedicamento) {
        this.stock = stockMedicamento;
    }
    
    /*public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    

    

    public String getTitularMedicamento() {
        return titular;
    }

    public String getDescripcionMedicamento() {
        return Descripcion;
    }

    public String getPresentacionMedicamento() {
        return presentacion;
    }

    public String getPrincipioActivoMedicamento() {
        return principioActivo;
    }

    

    */

}
