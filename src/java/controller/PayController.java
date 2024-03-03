package controller;

import cart.RegistrationCart;

import entity.Employment;
import entity.EmploymentPK;
import entity.Payitem;
import entity.Pg;
import entity.Publication;
import entity.PublicationPK;
import entity.QaStudents;
import entity.Referee;
import entity.RefereePK;
import entity.Schoolattended;
import entity.SchoolattendedPK;
import helper.General;
import helper.HttpURLConnectionExample;
import helper.PgSMS;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
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
import session.EmploymentFacade;
import session.PayitemFacade;
import session.PaymentFacade;
import session.PgFacade;
import session.PublicationFacade;
import session.QaStudentsFacade;
import session.RefereeFacade;
import session.SchoolattendedFacade;
import session.StudentFacade;

/**
 *
 * @author Armayau
 */
@WebServlet(name = "PayController", urlPatterns = {"/pg", "/save_pg", "/save_pub", "/save_empl","/save_pgimage", "/save_all", "/pay", "/sdetail", "/sciencepay", "/addToCart",
    "/viewCart",
    "/updateCart",
    "/checkout",
    "/purchase", "/philip","/feeone"})
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB  

public class PayController extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "/var/www/images";//""   /C:/Users/Public

    @EJB
    private StudentFacade studentFacade;
    @EJB
    private PaymentFacade paymentFacade;
    @EJB
    private PayitemFacade payitemFacade;
    @EJB
    QaStudentsFacade qaStudentsFacade;
    @EJB
    PgFacade pgFacade;

    @EJB
    EmploymentFacade employmentFacade;

    @EJB
    SchoolattendedFacade schoolattendedFacade;
    @EJB
    PublicationFacade publicationFacade;
    @EJB
    RefereeFacade refreeFacade;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

        // initialize servlet with configuration information
        // store category list in servlet context
        getServletContext().setAttribute("services", payitemFacade.findAll());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        if (userPath.equals("/pay")) {

        } else if (userPath.equals("/viewCart")) {
            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                RegistrationCart cart = (RegistrationCart) session.getAttribute("cart");
                cart.clear();
            }

            userPath = "/cart";
        } else if (userPath.equals("/checkout")) {

            RegistrationCart cart = (RegistrationCart) session.getAttribute("cart");

            // calculate total
            // cart.calculateTotal(surcharge);
            // forward to checkout page and switch to a secure channel
            // if user switches language
        } else if (userPath.equals("/pg")) {

        }
else if (userPath.equals("/philip")) {

        }
//else if (userPath.equals("/feeone")) {
//
//        }//
        String url = "/WEB-INF/pay/" + userPath + ".jsp";

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
        HttpSession session = request.getSession();
        RegistrationCart cart = (RegistrationCart) session.getAttribute("cart");
        if (userPath.equals("/sdetail")) {
//            String regNo = request.getParameter("regNo");
//            QaStudents student = qaStudentsFacade.findId(regNo);
//            System.out.println("Ga student " + student.getFirstname());
//            request.setAttribute("studentDetails", student);
//            session.setAttribute("studentDetails", student);
//            userPath = "/pay";
        } else if (userPath.equals("/save_pg")) {
            try {
                String program = request.getParameter("program");
                String name = request.getParameter("name");
                String dob = request.getParameter("dob");
                String gender = request.getParameter("gender");
                String mstatus = request.getParameter("mstatus");
                String nationality = request.getParameter("nationality");
                String state = request.getParameter("state");
                String lga = request.getParameter("lga");
                String pbirth = request.getParameter("pbirth");
                String htown = request.getParameter("htown");
                String hqualification = request.getParameter("hqualification");
                String gsm = request.getParameter("gsm");
                String email = request.getParameter("email");
                String paddress = request.getParameter("paddress");
                String spname = request.getParameter("spname");
                String spaddress = request.getParameter("spaddress");
                String nok = request.getParameter("nok");
                String nokaddress = request.getParameter("nokaddress");
                String nokrelation = request.getParameter("nokrelation");
                String nokphone = request.getParameter("nokphone");
                String nokemail = request.getParameter("nokemail");
                String expuni = request.getParameter("expuni");
                String expdate = request.getParameter("expdate");
                if (expdate.isEmpty()) {
                    expdate = "0/0/000";
                }
                String expreason = request.getParameter("expreason");
                String oherinst = request.getParameter("oherinst");
                String rcexp = request.getParameter("rcexp");
                General g = new General();
                java.util.Date dateExpelled = g.createDate(expdate);
                java.util.Date dtbirth = g.createDate(dob);
                int count = pgFacade.countByName(program);
                count += 1;
                String ref = program.concat("2016") + count;
                Pg pg = new Pg();
                pg.setName(name);
                pg.setProgram(program);
                pg.setDob(dtbirth);
                pg.setGender(gender);
                pg.setMstatus(mstatus);
                pg.setNationality(nationality);
                pg.setState(state);
                pg.setLga(lga);
                pg.setPobirth(pbirth);
                pg.setHtown(htown);
                pg.setHqualification(hqualification);
                pg.setGsm(gsm);
                pg.setEmail(email);
                pg.setPaddress(paddress);
                pg.setSpname(spname);
                pg.setSpaddress(spaddress);
                pg.setNok(nok);
                pg.setNokaddress(nokaddress);
                pg.setNokrelation(nokrelation);
                pg.setNokphone(nokphone);
                pg.setNokemail(nokemail);
                pg.setExpuni(expuni);
                pg.setExpdate(dateExpelled);
                pg.setExpreason(expreason);
                pg.setOtherinst(oherinst);
                pg.setResearchexp(rcexp);
                pg.setAppref(ref);
                pgFacade.create(pg);
                userPath = "/pg";
                  
                Pg pginfo = pgFacade.findByrefNo(ref);
                request.setAttribute("pginfo", pginfo);
            } catch (ParseException ex) {
                Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/save_pgimage")) {
            String refNum = (String)session.getAttribute("pgdetails");
         //   String refNum = request.getParameter("refNum");
            System.out.println("Ga refnum " + refNum);
            Pg pgApplicant = pgFacade.findByrefNo(refNum);

            int appid = pgApplicant.getId();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            InputStream ioStream = null;
            OutputStream out = null;
            Part exam1 = request.getPart("result1");
            if (exam1.getSize() <= 524288 && exam1.getSize() > 0) {
                ioStream = exam1.getInputStream();
                BufferedImage bImageFromConvert = ImageIO.read(ioStream);
                if (bImageFromConvert != null) {
                    ImageIO.write(bImageFromConvert, "jpg", new File("/var/www/images/ " + pgApplicant.getAppref() + ".jpg")); //  C:/Users/Public/ 
                } else {
                    out = new FileOutputStream(new File(File.separator
                            + UPLOAD_DIRECTORY + pgApplicant.getAppref() + ".pdf")); //
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
//            HttpURLConnectionExample txt1 = new HttpURLConnectionExample();
//            txt1.sendMessage(pgFacade.findByrefNo(refNum).getGsm());
           PgSMS txt = new PgSMS();
           txt.sendMessage(pgFacade.findByrefNo(refNum).getGsm());
            
            userPath = "/pgslip";
            request.setAttribute("evidence",  pgApplicant);
           

        } else if (userPath.equals("/save_empl")) {

        } else if (userPath.equals("/save_all")) {

            String refNum = request.getParameter("refNum");
            System.out.println("Ga refnum " + refNum);
            Pg pgApplicant = pgFacade.findByrefNo(refNum);

            int appid = pgApplicant.getId();

            String schools[] = request.getParameterValues("school");
            String froms[] = request.getParameterValues("from");
            String tos[] = request.getParameterValues("to");
            String certs[] = request.getParameterValues("cert");

            String employments[] = request.getParameterValues("employment");
            String posts[] = request.getParameterValues("posth");
            String toes[] = request.getParameterValues("toe");

            String refs[] = request.getParameterValues("ref");
            String ranks[] = request.getParameterValues("rank");
            String mails[] = request.getParameterValues("refemail");
            String gsms[] = request.getParameterValues("refgsm");
            for (int i = 0; i < schools.length; i++) {

                Schoolattended acc = new Schoolattended();
                SchoolattendedPK acpk = new SchoolattendedPK();
                acpk.setPgId(appid);
                acc.setCollege(schools[i]);
                acc.setBegn(froms[i]);
                acc.setEnds(tos[i]);
                acc.setCert(certs[i]);
                acc.setPg(pgApplicant);
                acc.setSchoolattendedPK(acpk);
                try {

                    schoolattendedFacade.create(acc);
                } catch (Exception ex) {
                    System.out.println("Erro  " + ex);
                }

            }
            for (int i = 0; i < employments.length; i++) {
                Employment emp = new Employment();
                EmploymentPK epk = new EmploymentPK();
                epk.setPgId(appid);
                emp.setEmp(employments[i]);
                emp.setPosition(posts[i]);
                emp.setPg(pgApplicant);
                emp.setEmploymentPK(epk);
                employmentFacade.create(emp);

            }
            for (int i = 0; i < refs.length; i++) {
                Referee refree = new Referee();
                RefereePK rpk = new RefereePK();
                rpk.setPgId(appid);
                refree.setName(refs[i]);
                refree.setRank(ranks[i]);
                refree.setEmail(mails[i]);
                refree.setGsm(gsms[i]);
                refree.setRefereePK(rpk);
                refree.setPg(pgApplicant);
                refreeFacade.create(refree);
            }

            String pub = request.getParameter("pub");
            Publication publi = new Publication();
            PublicationPK ppk = new PublicationPK();
            ppk.setPgId(appid);

            publi.setPu(pub);
            publi.setPublicationPK(ppk);
            publi.setPg(pgApplicant);
            publicationFacade.create(publi);

            userPath = "/pg";
            session.setAttribute("pgdetails", pgApplicant.getAppref());
//            Pg pgdetails = pgApplicant;
//
//            request.setAttribute("pgdetails", pgdetails);

        } else if (userPath.equals("/addToCart")) {
//            if (cart == null) {
//
//                cart = new RegistrationCart();
//                session.setAttribute("cart", cart);
//            }
//
//            // get user input from request
//            String serviceName = request.getParameter("serviceName");
//            System.out.println("GA service ID" + serviceName);
//
//            if (!serviceName.isEmpty()) {
//
//                Payitem service = payitemFacade.findServiceName(serviceName);
//                System.out.println("GA   Banki" + service.getItemamount());
//                cart.addItem(service);
//                System.out.println("GA number of items " + cart.numberOfItems);
//            }
//
//            userPath = "/pay";

        }
        String url = "/WEB-INF/pay/" + userPath + ".jsp";

        try {

            request.getRequestDispatcher(url).forward(request, response);
        } catch (NullPointerException e) { ////

            System.out.print(e.getMessage() + "Very Disturbing");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
