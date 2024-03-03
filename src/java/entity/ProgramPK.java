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
public class ProgramPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "programID")
    private String programID;

    public ProgramPK() {
    }

    public ProgramPK(int id, String programID) {
        this.id = id;
        this.programID = programID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (programID != null ? programID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramPK)) {
            return false;
        }
        ProgramPK other = (ProgramPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.programID == null && other.programID != null) || (this.programID != null && !this.programID.equals(other.programID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProgramPK[ id=" + id + ", programID=" + programID + " ]";
    }
    
}
