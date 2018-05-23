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
@Table(name = "encargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encargo.findAll", query = "SELECT e FROM Encargo e"),
    @NamedQuery(name = "Encargo.findByIdencargo", query = "SELECT e FROM Encargo e WHERE e.idencargo = :idencargo"),
    @NamedQuery(name = "Encargo.findByFechaActual", query = "SELECT e FROM Encargo e WHERE e.fechaActual = :fechaActual"),
    @NamedQuery(name = "Encargo.findByHoraActual", query = "SELECT e FROM Encargo e WHERE e.horaActual = :horaActual"),
    @NamedQuery(name = "Encargo.findByValorProducto", query = "SELECT e FROM Encargo e WHERE e.valorProducto = :valorProducto"),
    @NamedQuery(name = "Encargo.findByDescuentoPreferencial", query = "SELECT e FROM Encargo e WHERE e.descuentoPreferencial = :descuentoPreferencial"),
    @NamedQuery(name = "Encargo.findByObservacion", query = "SELECT e FROM Encargo e WHERE e.observacion = :observacion")})
public class Encargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idencargo")
    private Long idencargo;
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
    @ManyToOne(optional = false)
    private CampaniasPromocionales idcampaniasPromocionales;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne
    private Documento iddocumento;
    @JoinColumn(name = "idestado_entrega", referencedColumnName = "idestado_entrega")
    @ManyToOne(optional = false)
    private EstadoEntrega idestadoEntrega;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;

    public Encargo() {
    }

    public Encargo(Long idencargo) {
        this.idencargo = idencargo;
    }

    public Long getIdencargo() {
        return idencargo;
    }

    public void setIdencargo(Long idencargo) {
        this.idencargo = idencargo;
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

    public EstadoEntrega getIdestadoEntrega() {
        return idestadoEntrega;
    }

    public void setIdestadoEntrega(EstadoEntrega idestadoEntrega) {
        this.idestadoEntrega = idestadoEntrega;
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
        hash += (idencargo != null ? idencargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encargo)) {
            return false;
        }
        Encargo other = (Encargo) object;
        if ((this.idencargo == null && other.idencargo != null) || (this.idencargo != null && !this.idencargo.equals(other.idencargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.Encargo[ idencargo=" + idencargo + " ]";
    }
    
}