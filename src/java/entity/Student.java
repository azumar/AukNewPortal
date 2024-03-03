/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByRegNo", query = "SELECT s FROM Student s WHERE s.regNo = :regNo"),
    @NamedQuery(name = "Student.findByJambNo", query = "SELECT s FROM Student s WHERE s.jambNo = :jambNo"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Student.findByMiddleName", query = "SELECT s FROM Student s WHERE s.middleName = :middleName"),
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email"),
    @NamedQuery(name = "Student.findBySex", query = "SELECT s FROM Student s WHERE s.sex = :sex"),
    @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob"),
    @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = :nationality"),
    @NamedQuery(name = "Student.findBySstate", query = "SELECT s FROM Student s WHERE s.sstate = :sstate"),
    @NamedQuery(name = "Student.findByLga", query = "SELECT s FROM Student s WHERE s.lga = :lga"),
    @NamedQuery(name = "Student.findByTelephone", query = "SELECT s FROM Student s WHERE s.telephone = :telephone"),
    @NamedQuery(name = "Student.findByMStatus", query = "SELECT s FROM Student s WHERE s.mStatus = :mStatus"),
    @NamedQuery(name = "Student.findByReligion", query = "SELECT s FROM Student s WHERE s.religion = :religion"),
    @NamedQuery(name = "Student.findBySessionAdmitted", query = "SELECT s FROM Student s WHERE s.sessionAdmitted = :sessionAdmitted"),
    @NamedQuery(name = "Student.findByEntryMode", query = "SELECT s FROM Student s WHERE s.entryMode = :entryMode"),
    @NamedQuery(name = "Student.findByEntryLevel", query = "SELECT s FROM Student s WHERE s.entryLevel = :entryLevel"),
    @NamedQuery(name = "Student.findByCurrentLevel", query = "SELECT s FROM Student s WHERE s.currentLevel = :currentLevel"),
    @NamedQuery(name = "Student.findByHStatus", query = "SELECT s FROM Student s WHERE s.hStatus = :hStatus"),
    @NamedQuery(name = "Student.findByGraduated", query = "SELECT s FROM Student s WHERE s.graduated = :graduated"),
    @NamedQuery(name = "Student.findByHqualification", query = "SELECT s FROM Student s WHERE s.hqualification = :hqualification"),
    @NamedQuery(name = "Student.findByHqualDate", query = "SELECT s FROM Student s WHERE s.hqualDate = :hqualDate"),
    @NamedQuery(name = "Student.findByPhaddress", query = "SELECT s FROM Student s WHERE s.phaddress = :phaddress"),
    @NamedQuery(name = "Student.findByContactAddress", query = "SELECT s FROM Student s WHERE s.contactAddress = :contactAddress"),
    @NamedQuery(name = "Student.findByNoktelephone", query = "SELECT s FROM Student s WHERE s.noktelephone = :noktelephone"),
    @NamedQuery(name = "Student.findByNokAddress", query = "SELECT s FROM Student s WHERE s.nokAddress = :nokAddress"),
    @NamedQuery(name = "Student.findByNokrelationship", query = "SELECT s FROM Student s WHERE s.nokrelationship = :nokrelationship")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "regNo")
    private String regNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "jambNo")
    private String jambNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "middleName")
    private String middleName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 35)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 25)
    @Column(name = "nationality")
    private String nationality;
    @Size(max = 25)
    @Column(name = "sstate")
    private String sstate;
    @Size(max = 25)
    @Column(name = "lga")
    private String lga;
    @Size(max = 45)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 10)
    @Column(name = "mStatus")
    private String mStatus;
    @Size(max = 15)
    @Column(name = "religion")
    private String religion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "sessionAdmitted")
    private String sessionAdmitted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "entryMode")
    private String entryMode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entryLevel")
    private int entryLevel;
    @Column(name = "currentLevel")
    private Integer currentLevel;
    @Size(max = 15)
    @Column(name = "hStatus")
    private String hStatus;
    @Column(name = "graduated")
    private Character graduated;
    @Size(max = 75)
    @Column(name = "hqualification")
    private String hqualification;
    @Column(name = "hqualDate")
    @Temporal(TemporalType.DATE)
    private Date hqualDate;
    @Size(max = 150)
    @Column(name = "phaddress")
    private String phaddress;
    @Size(max = 150)
    @Column(name = "contactAddress")
    private String contactAddress;
    @Size(max = 70)
    @Column(name = "noktelephone")
    private String noktelephone;
    @Size(max = 150)
    @Column(name = "nokAddress")
    private String nokAddress;
    @Size(max = 150)
    @Column(name = "nokrelationship")
    private String nokrelationship;
    @JoinColumns({
        @JoinColumn(name = "program_id", referencedColumnName = "id"),
        @JoinColumn(name = "program_programID", referencedColumnName = "programID")})
    @ManyToOne(optional = false)
    private Program program;

    public Student() {
    }

    public Student(String regNo) {
        this.regNo = regNo;
    }

    public Student(String regNo, String jambNo, String firstName, String lastName, Date dob, String sessionAdmitted, String entryMode, int entryLevel) {
        this.regNo = regNo;
        this.jambNo = jambNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sessionAdmitted = sessionAdmitted;
        this.entryMode = entryMode;
        this.entryLevel = entryLevel;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getJambNo() {
        return jambNo;
    }

    public void setJambNo(String jambNo) {
        this.jambNo = jambNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMStatus() {
        return mStatus;
    }

    public void setMStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSessionAdmitted() {
        return sessionAdmitted;
    }

    public void setSessionAdmitted(String sessionAdmitted) {
        this.sessionAdmitted = sessionAdmitted;
    }

    public String getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }

    public int getEntryLevel() {
        return entryLevel;
    }

    public void setEntryLevel(int entryLevel) {
        this.entryLevel = entryLevel;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getHStatus() {
        return hStatus;
    }

    public void setHStatus(String hStatus) {
        this.hStatus = hStatus;
    }

    public Character getGraduated() {
        return graduated;
    }

    public void setGraduated(Character graduated) {
        this.graduated = graduated;
    }

    public String getHqualification() {
        return hqualification;
    }

    public void setHqualification(String hqualification) {
        this.hqualification = hqualification;
    }

    public Date getHqualDate() {
        return hqualDate;
    }

    public void setHqualDate(Date hqualDate) {
        this.hqualDate = hqualDate;
    }

    public String getPhaddress() {
        return phaddress;
    }

    public void setPhaddress(String phaddress) {
        this.phaddress = phaddress;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getNoktelephone() {
        return noktelephone;
    }

    public void setNoktelephone(String noktelephone) {
        this.noktelephone = noktelephone;
    }

    public String getNokAddress() {
        return nokAddress;
    }

    public void setNokAddress(String nokAddress) {
        this.nokAddress = nokAddress;
    }

    public String getNokrelationship() {
        return nokrelationship;
    }

    public void setNokrelationship(String nokrelationship) {
        this.nokrelationship = nokrelationship;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regNo != null ? regNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.regNo == null && other.regNo != null) || (this.regNo != null && !this.regNo.equals(other.regNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Student[ regNo=" + regNo + " ]";
    }
    
}
