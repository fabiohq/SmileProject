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
@Table(name = "tipo_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTelefono.findAll", query = "SELECT t FROM TipoTelefono t"),
    @NamedQuery(name = "TipoTelefono.findByIdtipoTelefono", query = "SELECT t FROM TipoTelefono t WHERE t.idtipoTelefono = :idtipoTelefono"),
    @NamedQuery(name = "TipoTelefono.findByNombre", query = "SELECT t FROM TipoTelefono t WHERE t.nombre = :nombre")})
public class TipoTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo_telefono")
    private Long idtipoTelefono;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoTelefono")
    private List<Telefono> telefonoList;

    public TipoTelefono() {
    }

    public TipoTelefono(Long idtipoTelefono) {
        this.idtipoTelefono = idtipoTelefono;
    }

    public Long getIdtipoTelefono() {
        return idtipoTelefono;
    }

    public void setIdtipoTelefono(Long idtipoTelefono) {
        this.idtipoTelefono = idtipoTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoTelefono != null ? idtipoTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTelefono)) {
            return false;
        }
        TipoTelefono other = (TipoTelefono) object;
        if ((this.idtipoTelefono == null && other.idtipoTelefono != null) || (this.idtipoTelefono != null && !this.idtipoTelefono.equals(other.idtipoTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.TipoTelefono[ idtipoTelefono=" + idtipoTelefono + " ]";
    }
    
}
