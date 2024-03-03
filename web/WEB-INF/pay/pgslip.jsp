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
                window.location = "https://portal.auk.edu.ng/AukNewPortal/logout";
              //  window.navigate("https://portal.auk.edu.ng/AukNewPortal/logout");
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
                        <h5>School of Post-Graduate  Studies </h5>
                        
                        
                    </div>
                   
                </section>

            </div> <!--                end row -->
            <!--            second row-->
            <div class="row">
                <hr/>
            </div>
            <!--            end second row-->

            <div class="row">
  <input class="btn" type="button" onclick="printDiv('print-content')" value="print Slip"/>
                <!--            left Section-->
                <div class="span6">
                   
                    <table class="table table-striped table-bordered table-condensed">
                        <tr>
                            <td>
                                Full Name
                            </td>
                            <td>
                                ${evidence.name}   
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Local Government
                            </td>
                            <td>
                                ${evidence.lga} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                State
                            </td>
                            <td>
                                ${evidence.state} 
                            </td>
                        <tr>
                            <td>
                                Gender
                            </td>
                            <td>
                                ${candidate.gender} 
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
                                ${evidence.paddress} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Phone Number
                            </td>
                            <td>
                                ${evidence.gsm} 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Program Applied
                            </td>
                            <td>
                                ${evidence.program} 
                            </td>
                        <tr>
                            <td>
                                Date of Birth
                            </td>
                            <td>
                                <fmt:formatDate pattern="dd/mm/yyy"  value="${evidence.dob}"/>
                            </td>
                        </tr>


                    </table>

                </div>
            </div>
                         <div class="row">
                <div class="span12">
                    
                    
                </div>
            </div>
   <input class="btn" type="button" onclick="printDiv('print-content')" value="print Slip"/>
        </div><!--        </div> end container -->
    </body>
</html>
