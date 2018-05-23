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
@Table(name = "detalle_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d"),
    @NamedQuery(name = "DetalleVenta.findByIddetalleVenta", query = "SELECT d FROM DetalleVenta d WHERE d.iddetalleVenta = :iddetalleVenta"),
    @NamedQuery(name = "DetalleVenta.findByReferenciaVenta", query = "SELECT d FROM DetalleVenta d WHERE d.referenciaVenta = :referenciaVenta"),
    @NamedQuery(name = "DetalleVenta.findByFechaActual", query = "SELECT d FROM DetalleVenta d WHERE d.fechaActual = :fechaActual"),
    @NamedQuery(name = "DetalleVenta.findByHoraActual", query = "SELECT d FROM DetalleVenta d WHERE d.horaActual = :horaActual"),
    @NamedQuery(name = "DetalleVenta.findByValorProducto", query = "SELECT d FROM DetalleVenta d WHERE d.valorProducto = :valorProducto"),
    @NamedQuery(name = "DetalleVenta.findByDescuentoPreferencial", query = "SELECT d FROM DetalleVenta d WHERE d.descuentoPreferencial = :descuentoPreferencial"),
    @NamedQuery(name = "DetalleVenta.findByObservacion", query = "SELECT d FROM DetalleVenta d WHERE d.observacion = :observacion")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalle_venta")
    private Long iddetalleVenta;
    @Column(name = "referencia_venta")
    private Long referenciaVenta;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    @Size(max = 8)
    @Column(name = "hora_actual")
    private String horaActual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_producto")
    private BigDecimal valorProducto;
    @Column(name = "descuento_preferencial")
    private BigDecimal descuentoPreferencial;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;
    @JoinColumn(name = "idcampanias_promocionales", referencedColumnName = "idcampanias_promocionales")
    @ManyToOne
    private CampaniasPromocionales idcampaniasPromocionales;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne
    private Documento iddocumento;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;

    public DetalleVenta() {
    }

    public DetalleVenta(Long iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
    }

    public Long getIddetalleVenta() {
        return iddetalleVenta;
    }

    public void setIddetalleVenta(Long iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
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

    public BigDecimal getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(BigDecimal valorProducto) {
        this.valorProducto = valorProducto;
    }

    public BigDecimal getDescuentoPreferencial() {
        return descuentoPreferencial;
    }

    public void setDescuentoPreferencial(BigDecimal descuentoPreferencial) {
        this.descuentoPreferencial = descuentoPreferencial;
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

    public CampaniasPromocionales getIdcampaniasPromocionales() {
        return idcampaniasPromocionales;
    }

    public void setIdcampaniasPromocionales(CampaniasPromocionales idcampaniasPromocionales) {
        this.idcampaniasPromocionales = idcampaniasPromocionales;
    }

    public Documento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Documento iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleVenta != null ? iddetalleVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.iddetalleVenta == null && other.iddetalleVenta != null) || (this.iddetalleVenta != null && !this.iddetalleVenta.equals(other.iddetalleVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.DetalleVenta[ iddetalleVenta=" + iddetalleVenta + " ]";
    }
    
}