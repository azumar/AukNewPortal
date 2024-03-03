

package controller;

import entity.Pume;
import entity.PumePK;
import entity.Utme;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
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
import session.PumeFacade;
import session.UtmeFacade;

/**
 *
 * @author Armayau
 */
@WebServlet(name = "pumeController", urlPatterns = {"/pumeController","/album", "/pume","/pumeDetails", "/test", "/paid" ,"/checkpin","/registerpume", "/pslip"})
@MultipartConfig(maxFileSize = 16177215)
public class pumeController extends HttpServlet {
     private final String UPLOAD_DIRECTORY = "/C:/Users/Public/pume";//""   /C:/Users/Public/pume
@EJB
UtmeFacade utmeFacade;
@EJB
   PumeFacade pumeFacade;
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/album")) {
            String name = request.getUserPrincipal().getName();
          
        }
        else if (userPath.equals("/pume")) {
//            String name = request.getUserPrincipal().getName();
         
            //query and send all list

        }
        else if (userPath.equals("/pslip")) {
           

        }
        
         
         String url = "/WEB-INF/pume/" + userPath + ".jsp";

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
        if (userPath.equals("/pumeDetails")) {
            String name = request.getUserPrincipal().getName();
            String jambNo = request.getParameter("jambNo").trim().toUpperCase();
               Utme utmeDetails = utmeFacade.findByJambNo(jambNo);
               System.out.println(utmeDetails.getName());
                 request.setAttribute("utmeDetails", utmeDetails );
               
               userPath ="/pume";
          
        }
        else if (userPath.equals("/test")) {
            String hash = request.getParameter("hash");
            System.out.println("TEST HASH "+ hash);

        }
        else if (userPath.equals("/registerpume")) {
             String jambNo = request.getParameter("jambNo").trim();
                
             DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            InputStream ioStream = null;
             OutputStream out = null;
            Part exam1 = request.getPart("result1");
            if (exam1.getSize() <= 524288 && exam1.getSize() > 0) {
                ioStream = exam1.getInputStream();
                BufferedImage bImageFromConvert = ImageIO.read(ioStream);
                if (bImageFromConvert != null) {
                    ImageIO.write(bImageFromConvert, "jpg", new File("/C:/Users/Public/pume/" + jambNo + ".jpg")); //   /var/www/images/pume/ 
                } else {
                    out = new FileOutputStream(new File(File.separator
                            + UPLOAD_DIRECTORY + jambNo + ".pdf")); //
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
            
           
            String schedule = request.getParameter("schedule");
           
             Utme candidate = utmeFacade.findByJambNo(jambNo);
              Pume pume = new Pume();
             
              PumePK pk = new  PumePK();
              pk.setUtmeId(candidate.getUtmePK().getId());
              pk.setUtmejambNo(jambNo);
              pume.setPumePK(pk);
              pume.setSchedulle(schedule);
              pume.setUtme(candidate);
              pumeFacade.create(pume);
                request.setAttribute("schedule", schedule);
          request.setAttribute("candidate", candidate);
            userPath = "/pslip";

        }
        else if (userPath.equals("/checkpin")) {
            String pin = request.getParameter("pin");

        }
        
         else if (userPath.equals("/paid")) {
            String tn = request.getParameter("txnref");
            System.out.println("tnx    "+ tn);
              String payRef = request.getParameter("payRef");
            System.out.println("payRef      "+ payRef);
             String retRef= request.getParameter("retRef");
            System.out.println("retRef     "+ retRef);
              String cardNum= request.getParameter("cardNum");
            System.out.println("cardNum      "+ cardNum);
             String apprAmt= request.getParameter("apprAmt");
            System.out.println("apprAmt      "+ apprAmt);

        }
        String url = "/WEB-INF/pume/" + userPath + ".jsp";

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
