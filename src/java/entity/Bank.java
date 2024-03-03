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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findById", query = "SELECT b FROM Bank b WHERE b.id = :id"),
    @NamedQuery(name = "Bank.findByBankname", query = "SELECT b FROM Bank b WHERE b.bankname = :bankname"),
    @NamedQuery(name = "Bank.findByAccounttype", query = "SELECT b FROM Bank b WHERE b.accounttype = :accounttype"),
    @NamedQuery(name = "Bank.findByAccountno", query = "SELECT b FROM Bank b WHERE b.accountno = :accountno")})
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "bankname")
    private String bankname;
    @Size(max = 45)
    @Column(name = "accounttype")
    private String accounttype;
    @Size(max = 45)
    @Column(name = "accountno")
    private String accountno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private Collection<Payitem> payitemCollection;

    public Bank() {
    }

    public Bank(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    @XmlTransient
    public Collection<Payitem> getPayitemCollection() {
        return payitemCollection;
    }

    public void setPayitemCollection(Collection<Payitem> payitemCollection) {
        this.payitemCollection = payitemCollection;
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
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bank[ id=" + id + " ]";
    }
    
}
