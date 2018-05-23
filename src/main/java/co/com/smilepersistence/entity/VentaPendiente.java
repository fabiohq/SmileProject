package co.com.smilepersistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FABIO
 */
@Entity
@Table(name = "venta_pendiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaPendiente.findAll", query = "SELECT v FROM VentaPendiente v"),
    @NamedQuery(name = "VentaPendiente.findByIdventaPendiente", query = "SELECT v FROM VentaPendiente v WHERE v.idventaPendiente = :idventaPendiente"),
    @NamedQuery(name = "VentaPendiente.findByReferenciaVenta", query = "SELECT v FROM VentaPendiente v WHERE v.referenciaVenta = :referenciaVenta"),
    @NamedQuery(name = "VentaPendiente.findByFechaActual", query = "SELECT v FROM VentaPendiente v WHERE v.fechaActual = :fechaActual"),
    @NamedQuery(name = "VentaPendiente.findByHoraActual", query = "SELECT v FROM VentaPendiente v WHERE v.horaActual = :horaActual"),
    @NamedQuery(name = "VentaPendiente.findByTotalDescCampania", query = "SELECT v FROM VentaPendiente v WHERE v.totalDescCampania = :totalDescCampania"),
    @NamedQuery(name = "VentaPendiente.findByTotalDescPreferenc", query = "SELECT v FROM VentaPendiente v WHERE v.totalDescPreferenc = :totalDescPreferenc"),
    @NamedQuery(name = "VentaPendiente.findByDescALaVenta", query = "SELECT v FROM VentaPendiente v WHERE v.descALaVenta = :descALaVenta"),
    @NamedQuery(name = "VentaPendiente.findByTotalVenta", query = "SELECT v FROM VentaPendiente v WHERE v.totalVenta = :totalVenta"),
    @NamedQuery(name = "VentaPendiente.findByObservacion", query = "SELECT v FROM VentaPendiente v WHERE v.observacion = :observacion")})
public class VentaPendiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idventa_pendiente")
    private Long idventaPendiente;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idventaPendiente")
    private List<Abono> abonoList;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne
    private Documento iddocumento;
    @JoinColumn(name = "idestado_venta", referencedColumnName = "idestado_venta")
    @ManyToOne(optional = false)
    private EstadoVenta idestadoVenta;

    public VentaPendiente() {
    }

    public VentaPendiente(Long idventaPendiente) {
        this.idventaPendiente = idventaPendiente;
    }

    public Long getIdventaPendiente() {
        return idventaPendiente;
    }

    public void setIdventaPendiente(Long idventaPendiente) {
        this.idventaPendiente = idventaPendiente;
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

    @XmlTransient
    public List<Abono> getAbonoList() {
        return abonoList;
    }

    public void setAbonoList(List<Abono> abonoList) {
        this.abonoList = abonoList;
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

    public EstadoVenta getIdestadoVenta() {
        return idestadoVenta;
    }

    public void setIdestadoVenta(EstadoVenta idestadoVenta) {
        this.idestadoVenta = idestadoVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventaPendiente != null ? idventaPendiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaPendiente)) {
            return false;
        }
        VentaPendiente other = (VentaPendiente) object;
        if ((this.idventaPendiente == null && other.idventaPendiente != null) || (this.idventaPendiente != null && !this.idventaPendiente.equals(other.idventaPendiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.VentaPendiente[ idventaPendiente=" + idventaPendiente + " ]";
    }
    
}
