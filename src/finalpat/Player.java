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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emanuelpackas
 */
@Entity
@Table(name = "PLAYER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
    , @NamedQuery(name = "Player.findByPlayerid", query = "SELECT p FROM Player p WHERE p.playerid = :playerid")
    , @NamedQuery(name = "Player.findByPname", query = "SELECT p FROM Player p WHERE p.pname = :pname")
    , @NamedQuery(name = "Player.findByPsurname", query = "SELECT p FROM Player p WHERE p.psurname = :psurname")
    , @NamedQuery(name = "Player.findByPheight", query = "SELECT p FROM Player p WHERE p.pheight = :pheight")
    , @NamedQuery(name = "Player.findByPweight", query = "SELECT p FROM Player p WHERE p.pweight = :pweight")
    , @NamedQuery(name = "Player.findByPage", query = "SELECT p FROM Player p WHERE p.page = :page")
    , @NamedQuery(name = "Player.findByPinjuredbefore", query = "SELECT p FROM Player p WHERE p.pinjuredbefore = :pinjuredbefore")
    , @NamedQuery(name = "Player.findByPgoals", query = "SELECT p FROM Player p WHERE p.pgoals = :pgoals")
    , @NamedQuery(name = "Player.findByPassists", query = "SELECT p FROM Player p WHERE p.passists = :passists")
    , @NamedQuery(name = "Player.findByPappearances", query = "SELECT p FROM Player p WHERE p.pappearances = :pappearances")
    , @NamedQuery(name = "Player.findByPnationality", query = "SELECT p FROM Player p WHERE p.pnationality = :pnationality")
    , @NamedQuery(name = "Player.findByPyellow", query = "SELECT p FROM Player p WHERE p.pyellow = :pyellow")
    , @NamedQuery(name = "Player.findByPred", query = "SELECT p FROM Player p WHERE p.pred = :pred")})
public class Player implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYERID")
    private Integer playerid;
    @Column(name = "PNAME")
    private String pname;
    @Column(name = "PSURNAME")
    private String psurname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PHEIGHT")
    private BigDecimal pheight;
    @Column(name = "PWEIGHT")
    private BigDecimal pweight;
    @Column(name = "PAGE")
    private Integer page;
    @Column(name = "PINJUREDBEFORE")
    private Boolean pinjuredbefore;
    @Column(name = "PGOALS")
    private Integer pgoals;
    @Column(name = "PASSISTS")
    private Integer passists;
    @Column(name = "PAPPEARANCES")
    private Integer pappearances;
    @Column(name = "PNATIONALITY")
    private String pnationality;
    @Column(name = "PYELLOW")
    private Integer pyellow;
    @Column(name = "PRED")
    private Integer pred;
    @JoinColumn(name = "INJURYID", referencedColumnName = "INJURYID")
    @ManyToOne
    private Injury injury;
    @JoinColumn(name = "POSITIONID", referencedColumnName = "POSITIONID")
    @ManyToOne
    private Pposition pposition;

    public Player() {
    }

    public Player(Integer playerid) {
        this.playerid = playerid;
    }

    public Integer getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Integer playerid) {
        Integer oldPlayerid = this.playerid;
        this.playerid = playerid;
        changeSupport.firePropertyChange("playerid", oldPlayerid, playerid);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        String oldPname = this.pname;
        this.pname = pname;
        changeSupport.firePropertyChange("pname", oldPname, pname);
    }

    public String getPsurname() {
        return psurname;
    }

    public void setPsurname(String psurname) {
        String oldPsurname = this.psurname;
        this.psurname = psurname;
        changeSupport.firePropertyChange("psurname", oldPsurname, psurname);
    }

    public BigDecimal getPheight() {
        return pheight;
    }

    public void setPheight(BigDecimal pheight) {
        BigDecimal oldPheight = this.pheight;
        this.pheight = pheight;
        changeSupport.firePropertyChange("pheight", oldPheight, pheight);
    }

    public BigDecimal getPweight() {
        return pweight;
    }

    public void setPweight(BigDecimal pweight) {
        BigDecimal oldPweight = this.pweight;
        this.pweight = pweight;
        changeSupport.firePropertyChange("pweight", oldPweight, pweight);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        Integer oldPage = this.page;
        this.page = page;
        changeSupport.firePropertyChange("page", oldPage, page);
    }

    public Boolean getPinjuredbefore() {
        return pinjuredbefore;
    }

    public void setPinjuredbefore(Boolean pinjuredbefore) {
        Boolean oldPinjuredbefore = this.pinjuredbefore;
        this.pinjuredbefore = pinjuredbefore;
        changeSupport.firePropertyChange("pinjuredbefore", oldPinjuredbefore, pinjuredbefore);
    }

    public Integer getPgoals() {
        return pgoals;
    }

    public void setPgoals(Integer pgoals) {
        Integer oldPgoals = this.pgoals;
        this.pgoals = pgoals;
        changeSupport.firePropertyChange("pgoals", oldPgoals, pgoals);
    }

    public Integer getPassists() {
        return passists;
    }

    public void setPassists(Integer passists) {
        Integer oldPassists = this.passists;
        this.passists = passists;
        changeSupport.firePropertyChange("passists", oldPassists, passists);
    }

    public Integer getPappearances() {
        return pappearances;
    }

    public void setPappearances(Integer pappearances) {
        Integer oldPappearances = this.pappearances;
        this.pappearances = pappearances;
        changeSupport.firePropertyChange("pappearances", oldPappearances, pappearances);
    }

    public String getPnationality() {
        return pnationality;
    }

    public void setPnationality(String pnationality) {
        String oldPnationality = this.pnationality;
        this.pnationality = pnationality;
        changeSupport.firePropertyChange("pnationality", oldPnationality, pnationality);
    }

    public Integer getPyellow() {
        return pyellow;
    }

    public void setPyellow(Integer pyellow) {
        Integer oldPyellow = this.pyellow;
        this.pyellow = pyellow;
        changeSupport.firePropertyChange("pyellow", oldPyellow, pyellow);
    }

    public Integer getPred() {
        return pred;
    }

    public void setPred(Integer pred) {
        Integer oldPred = this.pred;
        this.pred = pred;
        changeSupport.firePropertyChange("pred", oldPred, pred);
    }

    public Injury getInjury() {
        return injury;
    }

    public void setInjury(Injury injury) {
        Injury oldInjury = this.injury;
        this.injury = injury;
        changeSupport.firePropertyChange("injury", oldInjury, injury);
    }

    public Pposition getPposition() {
        return pposition;
    }

    public void setPposition(Pposition pposition) {
        Pposition oldPposition = this.pposition;
        this.pposition = pposition;
        changeSupport.firePropertyChange("pposition", oldPposition, pposition);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerid != null ? playerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.playerid == null && other.playerid != null) || (this.playerid != null && !this.playerid.equals(other.playerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        String toret = getPname() + " " + getPsurname();
        return toret;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
