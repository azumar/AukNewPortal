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
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "pume")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pume.findAll", query = "SELECT p FROM Pume p"),
    @NamedQuery(name = "Pume.findByUtmeId", query = "SELECT p FROM Pume p WHERE p.pumePK.utmeId = :utmeId"),
    @NamedQuery(name = "Pume.findByUtmejambNo", query = "SELECT p FROM Pume p WHERE p.pumePK.utmejambNo = :utmejambNo"),
    @NamedQuery(name = "Pume.findBySchedulle", query = "SELECT p FROM Pume p WHERE p.schedulle = :schedulle")})
public class Pume implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PumePK pumePK;
    @Size(max = 85)
    @Column(name = "schedulle")
    private String schedulle;
    @JoinColumns({
        @JoinColumn(name = "utme_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "utme_jambNo", referencedColumnName = "jambNo", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Utme utme;

    public Pume() {
    }

    public Pume(PumePK pumePK) {
        this.pumePK = pumePK;
    }

    public Pume(int utmeId, String utmejambNo) {
        this.pumePK = new PumePK(utmeId, utmejambNo);
    }

    public PumePK getPumePK() {
        return pumePK;
    }

    public void setPumePK(PumePK pumePK) {
        this.pumePK = pumePK;
    }

    public String getSchedulle() {
        return schedulle;
    }

    public void setSchedulle(String schedulle) {
        this.schedulle = schedulle;
    }

    public Utme getUtme() {
        return utme;
    }

    public void setUtme(Utme utme) {
        this.utme = utme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pumePK != null ? pumePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pume)) {
            return false;
        }
        Pume other = (Pume) object;
        if ((this.pumePK == null && other.pumePK != null) || (this.pumePK != null && !this.pumePK.equals(other.pumePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pume[ pumePK=" + pumePK + " ]";
    }
    
}
