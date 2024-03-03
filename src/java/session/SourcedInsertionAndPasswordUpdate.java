package session;

import entity.De;
import entity.DePK;
import entity.Program;
import entity.Type;
import entity.Users;
import entity.Utme;
import entity.UtmePK;
import helper.HashedPasswordGenerator;
import helper.HttpURLConnectionExample;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SourcedInsertionAndPasswordUpdate {

    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addPinandUpdatePassword(String jambNo, String names, String state, String lga, char sex, String subject2, String subject3, String subject4, int totalScore, String gsm, String email, String session, Type type, Program program, Users user) {
        Utme utme = addUtme(jambNo, names, state, lga, sex, subject2, subject3, subject4, totalScore, gsm, email, session, type, program);
         editUser(user);
         HttpURLConnectionExample http = new HttpURLConnectionExample();
         http.sendMessage(gsm);

    }
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addPinandUpdateDePwd(String jambNo, String names, String state, String lga, char sex, String qualification, String courseStudied, String gradeObtained,   String gsm, String email, String session, Type type, Program program, Users user) {
     De de  = addDe(jambNo, names, state, lga, sex, qualification, courseStudied, gradeObtained, gsm, email, session, type, program);
         editUser(user);
         HttpURLConnectionExample http = new HttpURLConnectionExample();
         http.sendMessage(gsm);

    }

    private Utme addUtme(String jambNo, String names, String state, String lga, char sex, String subject2, String subject3, String subject4, int totalScore, String gsm, String email, String session, Type type, Program program) {
        Utme utme = new Utme();
        UtmePK utmePk = new UtmePK();
        utmePk.setJambNo(jambNo);
        utme.setName(names);
        utme.setState(state);
        utme.setLga(lga);
        utme.setSex(sex);
        utme.setSubject2(subject2);
        utme.setSubject3(subject3);
        utme.setSubject4(subject4);
        utme.setTotalScore(totalScore);
        utme.setTypeId(type);
        utme.setProgram(program);
        utme.setPume(0.0);
        utme.setSession("2015/2016");
        utme.setGsm(gsm);
        utme.setEmail(email);
        utme.setStatus("not Decided");
        utme.setAdmitted("NO");
         utme.setUtmePK(utmePk);
        em.persist(utme);

        return utme;
    }
    private void editUser(Users user){
        String text = "ANgama#";
        HashedPasswordGenerator hGen = new HashedPasswordGenerator();
        String updatePsswd = hGen.generateHash(text);
        user.setPassword(updatePsswd);
        em.merge(user);
        
    }

    private De addDe(String jambNo, String names, String state, String lga, char sex, String qualification, String courseStudied, String gradeObtained, String gsm, String email, String session, Type type, Program program) {
        De de = new De();
        DePK dePK = new    DePK();
        dePK.setJambNo(jambNo);
        de.setName(names);
        de.setState(state);
        de.setLga(lga);
        de.setSex(sex);
        de.setProgramme(qualification);
        de.setGrade(gradeObtained);
        de.setProgram(program);
        de.setGsm(gsm);
        de.setTypeId(type);
        de.setAdmitted("N");
             de.setEmail(email);
        de.setCourse(courseStudied);
        de.setGrade(gradeObtained);
        de.setSession("2015/2016");
          de.setDePK(dePK);
          em.persist(de);
    //    de.setCourseApplied(courseApplied);
        return de;
    }

}
