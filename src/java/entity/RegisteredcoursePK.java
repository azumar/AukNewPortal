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
public class RegisteredcoursePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "student_regNo")
    private String studentregNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_program_id")
    private int studentProgramId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "student_program_programID")
    private String studentprogramprogramID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "course_courseCode")
    private String coursecourseCode;

    public RegisteredcoursePK() {
    }

    public RegisteredcoursePK(int studentId, String studentregNo, int studentProgramId, String studentprogramprogramID, String coursecourseCode) {
        this.studentId = studentId;
        this.studentregNo = studentregNo;
        this.studentProgramId = studentProgramId;
        this.studentprogramprogramID = studentprogramprogramID;
        this.coursecourseCode = coursecourseCode;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentregNo() {
        return studentregNo;
    }

    public void setStudentregNo(String studentregNo) {
        this.studentregNo = studentregNo;
    }

    public int getStudentProgramId() {
        return studentProgramId;
    }

    public void setStudentProgramId(int studentProgramId) {
        this.studentProgramId = studentProgramId;
    }

    public String getStudentprogramprogramID() {
        return studentprogramprogramID;
    }

    public void setStudentprogramprogramID(String studentprogramprogramID) {
        this.studentprogramprogramID = studentprogramprogramID;
    }

    public String getCoursecourseCode() {
        return coursecourseCode;
    }

    public void setCoursecourseCode(String coursecourseCode) {
        this.coursecourseCode = coursecourseCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (studentregNo != null ? studentregNo.hashCode() : 0);
        hash += (int) studentProgramId;
        hash += (studentprogramprogramID != null ? studentprogramprogramID.hashCode() : 0);
        hash += (coursecourseCode != null ? coursecourseCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisteredcoursePK)) {
            return false;
        }
        RegisteredcoursePK other = (RegisteredcoursePK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if ((this.studentregNo == null && other.studentregNo != null) || (this.studentregNo != null && !this.studentregNo.equals(other.studentregNo))) {
            return false;
        }
        if (this.studentProgramId != other.studentProgramId) {
            return false;
        }
        if ((this.studentprogramprogramID == null && other.studentprogramprogramID != null) || (this.studentprogramprogramID != null && !this.studentprogramprogramID.equals(other.studentprogramprogramID))) {
            return false;
        }
        if ((this.coursecourseCode == null && other.coursecourseCode != null) || (this.coursecourseCode != null && !this.coursecourseCode.equals(other.coursecourseCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RegisteredcoursePK[ studentId=" + studentId + ", studentregNo=" + studentregNo + ", studentProgramId=" + studentProgramId + ", studentprogramprogramID=" + studentprogramprogramID + ", coursecourseCode=" + coursecourseCode + " ]";
    }
    
}
