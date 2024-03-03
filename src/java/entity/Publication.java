/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "publication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p"),
    @NamedQuery(name = "Publication.findById", query = "SELECT p FROM Publication p WHERE p.publicationPK.id = :id"),
    @NamedQuery(name = "Publication.findByPu", query = "SELECT p FROM Publication p WHERE p.pu = :pu"),
    @NamedQuery(name = "Publication.findByPgId", query = "SELECT p FROM Publication p WHERE p.publicationPK.pgId = :pgId")})
public class Publication implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PublicationPK publicationPK;
    @Size(max = 335)
    @Column(name = "pu")
    private String pu;
    @JoinColumn(name = "pg_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pg pg;

    public Publication() {
    }

    public Publication(PublicationPK publicationPK) {
        this.publicationPK = publicationPK;
    }

    public Publication(int id, int pgId) {
        this.publicationPK = new PublicationPK(id, pgId);
    }

    public PublicationPK getPublicationPK() {
        return publicationPK;
    }

    public void setPublicationPK(PublicationPK publicationPK) {
        this.publicationPK = publicationPK;
    }

    public String getPu() {
        return pu;
    }

    public void setPu(String pu) {
        this.pu = pu;
    }

    public Pg getPg() {
        return pg;
    }

    public void setPg(Pg pg) {
        this.pg = pg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicationPK != null ? publicationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.publicationPK == null && other.publicationPK != null) || (this.publicationPK != null && !this.publicationPK.equals(other.publicationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Publication[ publicationPK=" + publicationPK + " ]";
    }
    
}
