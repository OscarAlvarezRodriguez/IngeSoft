package Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompramedicamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDMEDICAMENTO")
    private short idmedicamento;
    @Basic(optional = false)
    @Column(name = "IDCOMPRA")
    private int idcompra;

    public CompramedicamentoPK() {
    }

    public CompramedicamentoPK(short idmedicamento, int idcompra) {
        this.idmedicamento = idmedicamento;
        this.idcompra = idcompra;
    }

    public short getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(short idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmedicamento;
        hash += (int) idcompra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompramedicamentoPK)) {
            return false;
        }
        CompramedicamentoPK other = (CompramedicamentoPK) object;
        if (this.idmedicamento != other.idmedicamento) {
            return false;
        }
        if (this.idcompra != other.idcompra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.CompramedicamentoPK[ idmedicamento=" + idmedicamento + ", idcompra=" + idcompra + " ]";
    }

}
