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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByIdtipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.idtipoDocumento = :idtipoDocumento"),
    @NamedQuery(name = "TipoDocumento.findByNombre", query = "SELECT t FROM TipoDocumento t WHERE t.nombre = :nombre")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo_documento")
    private Long idtipoDocumento;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoDocumento")
    private List<Documento> documentoList;

    public TipoDocumento() {
    }

    public TipoDocumento(Long idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }
    
    public TipoDocumento(Long idtipoDocumento,String nombre) {
        this.idtipoDocumento = idtipoDocumento;
        this.nombre = nombre;
    }

    public Long getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(Long idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoDocumento != null ? idtipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idtipoDocumento == null && other.idtipoDocumento != null) || (this.idtipoDocumento != null && !this.idtipoDocumento.equals(other.idtipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.TipoDocumento[ idtipoDocumento=" + idtipoDocumento + " ]";
    }
    
}