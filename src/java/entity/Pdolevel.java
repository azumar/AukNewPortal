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
@Table(name = "pdolevel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pdolevel.findAll", query = "SELECT p FROM Pdolevel p"),
    @NamedQuery(name = "Pdolevel.findById", query = "SELECT p FROM Pdolevel p WHERE p.pdolevelPK.id = :id"),
    @NamedQuery(name = "Pdolevel.findBySubject", query = "SELECT p FROM Pdolevel p WHERE p.subject = :subject"),
    @NamedQuery(name = "Pdolevel.findByGrade", query = "SELECT p FROM Pdolevel p WHERE p.grade = :grade"),
    @NamedQuery(name = "Pdolevel.findByExamination", query = "SELECT p FROM Pdolevel p WHERE p.examination = :examination"),
    @NamedQuery(name = "Pdolevel.findByPredegreeId", query = "SELECT p FROM Pdolevel p WHERE p.pdolevelPK.predegreeId = :predegreeId")})
public class Pdolevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PdolevelPK pdolevelPK;
    @Size(max = 45)
    @Column(name = "subject")
    private String subject;
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    @Size(max = 45)
    @Column(name = "examination")
    private String examination;
    @JoinColumn(name = "predegree_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Predegree predegree;

    public Pdolevel() {
    }

    public Pdolevel(PdolevelPK pdolevelPK) {
        this.pdolevelPK = pdolevelPK;
    }

    public Pdolevel(int id, int predegreeId) {
        this.pdolevelPK = new PdolevelPK(id, predegreeId);
    }

    public PdolevelPK getPdolevelPK() {
        return pdolevelPK;
    }

    public void setPdolevelPK(PdolevelPK pdolevelPK) {
        this.pdolevelPK = pdolevelPK;
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

    public Predegree getPredegree() {
        return predegree;
    }

    public void setPredegree(Predegree predegree) {
        this.predegree = predegree;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdolevelPK != null ? pdolevelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pdolevel)) {
            return false;
        }
        Pdolevel other = (Pdolevel) object;
        if ((this.pdolevelPK == null && other.pdolevelPK != null) || (this.pdolevelPK != null && !this.pdolevelPK.equals(other.pdolevelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pdolevel[ pdolevelPK=" + pdolevelPK + " ]";
    }
    
}
