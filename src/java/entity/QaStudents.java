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
@Table(name = "qa_students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaStudents.findAll", query = "SELECT q FROM QaStudents q"),
    @NamedQuery(name = "QaStudents.findByBid", query = "SELECT q FROM QaStudents q WHERE q.bid = :bid"),
    @NamedQuery(name = "QaStudents.findByAddress", query = "SELECT q FROM QaStudents q WHERE q.address = :address"),
    @NamedQuery(name = "QaStudents.findByAmount", query = "SELECT q FROM QaStudents q WHERE q.amount = :amount"),
    @NamedQuery(name = "QaStudents.findByEmail", query = "SELECT q FROM QaStudents q WHERE q.email = :email"),
    @NamedQuery(name = "QaStudents.findByFirstname", query = "SELECT q FROM QaStudents q WHERE q.firstname = :firstname"),
    @NamedQuery(name = "QaStudents.findByLastname", query = "SELECT q FROM QaStudents q WHERE q.lastname = :lastname"),
    @NamedQuery(name = "QaStudents.findByPaymentstatus", query = "SELECT q FROM QaStudents q WHERE q.paymentstatus = :paymentstatus"),
    @NamedQuery(name = "QaStudents.findByPhone", query = "SELECT q FROM QaStudents q WHERE q.phone = :phone"),
    @NamedQuery(name = "QaStudents.findByStudentid", query = "SELECT q FROM QaStudents q WHERE q.studentid = :studentid"),
    @NamedQuery(name = "QaStudents.findByLga", query = "SELECT q FROM QaStudents q WHERE q.lga = :lga")})
public class QaStudents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid")
    private Long bid;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 255)
    @Column(name = "paymentstatus")
    private String paymentstatus;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "studentid")
    private String studentid;
    @Size(max = 255)
    @Column(name = "lga")
    private String lga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qaStudentsBid")
    private Collection<Payment> paymentCollection;

    public QaStudents() {
    }

    public QaStudents(Long bid) {
        this.bid = bid;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaStudents)) {
            return false;
        }
        QaStudents other = (QaStudents) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.QaStudents[ bid=" + bid + " ]";
    }
    
}
