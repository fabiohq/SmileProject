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
@Table(name = "estado_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEntrega.findAll", query = "SELECT e FROM EstadoEntrega e"),
    @NamedQuery(name = "EstadoEntrega.findByIdestadoEntrega", query = "SELECT e FROM EstadoEntrega e WHERE e.idestadoEntrega = :idestadoEntrega"),
    @NamedQuery(name = "EstadoEntrega.findByNombre", query = "SELECT e FROM EstadoEntrega e WHERE e.nombre = :nombre")})
public class EstadoEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestado_entrega")
    private Long idestadoEntrega;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoEntrega")
    private List<Encargo> encargoList;

    public EstadoEntrega() {
    }

    public EstadoEntrega(Long idestadoEntrega) {
        this.idestadoEntrega = idestadoEntrega;
    }

    public Long getIdestadoEntrega() {
        return idestadoEntrega;
    }

    public void setIdestadoEntrega(Long idestadoEntrega) {
        this.idestadoEntrega = idestadoEntrega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Encargo> getEncargoList() {
        return encargoList;
    }

    public void setEncargoList(List<Encargo> encargoList) {
        this.encargoList = encargoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoEntrega != null ? idestadoEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEntrega)) {
            return false;
        }
        EstadoEntrega other = (EstadoEntrega) object;
        if ((this.idestadoEntrega == null && other.idestadoEntrega != null) || (this.idestadoEntrega != null && !this.idestadoEntrega.equals(other.idestadoEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.EstadoEntrega[ idestadoEntrega=" + idestadoEntrega + " ]";
    }
    
}
