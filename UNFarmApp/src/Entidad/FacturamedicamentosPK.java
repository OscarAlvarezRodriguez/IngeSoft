package Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacturamedicamentosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDMEDICAMENTO")
    private short idmedicamento;
    @Basic(optional = false)
    @Column(name = "IDFACTURA")
    private int idfactura;

    public FacturamedicamentosPK() {
    }

    public FacturamedicamentosPK(short idmedicamento, int idfactura) {
        this.idmedicamento = idmedicamento;
        this.idfactura = idfactura;
    }

    public short getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(short idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmedicamento;
        hash += (int) idfactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturamedicamentosPK)) {
            return false;
        }
        FacturamedicamentosPK other = (FacturamedicamentosPK) object;
        if (this.idmedicamento != other.idmedicamento) {
            return false;
        }
        if (this.idfactura != other.idfactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.FacturamedicamentosPK[ idmedicamento=" + idmedicamento + ", idfactura=" + idfactura + " ]";
    }

}
