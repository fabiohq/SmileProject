package co.com.smilepersistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table (name = "abono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Abono.FIND_ALL, query = "SELECT a FROM Abono a"),
    @NamedQuery(name = Abono.FIND_BY_ID_ABONO, query = "SELECT a FROM Abono a WHERE a.idabono = :idabono"),
    @NamedQuery(name = "Abono.findByFechaActual", query = "SELECT a FROM Abono a WHERE a.fechaActual = :fechaActual"),
    @NamedQuery(name = "Abono.findByHoraActual", query = "SELECT a FROM Abono a WHERE a.horaActual = :horaActual"),
    @NamedQuery(name = "Abono.findByValor", query = "SELECT a FROM Abono a WHERE a.valor = :valor"),
    @NamedQuery(name = "Abono.findByObservacion", query = "SELECT a FROM Abono a WHERE a.observacion = :observacion")})
public class Abono implements Serializable{
	
	protected static final String FIND_ALL = "Abono.findAll";
	protected static final String FIND_BY_ID_ABONO = "Abono.findByIdabono";

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idabono")
    private Long idabono;
    @Column(name = "fecha_actual")
    @Temporal(TemporalType.DATE)
    private Date fechaActual;
    @Size(max = 8)
    @Column(name = "hora_actual")
    private String horaActual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idventa_pendiente", referencedColumnName = "idventa_pendiente")
    @ManyToOne(optional = false)
    private VentaPendiente idventaPendiente;

    public Abono() {
    }
    
    public Abono(Long idabono) {
        this.idabono = idabono;
    }

    public Long getIdabono() {
        return idabono;
    }

    public void setIdabono(Long idabono) {
        this.idabono = idabono;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getHoraActual() {
        return horaActual;
    }

    public void setHoraActual(String horaActual) {
        this.horaActual = horaActual;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public VentaPendiente getIdventaPendiente() {
        return idventaPendiente;
    }

    public void setIdventaPendiente(VentaPendiente idventaPendiente) {
        this.idventaPendiente = idventaPendiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idabono != null ? idabono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abono)) {
            return false;
        }
        Abono other = (Abono) object;
        if ((this.idabono == null && other.idabono != null) || (this.idabono != null && !this.idabono.equals(other.idabono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.smileproject.smilepersistence.modelo.entity.Abono[ idabono=" + idabono + " ]";
    }

}
