

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "payitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payitem.findAll", query = "SELECT p FROM Payitem p"),
    @NamedQuery(name = "Payitem.findById", query = "SELECT p FROM Payitem p WHERE p.payitemPK.id = :id"),
    @NamedQuery(name = "Payitem.findByItemname", query = "SELECT p FROM Payitem p WHERE p.itemname = :itemname"),
    @NamedQuery(name = "Payitem.findByItemamount", query = "SELECT p FROM Payitem p WHERE p.itemamount = :itemamount"),
    @NamedQuery(name = "Payitem.findByItemid", query = "SELECT p FROM Payitem p WHERE p.payitemPK.itemid = :itemid")})
public class Payitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PayitemPK payitemPK;
    @Size(max = 45)
    @Column(name = "itemname")
    private String itemname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "itemamount")
    private BigDecimal itemamount;
    @JoinColumn(name = "itemid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bank bank;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "payitem")
    private Paiditems paiditems;

    public Payitem() {
    }

    public Payitem(PayitemPK payitemPK) {
        this.payitemPK = payitemPK;
    }

    public Payitem(int id, int itemid) {
        this.payitemPK = new PayitemPK(id, itemid);
    }

    public PayitemPK getPayitemPK() {
        return payitemPK;
    }

    public void setPayitemPK(PayitemPK payitemPK) {
        this.payitemPK = payitemPK;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public BigDecimal getItemamount() {
        return itemamount;
    }

    public void setItemamount(BigDecimal itemamount) {
        this.itemamount = itemamount;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Paiditems getPaiditems() {
        return paiditems;
    }

    public void setPaiditems(Paiditems paiditems) {
        this.paiditems = paiditems;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payitemPK != null ? payitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payitem)) {
            return false;
        }
        Payitem other = (Payitem) object;
        if ((this.payitemPK == null && other.payitemPK != null) || (this.payitemPK != null && !this.payitemPK.equals(other.payitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payitem[ payitemPK=" + payitemPK + " ]";
    }
    
}
