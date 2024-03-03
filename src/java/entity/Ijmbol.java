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
@Table(name = "ijmbol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ijmbol.findAll", query = "SELECT i FROM Ijmbol i"),
    @NamedQuery(name = "Ijmbol.findById", query = "SELECT i FROM Ijmbol i WHERE i.id = :id"),
    @NamedQuery(name = "Ijmbol.findBySubject", query = "SELECT i FROM Ijmbol i WHERE i.subject = :subject"),
    @NamedQuery(name = "Ijmbol.findByGrade", query = "SELECT i FROM Ijmbol i WHERE i.grade = :grade"),
    @NamedQuery(name = "Ijmbol.findByExamination", query = "SELECT i FROM Ijmbol i WHERE i.examination = :examination")})
public class Ijmbol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "subject")
    private String subject;
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    @Size(max = 45)
    @Column(name = "examination")
    private String examination;
    @JoinColumn(name = "ijmb_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ijmb ijmbId;

    public Ijmbol() {
    }

    public Ijmbol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public Ijmb getIjmbId() {
        return ijmbId;
    }

    public void setIjmbId(Ijmb ijmbId) {
        this.ijmbId = ijmbId;
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
        if (!(object instanceof Ijmbol)) {
            return false;
        }
        Ijmbol other = (Ijmbol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ijmbol[ id=" + id + " ]";
    }
    
}
