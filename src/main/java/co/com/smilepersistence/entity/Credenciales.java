package co.com.smilepersistence.entity;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FABIO
 */
@Entity
@Table(name = "credenciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credenciales.findAll", query = "SELECT c FROM Credenciales c"),
    @NamedQuery(name = "Credenciales.findByIdcredenciales", query = "SELECT c FROM Credenciales c WHERE c.idcredenciales = :idcredenciales"),
    @NamedQuery(name = "Credenciales.findByUsuario", query = "SELECT c FROM Credenciales c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Credenciales.findByClave", query = "SELECT c FROM Credenciales c WHERE c.clave = :clave")})
public class Credenciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcredenciales")
    private Long idcredenciales;
    @Size(max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 50)
    @Column(name = "clave")
    private String clave;
    @JoinColumn(name = "idactor_sistema", referencedColumnName = "idactor_sistema")
    @ManyToOne(optional = false)
    private ActorSistema idactorSistema;

    public Credenciales() {
    }

    public Credenciales(Long idcredenciales) {
        this.idcredenciales = idcredenciales;
    }

    public Long getIdcredenciales() {
        return idcredenciales;
    }

    public void setIdcredenciales(Long idcredenciales) {
        this.idcredenciales = idcredenciales;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ActorSistema getIdactorSistema() {
        return idactorSistema;
    }

    public void setIdactorSistema(ActorSistema idactorSistema) {
        this.idactorSistema = idactorSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcredenciales != null ? idcredenciales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credenciales)) {
            return false;
        }
        Credenciales other = (Credenciales) object;
        if ((this.idcredenciales == null && other.idcredenciales != null) || (this.idcredenciales != null && !this.idcredenciales.equals(other.idcredenciales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.Credenciales[ idcredenciales=" + idcredenciales + " ]";
    }
    
}
