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
@Table(name = "combination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combination.findAll", query = "SELECT c FROM Combination c"),
    @NamedQuery(name = "Combination.findById", query = "SELECT c FROM Combination c WHERE c.id = :id"),
    @NamedQuery(name = "Combination.findByCode", query = "SELECT c FROM Combination c WHERE c.code = :code"),
    @NamedQuery(name = "Combination.findBySubjects", query = "SELECT c FROM Combination c WHERE c.subjects = :subjects"),
    @NamedQuery(name = "Combination.findByPossibilities", query = "SELECT c FROM Combination c WHERE c.possibilities = :possibilities")})
public class Combination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 5)
    @Column(name = "code")
    private String code;
    @Size(max = 150)
    @Column(name = "subjects")
    private String subjects;
    @Size(max = 45)
    @Column(name = "possibilities")
    private String possibilities;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "combinationId")
    private Collection<Ijmb> ijmbCollection;

    public Combination() {
    }

    public Combination(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getPossibilities() {
        return possibilities;
    }

    public void setPossibilities(String possibilities) {
        this.possibilities = possibilities;
    }

    @XmlTransient
    public Collection<Ijmb> getIjmbCollection() {
        return ijmbCollection;
    }

    public void setIjmbCollection(Collection<Ijmb> ijmbCollection) {
        this.ijmbCollection = ijmbCollection;
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
        if (!(object instanceof Combination)) {
            return false;
        }
        Combination other = (Combination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Combination[ id=" + id + " ]";
    }
    
}
