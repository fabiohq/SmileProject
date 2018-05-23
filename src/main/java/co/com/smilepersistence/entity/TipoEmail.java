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
@Table(name = "tipo_email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmail.findAll", query = "SELECT t FROM TipoEmail t"),
    @NamedQuery(name = "TipoEmail.findByIdtipoEmail", query = "SELECT t FROM TipoEmail t WHERE t.idtipoEmail = :idtipoEmail"),
    @NamedQuery(name = "TipoEmail.findByNombre", query = "SELECT t FROM TipoEmail t WHERE t.nombre = :nombre")})
public class TipoEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo_email")
    private Long idtipoEmail;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoEmail")
    private List<Email> emailList;

    public TipoEmail() {
    }

    public TipoEmail(Long idtipoEmail) {
        this.idtipoEmail = idtipoEmail;
    }

    public Long getIdtipoEmail() {
        return idtipoEmail;
    }

    public void setIdtipoEmail(Long idtipoEmail) {
        this.idtipoEmail = idtipoEmail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoEmail != null ? idtipoEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmail)) {
            return false;
        }
        TipoEmail other = (TipoEmail) object;
        if ((this.idtipoEmail == null && other.idtipoEmail != null) || (this.idtipoEmail != null && !this.idtipoEmail.equals(other.idtipoEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.TipoEmail[ idtipoEmail=" + idtipoEmail + " ]";
    }
    
}
