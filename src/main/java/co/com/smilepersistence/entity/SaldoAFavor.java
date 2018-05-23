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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FABIO
 */
@Entity
@Table(name = "saldo_a_favor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaldoAFavor.findAll", query = "SELECT s FROM SaldoAFavor s"),
    @NamedQuery(name = "SaldoAFavor.findByIdsaldoAFavor", query = "SELECT s FROM SaldoAFavor s WHERE s.idsaldoAFavor = :idsaldoAFavor"),
    @NamedQuery(name = "SaldoAFavor.findByFechaActual", query = "SELECT s FROM SaldoAFavor s WHERE s.fechaActual = :fechaActual"),
    @NamedQuery(name = "SaldoAFavor.findByHoraActual", query = "SELECT s FROM SaldoAFavor s WHERE s.horaActual = :horaActual"),
    @NamedQuery(name = "SaldoAFavor.findBySaldo", query = "SELECT s FROM SaldoAFavor s WHERE s.saldo = :saldo")})
public class SaldoAFavor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsaldo_a_favor")
    private Long idsaldoAFavor;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    @Size(max = 8)
    @Column(name = "hora_actual")
    private String horaActual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private BigDecimal saldo;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne(optional = false)
    private Documento iddocumento;

    public SaldoAFavor() {
    }

    public SaldoAFavor(Long idsaldoAFavor) {
        this.idsaldoAFavor = idsaldoAFavor;
    }

    public Long getIdsaldoAFavor() {
        return idsaldoAFavor;
    }

    public void setIdsaldoAFavor(Long idsaldoAFavor) {
        this.idsaldoAFavor = idsaldoAFavor;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getHoraActual() {
        return horaActual;
    }

    public void setHoraActual(String horaActual) {
        this.horaActual = horaActual;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Documento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Documento iddocumento) {
        this.iddocumento = iddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsaldoAFavor != null ? idsaldoAFavor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaldoAFavor)) {
            return false;
        }
        SaldoAFavor other = (SaldoAFavor) object;
        if ((this.idsaldoAFavor == null && other.idsaldoAFavor != null) || (this.idsaldoAFavor != null && !this.idsaldoAFavor.equals(other.idsaldoAFavor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.SaldoAFavor[ idsaldoAFavor=" + idsaldoAFavor + " ]";
    }
    
}
