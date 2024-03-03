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
import javax.persistence.ManyToOne;
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
@Table(name = "ijmb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ijmb.findAll", query = "SELECT i FROM Ijmb i"),
    @NamedQuery(name = "Ijmb.findById", query = "SELECT i FROM Ijmb i WHERE i.id = :id"),
    @NamedQuery(name = "Ijmb.findBySurName", query = "SELECT i FROM Ijmb i WHERE i.surName = :surName"),
    @NamedQuery(name = "Ijmb.findByFirstName", query = "SELECT i FROM Ijmb i WHERE i.firstName = :firstName"),
    @NamedQuery(name = "Ijmb.findByOtherName", query = "SELECT i FROM Ijmb i WHERE i.otherName = :otherName"),
    @NamedQuery(name = "Ijmb.findByDob", query = "SELECT i FROM Ijmb i WHERE i.dob = :dob"),
    @NamedQuery(name = "Ijmb.findBySex", query = "SELECT i FROM Ijmb i WHERE i.sex = :sex"),
    @NamedQuery(name = "Ijmb.findByState", query = "SELECT i FROM Ijmb i WHERE i.state = :state"),
    @NamedQuery(name = "Ijmb.findByLga", query = "SELECT i FROM Ijmb i WHERE i.lga = :lga"),
    @NamedQuery(name = "Ijmb.findByAddress", query = "SELECT i FROM Ijmb i WHERE i.address = :address"),
    @NamedQuery(name = "Ijmb.findByLastSchool", query = "SELECT i FROM Ijmb i WHERE i.lastSchool = :lastSchool"),
    @NamedQuery(name = "Ijmb.findByEmail", query = "SELECT i FROM Ijmb i WHERE i.email = :email"),
    @NamedQuery(name = "Ijmb.findByGsm", query = "SELECT i FROM Ijmb i WHERE i.gsm = :gsm"),
    @NamedQuery(name = "Ijmb.findByAppref", query = "SELECT i FROM Ijmb i WHERE i.appref = :appref")})
public class Ijmb implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "appref")
    private String appref;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ijmbId")
    private Collection<Ijmbol> ijmbolCollection;
    @JoinColumn(name = "combination_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Combination combinationId;

    public Ijmb() {
    }

    public Ijmb(Integer id) {
        this.id = id;
    }

    public Ijmb(Integer id, String appref) {
        this.id = id;
        this.appref = appref;
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

    public String getAppref() {
        return appref;
    }

    public void setAppref(String appref) {
        this.appref = appref;
    }

    @XmlTransient
    public Collection<Ijmbol> getIjmbolCollection() {
        return ijmbolCollection;
    }

    public void setIjmbolCollection(Collection<Ijmbol> ijmbolCollection) {
        this.ijmbolCollection = ijmbolCollection;
    }

    public Combination getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Combination combinationId) {
        this.combinationId = combinationId;
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
        if (!(object instanceof Ijmb)) {
            return false;
        }
        Ijmb other = (Ijmb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ijmb[ id=" + id + " ]";
    }
    
}
