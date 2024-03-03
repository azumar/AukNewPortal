/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "de")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "De.findAll", query = "SELECT d FROM De d"),
    @NamedQuery(name = "De.findById", query = "SELECT d FROM De d WHERE d.dePK.id = :id"),
    @NamedQuery(name = "De.findByJambNo", query = "SELECT d FROM De d WHERE d.dePK.jambNo = :jambNo"),
    @NamedQuery(name = "De.findByName", query = "SELECT d FROM De d WHERE d.name = :name"),
    @NamedQuery(name = "De.findBySex", query = "SELECT d FROM De d WHERE d.sex = :sex"),
    @NamedQuery(name = "De.findByProgramme", query = "SELECT d FROM De d WHERE d.programme = :programme"),
    @NamedQuery(name = "De.findByCourse", query = "SELECT d FROM De d WHERE d.course = :course"),
    @NamedQuery(name = "De.findByGrade", query = "SELECT d FROM De d WHERE d.grade = :grade"),
    @NamedQuery(name = "De.findByState", query = "SELECT d FROM De d WHERE d.state = :state"),
    @NamedQuery(name = "De.findByLga", query = "SELECT d FROM De d WHERE d.lga = :lga"),
    @NamedQuery(name = "De.findByStatus", query = "SELECT d FROM De d WHERE d.status = :status"),
    @NamedQuery(name = "De.findBySession", query = "SELECT d FROM De d WHERE d.session = :session"),
    @NamedQuery(name = "De.findByAdmitted", query = "SELECT d FROM De d WHERE d.admitted = :admitted"),
    @NamedQuery(name = "De.findByEmail", query = "SELECT d FROM De d WHERE d.email = :email"),
    @NamedQuery(name = "De.findByCourseApplied", query = "SELECT d FROM De d WHERE d.courseApplied = :courseApplied"),
    @NamedQuery(name = "De.findByGsm", query = "SELECT d FROM De d WHERE d.gsm = :gsm"),
    @NamedQuery(name = "De.findByAccesCode", query = "SELECT d FROM De d WHERE d.accesCode = :accesCode")})
public class De implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DePK dePK;
    @Size(max = 75)
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private Character sex;
    @Size(max = 10)
    @Column(name = "programme")
    private String programme;
    @Size(max = 45)
    @Column(name = "course")
    private String course;
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "lga")
    private String lga;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 15)
    @Column(name = "session")
    private String session;
    @Size(max = 15)
    @Column(name = "admitted")
    private String admitted;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 75)
    @Column(name = "courseApplied")
    private String courseApplied;
    @Size(max = 15)
    @Column(name = "gsm")
    private String gsm;
    @Size(max = 100)
    @Column(name = "accesCode")
    private String accesCode;
    @JoinColumns({
        @JoinColumn(name = "program_programID", referencedColumnName = "id"),
        @JoinColumn(name = "couseRecommended", referencedColumnName = "programID")})
    @ManyToOne(optional = false)
    private Program program;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Type typeId;

    public De() {
    }

    public De(DePK dePK) {
        this.dePK = dePK;
    }

    public De(int id, String jambNo) {
        this.dePK = new DePK(id, jambNo);
    }

    public DePK getDePK() {
        return dePK;
    }

    public void setDePK(DePK dePK) {
        this.dePK = dePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getAdmitted() {
        return admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseApplied() {
        return courseApplied;
    }

    public void setCourseApplied(String courseApplied) {
        this.courseApplied = courseApplied;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getAccesCode() {
        return accesCode;
    }

    public void setAccesCode(String accesCode) {
        this.accesCode = accesCode;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dePK != null ? dePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof De)) {
            return false;
        }
        De other = (De) object;
        if ((this.dePK == null && other.dePK != null) || (this.dePK != null && !this.dePK.equals(other.dePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.De[ dePK=" + dePK + " ]";
    }
    
}
