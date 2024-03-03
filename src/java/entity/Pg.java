/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "pg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pg.findAll", query = "SELECT p FROM Pg p"),
    @NamedQuery(name = "Pg.findById", query = "SELECT p FROM Pg p WHERE p.id = :id"),
    @NamedQuery(name = "Pg.findByProgram", query = "SELECT p FROM Pg p WHERE p.program = :program"),
    @NamedQuery(name = "Pg.findByName", query = "SELECT p FROM Pg p WHERE p.name = :name"),
    @NamedQuery(name = "Pg.findByGender", query = "SELECT p FROM Pg p WHERE p.gender = :gender"),
    @NamedQuery(name = "Pg.findByDob", query = "SELECT p FROM Pg p WHERE p.dob = :dob"),
    @NamedQuery(name = "Pg.findByMstatus", query = "SELECT p FROM Pg p WHERE p.mstatus = :mstatus"),
    @NamedQuery(name = "Pg.findByNationality", query = "SELECT p FROM Pg p WHERE p.nationality = :nationality"),
    @NamedQuery(name = "Pg.findByState", query = "SELECT p FROM Pg p WHERE p.state = :state"),
    @NamedQuery(name = "Pg.findByLga", query = "SELECT p FROM Pg p WHERE p.lga = :lga"),
    @NamedQuery(name = "Pg.findByPobirth", query = "SELECT p FROM Pg p WHERE p.pobirth = :pobirth"),
    @NamedQuery(name = "Pg.findByHtown", query = "SELECT p FROM Pg p WHERE p.htown = :htown"),
    @NamedQuery(name = "Pg.findByHqualification", query = "SELECT p FROM Pg p WHERE p.hqualification = :hqualification"),
    @NamedQuery(name = "Pg.findByGsm", query = "SELECT p FROM Pg p WHERE p.gsm = :gsm"),
    @NamedQuery(name = "Pg.findByEmail", query = "SELECT p FROM Pg p WHERE p.email = :email"),
    @NamedQuery(name = "Pg.findByPaddress", query = "SELECT p FROM Pg p WHERE p.paddress = :paddress"),
    @NamedQuery(name = "Pg.findBySpname", query = "SELECT p FROM Pg p WHERE p.spname = :spname"),
    @NamedQuery(name = "Pg.findBySpaddress", query = "SELECT p FROM Pg p WHERE p.spaddress = :spaddress"),
    @NamedQuery(name = "Pg.findByNok", query = "SELECT p FROM Pg p WHERE p.nok = :nok"),
    @NamedQuery(name = "Pg.findByNokaddress", query = "SELECT p FROM Pg p WHERE p.nokaddress = :nokaddress"),
    @NamedQuery(name = "Pg.findByNokrelation", query = "SELECT p FROM Pg p WHERE p.nokrelation = :nokrelation"),
    @NamedQuery(name = "Pg.findByNokphone", query = "SELECT p FROM Pg p WHERE p.nokphone = :nokphone"),
    @NamedQuery(name = "Pg.findByNokemail", query = "SELECT p FROM Pg p WHERE p.nokemail = :nokemail"),
    @NamedQuery(name = "Pg.findByExpuni", query = "SELECT p FROM Pg p WHERE p.expuni = :expuni"),
    @NamedQuery(name = "Pg.findByExpdate", query = "SELECT p FROM Pg p WHERE p.expdate = :expdate"),
    @NamedQuery(name = "Pg.findByExpreason", query = "SELECT p FROM Pg p WHERE p.expreason = :expreason"),
    @NamedQuery(name = "Pg.findByOtherinst", query = "SELECT p FROM Pg p WHERE p.otherinst = :otherinst"),
    @NamedQuery(name = "Pg.findByResearchexp", query = "SELECT p FROM Pg p WHERE p.researchexp = :researchexp"),
    @NamedQuery(name = "Pg.findByAppref", query = "SELECT p FROM Pg p WHERE p.appref = :appref")})
public class Pg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "program")
    private String program;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 10)
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 10)
    @Column(name = "mstatus")
    private String mstatus;
    @Size(max = 45)
    @Column(name = "nationality")
    private String nationality;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "lga")
    private String lga;
    @Size(max = 115)
    @Column(name = "pobirth")
    private String pobirth;
    @Size(max = 45)
    @Column(name = "htown")
    private String htown;
    @Size(max = 225)
    @Column(name = "hqualification")
    private String hqualification;
    @Size(max = 25)
    @Column(name = "gsm")
    private String gsm;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 335)
    @Column(name = "paddress")
    private String paddress;
    @Size(max = 205)
    @Column(name = "spname")
    private String spname;
    @Size(max = 205)
    @Column(name = "spaddress")
    private String spaddress;
    @Size(max = 105)
    @Column(name = "nok")
    private String nok;
    @Size(max = 305)
    @Column(name = "nokaddress")
    private String nokaddress;
    @Size(max = 105)
    @Column(name = "nokrelation")
    private String nokrelation;
    @Size(max = 25)
    @Column(name = "nokphone")
    private String nokphone;
    @Size(max = 45)
    @Column(name = "nokemail")
    private String nokemail;
    @Size(max = 125)
    @Column(name = "expuni")
    private String expuni;
    @Column(name = "expdate")
    @Temporal(TemporalType.DATE)
    private Date expdate;
    @Size(max = 205)
    @Column(name = "expreason")
    private String expreason;
    @Size(max = 105)
    @Column(name = "otherinst")
    private String otherinst;
    @Size(max = 400)
    @Column(name = "researchexp")
    private String researchexp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "appref")
    private String appref;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pg")
    private Collection<Schoolattended> schoolattendedCollection;

    public Pg() {
    }

    public Pg(Integer id) {
        this.id = id;
    }

    public Pg(Integer id, String appref) {
        this.id = id;
        this.appref = appref;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getPobirth() {
        return pobirth;
    }

    public void setPobirth(String pobirth) {
        this.pobirth = pobirth;
    }

    public String getHtown() {
        return htown;
    }

    public void setHtown(String htown) {
        this.htown = htown;
    }

    public String getHqualification() {
        return hqualification;
    }

    public void setHqualification(String hqualification) {
        this.hqualification = hqualification;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getSpaddress() {
        return spaddress;
    }

    public void setSpaddress(String spaddress) {
        this.spaddress = spaddress;
    }

    public String getNok() {
        return nok;
    }

    public void setNok(String nok) {
        this.nok = nok;
    }

    public String getNokaddress() {
        return nokaddress;
    }

    public void setNokaddress(String nokaddress) {
        this.nokaddress = nokaddress;
    }

    public String getNokrelation() {
        return nokrelation;
    }

    public void setNokrelation(String nokrelation) {
        this.nokrelation = nokrelation;
    }

    public String getNokphone() {
        return nokphone;
    }

    public void setNokphone(String nokphone) {
        this.nokphone = nokphone;
    }

    public String getNokemail() {
        return nokemail;
    }

    public void setNokemail(String nokemail) {
        this.nokemail = nokemail;
    }

    public String getExpuni() {
        return expuni;
    }

    public void setExpuni(String expuni) {
        this.expuni = expuni;
    }

    public Date getExpdate() {
        return expdate;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    public String getExpreason() {
        return expreason;
    }

    public void setExpreason(String expreason) {
        this.expreason = expreason;
    }

    public String getOtherinst() {
        return otherinst;
    }

    public void setOtherinst(String otherinst) {
        this.otherinst = otherinst;
    }

    public String getResearchexp() {
        return researchexp;
    }

    public void setResearchexp(String researchexp) {
        this.researchexp = researchexp;
    }

    public String getAppref() {
        return appref;
    }

    public void setAppref(String appref) {
        this.appref = appref;
    }

    @XmlTransient
    public Collection<Schoolattended> getSchoolattendedCollection() {
        return schoolattendedCollection;
    }

    public void setSchoolattendedCollection(Collection<Schoolattended> schoolattendedCollection) {
        this.schoolattendedCollection = schoolattendedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pg)) {
            return false;
        }
        Pg other = (Pg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pg[ id=" + id + " ]";
    }
    
}
