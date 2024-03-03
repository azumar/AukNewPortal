<%--
    This  is  form for creating new UTME record
--%>

<%@page import="helper.PaymentHashedGenerator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="css/rawStyle.css">
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" href="css/custom.css" />
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery.validate.js"></script>
        <title> Post UTME Application</title>
    </head>
    <body>
        <div class="row">
            <div class="span3" >
                <a href="http://www.auk.edu.ng"><img src="img/custom/Logo.png" alt="Logo" class="img-polaroid" /></a>
                <h5> Al-Qalam University, Katsina</h5>
            </div>
            <div class ="span8">
                <center>

                    <c:if test= "${empty studentDetails}">
                        <h4>  Enter your Jamb No below:</h4>
                        <form method="post" action="sdetail" >
                            <table border="0">
                                <tr>
                                    <td>Registration No </td>
                                    <td><input type="text" name="regNo" /></td>
                                </tr>

                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Find Detail">
                                    </td>
                                </tr>
                            </table>
                        </form>

                    </c:if>
                    <c:if test="${!empty studentDetails}">

                        <h4 >  Welcome ${studentDetails.firstname}  (${studentDetails.studentid}), Select all fees that apply to you  </h4>
                        <form action="https://portal.auk.edu.ng/alqalamfees/transactions/dopayment">
                            <input type="hidden" name="studentid" value="  ${studentDetails.studentid}" />
                             <input type="hidden" name="name" value=" ${studentDetails.firstname} ${studentDetails.firstname}" />
                               <input type="hidden" name="email" value=" ${studentDetails.email}" />
                                  <input type="hidden" name="mobile" value=" ${studentDetails.phone}" />
                            <table class="table table-striped table-bordered">
                                <c:forEach var="service" items="${services}">
                                    <tr>

                                    <input type="hidden" name="callback" value="https://portal.auk.edu.ng/alqalamfees/feeone/">
                                    <input type="hidden" name="payitemid" value="  ${service.bank.id}" />
                                    <td> <input type="checkbox"  name="amount" value ="${service.itemamount}"/></td>

                                    <td>
                                        ${service.itemname}
                                    </td>


                                    <td>
                                        ${service.itemamount}
                                    </td>
                                  
                                    </tr>
                                </c:forEach>
                                      <tr>
                                          <td></td>
                                          <td></td>
                                          <td><button type="submit" class="btn btn-default">Process Payment</button></td>
                        </tr>
                            </table>
  
                        </form>
                    </c:if>
                      
                </center>
            </div>
        </div>
    </body>
    <!--
    -->
</html>
