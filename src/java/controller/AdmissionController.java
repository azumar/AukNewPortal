package controller;

import entity.Program;
import entity.Type;
import entity.Utme;
import entity.UtmePK;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.AcademicsessionFacade;
import session.ProgramFacade;
//import session.PumeFacade;
import session.TypeFacade;
import session.UsersFacade;
import session.UtmeFacade;

@WebServlet(name = "TheAdmissionController", loadOnStartup = 1, urlPatterns = {"/utme", "/utmeSearch", "/newUtme", "/addUtme", "/deleteUtme", "/utmeDetails", "/updateUtme", "/departmentDesicion", "/editPostUtme", "/finalApproval", "/logout", "/login"})
public class AdmissionController extends HttpServlet {

    @EJB
    private UtmeFacade utmeFacade;
    @EJB
    private ProgramFacade programeFacade;

    @EJB
    private AcademicsessionFacade academicSessionFacade;
    @EJB
    private TypeFacade typeFacade;

    @EJB
    private UsersFacade usersFacade;
//    @EJB
//    PumeFacade pumeFacade;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        getServletContext().setAttribute("programs", programeFacade.findAll());
        getServletContext().setAttribute("preprograms", programeFacade.findpreDegree());
        getServletContext().setAttribute("academicSessions", academicSessionFacade.findAll());
      //  getServletContext().setAttribute("types", typeFacade.findAll());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        HttpSession session = request.getSession(true);
        String userPath = request.getServletPath();
        if (userPath.equals("/editPostUtme")) {
            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
            // if utme is requested
        } else if (userPath.equals("/utme")) {
            //query and send all list
            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
//if departments made decisions
        } else if (userPath.equals("/finalApproval")) {
            //query and send all list
            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
//if departments made decisions
        } else if (userPath.equals("/departmentDesicion")) {
            //query and send all list
            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
//if details of a particular candidate is requested
        } else if (userPath.equals("/utmeDetails")) {
            String jambNo = request.getQueryString();

            if (jambNo != null) {//Check if jamb number is forwarded with the request

                Utme selectedUtme = utmeFacade.findByJambNo(jambNo);
                request.setAttribute("selectedUtme", selectedUtme);
            }

        } else if (userPath.equals("/logout")) {

            session = request.getSession();
            session.invalidate();

            userPath = "/login";

        } else if (userPath.equals("/login")) {

            response.setHeader("Location", "https://localhost:8181/AukNewPortal/bank");

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/utme/" + userPath + ".jsp";

        try {

            request.getRequestDispatcher(url).forward(request, response);
        } catch (NullPointerException e) { ////

            System.out.print(e.getMessage() + "Very Disturbing");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/something")) {
            if (request.getParameterMap().containsKey("jambNo")) { //check if any jamb No is slected
                String[] jambNos = request.getParameterValues("jambNo");

                try {
                    for (String jambNo : jambNos) {

                        Utme utme = utmeFacade.findByJambNo(jambNo);
                        double pume = Double.parseDouble(request.getParameter(jambNo));
                        System.out.println("PUME  " + pume);
                        utme.setPume(pume);
                        utmeFacade.edit(utme);

                    }
                } catch (Exception e) {
                    System.out.println("ERRO  " + e);
                }

            }

            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
            userPath = "/utme";

        } else if (userPath.equals("/utme")) {// if utme is selected via post method, usually for searching utme list using some criteria

            String program = request.getParameter("program");
            String academicSession = request.getParameter("academicSession");
            String applicationType = request.getParameter("applicationType");
            //if none of the criterial is selected
            if (program.contains("ALL") && academicSession.contains("ALL") && applicationType.contains("ALL")) { //send all list
                List<Utme> utmeList = utmeFacade.findAll();
                request.setAttribute("utmeList", utmeList);
            } else if (program.contains("ALL") && !academicSession.contains("ALL") && applicationType.contains("ALL")) {//if only session is selected
                List<Utme> utmeList = utmeFacade.findBySession(academicSession); //filter list by academic session
                request.setAttribute("utmeList", utmeList);
            } else if (!program.contains("ALL") && academicSession.contains("ALL") && applicationType.contains("ALL")) { //if only program is selected
                List<Utme> utmeList = utmeFacade.findByProgram(program); //ilter list byprogram
                request.setAttribute("utmeList", utmeList);
            } else if (program.contains("ALL") && academicSession.contains("ALL") && !applicationType.contains("ALL")) { //if only application type is selected
                List<Utme> utmeList = utmeFacade.findByType(applicationType); //filter list type - first choice or sourced
                request.setAttribute("utmeList", utmeList);
            } else if (!program.contains("ALL") && !academicSession.contains("ALL") && applicationType.contains("ALL")) {// if program and sessiona are selected
                List<Utme> utmeList = utmeFacade.findByProgramAndSession(academicSession, program);//filter list by program and session
                request.setAttribute("utmeList", utmeList);
            } else if (!program.contains("ALL") && academicSession.contains("ALL") && !applicationType.contains("ALL")) { // if program and apllication type are selected
                List<Utme> utmeList = utmeFacade.findByProgramAndType(program, applicationType); //filter list by program and application type
                request.setAttribute("utmeList", utmeList);
            } else if (program.contains("ALL") && !academicSession.contains("ALL") && !applicationType.contains("ALL")) { // if sessionand apllication type are selected
                List<Utme> utmeList = utmeFacade.findBySessionAndType(academicSession, applicationType); //filter list by session and application type
                request.setAttribute("utmeList", utmeList);
            } else if (!program.contains("ALL") && !academicSession.contains("ALL") && !applicationType.contains("ALL")) {//if all criteria are set
                List<Utme> utmeList = utmeFacade.findByProgramTypeAndSession(academicSession, program, applicationType);
                request.setAttribute("utmeList", utmeList);
            }
//if user request for deletion 
        } else if (userPath.equals("/deleteUtme")) {

            if (request.getParameterMap().containsKey("jambNo")) { //check if any jamb No is slected
                String[] jambNos = request.getParameterValues("jambNo");
                try {
                    for (String jambNo : jambNos) {
                        Utme utme = utmeFacade.findByJambNo(jambNo);
                        utmeFacade.remove(utme);

                    }
                } catch (Exception ex) {

                }
            }

            List<Utme> utmeList = utmeFacade.findAll();//query and send the list
            request.setAttribute("utmeList", utmeList);
            userPath = "/utme";// redirect to list path

        } else if (userPath.equals("/editPostUtme")) {

            if (request.getParameterMap().containsKey("jambNo")) { //check if any jamb No is slected
                String[] jambNos = request.getParameterValues("jambNo");

                try {
                    for (String jambNo : jambNos) {

                        Utme utme = utmeFacade.findByJambNo(jambNo);
                        double pume = Double.parseDouble(request.getParameter(jambNo));

                        utme.setPume(pume);
                        utmeFacade.edit(utme);

                    }
                } catch (Exception e) {
                    System.out.println("ERRO  " + e);
                }

            }

            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
            userPath = "/utme";

        } else if (userPath.equals("/utme")) { //if utme is requested

            List<Utme> utmeList = utmeFacade.findAll(); //query and send the list
            request.setAttribute("utmeList", utmeList);

        } else if (userPath.equals("/departmentDesicion")) {
            if (request.getParameterMap().containsKey("jambNo")) { //check if any jamb No is slected
                String[] jambNos = request.getParameterValues("jambNo");

                try {
                    for (String jambNo : jambNos) {

                        Utme utme = utmeFacade.findByJambNo(jambNo);
                        String status = request.getParameter(jambNo);
                        System.out.println("STATUS  " + status);
                        utme.setStatus(status);
                        utmeFacade.edit(utme);

                    }
                } catch (Exception e) {
                    System.out.println("ERRO  " + e);
                }

            }

            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
            userPath = "/utme";

        } else if (userPath.equals("/finalApproval")) {
            if (request.getParameterMap().containsKey("jambNo")) { //check if any jamb No is slected
                String[] jambNos = request.getParameterValues("jambNo");

                try {
                    for (String jambNo : jambNos) {

                        Utme utme = utmeFacade.findByJambNo(jambNo);
                        String admitted = request.getParameter(jambNo);

                        utme.setAdmitted(admitted);
                        utmeFacade.edit(utme);

                    }
                } catch (Exception e) {

                }

            }

            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);
            userPath = "/utme";

        } else if (userPath.equals("/addUtme") || userPath.equals("/updateUtme")) {

            String jabmNo = request.getParameter("jambNo");
            String names = request.getParameter("names");
            String state = request.getParameter("state");
            String lga = request.getParameter("lga");
            char sex = (request.getParameter("sex")).charAt(0);
            String subject2 = request.getParameter("subject2");
            String subject3 = request.getParameter("subject3");
            String subject4 = request.getParameter("subject4");
            int totalScore = Integer.parseInt(request.getParameter("totalScore"));
            String gsm = request.getParameter("gsm");
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

            Utme utme = new Utme();
            UtmePK utmePk = new UtmePK();
            utmePk.setJambNo(jabmNo);
            Type type = typeFacade.findTypeByName(applicationType);
            Program program = programeFacade.findProgramByName(course);

            utme.setName(names);
            utme.setState(state);
            utme.setLga(lga);
            utme.setSex(sex);
            utme.setSubject2(subject2);
            utme.setSubject3(subject3);
            utme.setSubject4(subject4);
            utme.setTotalScore(totalScore);
            //utme.setPume(pume);
            utme.setStatus(status);
            utme.setAdmitted(isAdmitted);
            utme.setTypeId(type);
            utme.setSession(session);
            utme.setPume(0.0);
            utme.setGsm(gsm);

            utme.setProgram(program);
            switch (userPath) {
                case "/addUtme":
                    boolean validationErrorFlag = false;
                    validationErrorFlag = utmeFacade.validUtme(jabmNo, request);
                    if (validationErrorFlag == true) {

                        request.setAttribute("validationErrorFlag", validationErrorFlag);

                    } else {
                        utme.setUtmePK(utmePk);
                        utmeFacade.create(utme);
                    }

                    break;
                case "/updateUtme":
                    double pume = Double.parseDouble(request.getParameter("pume"));
                    int id = Integer.parseInt(request.getParameter("id"));
                    utmePk.setId(id);
                    utme.setUtmePK(utmePk);
                    utme.setPume(pume);
                    utmeFacade.edit(utme);
                    break;
            }

            List<Utme> utmeList = utmeFacade.findAll();
            request.setAttribute("utmeList", utmeList);

            userPath = "/newUtme";
        } else if (userPath.equals("/pre-degree")) {

        } else if (userPath.equals("/utmeSearch")) {
            Utme singleCandidate = null;

            String jNo = request.getParameter("jNo");
            String gsmNo = request.getParameter("gsmNo");
            try {
                if (jNo.length() > 0 && gsmNo.length() < 1) {
                    singleCandidate = utmeFacade.findByJambNo(jNo);
                } else if (jNo.length() < 1 && gsmNo.length() > 0) {
                    singleCandidate = utmeFacade.findBygsmNo(gsmNo);
                } else if (jNo.length() > 0 && gsmNo.length() > 0) {
                    singleCandidate = utmeFacade.findBygsmandJambNo(jNo, gsmNo);
                }
            } catch (NoResultException e) {
                System.out.print(e.getMessage() + "Very Disturbing");
            }
            request.setAttribute("singleCandidate", singleCandidate);

            userPath = "/utme";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/utme/" + userPath + ".jsp";

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
