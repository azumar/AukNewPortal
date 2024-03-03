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
public class PinPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pinId")
    private int pinId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accessCode")
    private String accessCode;

    public PinPK() {
    }

    public PinPK(int pinId, String accessCode) {
        this.pinId = pinId;
        this.accessCode = accessCode;
    }

    public int getPinId() {
        return pinId;
    }

    public void setPinId(int pinId) {
        this.pinId = pinId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pinId;
        hash += (accessCode != null ? accessCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PinPK)) {
            return false;
        }
        PinPK other = (PinPK) object;
        if (this.pinId != other.pinId) {
            return false;
        }
        if ((this.accessCode == null && other.accessCode != null) || (this.accessCode != null && !this.accessCode.equals(other.accessCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PinPK[ pinId=" + pinId + ", accessCode=" + accessCode + " ]";
    }
    
}
