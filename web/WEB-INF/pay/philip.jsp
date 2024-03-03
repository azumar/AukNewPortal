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
                <form role="form" action="https://portal.auk.edu.ng/alqalamfees/transactions/dopayment" method="POST">
                    <div class="form-group">
                        <label for="name">Fullname</label> <input type="text" required="required"
                                                                  class="form-control" id="name" name="name" >
                    </div>
                    <div class="form-group">
                        <label for="email">Email </label>
                        <input type="email" required="required"
                               class="form-control" id="email" name="email" >
                    </div>
                    <div>
                        <input type="hidden" name="callback" value="https://portal.auk.edu.ng/alqalamfees/feeone/">
                        <input type="hidden" name="payitemid" value="101" />
                        <input type="hidden" name="feename" value="stanbic demo" />
                    </div>


                    <div class="form-group">
                        <label for="usermac">GSM </label>
                        <input required="required"
                               maxlength="20" type="text" class="form-control" id="mobile" name="mobile">
                    </div>

                    <div class="form-group">
                        <label for="studentid">Student ID </label> <input type="text" required="required"
                                                                          class="form-control" id="studentid" name="studentid">
                    </div>

                    <div class="form-group">
                        <label for="Amount">Amount</label> <input type="text" required="required"
                                                                  class="form-control" id="amount" name="amount">
                    </div>	

                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
    </body>
    <!--
    -->        
</html>
