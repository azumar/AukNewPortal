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
public class PumePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "utme_id")
    private int utmeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "utme_jambNo")
    private String utmejambNo;

    public PumePK() {
    }

    public PumePK(int utmeId, String utmejambNo) {
        this.utmeId = utmeId;
        this.utmejambNo = utmejambNo;
    }

    public int getUtmeId() {
        return utmeId;
    }

    public void setUtmeId(int utmeId) {
        this.utmeId = utmeId;
    }

    public String getUtmejambNo() {
        return utmejambNo;
    }

    public void setUtmejambNo(String utmejambNo) {
        this.utmejambNo = utmejambNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) utmeId;
        hash += (utmejambNo != null ? utmejambNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PumePK)) {
            return false;
        }
        PumePK other = (PumePK) object;
        if (this.utmeId != other.utmeId) {
            return false;
        }
        if ((this.utmejambNo == null && other.utmejambNo != null) || (this.utmejambNo != null && !this.utmejambNo.equals(other.utmejambNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PumePK[ utmeId=" + utmeId + ", utmejambNo=" + utmejambNo + " ]";
    }
    
}
