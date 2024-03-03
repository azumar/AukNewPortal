/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "employment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employment.findAll", query = "SELECT e FROM Employment e"),
    @NamedQuery(name = "Employment.findById", query = "SELECT e FROM Employment e WHERE e.employmentPK.id = :id"),
    @NamedQuery(name = "Employment.findByEmp", query = "SELECT e FROM Employment e WHERE e.emp = :emp"),
    @NamedQuery(name = "Employment.findByPosition", query = "SELECT e FROM Employment e WHERE e.position = :position"),
    @NamedQuery(name = "Employment.findByDate", query = "SELECT e FROM Employment e WHERE e.date = :date"),
    @NamedQuery(name = "Employment.findByPgId", query = "SELECT e FROM Employment e WHERE e.employmentPK.pgId = :pgId")})
public class Employment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmploymentPK employmentPK;
    @Size(max = 200)
    @Column(name = "emp")
    private String emp;
    @Size(max = 100)
    @Column(name = "position")
    private String position;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "pg_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pg pg;

    public Employment() {
    }

    public Employment(EmploymentPK employmentPK) {
        this.employmentPK = employmentPK;
    }

    public Employment(int id, int pgId) {
        this.employmentPK = new EmploymentPK(id, pgId);
    }

    public EmploymentPK getEmploymentPK() {
        return employmentPK;
    }

    public void setEmploymentPK(EmploymentPK employmentPK) {
        this.employmentPK = employmentPK;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        hash += (employmentPK != null ? employmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employment)) {
            return false;
        }
        Employment other = (Employment) object;
        if ((this.employmentPK == null && other.employmentPK != null) || (this.employmentPK != null && !this.employmentPK.equals(other.employmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employment[ employmentPK=" + employmentPK + " ]";
    }
    
}
