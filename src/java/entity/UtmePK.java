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
import javax.validation.constraints.Size;

/**
 *
 * @author Armayau
 */
@Embeddable
public class UtmePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "jambNo")
    private String jambNo;

    public UtmePK() {
    }

    public UtmePK(int id, String jambNo) {
        this.id = id;
        this.jambNo = jambNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJambNo() {
        return jambNo;
    }

    public void setJambNo(String jambNo) {
        this.jambNo = jambNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (jambNo != null ? jambNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtmePK)) {
            return false;
        }
        UtmePK other = (UtmePK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.jambNo == null && other.jambNo != null) || (this.jambNo != null && !this.jambNo.equals(other.jambNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UtmePK[ id=" + id + ", jambNo=" + jambNo + " ]";
    }
    
}
