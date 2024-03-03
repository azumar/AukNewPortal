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
@Table(name = "registeredcourse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registeredcourse.findAll", query = "SELECT r FROM Registeredcourse r"),
    @NamedQuery(name = "Registeredcourse.findByRegistrationId", query = "SELECT r FROM Registeredcourse r WHERE r.registrationId = :registrationId"),
    @NamedQuery(name = "Registeredcourse.findBySession", query = "SELECT r FROM Registeredcourse r WHERE r.session = :session"),
    @NamedQuery(name = "Registeredcourse.findBySemester", query = "SELECT r FROM Registeredcourse r WHERE r.semester = :semester"),
    @NamedQuery(name = "Registeredcourse.findByMarks", query = "SELECT r FROM Registeredcourse r WHERE r.marks = :marks"),
    @NamedQuery(name = "Registeredcourse.findByGrade", query = "SELECT r FROM Registeredcourse r WHERE r.grade = :grade"),
    @NamedQuery(name = "Registeredcourse.findByGp", query = "SELECT r FROM Registeredcourse r WHERE r.gp = :gp"),
    @NamedQuery(name = "Registeredcourse.findByClear", query = "SELECT r FROM Registeredcourse r WHERE r.clear = :clear"),
    @NamedQuery(name = "Registeredcourse.findByStudentId", query = "SELECT r FROM Registeredcourse r WHERE r.registeredcoursePK.studentId = :studentId"),
    @NamedQuery(name = "Registeredcourse.findByStudentregNo", query = "SELECT r FROM Registeredcourse r WHERE r.registeredcoursePK.studentregNo = :studentregNo"),
    @NamedQuery(name = "Registeredcourse.findByStudentProgramId", query = "SELECT r FROM Registeredcourse r WHERE r.registeredcoursePK.studentProgramId = :studentProgramId"),
    @NamedQuery(name = "Registeredcourse.findByStudentprogramprogramID", query = "SELECT r FROM Registeredcourse r WHERE r.registeredcoursePK.studentprogramprogramID = :studentprogramprogramID"),
    @NamedQuery(name = "Registeredcourse.findByCoursecourseCode", query = "SELECT r FROM Registeredcourse r WHERE r.registeredcoursePK.coursecourseCode = :coursecourseCode")})
public class Registeredcourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegisteredcoursePK registeredcoursePK;
    @Column(name = "registrationId")
    private Integer registrationId;
    @Size(max = 45)
    @Column(name = "session")
    private String session;
    @Column(name = "semester")
    private Integer semester;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "marks")
    private Double marks;
    @Column(name = "grade")
    private Character grade;
    @Column(name = "gp")
    private Integer gp;
    @Size(max = 45)
    @Column(name = "clear")
    private String clear;
    @JoinColumn(name = "course_courseCode", referencedColumnName = "courseCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "student_regNo", referencedColumnName = "regNo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Registeredcourse() {
    }

    public Registeredcourse(RegisteredcoursePK registeredcoursePK) {
        this.registeredcoursePK = registeredcoursePK;
    }

    public Registeredcourse(int studentId, String studentregNo, int studentProgramId, String studentprogramprogramID, String coursecourseCode) {
        this.registeredcoursePK = new RegisteredcoursePK(studentId, studentregNo, studentProgramId, studentprogramprogramID, coursecourseCode);
    }

    public RegisteredcoursePK getRegisteredcoursePK() {
        return registeredcoursePK;
    }

    public void setRegisteredcoursePK(RegisteredcoursePK registeredcoursePK) {
        this.registeredcoursePK = registeredcoursePK;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    public Integer getGp() {
        return gp;
    }

    public void setGp(Integer gp) {
        this.gp = gp;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registeredcoursePK != null ? registeredcoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registeredcourse)) {
            return false;
        }
        Registeredcourse other = (Registeredcourse) object;
        if ((this.registeredcoursePK == null && other.registeredcoursePK != null) || (this.registeredcoursePK != null && !this.registeredcoursePK.equals(other.registeredcoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Registeredcourse[ registeredcoursePK=" + registeredcoursePK + " ]";
    }
    
}
