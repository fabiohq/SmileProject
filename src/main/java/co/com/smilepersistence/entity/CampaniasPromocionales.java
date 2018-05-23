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
@Table(name = "campanias_promocionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CampaniasPromocionales.findAll", query = "SELECT c FROM CampaniasPromocionales c"),
    @NamedQuery(name = "CampaniasPromocionales.findByIdcampaniasPromocionales", query = "SELECT c FROM CampaniasPromocionales c WHERE c.idcampaniasPromocionales = :idcampaniasPromocionales"),
    @NamedQuery(name = "CampaniasPromocionales.findByNombre", query = "SELECT c FROM CampaniasPromocionales c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CampaniasPromocionales.findByDescuento", query = "SELECT c FROM CampaniasPromocionales c WHERE c.descuento = :descuento"),
    @NamedQuery(name = "CampaniasPromocionales.findByFechaInicio", query = "SELECT c FROM CampaniasPromocionales c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "CampaniasPromocionales.findByFechaFin", query = "SELECT c FROM CampaniasPromocionales c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "CampaniasPromocionales.findByDescripcion", query = "SELECT c FROM CampaniasPromocionales c WHERE c.descripcion = :descripcion")})
public class CampaniasPromocionales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcampanias_promocionales")
    private Long idcampaniasPromocionales;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descuento")
    private Integer descuento;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampaniasPromocionales")
    private List<Encargo> encargoList;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private Producto idproducto;
    @OneToMany(mappedBy = "idcampaniasPromocionales")
    private List<DetalleVenta> detalleVentaList;

    public CampaniasPromocionales() {
    }

    public CampaniasPromocionales(Long idcampaniasPromocionales) {
        this.idcampaniasPromocionales = idcampaniasPromocionales;
    }

    public Long getIdcampaniasPromocionales() {
        return idcampaniasPromocionales;
    }

    public void setIdcampaniasPromocionales(Long idcampaniasPromocionales) {
        this.idcampaniasPromocionales = idcampaniasPromocionales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Encargo> getEncargoList() {
        return encargoList;
    }

    public void setEncargoList(List<Encargo> encargoList) {
        this.encargoList = encargoList;
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

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampaniasPromocionales != null ? idcampaniasPromocionales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampaniasPromocionales)) {
            return false;
        }
        CampaniasPromocionales other = (CampaniasPromocionales) object;
        if ((this.idcampaniasPromocionales == null && other.idcampaniasPromocionales != null) || (this.idcampaniasPromocionales != null && !this.idcampaniasPromocionales.equals(other.idcampaniasPromocionales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.CampaniasPromocionales[ idcampaniasPromocionales=" + idcampaniasPromocionales + " ]";
    }
    
}

