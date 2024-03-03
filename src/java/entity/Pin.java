/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armayau
 */
@Entity
@Table(name = "pin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pin.findAll", query = "SELECT p FROM Pin p"),
    @NamedQuery(name = "Pin.findByPinId", query = "SELECT p FROM Pin p WHERE p.pinPK.pinId = :pinId"),
    @NamedQuery(name = "Pin.findBySerialNo", query = "SELECT p FROM Pin p WHERE p.serialNo = :serialNo"),
    @NamedQuery(name = "Pin.findByAccessCode", query = "SELECT p FROM Pin p WHERE p.pinPK.accessCode = :accessCode"),
    @NamedQuery(name = "Pin.findBySurname", query = "SELECT p FROM Pin p WHERE p.surname = :surname"),
    @NamedQuery(name = "Pin.findByOtherNames", query = "SELECT p FROM Pin p WHERE p.otherNames = :otherNames"),
    @NamedQuery(name = "Pin.findByUserName", query = "SELECT p FROM Pin p WHERE p.userName = :userName"),
    @NamedQuery(name = "Pin.findByPassword", query = "SELECT p FROM Pin p WHERE p.password = :password"),
    @NamedQuery(name = "Pin.findByStatus", query = "SELECT p FROM Pin p WHERE p.status = :status"),
    @NamedQuery(name = "Pin.findByCreator", query = "SELECT p FROM Pin p WHERE p.creator = :creator"),
    @NamedQuery(name = "Pin.findByTellerNo", query = "SELECT p FROM Pin p WHERE p.tellerNo = :tellerNo")})
public class Pin implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PinPK pinPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serialNo")
    private int serialNo;
    @Size(max = 45)
    @Column(name = "surname")
    private String surname;
    @Size(max = 45)
    @Column(name = "otherNames")
    private String otherNames;
    @Size(max = 255)
    @Column(name = "userName")
    private String userName;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 10)
    @Column(name = "status")
    private String status;
    @Size(max = 95)
    @Column(name = "creator")
    private String creator;
    @Size(max = 45)
    @Column(name = "tellerNo")
    private String tellerNo;

    public Pin() {
    }

    public Pin(PinPK pinPK) {
        this.pinPK = pinPK;
    }

    public Pin(PinPK pinPK, int serialNo) {
        this.pinPK = pinPK;
        this.serialNo = serialNo;
    }

    public Pin(int pinId, String accessCode) {
        this.pinPK = new PinPK(pinId, accessCode);
    }

    public PinPK getPinPK() {
        return pinPK;
    }

    public void setPinPK(PinPK pinPK) {
        this.pinPK = pinPK;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTellerNo() {
        return tellerNo;
    }

    public void setTellerNo(String tellerNo) {
        this.tellerNo = tellerNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinPK != null ? pinPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pin)) {
            return false;
        }
        Pin other = (Pin) object;
        if ((this.pinPK == null && other.pinPK != null) || (this.pinPK != null && !this.pinPK.equals(other.pinPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pin[ pinPK=" + pinPK + " ]";
    }
    
}
