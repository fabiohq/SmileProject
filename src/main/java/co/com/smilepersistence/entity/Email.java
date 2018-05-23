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
@Table(name = "email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findByIdemail", query = "SELECT e FROM Email e WHERE e.idemail = :idemail"),
    @NamedQuery(name = "Email.findByMail", query = "SELECT e FROM Email e WHERE e.mail = :mail")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idemail")
    private Long idemail;
    @Size(max = 200)
    @Column(name = "mail")
    private String mail;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idtipo_email", referencedColumnName = "idtipo_email")
    @ManyToOne(optional = false)
    private TipoEmail idtipoEmail;

    public Email() {
    }

    public Email(Long idemail) {
        this.idemail = idemail;
    }

    public Long getIdemail() {
        return idemail;
    }

    public void setIdemail(Long idemail) {
        this.idemail = idemail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public TipoEmail getIdtipoEmail() {
        return idtipoEmail;
    }

    public void setIdtipoEmail(TipoEmail idtipoEmail) {
        this.idtipoEmail = idtipoEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemail != null ? idemail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.idemail == null && other.idemail != null) || (this.idemail != null && !this.idemail.equals(other.idemail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.Email[ idemail=" + idemail + " ]";
    }
    
}