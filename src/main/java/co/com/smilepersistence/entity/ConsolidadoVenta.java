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
@Table(name = "consolidado_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsolidadoVenta.findAll", query = "SELECT c FROM ConsolidadoVenta c"),
    @NamedQuery(name = "ConsolidadoVenta.findByIdconsolidadoVenta", query = "SELECT c FROM ConsolidadoVenta c WHERE c.idconsolidadoVenta = :idconsolidadoVenta"),
    @NamedQuery(name = "ConsolidadoVenta.findByReferenciaVenta", query = "SELECT c FROM ConsolidadoVenta c WHERE c.referenciaVenta = :referenciaVenta"),
    @NamedQuery(name = "ConsolidadoVenta.findByFechaActual", query = "SELECT c FROM ConsolidadoVenta c WHERE c.fechaActual = :fechaActual"),
    @NamedQuery(name = "ConsolidadoVenta.findByHoraActual", query = "SELECT c FROM ConsolidadoVenta c WHERE c.horaActual = :horaActual"),
    @NamedQuery(name = "ConsolidadoVenta.findByTotalDescCampania", query = "SELECT c FROM ConsolidadoVenta c WHERE c.totalDescCampania = :totalDescCampania"),
    @NamedQuery(name = "ConsolidadoVenta.findByTotalDescPreferenc", query = "SELECT c FROM ConsolidadoVenta c WHERE c.totalDescPreferenc = :totalDescPreferenc"),
    @NamedQuery(name = "ConsolidadoVenta.findByDescALaVenta", query = "SELECT c FROM ConsolidadoVenta c WHERE c.descALaVenta = :descALaVenta"),
    @NamedQuery(name = "ConsolidadoVenta.findByTotalVenta", query = "SELECT c FROM ConsolidadoVenta c WHERE c.totalVenta = :totalVenta"),
    @NamedQuery(name = "ConsolidadoVenta.findByObservacion", query = "SELECT c FROM ConsolidadoVenta c WHERE c.observacion = :observacion")})
public class ConsolidadoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idconsolidado_venta")
    private Long idconsolidadoVenta;
    @Column(name = "referencia_venta")
    private Long referenciaVenta;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    @Size(max = 8)
    @Column(name = "hora_actual")
    private String horaActual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_desc_campania")
    private BigDecimal totalDescCampania;
    @Column(name = "total_desc_preferenc")
    private BigDecimal totalDescPreferenc;
    @Column(name = "desc_a_la_venta")
    private BigDecimal descALaVenta;
    @Column(name = "total_venta")
    private BigDecimal totalVenta;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne
    private Documento iddocumento;

    public ConsolidadoVenta() {
    }

    public ConsolidadoVenta(Long idconsolidadoVenta) {
        this.idconsolidadoVenta = idconsolidadoVenta;
    }

    public Long getIdconsolidadoVenta() {
        return idconsolidadoVenta;
    }

    public void setIdconsolidadoVenta(Long idconsolidadoVenta) {
        this.idconsolidadoVenta = idconsolidadoVenta;
    }

    public Long getReferenciaVenta() {
        return referenciaVenta;
    }

    public void setReferenciaVenta(Long referenciaVenta) {
        this.referenciaVenta = referenciaVenta;
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

    public BigDecimal getTotalDescCampania() {
        return totalDescCampania;
    }

    public void setTotalDescCampania(BigDecimal totalDescCampania) {
        this.totalDescCampania = totalDescCampania;
    }

    public BigDecimal getTotalDescPreferenc() {
        return totalDescPreferenc;
    }

    public void setTotalDescPreferenc(BigDecimal totalDescPreferenc) {
        this.totalDescPreferenc = totalDescPreferenc;
    }

    public BigDecimal getDescALaVenta() {
        return descALaVenta;
    }

    public void setDescALaVenta(BigDecimal descALaVenta) {
        this.descALaVenta = descALaVenta;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ActorSistema getIdactorSistema() {
        return idactorSistema;
    }

    public void setIdactorSistema(ActorSistema idactorSistema) {
        this.idactorSistema = idactorSistema;
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
        hash += (idconsolidadoVenta != null ? idconsolidadoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsolidadoVenta)) {
            return false;
        }
        ConsolidadoVenta other = (ConsolidadoVenta) object;
        if ((this.idconsolidadoVenta == null && other.idconsolidadoVenta != null) || (this.idconsolidadoVenta != null && !this.idconsolidadoVenta.equals(other.idconsolidadoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.ConsolidadoVenta[ idconsolidadoVenta=" + idconsolidadoVenta + " ]";
    }   
}