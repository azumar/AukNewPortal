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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDeptid", query = "SELECT d FROM Department d WHERE d.deptid = :deptid"),
    @NamedQuery(name = "Department.findByDepartmentName", query = "SELECT d FROM Department d WHERE d.departmentName = :departmentName"),
    @NamedQuery(name = "Department.findByHodName", query = "SELECT d FROM Department d WHERE d.hodName = :hodName")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deptid")
    private Integer deptid;
    @Size(max = 45)
    @Column(name = "departmentName")
    private String departmentName;
    @Size(max = 45)
    @Column(name = "hodName")
    private String hodName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentDeptid")
    private Collection<Program> programCollection;
    @JoinColumn(name = "college_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private College collegeId;

    public Department() {
    }

    public Department(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    @XmlTransient
    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public College getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(College collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptid != null ? deptid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.deptid == null && other.deptid != null) || (this.deptid != null && !this.deptid.equals(other.deptid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Department[ deptid=" + deptid + " ]";
    }
    
}
