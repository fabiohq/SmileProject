package co.com.smilepersistence.entity;


import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FABIO
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIddocumento", query = "SELECT d FROM Documento d WHERE d.iddocumento = :iddocumento"),
    @NamedQuery(name = "Documento.findByNumero", query = "SELECT d FROM Documento d WHERE d.numero = :numero")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddocumento")
    private Long iddocumento;
    @Size(max = 20)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idtipo_documento", referencedColumnName = "idtipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento idtipoDocumento;
    @OneToMany(mappedBy = "iddocumento")
    private List<Encargo> encargoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocumento")
    private List<ActorSistema> actorSistemaList;
    @OneToMany(mappedBy = "iddocumento")
    private List<ConsolidadoVenta> consolidadoVentaList;
    @OneToMany(mappedBy = "iddocumento")
    private List<VentaPendiente> ventaPendienteList;
    @OneToMany(mappedBy = "iddocumento")
    private List<DetalleVenta> detalleVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocumento")
    private List<SaldoAFavor> saldoAFavorList;

    public Documento() {
    }

    public Documento(Long iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Long getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Long iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public TipoDocumento getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(TipoDocumento idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    @XmlTransient
    public List<Encargo> getEncargoList() {
        return encargoList;
    }

    public void setEncargoList(List<Encargo> encargoList) {
        this.encargoList = encargoList;
    }

    @XmlTransient
    public List<ActorSistema> getActorSistemaList() {
        return actorSistemaList;
    }

    public void setActorSistemaList(List<ActorSistema> actorSistemaList) {
        this.actorSistemaList = actorSistemaList;
    }

    @XmlTransient
    public List<ConsolidadoVenta> getConsolidadoVentaList() {
        return consolidadoVentaList;
    }

    public void setConsolidadoVentaList(List<ConsolidadoVenta> consolidadoVentaList) {
        this.consolidadoVentaList = consolidadoVentaList;
    }

    @XmlTransient
    public List<VentaPendiente> getVentaPendienteList() {
        return ventaPendienteList;
    }

    public void setVentaPendienteList(List<VentaPendiente> ventaPendienteList) {
        this.ventaPendienteList = ventaPendienteList;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @XmlTransient
    public List<SaldoAFavor> getSaldoAFavorList() {
        return saldoAFavorList;
    }

    public void setSaldoAFavorList(List<SaldoAFavor> saldoAFavorList) {
        this.saldoAFavorList = saldoAFavorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumento != null ? iddocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.iddocumento == null && other.iddocumento != null) || (this.iddocumento != null && !this.iddocumento.equals(other.iddocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.Documento[ iddocumento=" + iddocumento + " ]";
    }
    
}