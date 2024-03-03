/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "paiditems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiditems.findAll", query = "SELECT p FROM Paiditems p"),
    @NamedQuery(name = "Paiditems.findByPayitemId", query = "SELECT p FROM Paiditems p WHERE p.paiditemsPK.payitemId = :payitemId"),
    @NamedQuery(name = "Paiditems.findByPayitemItemid", query = "SELECT p FROM Paiditems p WHERE p.paiditemsPK.payitemItemid = :payitemItemid")})
public class Paiditems implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaiditemsPK paiditemsPK;
    @JoinColumns({
        @JoinColumn(name = "payitem_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "payitem_itemid", referencedColumnName = "itemid", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Payitem payitem;
    @JoinColumn(name = "payment_idpayment", referencedColumnName = "idpayment")
    @ManyToOne(optional = false)
    private Payment paymentIdpayment;

    public Paiditems() {
    }

    public Paiditems(PaiditemsPK paiditemsPK) {
        this.paiditemsPK = paiditemsPK;
    }

    public Paiditems(int payitemId, int payitemItemid) {
        this.paiditemsPK = new PaiditemsPK(payitemId, payitemItemid);
    }

    public PaiditemsPK getPaiditemsPK() {
        return paiditemsPK;
    }

    public void setPaiditemsPK(PaiditemsPK paiditemsPK) {
        this.paiditemsPK = paiditemsPK;
    }

    public Payitem getPayitem() {
        return payitem;
    }

    public void setPayitem(Payitem payitem) {
        this.payitem = payitem;
    }

    public Payment getPaymentIdpayment() {
        return paymentIdpayment;
    }

    public void setPaymentIdpayment(Payment paymentIdpayment) {
        this.paymentIdpayment = paymentIdpayment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiditemsPK != null ? paiditemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiditems)) {
            return false;
        }
        Paiditems other = (Paiditems) object;
        if ((this.paiditemsPK == null && other.paiditemsPK != null) || (this.paiditemsPK != null && !this.paiditemsPK.equals(other.paiditemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paiditems[ paiditemsPK=" + paiditemsPK + " ]";
    }
    
}
