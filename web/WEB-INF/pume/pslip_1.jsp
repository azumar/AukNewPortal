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
               
                window.print();

            }
        </script>
        <div class="container-fluid centeredForm" id="print-content">
            <!--            first Row-->
            <div  class="row" > 
                <section>
                    <div class="span2">
                        <img src="${pageContext.request.contextPath}/image/${candidate.utmePK.jambNo}.jpg" />
                        ${pageContext.request.contextPath}/image/${candidate.utmePK.jambNo}.jpg
<!--                         <img src="/C:/Users/Public/pume/55180038IG.jpg" alt="Logo" class="img-polaroid" />-->
                    </div>
                    <div class="span">
                        <h3>Al-Qalam University Katsina</h3>
                        <h4>2014/2015 Post UTME Registration </h4>
                        <h6>UTME Number:  ${candidate.utmePK.jambNo}</h6>
                    </div>
                     <div class="span2">
                        <img src="img/Logo.png" alt="Logo" class="img-polaroid" />
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
                <div class="span5">
                    <table class="table table-striped table-bordered table-condensed">
                        <tr>
                            <td>
                                Full Name
                            </td>
                            <td>
                              ${candidate.name}
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
                <div class="span5">
                    <table class="table table-striped table-bordered table-condensed">
                        <tr>
                            <td>
                             College
                            </td>
                            <td>
                                ${candidate.program.departmentDeptid.collegeId.collegeName} 
                            </td>
                        </tr>
                         <tr>
                            <td>
                              Department
                            </td>
                            <td>
                              ${candidate.program.departmentDeptid.departmentName} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Program Applied
                            </td>
                            <td>
                             ${candidate.program.programName} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Exam Schedulle 
                            </td>
                            <td>
                                    ${schedule} 
                            </td>
                        </tr>


                    </table>

                </div>
            </div>
                         <div class="row">
                <div class="span12">
                     <input class="btn" type="button" onclick="printDiv('print-content')" value="print Slip"/>
                    
                    
                    

                </div>
            </div>
  
        </div><!--        </div> end container -->
    </body>
</html>
