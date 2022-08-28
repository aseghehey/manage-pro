/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpat;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "PPOSITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pposition.findAll", query = "SELECT p FROM Pposition p")
    , @NamedQuery(name = "Pposition.findByPositionid", query = "SELECT p FROM Pposition p WHERE p.positionid = :positionid")
    , @NamedQuery(name = "Pposition.findByPositioname", query = "SELECT p FROM Pposition p WHERE p.positioname = :positioname")
    , @NamedQuery(name = "Pposition.findByPositioncategory", query = "SELECT p FROM Pposition p WHERE p.positioncategory = :positioncategory")
    , @NamedQuery(name = "Pposition.findByPlayupfront", query = "SELECT p FROM Pposition p WHERE p.playupfront = :playupfront")})
public class Pposition implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "POSITIONID")
    private Integer positionid;
    @Column(name = "POSITIONAME")
    private String positioname;
    @Column(name = "POSITIONCATEGORY")
    private String positioncategory;
    @Column(name = "PLAYUPFRONT")
    private Boolean playupfront;
    @OneToMany(mappedBy = "pposition")
    private List<Player> playerList;

    public Pposition() {
    }

    public Pposition(Integer positionid) {
        this.positionid = positionid;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        Integer oldPositionid = this.positionid;
        this.positionid = positionid;
        changeSupport.firePropertyChange("positionid", oldPositionid, positionid);
    }

    public String getPositioname() {
        return positioname;
    }

    public void setPositioname(String positioname) {
        String oldPositioname = this.positioname;
        this.positioname = positioname;
        changeSupport.firePropertyChange("positioname", oldPositioname, positioname);
    }

    public String getPositioncategory() {
        return positioncategory;
    }

    public void setPositioncategory(String positioncategory) {
        String oldPositioncategory = this.positioncategory;
        this.positioncategory = positioncategory;
        changeSupport.firePropertyChange("positioncategory", oldPositioncategory, positioncategory);
    }

    public Boolean getPlayupfront() {
        return playupfront;
    }

    public void setPlayupfront(Boolean playupfront) {
        Boolean oldPlayupfront = this.playupfront;
        this.playupfront = playupfront;
        changeSupport.firePropertyChange("playupfront", oldPlayupfront, playupfront);
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
        hash += (positionid != null ? positionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pposition)) {
            return false;
        }
        Pposition other = (Pposition) object;
        if ((this.positionid == null && other.positionid != null) || (this.positionid != null && !this.positionid.equals(other.positionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String toret = getPositioname();
        return toret;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
