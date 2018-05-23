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
@Table(name = "fecha_in")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechaIn.findAll", query = "SELECT f FROM FechaIn f"),
    @NamedQuery(name = "FechaIn.findByIdfechaIn", query = "SELECT f FROM FechaIn f WHERE f.idfechaIn = :idfechaIn"),
    @NamedQuery(name = "FechaIn.findByFechaActual", query = "SELECT f FROM FechaIn f WHERE f.fechaActual = :fechaActual"),
    @NamedQuery(name = "FechaIn.findByHoraActual", query = "SELECT f FROM FechaIn f WHERE f.horaActual = :horaActual"),
    @NamedQuery(name = "FechaIn.findByCantidad", query = "SELECT f FROM FechaIn f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "FechaIn.findByObservacion", query = "SELECT f FROM FechaIn f WHERE f.observacion = :observacion")})
public class FechaIn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfecha_in")
    private Long idfechaIn;
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

    public FechaIn() {
    }

    public FechaIn(Long idfechaIn) {
        this.idfechaIn = idfechaIn;
    }

    public Long getIdfechaIn() {
        return idfechaIn;
    }

    public void setIdfechaIn(Long idfechaIn) {
        this.idfechaIn = idfechaIn;
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
        hash += (idfechaIn != null ? idfechaIn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechaIn)) {
            return false;
        }
        FechaIn other = (FechaIn) object;
        if ((this.idfechaIn == null && other.idfechaIn != null) || (this.idfechaIn != null && !this.idfechaIn.equals(other.idfechaIn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.FechaIn[ idfechaIn=" + idfechaIn + " ]";
    }
    
}