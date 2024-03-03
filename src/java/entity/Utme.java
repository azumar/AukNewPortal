/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "utme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utme.findAll", query = "SELECT u FROM Utme u"),
    @NamedQuery(name = "Utme.findById", query = "SELECT u FROM Utme u WHERE u.utmePK.id = :id"),
    @NamedQuery(name = "Utme.findByName", query = "SELECT u FROM Utme u WHERE u.name = :name"),
    @NamedQuery(name = "Utme.findByState", query = "SELECT u FROM Utme u WHERE u.state = :state"),
    @NamedQuery(name = "Utme.findByLga", query = "SELECT u FROM Utme u WHERE u.lga = :lga"),
    @NamedQuery(name = "Utme.findBySex", query = "SELECT u FROM Utme u WHERE u.sex = :sex"),
    @NamedQuery(name = "Utme.findByJambNo", query = "SELECT u FROM Utme u WHERE u.utmePK.jambNo = :jambNo"),
    @NamedQuery(name = "Utme.findBySubject2", query = "SELECT u FROM Utme u WHERE u.subject2 = :subject2"),
    @NamedQuery(name = "Utme.findBySubject3", query = "SELECT u FROM Utme u WHERE u.subject3 = :subject3"),
    @NamedQuery(name = "Utme.findBySubject4", query = "SELECT u FROM Utme u WHERE u.subject4 = :subject4"),
    @NamedQuery(name = "Utme.findByTotalScore", query = "SELECT u FROM Utme u WHERE u.totalScore = :totalScore"),
    @NamedQuery(name = "Utme.findByCourseApplied", query = "SELECT u FROM Utme u WHERE u.courseApplied = :courseApplied"),
    @NamedQuery(name = "Utme.findByStatus", query = "SELECT u FROM Utme u WHERE u.status = :status"),
    @NamedQuery(name = "Utme.findByPume", query = "SELECT u FROM Utme u WHERE u.pume = :pume"),
    @NamedQuery(name = "Utme.findBySession", query = "SELECT u FROM Utme u WHERE u.session = :session"),
    @NamedQuery(name = "Utme.findByEmail", query = "SELECT u FROM Utme u WHERE u.email = :email"),
    @NamedQuery(name = "Utme.findByGsm", query = "SELECT u FROM Utme u WHERE u.gsm = :gsm"),
    @NamedQuery(name = "Utme.findByAdmitted", query = "SELECT u FROM Utme u WHERE u.admitted = :admitted"),
    @NamedQuery(name = "Utme.findByAccessCode", query = "SELECT u FROM Utme u WHERE u.accessCode = :accessCode")})
public class Utme implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utme")
    private Pume pume1;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UtmePK utmePK;
    @Size(max = 75)
    @Column(name = "name")
    private String name;
    @Size(max = 35)
    @Column(name = "state")
    private String state;
    @Size(max = 35)
    @Column(name = "lga")
    private String lga;
    @Column(name = "sex")
    private Character sex;
    @Size(max = 75)
    @Column(name = "subject2")
    private String subject2;
    @Size(max = 75)
    @Column(name = "subject3")
    private String subject3;
    @Size(max = 75)
    @Column(name = "subject4")
    private String subject4;
    @Column(name = "totalScore")
    private Integer totalScore;
    @Size(max = 45)
    @Column(name = "courseApplied")
    private String courseApplied;
    @Size(max = 25)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pume")
    private Double pume;
    @Size(max = 15)
    @Column(name = "session")
    private String session;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "gsm")
    private String gsm;
    @Size(max = 15)
    @Column(name = "admitted")
    private String admitted;
    @Size(max = 100)
    @Column(name = "accessCode")
    private String accessCode;
    @JoinColumns({
        @JoinColumn(name = "program_programID", referencedColumnName = "id"),
        @JoinColumn(name = "courseId", referencedColumnName = "programID")})
    @ManyToOne
    private Program program;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Type typeId;

    public Utme() {
    }

    public Utme(UtmePK utmePK) {
        this.utmePK = utmePK;
    }

    public Utme(int id, String jambNo) {
        this.utmePK = new UtmePK(id, jambNo);
    }

    public UtmePK getUtmePK() {
        return utmePK;
    }

    public void setUtmePK(UtmePK utmePK) {
        this.utmePK = utmePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public String getSubject4() {
        return subject4;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getCourseApplied() {
        return courseApplied;
    }

    public void setCourseApplied(String courseApplied) {
        this.courseApplied = courseApplied;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPume() {
        return pume;
    }

    public void setPume(Double pume) {
        this.pume = pume;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getAdmitted() {
        return admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
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
        hash += (utmePK != null ? utmePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utme)) {
            return false;
        }
        Utme other = (Utme) object;
        if ((this.utmePK == null && other.utmePK != null) || (this.utmePK != null && !this.utmePK.equals(other.utmePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Utme[ utmePK=" + utmePK + " ]";
    }

    public Pume getPume1() {
        return pume1;
    }

    public void setPume1(Pume pume1) {
        this.pume1 = pume1;
    }
    
}
