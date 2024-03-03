/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pumepin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pumepin.findAll", query = "SELECT p FROM Pumepin p"),
    @NamedQuery(name = "Pumepin.findById", query = "SELECT p FROM Pumepin p WHERE p.id = :id"),
    @NamedQuery(name = "Pumepin.findByJambno", query = "SELECT p FROM Pumepin p WHERE p.jambno = :jambno"),
    @NamedQuery(name = "Pumepin.findByPin", query = "SELECT p FROM Pumepin p WHERE p.pin = :pin"),
    @NamedQuery(name = "Pumepin.findByUsed", query = "SELECT p FROM Pumepin p WHERE p.used = :used"),
    @NamedQuery(name = "Pumepin.findByName", query = "SELECT p FROM Pumepin p WHERE p.name = :name")})
public class Pumepin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "jambno")
    private String jambno;
    @Size(max = 100)
    @Column(name = "pin")
    private String pin;
    @Column(name = "used")
    private Character used;
    @Size(max = 150)
    @Column(name = "name")
    private String name;

    public Pumepin() {
    }

    public Pumepin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJambno() {
        return jambno;
    }

    public void setJambno(String jambno) {
        this.jambno = jambno;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Character getUsed() {
        return used;
    }

    public void setUsed(Character used) {
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Pumepin)) {
            return false;
        }
        Pumepin other = (Pumepin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pumepin[ id=" + id + " ]";
    }
    
}
