/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.QaStudents;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Armayau
 */
@Stateless
public class QaStudentsFacade extends AbstractFacade<QaStudents> {
    @PersistenceContext(unitName = "AukNewPortalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QaStudentsFacade() {
        super(QaStudents.class);
    }
     public QaStudents findId(String idno) {
         String jamb = idno.trim();
        Query query = em.createNamedQuery("QaStudents.findByStudentid");
        query.setParameter("studentid", idno);
        return (QaStudents) query.getSingleResult();
    }
}
