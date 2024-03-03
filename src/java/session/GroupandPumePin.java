package session;

import entity.*;
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
public class GroupandPumePin {

    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)

    public void insertPinandGroup(String jambNo, String fullName, String pinNo, int serial, String password, String tellerNumber, HttpServletRequest request, String group) {
        try {
        //change this to pume pin

            Pin pin = addPin(serial, pinNo, jambNo, fullName, tellerNumber, request);
            Groups groups = addGroup(jambNo, serial, group);

            Users users = addUsers(jambNo, fullName, password);

        } catch (ConstraintViolationException e) {
            System.out.println("Ko Erro " + e.getConstraintViolations());
        }
    }

    //change this to pume pin
    private Pin addPin(int serial, String pinNo, String jambNo, String fullName, String tellerNumber, HttpServletRequest request) {
        Pin pin = new Pin();
        PinPK pinPk = new PinPK();
        pin.setSerialNo(serial);
        pinPk.setAccessCode(pinNo);
        pin.setPinPK(pinPk);
        pin.setSurname(jambNo);
        pin.setOtherNames(fullName);
        pin.setUserName(jambNo);
        pin.setPassword("BBBBBBB");
        pin.setTellerNo(tellerNumber);
        // pin.setCreator(request.getUserPrincipal().getName());
        pin.setCreator("ST" + request.getUserPrincipal().toString());
        em.persist(pin);
        return pin;
    }

    private Groups addGroup(String userName, int serial, String group) {
        // em.flush();
        Groups groups = new Groups();
        groups.setId(serial);
        groups.setUsername(userName);
        groups.setGroupname(group);
        em.persist(groups);
        return groups;

    }

    private Users addUsers(String userName, String name, String password) {
        // em.flush();
        Users users = new Users();
        users.setUsername(userName);
        users.setName(name);
        users.setPassword(password);
        users.setUsertype("pume");
        em.persist(users);
        return users;

    }
}
