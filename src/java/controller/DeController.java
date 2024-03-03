/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.De;
import entity.DePK;
import entity.Program;
import entity.Type;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.DeFacade;
import session.ProgramFacade;
import session.TypeFacade;

/**
 *
 * @author Armayau
 */
@WebServlet(name = "DeController", urlPatterns = {"/deList", "/newDe", "/newDe", "/deleteDe", "/deDeptDesicion"})
public class DeController extends HttpServlet {

    @EJB
    DeFacade deFacade;
    @EJB
    TypeFacade typeFacade;
    @EJB
    ProgramFacade programFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/deList")) {
            List<De> des = deFacade.findAll();
            request.setAttribute("des", des);
        } else if (userPath.equals("/deDeptDesicion")) {
            List<De> des = deFacade.findAll();
            request.setAttribute("des", des);

        } else if (userPath.equals("/somePath")) {
            int pinNo = Integer.parseInt(request.getQueryString());

        } else if (userPath.equals("/somethingElse1")) {

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/de/" + userPath + ".jsp";

        try {

            request.getRequestDispatcher(url).forward(request, response);
        } catch (NullPointerException e) {

            System.out.print(e.getMessage() + "Very Disturbing");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/deList")) {
            List<De> des = deFacade.findAll();
            request.setAttribute("des", des);
        } else if (userPath.equals("/deleteDe")) {
            if (request.getParameterMap().containsKey("jambNo")) { //check if any jamb No is slected
                String[] jambNos = request.getParameterValues("jambNo");
                try {
                    for (String jambNo : jambNos) {
                        De de = deFacade.findByJambNo(jambNo);
                        deFacade.remove(de);

                    }
                } catch (Exception ex) {

                }
            }

            List<De> des = deFacade.findAll();
            request.setAttribute("des", des);
            userPath = "/deList";

        } else if (userPath.equals("/deDeptDesicion")) {
            if (request.getParameterMap().containsKey("jambNo")) { //check if any jamb No is slected
                String[] jambNos = request.getParameterValues("jambNo");

                try {
                    for (String jambNo : jambNos) {

                        De de = deFacade.findByJambNo(jambNo);
                        String status = request.getParameter(jambNo);

                        de.setStatus(status);
                        deFacade.edit(de);

                    }
                } catch (Exception e) {
                    System.out.println("ERRO  " + e);
                }

            }
            List<De> des = deFacade.findAll();
            request.setAttribute("des", des);
            userPath = "/deList";

        } else if (userPath.equals("/newDe")) {
            String jabmNo = request.getParameter("jambNo");
            String names = request.getParameter("names");
            String state = request.getParameter("state");
            String lga = request.getParameter("lga");
            char sex = (request.getParameter("sex")).charAt(0);
            String qualification = request.getParameter("qualification");
            String courseStudied = request.getParameter("courseStudied");
            String gradeObtained = request.getParameter("gradeObtained");
            String email = request.getParameter("email");
            String gsm = request.getParameter("gsm");
            //email
            String course = request.getParameter("course");
//            double pume = Double.parseDouble(request.getParameter("pume"));
            String status = request.getParameter("status");

            String applicationType = request.getParameter("applicationType");
            if (applicationType.contains("SELECT")) {
                applicationType = "First Choice";
            }

            String session = request.getParameter("session");

            String admitted = request.getParameter("admitted");

            String isAdmitted = "NO";
            if (admitted != null && admitted.length() > 0) {
                isAdmitted = "YES";
            }

            De de = new De();
            DePK dePk = new DePK();
            Type type = typeFacade.findTypeByName(applicationType);
            Program program = programFacade.findProgramByName(course);
            dePk.setJambNo(jabmNo);
            de.setDePK(dePk);
            de.setTypeId(type);
            de.setProgram(program);
            de.setName(names);
            de.setState(state);
            de.setLga(lga);
            de.setSex(sex);
            de.setProgramme(qualification);
            de.setCourse(courseStudied);
            de.setGrade(gradeObtained);
            de.setSession(session);
            de.setStatus(status);
            de.setEmail(email);
            de.setGsm(gsm);
            de.setAdmitted(isAdmitted);
            deFacade.create(de);

            List<De> des = deFacade.findAll();
            request.setAttribute("des", des);
            userPath = "/deList";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/de/" + userPath + ".jsp";

        try {

            request.getRequestDispatcher(url).forward(request, response);
        } catch (NullPointerException e) { ////

            System.out.print(e.getMessage() + "Very Disturbing");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
