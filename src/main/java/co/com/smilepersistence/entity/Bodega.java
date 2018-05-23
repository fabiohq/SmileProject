package co.com.smilepersistence.entity;

import java.io.Serializable;
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
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByIdbodega", query = "SELECT b FROM Bodega b WHERE b.idbodega = :idbodega"),
    @NamedQuery(name = "Bodega.findByCantidad", query = "SELECT b FROM Bodega b WHERE b.cantidad = :cantidad"),
    @NamedQuery(name = "Bodega.findByFechaActual", query = "SELECT b FROM Bodega b WHERE b.fechaActual = :fechaActual"),
    @NamedQuery(name = "Bodega.findByHoraActual", query = "SELECT b FROM Bodega b WHERE b.horaActual = :horaActual"),
    @NamedQuery(name = "Bodega.findByTopeMax", query = "SELECT b FROM Bodega b WHERE b.topeMax = :topeMax"),
    @NamedQuery(name = "Bodega.findByTopeMinimo", query = "SELECT b FROM Bodega b WHERE b.topeMinimo = :topeMinimo"),
    @NamedQuery(name = "Bodega.findByObservaciones", query = "SELECT b FROM Bodega b WHERE b.observaciones = :observaciones")})
public class Bodega implements Serializable{
	

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbodega")
    private Long idbodega;
    @Column(name = "cantidad")
    private Long cantidad;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    @Size(max = 8)
    @Column(name = "hora_actual")
    private String horaActual;
    @Column(name = "tope_max")
    private Integer topeMax;
    @Column(name = "tope_minimo")
    private Integer topeMinimo;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbodega")
    private List<FechaIn> fechaInList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbodega")
    private List<FechaOut> fechaOutList;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;

    public Bodega() {
    }

    public Bodega(Long idbodega) {
        this.idbodega = idbodega;
    }

    public Long getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Long idbodega) {
        this.idbodega = idbodega;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
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

    public Integer getTopeMax() {
        return topeMax;
    }

    public void setTopeMax(Integer topeMax) {
        this.topeMax = topeMax;
    }

    public Integer getTopeMinimo() {
        return topeMinimo;
    }

    public void setTopeMinimo(Integer topeMinimo) {
        this.topeMinimo = topeMinimo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<FechaIn> getFechaInList() {
        return fechaInList;
    }

    public void setFechaInList(List<FechaIn> fechaInList) {
        this.fechaInList = fechaInList;
    }

    @XmlTransient
    public List<FechaOut> getFechaOutList() {
        return fechaOutList;
    }

    public void setFechaOutList(List<FechaOut> fechaOutList) {
        this.fechaOutList = fechaOutList;
    }

    public ActorSistema getIdactorSistema() {
        return idactorSistema;
    }

    public void setIdactorSistema(ActorSistema idactorSistema) {
        this.idactorSistema = idactorSistema;
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
        hash += (idbodega != null ? idbodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idbodega == null && other.idbodega != null) || (this.idbodega != null && !this.idbodega.equals(other.idbodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.Bodega[ idbodega=" + idbodega + " ]";
    }
}