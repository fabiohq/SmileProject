package co.com.smilepersistence.entity;


import java.io.Serializable;
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
@Table(name = "fecha_out")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechaOut.findAll", query = "SELECT f FROM FechaOut f"),
    @NamedQuery(name = "FechaOut.findByIdfechaOut", query = "SELECT f FROM FechaOut f WHERE f.idfechaOut = :idfechaOut"),
    @NamedQuery(name = "FechaOut.findByFechaActual", query = "SELECT f FROM FechaOut f WHERE f.fechaActual = :fechaActual"),
    @NamedQuery(name = "FechaOut.findByHoraActual", query = "SELECT f FROM FechaOut f WHERE f.horaActual = :horaActual"),
    @NamedQuery(name = "FechaOut.findByCantidad", query = "SELECT f FROM FechaOut f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "FechaOut.findByObservacion", query = "SELECT f FROM FechaOut f WHERE f.observacion = :observacion")})
public class FechaOut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfecha_out")
    private Long idfechaOut;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    @Size(max = 8)
    @Column(name = "hora_actual")
    private String horaActual;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;
    @JoinColumn(name = "idbodega", referencedColumnName = "idbodega")
    @ManyToOne(optional = false)
    private Bodega idbodega;

    public FechaOut() {
    }

    public FechaOut(Long idfechaOut) {
        this.idfechaOut = idfechaOut;
    }

    public Long getIdfechaOut() {
        return idfechaOut;
    }

    public void setIdfechaOut(Long idfechaOut) {
        this.idfechaOut = idfechaOut;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    public Bodega getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Bodega idbodega) {
        this.idbodega = idbodega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfechaOut != null ? idfechaOut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechaOut)) {
            return false;
        }
        FechaOut other = (FechaOut) object;
        if ((this.idfechaOut == null && other.idfechaOut != null) || (this.idfechaOut != null && !this.idfechaOut.equals(other.idfechaOut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.FechaOut[ idfechaOut=" + idfechaOut + " ]";
    }
    
}
