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
public class PayitemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemid")
    private int itemid;

    public PayitemPK() {
    }

    public PayitemPK(int id, int itemid) {
        this.id = id;
        this.itemid = itemid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) itemid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayitemPK)) {
            return false;
        }
        PayitemPK other = (PayitemPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.itemid != other.itemid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PayitemPK[ id=" + id + ", itemid=" + itemid + " ]";
    }
    
}
