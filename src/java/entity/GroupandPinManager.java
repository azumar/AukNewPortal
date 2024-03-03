/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Armayau
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GroupandPinManager {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;
 @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void  insertPinandGroup(String surName, String userName, String otherName, String pinNo, int  serial, String password,  String tellerNumber, HttpServletRequest request, String group) {
  try {       
        
       Pin  pin = addPin(serial, pinNo, surName, otherName,  userName, tellerNumber,request);
       Groups groups = addGroup(userName,serial, group);
       Users users = addUsers(userName, otherName, password);
        System.out.println("After Persisting");
       } catch (ConstraintViolationException e) {
       System.out.println("Ko Erro "+e.getConstraintViolations());
    }
    }
    
    private Pin addPin(int serial, String pinNo, String surName, String otherName, String userName, String tellerNumber,HttpServletRequest request)
    {
        Pin pin = new Pin();
           PinPK pinPk = new PinPK();
           pin.setSerialNo(serial);
           pinPk.setAccessCode(pinNo);
          pin.setPinPK(pinPk);
           pin.setSurname(surName);
           pin.setOtherNames(otherName);
           pin.setUserName(userName);
           pin.setPassword("BBBBBBB");
           pin.setTellerNo(tellerNumber);
          // pin.setCreator(request.getUserPrincipal().getName());
           pin.setCreator(request.getUserPrincipal().toString());
        em.persist(pin);
           return pin;
    }
   
    private Groups addGroup(String userName, int serial, String group)
    {
        // em.flush();
        Groups groups = new Groups();
        groups.setId(serial);
        groups.setUsername(userName);
        groups.setGroupname(group);
        em.persist(groups);
        return groups;
        
    }
    private Users addUsers(String userName, String name, String password)
    {
        // em.flush();
        Users users = new Users();
      users.setUsername(userName);
      users.setName(name);
      users.setPassword(password);
      users.setUsertype("sourced");
      em.persist(users);
        return users;
        
    }
}
