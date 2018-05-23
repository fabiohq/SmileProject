package co.com.smilepersistence.entity;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "estado_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoVenta.findAll", query = "SELECT e FROM EstadoVenta e"),
    @NamedQuery(name = "EstadoVenta.findByIdestadoVenta", query = "SELECT e FROM EstadoVenta e WHERE e.idestadoVenta = :idestadoVenta"),
    @NamedQuery(name = "EstadoVenta.findByNombre", query = "SELECT e FROM EstadoVenta e WHERE e.nombre = :nombre")})
public class EstadoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestado_venta")
    private Long idestadoVenta;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoVenta")
    private List<VentaPendiente> ventaPendienteList;

    public EstadoVenta() {
    }

    public EstadoVenta(Long idestadoVenta) {
        this.idestadoVenta = idestadoVenta;
    }

    public Long getIdestadoVenta() {
        return idestadoVenta;
    }

    public void setIdestadoVenta(Long idestadoVenta) {
        this.idestadoVenta = idestadoVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<VentaPendiente> getVentaPendienteList() {
        return ventaPendienteList;
    }

    public void setVentaPendienteList(List<VentaPendiente> ventaPendienteList) {
        this.ventaPendienteList = ventaPendienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoVenta != null ? idestadoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoVenta)) {
            return false;
        }
        EstadoVenta other = (EstadoVenta) object;
        if ((this.idestadoVenta == null && other.idestadoVenta != null) || (this.idestadoVenta != null && !this.idestadoVenta.equals(other.idestadoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.EstadoVenta[ idestadoVenta=" + idestadoVenta + " ]";
    }
    
}