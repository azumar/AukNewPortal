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
         <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery.validate.js"></script>
        <title>Bank Access</title>
    </head>
    <body>
        <script type="text/javascript">
             
            $(document).ready(function() {
               
                $("#pinForm").validate({
                    rules: {
                        surName: "required",
                        tellerNumber: {
                            required: true
                        }

                    }
                });
            });
        </script>
        <section>
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <h5>Bank User  Interface</h5>
                         <h6> User:   ${"  "}     ${name} </h6>
                                <div class="btn" type="" name="" > <a href="stcodes">Show List</a></div>
                                 <div class="btn" type="" name="" > <a href="changePassword">Change Password</a></div>
                                 <div class="btn" type="" name="" > <a href="logout">Logout</a></div>
                                 

                        
                    </div>
                    
                    <div class="span9"><!-- Right Side where which holds form -->
    
                        <section>
                            <h4> Please only Add Record when you Credited Al-Qalam University Account</h4>
                       

                            <div class="row c-product-cta">



                            </div>

                            <div >
                                <form id="pinForm" class="form" action="stbank" method="post">

                                    <div class="control-group">
                                        <label class="control-label">JAMB NO..</label>
                                        <div class="controls"><input type="text" placeholder="Candidate JAMB NO"  name="jambNo"/></div>			
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">Full Name</label>
                                        <div class="controls"><input type="text" placeholder="Full Name" name="fName" /></div>			
                                    </div>
                                     <div class="control-group">
                                        <label class="control-label">Teller Number</label>
                                        <div class="controls"><input type="text" placeholder="Teller Number" name="tellerNumber" /></div>			
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <button type="submit" class="btn" >Create</button>
                                            <button type="reset" class="btn" >Clear</button>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </section>

                    </div> 

                </div>

                <hr />
            </div> <!-- end container -->
        </section>
    </body>
</html>

