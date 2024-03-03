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
import javax.persistence.Id;
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
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseCode", query = "SELECT c FROM Course c WHERE c.courseCode = :courseCode"),
    @NamedQuery(name = "Course.findByCouseTitle", query = "SELECT c FROM Course c WHERE c.couseTitle = :couseTitle"),
    @NamedQuery(name = "Course.findByUnit", query = "SELECT c FROM Course c WHERE c.unit = :unit"),
    @NamedQuery(name = "Course.findByClevel", query = "SELECT c FROM Course c WHERE c.clevel = :clevel"),
    @NamedQuery(name = "Course.findByStatus", query = "SELECT c FROM Course c WHERE c.status = :status")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "courseCode")
    private String courseCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "couseTitle")
    private String couseTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit")
    private int unit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clevel")
    private int clevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<Registeredcourse> registeredcourseCollection;

    public Course() {
    }

    public Course(String courseCode) {
        this.courseCode = courseCode;
    }

    public Course(String courseCode, String couseTitle, int unit, int clevel, String status) {
        this.courseCode = courseCode;
        this.couseTitle = couseTitle;
        this.unit = unit;
        this.clevel = clevel;
        this.status = status;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCouseTitle() {
        return couseTitle;
    }

    public void setCouseTitle(String couseTitle) {
        this.couseTitle = couseTitle;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getClevel() {
        return clevel;
    }

    public void setClevel(int clevel) {
        this.clevel = clevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Registeredcourse> getRegisteredcourseCollection() {
        return registeredcourseCollection;
    }

    public void setRegisteredcourseCollection(Collection<Registeredcourse> registeredcourseCollection) {
        this.registeredcourseCollection = registeredcourseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseCode != null ? courseCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseCode == null && other.courseCode != null) || (this.courseCode != null && !this.courseCode.equals(other.courseCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Course[ courseCode=" + courseCode + " ]";
    }
    
}
