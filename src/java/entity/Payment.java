/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByIdpayment", query = "SELECT p FROM Payment p WHERE p.idpayment = :idpayment"),
    @NamedQuery(name = "Payment.findByDataCreated", query = "SELECT p FROM Payment p WHERE p.dataCreated = :dataCreated"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount"),
    @NamedQuery(name = "Payment.findByRegLevel", query = "SELECT p FROM Payment p WHERE p.regLevel = :regLevel")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpayment")
    private Integer idpayment;
    @Column(name = "data_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreated;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Size(max = 45)
    @Column(name = "regLevel")
    private String regLevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentIdpayment")
    private Collection<Paiditems> paiditemsCollection;
    @JoinColumn(name = "qa_students_bid", referencedColumnName = "bid")
    @ManyToOne(optional = false)
    private QaStudents qaStudentsBid;

    public Payment() {
    }

    public Payment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public Integer getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Date dataCreated) {
        this.dataCreated = dataCreated;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRegLevel() {
        return regLevel;
    }

    public void setRegLevel(String regLevel) {
        this.regLevel = regLevel;
    }

    @XmlTransient
    public Collection<Paiditems> getPaiditemsCollection() {
        return paiditemsCollection;
    }

    public void setPaiditemsCollection(Collection<Paiditems> paiditemsCollection) {
        this.paiditemsCollection = paiditemsCollection;
    }

    public QaStudents getQaStudentsBid() {
        return qaStudentsBid;
    }

    public void setQaStudentsBid(QaStudents qaStudentsBid) {
        this.qaStudentsBid = qaStudentsBid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpayment != null ? idpayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idpayment == null && other.idpayment != null) || (this.idpayment != null && !this.idpayment.equals(other.idpayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payment[ idpayment=" + idpayment + " ]";
    }
    
}
