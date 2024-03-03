/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findById", query = "SELECT p FROM Program p WHERE p.programPK.id = :id"),
    @NamedQuery(name = "Program.findByProgramID", query = "SELECT p FROM Program p WHERE p.programPK.programID = :programID"),
    @NamedQuery(name = "Program.findByProgramName", query = "SELECT p FROM Program p WHERE p.programName = :programName"),
    @NamedQuery(name = "Program.findByProgramDescription", query = "SELECT p FROM Program p WHERE p.programDescription = :programDescription"),
    @NamedQuery(name = "Program.findByLevel", query = "SELECT p FROM Program p WHERE p.level = :level")})
public class Program implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPK programPK;
    @Size(max = 45)
    @Column(name = "programName")
    private String programName;
    @Size(max = 45)
    @Column(name = "programDescription")
    private String programDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private int level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "department_deptid", referencedColumnName = "deptid")
    @ManyToOne(optional = false)
    private Department departmentDeptid;

    public Program() {
    }

    public Program(ProgramPK programPK) {
        this.programPK = programPK;
    }

    public Program(ProgramPK programPK, int level) {
        this.programPK = programPK;
        this.level = level;
    }

    public Program(int id, String programID) {
        this.programPK = new ProgramPK(id, programID);
    }

    public ProgramPK getProgramPK() {
        return programPK;
    }

    public void setProgramPK(ProgramPK programPK) {
        this.programPK = programPK;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Department getDepartmentDeptid() {
        return departmentDeptid;
    }

    public void setDepartmentDeptid(Department departmentDeptid) {
        this.departmentDeptid = departmentDeptid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programPK != null ? programPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.programPK == null && other.programPK != null) || (this.programPK != null && !this.programPK.equals(other.programPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Program[ programPK=" + programPK + " ]";
    }
    
}
