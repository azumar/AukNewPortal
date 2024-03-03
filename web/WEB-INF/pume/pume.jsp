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

                        <h4 >  Welcome ${utmeDetails.name}, Please Upload your passport </h4>
                        <form   class="form-horizontal centeredForm" action="registerpume" method="post" enctype="multipart/form-data">

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
                                    <td>College Applied </td>
                                    <td><input type="text" name="name" value ="${utmeDetails.program.departmentDeptid.collegeId.collegeName}" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td>Department</td>
                                    <td><input type="text" name="name" value ="${utmeDetails.program.departmentDeptid.departmentName}" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td>Programme </td>
                                    <td><input type="text" name="name" value ="${utmeDetails.program.programName}" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td >Passport</td>
                                    <td><input type="file" name="result1" size="50"/></td>
                                </tr>
                                <tr>
                                    <td>Exam Time</td> <td>  <select name="schedule">
                                            <option >SELECT</option>
                                            <option value="Thursday, 5th Nov, 15, 10:00am" >Thursday, 5th Nov, 15, 10:00am</option>
                                              <option value="Thursday, 5th Nov, 15, 10:00am" >Thursday, 5th Nov, 15, 2:00pm</option>
                                             <option value="Friday, 6th Nov, 15, 10:00am" >Friday, 6th Nov, 15, 10:00am</option>
                                              <option value="Friday, 6th Nov, 15, 3:00pm" >Friday, 5th Nov, 15, 3:00pm</option>
                                        </select></td>

                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Submit">
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
