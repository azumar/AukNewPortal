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
        <title>Change Password</title>
    </head>
    <body>
        <section>
            <div class="row-image">   <img src="img/Logo.png" width="100px" height="50px" f/>
                    
                </div>
        </section>
     
        <section>
              
            <div class="container">
              
                <div class="row">
                    <div class="span3">
                        <h3>Al-Qalam University Katsina</h3>
                        
                         <div class="btn" type="" name="" > <a href="logout">Logout</a></div>
                    </div>
                    
                    <div class="span9"><!-- Right Side where which holds form -->
                        <c:if test="${!empty storedEqualSupplyPassword}">
                   
                            <h4 class="error">  Wrong password!</h4>
                        </c:if>
                        <c:if test="${!empty passwordMatch}">
                            <h4 class="error">  Password Mismatch</h4>
                        </c:if>
                        <c:if test="${!empty user}">
                            <h4 class="alert-success">  Password Successfully  Change</h4>
                        </c:if>
                        <section>
                            <h4>Change Password</h4>
                            <div class="row c-product-cta">

                            </div>

                            <div >
                                <form class="form-horizontal" action="changePassword" method="post">
                                        <div class="control-group">
                            <label class="control-label">Old Password.</label>
                            <div class="controls"><input type="password" placeholder="Old Password" name="oldPassword" /></div>			
                        </div>
                                    <div class="control-group">
                            <label class="control-label">New Password</label>
                            <div class="controls"><input type="password" placeholder="New Password" name="newPassword" /></div>			
                        </div>

                        <div class="control-group">
                            <label class="control-label">Confirm New Password</label>
                            <div class="controls"><input type="password"  placeholder="New Password" name ="confirmPassword"/></div>			
                        </div>
                                                  
                            <div class="control-group">
                                <div class="controls">
                                    <button type="submit" class="btn" >Change </button>
                                    <button type="reset" class="btn" >Reset</button>
                                </div>
                            </div>
                        
                                                            
                                </form>
                            
                        </section>

                    </div> 

                </div>

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