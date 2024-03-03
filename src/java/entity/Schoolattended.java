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
@Table(name = "schoolattended")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schoolattended.findAll", query = "SELECT s FROM Schoolattended s"),
    @NamedQuery(name = "Schoolattended.findById", query = "SELECT s FROM Schoolattended s WHERE s.schoolattendedPK.id = :id"),
    @NamedQuery(name = "Schoolattended.findByCollege", query = "SELECT s FROM Schoolattended s WHERE s.college = :college"),
    @NamedQuery(name = "Schoolattended.findByBegn", query = "SELECT s FROM Schoolattended s WHERE s.begn = :begn"),
    @NamedQuery(name = "Schoolattended.findByEnds", query = "SELECT s FROM Schoolattended s WHERE s.ends = :ends"),
    @NamedQuery(name = "Schoolattended.findByCert", query = "SELECT s FROM Schoolattended s WHERE s.cert = :cert"),
    @NamedQuery(name = "Schoolattended.findByPgId", query = "SELECT s FROM Schoolattended s WHERE s.schoolattendedPK.pgId = :pgId")})
public class Schoolattended implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchoolattendedPK schoolattendedPK;
    @Size(max = 200)
    @Column(name = "college")
    private String college;
    @Size(max = 100)
    @Column(name = "begn")
    private String begn;
    @Size(max = 100)
    @Column(name = "ends")
    private String ends;
    @Size(max = 45)
    @Column(name = "cert")
    private String cert;
    @JoinColumn(name = "pg_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pg pg;

    public Schoolattended() {
    }

    public Schoolattended(SchoolattendedPK schoolattendedPK) {
        this.schoolattendedPK = schoolattendedPK;
    }

    public Schoolattended(int id, int pgId) {
        this.schoolattendedPK = new SchoolattendedPK(id, pgId);
    }

    public SchoolattendedPK getSchoolattendedPK() {
        return schoolattendedPK;
    }

    public void setSchoolattendedPK(SchoolattendedPK schoolattendedPK) {
        this.schoolattendedPK = schoolattendedPK;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBegn() {
        return begn;
    }

    public void setBegn(String begn) {
        this.begn = begn;
    }

    public String getEnds() {
        return ends;
    }

    public void setEnds(String ends) {
        this.ends = ends;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
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
        hash += (schoolattendedPK != null ? schoolattendedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schoolattended)) {
            return false;
        }
        Schoolattended other = (Schoolattended) object;
        if ((this.schoolattendedPK == null && other.schoolattendedPK != null) || (this.schoolattendedPK != null && !this.schoolattendedPK.equals(other.schoolattendedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Schoolattended[ schoolattendedPK=" + schoolattendedPK + " ]";
    }
    
}
