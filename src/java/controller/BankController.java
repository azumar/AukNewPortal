
package controller;

import entity.GroupandPinManager;
import entity.Groups;
import entity.Pin;
import entity.Users;
import helper.AccessCode;
import helper.HashedPasswordGenerator;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.GroupandPumePin;
import session.GroupsAndUsersManager;
import session.GroupsFacade;
import session.PinFacade;
import session.PumepinFacade;
import session.UsersFacade;

@WebServlet(name = "NewServlet", urlPatterns = {"/bank", "/sterling", "/sterlingAdmin", "/stbusers","/stbank","/accessCodeList", "/stcodes","/detailPin", "/bankAdmin", "/changePassword", "/addBankUser", "/bankUsers", "/deleteBankUsers","/addstbUser", "/pumeslip"})
public class BankController extends HttpServlet {

    @EJB
    private PinFacade pinFacade;
    @EJB
    GroupandPinManager groupAndPinManager;
    @EJB
    UsersFacade usersFacade;
    @EJB
    GroupsFacade groupsFacade;
    @EJB
    GroupsAndUsersManager groupAndUserManager;
    @EJB
    PumepinFacade pumepinFacade;
    @EJB
    GroupandPumePin groupandPumePin;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        String name = request.getUserPrincipal().getName();
        String userPath = request.getServletPath();
        if (userPath.equals("/bank")) {
            
                 request.setAttribute("name", name);
                   

        }
         if (userPath.equals("/sterling")) {
            
                // request.setAttribute("name", name);
                   

        } else if (userPath.equals("/accessCodeList")) {

            userPath = "/accessList";

            List<Pin> accessLists = pinFacade.finPinByCreator(name);
            request.setAttribute("accessLists", accessLists);

        } 
        else if (userPath.equals("/stcodes")) {

            userPath = "/stcodes";

            List<Pin> accessLists = pinFacade.finPinByCreator("ST"+name);
            request.setAttribute("accessLists", accessLists);

        }else if (userPath.equals("/detailPin")) {//pumeslip
            int pinNo = Integer.parseInt(request.getQueryString());

            if (pinNo > 0) {

                Pin selectedPin = pinFacade.finPinByPinId(pinNo);
                request.setAttribute("selectedPin", selectedPin);
            }

        }
        else if (userPath.equals("/pumeslip")) {
            int pinNo = Integer.parseInt(request.getQueryString());

            if (pinNo > 0) {

                Pin selectedPin = pinFacade.finPinByPinId(pinNo);
                request.setAttribute("selectedPin", selectedPin);
            }

        }else if (userPath.equals("/bankAdmin")) {
        request.setAttribute("name", name);
        } 
        else if (userPath.equals("/sterlingAdmin")) {
       // request.setAttribute("name", name);
        }
        
        else if (userPath.equals("/changePassword")) {

        }
        else if (userPath.equals("/bankUsers")) {
            
            List<Users> bankUsers = usersFacade.findUsersByType("bankUser");
              request.setAttribute("bankUsers", bankUsers);

        }
 else if (userPath.equals("/stbusers")) {
            
            List<Users> stbusers = usersFacade.findUsersByType("stbUser");
              request.setAttribute("stbusers", stbusers);

        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/bank" + userPath + ".jsp";

        try {

            request.getRequestDispatcher(url).forward(request, response);
        } catch (NullPointerException e) { ////

          
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        String name = request.getUserPrincipal().getName();
        if (userPath.equals("/bank")) {

            String surName = request.getParameter("surName");
            String otherName = request.getParameter("otherNames");
            AccessCode accessCode = new AccessCode();
            String pinNo = accessCode.getAccessCodes();
            int serial = accessCode.getCount()+1500;
            String userName = surName+serial;
            HashedPasswordGenerator hashGen = new HashedPasswordGenerator();
            String password = hashGen.generateHash(pinNo);
            String tellerNumber =request.getParameter("tellerNumber");

            try {
                
                groupAndPinManager.insertPinandGroup(surName, userName,otherName, pinNo, serial, password, tellerNumber ,request, "sourced");
                

            
            } catch (Exception ex) {

                System.out.println("HABA " + ex);
            }

        }
        else  if (userPath.equals("/stbank")) {

            String jambNo = request.getParameter("jambNo");
            String fullName = request.getParameter("fName");
            AccessCode accessCode = new AccessCode();
            String pinNo = accessCode.getAccessCodes();
            int serial = accessCode.getCount() +300;
            String userName = jambNo+serial;
            HashedPasswordGenerator hashGen = new HashedPasswordGenerator();
            String password = hashGen.generateHash(pinNo);
            String tellerNumber =request.getParameter("tellerNumber");

            try {
                
              //  groupAndPinManager.insertPinandGroup(surName, userName,otherName, pinNo, serial, password, tellerNumber ,request);
                
                groupandPumePin.insertPinandGroup(jambNo, fullName, pinNo,serial, password, tellerNumber, request, "pume");
                userPath ="/sterling";

            
            } catch (Exception ex) {

                System.out.println("HABA " + ex);
            }

        }
        else if (userPath.equals("/changePassword")) {
            String oldPassword = request.getParameter("oldPassword");
            Users user = usersFacade.findUserByUserName(name);
            String storedPassword = user.getPassword();
            HashedPasswordGenerator hPG = new HashedPasswordGenerator();
            String hOldPassword = hPG.generateHash(oldPassword);
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            boolean  success = false;
            boolean passwordMatch = false;
            boolean storedEqualSupplyPassword = false;
            if (hOldPassword.equals(storedPassword)) {

                if (newPassword.equals(confirmPassword)) {
                    String hNewPassword = hPG.generateHash(newPassword);
                    user.setPassword(hNewPassword);
                    usersFacade.edit(user);
                    request.setAttribute("user", user);
                }
                else{
                      request.setAttribute("passwordMatch", passwordMatch);
                }
                

            }
            else {
                request.setAttribute("storedEqualSupplyPassword", storedEqualSupplyPassword);
            }

        } else if (userPath.equals("/addBankUser")) {

            String names = request.getParameter("names");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String userType = request.getParameter("userType");
            System.out.println("USER TYPE "+userType);
            if (userType.contains("Admin"))
            {
               userType = "bankAdmin" ;
            }else
            {
                userType = "bankUser" ;
            }
            HashedPasswordGenerator hPG = new HashedPasswordGenerator();
            String hPassword = hPG.generateHash(password);
            String branch = request.getParameter("branch");
              String gsm = request.getParameter("gsm");
            groupAndUserManager.insertGroupAndUser(names, username, hPassword, userType, branch, gsm);
             List<Users> bankUsers = usersFacade.findUsersByType("bankUser");
              request.setAttribute("bankUsers", bankUsers);
            userPath = "/stbusers";

        } else if (userPath.equals("/addstbUser")) {

            String names = request.getParameter("names");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String userType = request.getParameter("userType");
           
            if (userType.contains("Admin"))
            {
               userType = "stbAdmin" ;
            }else
            {
                userType = "stbUser" ;
            }
            HashedPasswordGenerator hPG = new HashedPasswordGenerator();
            String hPassword = hPG.generateHash(password);
            String branch = request.getParameter("branch");
              String gsm = request.getParameter("gsm");
            groupAndUserManager.insertGroupAndUser(names, username, hPassword, userType, branch, gsm);
              List<Users> stbusers = usersFacade.findUsersByType("stbUser");
              request.setAttribute("stbusers", stbusers);
            userPath = "/stbusers";

        }
        else if (userPath.equals("/deleteBankUsers")) {
             if (request.getParameterMap().containsKey("username")) { //check if any jamb No is slected
                String[] usernames = request.getParameterValues("username");
                try {
                    for (String username : usernames) {
                    
                        Groups rGroup = groupsFacade.findGroupByUserName(username);
                        Users rUser = usersFacade.findUserByUserName(username);
                        System.out.println("GROUP"+rGroup.getUsername());
                        System.out.println("USER"+rUser.getName());
                        groupsFacade.remove(rGroup);
                        usersFacade.remove(rUser);
                         //groupAndUserManager.deleteGroupAndUser(rUser, rGroup);
                    }
                } catch (Exception ex) {

                }
               
            }
  List<Users> bankUsers = usersFacade.findUsersByType("bankUser");
              request.setAttribute("bankUsers", bankUsers);
            userPath = "/bankUsers";

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/bank" + userPath + ".jsp";

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
