/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "referee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referee.findAll", query = "SELECT r FROM Referee r"),
    @NamedQuery(name = "Referee.findById", query = "SELECT r FROM Referee r WHERE r.refereePK.id = :id"),
    @NamedQuery(name = "Referee.findByName", query = "SELECT r FROM Referee r WHERE r.name = :name"),
    @NamedQuery(name = "Referee.findByRank", query = "SELECT r FROM Referee r WHERE r.rank = :rank"),
    @NamedQuery(name = "Referee.findByEmail", query = "SELECT r FROM Referee r WHERE r.email = :email"),
    @NamedQuery(name = "Referee.findByGsm", query = "SELECT r FROM Referee r WHERE r.gsm = :gsm"),
    @NamedQuery(name = "Referee.findByPgId", query = "SELECT r FROM Referee r WHERE r.refereePK.pgId = :pgId")})
public class Referee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RefereePK refereePK;
    @Size(max = 105)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "rank")
    private String rank;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 105)
    @Column(name = "email")
    private String email;
    @Size(max = 25)
    @Column(name = "gsm")
    private String gsm;
    @JoinColumn(name = "pg_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pg pg;

    public Referee() {
    }

    public Referee(RefereePK refereePK) {
        this.refereePK = refereePK;
    }

    public Referee(int id, int pgId) {
        this.refereePK = new RefereePK(id, pgId);
    }

    public RefereePK getRefereePK() {
        return refereePK;
    }

    public void setRefereePK(RefereePK refereePK) {
        this.refereePK = refereePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public Pg getPg() {
        return pg;
    }

    public void setPg(Pg pg) {
        this.pg = pg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refereePK != null ? refereePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referee)) {
            return false;
        }
        Referee other = (Referee) object;
        if ((this.refereePK == null && other.refereePK != null) || (this.refereePK != null && !this.refereePK.equals(other.refereePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Referee[ refereePK=" + refereePK + " ]";
    }
    
}
