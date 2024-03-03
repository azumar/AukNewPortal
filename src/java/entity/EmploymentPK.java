/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Armayau
 */
@Embeddable
public class EmploymentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pg_id")
    private int pgId;

    public EmploymentPK() {
    }

    public EmploymentPK(int id, int pgId) {
        this.id = id;
        this.pgId = pgId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPgId() {
        return pgId;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) pgId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmploymentPK)) {
            return false;
        }
        EmploymentPK other = (EmploymentPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.pgId != other.pgId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EmploymentPK[ id=" + id + ", pgId=" + pgId + " ]";
    }
    
}
