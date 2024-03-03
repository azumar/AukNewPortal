package controller;

import entity.Combination;
import entity.Ijmb;
import entity.Ijmbol;
import entity.Pdolevel;
import entity.PdolevelPK;
import entity.Predegree;
import entity.Program;
import entity.Pume;
import entity.PumePK;
import entity.Type;
import entity.Users;
import helper.General;
import helper.HashedPasswordGenerator;
import helper.HttpURLConnectionExample;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import session.CombinationFacade;
import session.IjmbFacade;
import session.IjmbolFacade;
import session.OlevelexamFacade;
import session.OlevelgradesFacade;
import session.OlevelsubjectFacade;
import session.PdolevelFacade;
import session.PredegreeFacade;
import session.ProgramFacade;
import session.PumeFacade;
import session.SourcedInsertionAndPasswordUpdate;
import session.TypeFacade;
import session.UsersFacade;
import session.UtmeFacade;

@WebServlet(name = "SourceController", urlPatterns = {"/sourcedUtme", "/slip","/ijslip", "/newSourcedUtme", "/deApplication", "/sourcedDe", "/savePume", "/predegree", "/savePreDegree", "/saveolevel", "/ijmb", "/save_ijmb", "/ijmb_ol"})
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB  
public class SourceController extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "/C:/Users/Public";//""   /C:/Users/Public

    @EJB
    UtmeFacade utmeFacade;
    @EJB
    TypeFacade typeFacade;
    @EJB
    ProgramFacade programFacade;
    @EJB
    UsersFacade usersFacade;
    @EJB
    SourcedInsertionAndPasswordUpdate sourcedInsertionAndPasswordUpdate;
    @EJB
    PumeFacade pumeFacade;
    @EJB
    PredegreeFacade preDegreeFacade;
    @EJB
    PdolevelFacade pdolevelFacade;
    @EJB
    private OlevelsubjectFacade olevelsubjectFacade;
    @EJB
    private OlevelgradesFacade olevelgradesFacade;
    @EJB
    private OlevelexamFacade olevelexamFacade;

    @EJB
    private CombinationFacade combinationFacade;
    @EJB
    private IjmbFacade ijmbFacade;
    @EJB
    private IjmbolFacade ijmbolFacade;

    @PersistenceContext(unitName = "AukNewPortalPU")
    EntityManager em;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        getServletContext().setAttribute("subjects", olevelsubjectFacade.findAll());
        getServletContext().setAttribute("grades", olevelgradesFacade.findAll());
        getServletContext().setAttribute("exams", olevelexamFacade.findAll());
        getServletContext().setAttribute("combinations", combinationFacade.findAll());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession(true);
        if (userPath.equals("/sourcedUtme")) {
            String name = request.getUserPrincipal().getName();
//            Users user = usersFacade.findUserByUserName(name);
            //  request.setAttribute("user", user);

            // if utme is requested
        } else if (userPath.equals("/deApplication")) {
            String name = request.getUserPrincipal().getName();
            //  Users user = usersFacade.findUserByUserName(name);
            //  request.setAttribute("user", user);
            //query and send all list

        } else if (userPath.equals("/predegree")) {

        } else if (userPath.equals("/slip")) {
            userPath = "/logout";//"/ijmb"
        } 
        else if (userPath.equals("/ijslip")) {//
             session = request.getSession();
            session.invalidate();
        }
        
        else if (userPath.equals("/ijmb")) {

        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/sourced/" + userPath + ".jsp";

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
        HttpSession session = request.getSession(true);
        String name = request.getUserPrincipal().getName();

        if (userPath.equals("/sourcedDe")) {
            String jambNo = request.getParameter("jambNo");
            String names = request.getParameter("names");
            String state = request.getParameter("state");
            String lga = request.getParameter("lga");
            char sex = (request.getParameter("sex")).charAt(0);
            String qualification = request.getParameter("qualification");
            String courseStudied = request.getParameter("courseStudied");
            String gradeObtained = request.getParameter("gradeObtained");
            String courseApplied = request.getParameter("course");
            String email = request.getParameter("email");
            String gsm = request.getParameter("gsm");
            String applicationType = "Sourced";
            Type type = typeFacade.findTypeByName(applicationType);
            Program program = programFacade.findProgramByName(courseApplied);
            Users user = usersFacade.findUserByUserName(name);
            System.out.println(user.getUsername());
            sourcedInsertionAndPasswordUpdate.addPinandUpdateDePwd(jambNo, names, state, lga, sex, qualification, courseStudied, gradeObtained, gsm, email, email, type, program, user);

            userPath = "/logout";
        } else if (userPath.equals("/newSourcedUtme")) {
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
            System.out.println(" GA COSS  " + course);
            String applicationType = "Sourced";
            Type type = typeFacade.findTypeByName(applicationType);
            Program program = programFacade.findProgramByName(course);
            Users user = usersFacade.findUserByUserName(name);

            sourcedInsertionAndPasswordUpdate.addPinandUpdatePassword(jabmNo, names, state, lga, sex, subject2, subject3, subject4, totalScore, gsm, lga, gsm, type, program, user);
            //  session =  request.getSession();

            userPath = "/logout";

            //session.invalidate();
        } else if (userPath.equals("/savePume")) {
            String pin = request.getParameter("pin");

            InputStream inputStream = null;

            // obtains the upload file part in this multipart request  
            Part filePart = request.getPart("photo");
            if (filePart != null) {
                inputStream = filePart.getInputStream();
                BufferedImage bImageFromConvert = ImageIO.read(inputStream);
                ImageIO.write(bImageFromConvert, "jpg", new File(pin + ".jpg")); //"C:/Users/Public" +
                Pume pUme = new Pume();
                PumePK pPk = new PumePK();
                pPk.setUtmejambNo(name);
                // pUme.s(Long.MIN_VALUE);
                //    pUme.setPin(pin);
                pUme.setPumePK(pPk);
                pUme.setSchedulle(name);
                byte[] passport = IOUtils.toByteArray(inputStream);
                // pUme.setPassport(passport);
                try {
                    pumeFacade.create(pUme);
                } catch (Exception ex) {
                    System.out.println("TELLE ME THE PROBMLEM   " + ex);
                }

            }
            System.out.println("WELCOME  POSTUTME");
            userPath = "/logout";
        } else if (userPath.equals("/saveolevel")) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            InputStream ioStream = null;

            OutputStream out = null;
            Predegree candidate = preDegreeFacade.findPredegreeByGsm(request.getParameter("gsm"));
            String subjects[] = request.getParameterValues("subject");
            String grades[] = request.getParameterValues("grade");
            String exams[] = request.getParameterValues("examType");
            List<Pdolevel> olevels = new ArrayList<Pdolevel>();
            for (int i = 0; i < subjects.length; i++) {
                //  System.out.println("SUBJECT " + i + subjects[i]);
                PdolevelPK pdk = new PdolevelPK();
                pdk.setPredegreeId(candidate.getId());
                Pdolevel pdol = new Pdolevel();
                pdol.setPredegree(candidate);
                pdol.setSubject(subjects[i]);
                pdol.setGrade(grades[i]);
                pdol.setExamination(exams[i]);
                pdol.setPdolevelPK(pdk);

                pdolevelFacade.create(pdol);
                olevels.add(pdol);

            }

            Part exam1 = request.getPart("result1");
            if (exam1.getSize() <= 524288 && exam1.getSize() > 0) {
                ioStream = exam1.getInputStream();
                BufferedImage bImageFromConvert = ImageIO.read(ioStream);
                if (bImageFromConvert != null) {
                    ImageIO.write(bImageFromConvert, "jpg", new File("/C:/Users/Public/ " + candidate.getId() + ".jpg")); //  C:/Users/Public/ 
                } else {
                    out = new FileOutputStream(new File(File.separator
                            + UPLOAD_DIRECTORY + candidate.getId() + ".pdf")); //
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = ioStream.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                }

            } else {
                String bigSize = "RESIZE The image!";
                System.out.println("SIZE TOO MUCH   " + bigSize);
                request.setAttribute("bigSize ", bigSize);
            }
            //////
            Part exam2 = request.getPart("result2");
            if (exam2.getSize() <= 524288 && exam2.getSize() > 0) {
                ioStream = exam2.getInputStream();
                BufferedImage bImageFromConvert = ImageIO.read(ioStream);
                if (bImageFromConvert != null) {
                    ImageIO.write(bImageFromConvert, "jpg", new File("/C:/Users/Public/ " + candidate.getId() + 1 + ".jpg")); //  C:/Users/Public/ /var/www/images/
                } else {
                    out = new FileOutputStream(new File(File.separator
                            + UPLOAD_DIRECTORY + candidate.getId() + ".pdf")); //
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = ioStream.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                }

            } else {
                String bigSize = "RESIZE The image!";
                System.out.println("SIZE TOO MUCH   " + bigSize);
                request.setAttribute("bigSize ", bigSize);
            }

//             InputStream ioStream1 = null;
//            Part exam2 = request.getPart("result2");
//            if (exam2.getSize() <= 524288 && exam2.getSize() > 0) {
//                ioStream1 = exam2.getInputStream();
//                BufferedImage bImageFromConvert = ImageIO.read(ioStream1);
//                if (bImageFromConvert != null) {
//                    ImageIO.write(bImageFromConvert, "jpg", new File(" /C:/Users/Public/ " + candidate.getId() + "_1" + ".jpg")); // C:/Users/Public/
//                } else {
//                    out = new FileOutputStream(new File(File.separator
//                            + UPLOAD_DIRECTORY + candidate.getId() + 1 + ".pdf")); //
//                    int read = 0;
//                    final byte[] bytes = new byte[1024];
//                    while ((read = ioStream.read(bytes)) != -1) {
//                        out.write(bytes, 0, read);
//                    }
//                }
//
//            } else {
//                String bigSize1 = "RESIZE The image!";
//                System.out.println("SIZE TOO MUCH   " + bigSize1);
//                request.setAttribute("bigSize ", bigSize1);
//            }
            HttpURLConnectionExample smessage = new HttpURLConnectionExample();
            smessage.sendMessage(request.getParameter("gsm"));
            Users user = usersFacade.findUserByUserName(name);
            String text = "ANgama#";

            HashedPasswordGenerator hGen = new HashedPasswordGenerator();
            String updatePsswd = hGen.generateHash(text);
            user.setPassword(updatePsswd);
            usersFacade.edit(user);

            request.setAttribute("olevels", olevels);
            request.setAttribute("candidate", candidate);
            userPath = "/slip";

        } else if (userPath.equals("/savePreDegree")) {//
            java.util.Date dob = null;
            String surname = request.getParameter("surname");
            String firstName = request.getParameter("firstName");
            String otherName = request.getParameter("oName");
            String state = request.getParameter("state");
            String lga = request.getParameter("lga");
            String address = request.getParameter("address");
            String sex = request.getParameter("sex");
            String programApplied = request.getParameter("course");
            String email = request.getParameter("email");
            String gsm = request.getParameter("gsm");
            String lastSchool = request.getParameter("lschool");
            Program program = programFacade.findProgramByName(programApplied);
            String dt = request.getParameter("dob");
            General g = new General();
            try {
                dob = g.createDate(dt);
            } catch (ParseException ex) {
                Logger.getLogger(SourceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Predegree pd = new Predegree();
            pd.setSurName(surname);
            pd.setFirstName(firstName);
            pd.setOtherName(otherName);
            pd.setAddress(address);
            pd.setDob(dob);
            pd.setState(state);
            pd.setLastSchool(lastSchool);
            pd.setLga(lga);
            pd.setProgram(program);
            pd.setSex(sex);
            pd.setEmail(email);
            pd.setGsm(gsm);

            try {
                preDegreeFacade.create(pd);

                em.flush();
            } catch (Exception c) {
                System.out.println("BA ID Error " + c);
            }
            Predegree predegreeCandidate = preDegreeFacade.findPredegreeByGsm(gsm);
            request.setAttribute("predegreeCandidate", predegreeCandidate);
            userPath = "/predegree";
        } else if (userPath.equals("/save_ijmb")) {
            try {
                String comb = request.getParameter("comb");
                Combination combination = combinationFacade.findProgramByName(comb);
                int count = ijmbFacade.countByName(combination);
                String surname = request.getParameter("surname");
                String firstName = request.getParameter("firstName");
                String otherName = request.getParameter("oName");
                String state = request.getParameter("state");
                String lga = request.getParameter("lga");
                String address = request.getParameter("address");
                String sex = request.getParameter("sex");

                String email = request.getParameter("email");
                String gsm = request.getParameter("gsm");
                String lastSchool = request.getParameter("lschool");

                String dt = request.getParameter("dob");
                General g = new General();
                Date db = g.createDate(dt);
                Ijmb ijmb = new Ijmb();
                String refnum = combination.getCode() + "2016" + count;

                ijmb.setSurName(surname);
                ijmb.setFirstName(firstName);
                ijmb.setOtherName(otherName);
                ijmb.setDob(db);
                ijmb.setSex(sex);
                ijmb.setState(state);
                ijmb.setLga(lga);
                ijmb.setAddress(address);
                ijmb.setLastSchool(lastSchool);
                ijmb.setEmail(email);
                ijmb.setGsm(gsm);
                ijmb.setCombinationId(combination);
                ijmb.setAppref(refnum);
                ijmbFacade.create(ijmb);
                Ijmb ijmbCandidate = ijmbFacade.finfByRefNum(refnum);

                request.setAttribute("ijmbCandidate", ijmbCandidate);
                userPath = "/ijmb";
            } catch (ParseException ex) {
                Logger.getLogger(SourceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/ijmb_ol")) {
            String refNum = request.getParameter("refNum");
            System.out.println("REF " + refNum);
            Ijmb ijmb = ijmbFacade.finfByRefNum(refNum);
            int ijid = ijmb.getId();
            String subjects[] = request.getParameterValues("subject");
            String grades[] = request.getParameterValues("grade");
            String exams[] = request.getParameterValues("exam");
            List<Ijmbol> ijmbol = new ArrayList<Ijmbol>();
            for (int i = 0; i < subjects.length; i++) {
                System.out.println("SUBJECT " + i + subjects[i]);

                Ijmbol ijol = new Ijmbol();
                ijol.setSubject(subjects[i]);
                ijol.setGrade(grades[i]);
                ijol.setExamination(exams[i]);
                ijol.setIjmbId(ijmb);
                ijmbolFacade.create(ijol);
                ijmbol.add(ijol);

            }
            HttpURLConnectionExample smessage = new HttpURLConnectionExample();
            smessage.sendMessage(request.getParameter("gsm"));
            Users user = usersFacade.findUserByUserName(name);
            String text = "ANgama#";

            HashedPasswordGenerator hGen = new HashedPasswordGenerator();
            String updatePsswd = hGen.generateHash(text);
            user.setPassword(updatePsswd);
            usersFacade.edit(user);
            request.setAttribute("olevels", ijmbol);
            request.setAttribute("candidate", ijmb);
            
            userPath = "/ijslip";
        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/sourced/" + userPath + ".jsp";

        try {

            request.getRequestDispatcher(url).forward(request, response);
        } catch (NullPointerException e) { ////

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
