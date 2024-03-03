package session;

import entity.Groups;
import entity.Users;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GroupsAndUsersManager {

    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertGroupAndUser(String name, String userName, String password, String userType, String branch, String gsm) {
        try{
        Users user = addUser(name,userName, password, userType, branch, gsm);
        Groups group = addGroup(userName, userType);
        }
        catch(Exception ex)
        {
            
        }

    }
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
//    public void deleteGroupAndUser(Users user, Groups group) {
//        try{
//        
//        em.remove(user);
//      
//        em.remove(group);
//        }
//        catch(Exception ex)
//        {
//            
//        }
//
//    }

    private Users addUser(String name, String userName, String password, String userType, String branch, String gsm) {
      
        Users user = new Users();
        user.setName(name);
        user.setUsername(userName);
        user.setPassword(password);
        user.setUsertype(userType);
        user.setBranch(branch);
        user.setGsm(gsm);
       em.persist(user);
        return user;
    }

    private Groups addGroup(String userName, String userType) {
        Groups group = new Groups();
        group.setUsername(userName);
        group.setGroupname(userType);
        em.persist(group);
        return group;
    }

    

}
