/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpat;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author emanuelpackas
 */
@Entity
@Table(name = "INJURY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Injury.findAll", query = "SELECT i FROM Injury i")
    , @NamedQuery(name = "Injury.findByInjuryid", query = "SELECT i FROM Injury i WHERE i.injuryid = :injuryid")
    , @NamedQuery(name = "Injury.findByIname", query = "SELECT i FROM Injury i WHERE i.iname = :iname")
    , @NamedQuery(name = "Injury.findByItreatment", query = "SELECT i FROM Injury i WHERE i.itreatment = :itreatment")
    , @NamedQuery(name = "Injury.findByRecoverydays", query = "SELECT i FROM Injury i WHERE i.recoverydays = :recoverydays")
    , @NamedQuery(name = "Injury.findByExtremity", query = "SELECT i FROM Injury i WHERE i.extremity = :extremity")})
public class Injury implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INJURYID")
    private Integer injuryid;
    @Column(name = "INAME")
    private String iname;
    @Column(name = "ITREATMENT")
    private String itreatment;
    @Column(name = "RECOVERYDAYS")
    private Integer recoverydays;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EXTREMITY")
    private BigDecimal extremity;
    @OneToMany(mappedBy = "injury")
    private List<Player> playerList;

    public Injury() {
    }

    public Injury(Integer injuryid) {
        this.injuryid = injuryid;
    }

    public Integer getInjuryid() {
        return injuryid;
    }

    public void setInjuryid(Integer injuryid) {
        Integer oldInjuryid = this.injuryid;
        this.injuryid = injuryid;
        changeSupport.firePropertyChange("injuryid", oldInjuryid, injuryid);
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        String oldIname = this.iname;
        this.iname = iname;
        changeSupport.firePropertyChange("iname", oldIname, iname);
    }

    public String getItreatment() {
        return itreatment;
    }

    public void setItreatment(String itreatment) {
        String oldItreatment = this.itreatment;
        this.itreatment = itreatment;
        changeSupport.firePropertyChange("itreatment", oldItreatment, itreatment);
    }

    public Integer getRecoverydays() {
        return recoverydays;
    }

    public void setRecoverydays(Integer recoverydays) {
        Integer oldRecoverydays = this.recoverydays;
        this.recoverydays = recoverydays;
        changeSupport.firePropertyChange("recoverydays", oldRecoverydays, recoverydays);
    }

    public BigDecimal getExtremity() {
        return extremity;
    }

    public void setExtremity(BigDecimal extremity) {
        BigDecimal oldExtremity = this.extremity;
        this.extremity = extremity;
        changeSupport.firePropertyChange("extremity", oldExtremity, extremity);
    }

    @XmlTransient
    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (injuryid != null ? injuryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Injury)) {
            return false;
        }
        Injury other = (Injury) object;
        if ((this.injuryid == null && other.injuryid != null) || (this.injuryid != null && !this.injuryid.equals(other.injuryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIname();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
