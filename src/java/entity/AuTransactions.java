/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "au_transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuTransactions.findAll", query = "SELECT a FROM AuTransactions a"),
    @NamedQuery(name = "AuTransactions.findByTid", query = "SELECT a FROM AuTransactions a WHERE a.tid = :tid"),
    @NamedQuery(name = "AuTransactions.findByAmount", query = "SELECT a FROM AuTransactions a WHERE a.amount = :amount"),
    @NamedQuery(name = "AuTransactions.findByCardNumber", query = "SELECT a FROM AuTransactions a WHERE a.cardNumber = :cardNumber"),
    @NamedQuery(name = "AuTransactions.findByLeadBankCbnCode", query = "SELECT a FROM AuTransactions a WHERE a.leadBankCbnCode = :leadBankCbnCode"),
    @NamedQuery(name = "AuTransactions.findByLeadBankName", query = "SELECT a FROM AuTransactions a WHERE a.leadBankName = :leadBankName"),
    @NamedQuery(name = "AuTransactions.findByMerchantReference", query = "SELECT a FROM AuTransactions a WHERE a.merchantReference = :merchantReference"),
    @NamedQuery(name = "AuTransactions.findByResponseCode", query = "SELECT a FROM AuTransactions a WHERE a.responseCode = :responseCode"),
    @NamedQuery(name = "AuTransactions.findByResponseDescription", query = "SELECT a FROM AuTransactions a WHERE a.responseDescription = :responseDescription"),
    @NamedQuery(name = "AuTransactions.findByRetrievalReferenceNumber", query = "SELECT a FROM AuTransactions a WHERE a.retrievalReferenceNumber = :retrievalReferenceNumber"),
    @NamedQuery(name = "AuTransactions.findBySplitAccounts", query = "SELECT a FROM AuTransactions a WHERE a.splitAccounts = :splitAccounts"),
    @NamedQuery(name = "AuTransactions.findByTransactionDate", query = "SELECT a FROM AuTransactions a WHERE a.transactionDate = :transactionDate"),
    @NamedQuery(name = "AuTransactions.findByTransactiondesc", query = "SELECT a FROM AuTransactions a WHERE a.transactiondesc = :transactiondesc"),
    @NamedQuery(name = "AuTransactions.findByTransactiontype", query = "SELECT a FROM AuTransactions a WHERE a.transactiontype = :transactiontype"),
    @NamedQuery(name = "AuTransactions.findByAmountdue", query = "SELECT a FROM AuTransactions a WHERE a.amountdue = :amountdue"),
    @NamedQuery(name = "AuTransactions.findByStudentid", query = "SELECT a FROM AuTransactions a WHERE a.studentid = :studentid"),
    @NamedQuery(name = "AuTransactions.findByTransactioncode", query = "SELECT a FROM AuTransactions a WHERE a.transactioncode = :transactioncode"),
    @NamedQuery(name = "AuTransactions.findByTransactionstatus", query = "SELECT a FROM AuTransactions a WHERE a.transactionstatus = :transactionstatus"),
    @NamedQuery(name = "AuTransactions.findByTranxdate", query = "SELECT a FROM AuTransactions a WHERE a.tranxdate = :tranxdate"),
    @NamedQuery(name = "AuTransactions.findByTxnref", query = "SELECT a FROM AuTransactions a WHERE a.txnref = :txnref")})
public class AuTransactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Long tid;
    @Size(max = 255)
    @Column(name = "Amount")
    private String amount;
    @Size(max = 255)
    @Column(name = "CardNumber")
    private String cardNumber;
    @Size(max = 255)
    @Column(name = "LeadBankCbnCode")
    private String leadBankCbnCode;
    @Size(max = 255)
    @Column(name = "LeadBankName")
    private String leadBankName;
    @Size(max = 255)
    @Column(name = "MerchantReference")
    private String merchantReference;
    @Size(max = 255)
    @Column(name = "ResponseCode")
    private String responseCode;
    @Size(max = 255)
    @Column(name = "ResponseDescription")
    private String responseDescription;
    @Size(max = 255)
    @Column(name = "RetrievalReferenceNumber")
    private String retrievalReferenceNumber;
    @Size(max = 255)
    @Column(name = "SplitAccounts")
    private String splitAccounts;
    @Size(max = 255)
    @Column(name = "TransactionDate")
    private String transactionDate;
    @Size(max = 255)
    @Column(name = "Transactiondesc")
    private String transactiondesc;
    @Size(max = 255)
    @Column(name = "Transactiontype")
    private String transactiontype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amountdue")
    private BigDecimal amountdue;
    @Size(max = 255)
    @Column(name = "studentid")
    private String studentid;
    @Size(max = 255)
    @Column(name = "transactioncode")
    private String transactioncode;
    @Size(max = 255)
    @Column(name = "transactionstatus")
    private String transactionstatus;
    @Column(name = "tranxdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranxdate;
    @Size(max = 255)
    @Column(name = "txnref")
    private String txnref;

    public AuTransactions() {
    }

    public AuTransactions(Long tid) {
        this.tid = tid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLeadBankCbnCode() {
        return leadBankCbnCode;
    }

    public void setLeadBankCbnCode(String leadBankCbnCode) {
        this.leadBankCbnCode = leadBankCbnCode;
    }

    public String getLeadBankName() {
        return leadBankName;
    }

    public void setLeadBankName(String leadBankName) {
        this.leadBankName = leadBankName;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public String getSplitAccounts() {
        return splitAccounts;
    }

    public void setSplitAccounts(String splitAccounts) {
        this.splitAccounts = splitAccounts;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactiondesc() {
        return transactiondesc;
    }

    public void setTransactiondesc(String transactiondesc) {
        this.transactiondesc = transactiondesc;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public BigDecimal getAmountdue() {
        return amountdue;
    }

    public void setAmountdue(BigDecimal amountdue) {
        this.amountdue = amountdue;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getTransactioncode() {
        return transactioncode;
    }

    public void setTransactioncode(String transactioncode) {
        this.transactioncode = transactioncode;
    }

    public String getTransactionstatus() {
        return transactionstatus;
    }

    public void setTransactionstatus(String transactionstatus) {
        this.transactionstatus = transactionstatus;
    }

    public Date getTranxdate() {
        return tranxdate;
    }

    public void setTranxdate(Date tranxdate) {
        this.tranxdate = tranxdate;
    }

    public String getTxnref() {
        return txnref;
    }

    public void setTxnref(String txnref) {
        this.txnref = txnref;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuTransactions)) {
            return false;
        }
        AuTransactions other = (AuTransactions) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AuTransactions[ tid=" + tid + " ]";
    }
    
}
