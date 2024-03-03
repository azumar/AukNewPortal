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
            <div class="span4" >
                <a href="http://www.auk.edu.ng"><img src="img/custom/Logo.png" alt="Logo" class="img-polaroid" /></a>
                <h5> Al-Qalam University, Katsina</h5>
            </div>
            <div class ="span7"> 
                <center>

                    <c:if test= "${empty utmeDetails}">
                        <h4>  Enter your Jamb No below:</h4>
                        <form method="post" action="pumeDetails" >
                            <table border="0">
                                <tr>
                                    <td>Jamb No </td>
                                    <td><input type="text" name="jambNo" /></td>
                                </tr>

                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Find Detail">
                                    </td>
                                </tr>
                            </table>
                        </form>

                    </c:if>
                    <c:if test="${!empty utmeDetails}">
                        <%
                            PaymentHashedGenerator ha = new PaymentHashedGenerator();
                            

                        %>
                        <h4 >  Welcome ${utmeDetails.name}, Please Upload your passport </h4>
                        <form method="post"  action= "https://stageserv.interswitchng.com/test_paydirect/pay" >
                            <table border="0">
                                <tr>
                                    <td>Jamb No </td>
                                    <td><input type="text" name="jambNo" value ="${utmeDetails.utmePK.jambNo}" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td>Full Name </td>
                                    <td><input type="text" name="name" value ="${utmeDetails.name}" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td>Full Name </td>
                                    <td><input type="text" name="name" value ="${utmeDetails.program.departmentDeptid.collegeId.collegeName}" readonly="readonly"/></td>
                                </tr>
                                 <tr>
                                    <td>Full Name </td>
                                    <td><input type="text" name="name" value ="${utmeDetails.program.departmentDeptid.departmentName}" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td>Full Name </td>
                                    <td><input type="text" name="name" value ="${utmeDetails.program.programName}" readonly="readonly"/></td>
                                </tr>
                                <input name="product_id" type="hidden" value="6207" />   
                                 

                                <input name="cust_name" type="hidden" value="${utmeDetails.name}" />   
                                <input name="pay_item_id" type="hidden" value="101" /> 
                                <input name="amount" type="hidden" value="3000" />    
                                <input name="currency" type="hidden" value="566" />   
                                <input name="site_redirect_url" type="hidden" value="http:/localhost:8080/AukNewPortal/paid"/>  
                                <input name="txn_ref" type="hidden" value="123456789" /> 
                                <%

                                    String hash = ha.generateHash();

                                    System.out.println("GA HASH " + hash);

                                %>

                                <input name="hash" type="hidden" value= "<%=hash%>" />
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Pay with Card">
                                    </td>
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
