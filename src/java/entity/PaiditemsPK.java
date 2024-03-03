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
public class PaiditemsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "payitem_id")
    private int payitemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payitem_itemid")
    private int payitemItemid;

    public PaiditemsPK() {
    }

    public PaiditemsPK(int payitemId, int payitemItemid) {
        this.payitemId = payitemId;
        this.payitemItemid = payitemItemid;
    }

    public int getPayitemId() {
        return payitemId;
    }

    public void setPayitemId(int payitemId) {
        this.payitemId = payitemId;
    }

    public int getPayitemItemid() {
        return payitemItemid;
    }

    public void setPayitemItemid(int payitemItemid) {
        this.payitemItemid = payitemItemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) payitemId;
        hash += (int) payitemItemid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaiditemsPK)) {
            return false;
        }
        PaiditemsPK other = (PaiditemsPK) object;
        if (this.payitemId != other.payitemId) {
            return false;
        }
        if (this.payitemItemid != other.payitemItemid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PaiditemsPK[ payitemId=" + payitemId + ", payitemItemid=" + payitemItemid + " ]";
    }
    
}
