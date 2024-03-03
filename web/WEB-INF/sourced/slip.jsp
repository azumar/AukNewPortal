<%-- 
    Document   : bank
    Created on : Jul 12, 2015, 6:58:34 AM
    Author     : Armayau
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/rawStyle.css">
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" href="css/custom.css" />
        <title>Print Slip</title>
    </head>
    <body>

        <script type="text/javascript">

            function printDiv(divName) {
                //alert('s');
//                var printContents = document.getElementById(divName).innerHTML;
//                w = window.open();
//                w.document.write(printContents);
//                w.print();
//                w.close();
                window.print();

            }
        </script>
        <div class="container-fluid" id="print-content">
            <!--            first Row-->
            <div  class="row" > 
                <section>
                    <div class="span2 pull-left">
                        <img src="img/Logo.png" alt="Logo" class="img-polaroid" />
                    </div>
                    <div class="span8">
                        <h3>Al-Qalam University Katsina</h3>
                        <h5>School of Pre-Degree and Remedial Studies </h5>
                        
                    </div>
                   
                </section>

            </div> <!--                end row -->
            <!--            second row-->
            <div class="row">
                <hr/>
            </div>
            <!--            end second row-->

            <div class="row">

                <!--            left Section-->
                <div class="span6">
                    <table class="table table-striped table-bordered table-condensed">
                        <tr>
                            <td>
                                Full Name
                            </td>
                            <td>
                                ${candidate.firstName}   ${candidate.surName} ${candidate.otherName}
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Local Government
                            </td>
                            <td>
                                ${candidate.lga} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                State
                            </td>
                            <td>
                                ${candidate.state} 
                            </td>
                        <tr>
                            <td>
                                Gender
                            </td>
                            <td>
                                ${candidate.sex} 
                            </td>
                        </tr>
                        </tr>
                    </table>
                </div>
                <!--            right Section-->
                <div class="span6">
                    <table class="table table-striped table-bordered table-condensed">
                        <tr>
                            <td>
                                Address
                            </td>
                            <td>
                                ${candidate.address} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                GSM
                            </td>
                            <td>
                                ${candidate.gsm} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Program Applied
                            </td>
                            <td>
                                ${candidate.program.programName} 
                            </td>
                        <tr>
                            <td>
                                Date of Birth
                            </td>
                            <td>
                                <fmt:formatDate pattern="dd/mm/yyy"  value="${candidate.dob}"/>
                            </td>
                        </tr>


                    </table>

                </div>
            </div>
                         <div class="row">
                <div class="span12">
                     <input class="btn" type="button" onclick="printDiv('print-content')" value="print Slip"/>
                    <h6> Olevel Record </h6>
                    
                    <table class="table table-striped table-condensed table-bordered">
                        <thead>
                        <th>Subject</th>
                           <th>Grade</th>
                              <th>Exam Type</th>
                        </thead>
                        <c:forEach var="pc" items="${olevels}">
                            <tr>
                            <td>${pc.subject} </td>
                             <td>${pc.grade} </td>
                              <td>${pc.examination} </td>
                            <tr>
                        </c:forEach>
                        
                    </table>

                </div>
            </div>
   <input class="btn" type="button" onclick="printDiv('print-content')" value="print Slip"/>
        </div><!--        </div> end container -->
    </body>
</html>
