<%-- 
    Document   : bank
    Created on : Jul 12, 2015, 6:58:34 AM
    Author     : Armayau
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/rawStyle.css">
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" href="css/custom.css" />
        <title>Access Code List</title>
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <h3>BankInterface</h3>
 <div class="btn" type="" name="" > <a href="sterling">Add new</a></div>

                        
                    </div>
                    
                    <div class="span9"><!-- Right Side where which holds form -->

                        <section>
                            <h4> Al-Qalam University  Portal Access List</h4>

                            

                            <div >
                                <table class="table  table-striped table-condensed">
                                    <thead>
                                        <tr>
                                            <td>Serial No</td>
                                            <td>Access Code</td>
                                            <td>Jamb Number</td>
                                            <td>Full  Name</td>
<!--                                            <td>Date</td>-->
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var ="pin" items="${accessLists}">
                                            <tr>
                                                
                                                <td> <a href="pumeslip?${pin.pinPK.pinId}">${pin.pinPK.pinId}</a></td>
                                                <td>${pin.pinPK.accessCode}</td>
                                                <td>${pin.surname}</td>
                                                <td>${pin.otherNames}</td>
                                            </tr>
                                            
                                            
                                        </c:forEach>
                                        
                                    </tbody>
                                    
                                    
                                </table>
                             

                            </div>
                        </section>

                    </div> 

                </div> <!-- end row -->

                <hr />
            </div> <!-- end container -->
        </section>
    </body>
</html>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.js"></script>
<script>
    $(document).ready(function() {
        $('.carousel').carousel({
            interval: 5000
        });
    });
</script>