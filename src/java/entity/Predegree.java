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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "predegree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predegree.findAll", query = "SELECT p FROM Predegree p"),
    @NamedQuery(name = "Predegree.findById", query = "SELECT p FROM Predegree p WHERE p.id = :id"),
    @NamedQuery(name = "Predegree.findBySurName", query = "SELECT p FROM Predegree p WHERE p.surName = :surName"),
    @NamedQuery(name = "Predegree.findByFirstName", query = "SELECT p FROM Predegree p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Predegree.findByOtherName", query = "SELECT p FROM Predegree p WHERE p.otherName = :otherName"),
    @NamedQuery(name = "Predegree.findByDob", query = "SELECT p FROM Predegree p WHERE p.dob = :dob"),
    @NamedQuery(name = "Predegree.findBySex", query = "SELECT p FROM Predegree p WHERE p.sex = :sex"),
    @NamedQuery(name = "Predegree.findByState", query = "SELECT p FROM Predegree p WHERE p.state = :state"),
    @NamedQuery(name = "Predegree.findByLga", query = "SELECT p FROM Predegree p WHERE p.lga = :lga"),
    @NamedQuery(name = "Predegree.findByAddress", query = "SELECT p FROM Predegree p WHERE p.address = :address"),
    @NamedQuery(name = "Predegree.findByLastSchool", query = "SELECT p FROM Predegree p WHERE p.lastSchool = :lastSchool"),
    @NamedQuery(name = "Predegree.findByEmail", query = "SELECT p FROM Predegree p WHERE p.email = :email"),
    @NamedQuery(name = "Predegree.findByGsm", query = "SELECT p FROM Predegree p WHERE p.gsm = :gsm")})
public class Predegree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 75)
    @Column(name = "surName")
    private String surName;
    @Size(max = 75)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 75)
    @Column(name = "otherName")
    private String otherName;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "lga")
    private String lga;
    @Size(max = 300)
    @Column(name = "address")
    private String address;
    @Size(max = 300)
    @Column(name = "lastSchool")
    private String lastSchool;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 75)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "gsm")
    private String gsm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predegree")
    private Collection<Pdolevel> pdolevelCollection;
    @JoinColumns({
        @JoinColumn(name = "program_id", referencedColumnName = "id"),
        @JoinColumn(name = "program_programID", referencedColumnName = "programID")})
    @ManyToOne(optional = false)
    private Program program;

    public Predegree() {
    }

    public Predegree(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastSchool() {
        return lastSchool;
    }

    public void setLastSchool(String lastSchool) {
        this.lastSchool = lastSchool;
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

    @XmlTransient
    public Collection<Pdolevel> getPdolevelCollection() {
        return pdolevelCollection;
    }

    public void setPdolevelCollection(Collection<Pdolevel> pdolevelCollection) {
        this.pdolevelCollection = pdolevelCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predegree)) {
            return false;
        }
        Predegree other = (Predegree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Predegree[ id=" + id + " ]";
    }
    
}
