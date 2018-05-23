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
@Table(name = "actor_sistema")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "ActorSistema.findAll", query = "SELECT a FROM ActorSistema a"),
   @NamedQuery(name = "ActorSistema.findByIdactorSistema", query = "SELECT a FROM ActorSistema a WHERE a.idactorSistema = :idactorSistema"),
   @NamedQuery(name = "ActorSistema.findByObservacion", query = "SELECT a FROM ActorSistema a WHERE a.observacion = :observacion"),
   @NamedQuery(name = "ActorSistema.findByFechaRegistro", query = "SELECT a FROM ActorSistema a WHERE a.fechaRegistro = :fechaRegistro")})
public class ActorSistema implements Serializable{


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idactor_sistema")
    private Long idactorSistema;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<FechaIn> fechaInList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<FechaOut> fechaOutList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<Encargo> encargoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<CampaniasPromocionales> campaniasPromocionalesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<Credenciales> credencialesList;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne(optional = false)
    private Documento iddocumento;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne
    private Estado idestado;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Rol idrol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<ConsolidadoVenta> consolidadoVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<ConsolidadoVtaDia> consolidadoVtaDiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<VentaPendiente> ventaPendienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<Bodega> bodegaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactorSistema")
    private List<DetalleVenta> detalleVentaList;

    public ActorSistema() {
    }

    public ActorSistema(Long idactorSistema) {
        this.idactorSistema = idactorSistema;
    }

    public Long getIdactorSistema() {
        return idactorSistema;
    }

    public void setIdactorSistema(Long idactorSistema) {
        this.idactorSistema = idactorSistema;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    @XmlTransient
    public List<Encargo> getEncargoList() {
        return encargoList;
    }

    public void setEncargoList(List<Encargo> encargoList) {
        this.encargoList = encargoList;
    }

    @XmlTransient
    public List<CampaniasPromocionales> getCampaniasPromocionalesList() {
        return campaniasPromocionalesList;
    }

    public void setCampaniasPromocionalesList(List<CampaniasPromocionales> campaniasPromocionalesList) {
        this.campaniasPromocionalesList = campaniasPromocionalesList;
    }

    @XmlTransient
    public List<Credenciales> getCredencialesList() {
        return credencialesList;
    }

    public void setCredencialesList(List<Credenciales> credencialesList) {
        this.credencialesList = credencialesList;
    }

    public Documento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Documento iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    @XmlTransient
    public List<ConsolidadoVenta> getConsolidadoVentaList() {
        return consolidadoVentaList;
    }

    public void setConsolidadoVentaList(List<ConsolidadoVenta> consolidadoVentaList) {
        this.consolidadoVentaList = consolidadoVentaList;
    }

    @XmlTransient
    public List<ConsolidadoVtaDia> getConsolidadoVtaDiaList() {
        return consolidadoVtaDiaList;
    }

    public void setConsolidadoVtaDiaList(List<ConsolidadoVtaDia> consolidadoVtaDiaList) {
        this.consolidadoVtaDiaList = consolidadoVtaDiaList;
    }

    @XmlTransient
    public List<VentaPendiente> getVentaPendienteList() {
        return ventaPendienteList;
    }

    public void setVentaPendienteList(List<VentaPendiente> ventaPendienteList) {
        this.ventaPendienteList = ventaPendienteList;
    }

    @XmlTransient
    public List<Bodega> getBodegaList() {
        return bodegaList;
    }

    public void setBodegaList(List<Bodega> bodegaList) {
        this.bodegaList = bodegaList;
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
        hash += (idactorSistema != null ? idactorSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActorSistema)) {
            return false;
        }
        ActorSistema other = (ActorSistema) object;
        if ((this.idactorSistema == null && other.idactorSistema != null) || (this.idactorSistema != null && !this.idactorSistema.equals(other.idactorSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.ActorSistema[ idactorSistema=" + idactorSistema + " ]";
    }

}
