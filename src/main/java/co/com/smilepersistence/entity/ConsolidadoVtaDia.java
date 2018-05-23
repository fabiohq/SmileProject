package co.com.smilepersistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FABIO
 */
@Entity
@Table(name = "consolidado_vta_dia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsolidadoVtaDia.findAll", query = "SELECT c FROM ConsolidadoVtaDia c"),
    @NamedQuery(name = "ConsolidadoVtaDia.findByIdconsolidadoVtaDia", query = "SELECT c FROM ConsolidadoVtaDia c WHERE c.idconsolidadoVtaDia = :idconsolidadoVtaDia"),
    @NamedQuery(name = "ConsolidadoVtaDia.findByFechaActual", query = "SELECT c FROM ConsolidadoVtaDia c WHERE c.fechaActual = :fechaActual"),
    @NamedQuery(name = "ConsolidadoVtaDia.findByValor", query = "SELECT c FROM ConsolidadoVtaDia c WHERE c.valor = :valor")})
public class ConsolidadoVtaDia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idconsolidado_vta_dia")
    private Long idconsolidadoVtaDia;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;

    public ConsolidadoVtaDia() {
    }

    public ConsolidadoVtaDia(Long idconsolidadoVtaDia) {
        this.idconsolidadoVtaDia = idconsolidadoVtaDia;
    }

    public Long getIdconsolidadoVtaDia() {
        return idconsolidadoVtaDia;
    }

    public void setIdconsolidadoVtaDia(Long idconsolidadoVtaDia) {
        this.idconsolidadoVtaDia = idconsolidadoVtaDia;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ActorSistema getIdactorSistema() {
        return idactorSistema;
    }

    public void setIdactorSistema(ActorSistema idactorSistema) {
        this.idactorSistema = idactorSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsolidadoVtaDia != null ? idconsolidadoVtaDia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsolidadoVtaDia)) {
            return false;
        }
        ConsolidadoVtaDia other = (ConsolidadoVtaDia) object;
        if ((this.idconsolidadoVtaDia == null && other.idconsolidadoVtaDia != null) || (this.idconsolidadoVtaDia != null && !this.idconsolidadoVtaDia.equals(other.idconsolidadoVtaDia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.ConsolidadoVtaDia[ idconsolidadoVtaDia=" + idconsolidadoVtaDia + " ]";
    }
    
}