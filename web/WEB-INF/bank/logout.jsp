<%-- 
    This  is  form for creating new UTME record
--%>

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
        <title>Sourced UTME Application</title>
    </head>
    <body>
        <div class="container"> <!-- start Container -->
            <!-- PAGE CONTENT -->
            <div class="row">
               
            </div>
            <section>
                <div class="row c-product-showcase">
                    <div class="span3"">
                        <a href="http://www.auk.edu.ng"><img src="img/Logo.png" alt="Logo" class="img-polaroid" /></a>
                        <h5> Al-Qalam University, Katsina</h5>
                    </div>
                    <div class="span6">
                        <form class="form" action="j_security_check" method=post>
 
        <table>
            <tr>
                <td>   <strong>User Id:</strong> </td>
                
                <td>   <input type="text" size="20" name="j_username"></td>
            </tr>
        <tr>
            <td><strong>password /Access Code:</strong> </td>
            <td> <input type="password" size="20" name="j_password"></td>       <tr>
        <tr>
            <td> </td>    <td><input type="submit" value="Log Back"> </td>
        </tr>
    </div>
</table>
</form>

                       

                        <hr />


                    </div>
                </div>


            </section>

        </div> <!-- end Container -->
        <!--
        -->            </body>
</html>
